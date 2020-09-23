package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.IntervalBarRenderer;
import org.jfree.data.category.DefaultIntervalCategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class IntervalBarChartDemo1 extends ApplicationFrame {

   private static final long serialVersionUID = 1L;


   public IntervalBarChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static IntervalCategoryDataset createDataset() {
      double[] var0 = new double[]{0.1D, 0.2D, 0.3D};
      double[] var1 = new double[]{0.3D, 0.4D, 0.5D};
      double[] var2 = new double[]{0.5D, 0.6D, 0.7D};
      double[] var3 = new double[]{0.7D, 0.8D, 0.9D};
      double[][] var4 = new double[][]{var0, var1};
      double[][] var5 = new double[][]{var2, var3};
      DefaultIntervalCategoryDataset var6 = new DefaultIntervalCategoryDataset(var4, var5);
      return var6;
   }

   private static JFreeChart createChart(IntervalCategoryDataset var0) {
      CategoryAxis var1 = new CategoryAxis("Category");
      NumberAxis var2 = new NumberAxis("Percentage");
      var2.setNumberFormatOverride(new DecimalFormat("0.00%"));
      IntervalBarRenderer var3 = new IntervalBarRenderer();
      CategoryPlot var4 = new CategoryPlot(var0, var1, var2, var3);
      JFreeChart var5 = new JFreeChart("IntervalBarChartDemo1", var4);
      var4.setDomainGridlinesVisible(true);
      var4.setRangePannable(true);
      ChartUtilities.applyCurrentTheme(var5);
      return var5;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      IntervalBarChartDemo1 var1 = new IntervalBarChartDemo1("JFreeChart: IntervalBarChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
