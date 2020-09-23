package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryLabelWidthType;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;
import org.jfree.util.SortOrder;

public class BarChart3DDemo2 extends ApplicationFrame {

   public BarChart3DDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(23.0D, "Series 1", "London");
      var0.addValue(14.0D, "Series 1", "New York");
      var0.addValue(14.0D, "Series 1", "Istanbul");
      var0.addValue(14.0D, "Series 1", "Cairo");
      var0.addValue(13.0D, "Series 2", "London");
      var0.addValue(19.0D, "Series 2", "New York");
      var0.addValue(19.0D, "Series 2", "Istanbul");
      var0.addValue(19.0D, "Series 2", "Cairo");
      var0.addValue(7.0D, "Series 3", "London");
      var0.addValue(9.0D, "Series 3", "New York");
      var0.addValue(9.0D, "Series 3", "Istanbul");
      var0.addValue(9.0D, "Series 3", "Cairo");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart3D("3D Bar Chart Demo 2", "Category", "Value", var0);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setOrientation(PlotOrientation.HORIZONTAL);
      var2.setRowRenderingOrder(SortOrder.DESCENDING);
      var2.setColumnRenderingOrder(SortOrder.DESCENDING);
      var2.setForegroundAlpha(1.0F);
      var2.setRangePannable(true);
      CategoryAxis var3 = var2.getDomainAxis();
      CategoryLabelPositions var4 = var3.getCategoryLabelPositions();
      CategoryLabelPosition var5 = new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, 0.0D, CategoryLabelWidthType.RANGE, 0.3F);
      var3.setCategoryLabelPositions(CategoryLabelPositions.replaceLeftPosition(var4, var5));
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      BarChart3DDemo2 var1 = new BarChart3DDemo2("JFreeChart: BarChart3DDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
