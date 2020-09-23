package demo;

import java.awt.Dimension;
import java.awt.Font;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.SortOrder;

public class ParetoChartDemo1 extends ApplicationFrame {

   public ParetoChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(550, 270));
      this.setContentPane(var2);
   }

   public static JFreeChart createChart(CategoryDataset[] var0) {
      JFreeChart var1 = ChartFactory.createBarChart("TIOBE Index of Programming Languages", (String)null, "Index Value", var0[0]);
      var1.addSubtitle(new TextTitle("As at August 2013"));
      var1.removeLegend();
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      CategoryAxis var3 = var2.getDomainAxis();
      var3.setLowerMargin(0.02D);
      var3.setUpperMargin(0.02D);
      var3.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      LineAndShapeRenderer var5 = new LineAndShapeRenderer();
      NumberAxis var6 = new NumberAxis("Percent");
      var6.setNumberFormatOverride(NumberFormat.getPercentInstance());
      var2.setRangeAxis(1, var6);
      var2.setDataset(1, var0[1]);
      var2.setRenderer(1, var5);
      var2.mapDatasetToRangeAxis(1, 1);
      var2.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
      ChartUtilities.applyCurrentTheme(var1);
      TextTitle var7 = new TextTitle("http://www.tiobe.com/index.php/content/paperinfo/tpci/index.html", new Font("Monospaced", 0, 10));
      var7.setPosition(RectangleEdge.BOTTOM);
      var7.setHorizontalAlignment(HorizontalAlignment.RIGHT);
      var1.addSubtitle(var7);
      return var1;
   }

   public static CategoryDataset[] createDatasets() {
      DefaultKeyedValues var0 = new DefaultKeyedValues();
      var0.addValue("C", 15.974D);
      var0.addValue("C++", 9.371D);
      var0.addValue("C#", 6.117D);
      var0.addValue("Java", 15.978D);
      var0.addValue("Javascript", 2.093D);
      var0.addValue("Obj-C", 8.082D);
      var0.addValue("PHP", 6.694D);
      var0.addValue("Python", 3.603D);
      var0.addValue("Ruby", 2.067D);
      var0.addValue("VB", 3.873D);
      var0.sortByValues(SortOrder.DESCENDING);
      KeyedValues var1 = DataUtilities.getCumulativePercentages(var0);
      CategoryDataset var2 = DatasetUtilities.createCategoryDataset("Languages", var0);
      CategoryDataset var3 = DatasetUtilities.createCategoryDataset("Cumulative", var1);
      return new CategoryDataset[]{var2, var3};
   }

   public static JPanel createDemoPanel() {
      CategoryDataset[] var0 = createDatasets();
      JFreeChart var1 = createChart(var0);
      return new ChartPanel(var1);
   }

   public static void main(String[] var0) {
      ParetoChartDemo1 var1 = new ParetoChartDemo1("JFreeChart: ParetoChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
