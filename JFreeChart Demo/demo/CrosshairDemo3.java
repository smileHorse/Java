package demo;

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CrosshairDemo3 extends ApplicationFrame {

   public CrosshairDemo3(String var1) {
      super(var1);
      this.setContentPane(createDemoPanel());
   }

   public static JPanel createDemoPanel() {
      return new CrosshairDemo3.MyDemoPanel();
   }

   public static void main(String[] var0) {
      CrosshairDemo3 var1 = new CrosshairDemo3("JFreeChart: CrosshairDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }

   static class MyDemoPanel extends DemoPanel implements ChangeListener {

      private JFreeChart chart;
      private JSlider slider;


      public MyDemoPanel() {
         super(new BorderLayout());
         XYDataset var1 = this.createDataset();
         this.chart = this.createChart(var1);
         this.addChart(this.chart);
         ChartPanel var2 = new ChartPanel(this.chart);
         var2.setPreferredSize(new Dimension(500, 270));
         var2.setMouseZoomable(true);
         JPanel var3 = new JPanel(new BorderLayout());
         this.slider = new JSlider(0, 100, 50);
         this.slider.addChangeListener(this);
         var3.add(this.slider);
         this.add(var2);
         this.add(var3, "South");
      }

      private JFreeChart createChart(XYDataset var1) {
         JFreeChart var2 = ChartFactory.createTimeSeriesChart("Legal & General Unit Trust Prices", "Date", "Price Per Unit", var1, true, true, false);
         XYPlot var3 = (XYPlot)var2.getPlot();
         var3.setDomainCrosshairVisible(true);
         var3.setDomainCrosshairLockedOnData(false);
         var3.setRangeCrosshairVisible(false);
         XYItemRenderer var4 = var3.getRenderer();
         if(var4 instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer var5 = (XYLineAndShapeRenderer)var4;
            var5.setBaseShapesVisible(true);
            var5.setBaseShapesFilled(true);
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

      public void stateChanged(ChangeEvent var1) {
         int var2 = this.slider.getValue();
         XYPlot var3 = (XYPlot)this.chart.getPlot();
         ValueAxis var4 = var3.getDomainAxis();
         Range var5 = var4.getRange();
         double var6 = var4.getLowerBound() + (double)var2 / 100.0D * var5.getLength();
         var3.setDomainCrosshairValue(var6);
      }
   }
}
