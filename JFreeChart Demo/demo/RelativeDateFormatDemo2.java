package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.util.RelativeDateFormat;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class RelativeDateFormatDemo2 extends ApplicationFrame {

   public RelativeDateFormatDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYBarChart("RelativeDateFormat Demo 2", "Date ", true, "Time To Complete", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      XYBarRenderer var3 = (XYBarRenderer)var2.getRenderer();
      var3.setDrawBarOutline(false);
      DateAxis var4 = new DateAxis();
      RelativeDateFormat var5 = new RelativeDateFormat();
      var5.setShowZeroDays(false);
      var5.setSecondFormatter(new DecimalFormat("00"));
      var4.setDateFormatOverride(var5);
      var2.setRangeAxis(var4);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static IntervalXYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Completion");
      var0.add(new Day(19, 1, 2007), 3343000.0D);
      var0.add(new Day(20, 1, 2007), 3420000.0D);
      var0.add(new Day(21, 1, 2007), 3515000.0D);
      var0.add(new Day(22, 1, 2007), 3315000.0D);
      var0.add(new Day(23, 1, 2007), 3490000.0D);
      var0.add(new Day(24, 1, 2007), 3556000.0D);
      var0.add(new Day(25, 1, 2007), 3383000.0D);
      var0.add(new Day(26, 1, 2007), 3575000.0D);
      TimeSeriesCollection var1 = new TimeSeriesCollection();
      var1.addSeries(var0);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      RelativeDateFormatDemo2 var1 = new RelativeDateFormatDemo2("JFreeChart: RelativeDateFormatDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
