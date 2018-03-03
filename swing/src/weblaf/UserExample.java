package weblaf;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.progressbar.WebProgressBar;

import javax.swing.*;

public class UserExample {
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            //WebLookAndFeel.install();

            JPanel panel = new JPanel();
            panel.add(new JLabel("Test"));
            panel.add(new JButton("Test"));
            WebProgressBar progressBar = new WebProgressBar();
            progressBar.setIndeterminate(true);
            progressBar.setStringPainted(true);
            progressBar.setString("请稍等...");
            panel.add(progressBar);

            JFrame frame = new JFrame();
            frame.setContentPane(panel);
            frame.setTitle("WebLaf Example");
            frame.setSize(400, 300);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
