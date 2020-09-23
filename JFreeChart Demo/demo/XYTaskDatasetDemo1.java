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
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.gantt.XYTaskDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYTaskDatasetDemo1 extends ApplicationFrame {

   public XYTaskDatasetDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYBarChart("XYTaskDatasetDemo1", "Resource", false, "Timing", var0, PlotOrientation.HORIZONTAL, true, false, false);
      var1.setBackgroundPaint(Color.white);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setRangePannable(true);
      SymbolAxis var3 = new SymbolAxis("Series", new String[]{"Team A", "Team B", "Team C", "Team D"});
      var3.setGridBandsVisible(false);
      var2.setDomainAxis(var3);
      XYBarRenderer var4 = (XYBarRenderer)var2.getRenderer();
      var4.setUseYInterval(true);
      var2.setRangeAxis(new DateAxis("Timing"));
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   private static IntervalXYDataset createDataset() {
      return new XYTaskDataset(createTasks());
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
      var0.add(var1);
      var0.add(var2);
      var0.add(var3);
      var0.add(var4);
      return var0;
   }

   public static void main(String[] var0) {
      XYTaskDatasetDemo1 var1 = new XYTaskDatasetDemo1("JFreeChart : XYTaskDatasetDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
