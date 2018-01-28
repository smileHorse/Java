package table;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class TableTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PlanetTableFrame frame = new PlanetTableFrame();
            frame.setTitle("tableTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class PlanetTableFrame extends JFrame {
    private String[] columnNames = { "Planet", "Radius", "Moons", "Gaseous", "Color" };
    private Object[][] cells = {
            { "Mercury", 2440.0, 0, false, Color.YELLOW },
            { "Venus", 2440.0, 0, false, Color.YELLOW },
            { "Earth", 2440.0, 0, false, Color.BLUE },
            { "Mars", 2440.0, 0, false, Color.RED },
            { "Jupiter", 2440.0, 0, true, Color.ORANGE },
            { "Saturn", 2440.0, 0, true, Color.ORANGE },
            { "Uranus", 2440.0, 0, true, Color.BLUE },
            { "Neptune", 2440.0, 0, true, Color.BLUE },
            { "Pluto", 2440.0, 0, false, Color.BLACK }
    };

    public PlanetTableFrame() {
        final JTable table = new JTable(cells, columnNames);
        table.setAutoCreateRowSorter(true);
        add(new JScrollPane(table), BorderLayout.CENTER);
        JButton printButton = new JButton("Print");
        printButton.addActionListener(EventHandler.create(ActionListener.class, table, "print"));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(printButton);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}
