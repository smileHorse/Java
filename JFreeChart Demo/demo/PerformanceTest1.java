package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.FixedMillisecond;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class PerformanceTest1 extends ApplicationFrame {

   private TimeSeries timings = new TimeSeries("Timings");


   public PerformanceTest1(String var1) {
      super(var1);
      TimeSeriesCollection var2 = new TimeSeriesCollection(this.timings);
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      var4.setMouseZoomable(true);
      this.setContentPane(var4);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Performance Test 1", "Time", "Milliseconds", var0, true, true, false);
      var1.setBackgroundPaint(Color.white);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setBackgroundPaint(Color.lightGray);
      var2.setDomainGridlinePaint(Color.white);
      var2.setRangeGridlinePaint(Color.white);
      var2.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      XYItemRenderer var3 = var2.getRenderer();
      if(var3 instanceof StandardXYItemRenderer) {
         StandardXYItemRenderer var4 = (StandardXYItemRenderer)var3;
         var4.setSeriesStroke(0, new BasicStroke(1.1F));
      }

      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart((XYDataset)null);
      return new ChartPanel(var0);
   }

   public void addObservation(long var1) {
      this.timings.addOrUpdate(new Millisecond(), (double)var1);
   }

   public static void main2(String[] var0) {
      PerformanceTest1 var1 = new PerformanceTest1("Performance Test 1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
      TimeSeries var2 = new TimeSeries("Test");
      var2.setMaximumItemAge(200L);

      while(true) {
         Millisecond var3 = new Millisecond();
         long var4 = System.currentTimeMillis();

         for(int var6 = 0; var6 < 200; ++var6) {
            var3 = (Millisecond)var3.next();
            var2.addOrUpdate(var3, 1.0D);
         }

         long var8 = System.currentTimeMillis();
         var1.addObservation(var8 - var4);
      }
   }

   public static void main4(String[] var0) {
      TimeSeries var1 = new TimeSeries("Test");
      var1.setMaximumItemCount(4000);
      FixedMillisecond var2 = new FixedMillisecond();

      for(int var3 = 0; var3 < '\u9c40'; ++var3) {
         long var4 = System.currentTimeMillis();

         for(int var6 = 0; var6 < 400; ++var6) {
            var2 = (FixedMillisecond)var2.next();
            var1.add(var2, Math.random());
         }

         long var8 = System.currentTimeMillis();
         System.out.println(var3 + " --> " + (var8 - var4) + " (" + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().totalMemory() + ")");
      }

   }

   public static void main5(String[] var0) {
      XYSeries var1 = new XYSeries("Test");
      var1.setMaximumItemCount(4000);
      int var2 = 0;

      for(int var3 = 0; var3 < '\u9c40'; ++var3) {
         long var4 = System.currentTimeMillis();

         for(int var6 = 0; var6 < 4000; ++var6) {
            var1.add((double)(var2++), Math.random());
         }

         long var8 = System.currentTimeMillis();
         System.out.println(var3 + " --> " + (var8 - var4) + " (" + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().totalMemory() + ")");
      }

   }

   public static void main(String[] var0) {
      ArrayList var4 = new ArrayList();

      int var5;
      for(var5 = 0; var5 < 4000; ++var5) {
         var4.add(new Double(Math.random()));
      }

      var5 = 0;

      for(int var6 = 0; var6 < 20000; ++var6) {
         long var7 = System.currentTimeMillis();

         for(int var9 = 0; var9 < 1000000; ++var9) {
            var5 += var9;
         }

         long var11 = System.currentTimeMillis();
         System.out.println(var6 + " --> " + (var11 - var7) + " (" + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().totalMemory() + ")");
      }

   }

   public static void main3(String[] var0) {
      ArrayList var1 = new ArrayList();
      Millisecond var2 = new Millisecond();

      int var3;
      for(var3 = 0; var3 < 200; ++var3) {
         var2 = (Millisecond)var2.next();
         var1.add(var2);
      }

      for(var3 = 0; var3 < 2000; ++var3) {
         long var4 = System.currentTimeMillis();
         Collections.binarySearch(var1, new Millisecond());
         long var6 = System.currentTimeMillis();
         System.out.println(var3 + " --> " + (var6 - var4) + " (" + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().totalMemory() + ")");
      }

   }
}
