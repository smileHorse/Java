package Text.SpecificFormatsTextInput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestRegexConstrainedDocument extends JPanel implements ActionListener {
    JTextField regexField, filterField;
    JButton regexButton;
    RegexConstrainedDocument regexDoc;

    public TestRegexConstrainedDocument() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // top - regex stuff
        JPanel topPanel = new JPanel();
        JLabel rLabel = new JLabel("regex: ");
        topPanel.add(rLabel);
        regexField = new JTextField(20);
        topPanel.add(regexField);
        regexButton = new JButton("Set");
        regexButton.addActionListener(this);
        topPanel.add(regexButton);
        add(topPanel);
        regexDoc = new RegexConstrainedDocument();
        filterField = new JTextField(regexDoc, "", 50);
        add(filterField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionperformed");
        if (e.getSource() == regexButton) {
            System.out.println("regexButton");
            regexDoc.setPatternByString(regexField.getText());
        }
    }

    public static void main(String[] args) {
        JComponent c = new TestRegexConstrainedDocument();
        JFrame f = new JFrame("Regex filtering");
        f.getContentPane().add(c);
        f.pack();
        f.setVisible(true);
    }
}
