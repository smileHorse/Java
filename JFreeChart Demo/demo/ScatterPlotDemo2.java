package demo;

import demo.SampleXYDataset2;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ScatterPlotDemo2 extends ApplicationFrame {

   public ScatterPlotDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createScatterPlot("Scatter Plot Demo 2", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainCrosshairVisible(true);
      var2.setDomainCrosshairLockedOnData(true);
      var2.setRangeCrosshairVisible(true);
      var2.setRangeCrosshairLockedOnData(true);
      var2.setDomainZeroBaselineVisible(true);
      var2.setRangeZeroBaselineVisible(true);
      XYDotRenderer var3 = new XYDotRenderer();
      var3.setDotWidth(2);
      var3.setDotHeight(2);
      var2.setRenderer(var3);
      NumberAxis var4 = (NumberAxis)var2.getDomainAxis();
      var4.setAutoRangeIncludesZero(false);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(new SampleXYDataset2());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      ScatterPlotDemo2 var1 = new ScatterPlotDemo2("JFreeChart: ScatterPlotDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
