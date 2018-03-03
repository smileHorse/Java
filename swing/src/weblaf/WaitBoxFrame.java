package weblaf;

import javax.swing.*;
import java.awt.*;

public class WaitBoxFrame extends JFrame {
    private WaitBox waitBox = new WaitBox(this);

    private JButton showButton = null;
    private JButton hideButton = null;

    public WaitBoxFrame()
    {
        initGui();
    }

    private void initGui()
    {
        showButton = new JButton("显示");
        showButton.addActionListener(event -> {
            waitBox.show("显示", "正在加载...");
        });

        hideButton = new JButton("隐藏");
        hideButton.addActionListener(event -> {
            waitBox.dispose();
        });

        JPanel panel = new JPanel();
        panel.add(showButton);
        panel.add(hideButton);
        setContentPane(panel);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            WaitBoxFrame frame = new WaitBoxFrame();
            frame.setTitle("WaitBoxFrame");
            frame.setSize(400, 300);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
