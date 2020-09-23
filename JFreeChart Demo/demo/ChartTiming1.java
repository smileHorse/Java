package demo;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ChartTiming1 implements ActionListener {

   private boolean finished;


   public void run() {
      this.finished = false;
      DefaultPieDataset var1 = new DefaultPieDataset();
      var1.setValue("One", new Double(10.3D));
      var1.setValue("Two", new Double(8.5D));
      var1.setValue("Three", new Double(3.9D));
      var1.setValue("Four", new Double(3.9D));
      var1.setValue("Five", new Double(3.9D));
      var1.setValue("Six", new Double(3.9D));
      boolean var2 = true;
      JFreeChart var3 = ChartFactory.createPieChart("Testing", var1, var2, true, false);
      BufferedImage var4 = new BufferedImage(400, 300, 1);
      Graphics2D var5 = var4.createGraphics();
      java.awt.geom.Rectangle2D.Double var6 = new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, 400.0D, 300.0D);
      Timer var7 = new Timer(10000, this);
      var7.setRepeats(false);
      int var8 = 0;
      var7.start();

      while(!this.finished) {
         var3.draw(var5, var6, (Point2D)null, (ChartRenderingInfo)null);
         System.out.println("Charts drawn..." + var8);
         if(!this.finished) {
            ++var8;
         }
      }

      System.out.println("DONE");
   }

   public void actionPerformed(ActionEvent var1) {
      this.finished = true;
   }

   public static void main(String[] var0) {
      ChartTiming1 var1 = new ChartTiming1();
      var1.run();
   }
}
