package demo;

import demo.CircleDrawer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYDrawableAnnotation;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class MarkerDemo1 extends ApplicationFrame {

   public MarkerDemo1(String var1) {
      super(var1);
      ChartPanel var2 = (ChartPanel)createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      var2.setDomainZoomable(true);
      var2.setRangeZoomable(true);
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createScatterPlot("Marker Demo 1", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      LegendTitle var2 = (LegendTitle)var1.getSubtitle(0);
      var2.setPosition(RectangleEdge.RIGHT);
      XYPlot var3 = (XYPlot)var1.getPlot();
      var3.setDomainPannable(true);
      var3.setRangePannable(true);
      var3.getRenderer().setBaseToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
      DateAxis var4 = new DateAxis("Time");
      var4.setUpperMargin(0.5D);
      var3.setDomainAxis(var4);
      ValueAxis var5 = var3.getRangeAxis();
      var5.setUpperMargin(0.3D);
      var5.setLowerMargin(0.5D);
      ValueMarker var6 = new ValueMarker(200.0D);
      var6.setLabelOffsetType(LengthAdjustmentType.EXPAND);
      var6.setPaint(Color.green);
      var6.setLabel("Bid Start Price");
      var6.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT);
      var6.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
      var3.addRangeMarker(var6);
      ValueMarker var7 = new ValueMarker(175.0D);
      var7.setLabelOffsetType(LengthAdjustmentType.EXPAND);
      var7.setPaint(Color.red);
      var7.setLabel("Target Price");
      var7.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
      var7.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
      var3.addRangeMarker(var7);
      Hour var8 = new Hour(2, new Day(22, 5, 2003));
      double var9 = (double)var8.getFirstMillisecond();
      ValueMarker var11 = new ValueMarker(var9);
      var11.setPaint(Color.orange);
      var11.setLabel("Original Close (02:00)");
      var11.setLabelAnchor(RectangleAnchor.TOP_LEFT);
      var11.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
      var3.addDomainMarker(var11);
      Minute var12 = new Minute(15, var8);
      var9 = (double)var12.getFirstMillisecond();
      ValueMarker var13 = new ValueMarker(var9);
      var13.setPaint(Color.red);
      var13.setLabel("Close Date (02:15)");
      var13.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
      var13.setLabelTextAnchor(TextAnchor.TOP_LEFT);
      var3.addDomainMarker(var13);
      Hour var14 = new Hour(2, new Day(22, 5, 2003));
      Minute var15 = new Minute(10, var14);
      var9 = (double)var15.getFirstMillisecond();
      CircleDrawer var16 = new CircleDrawer(Color.red, new BasicStroke(1.0F), (Paint)null);
      XYDrawableAnnotation var17 = new XYDrawableAnnotation(var9, 163.0D, 11.0D, 11.0D, var16);
      var3.addAnnotation(var17);
      XYPointerAnnotation var18 = new XYPointerAnnotation("Best Bid", var9, 163.0D, 2.356194490192345D);
      var18.setBaseRadius(35.0D);
      var18.setTipRadius(10.0D);
      var18.setFont(new Font("SansSerif", 0, 9));
      var18.setPaint(Color.blue);
      var18.setTextAnchor(TextAnchor.HALF_ASCENT_RIGHT);
      var3.addAnnotation(var18);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeriesCollection var0 = new TimeSeriesCollection();
      var0.addSeries(createSupplier1Bids());
      var0.addSeries(createSupplier2Bids());
      return var0;
   }

   private static TimeSeries createSupplier1Bids() {
      Hour var0 = new Hour(1, new Day(22, 5, 2003));
      TimeSeries var1 = new TimeSeries("Supplier 1");
      var1.add(new Minute(13, var0), 200.0D);
      var1.add(new Minute(14, var0), 195.0D);
      var1.add(new Minute(45, var0), 190.0D);
      var1.add(new Minute(46, var0), 188.0D);
      var1.add(new Minute(47, var0), 185.0D);
      var1.add(new Minute(52, var0), 180.0D);
      return var1;
   }

   private static TimeSeries createSupplier2Bids() {
      Hour var0 = new Hour(1, new Day(22, 5, 2003));
      Hour var1 = (Hour)var0.next();
      TimeSeries var2 = new TimeSeries("Supplier 2");
      var2.add(new Minute(25, var0), 185.0D);
      var2.add(new Minute(0, var1), 175.0D);
      var2.add(new Minute(5, var1), 170.0D);
      var2.add(new Minute(6, var1), 168.0D);
      var2.add(new Minute(9, var1), 165.0D);
      var2.add(new Minute(10, var1), 163.0D);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      MarkerDemo1 var1 = new MarkerDemo1("JFreeChart: MarkerDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
