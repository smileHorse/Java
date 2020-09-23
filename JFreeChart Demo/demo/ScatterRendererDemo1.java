package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.ScatterRenderer;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;
import org.jfree.data.statistics.MultiValueCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class ScatterRendererDemo1 extends ApplicationFrame {

   public ScatterRendererDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static List listOfValues(double[] var0) {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < var0.length; ++var2) {
         var1.add(new Double(var0[var2]));
      }

      return var1;
   }

   private static MultiValueCategoryDataset createDataset() {
      DefaultMultiValueCategoryDataset var0 = new DefaultMultiValueCategoryDataset();
      var0.add(listOfValues(new double[]{1.0D, 2.0D, 3.0D}), "Series 1", "C1");
      var0.add(listOfValues(new double[]{1.2D, 2.2D, 3.2D}), "Series 1", "C2");
      var0.add(listOfValues(new double[]{1.4D, 2.4D, 3.4D}), "Series 1", "C3");
      var0.add(listOfValues(new double[]{1.0D, 3.0D}), "Series 2", "C1");
      var0.add(listOfValues(new double[]{1.2D, 3.2D}), "Series 2", "C2");
      var0.add(listOfValues(new double[]{1.4D, 3.6D}), "Series 2", "C3");
      return var0;
   }

   private static JFreeChart createChart(MultiValueCategoryDataset var0) {
      CategoryPlot var1 = new CategoryPlot(var0, new CategoryAxis("Category"), new NumberAxis("Value"), new ScatterRenderer());
      var1.setBackgroundPaint(Color.lightGray);
      var1.setDomainGridlinePaint(Color.white);
      var1.setRangeGridlinePaint(Color.white);
      var1.setAxisOffset(new RectangleInsets(4.0D, 4.0D, 4.0D, 4.0D));
      JFreeChart var2 = new JFreeChart("ScatterRendererDemo1", var1);
      ChartUtilities.applyCurrentTheme(var2);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      ScatterRendererDemo1 var1 = new ScatterRendererDemo1("JFreeChart: ScatterRendererDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
