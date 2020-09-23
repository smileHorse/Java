package demo;

import demo.SampleXYDataset2;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;

public class ChartTiming2 implements ActionListener {

   private boolean finished;


   public void run() {
      this.finished = false;
      SampleXYDataset2 var1 = new SampleXYDataset2(1, 1440);
      boolean var2 = true;
      JFreeChart var3 = ChartFactory.createScatterPlot("Scatter plot timing", "X", "Y", var1, PlotOrientation.VERTICAL, var2, false, false);
      XYPlot var4 = (XYPlot)var3.getPlot();
      var4.setRenderer(new XYDotRenderer());
      BufferedImage var5 = new BufferedImage(400, 300, 1);
      Graphics2D var6 = var5.createGraphics();
      Double var7 = new Double(0.0D, 0.0D, 400.0D, 300.0D);
      Timer var8 = new Timer(10000, this);
      var8.setRepeats(false);
      int var9 = 0;
      var8.start();

      while(!this.finished) {
         var3.draw(var6, var7, (Point2D)null, (ChartRenderingInfo)null);
         System.out.println("Charts drawn..." + var9);
         if(!this.finished) {
            ++var9;
         }
      }

      System.out.println("DONE");
   }

   public void actionPerformed(ActionEvent var1) {
      this.finished = true;
   }

   public static void main(String[] var0) {
      ChartTiming2 var1 = new ChartTiming2();
      var1.run();
   }
}
