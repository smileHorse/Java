package demo;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.LegendItemEntity;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MouseListenerDemo3 extends ApplicationFrame implements ChartMouseListener {

   private JFreeChart chart;


   public MouseListenerDemo3(String var1) {
      super(var1);
      String var2 = "Legal & General Unit Trust Prices";
      XYDataset var3 = this.createDataset();
      this.chart = ChartFactory.createTimeSeriesChart(var2, "Date", "Price Per Unit", var3, true, true, false);
      this.chart.addSubtitle(new TextTitle("Click on the legend to see series highlighted..."));
      XYPlot var4 = (XYPlot)this.chart.getPlot();
      DateAxis var5 = (DateAxis)var4.getDomainAxis();
      var5.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
      ChartPanel var6 = new ChartPanel(this.chart);
      var6.setPreferredSize(new Dimension(500, 270));
      var6.setMouseZoomable(true);
      var6.addChartMouseListener(this);
      this.setContentPane(var6);
   }

   public XYDataset createDataset() {
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
      var3.setXPosition(TimePeriodAnchor.MIDDLE);
      return var3;
   }

   public void chartMouseClicked(ChartMouseEvent var1) {
      ChartEntity var2 = var1.getEntity();
      if(var2 != null && var2 instanceof LegendItemEntity) {
         LegendItemEntity var3 = (LegendItemEntity)var2;
         Comparable var4 = var3.getSeriesKey();
         XYPlot var5 = (XYPlot)this.chart.getPlot();
         XYDataset var6 = var5.getDataset();
         XYItemRenderer var7 = var5.getRenderer();

         for(int var8 = 0; var8 < var6.getSeriesCount(); ++var8) {
            var7.setSeriesStroke(var8, new BasicStroke(1.0F));
            if(var6.getSeriesKey(var8).equals(var4)) {
               var7.setSeriesStroke(var8, new BasicStroke(2.0F));
            }
         }
      }

   }

   public void chartMouseMoved(ChartMouseEvent var1) {}

   public static void main(String[] var0) {
      MouseListenerDemo3 var1 = new MouseListenerDemo3("JFreeChart: MouseListenerDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
