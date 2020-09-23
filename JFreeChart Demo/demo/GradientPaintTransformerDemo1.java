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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class GradientPaintTransformerDemo1 extends ApplicationFrame {

   public GradientPaintTransformerDemo1(String var1) {
      super(var1);
      this.setContentPane(createDemoPanel());
   }

   private static JFreeChart createChart(String var0, CategoryDataset var1) {
      JFreeChart var2 = ChartFactory.createBarChart(var0, (String)null, "Value", var1, PlotOrientation.VERTICAL, true, true, false);
      CategoryPlot var3 = (CategoryPlot)var2.getPlot();
      BarRenderer var4 = (BarRenderer)var3.getRenderer();
      var4.setItemMargin(0.02D);
      return var2;
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(7.0D, "Series 1", "Category 1");
      var0.addValue(5.0D, "Series 2", "Category 1");
      return var0;
   }

   public static JPanel createDemoPanel() {
      DemoPanel var0 = new DemoPanel(new GridLayout(2, 2));
      var0.setPreferredSize(new Dimension(800, 600));
      CategoryDataset var1 = createDataset();
      JFreeChart var2 = createChart("Type: VERTICAL", var1);
      CategoryPlot var3 = (CategoryPlot)var2.getPlot();
      BarRenderer var4 = (BarRenderer)var3.getRenderer();
      var4.setBarPainter(new StandardBarPainter());
      var4.setDrawBarOutline(false);
      var4.setSeriesPaint(0, new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, Color.yellow));
      var4.setSeriesPaint(1, new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.green));
      var4.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
      ChartPanel var5 = new ChartPanel(var2);
      var0.add(var5);
      JFreeChart var6 = createChart("Type: HORIZONTAL", var1);
      CategoryPlot var7 = (CategoryPlot)var6.getPlot();
      BarRenderer var8 = (BarRenderer)var7.getRenderer();
      var8.setBarPainter(new StandardBarPainter());
      var8.setDrawBarOutline(false);
      var8.setSeriesPaint(0, new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, Color.yellow));
      var8.setSeriesPaint(1, new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.green));
      var8.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
      ChartPanel var9 = new ChartPanel(var6);
      var0.add(var9);
      JFreeChart var10 = createChart("Type: CENTER_VERTICAL", var1);
      CategoryPlot var11 = (CategoryPlot)var10.getPlot();
      BarRenderer var12 = (BarRenderer)var11.getRenderer();
      var12.setBarPainter(new StandardBarPainter());
      var12.setDrawBarOutline(false);
      var12.setSeriesPaint(0, new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, Color.yellow));
      var12.setSeriesPaint(1, new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.green));
      var12.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
      ChartPanel var13 = new ChartPanel(var10);
      var0.add(var13);
      JFreeChart var14 = createChart("Type: CENTER_HORIZONTAL", var1);
      CategoryPlot var15 = (CategoryPlot)var14.getPlot();
      BarRenderer var16 = (BarRenderer)var15.getRenderer();
      var16.setBarPainter(new StandardBarPainter());
      var16.setDrawBarOutline(false);
      var16.setSeriesPaint(0, new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, Color.yellow));
      var16.setSeriesPaint(1, new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.green));
      var16.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL));
      ChartPanel var17 = new ChartPanel(var14);
      var0.add(var17);
      var0.addChart(var2);
      var0.addChart(var6);
      var0.addChart(var10);
      var0.addChart(var14);
      return var0;
   }

   public static void main(String[] var0) {
      GradientPaintTransformerDemo1 var1 = new GradientPaintTransformerDemo1("JFreeChart: GradientPaintTransformerDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
