package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LogarithmicAxisDemo2 extends ApplicationFrame {

   public LogarithmicAxisDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createScatterPlot("Logarithmic Axis Demo 2", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      LogarithmicAxis var3 = new LogarithmicAxis("X");
      var3.setExpTickLabelsFlag(true);
      var3.setStrictValuesFlag(false);
      LogarithmicAxis var4 = new LogarithmicAxis("Y");
      var4.setAllowNegativesFlag(true);
      var4.setLog10TickLabelsFlag(true);
      var2.setDomainAxis(var3);
      var2.setRangeAxis(var4);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static XYDataset createDataset() {
      XYSeries var0 = new XYSeries("Series 1");
      var0.add(-500.0D, -500.0D);
      var0.add(-50.0D, -50.0D);
      var0.add(-5.0D, -5.0D);
      var0.add(0.0D, 0.0D);
      var0.add(5.0D, 5.0D);
      var0.add(50.0D, 50.0D);
      var0.add(500.0D, 500.0D);
      return new XYSeriesCollection(var0);
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      LogarithmicAxisDemo2 var1 = new LogarithmicAxisDemo2("JFreeChart: LogarithmicAxisDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
