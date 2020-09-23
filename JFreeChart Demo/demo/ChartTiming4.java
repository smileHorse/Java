package demo;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.FastScatterPlot;

public class ChartTiming4 implements ActionListener {

   private boolean finished;
   private float[][] data = new float[2][1440];


   public void run() {
      this.finished = false;
      this.populateData();
      FastScatterPlot var1 = new FastScatterPlot(this.data, new NumberAxis("X"), new NumberAxis("Y"));
      JFreeChart var2 = new JFreeChart("Fast Scatter Plot Timing", JFreeChart.DEFAULT_TITLE_FONT, var1, true);
      BufferedImage var3 = new BufferedImage(400, 300, 1);
      Graphics2D var4 = var3.createGraphics();
      Double var5 = new Double(0.0D, 0.0D, 400.0D, 300.0D);
      Timer var6 = new Timer(10000, this);
      var6.setRepeats(false);
      int var7 = 0;
      var6.start();

      while(!this.finished) {
         var2.draw(var4, var5, (Point2D)null, (ChartRenderingInfo)null);
         System.out.println("Charts drawn..." + var7);
         if(!this.finished) {
            ++var7;
         }
      }

      System.out.println("DONE");
   }

   public void actionPerformed(ActionEvent var1) {
      this.finished = true;
   }

   private void populateData() {
      for(int var1 = 0; var1 < this.data[0].length; ++var1) {
         float var2 = (float)var1;
         this.data[0][var1] = var2;
         this.data[1][var1] = 100.0F + 2.0F * var2 + (float)Math.random() * 1440.0F;
      }

   }

   public static void main(String[] var0) {
      ChartTiming4 var1 = new ChartTiming4();
      var1.run();
   }
}
