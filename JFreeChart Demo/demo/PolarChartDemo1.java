package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PolarChartDemo1 extends ApplicationFrame {

   public PolarChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static XYDataset createDataset() {
      XYSeriesCollection var0 = new XYSeriesCollection();
      XYSeries var1 = new XYSeries("Series 1");
      var1.add(0.0D, 2.0D);
      var1.add(90.0D, 13.0D);
      var1.add(180.0D, 9.0D);
      var1.add(270.0D, 8.0D);
      var0.addSeries(var1);
      XYSeries var2 = new XYSeries("Series 2");
      var2.add(90.0D, -11.2D);
      var2.add(180.0D, 21.4D);
      var2.add(250.0D, 17.3D);
      var2.add(355.0D, 10.9D);
      var0.addSeries(var2);
      return var0;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createPolarChart("Polar Chart Demo 1", var0, true, false, false);
      PolarPlot var2 = (PolarPlot)var1.getPlot();
      var2.addCornerTextItem("Corner Item 1");
      var2.addCornerTextItem("Corner Item 2");
      var2.setAngleGridlinePaint(Color.white);
      var2.setRadiusGridlinePaint(Color.white);
      NumberAxis var3 = (NumberAxis)var2.getAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseZoomable(false);
      return var1;
   }

   public static void main(String[] var0) {
      PolarChartDemo1 var1 = new PolarChartDemo1("JFreeChart: PolarChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
