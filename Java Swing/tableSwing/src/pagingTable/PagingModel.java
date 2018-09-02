package pagingTable;

import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagingModel extends AbstractTableModel {

    protected int pageSize;
    protected int pageOffset;
    protected Record[] data;

    public PagingModel() {
        this(10000, 100);
    }

    public PagingModel(int numRows, int size) {
        data = new Record[numRows];
        pageSize = size;

        // Fill our table with random data
        for (int i = 0; i < data.length; i++) {
            data[i] = new Record();
        }
    }

    @Override
    public int getRowCount() {
        return Math.min(pageSize, data.length);
    }

    @Override
    public int getColumnCount() {
        return Record.getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int realRow = rowIndex + (pageOffset * pageSize);
        return data[realRow].getValueAt(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return Record.getColumnName(column);
    }

    // Use this method to figure out which page you are on
    public int getPageOffset() {
        return pageOffset;
    }

    public int getPageCount() {
        return (int)Math.ceil((double)data.length / pageSize);
    }

    // Use this method if you want to know how big the real table is. you could also
    // write "getRealValueAt()" if needed
    public int getRealRowCount() {
        return data.length;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (this.pageSize == pageSize) {
            return;
        }
        int oldPageSize = this.pageSize;
        this.pageSize = pageSize;
        pageOffset = (oldPageSize * pageOffset) / pageSize;
        fireTableDataChanged();
    }

    // Update the page offset and fire a data change event (all rows)
    public void  pageDown() {
        if (pageOffset < getPageCount() - 1) {
            pageOffset++;
            fireTableDataChanged();
        }
    }

    // Update the page offset and fire a data change event(all rows)
    public void pageUp() {
        if (pageOffset > 0) {
            pageOffset--;
            fireTableDataChanged();
        }
    }

    // We provide our own version of a scrollpane that includes
    // the page up and page down buttons by default
    public static JScrollPane createPagingScrollPaneForTable(JTable jTable) {
        JScrollPane scrollPane = new JScrollPane(jTable);
        TableModel tableModel = jTable.getModel();

        // Don't choke if this is called on a regular table
        if (!(tableModel instanceof PagingModel)) {
            return scrollPane;
        }

        // Go ahead and build the real scrollpane
        final PagingModel model = (PagingModel)tableModel;
        final JButton upButton = new JButton("Up");
        upButton.setEnabled(false);
        final JButton downButton = new JButton("Down");
        if (model.getPageCount() <= 1) {
            downButton.setEnabled(false);
        }

        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.pageUp();

                // If we hit the top of the data, disable the page up button
                if (model.getPageOffset() == 0) {
                    upButton.setEnabled(false);
                }
                downButton.setEnabled(true);
            }
        });

        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.pageDown();;

                // If we hit the bottom of the data, disable the page down button
                if (model.getPageOffset() == (model.getPageCount() - 1)) {
                    downButton.setEnabled(false);
                }
                upButton.setEnabled(true);
            }
        });

        // turn on the scrollbars, otherwise, we won't get our corners
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Added in the corners(page up/down)
        scrollPane.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER, upButton);
        scrollPane.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, downButton);

        return scrollPane;
    }
}
