package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryMarker;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class CategoryMarkerDemo1 extends ApplicationFrame {

   public CategoryMarkerDemo1(String var1) {
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
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createLineChart("Category Marker Demo 1", "Category", "Count", var0, PlotOrientation.VERTICAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      LineAndShapeRenderer var4 = (LineAndShapeRenderer)var2.getRenderer();
      var4.setSeriesShapesVisible(0, true);
      var4.setDrawOutlines(true);
      var4.setUseFillPaint(true);
      var4.setBaseFillPaint(Color.white);
      CategoryMarker var5 = new CategoryMarker("Category 4", Color.blue, new BasicStroke(1.0F));
      var5.setDrawAsLine(true);
      var5.setLabel("Marker Label");
      var5.setLabelFont(new Font("Dialog", 0, 11));
      var5.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
      var5.setLabelOffset(new RectangleInsets(2.0D, 5.0D, 2.0D, 5.0D));
      var2.addDomainMarker(var5, Layer.BACKGROUND);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      CategoryMarkerDemo1 var1 = new CategoryMarkerDemo1("JFreeChart: CategoryMarkerDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
