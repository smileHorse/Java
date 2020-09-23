package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo15 extends ApplicationFrame {

   public TimeSeriesDemo15(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Bug Report Submissions for Java", "Date", "Evaluation ID", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      XYItemRenderer var3 = var2.getRenderer();
      if(var3 instanceof XYLineAndShapeRenderer) {
         XYLineAndShapeRenderer var4 = (XYLineAndShapeRenderer)var3;
         var4.setBaseShapesVisible(true);
         var4.setBaseShapesFilled(true);
         var4.setUseFillPaint(true);
         var4.setBaseFillPaint(Color.white);
      }

      DateAxis var5 = (DateAxis)var2.getDomainAxis();
      var5.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Bugs");
      var0.add(new Day(27, 6, 2005), 478474.0D);
      var0.add(new Day(24, 1, 2006), 633804.0D);
      var0.add(new Day(28, 4, 2006), 694096.0D);
      var0.add(new Day(12, 5, 2006), 704680.0D);
      var0.add(new Day(16, 5, 2006), 709599.0D);
      var0.add(new Day(21, 6, 2006), 734754.0D);
      var0.add(new Day(27, 7, 2006), 760008.0D);
      TimeSeriesCollection var1 = new TimeSeriesCollection();
      var1.addSeries(var0);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      TimeSeriesDemo15 var1 = new TimeSeriesDemo15("Time Series Demo 15");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
