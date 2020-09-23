package demo;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class InternalFrameDemo extends ApplicationFrame {

   public InternalFrameDemo(String var1) {
      super(var1);
      JDesktopPane var2 = new JDesktopPane();
      var2.setPreferredSize(new Dimension(600, 400));
      JInternalFrame var3 = this.createFrame1();
      var2.add(var3);
      var3.pack();
      var3.setVisible(true);
      JInternalFrame var4 = this.createFrame2();
      var2.add(var4);
      var4.pack();
      var4.setLocation(100, 200);
      var4.setVisible(true);
      this.getContentPane().add(var2);
   }

   private JInternalFrame createFrame1() {
      DefaultCategoryDataset var1 = new DefaultCategoryDataset();
      var1.addValue(34.0D, "Series 1", "Category 1");
      var1.addValue(23.0D, "Series 1", "Category 2");
      var1.addValue(54.0D, "Series 1", "Category 3");
      JFreeChart var2 = ChartFactory.createBarChart("Bar Chart", "Category", "Series", var1, PlotOrientation.VERTICAL, true, true, false);
      ChartPanel var3 = new ChartPanel(var2);
      var3.setPreferredSize(new Dimension(200, 100));
      JInternalFrame var4 = new JInternalFrame("Frame 1", true);
      var4.getContentPane().add(var3);
      return var4;
   }

   private JInternalFrame createFrame2() {
      XYDataset var1 = this.createDataset("Series 1", 100.0D, new Minute(), 200);
      JFreeChart var2 = ChartFactory.createTimeSeriesChart("Time Series Chart", "Time of Day", "Value", var1, true, true, false);
      ChartPanel var3 = new ChartPanel(var2);
      var3.setPreferredSize(new Dimension(200, 100));
      JInternalFrame var4 = new JInternalFrame("Frame 2", true);
      var4.getContentPane().add(var3);
      return var4;
   }

   private XYDataset createDataset(String var1, double var2, RegularTimePeriod var4, int var5) {
      TimeSeries var6 = new TimeSeries(var1);
      RegularTimePeriod var7 = var4;
      double var8 = var2;

      for(int var10 = 0; var10 < var5; ++var10) {
         var6.add(var7, var8);
         var7 = var7.next();
         var8 *= 1.0D + (Math.random() - 0.495D) / 10.0D;
      }

      TimeSeriesCollection var11 = new TimeSeriesCollection();
      var11.addSeries(var6);
      return var11;
   }

   public static void main(String[] var0) {
      InternalFrameDemo var1 = new InternalFrameDemo("Internal Frame Demo");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
