package tableModel;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class InvestmentTable {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new InvestmentTableFrame();
                frame.setTitle("InvestmentTable");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class InvestmentTableFrame extends JFrame {
    public InvestmentTableFrame() {
        TableModel model = new InvestmentTableModel(30 ,5, 10);
        JTable table = new JTable(model);
        add(new JScrollPane(table));
        pack();
    }
}

class InvestmentTableModel extends AbstractTableModel {
    private static double INITIAL_BALANCE = 100000.0;

    private int years;
    private int minRate;
    private int maxRate;

    public InvestmentTableModel(int y, int r1, int r2) {
        years = y;
        minRate = r1;
        maxRate = r2;
    }

    @Override
    public int getRowCount() {
        return years;
    }

    @Override
    public int getColumnCount() {
        return maxRate - minRate + 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        double rate = (columnIndex + minRate) / 100.0;
        int nperiods = rowIndex;
        double futureBalance = INITIAL_BALANCE * Math.pow(1 + rate, nperiods);
        return String.format("%.2f", futureBalance);
    }

    @Override
    public String getColumnName(int column) {
        return (column + minRate) + "%";
    }
}
