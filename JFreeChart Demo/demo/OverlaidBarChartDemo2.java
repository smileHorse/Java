package demo;

import java.awt.BasicStroke;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LevelRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class OverlaidBarChartDemo2 extends ApplicationFrame {

   public OverlaidBarChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(1.0D, "S1", "Category 1");
      var0.addValue(4.0D, "S1", "Category 2");
      var0.addValue(3.0D, "S1", "Category 3");
      var0.addValue(5.0D, "S1", "Category 4");
      var0.addValue(5.0D, "S1", "Category 5");
      var0.addValue(5.0D, "S2", "Category 1");
      var0.addValue(7.0D, "S2", "Category 2");
      var0.addValue(6.0D, "S2", "Category 3");
      var0.addValue(8.0D, "S2", "Category 4");
      var0.addValue(4.0D, "S2", "Category 5");
      BarRenderer var1 = new BarRenderer();
      var1.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
      CategoryPlot var2 = new CategoryPlot();
      var2.setDataset(var0);
      var2.setRenderer(var1);
      var2.setDomainAxis(new CategoryAxis("Category"));
      var2.setRangeAxis(new NumberAxis("Value"));
      var2.setOrientation(PlotOrientation.VERTICAL);
      var2.setRangeGridlinesVisible(true);
      var2.setDomainGridlinesVisible(true);
      var2.setRangeZeroBaselineVisible(true);
      var2.setRangePannable(true);
      DefaultCategoryDataset var3 = new DefaultCategoryDataset();
      var3.addValue(6.0D, "Prior 1", "Category 1");
      var3.addValue(7.0D, "Prior 1", "Category 2");
      var3.addValue(2.0D, "Prior 1", "Category 3");
      var3.addValue(6.0D, "Prior 1", "Category 4");
      var3.addValue(6.0D, "Prior 1", "Category 5");
      var3.addValue(4.0D, "Prior 2", "Category 1");
      var3.addValue(2.0D, "Prior 2", "Category 2");
      var3.addValue(1.0D, "Prior 2", "Category 3");
      var3.addValue(3.0D, "Prior 2", "Category 4");
      var3.addValue(2.0D, "Prior 2", "Category 5");
      LevelRenderer var4 = new LevelRenderer();
      var2.setDataset(1, var3);
      var2.setRenderer(1, var4);
      var2.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
      JFreeChart var5 = new JFreeChart(var2);
      var5.setTitle("OverlaidBarChartDemo2");
      ChartUtilities.applyCurrentTheme(var5);
      var4.setSeriesStroke(0, new BasicStroke(2.0F));
      var4.setSeriesStroke(1, new BasicStroke(2.0F));
      return var5;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      OverlaidBarChartDemo2 var1 = new OverlaidBarChartDemo2("JFreeChart: OverlaidBarChartDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
