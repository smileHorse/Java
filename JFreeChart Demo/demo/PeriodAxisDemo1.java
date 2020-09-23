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
import org.jfree.data.time.Month;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class PeriodAxisDemo1 extends ApplicationFrame {

   public PeriodAxisDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
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
      var6.setAutoRangeTimePeriodClass(Month.class);
      var6.setMajorTickTimePeriodClass(Month.class);
      PeriodAxisLabelInfo[] var5 = new PeriodAxisLabelInfo[]{new PeriodAxisLabelInfo(Month.class, new SimpleDateFormat("MMM"), new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D), new Font("SansSerif", 1, 10), Color.blue, false, new BasicStroke(0.0F), Color.lightGray), new PeriodAxisLabelInfo(Year.class, new SimpleDateFormat("yyyy"))};
      var6.setLabelInfo(var5);
      var2.setDomainAxis(var6);
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
      var2.setXPosition(TimePeriodAnchor.MIDDLE);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      PeriodAxisDemo1 var1 = new PeriodAxisDemo1("JFreeChart: PeriodAxisDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
