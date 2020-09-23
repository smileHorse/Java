package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StatisticalLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StatisticalLineChartDemo1 extends ApplicationFrame {

   public StatisticalLineChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultStatisticalCategoryDataset var0 = new DefaultStatisticalCategoryDataset();
      var0.add(10.0D, 2.4D, "Row 1", "Column 1");
      var0.add(15.0D, 4.4D, "Row 1", "Column 2");
      var0.add(13.0D, 2.1D, "Row 1", "Column 3");
      var0.add(7.0D, 1.3D, "Row 1", "Column 4");
      var0.add(22.0D, 2.4D, "Row 2", "Column 1");
      var0.add(18.0D, 4.4D, "Row 2", "Column 2");
      var0.add(28.0D, 2.1D, "Row 2", "Column 3");
      var0.add(17.0D, 1.3D, "Row 2", "Column 4");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createLineChart("Statistical Line Chart Demo 1", "Type", "Value", var0, PlotOrientation.VERTICAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setRangePannable(true);
      CategoryAxis var3 = var2.getDomainAxis();
      var3.setUpperMargin(0.0D);
      var3.setLowerMargin(0.0D);
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var4.setAutoRangeIncludesZero(true);
      StatisticalLineAndShapeRenderer var5 = new StatisticalLineAndShapeRenderer(true, false);
      var5.setUseSeriesOffset(true);
      var2.setRenderer(var5);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      StatisticalLineChartDemo1 var1 = new StatisticalLineChartDemo1("JFreeChart: StatisticalLineChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
