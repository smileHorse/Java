package tableLayout;

import tableLayout.esotericsoftware.tablelayout.swing.Table;

import javax.swing.*;
import java.awt.*;

public class TableLayoutTest extends JDialog {

    private JPanel mainPanel = null;

    public TableLayoutTest() {
        setTitle("TableLayoutTest");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);

        initGui();
    }

    private void initGui() {
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout());

        // init center component
        initComponent();
    }

    private void initComponent() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        Table centerTable = new Table();
        centerTable.debug();
        centerTable.pad(10);
        centerPanel.add(centerTable, BorderLayout.CENTER);

        JLabel label11 = new JLabel("label11");
        JTextField field11 = new JTextField();

        JLabel label21 = new JLabel("label21");
        JTextField field21 = new JTextField();

        centerTable.addCell(label11);
        centerTable.addCell(field11).width(100).spaceBottom(10);
        centerTable.row();
        centerTable.addCell(label21).colspan(2);
        //centerTable.addCell(field21).width(100).colspan(2);

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TableLayoutTest tableLayoutTest = new TableLayoutTest();
        });
    }
}
