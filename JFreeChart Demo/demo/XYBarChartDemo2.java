package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.ClusteredXYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo2 extends ApplicationFrame {

   public XYBarChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static IntervalXYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Series 1");
      var0.add(new Day(1, 1, 2003), 54.3D);
      var0.add(new Day(2, 1, 2003), 20.3D);
      var0.add(new Day(3, 1, 2003), 43.4D);
      var0.add(new Day(4, 1, 2003), -12.0D);
      TimeSeries var1 = new TimeSeries("Series 2");
      var1.add(new Day(1, 1, 2003), 8.0D);
      var1.add(new Day(2, 1, 2003), 16.0D);
      var1.add(new Day(3, 1, 2003), 21.0D);
      var1.add(new Day(4, 1, 2003), 5.0D);
      TimeSeriesCollection var2 = new TimeSeriesCollection();
      var2.addSeries(var0);
      var2.addSeries(var1);
      return var2;
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYBarChart("XY Bar Chart Demo 2", "Date", true, "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      ClusteredXYBarRenderer var3 = new ClusteredXYBarRenderer(0.0D, false);
      var2.setRenderer(var3);
      var3.setDrawBarOutline(false);
      return var1;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      XYBarChartDemo2 var1 = new XYBarChartDemo2("JFreeChart: XYBarChartDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
