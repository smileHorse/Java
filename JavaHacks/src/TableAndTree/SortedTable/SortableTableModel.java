package TableAndTree.SortedTable;

import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortableTableModel implements TableModel, TableModelListener {

    EventListenerList listenerList = new EventListenerList();
    TableModel delegatedModel;
    int[] sortedIndicies;
    int sortColumn;
    Comparator comparator;
    Comparator[] comparators;

    public SortableTableModel(TableModel tm) {
        delegatedModel = tm;
        delegatedModel.addTableModelListener(this);
        comparators = new Comparator[delegatedModel.getColumnCount()];
        sortedIndicies = new int[0];
        setSortColumn(0);
    }

    // listen stuff

    @Override
    public void addTableModelListener(TableModelListener l) {
        listenerList.add(TableModelListener.class, l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listenerList.remove(TableModelListener.class, l);
    }

    public void fireTableModelEvent(TableModelEvent e) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == TableModelListener.class) {
                ((TableModelListener)listeners[i + 1]).tableChanged(e);
            }
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        switch (e.getType()) {
            case TableModelEvent.DELETE: {
                resort();
                fireAllChanged();
                break;
            }
            case TableModelEvent.INSERT: {
                resort();
                fireAllChanged();
                break;
            }
            case TableModelEvent.UPDATE: {
                resort();
                fireAllChanged();
                break;
            }
        }
    }

    // contents stuff

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (delegatedModel.getRowCount() > 0) {
            return delegatedModel.getValueAt(0, columnIndex).getClass();
        } else {
            return Object.class;
        }
    }

    @Override
    public int getColumnCount() {
        return delegatedModel.getColumnCount();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return delegatedModel.getColumnName(columnIndex);
    }

    @Override
    public int getRowCount() {
        return delegatedModel.getRowCount();
    }

    private int getDelegatedRow(int row) {
        return sortedIndicies[row];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return delegatedModel.getValueAt(getDelegatedRow(rowIndex), columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return delegatedModel.isCellEditable(rowIndex, columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        delegatedModel.setValueAt(aValue, rowIndex, columnIndex);
    }

    // internal helpers
    public void setComparatorForColumn(Comparator c, int i) {
        // range check
        if (i > comparators.length) {
            Comparator[] newComparators = new Comparator[i + 1];
            System.arraycopy(comparators, 0, newComparators, 0, comparators.length);
            comparators = newComparators;
        }
        // add the comparator
        comparators[i] = c;
    }

    public void setSortColumn(int i) {
        sortColumn = i;

        // reset current comparator, possibly to null, which
        // will make us use 'natural ordering' for those values
        comparator = null;
        if ((comparators != null) && (comparators.length > 0)) {
            comparator = comparators[sortColumn];
        }

        // now do the sort
        resort();
    }

    public int getSortColumn() {
        return sortColumn;
    }

    // called to rebuild the delegate-to-sortable mapping
    protected void resort() {
        // dose sortIndicies need to grow or shrink?
        if (sortedIndicies.length != delegatedModel.getRowCount()) {
            sortedIndicies = new int[delegatedModel.getRowCount()];
        }

        // build up a list of SortingDelegates
        ArrayList sortMe = new ArrayList();
        for (int i = 0; i < delegatedModel.getRowCount(); i++) {
            SortingDelegate sd = new SortingDelegate(delegatedModel.getValueAt(i, getSortColumn()), i);
            sortMe.add(sd);
        }

        // now sort him with the SortingDelegateComparator
        SortingDelegateComparator sdc = new SortingDelegateComparator(comparator);
        Collections.sort(sortMe, sdc);

        // fill sortedIndicies array
        // index -> value represents mapping from original
        // row to sorted row
        for (int i = 0; i < sortMe.size(); i++) {
            sortedIndicies[i] = ((SortingDelegate)sortMe.get(i)).row;
        }

        // fire change event
        fireAllChanged();
    }

    public class SortingDelegate extends Object {
        public Object value;
        public int row;
        public SortingDelegate(Object v, int r) {
            this.value = v;
            this.row = r;
        }
    }

    // "pointer object" int 1 is current value and int 2 is current row in table

    // compartor which applies current comparator's compare rule to value 2 in
    class SortingDelegateComparator extends Object implements Comparator {
        Comparator comp;
        public SortingDelegateComparator(Comparator c) {
            comp = c;
        }

        @Override
        public int compare(Object o1, Object o2) {
            Object v1 = ((SortingDelegate)o1).value;
            Object v2 = ((SortingDelegate)o2).value;
            if (comp != null) {
                return comp.compare(v1, v2);
            } else if (v1 instanceof Comparable) {
                return ((Comparable)v1).compareTo(v2);
            } else {
                throw new IllegalArgumentException("Can't compare objects " + "for sorting");
            }
        }
    }

    protected void fireAllChanged() {
        TableModelEvent e = new TableModelEvent(this);
        fireTableModelEvent(e);
    }
}
