package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDifferenceRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DifferenceChartDemo1 extends ApplicationFrame {

   public DifferenceChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Random 1");
      TimeSeries var1 = new TimeSeries("Random 2");
      double var2 = 0.0D;
      double var4 = 0.0D;
      Day var6 = new Day();

      for(int var7 = 0; var7 < 200; ++var7) {
         var2 = var2 + Math.random() - 0.5D;
         var4 = var4 + Math.random() - 0.5D;
         var0.add(var6, var2);
         var1.add(var6, var4);
         var6 = (Day)var6.next();
      }

      TimeSeriesCollection var8 = new TimeSeriesCollection();
      var8.addSeries(var0);
      var8.addSeries(var1);
      return var8;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Difference Chart Demo 1", "Time", "Value", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      XYDifferenceRenderer var3 = new XYDifferenceRenderer(Color.green, Color.red, false);
      var3.setRoundXCoordinates(true);
      var2.setDomainCrosshairLockedOnData(true);
      var2.setRangeCrosshairLockedOnData(true);
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      var2.setRenderer(var3);
      DateAxis var4 = new DateAxis("Time");
      var4.setLowerMargin(0.0D);
      var4.setUpperMargin(0.0D);
      var2.setDomainAxis(var4);
      var2.setForegroundAlpha(0.5F);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      DifferenceChartDemo1 var1 = new DifferenceChartDemo1("JFreeChart: DifferenceChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
