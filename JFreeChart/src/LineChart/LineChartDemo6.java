package LineChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
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

public class LineChartDemo6 extends ApplicationFrame {

    public LineChartDemo6(String s) {
        super(s);
        JPanel jPanel = createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jPanel);
    }

    private static XYDataset createDataset() {
        XYSeries xyseries = new XYSeries("First");
        xyseries.add(1.0D, 1.0D);
        xyseries.add(2D, 4D);
        xyseries.add(3D, 3D);
        xyseries.add(4D, 5D);
        xyseries.add(5D, 5D);
        xyseries.add(6D, 7D);
        xyseries.add(7D, 7D);
        xyseries.add(8D, 8D);

        XYSeries xyseries1 = new XYSeries("Second");
        xyseries1.add(1.0D, 5D);
        xyseries1.add(2D, 7D);
        xyseries1.add(3D, 6D);
        xyseries1.add(4D, 8D);
        xyseries1.add(5D, 4D);
        xyseries1.add(6D, 4D);
        xyseries1.add(7D, 2D);
        xyseries1.add(8D, 1.0D);

        XYSeries xyseries2 = new XYSeries("Third");
        xyseries2.add(3D, 4D);
        xyseries2.add(4D, 3D);
        xyseries2.add(5D, 2D);
        xyseries2.add(6D, 3D);
        xyseries2.add(7D, 6D);
        xyseries2.add(8D, 3D);
        xyseries2.add(9D, 4D);
        xyseries2.add(10D, 3D);

        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        xyseriescollection.addSeries(xyseries1);
        xyseriescollection.addSeries(xyseries2);
        return xyseriescollection;
    }

    private static JFreeChart createChart(XYDataset xyDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart("Line Chart Demo 6", "X",
                "Y", xyDataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot)jFreeChart.getPlot();

        XYLineAndShapeRenderer xyLineAndShapeRenderer = new XYLineAndShapeRenderer();
        xyLineAndShapeRenderer.setSeriesLinesVisible(0, false);
        xyLineAndShapeRenderer.setSeriesLinesVisible(1, false);
        xyLineAndShapeRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        xyPlot.setRenderer(xyLineAndShapeRenderer);

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
        LineChartDemo6 lineChartDemo = new LineChartDemo6("JFreeChart: LineChartDemo3.java");
        lineChartDemo.pack();
        RefineryUtilities.centerFrameOnScreen(lineChartDemo);
        lineChartDemo.setVisible(true);
    }
}
