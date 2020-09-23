package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DeviationRenderer;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DeviationRendererDemo3 extends ApplicationFrame {

   public DeviationRendererDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static XYDataset createDataset() {
      YIntervalSeries var0 = new YIntervalSeries("Band A");
      YIntervalSeries var1 = new YIntervalSeries("Band B");
      YIntervalSeries var2 = new YIntervalSeries("Band C");
      Object var3 = new Quarter(1, 2005);
      double var4 = 0.0D;

      for(int var6 = 0; var6 <= 12; ++var6) {
         var4 += (Math.random() - 0.5D) * 15.0D;
         var0.add((double)((RegularTimePeriod)var3).getMiddleMillisecond(), var4, var4 + 10.0D, Math.max(50.0D, var4 + 30.0D));
         var1.add((double)((RegularTimePeriod)var3).getMiddleMillisecond(), var4, var4 - 10.0D, var4 + 10.0D);
         var2.add((double)((RegularTimePeriod)var3).getMiddleMillisecond(), var4, Math.min(-50.0D, var4 - 30.0D), var4 - 10.0D);
         var3 = ((RegularTimePeriod)var3).next();
      }

      YIntervalSeriesCollection var7 = new YIntervalSeriesCollection();
      var7.addSeries(var0);
      var7.addSeries(var1);
      var7.addSeries(var2);
      return var7;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("DeviationRenderer - Demo 3", "X", "Y", var0, PlotOrientation.VERTICAL, false, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      DeviationRenderer var3 = new DeviationRenderer(false, false);
      var3.setSeriesStroke(0, new BasicStroke(3.0F, 1, 1));
      var3.setSeriesStroke(0, new BasicStroke(3.0F, 1, 1));
      var3.setSeriesStroke(1, new BasicStroke(3.0F, 1, 1));
      var3.setSeriesFillPaint(0, Color.red);
      var3.setSeriesFillPaint(1, Color.orange);
      var3.setSeriesFillPaint(2, Color.green);
      var2.setRenderer(var3);
      DateAxis var4 = new DateAxis("Date");
      var4.setLowerMargin(0.0D);
      var4.setUpperMargin(0.0D);
      var2.setDomainAxis(var4);
      NumberAxis var5 = (NumberAxis)var2.getRangeAxis();
      var5.setRange(-40.0D, 40.0D);
      var5.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      DeviationRendererDemo3 var1 = new DeviationRendererDemo3("JFreeChart : DeviationRendererDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
