package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.util.RelativeDateFormat;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class RelativeDateFormatDemo1 extends ApplicationFrame {

   public RelativeDateFormatDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Exercise Chart", "Elapsed Time", "Beats Per Minute", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      XYItemRenderer var3 = var2.getRenderer();
      if(var3 instanceof XYLineAndShapeRenderer) {
         XYLineAndShapeRenderer var4 = (XYLineAndShapeRenderer)var3;
         var4.setBaseShapesVisible(true);
         var4.setBaseShapesFilled(true);
      }

      DateAxis var7 = (DateAxis)var2.getDomainAxis();
      Minute var5 = new Minute(0, 9, 1, 10, 2006);
      RelativeDateFormat var6 = new RelativeDateFormat(var5.getFirstMillisecond());
      var6.setSecondFormatter(new DecimalFormat("00"));
      var7.setDateFormatOverride(var6);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Heart Rate");
      var0.add(new org.jfree.data.time.Second(45, 6, 9, 1, 10, 2006), 143.0D);
      var0.add(new org.jfree.data.time.Second(33, 8, 9, 1, 10, 2006), 167.0D);
      var0.add(new org.jfree.data.time.Second(10, 10, 9, 1, 10, 2006), 189.0D);
      var0.add(new org.jfree.data.time.Second(19, 12, 9, 1, 10, 2006), 156.0D);
      var0.add(new org.jfree.data.time.Second(5, 15, 9, 1, 10, 2006), 176.0D);
      var0.add(new org.jfree.data.time.Second(12, 16, 9, 1, 10, 2006), 183.0D);
      var0.add(new org.jfree.data.time.Second(6, 18, 9, 1, 10, 2006), 138.0D);
      var0.add(new org.jfree.data.time.Second(11, 20, 9, 1, 10, 2006), 102.0D);
      TimeSeriesCollection var1 = new TimeSeriesCollection();
      var1.addSeries(var0);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      RelativeDateFormatDemo1 var1 = new RelativeDateFormatDemo1("JFreeChart: RelativeDateFormatDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
