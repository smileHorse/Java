package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedAreaChartDemo1 extends ApplicationFrame {

   public StackedAreaChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(1.0D, "S1", "C1");
      var0.addValue(2.0D, "S1", "C2");
      var0.addValue(3.0D, "S1", "C3");
      var0.addValue(4.0D, "S1", "C4");
      var0.addValue(5.0D, "S1", "C5");
      var0.addValue(6.0D, "S1", "C6");
      var0.addValue(7.0D, "S1", "C7");
      var0.addValue(8.0D, "S1", "C8");
      var0.addValue(6.0D, "S2", "C1");
      var0.addValue(3.0D, "S2", "C2");
      var0.addValue(4.0D, "S2", "C3");
      var0.addValue(3.0D, "S2", "C4");
      var0.addValue(9.0D, "S2", "C5");
      var0.addValue(7.0D, "S2", "C6");
      var0.addValue(2.0D, "S2", "C7");
      var0.addValue(3.0D, "S2", "C8");
      var0.addValue(1.0D, "S3", "C1");
      var0.addValue(7.0D, "S3", "C2");
      var0.addValue(6.0D, "S3", "C3");
      var0.addValue(7.0D, "S3", "C4");
      var0.addValue(4.0D, "S3", "C5");
      var0.addValue(5.0D, "S3", "C6");
      var0.addValue(3.0D, "S3", "C7");
      var0.addValue(1.0D, "S3", "C8");
      return var0;
   }

   public static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedAreaChart("Stacked Area Chart", "Category", "Value", var0, PlotOrientation.VERTICAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setForegroundAlpha(0.85F);
      CategoryAxis var3 = var2.getDomainAxis();
      var3.setLowerMargin(0.0D);
      var3.setUpperMargin(0.0D);
      var3.setCategoryMargin(0.0D);
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      CategoryItemRenderer var5 = var2.getRenderer();
      var5.setBaseItemLabelsVisible(true);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedAreaChartDemo1 var1 = new StackedAreaChartDemo1("JFreeChart: StackedAreaChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
