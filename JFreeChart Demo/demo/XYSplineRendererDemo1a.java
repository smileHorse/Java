package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class XYSplineRendererDemo1a extends ApplicationFrame {

   public XYSplineRendererDemo1a(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.getContentPane().add(var2);
   }

   public static JPanel createDemoPanel() {
      NumberAxis var0 = new NumberAxis("X");
      var0.setAutoRangeIncludesZero(false);
      NumberAxis var1 = new NumberAxis("Y");
      var1.setAutoRangeIncludesZero(false);
      XYSplineRenderer var2 = new XYSplineRenderer();
      XYPlot var3 = new XYPlot(createSampleData(), var0, var1, var2);
      var3.setBackgroundPaint(Color.lightGray);
      var3.setDomainGridlinePaint(Color.white);
      var3.setRangeGridlinePaint(Color.white);
      var3.setAxisOffset(new RectangleInsets(4.0D, 4.0D, 4.0D, 4.0D));
      JFreeChart var4 = new JFreeChart("XYSplineRenderer", JFreeChart.DEFAULT_TITLE_FONT, var3, true);
      ChartUtilities.applyCurrentTheme(var4);
      ChartPanel var5 = new ChartPanel(var4);
      return var5;
   }

   private static XYDataset createSampleData() {
      XYSeries var0 = new XYSeries("Series 1");
      var0.add(2.0D, 56.27D);
      var0.add(3.0D, 41.32D);
      var0.add(4.0D, 31.45D);
      var0.add(5.0D, 30.05D);
      var0.add(6.0D, 24.69D);
      var0.add(7.0D, 19.78D);
      var0.add(8.0D, 20.94D);
      var0.add(9.0D, 16.73D);
      var0.add(10.0D, 14.21D);
      var0.add(11.0D, 12.44D);
      XYSeriesCollection var1 = new XYSeriesCollection(var0);
      XYSeries var2 = new XYSeries("Series 2");
      var2.add(11.0D, 56.27D);
      var2.add(10.0D, 41.32D);
      var2.add(9.0D, 31.45D);
      var2.add(8.0D, 30.05D);
      var2.add(7.0D, 24.69D);
      var2.add(6.0D, 19.78D);
      var2.add(5.0D, 20.94D);
      var2.add(4.0D, 16.73D);
      var2.add(3.0D, 14.21D);
      var2.add(2.0D, 12.44D);
      var1.addSeries(var2);
      return var1;
   }

   public static void main(String[] var0) {
      XYSplineRendererDemo1a var1 = new XYSplineRendererDemo1a("JFreeChart: XYSplineRendererDemo1a.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
