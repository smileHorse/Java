package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChartDemo6 extends ApplicationFrame {

   public StackedBarChartDemo6(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      long var1 = 86400000L;
      var0.addValue((double)(3L * var1), "Series 1", "Category 1");
      var0.addValue((double)(1L * var1), "Series 2", "Category 1");
      var0.addValue((double)(2L * var1), "Series 3", "Category 1");
      var0.addValue((double)(4L * var1), "Series 1", "Category 2");
      var0.addValue((double)(5L * var1), "Series 2", "Category 2");
      var0.addValue((double)(1L * var1), "Series 3", "Category 2");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedBarChart("Stacked Bar Chart Demo 6", "Category", "Value", var0, PlotOrientation.HORIZONTAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      StackedBarRenderer var3 = (StackedBarRenderer)var2.getRenderer();
      var3.setDrawBarOutline(false);
      long var4 = System.currentTimeMillis();
      var3.setBase((double)var4);
      DateAxis var6 = new DateAxis("Date");
      var6.setLowerMargin(0.0D);
      var2.setRangeAxis(var6);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedBarChartDemo6 var1 = new StackedBarChartDemo6("Stacked Bar Chart Demo 6");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
