package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D.Double;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.gantt.XYTaskDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYTaskDatasetDemo2 extends ApplicationFrame {

   public XYTaskDatasetDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static XYPlot createSubplot1(XYDataset var0) {
      XYLineAndShapeRenderer var1 = new XYLineAndShapeRenderer();
      var1.setUseFillPaint(true);
      var1.setBaseFillPaint(Color.white);
      var1.setBaseShape(new Double(-4.0D, -4.0D, 8.0D, 8.0D));
      var1.setAutoPopulateSeriesShape(false);
      NumberAxis var2 = new NumberAxis("Y");
      var2.setLowerMargin(0.1D);
      var2.setUpperMargin(0.1D);
      XYPlot var3 = new XYPlot(var0, new DateAxis("Time"), var2, var1);
      return var3;
   }

   private static XYPlot createSubplot2(IntervalXYDataset var0) {
      DateAxis var1 = new DateAxis("Date/Time");
      SymbolAxis var2 = new SymbolAxis("Resources", new String[]{"Team A", "Team B", "Team C", "Team D", "Team E"});
      var2.setGridBandsVisible(false);
      XYBarRenderer var3 = new XYBarRenderer();
      var3.setUseYInterval(true);
      XYPlot var4 = new XYPlot(var0, var1, var2, var3);
      return var4;
   }

   private static JFreeChart createChart() {
      CombinedDomainXYPlot var0 = new CombinedDomainXYPlot(new DateAxis("Date/Time"));
      var0.setDomainPannable(true);
      var0.add(createSubplot1(createDataset1()));
      var0.add(createSubplot2(createDataset2()));
      JFreeChart var1 = new JFreeChart("XYTaskDatasetDemo2", var0);
      var1.setBackgroundPaint(Color.white);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart());
   }

   private static XYDataset createDataset1() {
      TimeSeriesCollection var0 = new TimeSeriesCollection();
      TimeSeries var1 = new TimeSeries("Time Series 1");
      var1.add(new Hour(0, new Day()), 20214.5D);
      var1.add(new Hour(4, new Day()), 73346.5D);
      var1.add(new Hour(8, new Day()), 54643.6D);
      var1.add(new Hour(12, new Day()), 92683.8D);
      var1.add(new Hour(16, new Day()), 110235.4D);
      var1.add(new Hour(20, new Day()), 120742.5D);
      var1.add(new Hour(24, new Day()), 90654.5D);
      var0.addSeries(var1);
      return var0;
   }

   private static IntervalXYDataset createDataset2() {
      XYTaskDataset var0 = new XYTaskDataset(createTasks());
      var0.setTransposed(true);
      var0.setSeriesWidth(0.6D);
      return var0;
   }

   private static TaskSeriesCollection createTasks() {
      TaskSeriesCollection var0 = new TaskSeriesCollection();
      TaskSeries var1 = new TaskSeries("Team A");
      var1.add(new Task("T1a", new Hour(11, new Day())));
      var1.add(new Task("T1b", new Hour(14, new Day())));
      var1.add(new Task("T1c", new Hour(16, new Day())));
      TaskSeries var2 = new TaskSeries("Team B");
      var2.add(new Task("T2a", new Hour(13, new Day())));
      var2.add(new Task("T2b", new Hour(19, new Day())));
      var2.add(new Task("T2c", new Hour(21, new Day())));
      TaskSeries var3 = new TaskSeries("Team C");
      var3.add(new Task("T3a", new Hour(13, new Day())));
      var3.add(new Task("T3b", new Hour(19, new Day())));
      var3.add(new Task("T3c", new Hour(21, new Day())));
      TaskSeries var4 = new TaskSeries("Team D");
      var4.add(new Task("T4a", new Day()));
      TaskSeries var5 = new TaskSeries("Team E");
      var5.add(new Task("T5a", new Day()));
      var0.add(var1);
      var0.add(var2);
      var0.add(var3);
      var0.add(var4);
      var0.add(var5);
      return var0;
   }

   public static void main(String[] var0) {
      XYTaskDatasetDemo2 var1 = new XYTaskDatasetDemo2("JFreeChart : XYTaskDatasetDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
