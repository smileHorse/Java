package demo;

import demo.SampleXYDataset2;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ScatterPlotDemo4 extends ApplicationFrame {

   public ScatterPlotDemo4(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static JPanel createDemoPanel() {
      SampleXYDataset2 var0 = new SampleXYDataset2();
      JFreeChart var1 = ChartFactory.createScatterPlot("Scatter Plot Demo 4", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setRangeTickBandPaint(new Color(200, 200, 100, 100));
      XYDotRenderer var3 = new XYDotRenderer();
      var3.setDotWidth(4);
      var3.setDotHeight(4);
      var2.setRenderer(var3);
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      NumberAxis var4 = (NumberAxis)var2.getDomainAxis();
      var4.setAutoRangeIncludesZero(false);
      var2.getRangeAxis().setInverted(true);
      ChartPanel var5 = new ChartPanel(var1);
      var5.setMouseWheelEnabled(true);
      return var5;
   }

   public static void main(String[] var0) {
      ScatterPlotDemo4 var1 = new ScatterPlotDemo4("JFreeChart: ScatterPlotDemo4.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
