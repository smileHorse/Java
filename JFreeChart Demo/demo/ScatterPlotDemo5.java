package demo;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class ScatterPlotDemo5 extends ApplicationFrame {

   public ScatterPlotDemo5(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static XYDataset createDataset() {
      XYSeriesCollection var0 = new XYSeriesCollection();
      XYSeries var1 = new XYSeries("S1");
      XYSeries var2 = new XYSeries("S2");

      for(int var3 = 0; var3 < 100; ++var3) {
         var1.add(Math.random() * 50.0D, Math.random() * 100.0D);
         var2.add(Math.random() * 50.0D, Math.random() * 100.0D);
      }

      var0.addSeries(var1);
      var0.addSeries(var2);
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = ChartFactory.createScatterPlot("Scatter Plot Demo 5", "X", "Y", createDataset());
      XYPlot var1 = (XYPlot)var0.getPlot();
      var1.setBackgroundPaint((Paint)null);
      var1.setAxisOffset(RectangleInsets.ZERO_INSETS);
      var1.setOutlineVisible(false);
      XYDotRenderer var2 = new XYDotRenderer();
      var2.setDotWidth(4);
      var2.setDotHeight(4);
      var1.setRenderer(var2);
      var1.setDomainCrosshairVisible(true);
      var1.setRangeCrosshairVisible(true);
      NumberAxis var3 = (NumberAxis)var1.getDomainAxis();
      AttributedString var4 = new AttributedString("H20");
      var4.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB, 1, 2);
      var3.setAttributedLabel(var4);
      var3.setPositiveArrowVisible(true);
      var3.setAutoRangeIncludesZero(false);
      NumberAxis var5 = (NumberAxis)var1.getRangeAxis();
      AttributedString var6 = new AttributedString("kg x 106");
      var6.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 7, 8);
      var5.setAttributedLabel(var6);
      var5.setPositiveArrowVisible(true);
      ChartPanel var7 = new ChartPanel(var0);
      var7.setMouseWheelEnabled(true);
      return var7;
   }

   public static void main(String[] var0) {
      ScatterPlotDemo5 var1 = new ScatterPlotDemo5("JFreeChart: ScatterPlotDemo5.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
