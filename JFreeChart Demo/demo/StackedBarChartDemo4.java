package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class StackedBarChartDemo4 extends ApplicationFrame {

   public StackedBarChartDemo4(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(590, 350));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(20.3D, "Product 1 (US)", "Jan 04");
      var0.addValue(27.2D, "Product 1 (US)", "Feb 04");
      var0.addValue(19.7D, "Product 1 (US)", "Mar 04");
      var0.addValue(19.4D, "Product 1 (Europe)", "Jan 04");
      var0.addValue(10.9D, "Product 1 (Europe)", "Feb 04");
      var0.addValue(18.4D, "Product 1 (Europe)", "Mar 04");
      var0.addValue(16.5D, "Product 1 (Asia)", "Jan 04");
      var0.addValue(15.9D, "Product 1 (Asia)", "Feb 04");
      var0.addValue(16.1D, "Product 1 (Asia)", "Mar 04");
      var0.addValue(13.2D, "Product 1 (Middle East)", "Jan 04");
      var0.addValue(14.4D, "Product 1 (Middle East)", "Feb 04");
      var0.addValue(13.7D, "Product 1 (Middle East)", "Mar 04");
      var0.addValue(23.3D, "Product 2 (US)", "Jan 04");
      var0.addValue(16.2D, "Product 2 (US)", "Feb 04");
      var0.addValue(28.7D, "Product 2 (US)", "Mar 04");
      var0.addValue(12.7D, "Product 2 (Europe)", "Jan 04");
      var0.addValue(17.9D, "Product 2 (Europe)", "Feb 04");
      var0.addValue(12.6D, "Product 2 (Europe)", "Mar 04");
      var0.addValue(15.4D, "Product 2 (Asia)", "Jan 04");
      var0.addValue(21.0D, "Product 2 (Asia)", "Feb 04");
      var0.addValue(11.1D, "Product 2 (Asia)", "Mar 04");
      var0.addValue(23.8D, "Product 2 (Middle East)", "Jan 04");
      var0.addValue(23.4D, "Product 2 (Middle East)", "Feb 04");
      var0.addValue(19.3D, "Product 2 (Middle East)", "Mar 04");
      var0.addValue(11.9D, "Product 3 (US)", "Jan 04");
      var0.addValue(31.0D, "Product 3 (US)", "Feb 04");
      var0.addValue(22.7D, "Product 3 (US)", "Mar 04");
      var0.addValue(15.3D, "Product 3 (Europe)", "Jan 04");
      var0.addValue(14.4D, "Product 3 (Europe)", "Feb 04");
      var0.addValue(25.3D, "Product 3 (Europe)", "Mar 04");
      var0.addValue(23.9D, "Product 3 (Asia)", "Jan 04");
      var0.addValue(19.0D, "Product 3 (Asia)", "Feb 04");
      var0.addValue(10.1D, "Product 3 (Asia)", "Mar 04");
      var0.addValue(13.2D, "Product 3 (Middle East)", "Jan 04");
      var0.addValue(15.5D, "Product 3 (Middle East)", "Feb 04");
      var0.addValue(10.1D, "Product 3 (Middle East)", "Mar 04");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedBarChart("Stacked Bar Chart Demo 4", "Category", "Value", var0, PlotOrientation.VERTICAL, true, true, false);
      GroupedStackedBarRenderer var2 = new GroupedStackedBarRenderer();
      KeyToGroupMap var3 = new KeyToGroupMap("G1");
      var3.mapKeyToGroup("Product 1 (US)", "G1");
      var3.mapKeyToGroup("Product 1 (Europe)", "G1");
      var3.mapKeyToGroup("Product 1 (Asia)", "G1");
      var3.mapKeyToGroup("Product 1 (Middle East)", "G1");
      var3.mapKeyToGroup("Product 2 (US)", "G2");
      var3.mapKeyToGroup("Product 2 (Europe)", "G2");
      var3.mapKeyToGroup("Product 2 (Asia)", "G2");
      var3.mapKeyToGroup("Product 2 (Middle East)", "G2");
      var3.mapKeyToGroup("Product 3 (US)", "G3");
      var3.mapKeyToGroup("Product 3 (Europe)", "G3");
      var3.mapKeyToGroup("Product 3 (Asia)", "G3");
      var3.mapKeyToGroup("Product 3 (Middle East)", "G3");
      var2.setSeriesToGroupMap(var3);
      var2.setItemMargin(0.1D);
      var2.setDrawBarOutline(false);
      SubCategoryAxis var4 = new SubCategoryAxis("Product / Month");
      var4.setCategoryMargin(0.05D);
      var4.addSubCategory("Product 1");
      var4.addSubCategory("Product 2");
      var4.addSubCategory("Product 3");
      CategoryPlot var5 = (CategoryPlot)var1.getPlot();
      var5.setDomainAxis(var4);
      var5.setRenderer(var2);
      var5.setFixedLegendItems(createLegendItems());
      ChartUtilities.applyCurrentTheme(var1);
      var4.setSubLabelFont(new Font("Tahoma", 2, 10));
      GradientPaint var6 = new GradientPaint(0.0F, 0.0F, new Color(34, 34, 255), 0.0F, 0.0F, new Color(136, 136, 255));
      var2.setSeriesPaint(0, var6);
      var2.setSeriesPaint(4, var6);
      var2.setSeriesPaint(8, var6);
      GradientPaint var7 = new GradientPaint(0.0F, 0.0F, new Color(34, 255, 34), 0.0F, 0.0F, new Color(136, 255, 136));
      var2.setSeriesPaint(1, var7);
      var2.setSeriesPaint(5, var7);
      var2.setSeriesPaint(9, var7);
      GradientPaint var8 = new GradientPaint(0.0F, 0.0F, new Color(255, 34, 34), 0.0F, 0.0F, new Color(255, 136, 136));
      var2.setSeriesPaint(2, var8);
      var2.setSeriesPaint(6, var8);
      var2.setSeriesPaint(10, var8);
      GradientPaint var9 = new GradientPaint(0.0F, 0.0F, new Color(255, 255, 34), 0.0F, 0.0F, new Color(255, 255, 136));
      var2.setSeriesPaint(3, var9);
      var2.setSeriesPaint(7, var9);
      var2.setSeriesPaint(11, var9);
      var2.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
      return var1;
   }

   private static LegendItemCollection createLegendItems() {
      LegendItemCollection var0 = new LegendItemCollection();
      LegendItem var1 = new LegendItem("US", "-", (String)null, (String)null, Plot.DEFAULT_LEGEND_ITEM_BOX, new Color(34, 34, 255));
      LegendItem var2 = new LegendItem("Europe", "-", (String)null, (String)null, Plot.DEFAULT_LEGEND_ITEM_BOX, new Color(34, 255, 34));
      LegendItem var3 = new LegendItem("Asia", "-", (String)null, (String)null, Plot.DEFAULT_LEGEND_ITEM_BOX, new Color(255, 34, 34));
      LegendItem var4 = new LegendItem("Middle East", "-", (String)null, (String)null, Plot.DEFAULT_LEGEND_ITEM_BOX, new Color(255, 255, 34));
      var0.add(var1);
      var0.add(var2);
      var0.add(var3);
      var0.add(var4);
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedBarChartDemo4 var1 = new StackedBarChartDemo4("Stacked Bar Chart Demo 4");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
