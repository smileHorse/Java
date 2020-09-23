package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LineChart3DDemo1 extends ApplicationFrame {

   public LineChart3DDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(143.2D, "S1", "C1");
      var0.addValue(120.2D, "S1", "C2");
      var0.addValue(135.0D, "S1", "C3");
      var0.addValue(115.0D, "S1", "C4");
      var0.addValue(98.7D, "S2", "C1");
      var0.addValue(63.2D, "S2", "C2");
      var0.addValue(71.4D, "S2", "C3");
      var0.addValue(55.0D, "S2", "C4");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createLineChart3D("Line Chart 3D Demo 1", (String)null, "Class Count", var0, PlotOrientation.VERTICAL, false, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setAutoRangeIncludesZero(false);
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      LineChart3DDemo1 var1 = new LineChart3DDemo1("JFreeChart: LineChart3DDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
