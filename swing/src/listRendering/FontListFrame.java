package listRendering;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class FontListFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;

    private JLabel label;
    private JList<Font> fontJList;
    private Font[] fonts = { new Font("Serif", 1, 10), new Font("SansSerif", 1, 20)};
    private JList<String> textList;
    private String[] words = { "Serif", "Sans Serif" };

    public FontListFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        label = new JLabel("The quick brown fix jumps over the lazy dog.");
        add(label, BorderLayout.CENTER);

        fontJList = new JList<>(fonts);
        fontJList.setCellRenderer(new FontCellRenderer());

        textList = new JList<>(words);

        JScrollPane scrollPane = new JScrollPane(fontJList);

        add(scrollPane, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            FontListFrame frame = new FontListFrame();
            frame.setTitle("字体列表");
            frame.setVisible(true);
        });
    }
}
