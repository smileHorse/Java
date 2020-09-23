package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.SamplingXYLineRenderer;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo5 extends ApplicationFrame {

   public TimeSeriesDemo5(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Random Data");
      Day var1 = new Day(1, 1, 1990);
      double var2 = 100.0D;

      for(int var4 = 0; var4 < 100000; ++var4) {
         try {
            var2 = var2 + Math.random() - 0.5D;
            var0.add(var1, new Double(var2));
            var1 = (Day)var1.next();
         } catch (SeriesException var6) {
            System.err.println("Error adding to series");
         }
      }

      return new TimeSeriesCollection(var0);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Test", "Day", "Value", var0, false, false, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      SamplingXYLineRenderer var3 = new SamplingXYLineRenderer();
      var2.setRenderer(var3);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      String var1 = "₢₢₢₣₤₥₦₧₨₩₪";
      TimeSeriesDemo5 var2 = new TimeSeriesDemo5(var1);
      var2.pack();
      RefineryUtilities.positionFrameRandomly(var2);
      var2.setVisible(true);
   }
}
