package demo;

import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYSeriesDemo1 extends ApplicationFrame {

   public XYSeriesDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("XY Series Demo 1", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      NumberAxis var3 = new NumberAxis((String)null);
      var2.setDomainAxis(1, var3);
      NumberAxis var4 = new NumberAxis((String)null);
      var2.setRangeAxis(1, var4);
      List var5 = Arrays.asList(new Integer[]{new Integer(0), new Integer(1)});
      var2.mapDatasetToDomainAxes(0, var5);
      var2.mapDatasetToRangeAxes(0, var5);
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
      var0.add(21.9D, (Number)null);
      var0.add(25.6D, 734.4D);
      var0.add(30.0D, 453.2D);
      return new XYSeriesCollection(var0);
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      XYSeriesDemo1 var1 = new XYSeriesDemo1("JFreeChart: XYSeriesDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
