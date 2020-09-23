package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYErrorRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYErrorRendererDemo1 extends ApplicationFrame {

   public XYErrorRendererDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      NumberAxis var1 = new NumberAxis("X");
      NumberAxis var2 = new NumberAxis("Y");
      XYErrorRenderer var3 = new XYErrorRenderer();
      XYPlot var4 = new XYPlot(var0, var1, var2, var3);
      var4.setDomainPannable(true);
      var4.setRangePannable(true);
      var4.setBackgroundPaint(Color.lightGray);
      var4.setDomainGridlinePaint(Color.white);
      var4.setRangeGridlinePaint(Color.white);
      JFreeChart var5 = new JFreeChart("XYErrorRenderer Demo 1", var4);
      ChartUtilities.applyCurrentTheme(var5);
      return var5;
   }

   private static IntervalXYDataset createDataset() {
      XYIntervalSeriesCollection var0 = new XYIntervalSeriesCollection();
      XYIntervalSeries var1 = new XYIntervalSeries("Series 1");
      var1.add(1.0D, 0.5D, 1.5D, 10.0D, 9.0D, 11.0D);
      var1.add(10.0D, 8.7D, 11.21D, 6.1D, 4.34D, 7.54D);
      var1.add(17.8D, 16.0D, 18.9D, 4.5D, 3.1D, 5.8D);
      XYIntervalSeries var2 = new XYIntervalSeries("Series 2");
      var2.add(3.0D, 2.5D, 3.5D, 7.0D, 6.0D, 8.0D);
      var2.add(13.0D, 11.5D, 14.5D, 13.0D, 11.5D, 14.5D);
      var2.add(24.0D, 22.7D, 25.21D, 16.1D, 14.34D, 17.54D);
      var0.addSeries(var1);
      var0.addSeries(var2);
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      XYErrorRendererDemo1 var1 = new XYErrorRendererDemo1("JFreeChart: XYErrorRendererDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
