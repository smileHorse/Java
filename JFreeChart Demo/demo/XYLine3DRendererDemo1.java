package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLine3DRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYLine3DRendererDemo1 extends ApplicationFrame {

   public XYLine3DRendererDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("XYLine3DRenderer Demo 1", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      XYLine3DRenderer var3 = new XYLine3DRenderer();
      var3.setWallPaint(Color.gray);
      var3.setXOffset(2.0D);
      var3.setYOffset(3.0D);
      var3.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
      var3.setDefaultEntityRadius(6);
      var2.setRenderer(var3);
      return var1;
   }

   private static XYDataset createDataset() {
      XYSeries var0 = new XYSeries("Series 1");
      var0.add(1.0D, 3.3D);
      var0.add(2.0D, 4.4D);
      var0.add(3.0D, 1.7D);
      XYSeries var1 = new XYSeries("Series 2");
      var1.add(1.0D, 7.3D);
      var1.add(2.0D, 0.0D);
      var1.add(3.0D, 9.6D);
      var1.add(4.0D, 5.6D);
      XYSeriesCollection var2 = new XYSeriesCollection();
      var2.addSeries(var0);
      var2.addSeries(var1);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      XYLine3DRendererDemo1 var1 = new XYLine3DRendererDemo1("JFreeChart: XYLine3DRendererDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
