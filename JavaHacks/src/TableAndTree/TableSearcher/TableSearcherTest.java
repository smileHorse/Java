package TableAndTree.TableSearcher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableSearcherTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();

            JTable table = new JTable();
            MyTableModel myTableModel = new MyTableModel();
            TableSearcher tableSearcher = new TableSearcher(myTableModel);
            table.setModel(tableSearcher);
            JScrollPane scrollPane = new JScrollPane(table);
            frame.getContentPane().setLayout(new BorderLayout());
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

            JTextField textField = new JTextField();
            textField.setColumns(100);
            JButton searchButton = new JButton("查找");
            searchButton.addActionListener(event -> {
                tableSearcher.search(textField.getText().trim().toLowerCase());
            });
            JPanel panel = new JPanel();
            panel.add(textField);
            panel.add(searchButton);
            frame.getContentPane().add(panel, BorderLayout.SOUTH);

            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    public static class MyTableModel extends DefaultTableModel {

        public enum Column {
            ORDER("序号"), COLUMN1("列1"), COLUMN2("列2"), COLUMN3("列3");

            private String columnName = "";
            private Column(String columnName) {
                this.columnName = columnName;
            }

            public String getColumnName() {
                return columnName;
            }
        }
        @Override
        public int getColumnCount() {
            return Column.values().length;
        }

        @Override
        public int getRowCount() {
            return 10;
        }

        @Override
        public String getColumnName(int column) {
            return Column.values()[column].getColumnName();
        }

        @Override
        public Object getValueAt(int row, int column) {
            if (row >= 0 && row < getRowCount()) {
                if (column >= 0 && column < getColumnCount()) {
                    Column columnValue = Column.values()[column];
                    switch (columnValue) {
                        case ORDER:
                            return "" + (row + 1);
                        case COLUMN1:
                            return "行" + (row + 1) + "; 列1";
                        case COLUMN2:
                            return "行" + (row + 1) + "; 列2";
                        case COLUMN3:
                            return "行" + (row + 1) + "; 列3";
                        default:
                            break;
                    }
                }
            }
            return super.getValueAt(row, column);
        }
    }
}

