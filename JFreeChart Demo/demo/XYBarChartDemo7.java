package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo7 extends ApplicationFrame {

   public XYBarChartDemo7(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYBarChart("XYBarChartDemo7", "Date", true, "Y", var0, PlotOrientation.HORIZONTAL, true, false, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setRangePannable(true);
      var2.setRangeAxis(new DateAxis("Date"));
      SymbolAxis var3 = new SymbolAxis("Series", new String[]{"S1", "S2", "S3"});
      var3.setGridBandsVisible(false);
      var2.setDomainAxis(var3);
      XYBarRenderer var4 = (XYBarRenderer)var2.getRenderer();
      var4.setUseYInterval(true);
      var2.setRenderer(var4);
      var2.setBackgroundPaint(Color.lightGray);
      var2.setDomainGridlinePaint(Color.white);
      var2.setRangeGridlinePaint(Color.white);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static IntervalXYDataset createDataset() {
      Day var0 = new Day(12, 6, 2007);
      Day var1 = new Day(13, 6, 2007);
      Day var2 = new Day(14, 6, 2007);
      Day var3 = new Day(15, 6, 2007);
      Day var4 = new Day(16, 6, 2007);
      Day var5 = new Day(17, 6, 2007);
      XYIntervalSeriesCollection var6 = new XYIntervalSeriesCollection();
      XYIntervalSeries var7 = new XYIntervalSeries("S1");
      XYIntervalSeries var8 = new XYIntervalSeries("S2");
      XYIntervalSeries var9 = new XYIntervalSeries("S3");
      addItem(var7, var0, var1, 0);
      addItem(var7, var3, var3, 0);
      addItem(var8, var0, var5, 1);
      addItem(var9, var2, var4, 2);
      var6.addSeries(var7);
      var6.addSeries(var8);
      var6.addSeries(var9);
      return var6;
   }

   private static void addItem(XYIntervalSeries var0, RegularTimePeriod var1, RegularTimePeriod var2, int var3) {
      var0.add((double)var3, (double)var3 - 0.45D, (double)var3 + 0.45D, (double)var1.getFirstMillisecond(), (double)var1.getFirstMillisecond(), (double)var2.getLastMillisecond());
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      XYBarChartDemo7 var1 = new XYBarChartDemo7("JFreeChart : XYBarChartDemo7.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
