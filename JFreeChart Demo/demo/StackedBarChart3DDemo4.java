package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class StackedBarChart3DDemo4 extends ApplicationFrame {

   public StackedBarChart3DDemo4(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(10.0D, "Series 1", "C1");
      var0.addValue(5.0D, "Series 1", "C2");
      var0.addValue(6.0D, "Series 1", "C3");
      var0.addValue(7.0D, "Series 1", "C4");
      var0.addValue(8.0D, "Series 1", "C5");
      var0.addValue(9.0D, "Series 1", "C6");
      var0.addValue(10.0D, "Series 1", "C7");
      var0.addValue(11.0D, "Series 1", "C8");
      var0.addValue(3.0D, "Series 1", "C9");
      var0.addValue(4.0D, "Series 2", "C1");
      var0.addValue(7.0D, "Series 2", "C2");
      var0.addValue(17.0D, "Series 2", "C3");
      var0.addValue(15.0D, "Series 2", "C4");
      var0.addValue(6.0D, "Series 2", "C5");
      var0.addValue(8.0D, "Series 2", "C6");
      var0.addValue(9.0D, "Series 2", "C7");
      var0.addValue(13.0D, "Series 2", "C8");
      var0.addValue(7.0D, "Series 2", "C9");
      var0.addValue(15.0D, "Series 3", "C1");
      var0.addValue(14.0D, "Series 3", "C2");
      var0.addValue(12.0D, "Series 3", "C3");
      var0.addValue(11.0D, "Series 3", "C4");
      var0.addValue(10.0D, "Series 3", "C5");
      var0.addValue(0.0D, "Series 3", "C6");
      var0.addValue(7.0D, "Series 3", "C7");
      var0.addValue(9.0D, "Series 3", "C8");
      var0.addValue(11.0D, "Series 3", "C9");
      var0.addValue(14.0D, "Series 4", "C1");
      var0.addValue(3.0D, "Series 4", "C2");
      var0.addValue(7.0D, "Series 4", "C3");
      var0.addValue(0.0D, "Series 4", "C4");
      var0.addValue(9.0D, "Series 4", "C5");
      var0.addValue(6.0D, "Series 4", "C6");
      var0.addValue(7.0D, "Series 4", "C7");
      var0.addValue(9.0D, "Series 4", "C8");
      var0.addValue(10.0D, "Series 4", "C9");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedBarChart3D("Stacked Bar Chart 3D Demo 4", "Category", "Value", var0, PlotOrientation.HORIZONTAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setNumberFormatOverride(new DecimalFormat("0%"));
      StackedBarRenderer3D var4 = (StackedBarRenderer3D)var2.getRenderer();
      var4.setRenderAsPercentages(true);
      var4.setDrawBarOutline(false);
      var4.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{3}", NumberFormat.getIntegerInstance(), new DecimalFormat("0.0%")));
      var4.setBaseItemLabelsVisible(true);
      var4.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
      var4.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedBarChart3DDemo4 var1 = new StackedBarChart3DDemo4("Stacked Bar Chart 3D Demo 4");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
