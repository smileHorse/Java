package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.data.xy.CategoryTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedXYAreaChartDemo2 extends ApplicationFrame {

   public StackedXYAreaChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static TableXYDataset createDataset() {
      CategoryTableXYDataset var0 = new CategoryTableXYDataset();
      var0.add(0.0D, 0.0D, "Series 1");
      var0.add(10.0D, 20.0D, "Series 1");
      var0.add(20.0D, 15.0D, "Series 1");
      var0.add(30.0D, 25.0D, "Series 1");
      var0.add(40.0D, 21.0D, "Series 1");
      var0.add(10.0D, 9.0D, "Series 2");
      var0.add(20.0D, -7.0D, "Series 2");
      var0.add(30.0D, 15.0D, "Series 2");
      var0.add(40.0D, 11.0D, "Series 2");
      var0.add(45.0D, -10.0D, "Series 2");
      var0.add(50.0D, 0.0D, "Series 2");
      return var0;
   }

   private static JFreeChart createChart(TableXYDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedXYAreaChart("Stacked XY Area Chart Demo 2", "X Value", "Y Value", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      StackedXYAreaRenderer2 var3 = new StackedXYAreaRenderer2();
      var3.setRoundXCoordinates(true);
      var3.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
      var2.setRenderer(0, var3);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedXYAreaChartDemo2 var1 = new StackedXYAreaChartDemo2("Stacked XY Area Chart Demo 2");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
