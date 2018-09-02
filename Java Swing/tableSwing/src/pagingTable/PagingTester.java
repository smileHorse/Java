package pagingTable;

import javax.swing.*;
import java.awt.*;

public class PagingTester extends JFrame {

    public PagingTester() {
        super("Paged JTable Test");
        setSize(300, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PagingModel model = new PagingModel();
        JTable jTable = new JTable(model);

        JScrollPane scrollPane = PagingModel.createPagingScrollPaneForTable(jTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        PagingTester pagingTester = new PagingTester();
        pagingTester.setVisible(true);
    }
}
