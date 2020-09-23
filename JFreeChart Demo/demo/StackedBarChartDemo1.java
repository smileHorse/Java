package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChartDemo1 extends ApplicationFrame {

   public StackedBarChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(197.0D, "Agricultural", "Brazil");
      var0.addValue(64.0D, "Domestic", "Brazil");
      var0.addValue(57.0D, "Industrial", "Brazil");
      var0.addValue(339.0D, "Agricultural", "Indonesia");
      var0.addValue(30.0D, "Domestic", "Indonesia");
      var0.addValue(4.0D, "Industrial", "Indonesia");
      var0.addValue(279.0D, "Agricultural", "China");
      var0.addValue(27.0D, "Domestic", "China");
      var0.addValue(107.0D, "Industrial", "China");
      var0.addValue(92.0D, "Agricultural", "Germany");
      var0.addValue(55.0D, "Domestic", "Germany");
      var0.addValue(313.0D, "Industrial", "Germany");
      var0.addValue(96.0D, "Agricultural", "Russia");
      var0.addValue(102.0D, "Domestic", "Russia");
      var0.addValue(337.0D, "Industrial", "Russia");
      var0.addValue(403.0D, "Agricultural", "Turkey");
      var0.addValue(82.0D, "Domestic", "Turkey");
      var0.addValue(60.0D, "Industrial", "Turkey");
      var0.addValue(536.0D, "Agricultural", "Bangladesh");
      var0.addValue(17.0D, "Domestic", "Bangladesh");
      var0.addValue(6.0D, "Industrial", "Bangladesh");
      var0.addValue(508.0D, "Agricultural", "India");
      var0.addValue(47.0D, "Domestic", "India");
      var0.addValue(30.0D, "Industrial", "India");
      var0.addValue(428.0D, "Agricultural", "Japan");
      var0.addValue(138.0D, "Domestic", "Japan");
      var0.addValue(124.0D, "Industrial", "Japan");
      var0.addValue(325.0D, "Agricultural", "Italy");
      var0.addValue(130.0D, "Domestic", "Italy");
      var0.addValue(268.0D, "Industrial", "Italy");
      var0.addValue(569.0D, "Agricultural", "Mexico");
      var0.addValue(126.0D, "Domestic", "Mexico");
      var0.addValue(37.0D, "Industrial", "Mexico");
      var0.addValue(576.0D, "Agricultural", "Vietnam");
      var0.addValue(68.0D, "Domestic", "Vietnam");
      var0.addValue(203.0D, "Industrial", "Vietnam");
      var0.addValue(794.0D, "Agricultural", "Egypt");
      var0.addValue(74.0D, "Domestic", "Egypt");
      var0.addValue(55.0D, "Industrial", "Egypt");
      var0.addValue(954.0D, "Agricultural", "Iran");
      var0.addValue(21.0D, "Domestic", "Iran");
      var0.addValue(73.0D, "Industrial", "Iran");
      var0.addValue(1029.0D, "Agricultural", "Pakistan");
      var0.addValue(21.0D, "Domestic", "Pakistan");
      var0.addValue(21.0D, "Industrial", "Pakistan");
      var0.addValue(1236.0D, "Agricultural", "Thailand");
      var0.addValue(26.0D, "Domestic", "Thailand");
      var0.addValue(26.0D, "Industrial", "Thailand");
      var0.addValue(165.0D, "Agricultural", "Canada");
      var0.addValue(274.0D, "Domestic", "Canada");
      var0.addValue(947.0D, "Industrial", "Canada");
      var0.addValue(1363.0D, "Agricultural", "Iraq");
      var0.addValue(44.0D, "Domestic", "Iraq");
      var0.addValue(74.0D, "Industrial", "Iraq");
      var0.addValue(656.0D, "Agricultural", "US");
      var0.addValue(208.0D, "Domestic", "US");
      var0.addValue(736.0D, "Industrial", "US");
      var0.addValue(2040.0D, "Agricultural", "Uzbekistan");
      var0.addValue(110.0D, "Domestic", "Uzbekistan");
      var0.addValue(44.0D, "Industrial", "Uzbekistan");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedBarChart("Freshwater Usage By Country", "Country", "Value", var0);
      var1.addSubtitle(new TextTitle("Source: http://en.wikipedia.org/wiki/Peak_water#Water_supply"));
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      CategoryAxis var3 = var2.getDomainAxis();
      var3.setLowerMargin(0.01D);
      var3.setUpperMargin(0.01D);
      var3.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
      AttributedString var4 = new AttributedString("m3/person/year");
      var4.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_ULTRABOLD);
      var4.addAttribute(TextAttribute.SIZE, Integer.valueOf(14));
      var4.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 1, 2);
      var2.getRangeAxis().setAttributedLabel(var4);
      StackedBarRenderer var5 = (StackedBarRenderer)var2.getRenderer();
      var5.setDrawBarOutline(false);
      var5.setBarPainter(new StandardBarPainter());
      var5.setBaseItemLabelsVisible(true);
      var5.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
      var5.setBaseItemLabelPaint(Color.WHITE);
      var5.setSeriesPaint(0, new Color(0, 55, 122));
      var5.setSeriesPaint(1, new Color(24, 123, 58));
      var5.setSeriesPaint(2, Color.RED);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedBarChartDemo1 var1 = new StackedBarChartDemo1("JFreeChart: StackedBarChartDemo1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
