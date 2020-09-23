package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CompassFormat;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CompassFormatDemo1 extends ApplicationFrame {

   public CompassFormatDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static XYDataset createDirectionDataset(int var0) {
      TimeSeriesCollection var1 = new TimeSeriesCollection();
      TimeSeries var2 = new TimeSeries("Wind Direction");
      Object var3 = new Minute();
      double var4 = 180.0D;

      for(int var6 = 0; var6 < var0; ++var6) {
         var2.add((RegularTimePeriod)var3, var4);
         var3 = ((RegularTimePeriod)var3).next();
         var4 += (Math.random() - 0.5D) * 15.0D;
         if(var4 < 0.0D) {
            var4 += 360.0D;
         } else if(var4 > 360.0D) {
            var4 -= 360.0D;
         }
      }

      var1.addSeries(var2);
      return var1;
   }

   private static XYDataset createForceDataset(int var0) {
      TimeSeriesCollection var1 = new TimeSeriesCollection();
      TimeSeries var2 = new TimeSeries("Wind Force");
      Object var3 = new Minute();
      double var4 = 3.0D;

      for(int var6 = 0; var6 < var0; ++var6) {
         var2.add((RegularTimePeriod)var3, var4);
         var3 = ((RegularTimePeriod)var3).next();
         var4 = Math.max(0.5D, var4 + (Math.random() - 0.5D) * 0.5D);
      }

      var1.addSeries(var2);
      return var1;
   }

   private static JFreeChart createChart() {
      XYDataset var0 = createDirectionDataset(600);
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Time", "Date", "Direction", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      var2.getDomainAxis().setLowerMargin(0.0D);
      var2.getDomainAxis().setUpperMargin(0.0D);
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setAutoRangeIncludesZero(false);
      TickUnits var4 = new TickUnits();
      var4.add(new NumberTickUnit(180.0D, new CompassFormat()));
      var4.add(new NumberTickUnit(90.0D, new CompassFormat()));
      var4.add(new NumberTickUnit(45.0D, new CompassFormat()));
      var4.add(new NumberTickUnit(22.5D, new CompassFormat()));
      var3.setStandardTickUnits(var4);
      var2.setRangeAxis(var3);
      XYAreaRenderer var5 = new XYAreaRenderer();
      NumberAxis var6 = new NumberAxis("Force");
      var6.setRange(0.0D, 12.0D);
      var5.setSeriesPaint(0, new Color(0, 0, 255, 128));
      var2.setDataset(1, createForceDataset(600));
      var2.setRenderer(1, var5);
      var2.setRangeAxis(1, var6);
      var2.mapDatasetToRangeAxis(1, 1);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      CompassFormatDemo1 var1 = new CompassFormatDemo1("JFreeChart: CompassFormatDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
