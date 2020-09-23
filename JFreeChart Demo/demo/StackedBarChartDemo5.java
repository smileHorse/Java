package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class StackedBarChartDemo5 extends ApplicationFrame {

   public StackedBarChartDemo5(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(3396.0D, "S1", "C1");
      var0.addValue(1580.0D, "S2", "C1");
      var0.addValue(76.0D, "S3", "C1");
      var0.addValue(10100.0D, "S4", "C1");
      var0.addValue(3429.0D, "S1", "C2");
      var0.addValue(1562.0D, "S2", "C2");
      var0.addValue(61.0D, "S3", "C2");
      var0.addValue(-10100.0D, "S4", "C2");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedBarChart("Stacked Bar Chart Demo 5", "Category", "Value", var0, PlotOrientation.VERTICAL, true, true, false);
      GroupedStackedBarRenderer var2 = new GroupedStackedBarRenderer();
      KeyToGroupMap var3 = new KeyToGroupMap("G1");
      var3.mapKeyToGroup("S1", "G1");
      var3.mapKeyToGroup("S2", "G1");
      var3.mapKeyToGroup("S3", "G2");
      var3.mapKeyToGroup("S4", "G3");
      var2.setSeriesToGroupMap(var3);
      var2.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
      var2.setBaseItemLabelsVisible(true);
      var2.setPositiveItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
      var2.setItemMargin(0.1D);
      SubCategoryAxis var4 = new SubCategoryAxis("Category / Group");
      var4.setCategoryMargin(0.05D);
      var4.addSubCategory("G1");
      var4.addSubCategory("G2");
      var4.addSubCategory("G3");
      CategoryPlot var5 = (CategoryPlot)var1.getPlot();
      var5.setDomainAxis(var4);
      var5.setRenderer(var2);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedBarChartDemo5 var1 = new StackedBarChartDemo5("Stacked Bar Chart Demo 5");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
