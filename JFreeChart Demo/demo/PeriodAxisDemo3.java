package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class PeriodAxisDemo3 extends ApplicationFrame {

   public PeriodAxisDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYBarChart("Maximum Temperature", "Day", true, "Temperature", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      PeriodAxis var3 = new PeriodAxis("Day");
      var3.setAutoRangeTimePeriodClass(Day.class);
      PeriodAxisLabelInfo[] var4 = new PeriodAxisLabelInfo[]{new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d")), new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("E"), new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D), new Font("SansSerif", 1, 10), Color.blue, false, new BasicStroke(0.0F), Color.lightGray), new PeriodAxisLabelInfo(Month.class, new SimpleDateFormat("MMM"))};
      var3.setLabelInfo(var4);
      var2.setDomainAxis(var3);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static IntervalXYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Temperature");
      var0.add(new Day(1, 4, 2006), 14.5D);
      var0.add(new Day(2, 4, 2006), 11.5D);
      var0.add(new Day(3, 4, 2006), 13.7D);
      var0.add(new Day(4, 4, 2006), 10.5D);
      var0.add(new Day(5, 4, 2006), 14.9D);
      var0.add(new Day(6, 4, 2006), 15.7D);
      var0.add(new Day(7, 4, 2006), 11.5D);
      var0.add(new Day(8, 4, 2006), 9.5D);
      var0.add(new Day(9, 4, 2006), 10.9D);
      var0.add(new Day(10, 4, 2006), 14.1D);
      var0.add(new Day(11, 4, 2006), 12.3D);
      var0.add(new Day(12, 4, 2006), 14.3D);
      var0.add(new Day(13, 4, 2006), 19.0D);
      var0.add(new Day(14, 4, 2006), 17.9D);
      TimeSeriesCollection var1 = new TimeSeriesCollection();
      var1.addSeries(var0);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      PeriodAxisDemo3 var1 = new PeriodAxisDemo3("JFreeChart: PeriodAxisDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
