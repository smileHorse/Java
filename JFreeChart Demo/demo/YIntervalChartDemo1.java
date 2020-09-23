package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.YIntervalRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class YIntervalChartDemo1 extends ApplicationFrame {

   public YIntervalChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createScatterPlot("Y Interval Chart Demo 1", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRenderer(new YIntervalRenderer());
      return var1;
   }

   private static IntervalXYDataset createDataset() {
      double var0 = 100.0D;
      YIntervalSeries var2 = new YIntervalSeries("Series 1");

      for(int var3 = 0; var3 < 100; ++var3) {
         var0 += Math.random() - 0.49D;
         var2.add((double)var3, var0, var0 - 3.0D, var0 + 3.0D);
      }

      YIntervalSeriesCollection var4 = new YIntervalSeriesCollection();
      var4.addSeries(var2);
      return var4;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      YIntervalChartDemo1 var1 = new YIntervalChartDemo1("JFreeChart: YIntervalChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
