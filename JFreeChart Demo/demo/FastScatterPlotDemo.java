package demo;

import java.awt.Dimension;
import java.awt.RenderingHints;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class FastScatterPlotDemo extends ApplicationFrame {

   private static final int COUNT = 100000;
   private float[][] data = new float[2][100000];


   public FastScatterPlotDemo(String var1) {
      super(var1);
      this.populateData();
      NumberAxis var2 = new NumberAxis("X");
      var2.setAutoRangeIncludesZero(false);
      NumberAxis var3 = new NumberAxis("Y");
      var3.setAutoRangeIncludesZero(false);
      FastScatterPlot var4 = new FastScatterPlot(this.data, var2, var3);
      var4.setDomainPannable(true);
      var4.setRangePannable(true);
      JFreeChart var5 = new JFreeChart("Fast Scatter Plot", var4);
      var5.addSubtitle(new TextTitle("This chart contains 100000 data points."));
      ChartUtilities.applyCurrentTheme(var5);
      var5.getRenderingHints().put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      ChartPanel var6 = new ChartPanel(var5, true);
      var6.setPreferredSize(new Dimension(500, 270));
      var6.setDomainZoomable(true);
      var6.setRangeZoomable(true);
      var6.setMinimumDrawHeight(10);
      var6.setMaximumDrawHeight(2000);
      var6.setMinimumDrawWidth(20);
      var6.setMaximumDrawWidth(2000);
      var6.setMouseWheelEnabled(true);
      this.setContentPane(var6);
   }

   private void populateData() {
      for(int var1 = 0; var1 < this.data[0].length; ++var1) {
         float var2 = (float)var1 + 100000.0F;
         this.data[0][var1] = var2;
         this.data[1][var1] = 100000.0F + (float)Math.random() * 100000.0F;
      }

   }

   public static void main(String[] var0) {
      FastScatterPlotDemo var1 = new FastScatterPlotDemo("JFreeChart: FastScatterPlotDemo.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
