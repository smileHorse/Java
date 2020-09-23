package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChartDemo2 extends ApplicationFrame {

   public StackedBarChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(81.0D, "Against all torture", "Italy");
      var0.addValue(72.0D, "Against all torture", "Great Britain");
      var0.addValue(58.0D, "Against all torture", "USA");
      var0.addValue(48.0D, "Against all torture", "Israel");
      var0.addValue(43.0D, "Against all torture", "Russia");
      var0.addValue(23.0D, "Against all torture", "India");
      var0.addValue(59.0D, "Against all torture", "Average (*)");
      var0.addValue(5.0D, "-", "Italy");
      var0.addValue(4.0D, "-", "Great Britain");
      var0.addValue(6.0D, "-", "USA");
      var0.addValue(9.0D, "-", "Israel");
      var0.addValue(20.0D, "-", "Russia");
      var0.addValue(45.0D, "-", "India");
      var0.addValue(12.0D, "-", "Average (*)");
      var0.addValue(14.0D, "Some degree permissible", "Italy");
      var0.addValue(24.0D, "Some degree permissible", "Great Britain");
      var0.addValue(36.0D, "Some degree permissible", "USA");
      var0.addValue(43.0D, "Some degree permissible", "Israel");
      var0.addValue(37.0D, "Some degree permissible", "Russia");
      var0.addValue(32.0D, "Some degree permissible", "India");
      var0.addValue(29.0D, "Some degree permissible", "Average (*)");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedBarChart("Public Opinion : Torture of Prisoners", "Country", "%", var0, PlotOrientation.HORIZONTAL, false, true, false);
      var1.getTitle().setMargin(2.0D, 0.0D, 0.0D, 0.0D);
      TextTitle var2 = new TextTitle("Source: http://news.bbc.co.uk/1/hi/world/6063386.stm", new Font("Dialog", 0, 11));
      var2.setPosition(RectangleEdge.BOTTOM);
      var2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
      var2.setMargin(0.0D, 0.0D, 4.0D, 4.0D);
      var1.addSubtitle(var2);
      TextTitle var3 = new TextTitle("(*) Across 27,000 respondents in 25 countries", new Font("Dialog", 0, 11));
      var3.setPosition(RectangleEdge.BOTTOM);
      var3.setHorizontalAlignment(HorizontalAlignment.RIGHT);
      var3.setMargin(4.0D, 0.0D, 2.0D, 4.0D);
      var1.addSubtitle(var3);
      CategoryPlot var4 = (CategoryPlot)var1.getPlot();
      LegendItemCollection var5 = new LegendItemCollection();
      var5.add(new LegendItem("Against all torture", (String)null, (String)null, (String)null, new Double(-6.0D, -3.0D, 12.0D, 6.0D), Color.green));
      var5.add(new LegendItem("Some degree permissible", (String)null, (String)null, (String)null, new Double(-6.0D, -3.0D, 12.0D, 6.0D), Color.red));
      var4.setFixedLegendItems(var5);
      var4.setInsets(new RectangleInsets(5.0D, 5.0D, 5.0D, 20.0D));
      LegendTitle var6 = new LegendTitle(var4);
      var6.setPosition(RectangleEdge.BOTTOM);
      var1.addSubtitle(var6);
      var4.setDomainGridlinesVisible(true);
      NumberAxis var7 = (NumberAxis)var4.getRangeAxis();
      var7.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var7.setUpperMargin(0.0D);
      BarRenderer var8 = (BarRenderer)var4.getRenderer();
      var8.setDrawBarOutline(false);
      ChartUtilities.applyCurrentTheme(var1);
      GradientPaint var9 = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
      Color var10 = new Color(0, 0, 0, 0);
      GradientPaint var11 = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, new Color(64, 0, 0));
      var8.setSeriesPaint(0, var9);
      var8.setSeriesPaint(1, var10);
      var8.setSeriesPaint(2, var11);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedBarChartDemo2 var1 = new StackedBarChartDemo2("JFreeChart: StackedBarChartDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
