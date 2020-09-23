package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DefaultXYDatasetDemo1 extends ApplicationFrame {

   public DefaultXYDatasetDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      return ChartFactory.createScatterPlot("DefaultXYDatasetDemo1", "X", "Y", var0, PlotOrientation.VERTICAL, true, false, false);
   }

   private static XYDataset createDataset() {
      DefaultXYDataset var0 = new DefaultXYDataset();
      double[] var1 = new double[]{1.0D, 2.0D, 3.0D, 4.0D, 5.0D, 6.0D, 7.0D, 8.0D};
      double[] var2 = new double[]{8.0D, 7.0D, 6.0D, 5.0D, 4.0D, 3.0D, 2.0D, 1.0D};
      double[][] var3 = new double[][]{var1, var2};
      var0.addSeries("Series 1", var3);
      double[] var4 = new double[]{1.0D, 2.0D, 3.0D, 4.0D, 5.0D, 6.0D, 7.0D, 8.0D};
      double[] var5 = new double[]{1.0D, 2.0D, 3.0D, 4.0D, 5.0D, 6.0D, 7.0D, 8.0D};
      double[][] var6 = new double[][]{var4, var5};
      var0.addSeries("Series 2", var6);
      return var0;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      DefaultXYDatasetDemo1 var1 = new DefaultXYDatasetDemo1("JFreeChart: DefautlXYDatasetDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
