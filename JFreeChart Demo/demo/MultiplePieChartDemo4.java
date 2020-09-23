package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class MultiplePieChartDemo4 extends ApplicationFrame {

   public MultiplePieChartDemo4(String var1) {
      super(var1);
      CategoryDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3, true, true, true, false, true);
      var4.setPreferredSize(new Dimension(600, 380));
      this.setContentPane(var4);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(5.6D, "Row 0", "Column 0");
      var0.addValue(3.2D, "Row 0", "Column 1");
      var0.addValue(1.8D, "Row 0", "Column 2");
      var0.addValue(0.2D, "Row 0", "Column 3");
      var0.addValue(4.1D, "Row 0", "Column 4");
      var0.addValue(9.8D, "Row 1", "Column 0");
      var0.addValue(6.3D, "Row 1", "Column 1");
      var0.addValue(0.1D, "Row 1", "Column 2");
      var0.addValue(1.9D, "Row 1", "Column 3");
      var0.addValue(9.6D, "Row 1", "Column 4");
      var0.addValue(7.0D, "Row 2", "Column 0");
      var0.addValue(5.2D, "Row 2", "Column 1");
      var0.addValue(2.8D, "Row 2", "Column 2");
      var0.addValue(8.8D, "Row 2", "Column 3");
      var0.addValue(7.2D, "Row 2", "Column 4");
      var0.addValue(9.5D, "Row 3", "Column 0");
      var0.addValue(1.2D, "Row 3", "Column 1");
      var0.addValue(4.5D, "Row 3", "Column 2");
      var0.addValue(4.4D, "Row 3", "Column 3");
      var0.addValue(0.2D, "Row 3", "Column 4");
      var0.addValue(3.5D, "Row 4", "Column 0");
      var0.addValue(6.7D, "Row 4", "Column 1");
      var0.addValue(9.0D, "Row 4", "Column 2");
      var0.addValue(1.0D, "Row 4", "Column 3");
      var0.addValue(5.2D, "Row 4", "Column 4");
      var0.addValue(5.1D, "Row 5", "Column 0");
      var0.addValue(6.7D, "Row 5", "Column 1");
      var0.addValue(0.9D, "Row 5", "Column 2");
      var0.addValue(3.3D, "Row 5", "Column 3");
      var0.addValue(3.9D, "Row 5", "Column 4");
      var0.addValue(5.6D, "Row 6", "Column 0");
      var0.addValue(5.6D, "Row 6", "Column 1");
      var0.addValue(5.6D, "Row 6", "Column 2");
      var0.addValue(5.6D, "Row 6", "Column 3");
      var0.addValue(5.6D, "Row 6", "Column 4");
      var0.addValue(7.5D, "Row 7", "Column 0");
      var0.addValue(9.0D, "Row 7", "Column 1");
      var0.addValue(3.4D, "Row 7", "Column 2");
      var0.addValue(4.1D, "Row 7", "Column 3");
      var0.addValue(0.5D, "Row 7", "Column 4");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createMultiplePieChart3D("Multiple Pie Chart Demo 4", var0, TableOrder.BY_COLUMN, false, true, false);
      MultiplePiePlot var2 = (MultiplePiePlot)var1.getPlot();
      var2.setLimit(0.1D);
      JFreeChart var3 = var2.getPieChart();
      PiePlot var4 = (PiePlot)var3.getPlot();
      var4.setIgnoreNullValues(true);
      var4.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
      var4.setMaximumLabelWidth(0.2D);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      MultiplePieChartDemo4 var1 = new MultiplePieChartDemo4("JFreeChart: MultiplePieChartDemo4.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
