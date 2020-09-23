package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GridBandDemo1 extends ApplicationFrame {

   public GridBandDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createScatterPlot("Grid Band Demo 1", "X", "Y", var0, PlotOrientation.VERTICAL, true, false, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setNoDataMessage("NO DATA");
      var2.setRangeZeroBaselineVisible(true);
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      var2.setDomainTickBandPaint(new Color(0, 100, 0, 50));
      var2.setRangeTickBandPaint(new Color(0, 100, 0, 50));
      return var1;
   }

   public static JPanel createDemoPanel() {
      XYSeries var0 = new XYSeries("Random Data");

      for(int var1 = 0; var1 < 100; ++var1) {
         var0.add(Math.random() + 1.0D, Math.random() + 1.0D);
      }

      XYSeriesCollection var4 = new XYSeriesCollection();
      var4.addSeries(var0);
      JFreeChart var2 = createChart(var4);
      ChartPanel var3 = new ChartPanel(var2);
      var3.setMouseWheelEnabled(true);
      return var3;
   }

   public static void main(String[] var0) {
      GridBandDemo1 var1 = new GridBandDemo1("JFreeChart: GridBandDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
