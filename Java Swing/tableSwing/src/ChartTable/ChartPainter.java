package ChartTable;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class ChartPainter extends ComponentUI {

    protected Font textFont = new Font("Serif", Font.PLAIN, 12);
    protected Color textColor = Color.black;
    protected Color colors[] = new Color[] {
            Color.red, Color.blue, Color.yellow, Color.black, Color.green,
            Color.white, Color.gray, Color.cyan, Color.magenta, Color.darkGray
    };
    protected double values[] = new double[0];
    protected String labels[] = new String[0];

    public Font getTextFont() {
        return textFont;
    }

    public void setTextFont(Font textFont) {
        this.textFont = textFont;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public Color[] getColors() {
        return colors;
    }

    public void setColors(Color[] colors) {
        this.colors = colors;
    }

    public Color getColor(int index) {
        return colors[index];
    }

    public void setColor(int index, Color color) {
        colors[index] = color;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public abstract int indexOfEntryAt(MouseEvent mouseEvent);
    public abstract void paint(Graphics g, JComponent c);
}
