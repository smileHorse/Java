package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.AreaRendererEndType;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.VerticalAlignment;
import org.jfree.util.UnitType;

public class AreaChartDemo1 extends ApplicationFrame {

   public AreaChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(1.0D, "Series 1", "Type 1");
      var0.addValue(4.0D, "Series 1", "Type 2");
      var0.addValue(3.0D, "Series 1", "Type 3");
      var0.addValue(5.0D, "Series 1", "Type 4");
      var0.addValue(5.0D, "Series 1", "Type 5");
      var0.addValue(7.0D, "Series 1", "Type 6");
      var0.addValue(7.0D, "Series 1", "Type 7");
      var0.addValue(8.0D, "Series 1", "Type 8");
      var0.addValue(5.0D, "Series 2", "Type 1");
      var0.addValue(7.0D, "Series 2", "Type 2");
      var0.addValue(6.0D, "Series 2", "Type 3");
      var0.addValue(8.0D, "Series 2", "Type 4");
      var0.addValue(4.0D, "Series 2", "Type 5");
      var0.addValue(4.0D, "Series 2", "Type 6");
      var0.addValue(2.0D, "Series 2", "Type 7");
      var0.addValue(1.0D, "Series 2", "Type 8");
      var0.addValue(4.0D, "Series 3", "Type 1");
      var0.addValue(3.0D, "Series 3", "Type 2");
      var0.addValue(2.0D, "Series 3", "Type 3");
      var0.addValue(3.0D, "Series 3", "Type 4");
      var0.addValue(6.0D, "Series 3", "Type 5");
      var0.addValue(3.0D, "Series 3", "Type 6");
      var0.addValue(4.0D, "Series 3", "Type 7");
      var0.addValue(3.0D, "Series 3", "Type 8");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createAreaChart("Area Chart", "Category", "Value", var0);
      TextTitle var2 = new TextTitle("An area chart demonstration.  We use this subtitle as an example of what happens when you get a really long title or subtitle.");
      var2.setPosition(RectangleEdge.TOP);
      var2.setPadding(new RectangleInsets(UnitType.RELATIVE, 0.05D, 0.05D, 0.05D, 0.05D));
      var2.setVerticalAlignment(VerticalAlignment.BOTTOM);
      var1.addSubtitle(var2);
      CategoryPlot var3 = (CategoryPlot)var1.getPlot();
      var3.setForegroundAlpha(0.5F);
      var3.setDomainGridlinesVisible(true);
      AreaRenderer var4 = (AreaRenderer)var3.getRenderer();
      var4.setEndType(AreaRendererEndType.LEVEL);
      CategoryAxis var5 = var3.getDomainAxis();
      var5.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
      var5.setLowerMargin(0.0D);
      var5.setUpperMargin(0.0D);
      var5.addCategoryLabelToolTip("Type 1", "The first type.");
      var5.addCategoryLabelToolTip("Type 2", "The second type.");
      var5.addCategoryLabelToolTip("Type 3", "The third type.");
      NumberAxis var6 = (NumberAxis)var3.getRangeAxis();
      var6.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var6.setLabelAngle(0.0D);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      AreaChartDemo1 var1 = new AreaChartDemo1("JFreeChart: AreaChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
