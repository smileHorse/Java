package BarChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

public class BarChartDemo extends ApplicationFrame {
    /**
     * Creates a new demo interface
     */
    public BarChartDemo(String title) {
        super(title);

        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        // add the chart to a panel
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(500, 270));
        setContentPane(panel);
    }

    private CategoryDataset createDataset() {
        // row keys
        String series1 = "First";
        String series2 = "Second";
        String series3 = "Third";

        // column keys
        String category1 = "Category 1";
        String category2 = "Category 2";
        String category3 = "Category 3";
        String category4 = "Category 4";
        String category5 = "Category 5";

        // create the dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(1.0, series1, category1);
        dataset.setValue(4.0, series1, category2);
        dataset.setValue(3.0, series1, category3);
        dataset.setValue(5.0, series1, category4);
        dataset.setValue(5.0, series1, category5);

        dataset.setValue(5.0, series2, category1);
        dataset.setValue(7.0, series2, category2);
        dataset.setValue(6.0, series2, category3);
        dataset.setValue(8.0, series2, category4);
        dataset.setValue(4.0, series2, category5);

        dataset.setValue(4.0, series3, category1);
        dataset.setValue(3.0, series3, category2);
        dataset.setValue(2.3, series3, category3);
        dataset.setValue(3.4, series3, category4);
        dataset.setValue(6.5, series3, category5);

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        // create the chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Bar Chart Demo",       // title
                "Category", // categoryAxisLabel
                "Value",       // valueAxisLabel
                dataset,
                PlotOrientation.VERTICAL,
                true,                 // legend
                true,                // tooltips
                false                   // urls
        );

        // now do some optional customisation of the chart...

        // set the background color for the chart
        chart.setBackgroundPaint(new Color(0xBBBBDD));

        // get a reference to the plot for further customisation
        CategoryPlot plot = chart.getCategoryPlot();

        // set the range axis to display integers only
        NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines
        BarRenderer renderer = (BarRenderer)plot.getRenderer();
        renderer.setDrawBarOutline(false);

        // set up gradient paints for series
        GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.lightGray);
        GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, Color.lightGray);
        GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.lightGray);
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        // optional customisation completed

        return chart;
    }

    public static void main(String[] args) {
        BarChartDemo demo = new BarChartDemo("Bar Chart Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
