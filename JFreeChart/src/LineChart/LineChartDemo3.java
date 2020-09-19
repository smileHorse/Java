package LineChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;

public class LineChartDemo3 extends ApplicationFrame {

    public LineChartDemo3(String s) {
        super(s);
        JPanel jPanel = createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jPanel);
    }

    private static XYDataset createDataset() {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        for (int i = 0; i < 10; i++) {
            XYSeries xySeries = new XYSeries((new StringBuilder()).append("S").append(i).toString());
            for (int j = 0; j < 10; j++) {
                xySeries.add(j, Math.random() * 100.D);
            }

            xySeriesCollection.addSeries(xySeries);
        }
        return xySeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xyDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart("Line Chart Demo 3", "X",
                "Y", xyDataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot)jFreeChart.getPlot();
        xyPlot.setDomainPannable(true);
        xyPlot.setRangePannable(true);
        xyPlot.setDomainZeroBaselineVisible(true);
        xyPlot.setRangeZeroBaselineVisible(true);

        XYLineAndShapeRenderer xyLineAndShapeRenderer = (XYLineAndShapeRenderer)xyPlot.getRenderer();
        xyLineAndShapeRenderer.setBaseShapesVisible(true);
        xyLineAndShapeRenderer.setBaseShapesFilled(true);
        xyLineAndShapeRenderer.setDrawOutlines(true);

        NumberAxis numberAxis = (NumberAxis)xyPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] args) {
        LineChartDemo3 lineChartDemo = new LineChartDemo3("JFreeChart: LineChartDemo3.java");
        lineChartDemo.pack();
        RefineryUtilities.centerFrameOnScreen(lineChartDemo);
        lineChartDemo.setVisible(true);
    }
}
