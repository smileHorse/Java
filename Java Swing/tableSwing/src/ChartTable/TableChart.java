package ChartTable;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

public class TableChart extends JComponent implements TableModelListener {

    protected TableModel model;
    protected ChartPainter chartPainter;
    protected double[] percentages; // Pie slices
    protected String[] labels;  // Labels for slices
    protected String[] tips;    // Tooltips for slices

    protected NumberFormat formatter = NumberFormat.getPercentInstance();

    public TableChart(TableModel tm) {
        setUI(chartPainter = new PieChartPainter());
        setModel(tm);
    }

    public void setTextFont(Font f) {
        chartPainter.setTextFont(f);
    }

    public Font getTextFont() {
        return chartPainter.getTextFont();
    }

    public void setTextColor(Color color) {
        chartPainter.setTextColor(color);
    }

    public Color getTextColor() {
        return chartPainter.getTextColor();
    }

    public void setColor(Color[] clist) {
        chartPainter.setColors(clist);
    }

    public Color[] getColor() {
        return chartPainter.getColors();
    }

    public void setColor(int index, Color color) {
        chartPainter.setColor(index, color);
    }

    public Color getColor(int index) {
        return chartPainter.getColor(index);
    }

    @Override
    public String getToolTipText(MouseEvent event) {
        if (tips != null) {
            int whichTip = chartPainter.indexOfEntryAt(event);
            if (whichTip != -1) {
                return tips[whichTip];
            }
        }
        return null;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        updateLocalValues(e.getType() != TableModelEvent.UPDATE);
    }

    public void setModel(TableModel tm) {
        if (tm != model) {
            if (model != null) {
                model.removeTableModelListener(this);
            }
            model = tm;
            model.addTableModelListener(this);
            updateLocalValues(true);
        }
    }

    public TableModel getModel() {
        return model;
    }

    // Run through the model and count every cell(except the first column,
    // which we accume is the slice label column)
    protected void calculatePercentages() {
        double runningTotal = 0.0;
        for (int i = model.getRowCount() -  1; i >= 0; i--) {
            percentages[i] = 0.0;
            for (int j = model.getColumnCount() - 1; j >= 0; j--) {
                // First, try the cell as a Number object
                Object val = model.getValueAt(i, j);
                if (val instanceof Number) {
                    percentages[i] += ((Number)val).doubleValue();
                } else if (val instanceof String) {
                    // Oops, it wasn't number, so try it as a string
                    try {
                        percentages[i] += Double.valueOf(val.toString()).doubleValue();
                    } catch (Exception e) {
                    }
                }
            }
            runningTotal += percentages[i];
        }

        // Make each entry a percentage of the total
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            percentages[i] /= runningTotal;
        }
    }

    // This method just takes the percentages and formats them as tooltips
    protected void createLabelsAndTips() {
        for (int i = model.getRowCount() -  1; i >= 0; i--) {
            labels[i] = (String)model.getValueAt(i, 0);
            tips[i] = formatter.format(percentages[i]);
        }
    }

    // Call this method to update the chart, We try to be more efficient here by
    // allocating new storage arrays only if the new table has a different number of
    // rows
    protected void updateLocalValues(boolean freshStart) {
        if (freshStart) {
            int count = model.getRowCount();
            if ((tips == null) || (count != tips.length)) {
                percentages = new double[count];
                labels = new String[count];
                tips = new String[count];
            }
        }
        calculatePercentages();
        createLabelsAndTips();

        // Now that everything's up-to-date, reset the chart painter with the new values
        chartPainter.setValues(percentages);
        chartPainter.setLabels(labels);

        repaint();
    }
}
