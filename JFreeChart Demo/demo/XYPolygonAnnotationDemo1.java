package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPolygonAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RefineryUtilities;

public class XYPolygonAnnotationDemo1 extends ApplicationFrame {

   public XYPolygonAnnotationDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static XYDataset createDataset() {
      DefaultXYDataset var0 = new DefaultXYDataset();
      double[] var1 = new double[]{1.7D, 2.2D, 2.7D, 3.0D, 3.2D};
      double[] var2 = new double[]{4.0D, 3.0D, 6.0D, 1.0D, 9.0D};
      double[][] var3 = new double[][]{var1, var2};
      var0.addSeries("Series 1", var3);
      double[] var4 = new double[]{2.1D, 2.2D, 2.4D, 2.7D, 3.2D};
      double[] var5 = new double[]{4.5D, 6.0D, 4.0D, 8.0D, 5.1D};
      double[][] var6 = new double[][]{var4, var5};
      var0.addSeries("Series 2", var6);
      return var0;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createScatterPlot("XYPolygonAnnotationDemo1", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      XYLineAndShapeRenderer var3 = (XYLineAndShapeRenderer)var2.getRenderer();
      XYPolygonAnnotation var4 = new XYPolygonAnnotation(new double[]{2.0D, 5.0D, 2.5D, 8.0D, 3.0D, 5.0D, 2.5D, 2.0D}, (Stroke)null, (Paint)null, new Color(200, 200, 255, 100));
      var4.setToolTipText("Target Zone");
      var3.addAnnotation(var4, Layer.BACKGROUND);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      XYPolygonAnnotationDemo1 var1 = new XYPolygonAnnotationDemo1("XYPolygonAnnotationDemo1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
