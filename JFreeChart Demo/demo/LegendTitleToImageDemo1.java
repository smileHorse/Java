package demo;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.Size2D;

public class LegendTitleToImageDemo1 {

   public static void main(String[] var0) throws IOException {
      DefaultPieDataset var1 = new DefaultPieDataset();
      var1.setValue("A", 1.0D);
      var1.setValue("B", 2.0D);
      var1.setValue("C", 3.0D);
      JFreeChart var2 = ChartFactory.createPieChart("Test", var1, true, false, false);
      LegendTitle var3 = var2.getLegend();
      var3.setMargin(0.0D, 0.0D, 1.0D, 1.0D);
      BufferedImage var4 = new BufferedImage(1, 1, 2);
      Graphics2D var5 = var4.createGraphics();
      Size2D var6 = var3.arrange(var5);
      var5.dispose();
      int var7 = (int)Math.rint(var6.width);
      int var8 = (int)Math.rint(var6.height);
      BufferedImage var9 = new BufferedImage(var7, var8, 2);
      Graphics2D var10 = var9.createGraphics();
      var3.draw(var10, new Double(0.0D, 0.0D, (double)var7, (double)var8));
      var10.dispose();
      BufferedOutputStream var11 = new BufferedOutputStream(new FileOutputStream(new File("LegendTitleToImageDemo1.png")));
      ChartUtilities.writeBufferedImageAsPNG(var11, var9);
      var11.close();
   }
}
