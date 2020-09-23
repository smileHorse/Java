package demo;

import java.awt.Dimension;
import java.awt.geom.GeneralPath;
import java.awt.geom.Ellipse2D.Double;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo9 extends ApplicationFrame {

   public TimeSeriesDemo9(String var1) {
      super(var1);
      XYDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var4);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Time Series Demo 9", "Date", "Price Per Unit", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      XYItemRenderer var3 = var2.getRenderer();
      if(var3 instanceof XYLineAndShapeRenderer) {
         XYLineAndShapeRenderer var4 = (XYLineAndShapeRenderer)var3;
         var4.setBaseShapesVisible(true);
         var4.setBaseShapesFilled(true);
         var4.setSeriesShape(0, new Double(-3.0D, -3.0D, 6.0D, 6.0D));
         var4.setSeriesShape(1, new java.awt.geom.Rectangle2D.Double(-3.0D, -3.0D, 6.0D, 6.0D));
         GeneralPath var5 = new GeneralPath();
         var5.moveTo(0.0F, -3.0F);
         var5.lineTo(3.0F, 3.0F);
         var5.lineTo(-3.0F, 3.0F);
         var5.closePath();
         var4.setSeriesShape(2, var5);
         GeneralPath var6 = new GeneralPath();
         var6.moveTo(-1.0F, -3.0F);
         var6.lineTo(1.0F, -3.0F);
         var6.lineTo(1.0F, -1.0F);
         var6.lineTo(3.0F, -1.0F);
         var6.lineTo(3.0F, 1.0F);
         var6.lineTo(1.0F, 1.0F);
         var6.lineTo(1.0F, 3.0F);
         var6.lineTo(-1.0F, 3.0F);
         var6.lineTo(-1.0F, 1.0F);
         var6.lineTo(-3.0F, 1.0F);
         var6.lineTo(-3.0F, -1.0F);
         var6.lineTo(-1.0F, -1.0F);
         var6.closePath();
         var4.setSeriesShape(3, var6);
      }

      var2.getDomainAxis().setVisible(false);
      var2.getRangeAxis().setVisible(false);
      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeriesCollection var0 = new TimeSeriesCollection();

      for(int var1 = 0; var1 < 4; ++var1) {
         var0.addSeries(createTimeSeries(var1, 10));
      }

      return var0;
   }

   private static TimeSeries createTimeSeries(int var0, int var1) {
      TimeSeries var2 = new TimeSeries("Series " + var0);
      Day var3 = new Day();

      for(int var4 = 0; var4 < var1; ++var4) {
         var2.add(var3, Math.random());
         var3 = (Day)var3.next();
      }

      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      TimeSeriesDemo9 var1 = new TimeSeriesDemo9("Time Series Demo 9");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
