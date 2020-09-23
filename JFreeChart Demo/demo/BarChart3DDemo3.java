package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChart3DDemo3 extends ApplicationFrame {

   public BarChart3DDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(25.0D, "Series 1", "Category 1");
      var0.addValue(34.0D, "Series 1", "Category 2");
      var0.addValue(19.0D, "Series 2", "Category 1");
      var0.addValue(29.0D, "Series 2", "Category 2");
      var0.addValue(41.0D, "Series 3", "Category 1");
      var0.addValue(33.0D, "Series 3", "Category 2");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart3D("3D Bar Chart Demo", "Category", "Value", var0);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      CategoryAxis var3 = var2.getDomainAxis();
      var3.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.39269908169872414D));
      CategoryItemRenderer var4 = var2.getRenderer();
      var4.setBaseItemLabelsVisible(true);
      BarRenderer var5 = (BarRenderer)var4;
      var5.setItemMargin(0.2D);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      BarChart3DDemo3 var1 = new BarChart3DDemo3("JFreeChart: BarChart3DDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
