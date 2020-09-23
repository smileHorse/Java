package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class ChartPanelSerializationTest extends ApplicationFrame {

   public ChartPanelSerializationTest(String var1) {
      super(var1);
      XYDataset var2 = this.createDataset();
      JFreeChart var3 = this.createChart(var2);
      ChartPanel var4 = new ChartPanel(var3, true);
      var4.setMouseWheelEnabled(true);
      var4.setPreferredSize(new Dimension(500, 270));
      var4.setMouseZoomable(true, true);
      ChartPanel var5 = null;

      try {
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();
         ObjectOutputStream var7 = new ObjectOutputStream(var6);
         var7.writeObject(var4);
         var7.close();
         ObjectInputStream var8 = new ObjectInputStream(new ByteArrayInputStream(var6.toByteArray()));
         var5 = (ChartPanel)var8.readObject();
         var8.close();
      } catch (Exception var9) {
         var9.printStackTrace();
      }

      this.setContentPane(var5);
   }

   private JFreeChart createChart(XYDataset var1) {
      JFreeChart var2 = ChartFactory.createTimeSeriesChart("Legal & General Unit Trust Prices", "Date", "Price Per Unit", var1, true, true, false);
      var2.setBackgroundPaint(Color.white);
      XYPlot var3 = (XYPlot)var2.getPlot();
      var3.setBackgroundPaint(Color.lightGray);
      var3.setDomainGridlinePaint(Color.white);
      var3.setRangeGridlinePaint(Color.white);
      var3.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
      var3.setDomainCrosshairVisible(true);
      var3.setRangeCrosshairVisible(true);
      var3.setDomainPannable(true);
      var3.setRangePannable(false);
      XYItemRenderer var4 = var3.getRenderer();
      if(var4 instanceof XYLineAndShapeRenderer) {
         XYLineAndShapeRenderer var5 = (XYLineAndShapeRenderer)var4;
         var5.setBaseShapesVisible(true);
         var5.setBaseShapesFilled(true);
         var5.setBaseItemLabelsVisible(true);
      }

      DateAxis var6 = (DateAxis)var3.getDomainAxis();
      var6.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
      return var2;
   }

   private XYDataset createDataset() {
      TimeSeries var1 = new TimeSeries("L&G European Index Trust");
      var1.add(new Month(2, 2001), 181.8D);
      var1.add(new Month(3, 2001), 167.3D);
      var1.add(new Month(4, 2001), 153.8D);
      var1.add(new Month(5, 2001), 167.6D);
      var1.add(new Month(6, 2001), 158.8D);
      var1.add(new Month(7, 2001), 148.3D);
      var1.add(new Month(8, 2001), 153.9D);
      var1.add(new Month(9, 2001), 142.7D);
      var1.add(new Month(10, 2001), 123.2D);
      var1.add(new Month(11, 2001), 131.8D);
      var1.add(new Month(12, 2001), 139.6D);
      var1.add(new Month(1, 2002), 142.9D);
      var1.add(new Month(2, 2002), 138.7D);
      var1.add(new Month(3, 2002), 137.3D);
      var1.add(new Month(4, 2002), 143.9D);
      var1.add(new Month(5, 2002), 139.8D);
      var1.add(new Month(6, 2002), 137.0D);
      var1.add(new Month(7, 2002), 132.8D);
      TimeSeries var2 = new TimeSeries("L&G UK Index Trust");
      var2.add(new Month(2, 2001), 129.6D);
      var2.add(new Month(3, 2001), 123.2D);
      var2.add(new Month(4, 2001), 117.2D);
      var2.add(new Month(5, 2001), 124.1D);
      var2.add(new Month(6, 2001), 122.6D);
      var2.add(new Month(7, 2001), 119.2D);
      var2.add(new Month(8, 2001), 116.5D);
      var2.add(new Month(9, 2001), 112.7D);
      var2.add(new Month(10, 2001), 101.5D);
      var2.add(new Month(11, 2001), 106.1D);
      var2.add(new Month(12, 2001), 110.3D);
      var2.add(new Month(1, 2002), 111.7D);
      var2.add(new Month(2, 2002), 111.0D);
      var2.add(new Month(3, 2002), 109.6D);
      var2.add(new Month(4, 2002), 113.2D);
      var2.add(new Month(5, 2002), 111.6D);
      var2.add(new Month(6, 2002), 108.8D);
      var2.add(new Month(7, 2002), 101.6D);
      TimeSeriesCollection var3 = new TimeSeriesCollection();
      var3.addSeries(var1);
      var3.addSeries(var2);
      return var3;
   }

   public static void main(String[] var0) {
      ChartPanelSerializationTest var1 = new ChartPanelSerializationTest("Serialization Test");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
