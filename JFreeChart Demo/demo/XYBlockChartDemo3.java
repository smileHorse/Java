package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class XYBlockChartDemo3 extends ApplicationFrame {

   public XYBlockChartDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYZDataset var0) {
      NumberAxis var1 = new NumberAxis("X");
      var1.setLowerMargin(0.0D);
      var1.setUpperMargin(0.0D);
      NumberAxis var2 = new NumberAxis("Y");
      var2.setAutoRangeIncludesZero(false);
      var2.setInverted(true);
      var2.setLowerMargin(0.0D);
      var2.setUpperMargin(0.0D);
      var2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      XYBlockRenderer var3 = new XYBlockRenderer();
      LookupPaintScale var4 = new LookupPaintScale(0.5D, 3.5D, Color.black);
      var4.add(0.5D, Color.green);
      var4.add(1.5D, Color.orange);
      var4.add(2.5D, Color.red);
      var3.setPaintScale(var4);
      XYPlot var5 = new XYPlot(var0, var1, var2, var3);
      var5.setBackgroundPaint(Color.lightGray);
      var5.setDomainGridlinePaint(Color.white);
      var5.setRangeGridlinePaint(Color.white);
      var5.setForegroundAlpha(0.66F);
      var5.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
      JFreeChart var6 = new JFreeChart("XYBlockChartDemo3", var5);
      var6.removeLegend();
      SymbolAxis var7 = new SymbolAxis((String)null, new String[]{"", "OK", "Uncertain", "Bad"});
      var7.setRange(0.5D, 3.5D);
      var7.setPlot(new PiePlot());
      var7.setGridBandsVisible(false);
      PaintScaleLegend var8 = new PaintScaleLegend(var4, var7);
      var8.setAxisOffset(5.0D);
      var8.setPosition(RectangleEdge.BOTTOM);
      var8.setMargin(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
      var6.addSubtitle(var8);
      ChartUtilities.applyCurrentTheme(var6);
      return var6;
   }

   private static void setValue(double[][] var0, int var1, int var2, double var3) {
      var0[0][(var2 - 8) * 60 + var1] = (double)var1;
      var0[1][(var2 - 8) * 60 + var1] = (double)var2;
      var0[2][(var2 - 8) * 60 + var1] = var3;
   }

   private static XYZDataset createDataset() {
      double[] var0 = new double[840];
      double[] var1 = new double[840];
      double[] var2 = new double[840];
      double[][] var3 = new double[][]{var0, var1, var2};

      int var4;
      int var5;
      for(var4 = 0; var4 < 60; ++var4) {
         for(var5 = 8; var5 < 22; ++var5) {
            setValue(var3, var4, var5, 0.0D);
         }
      }

      for(var4 = 8; var4 < 12; ++var4) {
         for(var5 = 13; var5 < 48; ++var5) {
            setValue(var3, var5, var4, 1.0D);
         }
      }

      for(var4 = 12; var4 < 20; ++var4) {
         for(var5 = 23; var5 < 43; ++var5) {
            setValue(var3, var5, var4, 1.0D);
         }
      }

      setValue(var3, 2, 20, 2.0D);
      setValue(var3, 5, 20, 3.0D);
      setValue(var3, 6, 20, 3.0D);
      setValue(var3, 7, 20, 3.0D);
      setValue(var3, 8, 20, 3.0D);
      setValue(var3, 9, 20, 3.0D);
      setValue(var3, 11, 20, 3.0D);
      setValue(var3, 17, 20, 2.0D);
      setValue(var3, 18, 20, 2.0D);
      setValue(var3, 19, 20, 2.0D);
      setValue(var3, 20, 20, 2.0D);
      setValue(var3, 22, 20, 2.0D);
      setValue(var3, 25, 20, 2.0D);
      setValue(var3, 28, 20, 2.0D);
      setValue(var3, 35, 20, 2.0D);

      for(var4 = 40; var4 < 60; ++var4) {
         setValue(var3, var4, 20, 3.0D);
      }

      for(var4 = 23; var4 < 43; ++var4) {
         setValue(var3, var4, 21, 1.0D);
      }

      DefaultXYZDataset var6 = new DefaultXYZDataset();
      var6.addSeries("Series 1", var3);
      return var6;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      XYBlockChartDemo3 var1 = new XYBlockChartDemo3("Block Chart Demo 3");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
