package longList;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class LongListFrame extends JFrame {
    private JList<String> wordlist;
    private JLabel label;
    private String prefix = "The quick brown ";
    private String suffix = " jumps over the lazy dog.";

    public LongListFrame() {
        wordlist = new JList<String>(new WordListModel(3));
        wordlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        wordlist.setPrototypeCellValue("www");
        JScrollPane scrollPane = new JScrollPane(wordlist);

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        wordlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                setSubject(wordlist.getSelectedValue());
            }
        });

        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.NORTH);
        label = new JLabel(prefix + suffix);
        contentPane.add(label, BorderLayout.CENTER);
        setSubject("fox");
        pack();
    }

    public void setSubject(String word) {
        StringBuilder text = new StringBuilder(prefix);
        text.append(word);
        text.append(suffix);
        label.setText(text.toString());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            LongListFrame frame = new LongListFrame();
            frame.setTitle("长列表");
            frame.setVisible(true);
        });
    }
}
