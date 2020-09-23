package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HighLowChartDemo3 extends ApplicationFrame {

   public HighLowChartDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static OHLCDataset createDataset1() {
      OHLCSeries var0 = new OHLCSeries("Series 1");
      var0.add(new Day(24, 9, 2007), 50.5D, 53.2D, 49.8D, 50.1D);
      var0.add(new Day(25, 9, 2007), 50.2D, 51.2D, 47.8D, 48.1D);
      var0.add(new Day(26, 9, 2007), 48.0D, 49.2D, 45.3D, 47.4D);
      var0.add(new Day(27, 9, 2007), 47.5D, 48.3D, 46.8D, 46.8D);
      var0.add(new Day(28, 9, 2007), 46.6D, 47.0D, 45.1D, 46.0D);
      var0.add(new Day(1, 10, 2007), 46.6D, 47.0D, 45.1D, 46.0D);
      var0.add(new Day(2, 10, 2007), 47.5D, 48.3D, 46.8D, 46.8D);
      var0.add(new Day(3, 10, 2007), 48.0D, 49.2D, 45.3D, 47.4D);
      var0.add(new Day(4, 10, 2007), 50.2D, 51.2D, 47.8D, 48.1D);
      var0.add(new Day(5, 10, 2007), 50.5D, 53.2D, 49.8D, 50.1D);
      OHLCSeriesCollection var1 = new OHLCSeriesCollection();
      var1.addSeries(var0);
      return var1;
   }

   public static OHLCDataset createDataset2() {
      OHLCSeries var0 = new OHLCSeries("Series 2");
      var0.add(new Day(24, 9, 2007), 5.5D, 6.2D, 4.8D, 5.9D);
      var0.add(new Day(25, 9, 2007), 6.0D, 6.9D, 6.0D, 6.7D);
      var0.add(new Day(26, 9, 2007), 6.8D, 7.5D, 6.4D, 7.1D);
      var0.add(new Day(27, 9, 2007), 7.2D, 8.2D, 7.0D, 7.9D);
      var0.add(new Day(28, 9, 2007), 7.8D, 8.5D, 7.7D, 8.2D);
      var0.add(new Day(1, 10, 2007), 8.2D, 8.5D, 7.7D, 7.8D);
      var0.add(new Day(2, 10, 2007), 7.9D, 8.2D, 7.0D, 7.2D);
      var0.add(new Day(3, 10, 2007), 7.1D, 7.5D, 6.4D, 6.8D);
      var0.add(new Day(4, 10, 2007), 6.0D, 6.9D, 6.0D, 6.7D);
      var0.add(new Day(5, 10, 2007), 5.5D, 6.2D, 4.8D, 5.9D);
      OHLCSeriesCollection var1 = new OHLCSeriesCollection();
      var1.addSeries(var0);
      return var1;
   }

   private static JFreeChart createChart(OHLCDataset var0) {
      JFreeChart var1 = ChartFactory.createHighLowChart("OHLC Demo 3", "Time", "Price", var0, true);
      XYPlot var2 = (XYPlot)var1.getPlot();
      HighLowRenderer var3 = (HighLowRenderer)var2.getRenderer();
      var3.setBaseStroke(new BasicStroke(2.0F));
      var3.setSeriesPaint(0, Color.blue);
      DateAxis var4 = (DateAxis)var2.getDomainAxis();
      var4.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
      NumberAxis var5 = (NumberAxis)var2.getRangeAxis();
      var5.setAutoRangeIncludesZero(false);
      NumberAxis var6 = new NumberAxis("Price 2");
      var6.setAutoRangeIncludesZero(false);
      var2.setRangeAxis(1, var6);
      var2.setDataset(1, createDataset2());
      var2.setRenderer(1, new CandlestickRenderer(10.0D));
      var2.mapDatasetToRangeAxis(1, 1);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset1());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      HighLowChartDemo3 var1 = new HighLowChartDemo3("JFreeChart: HighLowChartDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
