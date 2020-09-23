package demo;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LineChartDemo5 extends ApplicationFrame {

   public LineChartDemo5(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      String var0 = "First";
      String var1 = "Second";
      String var2 = "Third";
      String var3 = "Type 1";
      String var4 = "Type 2";
      String var5 = "Type 3";
      String var6 = "Type 4";
      String var7 = "Type 5";
      String var8 = "Type 6";
      String var9 = "Type 7";
      String var10 = "Type 8";
      DefaultCategoryDataset var11 = new DefaultCategoryDataset();
      var11.addValue(1.0D, var0, var3);
      var11.addValue(4.0D, var0, var4);
      var11.addValue(3.0D, var0, var5);
      var11.addValue(5.0D, var0, var6);
      var11.addValue(5.0D, var0, var7);
      var11.addValue(7.0D, var0, var8);
      var11.addValue(7.0D, var0, var9);
      var11.addValue(8.0D, var0, var10);
      var11.addValue(5.0D, var1, var3);
      var11.addValue(7.0D, var1, var4);
      var11.addValue(6.0D, var1, var5);
      var11.addValue(8.0D, var1, var6);
      var11.addValue(4.0D, var1, var7);
      var11.addValue(4.0D, var1, var8);
      var11.addValue(2.0D, var1, var9);
      var11.addValue(1.0D, var1, var10);
      var11.addValue(4.0D, var2, var3);
      var11.addValue(3.0D, var2, var4);
      var11.addValue(2.0D, var2, var5);
      var11.addValue(3.0D, var2, var6);
      var11.addValue(6.0D, var2, var7);
      var11.addValue(3.0D, var2, var8);
      var11.addValue(4.0D, var2, var9);
      var11.addValue(3.0D, var2, var10);
      return var11;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createLineChart("Line Chart Demo 5", "Type", "Value", var0, PlotOrientation.VERTICAL, true, true, false);
      Shape[] var2 = new Shape[3];
      int[] var3 = new int[]{-3, 3, -3};
      int[] var4 = new int[]{-3, 0, 3};
      var2[0] = new Polygon(var3, var4, 3);
      var2[1] = new Double(-2.0D, -3.0D, 3.0D, 6.0D);
      var3 = new int[]{-3, 3, 3};
      var4 = new int[]{0, -3, 3};
      var2[2] = new Polygon(var3, var4, 3);
      DefaultDrawingSupplier var5 = new DefaultDrawingSupplier(DefaultDrawingSupplier.DEFAULT_PAINT_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE, DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE, var2);
      CategoryPlot var6 = (CategoryPlot)var1.getPlot();
      var6.setOrientation(PlotOrientation.HORIZONTAL);
      var6.setDrawingSupplier(var5);
      var6.getRenderer().setSeriesStroke(0, new BasicStroke(2.0F, 1, 1, 1.0F, new float[]{10.0F, 6.0F}, 0.0F));
      var6.getRenderer().setSeriesStroke(1, new BasicStroke(2.0F, 1, 1, 1.0F, new float[]{6.0F, 6.0F}, 0.0F));
      var6.getRenderer().setSeriesStroke(2, new BasicStroke(2.0F, 1, 1, 1.0F, new float[]{2.0F, 6.0F}, 0.0F));
      LineAndShapeRenderer var7 = (LineAndShapeRenderer)var6.getRenderer();
      var7.setBaseShapesVisible(true);
      var7.setBaseItemLabelsVisible(true);
      var7.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
      NumberAxis var8 = (NumberAxis)var6.getRangeAxis();
      var8.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var8.setAutoRangeIncludesZero(false);
      var8.setUpperMargin(0.12D);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      LineChartDemo5 var1 = new LineChartDemo5("JFreeChart: LineChartDemo5.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
