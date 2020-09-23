package demo;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BoxAndWhiskerChartDemo1 extends ApplicationFrame {

   public BoxAndWhiskerChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static BoxAndWhiskerCategoryDataset createDataset() {
      byte var0 = 3;
      byte var1 = 5;
      byte var2 = 20;
      DefaultBoxAndWhiskerCategoryDataset var3 = new DefaultBoxAndWhiskerCategoryDataset();

      for(int var4 = 0; var4 < var0; ++var4) {
         for(int var5 = 0; var5 < var1; ++var5) {
            List var6 = createValueList(0.0D, 20.0D, var2);
            var3.add(var6, "Series " + var4, "Category " + var5);
         }
      }

      return var3;
   }

   private static List createValueList(double var0, double var2, int var4) {
      ArrayList var5 = new ArrayList();

      for(int var6 = 0; var6 < var4; ++var6) {
         double var7 = var0 + Math.random() * (var2 - var0);
         var5.add(new Double(var7));
      }

      return var5;
   }

   private static JFreeChart createChart(BoxAndWhiskerCategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBoxAndWhiskerChart("Box and Whisker Chart Demo 1", "Category", "Value", var0, true);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setDomainGridlinesVisible(true);
      var2.setRangePannable(true);
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      BoxAndWhiskerChartDemo1 var1 = new BoxAndWhiskerChartDemo1("JFreeChart: BoxAndWhiskerChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
