package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LineChartDemo3 extends ApplicationFrame {

   public LineChartDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   private static XYDataset createDataset() {
      XYSeriesCollection var0 = new XYSeriesCollection();

      for(int var1 = 0; var1 < 10; ++var1) {
         XYSeries var2 = new XYSeries("S" + var1);

         for(int var3 = 0; var3 < 10; ++var3) {
            var2.add((double)var3, Math.random() * 100.0D);
         }

         var0.addSeries(var2);
      }

      return var0;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("Line Chart Demo 3", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      var2.setDomainZeroBaselineVisible(true);
      var2.setRangeZeroBaselineVisible(true);
      XYLineAndShapeRenderer var3 = (XYLineAndShapeRenderer)var2.getRenderer();
      var3.setBaseShapesVisible(true);
      var3.setBaseShapesFilled(true);
      var3.setDrawOutlines(true);
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      return var1;
   }

   public static void main(String[] var0) {
      LineChartDemo3 var1 = new LineChartDemo3("JFreeChart: LineChartDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
