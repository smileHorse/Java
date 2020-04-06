package LineChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class LineChartDemo7 extends ApplicationFrame {

    public LineChartDemo7(String s) {
        super(s);
        JPanel jPanel = createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(21D, "Series 1", "Category 1");
        defaultcategorydataset.addValue(50D, "Series 1", "Category 2");
        defaultcategorydataset.addValue(152D, "Series 1", "Category 3");
        defaultcategorydataset.addValue(184D, "Series 1", "Category 4");
        defaultcategorydataset.addValue(299D, "Series 1", "Category 5");
        defaultcategorydataset.addValue(275D, "Series 2", "Category 1");
        defaultcategorydataset.addValue(121D, "Series 2", "Category 2");
        defaultcategorydataset.addValue(98D, "Series 2", "Category 3");
        defaultcategorydataset.addValue(103D, "Series 2", "Category 4");
        defaultcategorydataset.addValue(210D, "Series 2", "Category 5");
        defaultcategorydataset.addValue(198D, "Series 3", "Category 1");
        defaultcategorydataset.addValue(165D, "Series 3", "Category 2");
        defaultcategorydataset.addValue(55D, "Series 3", "Category 3");
        defaultcategorydataset.addValue(34D, "Series 3", "Category 4");
        defaultcategorydataset.addValue(77D, "Series 3", "Category 5");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createLineChart("Line Chart Demo7", "Category",
                "Count", categoryDataset, PlotOrientation.VERTICAL,
                true, true, false);

        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();

        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)categoryPlot.getRenderer();
        lineAndShapeRenderer.setSeriesShapesVisible(0, true);
        lineAndShapeRenderer.setSeriesShapesVisible(1, false);
        lineAndShapeRenderer.setSeriesShapesVisible(2, true);
        lineAndShapeRenderer.setSeriesLinesVisible(2, false);
        lineAndShapeRenderer.setSeriesShape(2, ShapeUtilities.createDiamond(4));
        lineAndShapeRenderer.setDrawOutlines(true);
        lineAndShapeRenderer.setUseFillPaint(true);
        lineAndShapeRenderer.setBaseFillPaint(Color.white);

        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] args) {
        LineChartDemo7 lineChartDemo = new LineChartDemo7("JFreeChart: LineChartDemo7.java");
        lineChartDemo.pack();
        RefineryUtilities.centerFrameOnScreen(lineChartDemo);
        lineChartDemo.setVisible(true);
    }
}
