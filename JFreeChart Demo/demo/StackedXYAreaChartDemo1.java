package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedXYAreaChartDemo1 extends ApplicationFrame {

   public StackedXYAreaChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static TableXYDataset createDataset() {
      DefaultTableXYDataset var0 = new DefaultTableXYDataset();
      XYSeries var1 = new XYSeries("Series 1", true, false);
      var1.add(5.0D, 5.0D);
      var1.add(10.0D, 15.5D);
      var1.add(15.0D, 9.5D);
      var1.add(20.0D, 7.5D);
      var0.addSeries(var1);
      XYSeries var2 = new XYSeries("Series 2", true, false);
      var2.add(5.0D, 5.0D);
      var2.add(10.0D, 15.5D);
      var2.add(15.0D, 9.5D);
      var2.add(20.0D, 3.5D);
      var0.addSeries(var2);
      return var0;
   }

   private static JFreeChart createChart(TableXYDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedXYAreaChart("Stacked XY Area Chart Demo 1", "X Value", "Y Value", var0);
      XYPlot var2 = (XYPlot)var1.getPlot();
      StackedXYAreaRenderer var3 = new StackedXYAreaRenderer();
      var3.setSeriesPaint(0, Color.lightGray);
      var3.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
      var2.setRenderer(0, var3);
      var2.setDomainCrosshairVisible(true);
      var2.setRangeCrosshairVisible(true);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedXYAreaChartDemo1 var1 = new StackedXYAreaChartDemo1("Stacked XY Area Chart Demo 1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
