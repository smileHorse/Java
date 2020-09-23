package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class XYShapeRendererDemo1 extends ApplicationFrame {

   public XYShapeRendererDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYZDataset var0) {
      NumberAxis var1 = new NumberAxis("X");
      var1.setAutoRangeIncludesZero(false);
      NumberAxis var2 = new NumberAxis("Y");
      var2.setAutoRangeIncludesZero(false);
      XYShapeRenderer var3 = new XYShapeRenderer();
      LookupPaintScale var4 = new LookupPaintScale(1.0D, 4.0D, new Color(0, 0, 255));
      var4.add(2.0D, new Color(100, 100, 255));
      var4.add(3.0D, new Color(200, 200, 255));
      var3.setPaintScale(var4);
      XYPlot var5 = new XYPlot(var0, var1, var2, var3);
      var5.setDomainPannable(true);
      var5.setRangePannable(true);
      JFreeChart var6 = new JFreeChart("XYShapeRendererDemo1", var5);
      var6.removeLegend();
      NumberAxis var7 = new NumberAxis("Score");
      var7.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      PaintScaleLegend var8 = new PaintScaleLegend(var4, var7);
      var8.setPosition(RectangleEdge.RIGHT);
      var8.setMargin(4.0D, 4.0D, 40.0D, 4.0D);
      var8.setAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
      var6.addSubtitle(var8);
      ChartUtilities.applyCurrentTheme(var6);
      return var6;
   }

   public static XYZDataset createDataset() {
      DefaultXYZDataset var0 = new DefaultXYZDataset();
      double[] var1 = new double[]{2.1D, 2.3D, 2.3D, 2.2D, 2.2D, 1.8D, 1.8D, 1.9D, 2.3D, 2.8D};
      double[] var2 = new double[]{14.1D, 17.1D, 10.0D, 8.8D, 8.7D, 8.4D, 5.4D, 4.1D, 4.1D, 25.0D};
      double[] var3 = new double[]{2.4D, 2.7D, 1.7D, 2.2D, 1.3D, 2.2D, 2.1D, 3.2D, 1.6D, 3.4D};
      double[][] var4 = new double[][]{var1, var2, var3};
      var0.addSeries("Series 1", var4);
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      XYShapeRendererDemo1 var1 = new XYShapeRendererDemo1("JFreeChart: XYShapeRendererDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
