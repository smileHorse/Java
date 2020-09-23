package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYStepAreaRendererDemo1 extends ApplicationFrame {

   public XYStepAreaRendererDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("XYStepAreaRenderer Demo 1", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      XYStepAreaRenderer var3 = new XYStepAreaRenderer(2);
      var3.setDataBoundsIncludesVisibleSeriesOnly(false);
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
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      XYStepAreaRendererDemo1 var1 = new XYStepAreaRendererDemo1("XYStepAreaRenderer Demo 1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
