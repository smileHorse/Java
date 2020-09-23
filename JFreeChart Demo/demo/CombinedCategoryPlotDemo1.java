package demo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class CombinedCategoryPlotDemo1 extends ApplicationFrame {

   public CombinedCategoryPlotDemo1(String var1) {
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
      String var3 = "Type 1";
      String var4 = "Type 2";
      String var5 = "Type 3";
      String var6 = "Type 4";
      String var7 = "Type 5";
      String var8 = "Type 6";
      String var9 = "Type 7";
      String var10 = "Type 8";
      var0.addValue(11.0D, var1, var3);
      var0.addValue(14.0D, var1, var4);
      var0.addValue(13.0D, var1, var5);
      var0.addValue(15.0D, var1, var6);
      var0.addValue(15.0D, var1, var7);
      var0.addValue(17.0D, var1, var8);
      var0.addValue(17.0D, var1, var9);
      var0.addValue(18.0D, var1, var10);
      var0.addValue(15.0D, var2, var3);
      var0.addValue(17.0D, var2, var4);
      var0.addValue(16.0D, var2, var5);
      var0.addValue(18.0D, var2, var6);
      var0.addValue(14.0D, var2, var7);
      var0.addValue(14.0D, var2, var8);
      var0.addValue(12.0D, var2, var9);
      var0.addValue(11.0D, var2, var10);
      return var0;
   }

   private static JFreeChart createChart() {
      CategoryDataset var0 = createDataset1();
      NumberAxis var1 = new NumberAxis("Value");
      var1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      LineAndShapeRenderer var2 = new LineAndShapeRenderer();
      var2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
      CategoryPlot var3 = new CategoryPlot(var0, (CategoryAxis)null, var1, var2);
      var3.setDomainGridlinesVisible(true);
      CategoryDataset var4 = createDataset2();
      NumberAxis var5 = new NumberAxis("Value");
      var5.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      BarRenderer var6 = new BarRenderer();
      var6.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
      CategoryPlot var7 = new CategoryPlot(var4, (CategoryAxis)null, var5, var6);
      var7.setDomainGridlinesVisible(true);
      CategoryAxis var8 = new CategoryAxis("Category");
      CombinedDomainCategoryPlot var9 = new CombinedDomainCategoryPlot(var8);
      var9.add(var3, 2);
      var9.add(var7, 1);
      JFreeChart var10 = new JFreeChart("Combined Domain Category Plot Demo", new Font("SansSerif", 1, 12), var9, true);
      ChartUtilities.applyCurrentTheme(var10);
      var3.setAxisOffset(RectangleInsets.ZERO_INSETS);
      var7.setAxisOffset(RectangleInsets.ZERO_INSETS);
      return var10;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      String var1 = "JFreeChart: CombinedCategoryPlotDemo1.java";
      CombinedCategoryPlotDemo1 var2 = new CombinedCategoryPlotDemo1(var1);
      var2.pack();
      RefineryUtilities.centerFrameOnScreen(var2);
      var2.setVisible(true);
   }
}
