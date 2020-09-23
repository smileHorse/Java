package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MultipleAxisDemo1 extends ApplicationFrame {

   public MultipleAxisDemo1(String var1) {
      super(var1);
      ChartPanel var2 = (ChartPanel)createDemoPanel();
      var2.setPreferredSize(new Dimension(600, 270));
      var2.setDomainZoomable(true);
      var2.setRangeZoomable(true);
      this.setContentPane(var2);
   }

   private static JFreeChart createChart() {
      XYDataset var0 = createDataset("Series 1", 100.0D, new Minute(), 200);
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Multiple Axis Demo 1", "Time of Day", "Primary Range Axis", var0, true, true, false);
      var1.addSubtitle(new TextTitle("Four datasets and four range axes."));
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setOrientation(PlotOrientation.VERTICAL);
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      NumberAxis var3 = new NumberAxis("Range Axis 2");
      var3.setAutoRangeIncludesZero(false);
      var2.setRangeAxis(1, var3);
      var2.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_LEFT);
      XYDataset var4 = createDataset("Series 2", 1000.0D, new Minute(), 170);
      var2.setDataset(1, var4);
      var2.mapDatasetToRangeAxis(1, 1);
      StandardXYItemRenderer var5 = new StandardXYItemRenderer();
      var2.setRenderer(1, var5);
      NumberAxis var6 = new NumberAxis("Range Axis 3");
      var2.setRangeAxis(2, var6);
      XYDataset var7 = createDataset("Series 3", 10000.0D, new Minute(), 170);
      var2.setDataset(2, var7);
      var2.mapDatasetToRangeAxis(2, 2);
      StandardXYItemRenderer var8 = new StandardXYItemRenderer();
      var2.setRenderer(2, var8);
      NumberAxis var9 = new NumberAxis("Range Axis 4");
      var2.setRangeAxis(3, var9);
      XYDataset var10 = createDataset("Series 4", 25.0D, new Minute(), 200);
      var2.setDataset(3, var10);
      var2.mapDatasetToRangeAxis(3, 3);
      StandardXYItemRenderer var11 = new StandardXYItemRenderer();
      var2.setRenderer(3, var11);
      ChartUtilities.applyCurrentTheme(var1);
      var2.getRenderer().setSeriesPaint(0, Color.black);
      var5.setSeriesPaint(0, Color.red);
      var3.setLabelPaint(Color.red);
      var3.setTickLabelPaint(Color.red);
      var8.setSeriesPaint(0, Color.blue);
      var6.setLabelPaint(Color.blue);
      var6.setTickLabelPaint(Color.blue);
      var11.setSeriesPaint(0, Color.green);
      var9.setLabelPaint(Color.green);
      var9.setTickLabelPaint(Color.green);
      return var1;
   }

   private static XYDataset createDataset(String var0, double var1, RegularTimePeriod var3, int var4) {
      TimeSeries var5 = new TimeSeries(var0);
      RegularTimePeriod var6 = var3;
      double var7 = var1;

      for(int var9 = 0; var9 < var4; ++var9) {
         var5.add(var6, var7);
         var6 = var6.next();
         var7 *= 1.0D + (Math.random() - 0.495D) / 10.0D;
      }

      TimeSeriesCollection var10 = new TimeSeriesCollection();
      var10.addSeries(var5);
      return var10;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      MultipleAxisDemo1 var1 = new MultipleAxisDemo1("JFreeChart: MultipleAxisDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
