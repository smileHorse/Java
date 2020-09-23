package demo;

import demo.SimpleIntervalXYDataset;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo3 extends ApplicationFrame {

   public XYBarChartDemo3(String var1) {
      super(var1);
      SimpleIntervalXYDataset var2 = new SimpleIntervalXYDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var4);
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYBarChart("Sample", "X", false, "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      return var1;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(new SimpleIntervalXYDataset()));
   }

   public static void main(String[] var0) {
      XYBarChartDemo3 var1 = new XYBarChartDemo3("XY Bar Chart Demo 3");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
