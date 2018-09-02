package ChartTable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChartTester extends JFrame {

    public ChartTester() {
        super("Simple Table Test");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        TableModel tm = new AbstractTableModel() {
            String data[][] = {
                    {"Ron", "0.00", "68.68", "77.34", "78.02"},
                    {"Ravi", "0.00", "70.89", "64.17", "75.00"},
                    {"Maria", "76.52", "71.12", "75.68", "74.14"},
                    {"James", "70.00", "15.72", "26.40", "38.32"},
                    {"Ellen", "80.32", "78.16", "83.80", "85.72"}
            };
            String headers[] = {"", "Q1", "Q2", "Q3", "Q4"};

            @Override
            public int getRowCount() {
                return data.length;
            }

            @Override
            public int getColumnCount() {
                return headers.length;
            }

            @Override
            public String getColumnName(int column) {
                return headers[column];
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex == 0) ? Number.class : String.class;
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return true;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return data[rowIndex][columnIndex];
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                data[rowIndex][columnIndex] = (String)aValue;
                fireTableRowsUpdated(rowIndex, rowIndex);
            }
        };

        JTable jt = new JTable(tm);
        JScrollPane jsp = new JScrollPane(jt);
        getContentPane().add(jsp, BorderLayout.CENTER);

        final TableChartPopup tcp = new TableChartPopup(tm);
        JButton button = new JButton("Show me a chart of this table");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tcp.setVisible(true);
            }
        });
        getContentPane().add(button, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        ChartTester ct = new ChartTester();
        ct.setVisible(true);
    }
}
