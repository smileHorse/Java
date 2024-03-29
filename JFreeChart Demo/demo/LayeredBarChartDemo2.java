package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LayeredBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.SortOrder;

public class LayeredBarChartDemo2 extends ApplicationFrame {

   public LayeredBarChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      String var0 = "First";
      String var1 = "Second";
      String var2 = "Third";
      String var3 = "Category 1";
      String var4 = "Category 2";
      String var5 = "Category 3";
      String var6 = "Category 4";
      String var7 = "Category 5";
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

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart("Layered Bar Chart Demo 2", "Category", "Value", var0, PlotOrientation.HORIZONTAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setDomainGridlinesVisible(true);
      var2.setRangePannable(true);
      var2.setRangeZeroBaselineVisible(true);
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      LayeredBarRenderer var4 = new LayeredBarRenderer();
      var4.setDrawBarOutline(false);
      var2.setRenderer(var4);
      var2.setRowRenderingOrder(SortOrder.DESCENDING);
      GradientPaint var5 = new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, new Color(0, 0, 64));
      GradientPaint var6 = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
      GradientPaint var7 = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, new Color(64, 0, 0));
      var4.setSeriesPaint(0, var5);
      var4.setSeriesPaint(1, var6);
      var4.setSeriesPaint(2, var7);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      LayeredBarChartDemo2 var1 = new LayeredBarChartDemo2("JFreeChart: LayeredBarChartDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
