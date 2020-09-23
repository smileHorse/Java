package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo3 extends ApplicationFrame {

   public PieChartDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(PieDataset var0) {
      JFreeChart var1 = ChartFactory.createPieChart("Pie Chart Demo 3", var0, true, true, false);
      PiePlot var2 = (PiePlot)var1.getPlot();
      var2.setNoDataMessage("No data available so we go into this really long spiel about what that means and it runs off the end of the line but what can you do about that!");
      var2.setNoDataMessageFont(new Font("Serif", 2, 10));
      var2.setNoDataMessagePaint(Color.red);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(new DefaultPieDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      PieChartDemo3 var1 = new PieChartDemo3("Pie Chart Demo 3");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
