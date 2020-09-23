package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo4 extends ApplicationFrame {

   public TimeSeriesDemo4(String var1) {
      super(var1);
      XYDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      var4.setMouseZoomable(true);
      this.setContentPane(var4);
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Random Data");
      Day var1 = new Day();
      var0.add(new Hour(0, var1), 500.2D);
      var0.add(new Hour(2, var1), 694.1D);
      var0.add(new Hour(3, var1), 734.4D);
      var0.add(new Hour(4, var1), 453.2D);
      var0.add(new Hour(7, var1), 500.2D);
      var0.add(new Hour(8, var1), (Number)null);
      var0.add(new Hour(12, var1), 734.4D);
      var0.add(new Hour(16, var1), 453.2D);
      TimeSeriesCollection var2 = new TimeSeriesCollection(var0);
      return var2;
   }

   private static JFreeChart createChart(XYDataset var0) {
      String var1 = "₢₢₣₤₥₦₧₨₩₪";
      JFreeChart var2 = ChartFactory.createTimeSeriesChart(var1, "Time", "Value", var0, true, true, false);
      XYPlot var3 = (XYPlot)var2.getPlot();
      var3.setInsets(new RectangleInsets(0.0D, 0.0D, 0.0D, 20.0D));
      ValueMarker var4 = new ValueMarker(700.0D);
      var4.setPaint(Color.blue);
      var4.setAlpha(0.8F);
      var3.addRangeMarker(var4);
      var3.setBackgroundPaint((Paint)null);
      var3.setBackgroundImage(JFreeChart.INFO.getLogo());
      var3.getDomainAxis().setLowerMargin(0.0D);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      TimeSeriesDemo4 var1 = new TimeSeriesDemo4("Time Series Demo 4");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
