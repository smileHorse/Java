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

public class CombinedXYPlotDemo4 extends ApplicationFrame {

   public CombinedXYPlotDemo4(String var1) {
      super(var1);
      ChartPanel var2 = (ChartPanel)createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createCombinedChart() {
      XYDataset var0 = createDataset1();
      StandardXYItemRenderer var1 = new StandardXYItemRenderer();
      NumberAxis var2 = new NumberAxis("Range 1");
      XYPlot var3 = new XYPlot(var0, (ValueAxis)null, var2, var1);
      var3.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
      var3.setDataset(1, createDataset2());
      NumberAxis var4 = new NumberAxis("Range Axis 2");
      var4.setAutoRangeIncludesZero(false);
      var3.setRangeAxis(1, var4);
      var3.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
      var3.setRenderer(1, new StandardXYItemRenderer());
      var3.mapDatasetToRangeAxis(1, 1);
      var3.setRangePannable(true);
      XYTextAnnotation var5 = new XYTextAnnotation("Hello!", 50.0D, 10000.0D);
      var5.setFont(new Font("SansSerif", 0, 9));
      var5.setRotationAngle(0.7853981633974483D);
      var3.addAnnotation(var5);
      XYDataset var6 = createDataset2();
      StandardXYItemRenderer var7 = new StandardXYItemRenderer();
      NumberAxis var8 = new NumberAxis("Range 2");
      var8.setAutoRangeIncludesZero(false);
      XYPlot var9 = new XYPlot(var6, (ValueAxis)null, var8, var7);
      var9.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
      CombinedDomainXYPlot var10 = new CombinedDomainXYPlot(new NumberAxis("Domain"));
      var10.setGap(10.0D);
      var10.setDomainPannable(true);
      var10.add(var3, 1);
      var10.add(var9, 1);
      var10.setOrientation(PlotOrientation.VERTICAL);
      JFreeChart var11 = new JFreeChart("CombinedDomainXYPlot Demo", JFreeChart.DEFAULT_TITLE_FONT, var10, true);
      ChartUtilities.applyCurrentTheme(var11);
      return var11;
   }

   private static XYDataset createDataset1() {
      XYSeries var0 = new XYSeries("Series 1a");
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
      XYSeries var1 = new XYSeries("Series 1b");
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
      XYSeries var0 = new XYSeries("Series 2");
      var0.add(10.0D, 6853.2D);
      var0.add(20.0D, 9642.3D);
      var0.add(30.0D, 8253.5D);
      var0.add(40.0D, 5352.3D);
      var0.add(50.0D, 3532.0D);
      var0.add(60.0D, 2635.3D);
      var0.add(70.0D, 3998.2D);
      var0.add(80.0D, 1943.2D);
      var0.add(90.0D, 6943.9D);
      var0.add(100.0D, 7843.2D);
      var0.add(105.0D, 6495.3D);
      var0.add(110.0D, 7943.6D);
      var0.add(115.0D, 8500.7D);
      var0.add(120.0D, 9595.9D);
      return new XYSeriesCollection(var0);
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createCombinedChart();
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      CombinedXYPlotDemo4 var1 = new CombinedXYPlotDemo4("JFreeChart: CombinedDomainXYPlotDemo4.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
