package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.geom.Ellipse2D.Double;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYLineAndShapeRendererDemo2 extends ApplicationFrame {

   public XYLineAndShapeRendererDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart() {
      XYDataset var0 = createDataset(1, 1.0D);
      JFreeChart var1 = ChartFactory.createXYLineChart("XYLineAndShapeRenderer Demo 2", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      TextTitle var2 = new TextTitle("This chart shows various combinations of the useFillPaint and useOutlinePaint flags.");
      var2.setFont(new Font("Dialog", 0, 10));
      var1.addSubtitle(var2);
      ChartUtilities.applyCurrentTheme(var1);
      XYPlot var3 = (XYPlot)var1.getPlot();
      NumberAxis var4 = (NumberAxis)var3.getRangeAxis();
      var4.setAutoRangeIncludesZero(false);
      Double var5 = new Double(-4.0D, -4.0D, 8.0D, 8.0D);
      XYLineAndShapeRenderer var6 = (XYLineAndShapeRenderer)var3.getRenderer();
      var6.setBaseShapesVisible(true);
      var6.setSeriesShape(0, var5);
      var6.setSeriesPaint(0, Color.red);
      var6.setSeriesFillPaint(0, Color.yellow);
      var6.setSeriesOutlinePaint(0, Color.gray);
      XYDataset var7 = createDataset(2, 2.0D);
      XYLineAndShapeRenderer var8 = new XYLineAndShapeRenderer();
      var3.setDataset(1, var7);
      var3.setRenderer(1, var8);
      var8.setSeriesShape(0, var5);
      var8.setSeriesPaint(0, Color.red);
      var8.setSeriesFillPaint(0, Color.yellow);
      var8.setSeriesOutlinePaint(0, Color.gray);
      var8.setUseFillPaint(true);
      XYDataset var9 = createDataset(3, 3.0D);
      XYLineAndShapeRenderer var10 = new XYLineAndShapeRenderer();
      var3.setDataset(2, var9);
      var3.setRenderer(2, var10);
      var10.setSeriesShape(0, var5);
      var10.setSeriesPaint(0, Color.red);
      var10.setSeriesFillPaint(0, Color.yellow);
      var10.setSeriesOutlinePaint(0, Color.gray);
      var10.setUseOutlinePaint(true);
      XYDataset var11 = createDataset(4, 4.0D);
      XYLineAndShapeRenderer var12 = new XYLineAndShapeRenderer();
      var3.setDataset(3, var11);
      var3.setRenderer(3, var12);
      var12.setSeriesShape(0, var5);
      var12.setSeriesPaint(0, Color.red);
      var12.setSeriesFillPaint(0, Color.yellow);
      var12.setSeriesOutlinePaint(0, Color.gray);
      var12.setUseOutlinePaint(true);
      var12.setUseFillPaint(true);
      XYDataset var13 = createDataset(5, 5.0D);
      XYLineAndShapeRenderer var14 = new XYLineAndShapeRenderer();
      var3.setDataset(4, var13);
      var3.setRenderer(4, var14);
      var14.setSeriesShape(0, var5);
      var14.setSeriesPaint(0, Color.red);
      var14.setSeriesFillPaint(0, Color.yellow);
      var14.setSeriesOutlinePaint(0, Color.gray);
      var14.setUseOutlinePaint(true);
      var14.setUseFillPaint(true);
      var14.setDrawOutlines(false);
      return var1;
   }

   private static XYDataset createDataset(int var0, double var1) {
      XYSeries var3 = new XYSeries("Series " + var0);
      var3.add(1.0D, var1);
      var3.add(2.0D, var1);
      var3.add(3.0D, var1);
      XYSeriesCollection var4 = new XYSeriesCollection();
      var4.addSeries(var3);
      return var4;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      XYLineAndShapeRendererDemo2 var1 = new XYLineAndShapeRendererDemo2("JFreeChart: XYLineAndShapeRendererDemo2");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
