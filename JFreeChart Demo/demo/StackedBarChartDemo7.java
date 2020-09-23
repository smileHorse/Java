package demo;

import java.awt.Dimension;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChartDemo7 extends ApplicationFrame {

   public StackedBarChartDemo7(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(32.4D, "Series 1", "Category 1");
      var0.addValue(17.8D, "Series 2", "Category 1");
      var0.addValue(27.7D, "Series 3", "Category 1");
      var0.addValue(43.2D, "Series 1", "Category 2");
      var0.addValue(15.6D, "Series 2", "Category 2");
      var0.addValue(18.3D, "Series 3", "Category 2");
      var0.addValue(23.0D, "Series 1", "Category 3");
      var0.addValue(111.3D, "Series 2", "Category 3");
      var0.addValue(25.5D, "Series 3", "Category 3");
      var0.addValue(13.0D, "Series 1", "Category 4");
      var0.addValue(11.8D, "Series 2", "Category 4");
      var0.addValue(29.5D, "Series 3", "Category 4");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedBarChart("Stacked Bar Chart Demo 7", "Category", "Value", var0, PlotOrientation.VERTICAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setNumberFormatOverride(NumberFormat.getPercentInstance());
      StackedBarRenderer var4 = (StackedBarRenderer)var2.getRenderer();
      var4.setRenderAsPercentages(true);
      var4.setDrawBarOutline(false);
      var4.setBaseItemLabelsVisible(true);
      var4.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedBarChartDemo7 var1 = new StackedBarChartDemo7("Stacked Bar Chart Demo 7");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
