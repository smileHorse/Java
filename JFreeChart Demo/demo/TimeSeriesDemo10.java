package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo10 extends ApplicationFrame {

   public TimeSeriesDemo10(String var1) {
      super(var1);
      XYDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var4);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Time Series Demo 10", "Time", "Value", var0, true, true, false);
      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Per Minute Data");
      Hour var1 = new Hour();
      var0.add(new Minute(1, var1), 10.2D);
      var0.add(new Minute(3, var1), 17.3D);
      var0.add(new Minute(9, var1), 14.6D);
      var0.add(new Minute(11, var1), 11.9D);
      var0.add(new Minute(15, var1), 13.5D);
      var0.add(new Minute(19, var1), 10.9D);
      TimeSeriesCollection var2 = new TimeSeriesCollection(var0);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      TimeSeriesDemo10 var1 = new TimeSeriesDemo10("Time Series Demo 10");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
