package demo;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.data.general.DefaultValueDataset;

public class MeterChartDemo4 {

   public static void main(String[] var0) {
      DefaultValueDataset var1 = new DefaultValueDataset(75.0D);
      MeterPlot var2 = new MeterPlot(var1);
      JFreeChart var3 = new JFreeChart("Scaled Image Test", var2);
      ChartUtilities.applyCurrentTheme(var3);

      try {
         File var4 = new File("meterchart100.png");
         BufferedOutputStream var5 = new BufferedOutputStream(new FileOutputStream(var4));
         BufferedImage var6 = var3.createBufferedImage(200, 200, 400.0D, 400.0D, (ChartRenderingInfo)null);
         ChartUtilities.writeBufferedImageAsPNG(var5, var6);
      } catch (IOException var7) {
         System.out.println(var7.toString());
      }

   }
}
