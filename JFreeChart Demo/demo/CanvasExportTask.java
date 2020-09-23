package demo;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.JFreeChart;
import org.jfree.graphics2d.canvas.CanvasGraphics2D;
import org.jfree.graphics2d.canvas.CanvasUtils;
import org.jfree.ui.RectangleInsets;

public class CanvasExportTask implements Runnable {

   JFreeChart chart;
   int width;
   int height;
   File file;


   public CanvasExportTask(JFreeChart var1, int var2, int var3, File var4) {
      this.chart = var1;
      this.file = var4;
      this.width = var2;
      this.height = var3;
      var1.setBorderVisible(true);
      var1.setPadding(new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D));
   }

   public void run() {
      try {
         CanvasGraphics2D var1 = new CanvasGraphics2D("canvas1");
         this.chart.draw(var1, new Rectangle(this.width, this.height));
         CanvasUtils.writeToHTML(this.file, "", var1.getCanvasID(), this.width, this.height, var1.getScript() + "\n");
      } catch (IOException var2) {
         throw new RuntimeException(var2);
      }
   }
}
