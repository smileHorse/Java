package demo;

import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultWindDataset;
import org.jfree.data.xy.WindDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class WindChartDemo1 extends ApplicationFrame {

   public WindChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static long millisForDate(int var0, int var1, int var2) {
      Calendar var3 = Calendar.getInstance();
      var3.set(var2, var1 - 1, var0, 12, 0);
      return var3.getTimeInMillis();
   }

   private static Object[] createItem(long var0, int var2, int var3) {
      return new Object[]{new Date(var0), new Integer(var2), new Integer(var3)};
   }

   public static WindDataset createDataset() {
      Object[] var0 = createItem(millisForDate(3, 1, 1999), 0, 10);
      Object[] var1 = createItem(millisForDate(4, 1, 1999), 1, 8);
      Object[] var2 = createItem(millisForDate(5, 1, 1999), 2, 10);
      Object[] var3 = createItem(millisForDate(6, 1, 1999), 3, 10);
      Object[] var4 = createItem(millisForDate(7, 1, 1999), 4, 7);
      Object[] var5 = createItem(millisForDate(8, 1, 1999), 5, 10);
      Object[] var6 = createItem(millisForDate(9, 1, 1999), 6, 8);
      Object[] var7 = createItem(millisForDate(10, 1, 1999), 7, 11);
      Object[] var8 = createItem(millisForDate(11, 1, 1999), 8, 10);
      Object[] var9 = createItem(millisForDate(12, 1, 1999), 9, 11);
      Object[] var10 = createItem(millisForDate(13, 1, 1999), 10, 3);
      Object[] var11 = createItem(millisForDate(14, 1, 1999), 11, 9);
      Object[] var12 = createItem(millisForDate(15, 1, 1999), 12, 11);
      Object[] var13 = createItem(millisForDate(16, 1, 1999), 0, 0);
      Object[][] var14 = new Object[][]{var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13};
      Object[][][] var15 = new Object[][][]{var14};
      return new DefaultWindDataset(var15);
   }

   private static JFreeChart createChart(WindDataset var0) {
      JFreeChart var1 = ChartFactory.createWindPlot("Wind Chart Demo", "Date", "Direction / Force", var0, true, false, false);
      return var1;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      WindChartDemo1 var1 = new WindChartDemo1("Wind Chart Demo 1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
