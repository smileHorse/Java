package view;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ViewDB {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ViewDBFrame();
            frame.setTitle("ViewDB");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ViewDBFrame extends JFrame {
    private JButton previousButton;
    private JButton nextButton;
    private JButton deleteButton;
    private JButton saveButton;
    private DataPanel dataPanel;
    private Component scrollPanel;
    private JComboBox<String> tableNames;
    private Properties props;
    private CachedRowSet crs;

    public ViewDBFrame() {
        tableNames = new JComboBox<>();
        tableNames.addActionListener(event -> {
            showTable((String)tableNames.getSelectedItem());
        });
        add(tableNames, BorderLayout.NORTH);

        try {
            readDatabaseProperties();
            try (Connection conn = getConnection()) {
                DatabaseMetaData meta = conn.getMetaData();
                ResultSet mrs = meta.getTables(null, null, null,
                        new String[] { "TABLE"});
                while (mrs.next()) {
                    tableNames.addItem(mrs.getString(3));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e);
        }

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        previousButton = new JButton("Previous");
        previousButton.addActionListener(event -> {
            showPreviousRow();
        });
        buttonPanel.add(previousButton);
        nextButton = new JButton("Next");
        nextButton.addActionListener(event -> {
            showNextRow();
        });
        buttonPanel.add(nextButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(event -> {
            deleteRow();
        });
        buttonPanel.add(deleteButton);
        saveButton = new JButton("Save");
        saveButton.addActionListener(event -> {
            saveChanges();
        });
        buttonPanel.add(saveButton);
        pack();
    }

    public void showTable(String tableName) {
        try {
            try (Connection conn = getConnection()) {
                // get result set
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery("SELECT * FROM " + tableName);
                // copy into cached row set
                RowSetFactory factory = RowSetProvider.newFactory();
                crs = factory.createCachedRowSet();
                crs.setTableName(tableName);
                crs.populate(result);
            }

            if (scrollPanel != null) remove(scrollPanel);
            dataPanel = new DataPanel(crs);
            scrollPanel = new JScrollPane(dataPanel);
            add(scrollPanel, BorderLayout.CENTER);
            validate();
            showNextRow();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void showPreviousRow() {
        try {
            if (crs == null || crs.isFirst()) return;
            crs.previous();
            dataPanel.showRow(crs);
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public void showNextRow() {
        try {
            if (crs == null || crs.isLast()) return;
            crs.next();
            dataPanel.showRow(crs);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void deleteRow() {
        try {
            try (Connection conn = getConnection()) {
                crs.deleteRow();
                crs.acceptChanges(conn);
                if (crs.isAfterLast()) {
                    if (!crs.last()) {
                        crs = null;
                    }
                }
                dataPanel.showRow(crs);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void saveChanges() {
        try {
            try (Connection conn = getConnection()) {
                dataPanel.setRow(crs);
                crs.acceptChanges(conn);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void readDatabaseProperties() throws IOException {
        props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
            props.load(in);
        }
    }

    private Connection getConnection() throws SQLException {
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url, username, password);
    }
}

class DataPanel extends JPanel {
    private List<JTextField> fields;

    public DataPanel(RowSet rs) throws SQLException {
        fields = new ArrayList<>();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            gbc.gridy = i - 1;
            String columnName = rsmd.getColumnLabel(i);
            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.EAST;
            add(new JLabel(columnName), gbc);

            int columnWidth = rsmd.getColumnDisplaySize(i);
            JTextField tb = new JTextField(columnWidth);
            if (!rsmd.getColumnClassName(i).equals("java.lang.String")) {
                tb.setEditable(false);
            }

            fields.add(tb);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(tb, gbc);
        }
    }

    public void showRow(ResultSet rs) throws SQLException {
        for (int i = 1; i <= fields.size(); i++) {
            String field = rs == null ? "" : rs.getString(i);
            JTextField tb = fields.get(i - 1);
            tb.setText(field);
        }
    }

    public void setRow(RowSet rs) throws SQLException {
        for (int i = 1; i <= fields.size(); i++) {
            String field = rs.getString(i);
            JTextField tb = fields.get(i - 1);
            if (!field.equals(tb.getText())) {
                rs.updateString(i, tb.getText());
            }
        }
        rs.updateRow();
    }
 }