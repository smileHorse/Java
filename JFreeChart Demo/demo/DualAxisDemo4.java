package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DualAxisDemo4 extends ApplicationFrame {

   public DualAxisDemo4(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart() {
      CategoryDataset var0 = createDataset1();
      JFreeChart var1 = ChartFactory.createBarChart3D("Dual Axis Chart", "Category", "Value", var0, PlotOrientation.VERTICAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setDomainAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
      var2.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
      CategoryItemRenderer var3 = var2.getRenderer();
      var3.setSeriesPaint(0, Color.red);
      var3.setSeriesPaint(1, Color.yellow);
      var3.setSeriesPaint(2, Color.green);
      CategoryDataset var4 = createDataset2();
      NumberAxis3D var5 = new NumberAxis3D("Secondary");
      var2.setRangeAxis(1, var5);
      var2.setDataset(1, var4);
      var2.mapDatasetToRangeAxis(1, 1);
      LineRenderer3D var6 = new LineRenderer3D();
      var6.setSeriesPaint(0, Color.blue);
      var2.setRenderer(1, var6);
      var2.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static CategoryDataset createDataset1() {
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

   private static CategoryDataset createDataset2() {
      String var0 = "Fourth";
      String var1 = "Category 1";
      String var2 = "Category 2";
      String var3 = "Category 3";
      String var4 = "Category 4";
      String var5 = "Category 5";
      DefaultCategoryDataset var6 = new DefaultCategoryDataset();
      var6.addValue(15.0D, var0, var1);
      var6.addValue(24.0D, var0, var2);
      var6.addValue(31.0D, var0, var3);
      var6.addValue(25.0D, var0, var4);
      var6.addValue(56.0D, var0, var5);
      return var6;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      DualAxisDemo4 var1 = new DualAxisDemo4("JFreeChart: DualAxisDemo4.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
