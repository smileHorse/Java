package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GanttDemo2 extends ApplicationFrame {

   public GanttDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(IntervalCategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createGanttChart("Gantt Chart Demo", "Task", "Date", var0, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setRangePannable(true);
      var2.getDomainAxis().setMaximumCategoryLabelWidthRatio(10.0F);
      CategoryItemRenderer var3 = var2.getRenderer();
      var3.setSeriesPaint(0, Color.blue);
      return var1;
   }

   private static IntervalCategoryDataset createDataset() {
      TaskSeries var0 = new TaskSeries("Scheduled");
      Task var1 = new Task("Write Proposal", date(1, 3, 2001), date(5, 3, 2001));
      var1.setPercentComplete(1.0D);
      var0.add(var1);
      Task var2 = new Task("Obtain Approval", date(9, 3, 2001), date(9, 3, 2001));
      var2.setPercentComplete(1.0D);
      var0.add(var2);
      Task var3 = new Task("Requirements Analysis", date(10, 3, 2001), date(5, 4, 2001));
      Task var4 = new Task("Requirements 1", date(10, 3, 2001), date(25, 3, 2001));
      var4.setPercentComplete(1.0D);
      Task var5 = new Task("Requirements 2", date(1, 4, 2001), date(5, 4, 2001));
      var5.setPercentComplete(1.0D);
      var3.addSubtask(var4);
      var3.addSubtask(var5);
      var0.add(var3);
      Task var6 = new Task("Design Phase", date(6, 4, 2001), date(30, 4, 2001));
      Task var7 = new Task("Design 1", date(6, 4, 2001), date(10, 4, 2001));
      var7.setPercentComplete(1.0D);
      Task var8 = new Task("Design 2", date(15, 4, 2001), date(20, 4, 2001));
      var8.setPercentComplete(1.0D);
      Task var9 = new Task("Design 3", date(23, 4, 2001), date(30, 4, 2001));
      var9.setPercentComplete(0.5D);
      var6.addSubtask(var7);
      var6.addSubtask(var8);
      var6.addSubtask(var9);
      var0.add(var6);
      Task var10 = new Task("Design Signoff", date(2, 5, 2001), date(2, 5, 2001));
      var0.add(var10);
      Task var11 = new Task("Alpha Implementation", date(3, 5, 2001), date(31, 6, 2001));
      var11.setPercentComplete(0.6D);
      var0.add(var11);
      Task var12 = new Task("Design Review", date(1, 7, 2001), date(8, 7, 2001));
      var12.setPercentComplete(0.0D);
      var0.add(var12);
      Task var13 = new Task("Revised Design Signoff", date(10, 7, 2001), date(10, 7, 2001));
      var13.setPercentComplete(0.0D);
      var0.add(var13);
      Task var14 = new Task("Beta Implementation", date(12, 7, 2001), date(12, 8, 2001));
      var14.setPercentComplete(0.0D);
      var0.add(var14);
      Task var15 = new Task("Testing", date(13, 8, 2001), date(31, 9, 2001));
      var15.setPercentComplete(0.0D);
      var0.add(var15);
      Task var16 = new Task("Final Implementation", date(1, 10, 2001), date(15, 10, 2001));
      var16.setPercentComplete(0.0D);
      var0.add(var16);
      Task var17 = new Task("Signoff", date(28, 10, 2001), date(30, 10, 2001));
      var17.setPercentComplete(0.0D);
      var0.add(var17);
      TaskSeriesCollection var18 = new TaskSeriesCollection();
      var18.add(var0);
      return var18;
   }

   private static Date date(int var0, int var1, int var2) {
      Calendar var3 = Calendar.getInstance();
      var3.set(var2, var1, var0);
      Date var4 = var3.getTime();
      return var4;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      GanttDemo2 var1 = new GanttDemo2("JFreeChart: GanttDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
