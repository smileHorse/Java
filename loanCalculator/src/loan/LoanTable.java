package loan;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.List;

public class LoanTable extends JTable {
    private static final int DEFAULT_ROW_HEIGHT = 30;
    private LoanTableModel tableModel = null;

    public LoanTable() {
        tableModel = new LoanTableModel();
        setModel(tableModel);

        setRowHeight(DEFAULT_ROW_HEIGHT);
    }

    public void setData(List<LoanTableData> tableDataList) {
        tableModel.setData(tableDataList);
    }

    public void addData(LoanTableData tableData) {
        tableModel.addData(tableData);
    }

    public void clearTable() {
        tableModel.clear();
    }
}
