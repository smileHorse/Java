package demo;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.JFreeChart;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;
import org.jfree.ui.RectangleInsets;

public class SVGExportTask implements Runnable {

   JFreeChart chart;
   int width;
   int height;
   File file;


   public SVGExportTask(JFreeChart var1, int var2, int var3, File var4) {
      this.chart = var1;
      this.file = var4;
      this.width = var2;
      this.height = var3;
      var1.setBorderVisible(true);
      var1.setPadding(new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D));
   }

   public void run() {
      try {
         SVGGraphics2D var1 = new SVGGraphics2D(this.width, this.height);
         this.chart.draw(var1, new Rectangle(this.width, this.height));
         SVGUtils.writeToHTML(this.file, "title", var1.getSVGElement());
      } catch (IOException var2) {
         throw new RuntimeException(var2);
      }
   }
}
