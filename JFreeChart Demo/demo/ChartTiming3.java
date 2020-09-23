package demo;

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
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartTiming3 implements ActionListener {

   private boolean finished;


   public void run() {
      this.finished = false;
      XYSeries var1 = new XYSeries("Random Data");

      for(int var2 = 0; var2 < 1440; ++var2) {
         double var3 = Math.random();
         double var5 = Math.random();
         var1.add(var3, var5);
      }

      XYSeriesCollection var11 = new XYSeriesCollection(var1);
      boolean var12 = true;
      JFreeChart var4 = ChartFactory.createScatterPlot("Scatter plot timing", "X", "Y", var11, PlotOrientation.VERTICAL, var12, false, false);
      XYPlot var13 = (XYPlot)var4.getPlot();
      var13.setRenderer(new XYDotRenderer());
      BufferedImage var6 = new BufferedImage(400, 300, 1);
      Graphics2D var7 = var6.createGraphics();
      Double var8 = new Double(0.0D, 0.0D, 400.0D, 300.0D);
      Timer var9 = new Timer(10000, this);
      var9.setRepeats(false);
      int var10 = 0;
      var9.start();

      while(!this.finished) {
         var4.draw(var7, var8, (Point2D)null, (ChartRenderingInfo)null);
         System.out.println("Charts drawn..." + var10);
         if(!this.finished) {
            ++var10;
         }
      }

      System.out.println("DONE");
   }

   public void actionPerformed(ActionEvent var1) {
      this.finished = true;
   }

   public static void main(String[] var0) {
      ChartTiming3 var1 = new ChartTiming3();
      var1.run();
   }
}
