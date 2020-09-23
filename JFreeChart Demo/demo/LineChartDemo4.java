package demo;

import demo.SampleXYDataset;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LineChartDemo4 extends ApplicationFrame {

   public LineChartDemo4(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("Line Chart Demo 4", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainZeroBaselineVisible(true);
      var2.setRangeZeroBaselineVisible(true);
      var2.getDomainAxis().setLowerMargin(0.0D);
      var2.getDomainAxis().setUpperMargin(0.0D);
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      XYLineAndShapeRenderer var3 = (XYLineAndShapeRenderer)var2.getRenderer();
      var3.setLegendLine(new Double(-4.0D, -3.0D, 8.0D, 6.0D));
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(new SampleXYDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      LineChartDemo4 var1 = new LineChartDemo4("JFreeChart: LineChartDemo4.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
