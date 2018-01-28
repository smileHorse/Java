package mouse;

import javax.swing.*;
import java.awt.*;

public class MouseFrame extends JFrame {
    public MouseFrame() {
        add(new MouseComponent());
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MouseFrame frame = new MouseFrame();
            frame.setTitle("MouseFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
