package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.MinMaxCategoryRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MinMaxCategoryPlotDemo1 extends ApplicationFrame {

   public MinMaxCategoryPlotDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(1.0D, "First", "C1");
      var0.addValue(4.0D, "First", "C2");
      var0.addValue(3.0D, "First", "C3");
      var0.addValue(5.0D, "First", "C4");
      var0.addValue(5.0D, "First", "C5");
      var0.addValue(7.0D, "First", "C6");
      var0.addValue(7.0D, "First", "C7");
      var0.addValue(8.0D, "First", "C8");
      var0.addValue(5.0D, "Second", "C1");
      var0.addValue(7.0D, "Second", "C2");
      var0.addValue(6.0D, "Second", "C3");
      var0.addValue(8.0D, "Second", "C4");
      var0.addValue(4.0D, "Second", "C5");
      var0.addValue(4.0D, "Second", "C6");
      var0.addValue(2.0D, "Second", "C7");
      var0.addValue(1.0D, "Second", "C8");
      var0.addValue(4.0D, "Third", "C1");
      var0.addValue(3.0D, "Third", "C2");
      var0.addValue(2.0D, "Third", "C3");
      var0.addValue(3.0D, "Third", "C4");
      var0.addValue(6.0D, "Third", "C5");
      var0.addValue(3.0D, "Third", "C6");
      var0.addValue(4.0D, "Third", "C7");
      var0.addValue(3.0D, "Third", "C8");
      return var0;
   }

   public static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart("Min/Max Category Plot", "Category", "Value", var0, PlotOrientation.VERTICAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setRangePannable(true);
      MinMaxCategoryRenderer var3 = new MinMaxCategoryRenderer();
      var3.setDrawLines(false);
      var2.setRenderer(var3);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      MinMaxCategoryPlotDemo1 var1 = new MinMaxCategoryPlotDemo1("JFreeChart: MinMaxCategoryPlotDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
