package LineChart;

import demo.DemoPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;

public class XYSplineRendererDemo1 extends ApplicationFrame {

    static class MyDemoPanel extends DemoPanel {
        private XYDataset data1;

        private XYDataset createSampleData() {
            XYSeries xySeries = new XYSeries("Series 1");
            xySeries.add(2D, 56.270000000000003D);
            xySeries.add(3D, 41.32D);
            xySeries.add(4D, 31.449999999999999D);
            xySeries.add(5D, 30.050000000000001D);
            xySeries.add(6D, 24.690000000000001D);
            xySeries.add(7D, 19.780000000000001D);
            xySeries.add(8D, 20.940000000000001D);
            xySeries.add(9D, 16.73D);
            xySeries.add(10D, 14.210000000000001D);
            xySeries.add(11D, 12.44D);

            XYSeriesCollection xySeriesCollection = new XYSeriesCollection(xySeries);

            XYSeries xySeries1 = new XYSeries("Series 2");
            xySeries1.add(11D, 56.270000000000003D);
            xySeries1.add(10D, 41.32D);
            xySeries1.add(9D, 31.449999999999999D);
            xySeries1.add(8D, 30.050000000000001D);
            xySeries1.add(7D, 24.690000000000001D);
            xySeries1.add(6D, 19.780000000000001D);
            xySeries1.add(5D, 20.940000000000001D);
            xySeries1.add(4D, 16.73D);
            xySeries1.add(3D, 14.210000000000001D);
            xySeries1.add(2D, 12.44D);
            xySeriesCollection.addSeries(xySeries1);

            return xySeriesCollection;
        }

        private JTabbedPane createContent() {
            JTabbedPane jTabbedPane = new JTabbedPane();
            jTabbedPane.add("Splines:", createChartPanel1());
            jTabbedPane.add("Lines:", createChartPanel2());
            return jTabbedPane;
        }

        private ChartPanel createChartPanel1() {
            NumberAxis numberAxis = new NumberAxis("X");
            numberAxis.setAutoRangeIncludesZero(false);
            NumberAxis numberAxis1 = new NumberAxis("Y");
            numberAxis1.setAutoRangeIncludesZero(false);

            XYSplineRenderer xySplineRenderer = new XYSplineRenderer();
            XYPlot xyPlot = new XYPlot(data1, numberAxis, numberAxis1, xySplineRenderer);
            xyPlot.setBackgroundPaint(Color.lightGray);
            xyPlot.setDomainGridlinePaint(Color.white);
            xyPlot.setRangeGridlinePaint(Color.white);
            xyPlot.setAxisOffset(new RectangleInsets(4D, 4D, 4D, 4D));

            JFreeChart jFreeChart = new JFreeChart("XYSplineRenderer", JFreeChart.DEFAULT_TITLE_FONT,
                    xyPlot, true);
            addChart(jFreeChart);
            ChartUtilities.applyCurrentTheme(jFreeChart);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            return chartPanel;
        }

        private ChartPanel createChartPanel2() {
            NumberAxis numberAxis = new NumberAxis("X");
            numberAxis.setAutoRangeIncludesZero(false);
            NumberAxis numberAxis1 = new NumberAxis("Y");
            numberAxis1.setAutoRangeIncludesZero(false);

            XYLineAndShapeRenderer xyLineAndShapeRenderer = new XYLineAndShapeRenderer();
            XYPlot xyPlot = new XYPlot(data1, numberAxis, numberAxis1, xyLineAndShapeRenderer);
            xyPlot.setBackgroundPaint(Color.lightGray);
            xyPlot.setDomainGridlinePaint(Color.white);
            xyPlot.setRangeGridlinePaint(Color.white);
            xyPlot.setAxisOffset(new RectangleInsets(4D, 4D, 4D, 4D));

            JFreeChart jFreeChart = new JFreeChart("XYLineAndShapeRenderer", JFreeChart.DEFAULT_TITLE_FONT,
                    xyPlot, true);
            addChart(jFreeChart);
            ChartUtilities.applyCurrentTheme(jFreeChart);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            return chartPanel;
        }

        public MyDemoPanel() {
            super(new BorderLayout());
            data1 = createSampleData();
            add(createContent());
        }
    }

    public XYSplineRendererDemo1(String s) {
        super(s);
        JPanel panel = createDemoPanel();
        getContentPane().add(panel);
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] args) {
        XYSplineRendererDemo1 demo = new XYSplineRendererDemo1("JFreeChart: XYSplineRendererDemo1.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
