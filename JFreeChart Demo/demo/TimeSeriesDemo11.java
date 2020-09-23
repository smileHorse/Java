package demo;

import demo.DemoPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.date.SerialDate;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo11 extends ApplicationFrame {

   public TimeSeriesDemo11(String var1) {
      super(var1);
      this.setContentPane(createDemoPanel());
   }

   private static JFreeChart createChart(String var0, XYDataset var1) {
      JFreeChart var2 = ChartFactory.createTimeSeriesChart(var0, "Date", "Price", var1, true, true, false);
      XYPlot var3 = (XYPlot)var2.getPlot();
      var3.setOrientation(PlotOrientation.VERTICAL);
      XYItemRenderer var4 = var3.getRenderer();
      var4.setSeriesPaint(0, Color.blue);
      return var2;
   }

   private static XYDataset createDataset(String var0, double var1, RegularTimePeriod var3, int var4) {
      TimeSeries var5 = new TimeSeries(var0);
      RegularTimePeriod var6 = var3;
      double var7 = var1;

      for(int var9 = 0; var9 < var4; ++var9) {
         var5.add(var6, var7);
         var6 = var6.previous();
         var7 *= 1.0D + (Math.random() - 0.495D) / 10.0D;
      }

      TimeSeriesCollection var10 = new TimeSeriesCollection();
      var10.addSeries(var5);
      return var10;
   }

   public static JPanel createDemoPanel() {
      DemoPanel var0 = new DemoPanel(new GridLayout(2, 2));
      var0.setPreferredSize(new Dimension(800, 600));
      Day var1 = new Day();
      XYDataset var2 = createDataset("Series 1", 100.0D, var1, 365);
      JFreeChart var3 = createChart("Chart 1 : 1 Year", var2);
      ChartPanel var4 = new ChartPanel(var3);
      var0.add(var4);
      JFreeChart var5 = createChart("Chart 2 : 6 Months", var2);
      SerialDate var6 = var1.getSerialDate();
      SerialDate var7 = SerialDate.addMonths(-6, var6);
      Day var8 = new Day(var7);
      XYPlot var9 = (XYPlot)var5.getPlot();
      DateAxis var10 = (DateAxis)var9.getDomainAxis();
      var10.setRange(var8.getStart(), var1.getEnd());
      ChartPanel var11 = new ChartPanel(var5);
      var0.add(var11);
      JFreeChart var12 = createChart("Chart 3 : 3 Months", var2);
      SerialDate var13 = SerialDate.addMonths(-3, var6);
      Day var14 = new Day(var13);
      XYPlot var15 = (XYPlot)var12.getPlot();
      DateAxis var16 = (DateAxis)var15.getDomainAxis();
      var16.setRange(var14.getStart(), var1.getEnd());
      ChartPanel var17 = new ChartPanel(var12);
      var0.add(var17);
      JFreeChart var18 = createChart("Chart 4 : 1 Month", var2);
      SerialDate var19 = SerialDate.addMonths(-1, var6);
      Day var20 = new Day(var19);
      XYPlot var21 = (XYPlot)var18.getPlot();
      DateAxis var22 = (DateAxis)var21.getDomainAxis();
      var22.setRange(var20.getStart(), var1.getEnd());
      ChartPanel var23 = new ChartPanel(var18);
      var0.add(var23);
      var0.addChart(var3);
      var0.addChart(var5);
      var0.addChart(var12);
      var0.addChart(var18);
      return var0;
   }

   public static void main(String[] var0) {
      TimeSeriesDemo11 var1 = new TimeSeriesDemo11("Time Series Demo 11");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
