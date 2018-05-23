package TableAndTree.TableSearcher;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

/**
 * This is a TableModel that encapsulates Lucene
 * search logic within a TableModel implementation.
 * It is implemented as a TableModel decorator,
 * similar to the TableSorter demo from Sun that decorates
 * a TableModel and provides sorting functionality. The benefit
 * of this architecture is that you can decorate any TableModel
 * implementation with this searching table model -- making it
 * easy to add searching functionaliy to existing JTables -- or
 * making new search capable table models.
 *
 * This decorator works by holding a reference to a decorated ot inner
 * TableModel. All data is stored within that table model, not this
 * table model. Rather, this table model simply manages links to
 * data in the inner table model according to the search. All methods on
 * TableSearcher forward to the inner table model with subtle filtering
 * or alteration according to the search criteria.
 *
 * Using the table model:
 *
 * Pass the TableModel you want to decorate in at the constructor. When
 * the TableModel initializes, it displays all search results. Call
 * the search methid with any vaid Lucene search String and the data
 * will be filtered by the search string. Users can always clear the search
 * at any time by searching with an empty string. Additionally, you can
 * add a button calling the clearSearch() method.
 *
 * @author Jonathan Simon - jonathan_s_simon@yahoo.com
 */
public class TableSearcher extends AbstractTableModel {
    /**
     * The inner table model we are decorating
     */
    protected TableModel tableModel;

    /**
     * This listener is used to register this class as a listener to
     * the decorated table model for update events
     */
    private TableModelListener tableModelListener;

    /**
     * these keeps reference to the decorated table model for data
     * only rows that match the search criteria are linked
     */
    private ArrayList rowToModelIndex = new ArrayList();

    //Lucene stuff.

    /**
     * In memory lucene index
     */
    private RAMDirectory directory;

    /**
     * Cached lucene analyzer
     */
    private Analyzer analyzer;

    /**
     * Links between this table model and the decorated table model
     * are maintained through links based on row number. This is a
     * key constant to denote "row number" for indexing
     */
    private static final String ROW_NUMBER = "ROW_NUMBER";

    /**
     * Cache the current search String. Also used internally to
     * key whether there is an active search running or not. i.e. if
     * searchString is null, there is no active search.
     */
    private String searchString = null;

    /**
     * @param tableModel The table model to decorate
     */
    public TableSearcher(TableModel tableModel) {
        analyzer = new StandardAnalyzer();
        tableModelListener = new TableModelHandler();
        setTableModel(tableModel);
        tableModel.addTableModelListener(tableModelListener);
        clearSearchingState();
    }

    /**
     *
     * @return The inner table model this table model is decorating
     */
    public TableModel getTableModel() {
        return tableModel;
    }

    /**
     * Set the table model used by this table model
     * @param tableModel The new table model to decorate
     */
    public void setTableModel(TableModel tableModel) {
        //remove listeners if there...
        if (this.tableModel != null) {
            this.tableModel.removeTableModelListener(tableModelListener);
        }

        this.tableModel = tableModel;
        if (this.tableModel != null) {
            this.tableModel.addTableModelListener(tableModelListener);
        }

        //recalculate the links between this table model and
        //the inner table model since the decorated model just changed
        reindex();

        // let all listeners know the table has changed
        fireTableStructureChanged();
    }

    /**
     * Reset the search results and links to the decorated (inner) table
     * model from this table model.
     */
    private void reindex() {
        try {
            // recreate the RAMDirectory
            directory = new RAMDirectory();
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
            iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
            IndexWriter writer = new IndexWriter(directory, iwc);

            // iterate through all rows
            for (int row = 0; row < tableModel.getRowCount(); ++row) {
                // for each row make a new document
                Document document = new Document();
                //add the row number of this row in the decorated table model
                //this will allow us to retrive the results later
                //and map this table model's row to a row in the decorated
                //table model
                document.add(new StringField(ROW_NUMBER, "" + row, Field.Store.YES));
                //iterate through all columns
                //index the value keyed by the column name
                //NOTE: there could be a problem with using column names with spaces
                for (int column = 0; column < tableModel.getColumnCount(); column++) {
                    String columnName = tableModel.getColumnName(column);
                    String columnValue = String.valueOf(tableModel.getValueAt(row, column)).toLowerCase();
                    document.add(new StringField(columnName, columnValue, Field.Store.YES));
                }
                writer.addDocument(document);
            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return The current lucene analyzer
     */
    public Analyzer getAnalyzer() {
        return analyzer;
    }

    /**
     * @param analyzer The new analyzer to use
     */
    public void setAnalyzer(Analyzer analyzer) {
        this.analyzer = analyzer;
        //reindex from the model with the new analyzer
        reindex();

        //rerun the search if there is an active search
        if (isSearching()) {
            search(searchString);
        }
    }

    /**
     * Run a new search.
     *
     * @param searchString Any valid lucene search string
     */
    public void search(String searchString) {
        // if searchStirng is null or empty, clear the search == search all
        if (searchString == null || searchString.isEmpty()) {
            clearSearchingState();
            fireTableDataChanged();
            return;
        }

        try {
            // cache search string
            this.searchString = searchString;

            // make a new index searcher with the in memory (RAM) index
            IndexReader reader = DirectoryReader.open(directory);
            IndexSearcher is = new IndexSearcher(reader);

            // make an array of fields - one for each column
            String[] fields = new String[tableModel.getColumnCount()];
            for (int t = 0; t < tableModel.getColumnCount(); t++) {
                fields[t] = tableModel.getColumnName(t);
            }

            //build a query based on the fields, searchString and cached analyzer
            //NOTE: This is an area for improvement since the MultiFieldQueryParser
            // has some weirdness.
            Query query = MultiFieldQueryParser.parse(searchString, fields, BooleanClause.Occur.values(), analyzer);
            // run the search
            ScoreDoc[] hits = is.search(query, 100).scoreDocs;
            // reset this table model with the new results
            resetSearchResults(is, hits);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // notify all listeners that the table has been changed
        fireTableStructureChanged();
    }

    /**
     *
     * @param hits The new result set to set this table to.
     */
    private void resetSearchResults(IndexSearcher is, ScoreDoc[] hits) {
        try {
            //clear our index mapping this table model rows to
            //the decorated inner table model
            rowToModelIndex.clear();

            //iterate through the hits
            //get the row number stored at the index
            //that number is the row number of the decorated
            //tabble model row that we are mapping to
            for (int t = 0; t < hits.length; t++) {
                Document document = is.doc(hits[t].doc);
                //Field field = document.getField(ROW_NUMBER);
                //rowToModelIndex.add(new Integer(field.stringValue()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getModelRow(int row) {
        return ((Integer)rowToModelIndex.get(row)).intValue();
    }

    /**
     * Clear the currently active search
     * Resets the complete dataset of the decorated
     * table model.
     */
    private void clearSearchingState() {
        searchString = null;
        rowToModelIndex.clear();
        for (int t = 0; t < tableModel.getRowCount(); t++) {
            rowToModelIndex.add(new Integer(t));
        }
    }

    // TableModel interface methods

    @Override
    public int getRowCount() {
        return (tableModel == null) ? 0 : tableModel.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return (tableModel == null) ? 0 : tableModel.getColumnCount();
    }

    @Override
    public String getColumnName(int column) {
        return tableModel.getColumnName(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tableModel.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return tableModel.isCellEditable(getModelRow(rowIndex), columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return tableModel.getValueAt(getModelRow(rowIndex), columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        tableModel.setValueAt(aValue, getModelRow(rowIndex), columnIndex);
    }

    private boolean isSearching() {
        return searchString != null;
    }

    private class TableModelHandler implements TableModelListener {
        @Override
        public void tableChanged(TableModelEvent e) {
            // If we're not searching, just pass the event along.
            if (!isSearching()) {
                clearSearchingState();
                reindex();
                fireTableChanged(e);
                return;
            }

            // Something has happened to the data that may have invalidated the search.
            reindex();
            search(searchString);
            fireTableDataChanged();
            return;
        }
    }
}