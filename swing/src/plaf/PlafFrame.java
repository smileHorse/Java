package plaf;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.*;

public class PlafFrame extends JFrame {
    private JPanel buttonPanel;

    public PlafFrame() {
        buttonPanel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(), info.getClassName());
        }

        add(buttonPanel);
        pack();
    }

    private void makeButton(String name, String className) {
        JButton button = new JButton(name);
        buttonPanel.add(button);

        button.addActionListener(event -> {
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PlafFrame frame = new PlafFrame();
            frame.setTitle("PlatFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
