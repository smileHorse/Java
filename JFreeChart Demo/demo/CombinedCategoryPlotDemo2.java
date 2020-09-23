package demo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedRangeCategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CombinedCategoryPlotDemo2 extends ApplicationFrame {

   public CombinedCategoryPlotDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static CategoryDataset createDataset1() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      String var1 = "First";
      String var2 = "Second";
      String var3 = "Type 1";
      String var4 = "Type 2";
      String var5 = "Type 3";
      String var6 = "Type 4";
      String var7 = "Type 5";
      String var8 = "Type 6";
      String var9 = "Type 7";
      String var10 = "Type 8";
      var0.addValue(1.0D, var1, var3);
      var0.addValue(4.0D, var1, var4);
      var0.addValue(3.0D, var1, var5);
      var0.addValue(5.0D, var1, var6);
      var0.addValue(5.0D, var1, var7);
      var0.addValue(7.0D, var1, var8);
      var0.addValue(7.0D, var1, var9);
      var0.addValue(8.0D, var1, var10);
      var0.addValue(5.0D, var2, var3);
      var0.addValue(7.0D, var2, var4);
      var0.addValue(6.0D, var2, var5);
      var0.addValue(8.0D, var2, var6);
      var0.addValue(4.0D, var2, var7);
      var0.addValue(4.0D, var2, var8);
      var0.addValue(2.0D, var2, var9);
      var0.addValue(1.0D, var2, var10);
      return var0;
   }

   public static CategoryDataset createDataset2() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      String var1 = "Third";
      String var2 = "Fourth";
      String var3 = "Sector 1";
      String var4 = "Sector 2";
      String var5 = "Sector 3";
      String var6 = "Sector 4";
      var0.addValue(11.0D, var1, var3);
      var0.addValue(14.0D, var1, var4);
      var0.addValue(13.0D, var1, var5);
      var0.addValue(15.0D, var1, var6);
      var0.addValue(15.0D, var2, var3);
      var0.addValue(17.0D, var2, var4);
      var0.addValue(16.0D, var2, var5);
      var0.addValue(18.0D, var2, var6);
      return var0;
   }

   private static JFreeChart createChart() {
      CategoryDataset var0 = createDataset1();
      CategoryAxis var1 = new CategoryAxis("Class 1");
      var1.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
      var1.setMaximumCategoryLabelWidthRatio(5.0F);
      LineAndShapeRenderer var2 = new LineAndShapeRenderer();
      var2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
      CategoryPlot var3 = new CategoryPlot(var0, var1, (ValueAxis)null, var2);
      var3.setDomainGridlinesVisible(true);
      CategoryDataset var4 = createDataset2();
      CategoryAxis var5 = new CategoryAxis("Class 2");
      var5.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
      var5.setMaximumCategoryLabelWidthRatio(5.0F);
      BarRenderer var6 = new BarRenderer();
      var6.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
      CategoryPlot var7 = new CategoryPlot(var4, var5, (ValueAxis)null, var6);
      var7.setDomainGridlinesVisible(true);
      NumberAxis var8 = new NumberAxis("Value");
      CombinedRangeCategoryPlot var9 = new CombinedRangeCategoryPlot(var8);
      var9.setRangePannable(true);
      var9.add(var3, 3);
      var9.add(var7, 2);
      var9.setOrientation(PlotOrientation.HORIZONTAL);
      JFreeChart var10 = new JFreeChart("Combined Range Category Plot Demo", new Font("SansSerif", 1, 12), var9, true);
      ChartUtilities.applyCurrentTheme(var10);
      return var10;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      String var1 = "JFreeChart: CombinedCategoryPlotDemo2.java";
      CombinedCategoryPlotDemo2 var2 = new CombinedCategoryPlotDemo2(var1);
      var2.pack();
      RefineryUtilities.centerFrameOnScreen(var2);
      var2.setVisible(true);
   }
}
