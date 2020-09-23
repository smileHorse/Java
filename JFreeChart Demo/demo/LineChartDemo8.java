package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

public class LineChartDemo8 extends ApplicationFrame {

   public LineChartDemo8(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(0.0D, "Series 1", "Category 1");
      var0.addValue(2.0D, "Series 1", "Category 2");
      var0.addValue(1.0D, "Series 1", "Category 3");
      var0.addValue(3.0D, "Series 1", "Category 4");
      var0.addValue(5.0D, "Series 1", "Category 5");
      var0.addValue(2.0D, "Series 2", "Category 1");
      var0.addValue(4.0D, "Series 2", "Category 2");
      var0.addValue(4.0D, "Series 2", "Category 3");
      var0.addValue(5.0D, "Series 2", "Category 4");
      var0.addValue(2.0D, "Series 2", "Category 5");
      var0.addValue(1.0D, "Series 3", "Category 1");
      var0.addValue(3.0D, "Series 3", "Category 2");
      var0.addValue(5.0D, "Series 3", "Category 3");
      var0.addValue(2.0D, "Series 3", "Category 4");
      var0.addValue(0.0D, "Series 3", "Category 5");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createLineChart("Line Chart Demo 8", "Category", "Count", var0, PlotOrientation.VERTICAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      SymbolAxis var3 = new SymbolAxis("Group", new String[]{"A", "B", "C", "D", "E", "F"});
      var2.setRangeAxis(var3);
      ChartUtilities.applyCurrentTheme(var1);
      LineAndShapeRenderer var4 = (LineAndShapeRenderer)var2.getRenderer();
      var4.setSeriesShapesVisible(0, true);
      var4.setSeriesShapesVisible(1, false);
      var4.setSeriesShapesVisible(2, true);
      var4.setSeriesLinesVisible(2, false);
      var4.setSeriesShape(2, ShapeUtilities.createDiamond(4.0F));
      var4.setDrawOutlines(true);
      var4.setUseFillPaint(true);
      var4.setBaseFillPaint(Color.white);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      LineChartDemo8 var1 = new LineChartDemo8("JFreeChart: LineChartDemo8.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
