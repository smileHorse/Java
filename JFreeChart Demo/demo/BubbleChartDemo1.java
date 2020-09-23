package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BubbleChartDemo1 extends ApplicationFrame {

   public BubbleChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYZDataset var0) {
      JFreeChart var1 = ChartFactory.createBubbleChart("Bubble Chart Demo 1", "X", "Y", var0, PlotOrientation.HORIZONTAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setForegroundAlpha(0.65F);
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      XYItemRenderer var3 = var2.getRenderer();
      var3.setSeriesPaint(0, Color.blue);
      NumberAxis var4 = (NumberAxis)var2.getDomainAxis();
      var4.setLowerMargin(0.15D);
      var4.setUpperMargin(0.15D);
      NumberAxis var5 = (NumberAxis)var2.getRangeAxis();
      var5.setLowerMargin(0.15D);
      var5.setUpperMargin(0.15D);
      return var1;
   }

   public static XYZDataset createDataset() {
      DefaultXYZDataset var0 = new DefaultXYZDataset();
      double[] var1 = new double[]{2.1D, 2.3D, 2.3D, 2.2D, 2.2D, 1.8D, 1.8D, 1.9D, 2.3D, 3.8D};
      double[] var2 = new double[]{14.1D, 11.1D, 10.0D, 8.8D, 8.7D, 8.4D, 5.4D, 4.1D, 4.1D, 25.0D};
      double[] var3 = new double[]{2.4D, 2.7D, 2.7D, 2.2D, 2.2D, 2.2D, 2.1D, 2.2D, 1.6D, 4.0D};
      double[][] var4 = new double[][]{var1, var2, var3};
      var0.addSeries("Series 1", var4);
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      var1.setDomainZoomable(true);
      var1.setRangeZoomable(true);
      return var1;
   }

   public static void main(String[] var0) {
      BubbleChartDemo1 var1 = new BubbleChartDemo1("JFreeChart: BubbleChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
