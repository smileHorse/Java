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

public class LineChartDemo2 extends ApplicationFrame {

   public LineChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static XYDataset createDataset() {
      XYSeries var0 = new XYSeries("First");
      var0.add(1.0D, 1.0D);
      var0.add(2.0D, 4.0D);
      var0.add(3.0D, 3.0D);
      var0.add(4.0D, 5.0D);
      var0.add(5.0D, 5.0D);
      var0.add(6.0D, 7.0D);
      var0.add(7.0D, 7.0D);
      var0.add(8.0D, 8.0D);
      XYSeries var1 = new XYSeries("Second");
      var1.add(1.0D, 5.0D);
      var1.add(2.0D, 7.0D);
      var1.add(3.0D, 6.0D);
      var1.add(4.0D, 8.0D);
      var1.add(5.0D, 4.0D);
      var1.add(6.0D, 4.0D);
      var1.add(7.0D, 2.0D);
      var1.add(8.0D, 1.0D);
      XYSeries var2 = new XYSeries("Third");
      var2.add(3.0D, 4.0D);
      var2.add(4.0D, 3.0D);
      var2.add(5.0D, 2.0D);
      var2.add(6.0D, 3.0D);
      var2.add(7.0D, 6.0D);
      var2.add(8.0D, 3.0D);
      var2.add(9.0D, 4.0D);
      var2.add(10.0D, 3.0D);
      XYSeriesCollection var3 = new XYSeriesCollection();
      var3.addSeries(var0);
      var3.addSeries(var1);
      var3.addSeries(var2);
      return var3;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("Line Chart Demo 2", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      XYLineAndShapeRenderer var3 = (XYLineAndShapeRenderer)var2.getRenderer();
      var3.setBaseShapesVisible(true);
      var3.setBaseShapesFilled(true);
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      LineChartDemo2 var1 = new LineChartDemo2("JFreeChart: LineChartDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
