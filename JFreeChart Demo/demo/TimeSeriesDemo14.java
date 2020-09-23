package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.util.DefaultShadowGenerator;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo14 extends ApplicationFrame {

   public TimeSeriesDemo14(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(720, 340));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Browser Market Share", "Date", "Market Share", var0, true, true, false);
      var1.addSubtitle(new TextTitle("Source: http://gs.statcounter.com"));
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setShadowGenerator(new DefaultShadowGenerator());
      DateAxis var3 = (DateAxis)var2.getDomainAxis();
      var3.setLowerMargin(0.0D);
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setNumberFormatOverride(new DecimalFormat("0.0%"));
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      XYItemRenderer var5 = var2.getRenderer();
      if(var5 instanceof XYLineAndShapeRenderer) {
         XYLineAndShapeRenderer var6 = (XYLineAndShapeRenderer)var5;
         var6.setBaseStroke(new BasicStroke(3.0F));
         var6.setAutoPopulateSeriesStroke(false);
         var6.setSeriesPaint(0, new Color(1742401));
         var6.setSeriesPaint(1, new Color(10934634));
         var6.setSeriesPaint(2, new Color(16625249));
         var6.setSeriesPaint(3, new Color(16777151));
      }

      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeriesCollection var0 = new TimeSeriesCollection();
      var0.addSeries(createChromeData());
      var0.addSeries(createFirefoxData());
      var0.addSeries(createInternetExplorerData());
      var0.addSeries(createSafariData());
      return var0;
   }

   private static TimeSeries createChromeData() {
      TimeSeries var0 = new TimeSeries("Chrome");
      var0.add(new Month(6, 2013), 0.4268D);
      var0.add(new Month(5, 2013), 0.4138D);
      var0.add(new Month(4, 2013), 0.3915D);
      var0.add(new Month(3, 2013), 0.3807D);
      var0.add(new Month(2, 2013), 0.3709D);
      var0.add(new Month(1, 2013), 0.3652D);
      var0.add(new Month(12, 2012), 0.3642D);
      var0.add(new Month(11, 2012), 0.3572D);
      var0.add(new Month(10, 2012), 0.3477D);
      var0.add(new Month(9, 2012), 0.3421D);
      var0.add(new Month(8, 2012), 0.3359D);
      var0.add(new Month(7, 2012), 0.3381D);
      var0.add(new Month(6, 2012), 0.3276D);
      var0.add(new Month(5, 2012), 0.3243D);
      var0.add(new Month(4, 2012), 0.3123D);
      var0.add(new Month(3, 2012), 0.3087D);
      var0.add(new Month(2, 2012), 0.2984D);
      var0.add(new Month(1, 2012), 0.284D);
      var0.add(new Month(12, 2011), 0.2727D);
      var0.add(new Month(11, 2011), 0.2569D);
      var0.add(new Month(10, 2011), 0.25D);
      var0.add(new Month(9, 2011), 0.2361D);
      var0.add(new Month(8, 2011), 0.2316D);
      var0.add(new Month(7, 2011), 0.2214D);
      var0.add(new Month(6, 2011), 0.2065D);
      var0.add(new Month(5, 2011), 0.1936D);
      var0.add(new Month(4, 2011), 0.1829D);
      var0.add(new Month(3, 2011), 0.1737D);
      var0.add(new Month(2, 2011), 0.1654D);
      var0.add(new Month(1, 2011), 0.1568D);
      var0.add(new Month(12, 2010), 0.1485D);
      var0.add(new Month(11, 2010), 0.1335D);
      var0.add(new Month(10, 2010), 0.1239D);
      var0.add(new Month(9, 2010), 0.1154D);
      var0.add(new Month(8, 2010), 0.1076D);
      var0.add(new Month(7, 2010), 0.0988D);
      var0.add(new Month(6, 2010), 0.0924D);
      var0.add(new Month(5, 2010), 0.0861D);
      var0.add(new Month(4, 2010), 0.0806D);
      var0.add(new Month(3, 2010), 0.0729D);
      var0.add(new Month(2, 2010), 0.0672D);
      var0.add(new Month(1, 2010), 0.0604D);
      var0.add(new Month(12, 2009), 0.0545D);
      var0.add(new Month(11, 2009), 0.0466D);
      var0.add(new Month(10, 2009), 0.0417D);
      var0.add(new Month(9, 2009), 0.0369D);
      var0.add(new Month(8, 2009), 0.0338D);
      var0.add(new Month(7, 2009), 0.0301D);
      var0.add(new Month(6, 2009), 0.0282D);
      var0.add(new Month(5, 2009), 0.0242D);
      var0.add(new Month(4, 2009), 0.0207D);
      var0.add(new Month(3, 2009), 0.0173D);
      var0.add(new Month(2, 2009), 0.0152D);
      var0.add(new Month(1, 2009), 0.0138D);
      return var0;
   }

   private static TimeSeries createFirefoxData() {
      TimeSeries var0 = new TimeSeries("Firefox");
      var0.add(new Month(6, 2013), 0.2001D);
      var0.add(new Month(5, 2013), 0.1976D);
      var0.add(new Month(4, 2013), 0.2006D);
      var0.add(new Month(3, 2013), 0.2087D);
      var0.add(new Month(2, 2013), 0.2134D);
      var0.add(new Month(1, 2013), 0.2142D);
      var0.add(new Month(12, 2012), 0.2189D);
      var0.add(new Month(11, 2012), 0.2237D);
      var0.add(new Month(10, 2012), 0.2232D);
      var0.add(new Month(9, 2012), 0.224D);
      var0.add(new Month(8, 2012), 0.2285D);
      var0.add(new Month(7, 2012), 0.2373D);
      var0.add(new Month(6, 2012), 0.2456D);
      var0.add(new Month(5, 2012), 0.2555D);
      var0.add(new Month(4, 2012), 0.2487D);
      var0.add(new Month(3, 2012), 0.2498D);
      var0.add(new Month(2, 2012), 0.2488D);
      var0.add(new Month(1, 2012), 0.2478D);
      var0.add(new Month(12, 2011), 0.2527D);
      var0.add(new Month(11, 2011), 0.2523D);
      var0.add(new Month(10, 2011), 0.2639D);
      var0.add(new Month(9, 2011), 0.2679D);
      var0.add(new Month(8, 2011), 0.2749D);
      var0.add(new Month(7, 2011), 0.2795D);
      var0.add(new Month(6, 2011), 0.2834D);
      var0.add(new Month(5, 2011), 0.2929D);
      var0.add(new Month(4, 2011), 0.2967D);
      var0.add(new Month(3, 2011), 0.2998D);
      var0.add(new Month(2, 2011), 0.3037D);
      var0.add(new Month(1, 2011), 0.3068D);
      var0.add(new Month(12, 2010), 0.3076D);
      var0.add(new Month(11, 2010), 0.3117D);
      var0.add(new Month(10, 2010), 0.3124D);
      var0.add(new Month(9, 2010), 0.315D);
      var0.add(new Month(8, 2010), 0.3109D);
      var0.add(new Month(7, 2010), 0.3069D);
      var0.add(new Month(6, 2010), 0.3115D);
      var0.add(new Month(5, 2010), 0.3164D);
      var0.add(new Month(4, 2010), 0.3174D);
      var0.add(new Month(3, 2010), 0.3127D);
      var0.add(new Month(2, 2010), 0.3182D);
      var0.add(new Month(1, 2010), 0.3164D);
      var0.add(new Month(12, 2009), 0.3197D);
      var0.add(new Month(11, 2009), 0.3221D);
      var0.add(new Month(10, 2009), 0.3182D);
      var0.add(new Month(9, 2009), 0.3134D);
      var0.add(new Month(8, 2009), 0.3128D);
      var0.add(new Month(7, 2009), 0.305D);
      var0.add(new Month(6, 2009), 0.3033D);
      var0.add(new Month(5, 2009), 0.2875D);
      var0.add(new Month(4, 2009), 0.2967D);
      var0.add(new Month(3, 2009), 0.294D);
      var0.add(new Month(2, 2009), 0.2785D);
      var0.add(new Month(1, 2009), 0.2703D);
      return var0;
   }

   private static TimeSeries createInternetExplorerData() {
      TimeSeries var0 = new TimeSeries("Internet Explorer");
      var0.add(new Month(6, 2013), 0.2544D);
      var0.add(new Month(5, 2013), 0.2772D);
      var0.add(new Month(4, 2013), 0.2971D);
      var0.add(new Month(3, 2013), 0.293D);
      var0.add(new Month(2, 2013), 0.2982D);
      var0.add(new Month(1, 2013), 0.3069D);
      var0.add(new Month(12, 2012), 0.3078D);
      var0.add(new Month(11, 2012), 0.3123D);
      var0.add(new Month(10, 2012), 0.3208D);
      var0.add(new Month(9, 2012), 0.327D);
      var0.add(new Month(8, 2012), 0.3285D);
      var0.add(new Month(7, 2012), 0.3204D);
      var0.add(new Month(6, 2012), 0.3231D);
      var0.add(new Month(5, 2012), 0.3212D);
      var0.add(new Month(4, 2012), 0.3407D);
      var0.add(new Month(3, 2012), 0.3481D);
      var0.add(new Month(2, 2012), 0.3575D);
      var0.add(new Month(1, 2012), 0.3745D);
      var0.add(new Month(12, 2011), 0.3865D);
      var0.add(new Month(11, 2011), 0.4063D);
      var0.add(new Month(10, 2011), 0.4018D);
      var0.add(new Month(9, 2011), 0.4166D);
      var0.add(new Month(8, 2011), 0.4189D);
      var0.add(new Month(7, 2011), 0.4245D);
      var0.add(new Month(6, 2011), 0.4358D);
      var0.add(new Month(5, 2011), 0.4387D);
      var0.add(new Month(4, 2011), 0.4452D);
      var0.add(new Month(3, 2011), 0.4511D);
      var0.add(new Month(2, 2011), 0.4544D);
      var0.add(new Month(1, 2011), 0.46D);
      var0.add(new Month(12, 2010), 0.4694D);
      var0.add(new Month(11, 2010), 0.4816D);
      var0.add(new Month(10, 2010), 0.4921D);
      var0.add(new Month(9, 2010), 0.4987D);
      var0.add(new Month(8, 2010), 0.5134D);
      var0.add(new Month(7, 2010), 0.5268D);
      var0.add(new Month(6, 2010), 0.5286D);
      var0.add(new Month(5, 2010), 0.5277D);
      var0.add(new Month(4, 2010), 0.5326D);
      var0.add(new Month(3, 2010), 0.5444D);
      var0.add(new Month(2, 2010), 0.545D);
      var0.add(new Month(1, 2010), 0.5525D);
      var0.add(new Month(12, 2009), 0.5572D);
      var0.add(new Month(11, 2009), 0.5657D);
      var0.add(new Month(10, 2009), 0.5796D);
      var0.add(new Month(9, 2009), 0.5837D);
      var0.add(new Month(8, 2009), 0.5869D);
      var0.add(new Month(7, 2009), 0.6011D);
      var0.add(new Month(6, 2009), 0.5949D);
      var0.add(new Month(5, 2009), 0.6209D);
      var0.add(new Month(4, 2009), 0.6188D);
      var0.add(new Month(3, 2009), 0.6252D);
      var0.add(new Month(2, 2009), 0.6443D);
      var0.add(new Month(1, 2009), 0.6541D);
      return var0;
   }

   private static TimeSeries createSafariData() {
      TimeSeries var0 = new TimeSeries("Safari");
      var0.add(new Month(6, 2013), 0.0839D);
      var0.add(new Month(5, 2013), 0.0796D);
      var0.add(new Month(4, 2013), 0.08D);
      var0.add(new Month(3, 2013), 0.085D);
      var0.add(new Month(2, 2013), 0.086D);
      var0.add(new Month(1, 2013), 0.083D);
      var0.add(new Month(12, 2012), 0.0792D);
      var0.add(new Month(11, 2012), 0.0783D);
      var0.add(new Month(10, 2012), 0.0781D);
      var0.add(new Month(9, 2012), 0.077D);
      var0.add(new Month(8, 2012), 0.0739D);
      var0.add(new Month(7, 2012), 0.0712D);
      var0.add(new Month(6, 2012), 0.07D);
      var0.add(new Month(5, 2012), 0.0709D);
      var0.add(new Month(4, 2012), 0.0713D);
      var0.add(new Month(3, 2012), 0.0672D);
      var0.add(new Month(2, 2012), 0.0677D);
      var0.add(new Month(1, 2012), 0.0662D);
      var0.add(new Month(12, 2011), 0.0608D);
      var0.add(new Month(11, 2011), 0.0592D);
      var0.add(new Month(10, 2011), 0.0593D);
      var0.add(new Month(9, 2011), 0.056D);
      var0.add(new Month(8, 2011), 0.0519D);
      var0.add(new Month(7, 2011), 0.0517D);
      var0.add(new Month(6, 2011), 0.0507D);
      var0.add(new Month(5, 2011), 0.0501D);
      var0.add(new Month(4, 2011), 0.0504D);
      var0.add(new Month(3, 2011), 0.0502D);
      var0.add(new Month(2, 2011), 0.0508D);
      var0.add(new Month(1, 2011), 0.0509D);
      var0.add(new Month(12, 2010), 0.0479D);
      var0.add(new Month(11, 2010), 0.047D);
      var0.add(new Month(10, 2010), 0.0456D);
      var0.add(new Month(9, 2010), 0.0442D);
      var0.add(new Month(8, 2010), 0.0423D);
      var0.add(new Month(7, 2010), 0.0409D);
      var0.add(new Month(6, 2010), 0.0407D);
      var0.add(new Month(5, 2010), 0.0414D);
      var0.add(new Month(4, 2010), 0.0423D);
      var0.add(new Month(3, 2010), 0.0416D);
      var0.add(new Month(2, 2010), 0.0408D);
      var0.add(new Month(1, 2010), 0.0376D);
      var0.add(new Month(12, 2009), 0.0348D);
      var0.add(new Month(11, 2009), 0.0367D);
      var0.add(new Month(10, 2009), 0.0347D);
      var0.add(new Month(9, 2009), 0.0328D);
      var0.add(new Month(8, 2009), 0.0325D);
      var0.add(new Month(7, 2009), 0.0302D);
      var0.add(new Month(6, 2009), 0.0293D);
      var0.add(new Month(5, 2009), 0.0265D);
      var0.add(new Month(4, 2009), 0.0275D);
      var0.add(new Month(3, 2009), 0.0273D);
      var0.add(new Month(2, 2009), 0.0259D);
      var0.add(new Month(1, 2009), 0.0257D);
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      TimeSeriesDemo14 var1 = new TimeSeriesDemo14("JFreeChart: Time Series Demo 14");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
