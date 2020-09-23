package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class DualAxisDemo2 extends ApplicationFrame {

   public DualAxisDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static XYDataset createDataset1() {
      TimeSeries var0 = new TimeSeries("Random Data 1");
      var0.add(new Month(2, 2001), 181.8D);
      var0.add(new Month(3, 2001), 167.3D);
      var0.add(new Month(4, 2001), 153.8D);
      var0.add(new Month(5, 2001), 167.6D);
      var0.add(new Month(6, 2001), 158.8D);
      var0.add(new Month(7, 2001), 148.3D);
      var0.add(new Month(8, 2001), 153.9D);
      var0.add(new Month(9, 2001), 142.7D);
      var0.add(new Month(10, 2001), 123.2D);
      var0.add(new Month(11, 2001), 131.8D);
      var0.add(new Month(12, 2001), 139.6D);
      var0.add(new Month(1, 2002), 142.9D);
      var0.add(new Month(2, 2002), 138.7D);
      var0.add(new Month(3, 2002), 137.3D);
      var0.add(new Month(4, 2002), 143.9D);
      var0.add(new Month(5, 2002), 139.8D);
      var0.add(new Month(6, 2002), 137.0D);
      var0.add(new Month(7, 2002), 132.8D);
      TimeSeriesCollection var1 = new TimeSeriesCollection();
      var1.addSeries(var0);
      return var1;
   }

   private static XYDataset createDataset2() {
      TimeSeries var0 = new TimeSeries("Random Data 2");
      var0.add(new Month(2, 2001), 429.6D);
      var0.add(new Month(3, 2001), 323.2D);
      var0.add(new Month(4, 2001), 417.2D);
      var0.add(new Month(5, 2001), 624.1D);
      var0.add(new Month(6, 2001), 422.6D);
      var0.add(new Month(7, 2001), 619.2D);
      var0.add(new Month(8, 2001), 416.5D);
      var0.add(new Month(9, 2001), 512.7D);
      var0.add(new Month(10, 2001), 501.5D);
      var0.add(new Month(11, 2001), 306.1D);
      var0.add(new Month(12, 2001), 410.3D);
      var0.add(new Month(1, 2002), 511.7D);
      var0.add(new Month(2, 2002), 611.0D);
      var0.add(new Month(3, 2002), 709.6D);
      var0.add(new Month(4, 2002), 613.2D);
      var0.add(new Month(5, 2002), 711.6D);
      var0.add(new Month(6, 2002), 708.8D);
      var0.add(new Month(7, 2002), 501.6D);
      TimeSeriesCollection var1 = new TimeSeriesCollection();
      var1.addSeries(var0);
      return var1;
   }

   private static JFreeChart createChart() {
      XYDataset var0 = createDataset1();
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Dual Axis Demo 2", "Date", "Price Per Unit", var0, false, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      NumberAxis var3 = new NumberAxis("Secondary");
      var3.setAutoRangeIncludesZero(false);
      var2.setRangeAxis(1, var3);
      var2.setDataset(1, createDataset2());
      var2.mapDatasetToRangeAxis(1, 1);
      XYItemRenderer var4 = var2.getRenderer();
      var4.setBaseToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
      XYLineAndShapeRenderer var5;
      if(var4 instanceof XYLineAndShapeRenderer) {
         var5 = (XYLineAndShapeRenderer)var4;
         var5.setBaseShapesVisible(true);
         var5.setBaseShapesFilled(true);
      }

      var5 = new XYLineAndShapeRenderer();
      var5.setSeriesPaint(0, Color.black);
      var5.setBaseShapesVisible(true);
      var5.setBaseToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
      var2.setRenderer(1, var5);
      DateAxis var6 = (DateAxis)var2.getDomainAxis();
      var6.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
      LegendTitle var7 = new LegendTitle(var4);
      LegendTitle var8 = new LegendTitle(var5);
      BlockContainer var9 = new BlockContainer(new BorderArrangement());
      var9.add(var7, RectangleEdge.LEFT);
      var9.add(var8, RectangleEdge.RIGHT);
      var9.add(new EmptyBlock(2000.0D, 0.0D));
      CompositeTitle var10 = new CompositeTitle(var9);
      var10.setPosition(RectangleEdge.BOTTOM);
      var1.addSubtitle(var10);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      DualAxisDemo2 var1 = new DualAxisDemo2("JFreeChart: DualAxisDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
