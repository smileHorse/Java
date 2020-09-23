package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class MarkerDemo2 extends ApplicationFrame {

   public MarkerDemo2(String var1) {
      super(var1);
      XYDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      var4.setDomainZoomable(true);
      var4.setRangeZoomable(true);
      this.setContentPane(var4);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("Marker Demo 2", "X", "Temperature", var0, PlotOrientation.VERTICAL, false, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      PeriodAxis var3 = new PeriodAxis((String)null, new Hour(0, 30, 6, 2005), new Hour(23, 30, 6, 2005));
      PeriodAxisLabelInfo[] var4 = new PeriodAxisLabelInfo[]{new PeriodAxisLabelInfo(Hour.class, new SimpleDateFormat("HH")), new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("dd-MMM"))};
      var3.setLabelInfo(var4);
      var2.setDomainAxis(var3);
      ChartUtilities.applyCurrentTheme(var1);
      var2.setDomainGridlinePaint(Color.lightGray);
      var2.setDomainGridlineStroke(new BasicStroke(1.0F));
      var2.setRangeGridlinePaint(Color.lightGray);
      var2.setRangeGridlineStroke(new BasicStroke(1.0F));
      var2.setRangeTickBandPaint(new Color(240, 240, 240));
      ValueAxis var5 = var2.getRangeAxis();
      var5.setRange(0.0D, 100.0D);
      XYItemRenderer var6 = var2.getRenderer();
      var6.setSeriesPaint(0, Color.green);
      var6.setSeriesStroke(0, new BasicStroke(2.0F));
      ValueMarker var7 = new ValueMarker(80.0D);
      var7.setLabelOffsetType(LengthAdjustmentType.EXPAND);
      var7.setPaint(Color.red);
      var7.setStroke(new BasicStroke(2.0F));
      var7.setLabel("Temperature Threshold");
      var7.setLabelFont(new Font("SansSerif", 0, 11));
      var7.setLabelPaint(Color.red);
      var7.setLabelAnchor(RectangleAnchor.TOP_LEFT);
      var7.setLabelTextAnchor(TextAnchor.BOTTOM_LEFT);
      var2.addRangeMarker(var7);
      Hour var8 = new Hour(18, 30, 6, 2005);
      Hour var9 = new Hour(20, 30, 6, 2005);
      double var10 = (double)var8.getFirstMillisecond();
      double var12 = (double)var9.getFirstMillisecond();
      IntervalMarker var14 = new IntervalMarker(var10, var12);
      var14.setLabelOffsetType(LengthAdjustmentType.EXPAND);
      var14.setPaint(new Color(150, 150, 255));
      var14.setLabel("Automatic Cooling");
      var14.setLabelFont(new Font("SansSerif", 0, 11));
      var14.setLabelPaint(Color.blue);
      var14.setLabelAnchor(RectangleAnchor.TOP_LEFT);
      var14.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
      var2.addDomainMarker(var14, Layer.BACKGROUND);
      ValueMarker var15 = new ValueMarker(var10, Color.blue, new BasicStroke(2.0F));
      ValueMarker var16 = new ValueMarker(var12, Color.blue, new BasicStroke(2.0F));
      var2.addDomainMarker(var15, Layer.BACKGROUND);
      var2.addDomainMarker(var16, Layer.BACKGROUND);
      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeriesCollection var0 = new TimeSeriesCollection();
      TimeSeries var1 = new TimeSeries("Temperature");
      var1.add(new Hour(0, 30, 6, 2005), 45.3D);
      var1.add(new Hour(1, 30, 6, 2005), 48.9D);
      var1.add(new Hour(2, 30, 6, 2005), 52.1D);
      var1.add(new Hour(3, 30, 6, 2005), 44.8D);
      var1.add(new Hour(4, 30, 6, 2005), 49.9D);
      var1.add(new Hour(5, 30, 6, 2005), 55.5D);
      var1.add(new Hour(6, 30, 6, 2005), 58.2D);
      var1.add(new Hour(7, 30, 6, 2005), 58.1D);
      var1.add(new Hour(8, 30, 6, 2005), 63.7D);
      var1.add(new Hour(9, 30, 6, 2005), 66.3D);
      var1.add(new Hour(10, 30, 6, 2005), 69.8D);
      var1.add(new Hour(11, 30, 6, 2005), 70.1D);
      var1.add(new Hour(12, 30, 6, 2005), 72.4D);
      var1.add(new Hour(13, 30, 6, 2005), 69.7D);
      var1.add(new Hour(14, 30, 6, 2005), 68.6D);
      var1.add(new Hour(15, 30, 6, 2005), 70.9D);
      var1.add(new Hour(16, 30, 6, 2005), 73.4D);
      var1.add(new Hour(17, 30, 6, 2005), 77.5D);
      var1.add(new Hour(18, 30, 6, 2005), 82.9D);
      var1.add(new Hour(19, 30, 6, 2005), 62.1D);
      var1.add(new Hour(20, 30, 6, 2005), 37.3D);
      var1.add(new Hour(21, 30, 6, 2005), 40.7D);
      var1.add(new Hour(22, 30, 6, 2005), 44.2D);
      var1.add(new Hour(23, 30, 6, 2005), 49.8D);
      var0.addSeries(var1);
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      MarkerDemo2 var1 = new MarkerDemo2("JFreeChart: MarkerDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
