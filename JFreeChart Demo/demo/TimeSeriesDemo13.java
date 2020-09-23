package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Week;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo13 extends ApplicationFrame {

   public TimeSeriesDemo13(String var1) {
      super(var1);
      this.setContentPane(createDemoPanel());
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Weekly Data", "Date", "Value", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      XYItemRenderer var3 = var2.getRenderer();
      if(var3 instanceof XYLineAndShapeRenderer) {
         XYLineAndShapeRenderer var4 = (XYLineAndShapeRenderer)var3;
         var4.setBaseShapesVisible(true);
         var4.setBaseShapesFilled(true);
      }

      DateAxis var6 = (DateAxis)var2.getDomainAxis();
      TickUnits var5 = new TickUnits();
      var5.add(new DateTickUnit(DateTickUnitType.DAY, 1, new SimpleDateFormat("MMM dd \'\'yy")));
      var5.add(new DateTickUnit(DateTickUnitType.DAY, 7, new SimpleDateFormat("MMM dd \'\'yy")));
      var5.add(new DateTickUnit(DateTickUnitType.MONTH, 1, new SimpleDateFormat("MMM \'\'yy")));
      var6.setStandardTickUnits(var5);
      return var1;
   }

   private static XYDataset createDataset(int var0) {
      TimeSeries var1 = new TimeSeries("Random Data");
      Object var2 = new Week();
      double var3 = 100.0D;

      for(int var5 = 0; var5 < var0; ++var5) {
         var1.add((RegularTimePeriod)var2, var3);
         var3 *= 1.0D + (Math.random() - 0.499D) / 100.0D;
         var2 = ((RegularTimePeriod)var2).next();
      }

      TimeSeriesCollection var6 = new TimeSeriesCollection(var1);
      return var6;
   }

   public static JPanel createDemoPanel() {
      XYDataset var0 = createDataset(26);
      JFreeChart var1 = createChart(var0);
      ChartPanel var2 = new ChartPanel(var1);
      XYDataset var3 = createDataset(1);
      JFreeChart var4 = createChart(var3);
      ChartPanel var5 = new ChartPanel(var4);
      JTabbedPane var6 = new JTabbedPane();
      var6.add("Chart 1", var2);
      var6.add("Chart 2", var5);
      JPanel var7 = new JPanel(new BorderLayout());
      var7.setPreferredSize(new Dimension(500, 270));
      var7.add(var6);
      return var7;
   }

   public static void main(String[] var0) {
      TimeSeriesDemo13 var1 = new TimeSeriesDemo13("Time Series Demo 13");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
