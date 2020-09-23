package demo;

import java.awt.Paint;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

public class SparklineDemo1 {

   public static void main(String[] var0) {
      XYSeries var1 = new XYSeries("Series 1");
      var1.add(1.0D, 1.0D);
      var1.add(2.0D, 3.0D);
      var1.add(3.0D, 2.0D);
      var1.add(4.0D, 4.0D);
      XYSeriesCollection var2 = new XYSeriesCollection();
      var2.addSeries(var1);
      JFreeChart var3 = ChartFactory.createXYLineChart((String)null, "X", "Y", var2, PlotOrientation.VERTICAL, false, false, false);
      XYPlot var4 = (XYPlot)var3.getPlot();
      var4.setInsets(RectangleInsets.ZERO_INSETS);
      var4.setDomainGridlinesVisible(false);
      var4.setRangeGridlinesVisible(false);
      var4.setOutlinePaint((Paint)null);
      var4.getDomainAxis().setVisible(false);
      var4.getRangeAxis().setVisible(false);

      try {
         ChartUtilities.saveChartAsPNG(new File("Sparky.png"), var3, 100, 20);
      } catch (IOException var6) {
         var6.printStackTrace();
      }

   }
}
