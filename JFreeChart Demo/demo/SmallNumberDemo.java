package demo;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.StandardTickUnitSource;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class SmallNumberDemo extends ApplicationFrame {

   public SmallNumberDemo(String var1) {
      super(var1);
      XYSeries var2 = new XYSeries("Small Numbers");
      var2.add(1.0E-5D, 1.0E-16D);
      var2.add(5.0E-5D, 2.0E-12D);
      XYSeriesCollection var3 = new XYSeriesCollection(var2);
      JFreeChart var4 = ChartFactory.createXYLineChart("Small Number Demo", "X", "Y", var3, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var5 = (XYPlot)var4.getPlot();
      NumberAxis var6 = (NumberAxis)var5.getDomainAxis();
      var6.setStandardTickUnits(new StandardTickUnitSource());
      NumberAxis var7 = (NumberAxis)var5.getRangeAxis();
      var7.setStandardTickUnits(new StandardTickUnitSource());
      var7.setAutoRangeMinimumSize(Double.MIN_VALUE);
      ChartPanel var8 = new ChartPanel(var4);
      var8.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var8);
   }

   public static void main(String[] var0) {
      System.out.println("Min Double: 4.9E-324");
      SmallNumberDemo var1 = new SmallNumberDemo("Small Number Demo");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
