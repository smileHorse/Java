package demo;

import demo.Animator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo10 extends ApplicationFrame {

   public BarChartDemo10(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static DefaultCategoryDataset createDataset() {
      String var0 = "First";
      String var1 = "Second";
      String var2 = "Third";
      String var3 = "Category 1";
      String var4 = "Category 2";
      String var5 = "Category 3";
      String var6 = "Category 4";
      String var7 = "Category 5";
      DefaultCategoryDataset var8 = new DefaultCategoryDataset();
      var8.addValue(31.0D, var0, var3);
      var8.addValue(44.0D, var0, var4);
      var8.addValue(33.0D, var0, var5);
      var8.addValue(45.0D, var0, var6);
      var8.addValue(35.0D, var0, var7);
      var8.addValue(45.0D, var1, var3);
      var8.addValue(37.0D, var1, var4);
      var8.addValue(46.0D, var1, var5);
      var8.addValue(38.0D, var1, var6);
      var8.addValue(44.0D, var1, var7);
      var8.addValue(34.0D, var2, var3);
      var8.addValue(43.0D, var2, var4);
      var8.addValue(32.0D, var2, var5);
      var8.addValue(43.0D, var2, var6);
      var8.addValue(36.0D, var2, var7);
      return var8;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart("Bar Chart Demo 10", "Category", "Value", var0);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setDomainGridlinesVisible(true);
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      BarRenderer var4 = (BarRenderer)var2.getRenderer();
      var4.setDrawBarOutline(false);
      GradientPaint var5 = new GradientPaint(0.0F, 0.0F, Color.BLUE, 0.0F, 0.0F, new Color(0, 0, 64));
      GradientPaint var6 = new GradientPaint(0.0F, 0.0F, Color.GREEN, 0.0F, 0.0F, new Color(0, 64, 0));
      GradientPaint var7 = new GradientPaint(0.0F, 0.0F, Color.RED, 0.0F, 0.0F, new Color(64, 0, 0));
      var4.setSeriesPaint(0, var5);
      var4.setSeriesPaint(1, var6);
      var4.setSeriesPaint(2, var7);
      CategoryAxis var8 = var2.getDomainAxis();
      var8.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.5235987755982988D));
      return var1;
   }

   public static JPanel createDemoPanel() {
      DefaultCategoryDataset var0 = createDataset();
      JFreeChart var1 = createChart(var0);
      Animator var2 = new Animator(var0);
      var2.start();
      return new ChartPanel(var1);
   }

   public static void main(String[] var0) {
      BarChartDemo10 var1 = new BarChartDemo10("JFreeChart: BarChartDemo10.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
