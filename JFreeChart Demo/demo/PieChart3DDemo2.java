package demo;

import demo.Rotator;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

public class PieChart3DDemo2 extends ApplicationFrame {

   public PieChart3DDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(PieDataset var0) {
      JFreeChart var1 = ChartFactory.createPieChart3D("Pie Chart 3D Demo 2", var0, true, false, false);
      PiePlot3D var2 = (PiePlot3D)var1.getPlot();
      var2.setStartAngle(270.0D);
      var2.setDirection(Rotation.ANTICLOCKWISE);
      var2.setForegroundAlpha(0.6F);
      return var1;
   }

   private static PieDataset createDataset() {
      DefaultPieDataset var0 = new DefaultPieDataset();
      var0.setValue("Java", new Double(43.2D));
      var0.setValue("Visual Basic", new Double(10.0D));
      var0.setValue("C/C++", new Double(17.5D));
      var0.setValue("PHP", new Double(32.5D));
      var0.setValue("Perl", new Double(12.5D));
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      Rotator var1 = new Rotator((PiePlot3D)var0.getPlot());
      var1.start();
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      PieChart3DDemo2 var1 = new PieChart3DDemo2("JFreeChart: PieChart3DDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
