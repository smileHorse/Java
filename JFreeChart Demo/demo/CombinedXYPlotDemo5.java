package demo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CombinedXYPlotDemo5 extends ApplicationFrame {

   public CombinedXYPlotDemo5(String var1) {
      super(var1);
      JFreeChart var2 = createCombinedChart();
      ChartPanel var3 = new ChartPanel(var2, true, true, true, true, true);
      var3.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var3);
   }

   private static JFreeChart createCombinedChart() {
      XYDataset var0 = createDataset1();
      StandardXYItemRenderer var1 = new StandardXYItemRenderer();
      NumberAxis var2 = new NumberAxis("Range 1");
      XYPlot var3 = new XYPlot(var0, (ValueAxis)null, var2, var1);
      var3.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
      XYTextAnnotation var4 = new XYTextAnnotation("Hello!", 50.0D, 10000.0D);
      var4.setFont(new Font("SansSerif", 0, 9));
      var4.setRotationAngle(0.7853981633974483D);
      var3.addAnnotation(var4);
      XYDataset var5 = createDataset2();
      StandardXYItemRenderer var6 = new StandardXYItemRenderer();
      NumberAxis var7 = new NumberAxis("Range 2");
      var7.setAutoRangeIncludesZero(false);
      XYPlot var8 = new XYPlot(var5, (ValueAxis)null, var7, var6);
      var8.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
      NumberAxis var9 = new NumberAxis("Domain");
      var9.setTickMarkInsideLength(5.0F);
      CombinedDomainXYPlot var10 = new CombinedDomainXYPlot(var9);
      var10.setGap(10.0D);
      var10.add(var3, 1);
      var10.add(var8, 1);
      var10.setOrientation(PlotOrientation.VERTICAL);
      JFreeChart var11 = new JFreeChart("CombinedDomainXYPlotDemo5", JFreeChart.DEFAULT_TITLE_FONT, var10, true);
      ChartUtilities.applyCurrentTheme(var11);
      return var11;
   }

   private static XYDataset createDataset1() {
      XYSeries var0 = new XYSeries("Series 1");
      var0.add(10.0D, 12353.3D);
      var0.add(20.0D, 13734.4D);
      var0.add(30.0D, 14525.3D);
      var0.add(40.0D, 13984.3D);
      var0.add(50.0D, 12999.4D);
      var0.add(60.0D, 14274.3D);
      var0.add(70.0D, 15943.5D);
      var0.add(80.0D, 14845.3D);
      var0.add(90.0D, 14645.4D);
      var0.add(100.0D, 16234.6D);
      var0.add(110.0D, 17232.3D);
      var0.add(120.0D, 14232.2D);
      var0.add(130.0D, 13102.2D);
      var0.add(140.0D, 14230.2D);
      var0.add(150.0D, 11235.2D);
      XYSeries var1 = new XYSeries("Series 2");
      var1.add(10.0D, 15000.3D);
      var1.add(20.0D, 11000.4D);
      var1.add(30.0D, 17000.3D);
      var1.add(40.0D, 15000.3D);
      var1.add(50.0D, 14000.4D);
      var1.add(60.0D, 12000.3D);
      var1.add(70.0D, 11000.5D);
      var1.add(80.0D, 12000.3D);
      var1.add(90.0D, 13000.4D);
      var1.add(100.0D, 12000.6D);
      var1.add(110.0D, 13000.3D);
      var1.add(120.0D, 17000.2D);
      var1.add(130.0D, 18000.2D);
      var1.add(140.0D, 16000.2D);
      var1.add(150.0D, 17000.2D);
      XYSeriesCollection var2 = new XYSeriesCollection();
      var2.addSeries(var0);
      var2.addSeries(var1);
      return var2;
   }

   private static XYDataset createDataset2() {
      XYSeries var0 = new XYSeries("Series 3");
      var0.add(10.0D, 16853.2D);
      var0.add(20.0D, 19642.3D);
      var0.add(30.0D, 18253.5D);
      var0.add(40.0D, 15352.3D);
      var0.add(50.0D, 13532.0D);
      var0.add(100.0D, 12635.3D);
      var0.add(110.0D, 13998.2D);
      var0.add(120.0D, 11943.2D);
      var0.add(130.0D, 16943.9D);
      var0.add(140.0D, 17843.2D);
      var0.add(150.0D, 16495.3D);
      var0.add(160.0D, 17943.6D);
      var0.add(170.0D, 18500.7D);
      var0.add(180.0D, 19595.9D);
      return new XYSeriesCollection(var0);
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createCombinedChart();
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      CombinedXYPlotDemo5 var1 = new CombinedXYPlotDemo5("JFreeChart: CombinedDomainXYPlotDemo5.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
