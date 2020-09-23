package demo;

import java.awt.BasicStroke;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYStepRendererDemo1 extends ApplicationFrame {

   public XYStepRendererDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("XYStepRenderer Demo 1", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      XYStepRenderer var3 = new XYStepRenderer();
      var3.setBaseShapesVisible(true);
      var3.setSeriesStroke(0, new BasicStroke(2.0F));
      var3.setSeriesStroke(1, new BasicStroke(2.0F));
      var3.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
      var3.setDefaultEntityRadius(6);
      var2.setRenderer(var3);
      return var1;
   }

   private static XYDataset createDataset() {
      XYSeries var0 = new XYSeries("Series 1");
      var0.add(1.0D, 3.0D);
      var0.add(2.0D, 4.0D);
      var0.add(3.0D, 2.0D);
      var0.add(6.0D, 3.0D);
      XYSeries var1 = new XYSeries("Series 2");
      var1.add(1.0D, 7.0D);
      var1.add(2.0D, 6.0D);
      var1.add(3.0D, 9.0D);
      var1.add(4.0D, 5.0D);
      var1.add(6.0D, 4.0D);
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
      XYStepRendererDemo1 var1 = new XYStepRendererDemo1("JFreeChart: XYStepRendererDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
