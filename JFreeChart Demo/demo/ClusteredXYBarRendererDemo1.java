package demo;

import demo.DemoPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.ClusteredXYBarRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class ClusteredXYBarRendererDemo1 extends ApplicationFrame {

   public ClusteredXYBarRendererDemo1(String var1) {
      super(var1);
      this.setContentPane(createDemoPanel());
   }

   private static JFreeChart createChart(String var0, IntervalXYDataset var1) {
      JFreeChart var2 = ChartFactory.createXYBarChart(var0, (String)null, true, "Y", var1, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var3 = (XYPlot)var2.getPlot();
      ClusteredXYBarRenderer var4 = new ClusteredXYBarRenderer(0.2D, false);
      var3.setRenderer(var4);
      return var2;
   }

   private static IntervalXYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Series 1");
      var0.add(new Day(1, 1, 2003), 54.3D);
      var0.add(new Day(2, 1, 2003), 20.3D);
      var0.add(new Day(3, 1, 2003), 43.4D);
      var0.add(new Day(4, 1, 2003), -12.0D);
      TimeSeries var1 = new TimeSeries("Series 2");
      var1.add(new Day(1, 1, 2003), 8.0D);
      var1.add(new Day(2, 1, 2003), 16.0D);
      var1.add(new Day(3, 1, 2003), 21.0D);
      var1.add(new Day(4, 1, 2003), 5.0D);
      TimeSeriesCollection var2 = new TimeSeriesCollection();
      var2.addSeries(var0);
      var2.addSeries(var1);
      return var2;
   }

   public static JPanel createDemoPanel() {
      DemoPanel var0 = new DemoPanel(new GridLayout(2, 2));
      var0.setPreferredSize(new Dimension(800, 600));
      IntervalXYDataset var1 = createDataset();
      JFreeChart var2 = createChart("Vertical", var1);
      XYPlot var3 = (XYPlot)var2.getPlot();
      XYBarRenderer var4 = (XYBarRenderer)var3.getRenderer();
      var4.setDrawBarOutline(false);
      var4.setSeriesPaint(0, new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, Color.yellow));
      var4.setSeriesPaint(1, new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.green));
      var4.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
      ChartPanel var5 = new ChartPanel(var2);
      var0.add(var5);
      JFreeChart var6 = createChart("Vertical / Inverted Axis", var1);
      XYPlot var7 = (XYPlot)var6.getPlot();
      XYBarRenderer var8 = (XYBarRenderer)var7.getRenderer();
      var8.setDrawBarOutline(false);
      var8.setSeriesPaint(0, new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, Color.yellow));
      var8.setSeriesPaint(1, new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.green));
      var8.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
      var7.getDomainAxis().setInverted(true);
      ChartPanel var9 = new ChartPanel(var6);
      var0.add(var9);
      JFreeChart var10 = createChart("Horizontal", var1);
      XYPlot var11 = (XYPlot)var10.getPlot();
      var11.setOrientation(PlotOrientation.HORIZONTAL);
      XYBarRenderer var12 = (XYBarRenderer)var11.getRenderer();
      var12.setDrawBarOutline(false);
      var12.setSeriesPaint(0, new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, Color.yellow));
      var12.setSeriesPaint(1, new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.green));
      var12.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
      ChartPanel var13 = new ChartPanel(var10);
      var0.add(var13);
      JFreeChart var14 = createChart("Horizontal / Inverted Axis", var1);
      XYPlot var15 = (XYPlot)var14.getPlot();
      var15.setOrientation(PlotOrientation.HORIZONTAL);
      XYBarRenderer var16 = (XYBarRenderer)var15.getRenderer();
      var16.setDrawBarOutline(false);
      var16.setSeriesPaint(0, new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, Color.yellow));
      var16.setSeriesPaint(1, new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.green));
      var16.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL));
      var15.getDomainAxis().setInverted(true);
      ChartPanel var17 = new ChartPanel(var14);
      var0.add(var17);
      var0.addChart(var2);
      var0.addChart(var6);
      var0.addChart(var10);
      var0.addChart(var14);
      return var0;
   }

   public static void main(String[] var0) {
      ClusteredXYBarRendererDemo1 var1 = new ClusteredXYBarRendererDemo1("JFreeChart: ClusteredXYBarRendererDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
