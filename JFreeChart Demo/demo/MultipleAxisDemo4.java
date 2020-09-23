package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MultipleAxisDemo4 extends ApplicationFrame {

   public MultipleAxisDemo4(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(600, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart() {
      XYDataset var0 = createDataset("March 2007", 100.0D, new Day(1, 3, 2007), 31);
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Multiple Axis Demo 4", "Date", "Value", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setOrientation(PlotOrientation.VERTICAL);
      DateAxis var3 = (DateAxis)var2.getDomainAxis();
      var3.setDateFormatOverride(new SimpleDateFormat("d-MMM-yyyy"));
      XYItemRenderer var4 = var2.getRenderer();
      var4.setSeriesPaint(0, Color.red);
      NumberAxis var5 = (NumberAxis)var2.getRangeAxis();
      var5.setTickLabelPaint(Color.red);
      DateAxis var6 = new DateAxis("Date");
      var6.setDateFormatOverride(new SimpleDateFormat("d-MMM-yyyy"));
      var2.setDomainAxis(1, var6);
      var2.setDomainAxisLocation(1, AxisLocation.TOP_OR_LEFT);
      NumberAxis var7 = new NumberAxis("Value");
      var7.setAutoRangeIncludesZero(false);
      var7.setTickLabelPaint(Color.blue);
      var2.setRangeAxis(1, var7);
      var2.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
      XYDataset var8 = createDataset("July 2007", 1000.0D, new Day(1, 7, 2007), 31);
      var2.setDataset(1, var8);
      var2.mapDatasetToDomainAxis(1, 1);
      var2.mapDatasetToRangeAxis(1, 1);
      XYLineAndShapeRenderer var9 = new XYLineAndShapeRenderer(true, false);
      var9.setSeriesPaint(0, Color.blue);
      var2.setRenderer(1, var9);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static XYDataset createDataset(String var0, double var1, RegularTimePeriod var3, int var4) {
      TimeSeries var5 = new TimeSeries(var0);
      RegularTimePeriod var6 = var3;
      double var7 = var1;

      for(int var9 = 0; var9 < var4; ++var9) {
         var5.add(var6, var7);
         var6 = var6.next();
         var7 *= 1.0D + (Math.random() - 0.495D) / 10.0D;
      }

      TimeSeriesCollection var10 = new TimeSeriesCollection();
      var10.addSeries(var5);
      return var10;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      MultipleAxisDemo4 var1 = new MultipleAxisDemo4("JFreeChart: MultipleAxisDemo4.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
