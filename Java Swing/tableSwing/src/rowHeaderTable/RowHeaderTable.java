package rowHeaderTable;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class RowHeaderTable extends JFrame {

    public RowHeaderTable() {
        super("Row Header Test");
        setSize(300, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        TableModel tm = new AbstractTableModel() {
            String data[] = {"", "a", "b", "c", "d", "e"};
            String headers[] = {"Row #", "Column 1", "Column 2", "Column 3", "Column 4", "Column 5"};
            @Override
            public int getRowCount() {
                return 1000;
            }

            @Override
            public int getColumnCount() {
                return data.length;
            }

            @Override
            public String getColumnName(int column) {
                return headers[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return data[columnIndex] + rowIndex;
            }
        };

        // Create a column model for the main table. This model ignores the first
        // column added and sets a minimum width of 150px for all others
        TableColumnModel cm = new DefaultTableColumnModel() {
            boolean first = true;

            @Override
            public void addColumn(TableColumn aColumn) {
                // Drop the first column, which will be the row header
                if (first) {
                    first = false;
                    return;
                }
                aColumn.setMinWidth(150);
                super.addColumn(aColumn);
            }
        };

        // Create a column model that will serve as our row header table. This model
        // picks a maximum width and stores only the first column
        TableColumnModel rowHeaderModel = new DefaultTableColumnModel() {
            boolean first = true;

            @Override
            public void addColumn(TableColumn aColumn) {
                if (first) {
                    aColumn.setMaxWidth(aColumn.getPreferredWidth());
                    super.addColumn(aColumn);
                    first = false;
                }
                // Drop the rest of the columns, this is the header column only
            }
        };

        JTable jTable = new JTable(tm, cm);

        // Set up the header column and hook it up to everything
        JTable headerColumn = new JTable(tm, rowHeaderModel);
        jTable.createDefaultColumnsFromModel();
        headerColumn.createDefaultColumnsFromModel();

        // Make sure that selections between the main table and the header stay in sync
        // by sharing the same model
        jTable.setSelectionModel(headerColumn.getSelectionModel());

        // Make sure the header column look pretty
        //headerColumn.setBorder(BorderFactory.createEtchedBorder());
        headerColumn.setBackground(Color.lightGray);
        headerColumn.setColumnSelectionAllowed(false);
        headerColumn.setCellSelectionEnabled(false);

        // Put it in a viewport that we can control
        JViewport jViewport = new JViewport();
        jViewport.setView(headerColumn);
        jViewport.setPreferredSize(headerColumn.getMaximumSize());

        // Without shutting off atuoResizeMode, our tables won't scroll correctly
        // (horizontally, anyway)
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // We have to manually attach the row headers, but after that, the scroll
        // pane keep them in sync
        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setRowHeader(jViewport);
        scrollPane.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerColumn.getTableHeader());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        RowHeaderTable rowHeaderTable = new RowHeaderTable();
        rowHeaderTable.setVisible(true);
    }
}
