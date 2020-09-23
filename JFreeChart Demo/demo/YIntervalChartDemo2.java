package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYErrorRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class YIntervalChartDemo2 extends ApplicationFrame {

   public YIntervalChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static void add(YIntervalSeries var0, int var1, int var2, int var3, double var4, double var6) {
      Calendar var8 = Calendar.getInstance();
      var8.set(var1, var2, var3);
      var0.add((double)var8.getTime().getTime(), var4, var4 - var6, var4 + var6);
   }

   private static IntervalXYDataset createDataset() {
      YIntervalSeries var0 = new YIntervalSeries("Series 1");
      add(var0, 2005, 4, 16, 1309.0D, 13.0D);
      add(var0, 2005, 9, 18, 1312.0D, 12.0D);
      add(var0, 2005, 10, 7, 1309.0D, 12.0D);
      add(var0, 2006, 0, 12, 1311.0D, 12.0D);
      add(var0, 2006, 1, 7, 1311.0D, 13.0D);
      add(var0, 2006, 3, 3, 1309.0D, 13.0D);
      add(var0, 2006, 3, 4, 1307.0D, 13.0D);
      add(var0, 2006, 3, 6, 1305.0D, 13.0D);
      add(var0, 2006, 3, 13, 1303.0D, 13.0D);
      add(var0, 2006, 3, 25, 1308.0D, 13.0D);
      add(var0, 2006, 3, 28, 1311.0D, 13.0D);
      add(var0, 2006, 4, 2, 1306.0D, 13.0D);
      add(var0, 2006, 4, 15, 1303.0D, 13.0D);
      add(var0, 2006, 4, 18, 1311.0D, 13.0D);
      add(var0, 2006, 10, 16, 1301.0D, 13.0D);
      YIntervalSeriesCollection var1 = new YIntervalSeriesCollection();
      var1.addSeries(var0);
      return var1;
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("YIntervalChartDemo2", "Date", "Value", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      var2.setDomainAxis(new DateAxis("Date"));
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var3.setAutoRangeIncludesZero(false);
      XYErrorRenderer var4 = new XYErrorRenderer();
      var4.setBaseLinesVisible(true);
      var4.setUseFillPaint(true);
      var4.setBaseFillPaint(Color.white);
      var2.setRenderer(var4);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      YIntervalChartDemo2 var1 = new YIntervalChartDemo2("JFreeChart: YIntervalChartDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
