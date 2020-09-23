package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYLineAndShapeRendererDemo1 extends ApplicationFrame {

   public XYLineAndShapeRendererDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("XYLineAndShapeRenderer Demo 1", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      XYLineAndShapeRenderer var3 = new XYLineAndShapeRenderer();
      var3.setSeriesLinesVisible(0, true);
      var3.setSeriesShapesVisible(0, false);
      var3.setSeriesLinesVisible(1, false);
      var3.setSeriesShapesVisible(1, true);
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
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      XYLineAndShapeRendererDemo1 var1 = new XYLineAndShapeRendererDemo1("JFreeChart: XYLineAndShapeRendererDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
