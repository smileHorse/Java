package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.SimpleHistogramBin;
import org.jfree.data.statistics.SimpleHistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HistogramDemo2 extends ApplicationFrame {

   public HistogramDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static IntervalXYDataset createDataset() {
      SimpleHistogramDataset var0 = new SimpleHistogramDataset("Series 1");
      SimpleHistogramBin var1 = new SimpleHistogramBin(0.0D, 1.0D, true, false);
      SimpleHistogramBin var2 = new SimpleHistogramBin(1.0D, 2.0D, true, false);
      SimpleHistogramBin var3 = new SimpleHistogramBin(2.0D, 3.0D, true, false);
      SimpleHistogramBin var4 = new SimpleHistogramBin(3.0D, 4.0D, true, true);
      var1.setItemCount(1);
      var2.setItemCount(10);
      var3.setItemCount(15);
      var4.setItemCount(20);
      var0.addBin(var1);
      var0.addBin(var2);
      var0.addBin(var3);
      var0.addBin(var4);
      return var0;
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createHistogram("HistogramDemo2", (String)null, (String)null, var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setForegroundAlpha(0.85F);
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      XYBarRenderer var4 = (XYBarRenderer)var2.getRenderer();
      var4.setDrawBarOutline(false);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      HistogramDemo2 var1 = new HistogramDemo2("JFreeChart: HistogramDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
