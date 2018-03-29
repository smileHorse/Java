package loan;

import Util.FunUtil;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class LoanTableModel extends AbstractTableModel {

    enum LoanTableColumn {
        NO("期次"), DATE("日期"), LOANBALANCE("贷款余额"),
        PAYAMOUNT("还款额"), PAYAMOUNTCOUNT("还款总额"),
        PAYPRINCIPAL("应还本金"), PAYPRINCIPALCOUNT("本金总额"),
        PAYINTEREST("应还利息"), PAYINTERESTCOUNT("利息总额");

        private String columnName = "";
        LoanTableColumn(String columnName) {
            this.columnName = columnName;
        }

        public String getColumnName() {
            return columnName;
        }
    }

    private List<LoanTableData> loanTableDataList = null;

    public LoanTableModel() {
        super();
        loanTableDataList = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return loanTableDataList.size();
    }

    @Override
    public int getColumnCount() {
        return LoanTableColumn.values().length;
    }

    @Override
    public String getColumnName(int column) {
        if (column >= 0 && column < LoanTableColumn.values().length) {
            return LoanTableColumn.values()[column].getColumnName();
        } else {
            return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && rowIndex < getRowCount()) {
            LoanTableData tableData = loanTableDataList.get(rowIndex);
            LoanTableColumn column = LoanTableColumn.values()[columnIndex];
            switch (column) {
                case NO:
                    return String.valueOf(rowIndex + 1);
                case DATE:
                    return tableData.getPayDate();
                case LOANBALANCE:
                    return FunUtil.format(tableData.getLoanBalance());
                case PAYAMOUNT:
                    return FunUtil.format(tableData.getPayAmount());
                case PAYAMOUNTCOUNT:
                    return FunUtil.format(getPayAmountCount(rowIndex));
                case PAYPRINCIPAL:
                    return FunUtil.format(tableData.getPayPrincipal());
                case PAYPRINCIPALCOUNT:
                    return FunUtil.format(getPayPrincipalCount(rowIndex));
                case PAYINTEREST:
                    return FunUtil.format(tableData.getPayInterest());
                case PAYINTERESTCOUNT:
                    return FunUtil.format(getPayInterestCount(rowIndex));
                default:
                    break;
            }
            return null;
        } else {
            return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    public void setData(List<LoanTableData> tableDataList) {
        tableDataList.clear();
        this.loanTableDataList = tableDataList;
        fireTableDataChanged();
    }

    public void addData(LoanTableData tableData) {
        loanTableDataList.add(tableData);
        fireTableDataChanged();
    }

    public void clear() {
        loanTableDataList.clear();
        fireTableDataChanged();
    }

    private double getPayAmountCount(int index) {
        double value = 0.0;
        if (index >= 0 && index < getRowCount()) {
            for (int i = 0; i <= index; ++i) {
                value += loanTableDataList.get(i).getPayAmount();
            }
        }
        return value;
    }

    private double getPayPrincipalCount(int index) {
        double value = 0.0;
        if (index >= 0 && index < getRowCount()) {
            for (int i = 0; i <= index; ++i) {
                value += loanTableDataList.get(i).getPayPrincipal();
            }
        }
        return value;
    }

    private double getPayInterestCount(int index) {
        double value = 0.0;
        if (index >= 0 && index < getRowCount()) {
            for (int i = 0; i <= index; ++i) {
                value += loanTableDataList.get(i).getPayInterest();
            }
        }
        return value;
    }
}
