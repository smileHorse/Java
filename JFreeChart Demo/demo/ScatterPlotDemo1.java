package demo;

import demo.SampleXYDataset2;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ScatterPlotDemo1 extends ApplicationFrame {

   public ScatterPlotDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createScatterPlot("Scatter Plot Demo 1", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setNoDataMessage("NO DATA");
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      var2.setDomainZeroBaselineVisible(true);
      var2.setRangeZeroBaselineVisible(true);
      var2.setDomainGridlineStroke(new BasicStroke(0.0F));
      var2.setDomainMinorGridlineStroke(new BasicStroke(0.0F));
      var2.setDomainGridlinePaint(Color.blue);
      var2.setRangeGridlineStroke(new BasicStroke(0.0F));
      var2.setRangeMinorGridlineStroke(new BasicStroke(0.0F));
      var2.setRangeGridlinePaint(Color.blue);
      var2.setDomainMinorGridlinesVisible(true);
      var2.setRangeMinorGridlinesVisible(true);
      XYLineAndShapeRenderer var3 = (XYLineAndShapeRenderer)var2.getRenderer();
      var3.setSeriesOutlinePaint(0, Color.black);
      var3.setUseOutlinePaint(true);
      NumberAxis var4 = (NumberAxis)var2.getDomainAxis();
      var4.setAutoRangeIncludesZero(false);
      var4.setTickMarkInsideLength(2.0F);
      var4.setTickMarkOutsideLength(2.0F);
      var4.setMinorTickCount(2);
      var4.setMinorTickMarksVisible(true);
      NumberAxis var5 = (NumberAxis)var2.getRangeAxis();
      var5.setTickMarkInsideLength(2.0F);
      var5.setTickMarkOutsideLength(2.0F);
      var5.setMinorTickCount(2);
      var5.setMinorTickMarksVisible(true);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(new SampleXYDataset2());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      ScatterPlotDemo1 var1 = new ScatterPlotDemo1("JFreeChart: ScatterPlotDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
