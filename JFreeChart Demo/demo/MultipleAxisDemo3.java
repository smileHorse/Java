package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MultipleAxisDemo3 extends ApplicationFrame {

   public MultipleAxisDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(600, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart() {
      XYDataset var0 = createDataset("Series 1", 100.0D, new Minute(), 200);
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Multiple Axis Demo 3", "Time of Day", "Primary Range Axis", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setOrientation(PlotOrientation.VERTICAL);
      NumberAxis var3 = new NumberAxis("Domain Axis 2");
      var3.setAutoRangeIncludesZero(false);
      var2.setDomainAxis(1, var3);
      var2.setDomainAxisLocation(1, AxisLocation.BOTTOM_OR_LEFT);
      NumberAxis var4 = new NumberAxis("Domain Axis 3");
      var3.setAutoRangeIncludesZero(false);
      var2.setDomainAxis(2, var4);
      var2.setDomainAxisLocation(2, AxisLocation.BOTTOM_OR_LEFT);
      NumberAxis var5 = new NumberAxis("Range Axis 2");
      var2.setRangeAxis(1, var5);
      var2.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
      XYDataset var6 = createDataset("Series 2", 1000.0D, new Minute(), 170);
      var2.setDataset(1, var6);
      var2.mapDatasetToDomainAxis(1, 1);
      var2.mapDatasetToRangeAxis(1, 1);
      var2.setRenderer(1, new XYLineAndShapeRenderer(true, false));
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
      MultipleAxisDemo3 var1 = new MultipleAxisDemo3("JFreeChart: MultipleAxisDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
