package FileTable;

import javax.swing.*;
import java.awt.*;

public class FileTable extends JFrame {

    public FileTable() {
        super("Custom TableModel Test");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FileModel fileModel = new FileModel();
        JTable jTable = new JTable(fileModel);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.setColumnSelectionAllowed(true);

        JScrollPane scrollPane = new JScrollPane(jTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        FileTable fileTable = new FileTable();
        fileTable.setVisible(true);
    }
}
