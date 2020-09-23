package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo6 extends ApplicationFrame {

   public BarChartDemo6(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(83.0D, "First", "Factor 1");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart((String)null, "Category", "Score (%)", var0);
      var1.removeLegend();
      var1.setBackgroundPaint(Color.YELLOW);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setOrientation(PlotOrientation.HORIZONTAL);
      var2.setInsets(new RectangleInsets(0.0D, 0.0D, 0.0D, 0.0D));
      var2.setAxisOffset(RectangleInsets.ZERO_INSETS);
      var2.setRangeGridlinesVisible(false);
      CategoryAxis var3 = var2.getDomainAxis();
      var3.setLowerMargin(0.2D);
      var3.setUpperMargin(0.2D);
      var3.setVisible(false);
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setRange(0.0D, 100.0D);
      var4.setVisible(false);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      BarChartDemo6 var1 = new BarChartDemo6("JFreeChart: BarChartDemo6.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
