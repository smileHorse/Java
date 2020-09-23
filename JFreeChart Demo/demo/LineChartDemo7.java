package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

public class LineChartDemo7 extends ApplicationFrame {

   public LineChartDemo7(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(21.0D, "Series 1", "Category 1");
      var0.addValue(50.0D, "Series 1", "Category 2");
      var0.addValue(152.0D, "Series 1", "Category 3");
      var0.addValue(184.0D, "Series 1", "Category 4");
      var0.addValue(299.0D, "Series 1", "Category 5");
      var0.addValue(275.0D, "Series 2", "Category 1");
      var0.addValue(121.0D, "Series 2", "Category 2");
      var0.addValue(98.0D, "Series 2", "Category 3");
      var0.addValue(103.0D, "Series 2", "Category 4");
      var0.addValue(210.0D, "Series 2", "Category 5");
      var0.addValue(198.0D, "Series 3", "Category 1");
      var0.addValue(165.0D, "Series 3", "Category 2");
      var0.addValue(55.0D, "Series 3", "Category 3");
      var0.addValue(34.0D, "Series 3", "Category 4");
      var0.addValue(77.0D, "Series 3", "Category 5");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createLineChart("Line Chart Demo 7", "Category", "Count", var0, PlotOrientation.VERTICAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
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
      LineChartDemo7 var1 = new LineChartDemo7("JFreeChart: LineChartDemo7.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
