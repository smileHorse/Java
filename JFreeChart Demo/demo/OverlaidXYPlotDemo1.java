package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.DatasetRenderingOrder;
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

public class OverlaidXYPlotDemo1 extends ApplicationFrame {

   public OverlaidXYPlotDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart() {
      IntervalXYDataset var0 = createDataset1();
      XYBarRenderer var1 = new XYBarRenderer(0.2D);
      var1.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00")));
      DateAxis var2 = new DateAxis("Date");
      var2.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
      NumberAxis var3 = new NumberAxis("Value");
      XYPlot var4 = new XYPlot(var0, var2, var3, var1);
      XYDataset var5 = createDataset2();
      StandardXYItemRenderer var6 = new StandardXYItemRenderer();
      var6.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00")));
      var4.setDataset(1, var5);
      var4.setRenderer(1, var6);
      var4.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
      JFreeChart var7 = new JFreeChart("Overlaid XYPlot Demo 1", JFreeChart.DEFAULT_TITLE_FONT, var4, true);
      ChartUtilities.applyCurrentTheme(var7);
      return var7;
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
      return new TimeSeriesCollection(var0);
   }

   private static XYDataset createDataset2() {
      TimeSeries var0 = new TimeSeries("Series 2");
      var0.add(new Day(3, 3, 2002), 16853.2D);
      var0.add(new Day(4, 3, 2002), 19642.3D);
      var0.add(new Day(5, 3, 2002), 18253.5D);
      var0.add(new Day(6, 3, 2002), 15352.3D);
      var0.add(new Day(7, 3, 2002), 13532.0D);
      var0.add(new Day(8, 3, 2002), 12635.3D);
      var0.add(new Day(9, 3, 2002), 13998.2D);
      var0.add(new Day(10, 3, 2002), 11943.2D);
      var0.add(new Day(11, 3, 2002), 16943.9D);
      var0.add(new Day(12, 3, 2002), 17843.2D);
      var0.add(new Day(13, 3, 2002), 16495.3D);
      var0.add(new Day(14, 3, 2002), 17943.6D);
      var0.add(new Day(15, 3, 2002), 18500.7D);
      var0.add(new Day(16, 3, 2002), 19595.9D);
      TimeSeriesCollection var1 = new TimeSeriesCollection(var0);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      OverlaidXYPlotDemo1 var1 = new OverlaidXYPlotDemo1("JFreeChart: OverlaidXYPlotDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
