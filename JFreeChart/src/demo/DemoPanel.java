package demo;

import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DemoPanel extends JPanel {

    List<JFreeChart> charts;

    public DemoPanel(LayoutManager layoutManager) {
        super(layoutManager);
        charts = new ArrayList();
    }

    public void addChart(JFreeChart jFreeChart) {
        charts.add(jFreeChart);
    }

    public JFreeChart[] getCharts() {
        int i = charts.size();
        JFreeChart aFreeChart[] = new JFreeChart[i];
        for (int j = 0; j < i; j++) {
            aFreeChart[j] = (JFreeChart)charts.get(j);
        }
        return aFreeChart;
    }

    public List<JFreeChart> getChartList() {
        return charts;
    }
}
