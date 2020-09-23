package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DeviationRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DeviationRendererDemo1 extends ApplicationFrame {

   public DeviationRendererDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static XYDataset createDataset() {
      YIntervalSeries var0 = new YIntervalSeries("Series 1");
      YIntervalSeries var1 = new YIntervalSeries("Series 2");
      double var2 = 100.0D;
      double var4 = 100.0D;

      for(int var6 = 0; var6 <= 100; ++var6) {
         var2 = var2 + Math.random() - 0.48D;
         double var7 = 0.05D * (double)var6;
         var0.add((double)var6, var2, var2 - var7, var2 + var7);
         var4 = var4 + Math.random() - 0.5D;
         double var9 = 0.07D * (double)var6;
         var1.add((double)var6, var4, var4 - var9, var4 + var9);
      }

      YIntervalSeriesCollection var11 = new YIntervalSeriesCollection();
      var11.addSeries(var0);
      var11.addSeries(var1);
      return var11;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("DeviationRenderer - Demo 1", "X", "Y", var0);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      DeviationRenderer var3 = new DeviationRenderer(true, false);
      var3.setSeriesStroke(0, new BasicStroke(3.0F, 1, 1));
      var3.setSeriesStroke(0, new BasicStroke(3.0F, 1, 1));
      var3.setSeriesStroke(1, new BasicStroke(3.0F, 1, 1));
      var3.setSeriesFillPaint(0, new Color(255, 200, 200));
      var3.setSeriesFillPaint(1, new Color(200, 200, 255));
      var2.setRenderer(var3);
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setAutoRangeIncludesZero(false);
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      DeviationRendererDemo1 var1 = new DeviationRendererDemo1("JFreeChart : DeviationRendererDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
