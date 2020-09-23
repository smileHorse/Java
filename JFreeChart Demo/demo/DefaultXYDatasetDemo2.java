package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DefaultXYDatasetDemo2 extends ApplicationFrame {

   public DefaultXYDatasetDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createScatterPlot("DefaultXYDatasetDemo2", "X", "Y", var0, PlotOrientation.VERTICAL, true, false, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      return var1;
   }

   private static XYDataset createDataset() {
      DefaultXYDataset var0 = new DefaultXYDataset();
      double[] var1 = new double[1000];
      double[] var2 = new double[1000];

      for(int var3 = 0; var3 < 1000; ++var3) {
         var1[var3] = Math.random() + 1.0D;
         var2[var3] = Math.random() + 1.0D;
      }

      double[][] var4 = new double[][]{var1, var2};
      var0.addSeries("Series 1", var4);
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      DefaultXYDatasetDemo2 var1 = new DefaultXYDatasetDemo2("JFreeChart: DefaultXYDatasetDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
