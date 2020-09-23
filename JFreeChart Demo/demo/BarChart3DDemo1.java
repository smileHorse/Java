package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChart3DDemo1 extends ApplicationFrame {

   public BarChart3DDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(10.0D, "Series 1", "Category 1");
      var0.addValue(4.0D, "Series 1", "Category 2");
      var0.addValue(15.0D, "Series 1", "Category 3");
      var0.addValue(14.0D, "Series 1", "Category 4");
      var0.addValue(-5.0D, "Series 2", "Category 1");
      var0.addValue(-7.0D, "Series 2", "Category 2");
      var0.addValue(14.0D, "Series 2", "Category 3");
      var0.addValue(-3.0D, "Series 2", "Category 4");
      var0.addValue(6.0D, "Series 3", "Category 1");
      var0.addValue(17.0D, "Series 3", "Category 2");
      var0.addValue(-12.0D, "Series 3", "Category 3");
      var0.addValue(7.0D, "Series 3", "Category 4");
      var0.addValue(7.0D, "Series 4", "Category 1");
      var0.addValue(15.0D, "Series 4", "Category 2");
      var0.addValue(11.0D, "Series 4", "Category 3");
      var0.addValue(0.0D, "Series 4", "Category 4");
      var0.addValue(-8.0D, "Series 5", "Category 1");
      var0.addValue(-6.0D, "Series 5", "Category 2");
      var0.addValue(10.0D, "Series 5", "Category 3");
      var0.addValue(-9.0D, "Series 5", "Category 4");
      var0.addValue(9.0D, "Series 6", "Category 1");
      var0.addValue(8.0D, "Series 6", "Category 2");
      var0.addValue(0.0D, "Series 6", "Category 3");
      var0.addValue(6.0D, "Series 6", "Category 4");
      var0.addValue(-10.0D, "Series 7", "Category 1");
      var0.addValue(9.0D, "Series 7", "Category 2");
      var0.addValue(7.0D, "Series 7", "Category 3");
      var0.addValue(7.0D, "Series 7", "Category 4");
      var0.addValue(11.0D, "Series 8", "Category 1");
      var0.addValue(13.0D, "Series 8", "Category 2");
      var0.addValue(9.0D, "Series 8", "Category 3");
      var0.addValue(9.0D, "Series 8", "Category 4");
      var0.addValue(-3.0D, "Series 9", "Category 1");
      var0.addValue(7.0D, "Series 9", "Category 2");
      var0.addValue(11.0D, "Series 9", "Category 3");
      var0.addValue(-10.0D, "Series 9", "Category 4");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart3D("3D Bar Chart Demo", "Category", "Value", var0);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setOutlineVisible(false);
      var2.setDomainGridlinesVisible(true);
      CategoryAxis var3 = var2.getDomainAxis();
      var3.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.39269908169872414D));
      var3.setCategoryMargin(0.0D);
      BarRenderer3D var4 = (BarRenderer3D)var2.getRenderer();
      var4.setDrawBarOutline(false);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setPreferredSize(new Dimension(600, 400));
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      BarChart3DDemo1 var1 = new BarChart3DDemo1("JFreeChart: BarChart3DDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
