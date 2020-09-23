package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.function.NormalDistributionFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class NormalDistributionDemo1 extends ApplicationFrame {

   public NormalDistributionDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static XYDataset createDataset() {
      NormalDistributionFunction2D var0 = new NormalDistributionFunction2D(0.0D, 1.0D);
      XYDataset var1 = DatasetUtilities.sampleFunction2D(var0, -5.0D, 5.0D, 100, "Normal");
      return var1;
   }

   public static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart("Normal Distribution", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      return var1;
   }

   public static void main(String[] var0) {
      NormalDistributionDemo1 var1 = new NormalDistributionDemo1("JFreeChart: NormalDistributionDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
