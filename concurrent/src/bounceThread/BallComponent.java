package bounceThread;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by masf on 2018/1/28.
 * The component that draws the balls
 * @author Masf
 * @version 1.0
 */
public class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    private java.util.List<Ball> balls = new ArrayList<>();

    /**
     * Add a ball to the component
     * @param b the ball to add
     */
    public void add(Ball b) {
        balls.add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
