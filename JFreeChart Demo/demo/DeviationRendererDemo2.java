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
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Week;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class DeviationRendererDemo2 extends ApplicationFrame {

   public DeviationRendererDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static XYDataset createDataset() {
      YIntervalSeries var0 = new YIntervalSeries("Series 1");
      YIntervalSeries var1 = new YIntervalSeries("Series 2");
      Object var2 = new Week();
      double var3 = 100.0D;
      double var5 = 100.0D;

      for(int var7 = 0; var7 <= 52; ++var7) {
         double var8 = 0.05D * (double)var7;
         var0.add((double)((RegularTimePeriod)var2).getFirstMillisecond(), var3, var3 - var8, var3 + var8);
         var3 = var3 + Math.random() - 0.45D;
         double var10 = 0.07D * (double)var7;
         var1.add((double)((RegularTimePeriod)var2).getFirstMillisecond(), var5, var5 - var10, var5 + var10);
         var5 = var5 + Math.random() - 0.55D;
         var2 = ((RegularTimePeriod)var2).next();
      }

      YIntervalSeriesCollection var12 = new YIntervalSeriesCollection();
      var12.addSeries(var0);
      var12.addSeries(var1);
      return var12;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Projected Values - Test", "Date", "Index Projection", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(false);
      var2.setInsets(new RectangleInsets(5.0D, 5.0D, 5.0D, 20.0D));
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
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      DeviationRendererDemo2 var1 = new DeviationRendererDemo2("JFreeChart: DeviationRendererDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
