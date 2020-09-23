package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class MultiplePieChartDemo3 extends ApplicationFrame {

   public MultiplePieChartDemo3(String var1) {
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
      var0.addValue(4.3D, "Row 0", "Column 1");
      var0.addValue(6.7D, "Row 0", "Column 2");
      var0.addValue(4.4D, "Row 0", "Column 3");
      var0.addValue(6.1D, "Row 0", "Column 4");
      var0.addValue(5.8D, "Row 1", "Column 0");
      var0.addValue(3.2D, "Row 1", "Column 1");
      var0.addValue(4.5D, "Row 1", "Column 2");
      var0.addValue(7.0D, "Row 1", "Column 3");
      var0.addValue(5.8D, "Row 1", "Column 4");
      var0.addValue(5.3D, "Row 2", "Column 0");
      var0.addValue(6.7D, "Row 2", "Column 1");
      var0.addValue(7.1D, "Row 2", "Column 2");
      var0.addValue(4.2D, "Row 2", "Column 3");
      var0.addValue(9.0D, "Row 2", "Column 4");
      var0.addValue(5.6D, "Row 3", "Column 0");
      var0.addValue(5.6D, "Row 3", "Column 1");
      var0.addValue(5.6D, "Row 3", "Column 2");
      var0.addValue(5.6D, "Row 3", "Column 3");
      var0.addValue(5.6D, "Row 3", "Column 4");
      var0.addValue(5.6D, "Row 4", "Column 0");
      var0.addValue(5.6D, "Row 4", "Column 1");
      var0.addValue(5.6D, "Row 4", "Column 2");
      var0.addValue(5.6D, "Row 4", "Column 3");
      var0.addValue(5.6D, "Row 4", "Column 4");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createMultiplePieChart3D("Multiple Pie Chart Demo 3", var0, TableOrder.BY_COLUMN, true, true, false);
      MultiplePiePlot var2 = (MultiplePiePlot)var1.getPlot();
      PiePlot var3 = (PiePlot)var2.getPieChart().getPlot();
      var3.setMaximumLabelWidth(0.18D);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      MultiplePieChartDemo3 var1 = new MultiplePieChartDemo3("JFreeChart: MultiplePieChartDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
