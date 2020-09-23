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
import org.jfree.data.time.Month;
import org.jfree.data.time.MovingAverage;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MovingAverageDemo1 extends ApplicationFrame {

   public MovingAverageDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("L&G European Index Trust");
      var0.add(new Month(2, 2001), 181.8D);
      var0.add(new Month(3, 2001), 167.3D);
      var0.add(new Month(4, 2001), 153.8D);
      var0.add(new Month(5, 2001), 167.6D);
      var0.add(new Month(6, 2001), 158.8D);
      var0.add(new Month(7, 2001), 148.3D);
      var0.add(new Month(8, 2001), 153.9D);
      var0.add(new Month(9, 2001), 142.7D);
      var0.add(new Month(10, 2001), 123.2D);
      var0.add(new Month(11, 2001), 131.8D);
      var0.add(new Month(12, 2001), 139.6D);
      var0.add(new Month(1, 2002), 142.9D);
      var0.add(new Month(2, 2002), 138.7D);
      var0.add(new Month(3, 2002), 137.3D);
      var0.add(new Month(4, 2002), 143.9D);
      var0.add(new Month(5, 2002), 139.8D);
      var0.add(new Month(6, 2002), 137.0D);
      var0.add(new Month(7, 2002), 132.8D);
      TimeSeries var1 = MovingAverage.createMovingAverage(var0, "Six Month Moving Average", 6, 0);
      TimeSeriesCollection var2 = new TimeSeriesCollection();
      var2.addSeries(var0);
      var2.addSeries(var1);
      return var2;
   }

   public static JFreeChart createChart(XYDataset var0) {
      String var1 = "Legal & General Unit Trust Prices";
      JFreeChart var2 = ChartFactory.createTimeSeriesChart(var1, "Date", "Price Per Unit", var0, true, true, false);
      XYPlot var3 = (XYPlot)var2.getPlot();
      XYItemRenderer var4 = var3.getRenderer();
      if(var4 instanceof XYLineAndShapeRenderer) {
         XYLineAndShapeRenderer var5 = (XYLineAndShapeRenderer)var4;
         var5.setBaseShapesVisible(false);
         var5.setSeriesShapesVisible(0, true);
         var5.setUseFillPaint(true);
         var5.setBaseFillPaint(Color.white);
      }

      DateAxis var6 = (DateAxis)var3.getDomainAxis();
      var6.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      MovingAverageDemo1 var1 = new MovingAverageDemo1("JFreeChart: MovingAverageDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
