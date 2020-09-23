package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.VectorRenderer;
import org.jfree.data.xy.VectorSeries;
import org.jfree.data.xy.VectorSeriesCollection;
import org.jfree.data.xy.VectorXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class VectorRendererDemo1 extends ApplicationFrame {

   public VectorRendererDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(VectorXYDataset var0) {
      NumberAxis var1 = new NumberAxis("X");
      var1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var1.setLowerMargin(0.01D);
      var1.setUpperMargin(0.01D);
      var1.setAutoRangeIncludesZero(false);
      NumberAxis var2 = new NumberAxis("Y");
      var2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var2.setLowerMargin(0.01D);
      var2.setUpperMargin(0.01D);
      var2.setAutoRangeIncludesZero(false);
      VectorRenderer var3 = new VectorRenderer();
      var3.setSeriesPaint(0, Color.blue);
      XYPlot var4 = new XYPlot(var0, var1, var2, var3);
      var4.setBackgroundPaint(Color.lightGray);
      var4.setDomainGridlinePaint(Color.white);
      var4.setRangeGridlinePaint(Color.white);
      var4.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
      var4.setOutlinePaint(Color.black);
      JFreeChart var5 = new JFreeChart("Vector Renderer Demo 1", var4);
      ChartUtilities.applyCurrentTheme(var5);
      return var5;
   }

   private static VectorXYDataset createDataset() {
      VectorSeries var0 = new VectorSeries("Series 1");

      for(double var1 = 0.0D; var1 < 20.0D; ++var1) {
         for(double var3 = 0.0D; var3 < 20.0D; ++var3) {
            var0.add(var1 + 10.0D, var3 + 10.0D, Math.sin(var1 / 5.0D) / 2.0D, Math.cos(var3 / 5.0D) / 2.0D);
         }
      }

      VectorSeriesCollection var5 = new VectorSeriesCollection();
      var5.addSeries(var0);
      return var5;
   }

   public static JPanel createDemoPanel() {
      ChartPanel var0 = new ChartPanel(createChart(createDataset()));
      var0.getChartRenderingInfo().setEntityCollection((EntityCollection)null);
      return var0;
   }

   public static void main(String[] var0) {
      VectorRendererDemo1 var1 = new VectorRendererDemo1("JFreeChart : VectorRendererDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
