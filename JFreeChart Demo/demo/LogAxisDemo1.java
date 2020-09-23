package demo;

import java.awt.BasicStroke;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LogAxisDemo1 extends ApplicationFrame {

   public LogAxisDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createScatterPlot("Log Axis Demo 1", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      var2.setDomainGridlineStroke(new BasicStroke(1.0F));
      var2.setRangeGridlineStroke(new BasicStroke(1.0F));
      var2.setDomainMinorGridlinesVisible(true);
      var2.setRangeMinorGridlinesVisible(true);
      var2.setDomainMinorGridlineStroke(new BasicStroke(0.1F));
      var2.setRangeMinorGridlineStroke(new BasicStroke(0.1F));
      LogAxis var3 = new LogAxis("X");
      LogAxis var4 = new LogAxis("Y");
      var2.setDomainAxis(var3);
      var2.setRangeAxis(var4);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static XYDataset createDataset() {
      XYSeries var0 = new XYSeries("Random Data");
      var0.add(1.0D, 500.2D);
      var0.add(5.0D, 694.1D);
      var0.add(4.0D, 100.0D);
      var0.add(12.5D, 734.4D);
      var0.add(17.3D, 453.2D);
      var0.add(21.2D, 500.2D);
      var0.add(21.9D, 9005.5D);
      var0.add(25.6D, 734.4D);
      var0.add(6663000.0D, 6453.2D);
      return new XYSeriesCollection(var0);
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      LogAxisDemo1 var1 = new LogAxisDemo1("JFreeChart: LogAxisDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
