package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo4 extends ApplicationFrame {

   public XYBarChartDemo4(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYBarChart("XYBarChartDemo4", "X", false, "Y", var0, PlotOrientation.VERTICAL, true, false, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      NumberAxis var3 = (NumberAxis)var2.getDomainAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      XYBarRenderer var4 = (XYBarRenderer)var2.getRenderer();
      var4.setDrawBarOutline(false);
      return var1;
   }

   private static IntervalXYDataset createDataset() {
      XYSeries var0 = new XYSeries("Series 1");
      var0.add(1.0D, 5.0D);
      var0.add(2.0D, 70.8D);
      var0.add(3.0D, 48.3D);
      XYSeriesCollection var1 = new XYSeriesCollection();
      var1.addSeries(var0);
      return new XYBarDataset(var1, 0.9D);
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      XYBarChartDemo4 var1 = new XYBarChartDemo4("XY Bar Chart Demo 4");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
