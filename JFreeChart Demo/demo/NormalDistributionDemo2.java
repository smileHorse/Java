package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.function.NormalDistributionFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class NormalDistributionDemo2 extends ApplicationFrame {

   public NormalDistributionDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static XYDataset createDataset() {
      XYSeriesCollection var0 = new XYSeriesCollection();
      NormalDistributionFunction2D var1 = new NormalDistributionFunction2D(0.0D, 1.0D);
      XYSeries var2 = DatasetUtilities.sampleFunction2DToSeries(var1, -5.1D, 5.1D, 121, "N1");
      var0.addSeries(var2);
      NormalDistributionFunction2D var3 = new NormalDistributionFunction2D(0.0D, Math.sqrt(0.2D));
      XYSeries var4 = DatasetUtilities.sampleFunction2DToSeries(var3, -5.1D, 5.1D, 121, "N2");
      var0.addSeries(var4);
      NormalDistributionFunction2D var5 = new NormalDistributionFunction2D(0.0D, Math.sqrt(5.0D));
      XYSeries var6 = DatasetUtilities.sampleFunction2DToSeries(var5, -5.1D, 5.1D, 121, "N3");
      var0.addSeries(var6);
      NormalDistributionFunction2D var7 = new NormalDistributionFunction2D(-2.0D, Math.sqrt(0.5D));
      XYSeries var8 = DatasetUtilities.sampleFunction2DToSeries(var7, -5.1D, 5.1D, 121, "N4");
      var0.addSeries(var8);
      return var0;
   }

   public static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("Normal Distribution Demo 2", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainZeroBaselineVisible(true);
      var2.setRangeZeroBaselineVisible(true);
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      ValueAxis var3 = var2.getDomainAxis();
      var3.setLowerMargin(0.0D);
      var3.setUpperMargin(0.0D);
      XYLineAndShapeRenderer var4 = (XYLineAndShapeRenderer)var2.getRenderer();
      var4.setDrawSeriesLineAsPath(true);
      var4.setSeriesStroke(0, new BasicStroke(1.5F));
      var4.setSeriesStroke(1, new BasicStroke(2.0F, 1, 1, 1.0F, new float[]{6.0F, 4.0F}, 0.0F));
      var4.setSeriesStroke(2, new BasicStroke(2.0F, 1, 1, 1.0F, new float[]{6.0F, 4.0F, 3.0F, 3.0F}, 0.0F));
      var4.setSeriesStroke(3, new BasicStroke(2.0F, 1, 1, 1.0F, new float[]{4.0F, 4.0F}, 0.0F));
      XYPointerAnnotation var5 = new XYPointerAnnotation("μ = -2.0, σ² = 0.5", -2.0D, 0.564D, 3.9269908169872414D);
      var5.setLabelOffset(4.0D);
      var5.setTextAnchor(TextAnchor.BOTTOM_RIGHT);
      var5.setBackgroundPaint(Color.yellow);
      var2.addAnnotation(var5);
      XYPointerAnnotation var6 = new XYPointerAnnotation("μ = 0.0, σ² = 0.2", 0.225D, 0.8D, 0.0D);
      var6.setLabelOffset(4.0D);
      var6.setTextAnchor(TextAnchor.CENTER_LEFT);
      var6.setBackgroundPaint(new Color(0, 0, 255, 63));
      var2.addAnnotation(var6);
      XYPointerAnnotation var7 = new XYPointerAnnotation("μ = 0.0, σ² = 1.0", 0.75D, 0.3D, 5.497787143782138D);
      var7.setLabelOffset(4.0D);
      var7.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
      var7.setBackgroundPaint(new Color(255, 0, 0, 63));
      var2.addAnnotation(var7);
      XYPointerAnnotation var8 = new XYPointerAnnotation("μ = 0.0, σ² = 5.0", 3.0D, 0.075D, 4.71238898038469D);
      var8.setLabelOffset(4.0D);
      var8.setTextAnchor(TextAnchor.BOTTOM_CENTER);
      var8.setBackgroundPaint(new Color(0, 255, 0, 63));
      var2.addAnnotation(var8);
      return var1;
   }

   public static void main(String[] var0) {
      NormalDistributionDemo2 var1 = new NormalDistributionDemo2("JFreeChart: NormalDistributionDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
