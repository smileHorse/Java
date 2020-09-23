package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYSeriesDemo2 extends ApplicationFrame {

   public XYSeriesDemo2(String var1) {
      super(var1);
      XYDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var4);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("XY Series Demo 2", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setAutoRangeIncludesZero(false);
      var3.setAutoRangeMinimumSize(1.0D);
      return var1;
   }

   private static XYDataset createDataset() {
      XYSeries var0 = new XYSeries("Flat Data");
      var0.add(1.0D, 100.0D);
      var0.add(5.0D, 100.0D);
      var0.add(4.0D, 100.0D);
      var0.add(12.5D, 100.0D);
      var0.add(17.3D, 100.0D);
      var0.add(21.2D, 100.0D);
      var0.add(21.9D, 100.0D);
      var0.add(25.6D, 100.0D);
      var0.add(30.0D, 100.0D);
      XYSeriesCollection var1 = new XYSeriesCollection(var0);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      XYSeriesDemo2 var1 = new XYSeriesDemo2("JFreeChart: XYSeriesDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
