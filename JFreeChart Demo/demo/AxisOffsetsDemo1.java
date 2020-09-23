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
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class AxisOffsetsDemo1 extends ApplicationFrame {

   public AxisOffsetsDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      String var0 = "S1";
      String var1 = "S2";
      String var2 = "S3";
      String var3 = "C1";
      String var4 = "C2";
      String var5 = "C3";
      String var6 = "C4";
      String var7 = "C5";
      DefaultCategoryDataset var8 = new DefaultCategoryDataset();
      var8.addValue(1.0D, var0, var3);
      var8.addValue(4.0D, var0, var4);
      var8.addValue(3.0D, var0, var5);
      var8.addValue(5.0D, var0, var6);
      var8.addValue(5.0D, var0, var7);
      var8.addValue(5.0D, var1, var3);
      var8.addValue(7.0D, var1, var4);
      var8.addValue(6.0D, var1, var5);
      var8.addValue(8.0D, var1, var6);
      var8.addValue(4.0D, var1, var7);
      var8.addValue(4.0D, var2, var3);
      var8.addValue(3.0D, var2, var4);
      var8.addValue(2.0D, var2, var5);
      var8.addValue(3.0D, var2, var6);
      var8.addValue(6.0D, var2, var7);
      return var8;
   }

   private static JFreeChart createChart(String var0, CategoryDataset var1) {
      JFreeChart var2 = ChartFactory.createBarChart(var0, "Category", "Value", var1);
      var2.removeLegend();
      CategoryPlot var3 = (CategoryPlot)var2.getPlot();
      var3.setDomainGridlinesVisible(true);
      NumberAxis var4 = (NumberAxis)var3.getRangeAxis();
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      BarRenderer var5 = (BarRenderer)var3.getRenderer();
      var5.setDrawBarOutline(false);
      GradientPaint var6 = new GradientPaint(0.0F, 0.0F, Color.BLUE, 0.0F, 0.0F, new Color(0, 0, 64));
      GradientPaint var7 = new GradientPaint(0.0F, 0.0F, Color.GREEN, 0.0F, 0.0F, new Color(0, 64, 0));
      GradientPaint var8 = new GradientPaint(0.0F, 0.0F, Color.RED, 0.0F, 0.0F, new Color(64, 0, 0));
      var5.setSeriesPaint(0, var6);
      var5.setSeriesPaint(1, var7);
      var5.setSeriesPaint(2, var8);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart("Axis Offsets: 0", createDataset());
      CategoryPlot var1 = (CategoryPlot)var0.getPlot();
      var1.setAxisOffset(RectangleInsets.ZERO_INSETS);
      ChartPanel var2 = new ChartPanel(var0);
      var2.setMinimumDrawWidth(0);
      var2.setMinimumDrawHeight(0);
      JFreeChart var3 = createChart("Axis Offsets: 5", createDataset());
      ChartPanel var4 = new ChartPanel(var3);
      var4.setMinimumDrawWidth(0);
      var4.setMinimumDrawHeight(0);
      CategoryPlot var5 = (CategoryPlot)var3.getPlot();
      var5.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
      DemoPanel var6 = new DemoPanel(new GridLayout(2, 1));
      var6.add(var2);
      var6.add(var4);
      var6.addChart(var0);
      var6.addChart(var3);
      return var6;
   }

   public static void main(String[] var0) {
      AxisOffsetsDemo1 var1 = new AxisOffsetsDemo1("JFreeChart: AxisOffsetsDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
