package demo;

import java.awt.Dimension;
import java.awt.Font;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class ItemLabelDemo3 extends ApplicationFrame {

   public ItemLabelDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(51.0D, "Series 1", "Apples");
      var0.addValue(44.3D, "Series 1", "Bananas");
      var0.addValue(93.0D, "Series 1", "Oranges");
      var0.addValue(35.6D, "Series 1", "Pears");
      var0.addValue(75.1D, "Series 1", "Plums");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart("Item Label Demo 3", "Category", "Value", var0, PlotOrientation.VERTICAL, false, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setRangePannable(true);
      var2.setRangeZeroBaselineVisible(true);
      CategoryAxis var3 = var2.getDomainAxis();
      var3.setVisible(false);
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setUpperMargin(0.15D);
      CategoryItemRenderer var5 = var2.getRenderer();
      StandardCategoryItemLabelGenerator var6 = new StandardCategoryItemLabelGenerator("{1}", NumberFormat.getInstance());
      var5.setBaseItemLabelGenerator(var6);
      var5.setBaseItemLabelFont(new Font("SansSerif", 0, 12));
      var5.setBaseItemLabelsVisible(true);
      var5.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, -1.5707963267948966D));
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      ItemLabelDemo3 var1 = new ItemLabelDemo3("JFreeChart: ItemLabelDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
