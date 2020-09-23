package demo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class MultiplePieChartDemo1 extends ApplicationFrame {

   public MultiplePieChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(600, 380));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      double[][] var0 = new double[][]{{3.0D, 4.0D, 3.0D, 5.0D}, {5.0D, 7.0D, 6.0D, 8.0D}, {5.0D, 7.0D, Double.NaN, 3.0D}, {1.0D, 2.0D, 3.0D, 4.0D}, {2.0D, 3.0D, 2.0D, 3.0D}};
      CategoryDataset var1 = DatasetUtilities.createCategoryDataset("Region ", "Sales/Q", var0);
      return var1;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createMultiplePieChart("Multiple Pie Chart", var0, TableOrder.BY_ROW, true, true, false);
      MultiplePiePlot var2 = (MultiplePiePlot)var1.getPlot();
      JFreeChart var3 = var2.getPieChart();
      PiePlot var4 = (PiePlot)var3.getPlot();
      var4.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
      var4.setLabelFont(new Font("SansSerif", 0, 8));
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      MultiplePieChartDemo1 var1 = new MultiplePieChartDemo1("JFreeChart: MultiplePieChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
