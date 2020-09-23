package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTitleAnnotation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class XYTitleAnnotationDemo1 extends ApplicationFrame {

   public XYTitleAnnotationDemo1(String var1) {
      super(var1);
      ChartPanel var2 = (ChartPanel)createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      var2.setMouseZoomable(true);
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Legal & General Unit Trust Prices", "Date", "Price Per Unit", var0, false, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      LegendTitle var3 = new LegendTitle(var2);
      var3.setItemFont(new Font("Dialog", 0, 9));
      var3.setBackgroundPaint(new Color(200, 200, 255, 100));
      var3.setFrame(new BlockBorder(Color.white));
      var3.setPosition(RectangleEdge.BOTTOM);
      XYTitleAnnotation var4 = new XYTitleAnnotation(0.98D, 0.02D, var3, RectangleAnchor.BOTTOM_RIGHT);
      var4.setMaxWidth(0.48D);
      var2.addAnnotation(var4);
      XYItemRenderer var5 = var2.getRenderer();
      if(var5 instanceof XYLineAndShapeRenderer) {
         XYLineAndShapeRenderer var6 = (XYLineAndShapeRenderer)var5;
         var6.setBaseShapesVisible(true);
         var6.setBaseShapesFilled(true);
      }

      DateAxis var8 = (DateAxis)var2.getDomainAxis();
      var8.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
      ValueAxis var7 = var2.getRangeAxis();
      var7.setLowerMargin(0.35D);
      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("L&G European Index Trust");
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
      TimeSeries var1 = new TimeSeries("L&G UK Index Trust");
      var1.add(new Month(2, 2001), 129.6D);
      var1.add(new Month(3, 2001), 123.2D);
      var1.add(new Month(4, 2001), 117.2D);
      var1.add(new Month(5, 2001), 124.1D);
      var1.add(new Month(6, 2001), 122.6D);
      var1.add(new Month(7, 2001), 119.2D);
      var1.add(new Month(8, 2001), 116.5D);
      var1.add(new Month(9, 2001), 112.7D);
      var1.add(new Month(10, 2001), 101.5D);
      var1.add(new Month(11, 2001), 106.1D);
      var1.add(new Month(12, 2001), 110.3D);
      var1.add(new Month(1, 2002), 111.7D);
      var1.add(new Month(2, 2002), 111.0D);
      var1.add(new Month(3, 2002), 109.6D);
      var1.add(new Month(4, 2002), 113.2D);
      var1.add(new Month(5, 2002), 111.6D);
      var1.add(new Month(6, 2002), 108.8D);
      var1.add(new Month(7, 2002), 101.6D);
      TimeSeriesCollection var2 = new TimeSeriesCollection();
      var2.addSeries(var0);
      var2.addSeries(var1);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      XYTitleAnnotationDemo1 var1 = new XYTitleAnnotationDemo1("XYTitleAnnotationDemo1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
