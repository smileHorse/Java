package demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Second {

   public static void main(String[] var0) {
      XYSeries var1 = new XYSeries("Advisory Range");
      var1.add(new Integer(1200), new Integer(1));
      var1.add(new Integer(1500), new Integer(1));
      XYSeries var2 = new XYSeries("Normal Range");
      var2.add(new Integer(2000), new Integer(4));
      var2.add(new Integer(2300), new Integer(4));
      XYSeries var3 = new XYSeries("Recommended");
      var3.add(new Integer(2100), new Integer(2));
      XYSeries var4 = new XYSeries("Current");
      var4.add(new Integer(2400), new Integer(3));
      XYSeriesCollection var5 = new XYSeriesCollection();
      var5.addSeries(var1);
      var5.addSeries(var2);
      var5.addSeries(var3);
      var5.addSeries(var4);
      JFreeChart var6 = ChartFactory.createXYLineChart("My Chart", "Calories", "Y", var5, PlotOrientation.VERTICAL, true, true, false);
      StandardXYItemRenderer var7 = new StandardXYItemRenderer(3, (XYToolTipGenerator)null);
      XYPlot var8 = (XYPlot)var6.getPlot();
      var8.setRenderer(var7);
      ValueAxis var9 = var8.getRangeAxis();
      var9.setTickLabelsVisible(false);
      var9.setRange(0.0D, 5.0D);
      ChartFrame var10 = new ChartFrame("Test", var6);
      var10.pack();
      var10.setVisible(true);
   }
}
