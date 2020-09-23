package demo;

import java.awt.BasicStroke;
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
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo12 extends ApplicationFrame {

   public TimeSeriesDemo12(String var1) {
      super(var1);
      XYDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      var4.setMouseZoomable(true);
      this.setContentPane(var4);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Sample Chart", "Date", "Value", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(false);
      XYItemRenderer var3 = var2.getRenderer();
      if(var3 instanceof XYLineAndShapeRenderer) {
         XYLineAndShapeRenderer var4 = (XYLineAndShapeRenderer)var3;
         var4.setBaseShapesVisible(true);
         var4.setBaseShapesFilled(true);
         var3.setSeriesStroke(0, new BasicStroke(2.0F));
         var3.setSeriesStroke(1, new BasicStroke(2.0F));
      }

      DateAxis var5 = (DateAxis)var2.getDomainAxis();
      var5.setDateFormatOverride(new SimpleDateFormat("hh:mma"));
      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeriesCollection var0 = new TimeSeriesCollection();
      TimeSeries var1 = new TimeSeries("Series 1");
      var1.add(new Minute(0, 0, 7, 12, 2003), 1.2D);
      var1.add(new Minute(30, 12, 7, 12, 2003), 3.0D);
      var1.add(new Minute(15, 14, 7, 12, 2003), 8.0D);
      TimeSeries var2 = new TimeSeries("Series 2");
      var2.add(new Minute(0, 3, 7, 12, 2003), 0.0D);
      var2.add(new Minute(30, 9, 7, 12, 2003), 0.0D);
      var2.add(new Minute(15, 10, 7, 12, 2003), 0.0D);
      var0.addSeries(var1);
      var0.addSeries(var2);
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      TimeSeriesDemo12 var1 = new TimeSeriesDemo12("Time Series Demo 12");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
