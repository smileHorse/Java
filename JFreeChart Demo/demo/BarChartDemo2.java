package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class BarChartDemo2 extends ApplicationFrame {

   public BarChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      double[][] var0 = new double[][]{{1.0D, 43.0D, 35.0D, 58.0D, 54.0D, 77.0D, 71.0D, 89.0D}, {54.0D, 75.0D, 63.0D, 83.0D, 43.0D, 46.0D, 27.0D, 13.0D}, {41.0D, 33.0D, 22.0D, 34.0D, 62.0D, 32.0D, 42.0D, 34.0D}};
      return DatasetUtilities.createCategoryDataset("Series ", "Factor ", var0);
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart("Bar Chart Demo 2", "Category", "Score (%)", var0);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setOrientation(PlotOrientation.HORIZONTAL);
      var2.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setRange(0.0D, 100.0D);
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      BarRenderer var4 = (BarRenderer)var2.getRenderer();
      GradientPaint var5 = new GradientPaint(0.0F, 0.0F, new Color(0, 0, 128), 0.0F, 0.0F, Color.blue);
      GradientPaint var6 = new GradientPaint(0.0F, 0.0F, new Color(0, 128, 0), 0.0F, 0.0F, Color.green);
      GradientPaint var7 = new GradientPaint(0.0F, 0.0F, new Color(128, 0, 0), 0.0F, 0.0F, Color.red);
      var4.setSeriesPaint(0, var5);
      var4.setSeriesPaint(1, var6);
      var4.setSeriesPaint(2, var7);
      var4.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
      var4.setDrawBarOutline(false);
      var4.setLegendItemToolTipGenerator(new StandardCategorySeriesLabelGenerator("Tooltip: {0}"));
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      BarChartDemo2 var1 = new BarChartDemo2("JFreeChart: BarChartDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
