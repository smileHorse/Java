package LineChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.net.URL;

public class LineChartDemo01 extends ApplicationFrame {

    public LineChartDemo01(String s) {
        super(s);
        JPanel jPanel = createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(212D, "Classes", "JDK1.0");
        defaultCategoryDataset.addValue(504D, "Classes", "JDK 1.1");
        defaultCategoryDataset.addValue(1520D, "Classes", "JDK 1.2");
        defaultCategoryDataset.addValue(1842D, "Classes", "JDK 1.3");
        defaultCategoryDataset.addValue(2991D, "Classes", "JDK 1.4");
        defaultCategoryDataset.addValue(3500D, "Classes", "JDK 1.5");
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createLineChart("Jave Standard Class Library", null,
                "Class Count", categoryDataset, PlotOrientation.VERTICAL,
                false, true, false);
        jFreeChart.addSubtitle(new TextTitle("Number of Classes By Release"));
        TextTitle textTitle = new TextTitle("Source: Java In A Nutshell (5th Edition) by David Flanagan (O'Reilly)");
        textTitle.setFont(new Font("SansSerif", 0, 10));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        textTitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jFreeChart.addSubtitle(textTitle);

        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangePannable(true);
        categoryPlot.setRangeGridlinesVisible(false);

        URL url = LineChartDemo01.class.getClassLoader().getResource("OnBridge11small.png");
        if (url != null) {
            ImageIcon imageIcon = new ImageIcon(url);
            jFreeChart.setBackgroundImage(imageIcon.getImage());
            categoryPlot.setBackgroundPaint(null);
        }

        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ChartUtilities.applyCurrentTheme(jFreeChart);

        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)categoryPlot.getRenderer();
        lineAndShapeRenderer.setBaseShapesVisible(true);
        lineAndShapeRenderer.setDrawOutlines(true);
        lineAndShapeRenderer.setUseFillPaint(true);
        lineAndShapeRenderer.setBaseFillPaint(Color.white);
        lineAndShapeRenderer.setSeriesStroke(0, new BasicStroke(3F));
        lineAndShapeRenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
        lineAndShapeRenderer.setSeriesShape(0, new Ellipse2D.Double(-5D, -5D, 10D, 10D));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] args) {
        LineChartDemo01 lineChartDemo01 = new LineChartDemo01("JFreeChart: LineChartDemo01.java");
        lineChartDemo01.pack();
        RefineryUtilities.centerFrameOnScreen(lineChartDemo01);
        lineChartDemo01.setVisible(true);
    }
}
