package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.util.TimeZone;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.axis.QuarterDateFormat;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class QuarterDateFormatDemo extends ApplicationFrame {

   public QuarterDateFormatDemo(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Legal & General Unit Trust Prices", "Date", "Price Per Unit", var0, true, true, false);
      var1.setBackgroundPaint(Color.white);
      XYPlot var2 = (XYPlot)var1.getPlot();
      PeriodAxis var3 = new PeriodAxis("Quarter", new Quarter(), new Quarter());
      var3.setAutoRangeTimePeriodClass(Quarter.class);
      PeriodAxisLabelInfo[] var4 = new PeriodAxisLabelInfo[]{new PeriodAxisLabelInfo(Quarter.class, new QuarterDateFormat(TimeZone.getDefault(), QuarterDateFormat.ROMAN_QUARTERS))};
      var3.setLabelInfo(var4);
      var2.setDomainAxis(var3);
      var2.setBackgroundPaint(Color.lightGray);
      var2.setDomainGridlinePaint(Color.white);
      var2.setRangeGridlinePaint(Color.white);
      var2.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      XYItemRenderer var5 = var2.getRenderer();
      if(var5 instanceof XYLineAndShapeRenderer) {
         XYLineAndShapeRenderer var6 = (XYLineAndShapeRenderer)var5;
         var6.setBaseShapesVisible(true);
         var6.setBaseShapesFilled(true);
      }

      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("L&G European Index Trust");
      var0.add(new Month(2, 2001), 181.8D);
      var0.add(new Month(3, 2001), 167.3D);
      var0.add(new Month(4, 2001), 153.8D);
      var0.add(new Month(5, 2001), 167.6D);
      var0.add(new Month(6, 2001), 158.8D);
      var0.add(new Month(7, 2001), 148.3D);
      var0.add(new Month(8, 2001), 153.9D);
      var0.add(new Month(9, 2001), 142.7D);
      var0.add(new Month(10, 2001), 123.2D);
      var0.add(new Month(11, 2001), 131.8D);
      var0.add(new Month(12, 2001), 139.6D);
      var0.add(new Month(1, 2002), 142.9D);
      var0.add(new Month(2, 2002), 138.7D);
      var0.add(new Month(3, 2002), 137.3D);
      var0.add(new Month(4, 2002), 143.9D);
      var0.add(new Month(5, 2002), 139.8D);
      var0.add(new Month(6, 2002), 137.0D);
      var0.add(new Month(7, 2002), 132.8D);
      TimeSeries var1 = new TimeSeries("L&G UK Index Trust");
      var1.add(new Month(2, 2001), 129.6D);
      var1.add(new Month(3, 2001), 123.2D);
      var1.add(new Month(4, 2001), 117.2D);
      var1.add(new Month(5, 2001), 124.1D);
      var1.add(new Month(6, 2001), 122.6D);
      var1.add(new Month(7, 2001), 119.2D);
      var1.add(new Month(8, 2001), 116.5D);
      var1.add(new Month(9, 2001), 112.7D);
      var1.add(new Month(10, 2001), 101.5D);
      var1.add(new Month(11, 2001), 106.1D);
      var1.add(new Month(12, 2001), 110.3D);
      var1.add(new Month(1, 2002), 111.7D);
      var1.add(new Month(2, 2002), 111.0D);
      var1.add(new Month(3, 2002), 109.6D);
      var1.add(new Month(4, 2002), 113.2D);
      var1.add(new Month(5, 2002), 111.6D);
      var1.add(new Month(6, 2002), 108.8D);
      var1.add(new Month(7, 2002), 101.6D);
      TimeSeriesCollection var2 = new TimeSeriesCollection();
      var2.addSeries(var0);
      var2.addSeries(var1);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      QuarterDateFormatDemo var1 = new QuarterDateFormatDemo("JFreeChart: QuarterDateFormatDemo.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
