package LineChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

import javax.swing.*;
import java.awt.*;

public class LineChartDemo8 extends ApplicationFrame {

    public LineChartDemo8(String s) {
        super(s);
        JPanel jPanel = createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(0.0D, "Series 1", "Category 1");
        defaultcategorydataset.addValue(2D, "Series 1", "Category 2");
        defaultcategorydataset.addValue(1.0D, "Series 1", "Category 3");
        defaultcategorydataset.addValue(3D, "Series 1", "Category 4");
        defaultcategorydataset.addValue(5D, "Series 1", "Category 5");
        defaultcategorydataset.addValue(2D, "Series 2", "Category 1");
        defaultcategorydataset.addValue(4D, "Series 2", "Category 2");
        defaultcategorydataset.addValue(4D, "Series 2", "Category 3");
        defaultcategorydataset.addValue(5D, "Series 2", "Category 4");
        defaultcategorydataset.addValue(2D, "Series 2", "Category 5");
        defaultcategorydataset.addValue(1.0D, "Series 3", "Category 1");
        defaultcategorydataset.addValue(3D, "Series 3", "Category 2");
        defaultcategorydataset.addValue(5D, "Series 3", "Category 3");
        defaultcategorydataset.addValue(2D, "Series 3", "Category 4");
        defaultcategorydataset.addValue(0.0D, "Series 3", "Category 5");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createLineChart("Line Chart Demo 8", "Category",
                "Count", categoryDataset, PlotOrientation.VERTICAL,
                true, true, false);

        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        SymbolAxis symbolAxis = new SymbolAxis("Group", new String[] {
                "A", "B", "C", "D", "E", "F"
        });
        categoryPlot.setRangeAxis(symbolAxis);
        ChartUtilities.applyCurrentTheme(jFreeChart);

        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)categoryPlot.getRenderer();
        lineAndShapeRenderer.setSeriesShapesVisible(0, true);
        lineAndShapeRenderer.setSeriesShapesVisible(1, false);
        lineAndShapeRenderer.setSeriesShapesVisible(2, true);
        lineAndShapeRenderer.setSeriesLinesVisible(2, false);
        lineAndShapeRenderer.setSeriesShape(2, ShapeUtilities.createDiamond(4F));
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
        LineChartDemo8 lineChartDemo = new LineChartDemo8("JFreeChart: LineChartDemo8.java");
        lineChartDemo.pack();
        RefineryUtilities.centerFrameOnScreen(lineChartDemo);
        lineChartDemo.setVisible(true);
    }
}
