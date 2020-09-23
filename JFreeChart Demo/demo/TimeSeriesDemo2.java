package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo2 extends ApplicationFrame {

   public TimeSeriesDemo2(String var1) {
      super(var1);
      XYDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var4);
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Quarterly Data");
      var0.add(new Quarter(1, 2001), 500.2D);
      var0.add(new Quarter(2, 2001), 694.1D);
      var0.add(new Quarter(3, 2001), 734.4D);
      var0.add(new Quarter(4, 2001), 453.2D);
      var0.add(new Quarter(1, 2002), 500.2D);
      var0.add(new Quarter(2, 2002), (Number)null);
      var0.add(new Quarter(3, 2002), 734.4D);
      var0.add(new Quarter(4, 2002), 453.2D);
      TimeSeriesCollection var1 = new TimeSeriesCollection(var0);
      return var1;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Time Series Demo 2", "Time", "Value", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.addRangeMarker(new ValueMarker(550.0D));
      Quarter var3 = new Quarter(2, 2002);
      var2.addDomainMarker(new ValueMarker((double)var3.getMiddleMillisecond()));
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      TimeSeriesDemo2 var1 = new TimeSeriesDemo2("Time Series Demo 2");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
