package LineChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.net.URL;

public class LineChartDemo02 extends ApplicationFrame {

    public LineChartDemo02(String s) {
        super(s);
        JPanel jPanel = createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jPanel);
    }

    private static XYDataset createDataset() {
        XYSeries xySeries = new XYSeries("First");
        xySeries.add(1.0D, 1.0D);
        xySeries.add(2D, 4D);
        xySeries.add(3D, 3D);
        xySeries.add(4D, 5D);
        xySeries.add(5D, 5D);
        xySeries.add(6D, 7D);
        xySeries.add(7D, 7D);
        xySeries.add(8D, 8D);

        XYSeries xySeries1 = new XYSeries("Second");
        xySeries1.add(1.0D, 5D);
        xySeries1.add(2D, 7D);
        xySeries1.add(3D, 6D);
        xySeries1.add(4D, 8D);
        xySeries1.add(5D, 4D);
        xySeries1.add(6D, 4D);
        xySeries1.add(7D, 2D);
        xySeries1.add(8D, 1.0D);

        XYSeries xySeries2 = new XYSeries("Third");
        xySeries2.add(3D, 4D);
        xySeries2.add(4D, 3D);
        xySeries2.add(5D, 2D);
        xySeries2.add(6D, 3D);
        xySeries2.add(7D, 6D);
        xySeries2.add(8D, 3D);
        xySeries2.add(9D, 4D);
        xySeries2.add(10D, 3D);

        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        xySeriesCollection.addSeries(xySeries);
        xySeriesCollection.addSeries(xySeries1);
        xySeriesCollection.addSeries(xySeries2);
        return xySeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xyDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart("Line Chart Demo 2", "X",
                "Y", xyDataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot)jFreeChart.getPlot();
        xyPlot.setDomainPannable(true);
        xyPlot.setRangePannable(true);

        XYLineAndShapeRenderer xyLineAndShapeRenderer = (XYLineAndShapeRenderer)xyPlot.getRenderer();
        xyLineAndShapeRenderer.setBaseShapesVisible(true);
        xyLineAndShapeRenderer.setBaseShapesFilled(true);

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
        LineChartDemo02 lineChartDemo02 = new LineChartDemo02("JFreeChart: LineChartDemo02.java");
        lineChartDemo02.pack();
        RefineryUtilities.centerFrameOnScreen(lineChartDemo02);
        lineChartDemo02.setVisible(true);
    }
}
