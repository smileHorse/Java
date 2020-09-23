package demo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class RingChartDemo1 extends ApplicationFrame {

   public RingChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static PieDataset createDataset() {
      DefaultPieDataset var0 = new DefaultPieDataset();
      var0.setValue("One", new Double(43.2D));
      var0.setValue("Two", new Double(10.0D));
      var0.setValue("Three", new Double(27.5D));
      var0.setValue("Four", new Double(17.5D));
      var0.setValue("Five", new Double(11.0D));
      var0.setValue("Six", new Double(19.4D));
      return var0;
   }

   private static JFreeChart createChart(PieDataset var0) {
      JFreeChart var1 = ChartFactory.createRingChart("Ring Chart Demo 1", var0, false, true, false);
      RingPlot var2 = (RingPlot)var1.getPlot();
      var2.setLabelFont(new Font("SansSerif", 0, 12));
      var2.setNoDataMessage("No data available");
      var2.setSectionDepth(0.35D);
      var2.setCircular(false);
      var2.setLabelGap(0.02D);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      RingChartDemo1 var1 = new RingChartDemo1("JFreeChart: RingChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
