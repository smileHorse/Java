package demo;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Random;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HistogramDemo1 extends ApplicationFrame {

   public HistogramDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static IntervalXYDataset createDataset() {
      HistogramDataset var0 = new HistogramDataset();
      double[] var1 = new double[1000];
      Random var2 = new Random(12345678L);

      int var3;
      for(var3 = 0; var3 < 1000; ++var3) {
         var1[var3] = var2.nextGaussian() + 5.0D;
      }

      var0.addSeries("H1", var1, 100, 2.0D, 8.0D);
      var1 = new double[1000];

      for(var3 = 0; var3 < 1000; ++var3) {
         var1[var3] = var2.nextGaussian() + 7.0D;
      }

      var0.addSeries("H2", var1, 100, 4.0D, 10.0D);
      return var0;
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createHistogram("Histogram Demo 1", (String)null, (String)null, var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      var2.setForegroundAlpha(0.85F);
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      XYBarRenderer var4 = (XYBarRenderer)var2.getRenderer();
      var4.setDrawBarOutline(false);
      var4.setBarPainter(new StandardXYBarPainter());
      var4.setShadowVisible(false);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) throws IOException {
      HistogramDemo1 var1 = new HistogramDemo1("JFreeChart: HistogramDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
