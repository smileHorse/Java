package demo;

import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ThermometerDemo2 extends ApplicationFrame {

   public ThermometerDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      this.setContentPane(var2);
   }

   private static JFreeChart createChart() {
      DefaultValueDataset var0 = new DefaultValueDataset(37.2D);
      ThermometerPlot var1 = new ThermometerPlot(var0);
      JFreeChart var2 = new JFreeChart("ThermometerDemo2", var1);
      ChartUtilities.applyCurrentTheme(var2);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      ThermometerDemo2 var1 = new ThermometerDemo2("JFreeChart: ThermometerDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
