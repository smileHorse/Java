package LineChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.net.URL;

public class LineChartDemo5 extends ApplicationFrame {

    public LineChartDemo5(String s) {
        super(s);
        JPanel jPanel = createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jPanel);
    }

    private static CategoryDataset createDataset() {
        String s = "First";
        String s1 = "Second";
        String s2 = "Third";
        String s3 = "Type 1";
        String s4 = "Type 2";
        String s5 = "Type 3";
        String s6 = "Type 4";
        String s7 = "Type 5";
        String s8 = "Type 6";
        String s9 = "Type 7";
        String s10 = "Type 8";
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0D, s, s3);
        defaultCategoryDataset.addValue(4D, s, s4);
        defaultCategoryDataset.addValue(3D, s, s5);
        defaultCategoryDataset.addValue(5D, s, s6);
        defaultCategoryDataset.addValue(5D, s, s7);
        defaultCategoryDataset.addValue(7D, s, s8);
        defaultCategoryDataset.addValue(7D, s, s9);
        defaultCategoryDataset.addValue(8D, s, s10);
        defaultCategoryDataset.addValue(5D, s1, s3);
        defaultCategoryDataset.addValue(7D, s1, s4);
        defaultCategoryDataset.addValue(6D, s1, s5);
        defaultCategoryDataset.addValue(8D, s1, s6);
        defaultCategoryDataset.addValue(4D, s1, s7);
        defaultCategoryDataset.addValue(4D, s1, s8);
        defaultCategoryDataset.addValue(2D, s1, s9);
        defaultCategoryDataset.addValue(1.0D, s1, s10);
        defaultCategoryDataset.addValue(4D, s2, s3);
        defaultCategoryDataset.addValue(3D, s2, s4);
        defaultCategoryDataset.addValue(2D, s2, s5);
        defaultCategoryDataset.addValue(3D, s2, s6);
        defaultCategoryDataset.addValue(6D, s2, s7);
        defaultCategoryDataset.addValue(3D, s2, s8);
        defaultCategoryDataset.addValue(4D, s2, s9);
        defaultCategoryDataset.addValue(3D, s2, s10);
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createLineChart("Line Chart Demo5", "Type",
                "Value", categoryDataset, PlotOrientation.VERTICAL,
                true, true, false);

        Shape ashape[] = new Shape[3];
        int ai[] = { -3, 3, -3 };
        int ai1[] = { -3, 0, 3};
        ashape[0] = new Polygon(ai, ai1, 3);
        ashape[1] = new Rectangle2D.Double(-2D, -3D, 3D, 6D);
        ai = (new int[]{ -3, 3, 3 });
        ai1 = (new int[] { 0, -3, 3 });
        ashape[2] = new Polygon(ai, ai1, 3);

        DefaultDrawingSupplier defaultDrawingSupplier = new DefaultDrawingSupplier(
                DefaultDrawingSupplier.DEFAULT_PAINT_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
                ashape);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setOrientation(PlotOrientation.HORIZONTAL);
        categoryPlot.setDrawingSupplier(defaultDrawingSupplier);
        categoryPlot.getRenderer().setSeriesStroke(0, new BasicStroke(2.0F, 1, 1, 1.0F,
                new float[]{10F, 6F}, 0.0F));
        categoryPlot.getRenderer().setSeriesStroke(1, new BasicStroke(2.0F, 1, 1, 1.0F,
                new float[]{6F, 6F}, 0.0F));
        categoryPlot.getRenderer().setSeriesStroke(2, new BasicStroke(2.0F, 1, 1, 1.0F,
                new float[]{2.0F, 6F}, 0.0F));

        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)categoryPlot.getRenderer();
        lineAndShapeRenderer.setBaseShapesVisible(true);
        lineAndShapeRenderer.setBaseItemLabelsVisible(true);
        lineAndShapeRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());

        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setAutoRangeIncludesZero(false);
        numberAxis.setUpperMargin(0.12D);

        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] args) {
        LineChartDemo5 lineChartDemo = new LineChartDemo5("JFreeChart: LineChartDemo5.java");
        lineChartDemo.pack();
        RefineryUtilities.centerFrameOnScreen(lineChartDemo);
        lineChartDemo.setVisible(true);
    }
}
