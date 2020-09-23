package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class XYSeriesDemo3 extends ApplicationFrame {

   public XYSeriesDemo3(String var1) {
      super(var1);
      IntervalXYDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var4);
   }

   private static IntervalXYDataset createDataset() {
      XYSeries var0 = new XYSeries("Random Data");
      var0.add(1.0D, 400.2D);
      var0.add(5.0D, 294.1D);
      var0.add(4.0D, 100.0D);
      var0.add(12.5D, 734.4D);
      var0.add(17.3D, 453.2D);
      var0.add(21.2D, 500.2D);
      var0.add(21.9D, (Number)null);
      var0.add(25.6D, 734.4D);
      var0.add(30.0D, 453.2D);
      XYSeriesCollection var1 = new XYSeriesCollection(var0);
      return var1;
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYBarChart("XY Series Demo 3", "X", false, "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      IntervalMarker var3 = new IntervalMarker(400.0D, 700.0D);
      var3.setLabel("Target Range");
      var3.setLabelFont(new Font("SansSerif", 2, 11));
      var3.setLabelAnchor(RectangleAnchor.LEFT);
      var3.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
      var3.setPaint(new Color(222, 222, 255, 128));
      var2.addRangeMarker(var3, Layer.BACKGROUND);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      XYSeriesDemo3 var1 = new XYSeriesDemo3("JFreeChart: XYSeriesDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
