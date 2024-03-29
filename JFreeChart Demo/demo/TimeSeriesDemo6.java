package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo6 extends ApplicationFrame {

   public TimeSeriesDemo6(String var1) {
      super(var1);
      ChartPanel var2 = (ChartPanel)createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("International Coffee Organisation : Coffee Prices", (String)null, "US cents/lb", var0, true, true, false);
      String var2 = "Palatino";
      var1.getTitle().setFont(new Font(var2, 1, 18));
      var1.addSubtitle(new TextTitle("Source: http://www.ico.org/historical/2010-19/PDF/HIST-PRICES.pdf", new Font(var2, 0, 14)));
      XYPlot var3 = (XYPlot)var1.getPlot();
      var3.setDomainPannable(true);
      var3.setRangePannable(false);
      var3.setDomainCrosshairVisible(true);
      var3.setRangeCrosshairVisible(true);
      var3.getDomainAxis().setLowerMargin(0.0D);
      var3.getDomainAxis().setLabelFont(new Font(var2, 1, 14));
      var3.getDomainAxis().setTickLabelFont(new Font(var2, 0, 12));
      var3.getRangeAxis().setLabelFont(new Font(var2, 1, 14));
      var3.getRangeAxis().setTickLabelFont(new Font(var2, 0, 12));
      var1.getLegend().setItemFont(new Font(var2, 0, 14));
      var1.getLegend().setFrame(BlockBorder.NONE);
      var1.getLegend().setHorizontalAlignment(HorizontalAlignment.CENTER);
      XYItemRenderer var4 = var3.getRenderer();
      if(var4 instanceof XYLineAndShapeRenderer) {
         XYLineAndShapeRenderer var5 = (XYLineAndShapeRenderer)var4;
         var5.setBaseShapesVisible(false);
         var5.setDrawSeriesLineAsPath(true);
         var5.setAutoPopulateSeriesStroke(false);
         var5.setBaseStroke(new BasicStroke(3.0F, 1, 2), false);
         var5.setSeriesPaint(0, Color.RED);
         var5.setSeriesPaint(1, new Color(24, 123, 58));
         var5.setSeriesPaint(2, new Color(149, 201, 136));
         var5.setSeriesPaint(3, new Color(1, 62, 29));
         var5.setSeriesPaint(4, new Color(81, 176, 86));
         var5.setSeriesPaint(5, new Color(0, 55, 122));
         var5.setSeriesPaint(6, new Color(0, 92, 165));
      }

      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Indicator Price");
      var0.add(new Month(1, 2010), 126.8D);
      var0.add(new Month(2, 2010), 123.37D);
      var0.add(new Month(3, 2010), 125.3D);
      var0.add(new Month(4, 2010), 126.89D);
      var0.add(new Month(5, 2010), 128.1D);
      var0.add(new Month(6, 2010), 142.2D);
      var0.add(new Month(7, 2010), 153.41D);
      var0.add(new Month(8, 2010), 157.46D);
      var0.add(new Month(9, 2010), 163.61D);
      var0.add(new Month(10, 2010), 161.56D);
      var0.add(new Month(11, 2010), 173.9D);
      var0.add(new Month(12, 2010), 184.26D);
      var0.add(new Month(1, 2011), 197.35D);
      var0.add(new Month(2, 2011), 216.03D);
      var0.add(new Month(3, 2011), 224.33D);
      var0.add(new Month(4, 2011), 231.24D);
      var0.add(new Month(5, 2011), 227.97D);
      var0.add(new Month(6, 2011), 215.58D);
      var0.add(new Month(7, 2011), 210.36D);
      var0.add(new Month(8, 2011), 212.19D);
      var0.add(new Month(9, 2011), 213.04D);
      var0.add(new Month(10, 2011), 193.9D);
      var0.add(new Month(11, 2011), 193.66D);
      var0.add(new Month(12, 2011), 189.02D);
      var0.add(new Month(1, 2012), 188.9D);
      var0.add(new Month(2, 2012), 182.29D);
      var0.add(new Month(3, 2012), 167.77D);
      var0.add(new Month(4, 2012), 160.46D);
      var0.add(new Month(5, 2012), 157.68D);
      var0.add(new Month(6, 2012), 145.31D);
      var0.add(new Month(7, 2012), 159.07D);
      var0.add(new Month(8, 2012), 148.5D);
      var0.add(new Month(9, 2012), 151.28D);
      var0.add(new Month(10, 2012), 147.12D);
      var0.add(new Month(11, 2012), 136.35D);
      var0.add(new Month(12, 2012), 131.31D);
      var0.add(new Month(1, 2013), 135.38D);
      var0.add(new Month(2, 2013), 131.51D);
      var0.add(new Month(3, 2013), 131.38D);
      TimeSeries var1 = new TimeSeries("Columbian Milds");
      var1.add(new Month(1, 2010), 207.51D);
      var1.add(new Month(2, 2010), 204.71D);
      var1.add(new Month(3, 2010), 205.71D);
      var1.add(new Month(4, 2010), 200.0D);
      var1.add(new Month(5, 2010), 200.54D);
      var1.add(new Month(6, 2010), 224.49D);
      var1.add(new Month(7, 2010), 235.52D);
      var1.add(new Month(8, 2010), 243.98D);
      var1.add(new Month(9, 2010), 247.77D);
      var1.add(new Month(10, 2010), 230.02D);
      var1.add(new Month(11, 2010), 244.02D);
      var1.add(new Month(12, 2010), 261.97D);
      var1.add(new Month(1, 2011), 279.88D);
      var1.add(new Month(2, 2011), 296.44D);
      var1.add(new Month(3, 2011), 300.68D);
      var1.add(new Month(4, 2011), 312.95D);
      var1.add(new Month(5, 2011), 302.17D);
      var1.add(new Month(6, 2011), 287.95D);
      var1.add(new Month(7, 2011), 285.21D);
      var1.add(new Month(8, 2011), 286.97D);
      var1.add(new Month(9, 2011), 287.54D);
      var1.add(new Month(10, 2011), 257.66D);
      var1.add(new Month(11, 2011), 256.99D);
      var1.add(new Month(12, 2011), 251.6D);
      var1.add(new Month(1, 2012), 255.91D);
      var1.add(new Month(2, 2012), 244.14D);
      var1.add(new Month(3, 2012), 222.84D);
      var1.add(new Month(4, 2012), 214.46D);
      var1.add(new Month(5, 2012), 207.32D);
      var1.add(new Month(6, 2012), 184.67D);
      var1.add(new Month(7, 2012), 202.56D);
      var1.add(new Month(8, 2012), 187.14D);
      var1.add(new Month(9, 2012), 190.1D);
      var1.add(new Month(10, 2012), 181.39D);
      var1.add(new Month(11, 2012), 170.08D);
      var1.add(new Month(12, 2012), 164.4D);
      var1.add(new Month(1, 2013), 169.19D);
      var1.add(new Month(2, 2013), 161.7D);
      var1.add(new Month(3, 2013), 161.53D);
      TimeSeries var2 = new TimeSeries("Other Milds");
      var2.add(new Month(1, 2010), 158.9D);
      var2.add(new Month(2, 2010), 157.86D);
      var2.add(new Month(3, 2010), 164.5D);
      var2.add(new Month(4, 2010), 169.55D);
      var2.add(new Month(5, 2010), 173.38D);
      var2.add(new Month(6, 2010), 190.9D);
      var2.add(new Month(7, 2010), 203.21D);
      var2.add(new Month(8, 2010), 211.59D);
      var2.add(new Month(9, 2010), 222.71D);
      var2.add(new Month(10, 2010), 217.64D);
      var2.add(new Month(11, 2010), 233.48D);
      var2.add(new Month(12, 2010), 248.17D);
      var2.add(new Month(1, 2011), 263.77D);
      var2.add(new Month(2, 2011), 287.89D);
      var2.add(new Month(3, 2011), 292.07D);
      var2.add(new Month(4, 2011), 300.12D);
      var2.add(new Month(5, 2011), 291.09D);
      var2.add(new Month(6, 2011), 274.98D);
      var2.add(new Month(7, 2011), 268.02D);
      var2.add(new Month(8, 2011), 270.44D);
      var2.add(new Month(9, 2011), 274.88D);
      var2.add(new Month(10, 2011), 247.82D);
      var2.add(new Month(11, 2011), 245.09D);
      var2.add(new Month(12, 2011), 236.71D);
      var2.add(new Month(1, 2012), 237.21D);
      var2.add(new Month(2, 2012), 224.16D);
      var2.add(new Month(3, 2012), 201.26D);
      var2.add(new Month(4, 2012), 191.45D);
      var2.add(new Month(5, 2012), 184.65D);
      var2.add(new Month(6, 2012), 168.69D);
      var2.add(new Month(7, 2012), 190.45D);
      var2.add(new Month(8, 2012), 174.82D);
      var2.add(new Month(9, 2012), 178.98D);
      var2.add(new Month(10, 2012), 173.32D);
      var2.add(new Month(11, 2012), 159.91D);
      var2.add(new Month(12, 2012), 152.74D);
      var2.add(new Month(1, 2013), 157.29D);
      var2.add(new Month(2, 2013), 149.46D);
      var2.add(new Month(3, 2013), 149.78D);
      TimeSeries var3 = new TimeSeries("Brazilian Naturals");
      var3.add(new Month(1, 2010), 131.67D);
      var3.add(new Month(2, 2010), 124.57D);
      var3.add(new Month(3, 2010), 126.21D);
      var3.add(new Month(4, 2010), 126.07D);
      var3.add(new Month(5, 2010), 127.45D);
      var3.add(new Month(6, 2010), 143.2D);
      var3.add(new Month(7, 2010), 156.87D);
      var3.add(new Month(8, 2010), 163.21D);
      var3.add(new Month(9, 2010), 175.15D);
      var3.add(new Month(10, 2010), 175.38D);
      var3.add(new Month(11, 2010), 190.62D);
      var3.add(new Month(12, 2010), 204.25D);
      var3.add(new Month(1, 2011), 219.77D);
      var3.add(new Month(2, 2011), 247.0D);
      var3.add(new Month(3, 2011), 260.98D);
      var3.add(new Month(4, 2011), 273.4D);
      var3.add(new Month(5, 2011), 268.66D);
      var3.add(new Month(6, 2011), 250.59D);
      var3.add(new Month(7, 2011), 245.69D);
      var3.add(new Month(8, 2011), 249.83D);
      var3.add(new Month(9, 2011), 255.64D);
      var3.add(new Month(10, 2011), 234.28D);
      var3.add(new Month(11, 2011), 236.75D);
      var3.add(new Month(12, 2011), 228.79D);
      var3.add(new Month(1, 2012), 228.21D);
      var3.add(new Month(2, 2012), 215.4D);
      var3.add(new Month(3, 2012), 192.03D);
      var3.add(new Month(4, 2012), 180.9D);
      var3.add(new Month(5, 2012), 174.17D);
      var3.add(new Month(6, 2012), 156.17D);
      var3.add(new Month(7, 2012), 175.98D);
      var3.add(new Month(8, 2012), 160.05D);
      var3.add(new Month(9, 2012), 166.53D);
      var3.add(new Month(10, 2012), 161.2D);
      var3.add(new Month(11, 2012), 148.25D);
      var3.add(new Month(12, 2012), 140.69D);
      var3.add(new Month(1, 2013), 145.17D);
      var3.add(new Month(2, 2013), 136.63D);
      var3.add(new Month(3, 2013), 133.61D);
      TimeSeries var4 = new TimeSeries("Robustas");
      var4.add(new Month(1, 2010), 69.92D);
      var4.add(new Month(2, 2010), 67.88D);
      var4.add(new Month(3, 2010), 67.25D);
      var4.add(new Month(4, 2010), 71.59D);
      var4.add(new Month(5, 2010), 70.7D);
      var4.add(new Month(6, 2010), 76.92D);
      var4.add(new Month(7, 2010), 85.27D);
      var4.add(new Month(8, 2010), 82.68D);
      var4.add(new Month(9, 2010), 81.28D);
      var4.add(new Month(10, 2010), 85.27D);
      var4.add(new Month(11, 2010), 92.04D);
      var4.add(new Month(12, 2010), 94.09D);
      var4.add(new Month(1, 2011), 101.09D);
      var4.add(new Month(2, 2011), 109.35D);
      var4.add(new Month(3, 2011), 118.13D);
      var4.add(new Month(4, 2011), 117.37D);
      var4.add(new Month(5, 2011), 121.98D);
      var4.add(new Month(6, 2011), 117.95D);
      var4.add(new Month(7, 2011), 112.73D);
      var4.add(new Month(8, 2011), 112.07D);
      var4.add(new Month(9, 2011), 106.06D);
      var4.add(new Month(10, 2011), 98.1D);
      var4.add(new Month(11, 2011), 97.24D);
      var4.add(new Month(12, 2011), 98.41D);
      var4.add(new Month(1, 2012), 96.72D);
      var4.add(new Month(2, 2012), 101.93D);
      var4.add(new Month(3, 2012), 103.57D);
      var4.add(new Month(4, 2012), 101.8D);
      var4.add(new Month(5, 2012), 106.88D);
      var4.add(new Month(6, 2012), 105.7D);
      var4.add(new Month(7, 2012), 107.06D);
      var4.add(new Month(8, 2012), 106.52D);
      var4.add(new Month(9, 2012), 104.95D);
      var4.add(new Month(10, 2012), 104.47D);
      var4.add(new Month(11, 2012), 97.67D);
      var4.add(new Month(12, 2012), 96.59D);
      var4.add(new Month(1, 2013), 99.69D);
      var4.add(new Month(2, 2013), 104.03D);
      var4.add(new Month(3, 2013), 106.26D);
      TimeSeries var5 = new TimeSeries("Futures (London)");
      var5.add(new Month(1, 2010), 62.66D);
      var5.add(new Month(2, 2010), 60.37D);
      var5.add(new Month(3, 2010), 58.64D);
      var5.add(new Month(4, 2010), 62.21D);
      var5.add(new Month(5, 2010), 62.46D);
      var5.add(new Month(6, 2010), 69.72D);
      var5.add(new Month(7, 2010), 78.17D);
      var5.add(new Month(8, 2010), 78.42D);
      var5.add(new Month(9, 2010), 75.87D);
      var5.add(new Month(10, 2010), 80.08D);
      var5.add(new Month(11, 2010), 86.4D);
      var5.add(new Month(12, 2010), 88.7D);
      var5.add(new Month(1, 2011), 96.02D);
      var5.add(new Month(2, 2011), 104.53D);
      var5.add(new Month(3, 2011), 111.36D);
      var5.add(new Month(4, 2011), 111.34D);
      var5.add(new Month(5, 2011), 116.76D);
      var5.add(new Month(6, 2011), 110.51D);
      var5.add(new Month(7, 2011), 103.36D);
      var5.add(new Month(8, 2011), 102.71D);
      var5.add(new Month(9, 2011), 96.1D);
      var5.add(new Month(10, 2011), 88.64D);
      var5.add(new Month(11, 2011), 85.78D);
      var5.add(new Month(12, 2011), 87.65D);
      var5.add(new Month(1, 2012), 84.19D);
      var5.add(new Month(2, 2012), 88.69D);
      var5.add(new Month(3, 2012), 91.37D);
      var5.add(new Month(4, 2012), 91.81D);
      var5.add(new Month(5, 2012), 96.82D);
      var5.add(new Month(6, 2012), 94.75D);
      var5.add(new Month(7, 2012), 96.14D);
      var5.add(new Month(8, 2012), 96.12D);
      var5.add(new Month(9, 2012), 94.65D);
      var5.add(new Month(10, 2012), 94.66D);
      var5.add(new Month(11, 2012), 87.32D);
      var5.add(new Month(12, 2012), 85.94D);
      var5.add(new Month(1, 2013), 88.85D);
      var5.add(new Month(2, 2013), 94.41D);
      var5.add(new Month(3, 2013), 97.22D);
      TimeSeries var6 = new TimeSeries("Futures (New York)");
      var6.add(new Month(1, 2010), 142.76D);
      var6.add(new Month(2, 2010), 134.35D);
      var6.add(new Month(3, 2010), 134.97D);
      var6.add(new Month(4, 2010), 135.12D);
      var6.add(new Month(5, 2010), 135.81D);
      var6.add(new Month(6, 2010), 152.36D);
      var6.add(new Month(7, 2010), 165.23D);
      var6.add(new Month(8, 2010), 175.1D);
      var6.add(new Month(9, 2010), 187.8D);
      var6.add(new Month(10, 2010), 190.43D);
      var6.add(new Month(11, 2010), 206.92D);
      var6.add(new Month(12, 2010), 221.51D);
      var6.add(new Month(1, 2011), 238.05D);
      var6.add(new Month(2, 2011), 261.41D);
      var6.add(new Month(3, 2011), 274.1D);
      var6.add(new Month(4, 2011), 285.58D);
      var6.add(new Month(5, 2011), 277.72D);
      var6.add(new Month(6, 2011), 262.52D);
      var6.add(new Month(7, 2011), 255.9D);
      var6.add(new Month(8, 2011), 260.39D);
      var6.add(new Month(9, 2011), 261.39D);
      var6.add(new Month(10, 2011), 236.74D);
      var6.add(new Month(11, 2011), 235.25D);
      var6.add(new Month(12, 2011), 227.23D);
      var6.add(new Month(1, 2012), 227.5D);
      var6.add(new Month(2, 2012), 212.09D);
      var6.add(new Month(3, 2012), 188.78D);
      var6.add(new Month(4, 2012), 181.75D);
      var6.add(new Month(5, 2012), 176.5D);
      var6.add(new Month(6, 2012), 159.93D);
      var6.add(new Month(7, 2012), 183.2D);
      var6.add(new Month(8, 2012), 169.77D);
      var6.add(new Month(9, 2012), 175.36D);
      var6.add(new Month(10, 2012), 170.43D);
      var6.add(new Month(11, 2012), 155.72D);
      var6.add(new Month(12, 2012), 149.58D);
      var6.add(new Month(1, 2013), 154.28D);
      var6.add(new Month(2, 2013), 144.89D);
      var6.add(new Month(3, 2013), 141.43D);
      TimeSeriesCollection var7 = new TimeSeriesCollection();
      var7.addSeries(var0);
      var7.addSeries(var1);
      var7.addSeries(var2);
      var7.addSeries(var3);
      var7.addSeries(var4);
      var7.addSeries(var5);
      var7.addSeries(var6);
      return var7;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      return var1;
   }

   public static void main(String[] var0) {
      TimeSeriesDemo6 var1 = new TimeSeriesDemo6("JFreeChart: TimeSeriesDemo6.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
