package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.CombinedRangeXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CombinedXYPlotDemo2 extends ApplicationFrame {

   public CombinedXYPlotDemo2(String var1) {
      super(var1);
      JFreeChart var2 = createCombinedChart();
      ChartPanel var3 = new ChartPanel(var2, true, true, true, true, true);
      var3.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var3);
   }

   private static JFreeChart createCombinedChart() {
      IntervalXYDataset var0 = createDataset1();
      XYBarRenderer var1 = new XYBarRenderer(0.2D);
      var1.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0,000.0")));
      XYPlot var2 = new XYPlot(var0, new DateAxis("Date"), (ValueAxis)null, var1);
      XYDataset var3 = createDataset2();
      StandardXYItemRenderer var4 = new StandardXYItemRenderer();
      var4.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0,000.0")));
      XYPlot var5 = new XYPlot(var3, new DateAxis("Date"), (ValueAxis)null, var4);
      NumberAxis var6 = new NumberAxis("Value");
      var6.setTickMarkInsideLength(3.0F);
      CombinedRangeXYPlot var7 = new CombinedRangeXYPlot(var6);
      var7.add(var2, 1);
      var7.add(var5, 1);
      JFreeChart var8 = new JFreeChart("Combined (Range) XY Plot", JFreeChart.DEFAULT_TITLE_FONT, var7, true);
      ChartUtilities.applyCurrentTheme(var8);
      return var8;
   }

   private static IntervalXYDataset createDataset1() {
      TimeSeries var0 = new TimeSeries("Series 1");
      var0.add(new Day(1, 3, 2002), 12353.3D);
      var0.add(new Day(2, 3, 2002), 13734.4D);
      var0.add(new Day(3, 3, 2002), 14525.3D);
      var0.add(new Day(4, 3, 2002), 13984.3D);
      var0.add(new Day(5, 3, 2002), 12999.4D);
      var0.add(new Day(6, 3, 2002), 14274.3D);
      var0.add(new Day(7, 3, 2002), 15943.5D);
      var0.add(new Day(8, 3, 2002), 14845.3D);
      var0.add(new Day(9, 3, 2002), 14645.4D);
      var0.add(new Day(10, 3, 2002), 16234.6D);
      var0.add(new Day(11, 3, 2002), 17232.3D);
      var0.add(new Day(12, 3, 2002), 14232.2D);
      var0.add(new Day(13, 3, 2002), 13102.2D);
      var0.add(new Day(14, 3, 2002), 14230.2D);
      var0.add(new Day(15, 3, 2002), 11235.2D);
      TimeSeriesCollection var1 = new TimeSeriesCollection(var0);
      return var1;
   }

   private static XYDataset createDataset2() {
      TimeSeries var0 = new TimeSeries("Series 2");
      var0.add(new Day(3, 3, 2002), 6853.2D);
      var0.add(new Day(4, 3, 2002), 9642.3D);
      var0.add(new Day(5, 3, 2002), 8253.5D);
      var0.add(new Day(6, 3, 2002), 5352.3D);
      var0.add(new Day(7, 3, 2002), 3532.0D);
      var0.add(new Day(8, 3, 2002), 2635.3D);
      var0.add(new Day(9, 3, 2002), 3998.2D);
      var0.add(new Day(10, 3, 2002), 1943.2D);
      var0.add(new Day(11, 3, 2002), 6943.9D);
      var0.add(new Day(12, 3, 2002), 7843.2D);
      var0.add(new Day(13, 3, 2002), 6495.3D);
      var0.add(new Day(14, 3, 2002), 7943.6D);
      var0.add(new Day(15, 3, 2002), 8500.7D);
      var0.add(new Day(16, 3, 2002), 9595.9D);
      return new TimeSeriesCollection(var0);
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createCombinedChart();
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      CombinedXYPlotDemo2 var1 = new CombinedXYPlotDemo2("JFreeChart: CombinedXYPlotDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
