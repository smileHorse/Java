package LineChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class LineChartDemo4 extends ApplicationFrame {

    public LineChartDemo4(String s) {
        super(s);
        JPanel jPanel = createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jPanel);
    }

    private static JFreeChart createChart(XYDataset xyDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart("Line Chart Demo 4", "X",
                "Y", xyDataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot)jFreeChart.getPlot();
        xyPlot.setDomainPannable(true);
        xyPlot.setRangePannable(true);
        xyPlot.setDomainZeroBaselineVisible(true);
        xyPlot.setRangeZeroBaselineVisible(true);
        xyPlot.getDomainAxis().setLowerMargin(0.0D);
        xyPlot.getDomainAxis().setUpperMargin(0.0D);

        XYLineAndShapeRenderer xyLineAndShapeRenderer = (XYLineAndShapeRenderer)xyPlot.getRenderer();
        xyLineAndShapeRenderer.setLegendLine(new Rectangle2D.Double(-4D, -3D, 8D, 6D));

        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = createChart(new SampleXYDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] args) {
        LineChartDemo4 lineChartDemo = new LineChartDemo4("JFreeChart: LineChartDemo3.java");
        lineChartDemo.pack();
        RefineryUtilities.centerFrameOnScreen(lineChartDemo);
        lineChartDemo.setVisible(true);
    }
}
