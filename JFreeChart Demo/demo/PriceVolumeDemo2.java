package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PriceVolumeDemo2 extends ApplicationFrame {

   public PriceVolumeDemo2(String var1) {
      super(var1);
      JFreeChart var2 = createChart();
      ChartPanel var3 = new ChartPanel(var2, true, true, true, false, true);
      var3.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var3);
   }

   private static JFreeChart createChart() {
      OHLCDataset var0 = createPriceDataset();
      String var1 = "Sun Microsystems (SUNW)";
      JFreeChart var2 = ChartFactory.createHighLowChart(var1, "Date", "Price", var0, true);
      XYPlot var3 = (XYPlot)var2.getPlot();
      DateAxis var4 = (DateAxis)var3.getDomainAxis();
      var4.setLowerMargin(0.01D);
      var4.setUpperMargin(0.01D);
      NumberAxis var5 = (NumberAxis)var3.getRangeAxis();
      var5.setLowerMargin(0.6D);
      var5.setAutoRangeIncludesZero(false);
      XYItemRenderer var6 = var3.getRenderer();
      var6.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00")));
      NumberAxis var7 = new NumberAxis("Volume");
      var7.setUpperMargin(1.0D);
      var3.setRangeAxis(1, var7);
      var3.setDataset(1, createVolumeDataset());
      var3.setRangeAxis(1, var7);
      var3.mapDatasetToRangeAxis(1, 1);
      XYBarRenderer var8 = new XYBarRenderer();
      var8.setDrawBarOutline(false);
      var8.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0,000.00")));
      var3.setRenderer(1, var8);
      ChartUtilities.applyCurrentTheme(var2);
      var8.setShadowVisible(false);
      var8.setBarPainter(new StandardXYBarPainter());
      return var2;
   }

   private static OHLCDataset createPriceDataset() {
      OHLCSeries var0 = new OHLCSeries("SUNW");
      var0.add(new Day(12, 4, 2007), 5.9D, 5.96D, 5.87D, 5.9D);
      var0.add(new Day(13, 4, 2007), 5.89D, 5.9D, 5.78D, 5.8D);
      var0.add(new Day(16, 4, 2007), 5.81D, 5.87D, 5.79D, 5.86D);
      var0.add(new Day(17, 4, 2007), 5.87D, 5.95D, 5.82D, 5.95D);
      var0.add(new Day(18, 4, 2007), 5.89D, 5.95D, 5.87D, 5.94D);
      var0.add(new Day(19, 4, 2007), 5.87D, 5.96D, 5.86D, 5.89D);
      var0.add(new Day(20, 4, 2007), 5.94D, 5.95D, 5.87D, 5.93D);
      var0.add(new Day(23, 4, 2007), 5.93D, 5.95D, 5.89D, 5.92D);
      var0.add(new Day(24, 4, 2007), 5.93D, 5.97D, 5.88D, 5.94D);
      var0.add(new Day(25, 4, 2007), 5.58D, 5.58D, 5.17D, 5.27D);
      var0.add(new Day(26, 4, 2007), 5.25D, 5.3D, 5.2D, 5.25D);
      var0.add(new Day(27, 4, 2007), 5.23D, 5.28D, 5.19D, 5.26D);
      var0.add(new Day(30, 4, 2007), 5.25D, 5.26D, 5.2D, 5.22D);
      var0.add(new Day(1, 5, 2007), 5.23D, 5.24D, 4.99D, 5.09D);
      var0.add(new Day(2, 5, 2007), 5.09D, 5.17D, 5.08D, 5.15D);
      var0.add(new Day(3, 5, 2007), 5.14D, 5.2D, 5.11D, 5.18D);
      var0.add(new Day(4, 5, 2007), 5.21D, 5.3D, 5.2D, 5.24D);
      var0.add(new Day(7, 5, 2007), 5.22D, 5.28D, 5.21D, 5.22D);
      var0.add(new Day(8, 5, 2007), 5.24D, 5.27D, 5.21D, 5.22D);
      var0.add(new Day(9, 5, 2007), 5.21D, 5.22D, 5.15D, 5.2D);
      var0.add(new Day(10, 5, 2007), 5.16D, 5.19D, 5.13D, 5.13D);
      var0.add(new Day(11, 5, 2007), 5.14D, 5.18D, 5.12D, 5.15D);
      var0.add(new Day(14, 5, 2007), 5.16D, 5.29D, 5.16D, 5.22D);
      var0.add(new Day(15, 5, 2007), 5.22D, 5.23D, 5.13D, 5.14D);
      var0.add(new Day(16, 5, 2007), 5.14D, 5.16D, 5.07D, 5.12D);
      var0.add(new Day(17, 5, 2007), 5.35D, 5.43D, 5.3D, 5.3D);
      var0.add(new Day(18, 5, 2007), 5.35D, 5.35D, 5.26D, 5.29D);
      var0.add(new Day(21, 5, 2007), 5.29D, 5.39D, 5.24D, 5.39D);
      var0.add(new Day(22, 5, 2007), 5.39D, 5.42D, 5.34D, 5.38D);
      var0.add(new Day(23, 5, 2007), 5.37D, 5.43D, 5.36D, 5.38D);
      var0.add(new Day(24, 5, 2007), 5.36D, 5.37D, 5.15D, 5.15D);
      var0.add(new Day(25, 5, 2007), 5.18D, 5.21D, 5.15D, 5.16D);
      var0.add(new Day(29, 5, 2007), 5.16D, 5.17D, 5.0D, 5.06D);
      var0.add(new Day(30, 5, 2007), 5.01D, 5.15D, 4.96D, 5.12D);
      var0.add(new Day(31, 5, 2007), 5.16D, 5.19D, 5.07D, 5.1D);
      var0.add(new Day(1, 6, 2007), 5.12D, 5.2D, 5.12D, 5.18D);
      var0.add(new Day(4, 6, 2007), 5.15D, 5.24D, 5.07D, 5.11D);
      var0.add(new Day(5, 6, 2007), 5.08D, 5.08D, 4.97D, 5.07D);
      var0.add(new Day(6, 6, 2007), 5.03D, 5.05D, 4.99D, 5.02D);
      var0.add(new Day(7, 6, 2007), 5.0D, 5.05D, 4.97D, 4.97D);
      var0.add(new Day(8, 6, 2007), 4.98D, 5.04D, 4.95D, 5.04D);
      var0.add(new Day(11, 6, 2007), 5.05D, 5.06D, 4.95D, 4.96D);
      var0.add(new Day(12, 6, 2007), 4.95D, 5.01D, 4.92D, 4.92D);
      var0.add(new Day(13, 6, 2007), 4.95D, 4.99D, 4.83D, 4.99D);
      var0.add(new Day(14, 6, 2007), 5.05D, 5.1D, 5.02D, 5.08D);
      var0.add(new Day(15, 6, 2007), 5.13D, 5.13D, 5.03D, 5.05D);
      var0.add(new Day(18, 6, 2007), 5.06D, 5.07D, 5.01D, 5.05D);
      var0.add(new Day(19, 6, 2007), 5.03D, 5.16D, 5.03D, 5.1D);
      var0.add(new Day(20, 6, 2007), 5.14D, 5.15D, 5.05D, 5.05D);
      var0.add(new Day(21, 6, 2007), 5.07D, 5.18D, 5.06D, 5.13D);
      var0.add(new Day(22, 6, 2007), 5.11D, 5.14D, 5.08D, 5.08D);
      var0.add(new Day(25, 6, 2007), 5.08D, 5.1D, 4.99D, 5.02D);
      var0.add(new Day(26, 6, 2007), 5.04D, 5.1D, 4.99D, 5.01D);
      var0.add(new Day(27, 6, 2007), 5.0D, 5.09D, 4.99D, 5.07D);
      var0.add(new Day(28, 6, 2007), 5.08D, 5.19D, 5.07D, 5.16D);
      var0.add(new Day(29, 6, 2007), 5.19D, 5.33D, 5.16D, 5.26D);
      var0.add(new Day(2, 7, 2007), 5.13D, 5.33D, 5.12D, 5.19D);
      var0.add(new Day(3, 7, 2007), 5.2D, 5.24D, 5.17D, 5.22D);
      var0.add(new Day(5, 7, 2007), 5.28D, 5.35D, 5.24D, 5.33D);
      var0.add(new Day(6, 7, 2007), 5.36D, 5.49D, 5.34D, 5.38D);
      var0.add(new Day(9, 7, 2007), 5.4D, 5.44D, 5.31D, 5.33D);
      var0.add(new Day(10, 7, 2007), 5.29D, 5.41D, 5.28D, 5.32D);
      var0.add(new Day(11, 7, 2007), 5.29D, 5.38D, 5.29D, 5.38D);
      var0.add(new Day(12, 7, 2007), 5.38D, 5.43D, 5.33D, 5.43D);
      var0.add(new Day(13, 7, 2007), 5.42D, 5.43D, 5.34D, 5.37D);
      var0.add(new Day(16, 7, 2007), 5.33D, 5.38D, 5.3D, 5.34D);
      OHLCSeriesCollection var1 = new OHLCSeriesCollection();
      var1.addSeries(var0);
      return var1;
   }

   private static IntervalXYDataset createVolumeDataset() {
      TimeSeries var0 = new TimeSeries("Volume");
      var0.add(new Day(12, 4, 2007), 4.96468E7D);
      var0.add(new Day(13, 4, 2007), 6.73193E7D);
      var0.add(new Day(16, 4, 2007), 5.68402E7D);
      var0.add(new Day(17, 4, 2007), 4.07523E7D);
      var0.add(new Day(18, 4, 2007), 4.25338E7D);
      var0.add(new Day(19, 4, 2007), 3.42321E7D);
      var0.add(new Day(20, 4, 2007), 3.24376E7D);
      var0.add(new Day(23, 4, 2007), 2.87559E7D);
      var0.add(new Day(24, 4, 2007), 7.45033E7D);
      var0.add(new Day(25, 4, 2007), 3.22214E8D);
      var0.add(new Day(26, 4, 2007), 9.61417E7D);
      var0.add(new Day(27, 4, 2007), 6.23262E7D);
      var0.add(new Day(30, 4, 2007), 5.23344E7D);
      var0.add(new Day(1, 5, 2007), 1.330961E8D);
      var0.add(new Day(2, 5, 2007), 9.38745E7D);
      var0.add(new Day(3, 5, 2007), 1.010114E8D);
      var0.add(new Day(4, 5, 2007), 5.66297E7D);
      var0.add(new Day(7, 5, 2007), 4.33022E7D);
      var0.add(new Day(8, 5, 2007), 5.14565E7D);
      var0.add(new Day(9, 5, 2007), 4.82309E7D);
      var0.add(new Day(10, 5, 2007), 6.5536E7D);
      var0.add(new Day(11, 5, 2007), 4.64697E7D);
      var0.add(new Day(14, 5, 2007), 1.1858E8D);
      var0.add(new Day(15, 5, 2007), 5.07741E7D);
      var0.add(new Day(16, 5, 2007), 4.45902E7D);
      var0.add(new Day(17, 5, 2007), 1.254825E8D);
      var0.add(new Day(18, 5, 2007), 4.99875E7D);
      var0.add(new Day(21, 5, 2007), 4.83874E7D);
      var0.add(new Day(22, 5, 2007), 6.79926E7D);
      var0.add(new Day(23, 5, 2007), 4.56292E7D);
      var0.add(new Day(24, 5, 2007), 1.232886E8D);
      var0.add(new Day(25, 5, 2007), 4.73453E7D);
      var0.add(new Day(29, 5, 2007), 9.0454E7D);
      var0.add(new Day(30, 5, 2007), 7.30492E7D);
      var0.add(new Day(31, 5, 2007), 6.03954E7D);
      var0.add(new Day(1, 6, 2007), 4.87923E7D);
      var0.add(new Day(4, 6, 2007), 1.099728E8D);
      var0.add(new Day(5, 6, 2007), 1.982012E8D);
      var0.add(new Day(6, 6, 2007), 1.214157E8D);
      var0.add(new Day(7, 6, 2007), 5.66374E7D);
      var0.add(new Day(8, 6, 2007), 6.41166E7D);
      var0.add(new Day(11, 6, 2007), 6.02748E7D);
      var0.add(new Day(12, 6, 2007), 9.34513E7D);
      var0.add(new Day(13, 6, 2007), 1.03309E8D);
      var0.add(new Day(14, 6, 2007), 1.031354E8D);
      var0.add(new Day(15, 6, 2007), 1.044159E8D);
      var0.add(new Day(18, 6, 2007), 5.15069E7D);
      var0.add(new Day(19, 6, 2007), 7.45921E7D);
      var0.add(new Day(20, 6, 2007), 6.90276E7D);
      var0.add(new Day(21, 6, 2007), 9.72125E7D);
      var0.add(new Day(22, 6, 2007), 5.1612E7D);
      var0.add(new Day(25, 6, 2007), 6.38454E7D);
      var0.add(new Day(26, 6, 2007), 8.48184E7D);
      var0.add(new Day(27, 6, 2007), 7.35129E7D);
      var0.add(new Day(28, 6, 2007), 7.52751E7D);
      var0.add(new Day(29, 6, 2007), 1.042039E8D);
      var0.add(new Day(2, 7, 2007), 6.65404E7D);
      var0.add(new Day(3, 7, 2007), 2.85208E7D);
      var0.add(new Day(5, 7, 2007), 4.71763E7D);
      var0.add(new Day(6, 7, 2007), 7.00848E7D);
      var0.add(new Day(9, 7, 2007), 9.16308E7D);
      var0.add(new Day(10, 7, 2007), 1.140717E8D);
      var0.add(new Day(11, 7, 2007), 3.42179E7D);
      var0.add(new Day(12, 7, 2007), 3.0298E7D);
      var0.add(new Day(13, 7, 2007), 4.04235E7D);
      var0.add(new Day(16, 7, 2007), 3.9238E7D);
      return new TimeSeriesCollection(var0);
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      PriceVolumeDemo2 var1 = new PriceVolumeDemo2("JFreeChart: PriceVolumeDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
