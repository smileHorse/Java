package guiFrame;

import javax.swing.*;
import java.awt.*;

public class TestFaConfigFrame {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Test");
            frame.setTitle("FaConfig");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
