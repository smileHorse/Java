package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class PeriodAxisDemo2 extends ApplicationFrame {

   public PeriodAxisDemo2(String var1) {
      super(var1);
      XYDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      var4.setMouseZoomable(true, true);
      this.setContentPane(var4);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Legal & General Unit Trust Prices", "Date", "Price Per Unit", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      XYItemRenderer var3 = var2.getRenderer();
      if(var3 instanceof XYLineAndShapeRenderer) {
         XYLineAndShapeRenderer var4 = (XYLineAndShapeRenderer)var3;
         var4.setBaseShapesVisible(true);
         var4.setBaseShapesFilled(true);
         var4.setBaseItemLabelsVisible(true);
      }

      PeriodAxis var6 = new PeriodAxis("Date");
      var6.setTimeZone(TimeZone.getTimeZone("Pacific/Auckland"));
      var6.setAutoRangeTimePeriodClass(Day.class);
      PeriodAxisLabelInfo[] var5 = new PeriodAxisLabelInfo[]{new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d")), new PeriodAxisLabelInfo(Month.class, new SimpleDateFormat("MMM"), new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D), new Font("SansSerif", 1, 10), Color.blue, false, new BasicStroke(0.0F), Color.lightGray), new PeriodAxisLabelInfo(Year.class, new SimpleDateFormat("yyyy"))};
      var6.setLabelInfo(var5);
      var2.setDomainAxis(var6);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("L&G European Index Trust");
      var0.add(new Day(24, 1, 2004), 181.8D);
      var0.add(new Day(25, 1, 2004), 167.3D);
      var0.add(new Day(26, 1, 2004), 153.8D);
      var0.add(new Day(27, 1, 2004), 167.6D);
      var0.add(new Day(28, 1, 2004), 158.8D);
      var0.add(new Day(29, 1, 2004), 148.3D);
      var0.add(new Day(30, 1, 2004), 153.9D);
      var0.add(new Day(31, 1, 2004), 142.7D);
      var0.add(new Day(1, 2, 2004), 123.2D);
      var0.add(new Day(2, 2, 2004), 131.8D);
      var0.add(new Day(3, 2, 2004), 139.6D);
      var0.add(new Day(4, 2, 2004), 142.9D);
      var0.add(new Day(5, 2, 2004), 138.7D);
      var0.add(new Day(6, 2, 2004), 137.3D);
      var0.add(new Day(7, 2, 2004), 143.9D);
      var0.add(new Day(8, 2, 2004), 139.8D);
      var0.add(new Day(9, 2, 2004), 137.0D);
      var0.add(new Day(10, 2, 2004), 132.8D);
      TimeZone var1 = TimeZone.getTimeZone("Pacific/Auckland");
      TimeSeriesCollection var2 = new TimeSeriesCollection(var1);
      var2.addSeries(var0);
      var2.setXPosition(TimePeriodAnchor.MIDDLE);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      PeriodAxisDemo2 var1 = new PeriodAxisDemo2("JFreeChart: PeriodAxisDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
