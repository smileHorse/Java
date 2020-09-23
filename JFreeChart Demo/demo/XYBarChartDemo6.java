package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.DefaultIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo6 extends ApplicationFrame {

   public XYBarChartDemo6(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYBarChart("XYBarChartDemo6", "X", false, "Y", var0, PlotOrientation.HORIZONTAL, false, false, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      XYBarRenderer var3 = (XYBarRenderer)var2.getRenderer();
      var3.setUseYInterval(true);
      var2.setRenderer(var3);
      return var1;
   }

   private static IntervalXYDataset createDataset() {
      DefaultIntervalXYDataset var0 = new DefaultIntervalXYDataset();
      double[] var1 = new double[]{1.0D, 2.0D, 3.0D, 4.0D};
      double[] var2 = new double[]{0.9D, 1.8D, 2.7D, 3.6D};
      double[] var3 = new double[]{1.1D, 2.2D, 3.3D, 4.4D};
      double[] var4 = new double[]{1.0D, 2.0D, 3.0D, 4.0D};
      double[] var5 = new double[]{0.9D, 1.8D, 2.7D, 3.6D};
      double[] var6 = new double[]{1.1D, 2.2D, 3.3D, 4.4D};
      double[][] var7 = new double[][]{var1, var2, var3, var4, var5, var6};
      var0.addSeries("Series 1", var7);
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      XYBarChartDemo6 var1 = new XYBarChartDemo6("JFreeChart : XYBarChartDemo6");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
