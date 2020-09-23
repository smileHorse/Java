package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryStepRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class CategoryStepChartDemo1 extends ApplicationFrame {

   public CategoryStepChartDemo1(String var1) {
      super(var1);
      ChartPanel var2 = (ChartPanel)createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      var2.setEnforceFileExtensions(false);
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      double[][] var0 = new double[][]{{1.0D, 4.0D, 3.0D, 5.0D, 5.0D, 7.0D, 7.0D, 8.0D}, {5.0D, 7.0D, 6.0D, 8.0D, 4.0D, 4.0D, 2.0D, 1.0D}, {4.0D, 3.0D, 2.0D, 3.0D, 6.0D, 3.0D, 4.0D, 3.0D}};
      CategoryDataset var1 = DatasetUtilities.createCategoryDataset("Series ", "Type ", var0);
      return var1;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      CategoryStepRenderer var1 = new CategoryStepRenderer(true);
      var1.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
      CategoryAxis var2 = new CategoryAxis("Category");
      NumberAxis var3 = new NumberAxis("Value");
      CategoryPlot var4 = new CategoryPlot(var0, var2, var3, var1);
      var4.setRangePannable(true);
      JFreeChart var5 = new JFreeChart("Category Step Chart", var4);
      var4.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
      var4.setDomainGridlinesVisible(true);
      var4.setRangeGridlinesVisible(true);
      var2.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
      var2.setLowerMargin(0.0D);
      var2.setUpperMargin(0.0D);
      var2.addCategoryLabelToolTip("Type 1", "The first type.");
      var2.addCategoryLabelToolTip("Type 2", "The second type.");
      var2.addCategoryLabelToolTip("Type 3", "The third type.");
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var3.setLabelAngle(0.0D);
      ChartUtilities.applyCurrentTheme(var5);
      return var5;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      CategoryStepChartDemo1 var1 = new CategoryStepChartDemo1("JFreeChart : CategoryStepChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
