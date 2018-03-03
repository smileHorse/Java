package weblaf;

import javax.swing.*;
import java.awt.*;

public class WaitBox extends JDialog {
    private static final int DEFAULT_WIDTH = 350;
    private static final int DEFAULT_HEIGHT = 70;
    private JProgressBar progressBar = null;

    public WaitBox(JFrame owner)
    {
        super(owner);
        this.setLocationRelativeTo(owner);

        progressBar = new JProgressBar();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(progressBar, BorderLayout.CENTER);
        this.setContentPane(panel);
    }

    public void show(String title, String msg)
    {
        progressBar.setIndeterminate(true);
        progressBar.setStringPainted(true);
        progressBar.setString(msg);
        this.setTitle(title);
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            WaitBox waitBox = new WaitBox(null);
            waitBox.show("加载数据", "正在加载...");
        });
    }
}
