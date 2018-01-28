package list;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;

    private JPanel listPanel;
    private JList<String> wordlist;
    private JLabel label;
    private JPanel buttonPanel;
    private ButtonGroup group;
    private String prefix = "The ";
    private String suffix = "for jumps over the lazy dog.";

    public ListFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        String[] words = { "quick", "brown", "hungry", "wild", "silent", "huge", "private", "abstract", "static", "final"};

        wordlist = new JList<>(words);
        wordlist.setVisibleRowCount(4);
        JScrollPane scrollPane = new JScrollPane(wordlist);

        listPanel = new JPanel();
        listPanel.add(scrollPane);
        wordlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                StringBuilder text = new StringBuilder(prefix);
                for (String value : wordlist.getSelectedValuesList()) {
                    text.append(value);
                    text.append(" ");
                }
                text.append(suffix);
                label.setText(text.toString());
            }
        });

        buttonPanel = new JPanel();
        group = new ButtonGroup();
        makeButton("Vertial", JList.VERTICAL);
        makeButton("Vertial Wrap", JList.VERTICAL_WRAP);
        makeButton("Horizontal Wrap", JList.HORIZONTAL_WRAP);

        add(listPanel, BorderLayout.NORTH);
        label = new JLabel(prefix + suffix);
        add(label, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void makeButton(String label, final int orientation) {
        JRadioButton button = new JRadioButton(label);
        buttonPanel.add(button);
        if (group.getButtonCount() == 0)    button.setSelected(true);
        group.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordlist.setLayoutOrientation(orientation);
                listPanel.revalidate();
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ListFrame frame = new ListFrame();
            frame.setTitle("列表");
            frame.setVisible(true);
        });
    }
}
