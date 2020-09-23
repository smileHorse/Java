package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.MovingAverage;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HighLowChartDemo2 extends ApplicationFrame {

   private static final Calendar calendar = Calendar.getInstance();


   public HighLowChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static Date createDate(int var0, int var1, int var2, int var3, int var4) {
      calendar.clear();
      calendar.set(var0, var1 - 1, var2, var3, var4);
      return calendar.getTime();
   }

   public static OHLCDataset createDataset() {
      Date[] var0 = new Date[47];
      double[] var1 = new double[47];
      double[] var2 = new double[47];
      double[] var3 = new double[47];
      double[] var4 = new double[47];
      double[] var5 = new double[47];
      byte var6 = 1;
      byte var7 = 2;
      var0[0] = createDate(2001, var6, 4, 12, 0);
      var1[0] = 47.0D;
      var2[0] = 33.0D;
      var3[0] = 35.0D;
      var4[0] = 33.0D;
      var5[0] = 100.0D;
      var0[1] = createDate(2001, var6, 5, 12, 0);
      var1[1] = 47.0D;
      var2[1] = 32.0D;
      var3[1] = 41.0D;
      var4[1] = 37.0D;
      var5[1] = 150.0D;
      var0[2] = createDate(2001, var6, 6, 12, 0);
      var1[2] = 49.0D;
      var2[2] = 43.0D;
      var3[2] = 46.0D;
      var4[2] = 48.0D;
      var5[2] = 70.0D;
      var0[3] = createDate(2001, var6, 7, 12, 0);
      var1[3] = 51.0D;
      var2[3] = 39.0D;
      var3[3] = 40.0D;
      var4[3] = 47.0D;
      var5[3] = 200.0D;
      var0[4] = createDate(2001, var6, 8, 12, 0);
      var1[4] = 60.0D;
      var2[4] = 40.0D;
      var3[4] = 46.0D;
      var4[4] = 53.0D;
      var5[4] = 120.0D;
      var0[5] = createDate(2001, var6, 9, 12, 0);
      var1[5] = 62.0D;
      var2[5] = 55.0D;
      var3[5] = 57.0D;
      var4[5] = 61.0D;
      var5[5] = 110.0D;
      var0[6] = createDate(2001, var6, 10, 12, 0);
      var1[6] = 65.0D;
      var2[6] = 56.0D;
      var3[6] = 62.0D;
      var4[6] = 59.0D;
      var5[6] = 70.0D;
      var0[7] = createDate(2001, var6, 11, 12, 0);
      var1[7] = 55.0D;
      var2[7] = 43.0D;
      var3[7] = 45.0D;
      var4[7] = 47.0D;
      var5[7] = 20.0D;
      var0[8] = createDate(2001, var6, 12, 12, 0);
      var1[8] = 54.0D;
      var2[8] = 33.0D;
      var3[8] = 40.0D;
      var4[8] = 51.0D;
      var5[8] = 30.0D;
      var0[9] = createDate(2001, var6, 13, 12, 0);
      var1[9] = 47.0D;
      var2[9] = 33.0D;
      var3[9] = 35.0D;
      var4[9] = 33.0D;
      var5[9] = 100.0D;
      var0[10] = createDate(2001, var6, 14, 12, 0);
      var1[10] = 54.0D;
      var2[10] = 38.0D;
      var3[10] = 43.0D;
      var4[10] = 52.0D;
      var5[10] = 50.0D;
      var0[11] = createDate(2001, var6, 15, 12, 0);
      var1[11] = 48.0D;
      var2[11] = 41.0D;
      var3[11] = 44.0D;
      var4[11] = 41.0D;
      var5[11] = 80.0D;
      var0[12] = createDate(2001, var6, 17, 12, 0);
      var1[12] = 60.0D;
      var2[12] = 30.0D;
      var3[12] = 34.0D;
      var4[12] = 44.0D;
      var5[12] = 90.0D;
      var0[13] = createDate(2001, var6, 18, 12, 0);
      var1[13] = 58.0D;
      var2[13] = 44.0D;
      var3[13] = 54.0D;
      var4[13] = 56.0D;
      var5[13] = 20.0D;
      var0[14] = createDate(2001, var6, 19, 12, 0);
      var1[14] = 54.0D;
      var2[14] = 32.0D;
      var3[14] = 42.0D;
      var4[14] = 53.0D;
      var5[14] = 70.0D;
      var0[15] = createDate(2001, var6, 20, 12, 0);
      var1[15] = 53.0D;
      var2[15] = 39.0D;
      var3[15] = 50.0D;
      var4[15] = 49.0D;
      var5[15] = 60.0D;
      var0[16] = createDate(2001, var6, 21, 12, 0);
      var1[16] = 47.0D;
      var2[16] = 33.0D;
      var3[16] = 41.0D;
      var4[16] = 40.0D;
      var5[16] = 30.0D;
      var0[17] = createDate(2001, var6, 22, 12, 0);
      var1[17] = 55.0D;
      var2[17] = 37.0D;
      var3[17] = 43.0D;
      var4[17] = 45.0D;
      var5[17] = 90.0D;
      var0[18] = createDate(2001, var6, 23, 12, 0);
      var1[18] = 54.0D;
      var2[18] = 42.0D;
      var3[18] = 50.0D;
      var4[18] = 42.0D;
      var5[18] = 150.0D;
      var0[19] = createDate(2001, var6, 24, 12, 0);
      var1[19] = 48.0D;
      var2[19] = 37.0D;
      var3[19] = 37.0D;
      var4[19] = 47.0D;
      var5[19] = 120.0D;
      var0[20] = createDate(2001, var6, 25, 12, 0);
      var1[20] = 58.0D;
      var2[20] = 33.0D;
      var3[20] = 39.0D;
      var4[20] = 41.0D;
      var5[20] = 80.0D;
      var0[21] = createDate(2001, var6, 26, 12, 0);
      var1[21] = 47.0D;
      var2[21] = 31.0D;
      var3[21] = 36.0D;
      var4[21] = 41.0D;
      var5[21] = 40.0D;
      var0[22] = createDate(2001, var6, 27, 12, 0);
      var1[22] = 58.0D;
      var2[22] = 44.0D;
      var3[22] = 49.0D;
      var4[22] = 44.0D;
      var5[22] = 20.0D;
      var0[23] = createDate(2001, var6, 28, 12, 0);
      var1[23] = 46.0D;
      var2[23] = 41.0D;
      var3[23] = 43.0D;
      var4[23] = 44.0D;
      var5[23] = 60.0D;
      var0[24] = createDate(2001, var6, 29, 12, 0);
      var1[24] = 56.0D;
      var2[24] = 39.0D;
      var3[24] = 39.0D;
      var4[24] = 51.0D;
      var5[24] = 40.0D;
      var0[25] = createDate(2001, var6, 30, 12, 0);
      var1[25] = 56.0D;
      var2[25] = 39.0D;
      var3[25] = 47.0D;
      var4[25] = 49.0D;
      var5[25] = 70.0D;
      var0[26] = createDate(2001, var6, 31, 12, 0);
      var1[26] = 53.0D;
      var2[26] = 39.0D;
      var3[26] = 52.0D;
      var4[26] = 47.0D;
      var5[26] = 60.0D;
      var0[27] = createDate(2001, var7, 1, 12, 0);
      var1[27] = 51.0D;
      var2[27] = 30.0D;
      var3[27] = 45.0D;
      var4[27] = 47.0D;
      var5[27] = 90.0D;
      var0[28] = createDate(2001, var7, 2, 12, 0);
      var1[28] = 47.0D;
      var2[28] = 30.0D;
      var3[28] = 34.0D;
      var4[28] = 46.0D;
      var5[28] = 100.0D;
      var0[29] = createDate(2001, var7, 3, 12, 0);
      var1[29] = 57.0D;
      var2[29] = 37.0D;
      var3[29] = 44.0D;
      var4[29] = 56.0D;
      var5[29] = 20.0D;
      var0[30] = createDate(2001, var7, 4, 12, 0);
      var1[30] = 49.0D;
      var2[30] = 40.0D;
      var3[30] = 47.0D;
      var4[30] = 44.0D;
      var5[30] = 50.0D;
      var0[31] = createDate(2001, var7, 5, 12, 0);
      var1[31] = 46.0D;
      var2[31] = 38.0D;
      var3[31] = 43.0D;
      var4[31] = 40.0D;
      var5[31] = 70.0D;
      var0[32] = createDate(2001, var7, 6, 12, 0);
      var1[32] = 55.0D;
      var2[32] = 38.0D;
      var3[32] = 39.0D;
      var4[32] = 53.0D;
      var5[32] = 120.0D;
      var0[33] = createDate(2001, var7, 7, 12, 0);
      var1[33] = 50.0D;
      var2[33] = 33.0D;
      var3[33] = 37.0D;
      var4[33] = 37.0D;
      var5[33] = 140.0D;
      var0[34] = createDate(2001, var7, 8, 12, 0);
      var1[34] = 59.0D;
      var2[34] = 34.0D;
      var3[34] = 57.0D;
      var4[34] = 43.0D;
      var5[34] = 70.0D;
      var0[35] = createDate(2001, var7, 9, 12, 0);
      var1[35] = 48.0D;
      var2[35] = 39.0D;
      var3[35] = 46.0D;
      var4[35] = 47.0D;
      var5[35] = 70.0D;
      var0[36] = createDate(2001, var7, 10, 12, 0);
      var1[36] = 55.0D;
      var2[36] = 30.0D;
      var3[36] = 37.0D;
      var4[36] = 30.0D;
      var5[36] = 30.0D;
      var0[37] = createDate(2001, var7, 11, 12, 0);
      var1[37] = 60.0D;
      var2[37] = 32.0D;
      var3[37] = 56.0D;
      var4[37] = 36.0D;
      var5[37] = 70.0D;
      var0[38] = createDate(2001, var7, 12, 12, 0);
      var1[38] = 56.0D;
      var2[38] = 42.0D;
      var3[38] = 53.0D;
      var4[38] = 54.0D;
      var5[38] = 40.0D;
      var0[39] = createDate(2001, var7, 13, 12, 0);
      var1[39] = 49.0D;
      var2[39] = 42.0D;
      var3[39] = 45.0D;
      var4[39] = 42.0D;
      var5[39] = 90.0D;
      var0[40] = createDate(2001, var7, 14, 12, 0);
      var1[40] = 55.0D;
      var2[40] = 42.0D;
      var3[40] = 47.0D;
      var4[40] = 54.0D;
      var5[40] = 70.0D;
      var0[41] = createDate(2001, var7, 15, 12, 0);
      var1[41] = 49.0D;
      var2[41] = 35.0D;
      var3[41] = 38.0D;
      var4[41] = 35.0D;
      var5[41] = 20.0D;
      var0[42] = createDate(2001, var7, 16, 12, 0);
      var1[42] = 47.0D;
      var2[42] = 38.0D;
      var3[42] = 43.0D;
      var4[42] = 42.0D;
      var5[42] = 10.0D;
      var0[43] = createDate(2001, var7, 17, 12, 0);
      var1[43] = 53.0D;
      var2[43] = 42.0D;
      var3[43] = 47.0D;
      var4[43] = 48.0D;
      var5[43] = 20.0D;
      var0[44] = createDate(2001, var7, 18, 12, 0);
      var1[44] = 47.0D;
      var2[44] = 44.0D;
      var3[44] = 46.0D;
      var4[44] = 44.0D;
      var5[44] = 30.0D;
      var0[45] = createDate(2001, var7, 19, 12, 0);
      var1[45] = 46.0D;
      var2[45] = 40.0D;
      var3[45] = 43.0D;
      var4[45] = 44.0D;
      var5[45] = 50.0D;
      var0[46] = createDate(2001, var7, 20, 12, 0);
      var1[46] = 48.0D;
      var2[46] = 41.0D;
      var3[46] = 46.0D;
      var4[46] = 41.0D;
      var5[46] = 100.0D;
      return new DefaultHighLowDataset("Series 1", var0, var1, var2, var3, var4, var5);
   }

   private static JFreeChart createChart(OHLCDataset var0) {
      JFreeChart var1 = ChartFactory.createHighLowChart("HighLowChartDemo2", "Time", "Value", var0, true);
      XYPlot var2 = (XYPlot)var1.getPlot();
      DateAxis var3 = (DateAxis)var2.getDomainAxis();
      var3.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setNumberFormatOverride(new DecimalFormat("$0.00"));
      XYDataset var5 = MovingAverage.createMovingAverage(var0, "-MAVG", 259200000L, 0L);
      var2.setDataset(1, var5);
      var2.setRenderer(1, new StandardXYItemRenderer());
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      HighLowChartDemo2 var1 = new HighLowChartDemo2("JFreeChart: HighLowChartDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }

}
