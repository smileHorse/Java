package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StatisticalBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class StatisticalBarChartDemo1 extends ApplicationFrame {

   private static final long serialVersionUID = 1L;


   public StatisticalBarChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultStatisticalCategoryDataset var0 = new DefaultStatisticalCategoryDataset();
      var0.add(10.0D, 2.4D, "Row 1", "Column 1");
      var0.add(15.0D, 4.4D, "Row 1", "Column 2");
      var0.add(13.0D, 2.1D, "Row 1", "Column 3");
      var0.add(7.0D, 1.3D, "Row 1", "Column 4");
      var0.add(22.0D, 2.4D, "Row 2", "Column 1");
      var0.add(18.0D, 4.4D, "Row 2", "Column 2");
      var0.add(28.0D, 2.1D, "Row 2", "Column 3");
      var0.add(17.0D, 1.3D, "Row 2", "Column 4");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createLineChart("Statistical Bar Chart Demo 1", "Type", "Value", var0, PlotOrientation.VERTICAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var3.setAutoRangeIncludesZero(false);
      StatisticalBarRenderer var4 = new StatisticalBarRenderer();
      var4.setDrawBarOutline(false);
      var4.setErrorIndicatorPaint(Color.black);
      var4.setIncludeBaseInRange(false);
      var2.setRenderer(var4);
      ChartUtilities.applyCurrentTheme(var1);
      var4.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
      var4.setBaseItemLabelsVisible(true);
      var4.setBaseItemLabelPaint(Color.yellow);
      var4.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.INSIDE6, TextAnchor.BOTTOM_CENTER));
      GradientPaint var5 = new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, new Color(0, 0, 64));
      GradientPaint var6 = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
      var4.setSeriesPaint(0, var5);
      var4.setSeriesPaint(1, var6);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StatisticalBarChartDemo1 var1 = new StatisticalBarChartDemo1("JFreeChart: StatisticalBarChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
