package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYBarRenderer;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedXYBarChartDemo1 extends ApplicationFrame {

   public StackedXYBarChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static TableXYDataset createDataset() {
      DefaultTableXYDataset var0 = new DefaultTableXYDataset();
      XYSeries var1 = new XYSeries("Series 1", true, false);
      var1.add(1.0D, 5.0D);
      var1.add(2.0D, 15.5D);
      var1.add(3.0D, 9.5D);
      var1.add(4.0D, 7.5D);
      var0.addSeries(var1);
      XYSeries var2 = new XYSeries("Series 2", true, false);
      var2.add(1.0D, 5.0D);
      var2.add(2.0D, 15.5D);
      var2.add(3.0D, 9.5D);
      var2.add(4.0D, 3.5D);
      var0.addSeries(var2);
      return var0;
   }

   private static JFreeChart createChart(TableXYDataset var0) {
      NumberAxis var1 = new NumberAxis("X");
      var1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      NumberAxis var2 = new NumberAxis("Y");
      StackedXYBarRenderer var3 = new StackedXYBarRenderer(0.1D);
      var3.setDrawBarOutline(false);
      XYPlot var4 = new XYPlot(var0, var1, var2, var3);
      JFreeChart var5 = new JFreeChart("Stacked XY Bar Chart Demo 1", var4);
      ChartUtilities.applyCurrentTheme(var5);
      return var5;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedXYBarChartDemo1 var1 = new StackedXYBarChartDemo1("Stacked XY Bar Chart Demo 1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
