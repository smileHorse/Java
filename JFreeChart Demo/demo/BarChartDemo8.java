package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo8 extends ApplicationFrame {

   public BarChartDemo8(String var1) {
      super(var1);
      CategoryDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var4);
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
      JFreeChart var1 = ChartFactory.createBarChart("Bar Chart Demo 8", "Category", "Value", var0);
      var1.removeLegend();
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var3.setUpperMargin(0.15D);
      CategoryItemRenderer var4 = var2.getRenderer();
      var4.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
      var4.setSeriesItemLabelsVisible(0, Boolean.TRUE);
      CategoryAxis var5 = var2.getDomainAxis();
      var5.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      BarChartDemo8 var1 = new BarChartDemo8("JFreeChart: BarChartDemo8.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
