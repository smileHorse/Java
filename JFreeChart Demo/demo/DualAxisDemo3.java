package demo;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class DualAxisDemo3 extends ApplicationFrame {

   public DualAxisDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      this.setContentPane(var2);
   }

   private static JFreeChart createChart() {
      CategoryDataset var0 = createDataset1();
      JFreeChart var1 = ChartFactory.createBarChart("Dual Axis Chart", "Category", "Value", var0, PlotOrientation.HORIZONTAL, true, true, false);
      LegendTitle var2 = (LegendTitle)var1.getSubtitle(0);
      var2.setPosition(RectangleEdge.LEFT);
      CategoryPlot var3 = (CategoryPlot)var1.getPlot();
      var3.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
      var3.getDomainAxis().setMaximumCategoryLabelWidthRatio(10.0F);
      CategoryDataset var4 = createDataset2();
      NumberAxis var5 = new NumberAxis("Secondary");
      var3.setRangeAxis(1, var5);
      var3.setDataset(1, var4);
      var3.mapDatasetToRangeAxis(1, 1);
      var3.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
      LineAndShapeRenderer var6 = new LineAndShapeRenderer();
      var3.setRenderer(1, var6);
      var3.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
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
      String var8 = "Category 6";
      String var9 = "Category 7";
      String var10 = "Category 8";
      DefaultCategoryDataset var11 = new DefaultCategoryDataset();
      var11.addValue(1.0D, var0, var3);
      var11.addValue(4.0D, var0, var4);
      var11.addValue(3.0D, var0, var5);
      var11.addValue(5.0D, var0, var6);
      var11.addValue(5.0D, var0, var7);
      var11.addValue(7.0D, var0, var8);
      var11.addValue(7.0D, var0, var9);
      var11.addValue(8.0D, var0, var10);
      var11.addValue(5.0D, var1, var3);
      var11.addValue(7.0D, var1, var4);
      var11.addValue(6.0D, var1, var5);
      var11.addValue(8.0D, var1, var6);
      var11.addValue(4.0D, var1, var7);
      var11.addValue(4.0D, var1, var8);
      var11.addValue(2.0D, var1, var9);
      var11.addValue(1.0D, var1, var10);
      var11.addValue(4.0D, var2, var3);
      var11.addValue(3.0D, var2, var4);
      var11.addValue(2.0D, var2, var5);
      var11.addValue(3.0D, var2, var6);
      var11.addValue(6.0D, var2, var7);
      var11.addValue(3.0D, var2, var8);
      var11.addValue(4.0D, var2, var9);
      var11.addValue(3.0D, var2, var10);
      return var11;
   }

   private static CategoryDataset createDataset2() {
      String var0 = "Fourth";
      String var1 = "Category 1";
      String var2 = "Category 2";
      String var3 = "Category 3";
      String var4 = "Category 4";
      String var5 = "Category 5";
      String var6 = "Category 6";
      String var7 = "Category 7";
      String var8 = "Category 8";
      DefaultCategoryDataset var9 = new DefaultCategoryDataset();
      var9.addValue(15.0D, var0, var1);
      var9.addValue(24.0D, var0, var2);
      var9.addValue(31.0D, var0, var3);
      var9.addValue(25.0D, var0, var4);
      var9.addValue(56.0D, var0, var5);
      var9.addValue(37.0D, var0, var6);
      var9.addValue(77.0D, var0, var7);
      var9.addValue(18.0D, var0, var8);
      return var9;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      DualAxisDemo3 var1 = new DualAxisDemo3("JFreeChart: DualAxisDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
