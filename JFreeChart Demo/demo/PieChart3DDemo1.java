package demo;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

public class PieChart3DDemo1 extends ApplicationFrame {

   public PieChart3DDemo1(String var1) {
      super(var1);
      ChartPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static PieDataset createDataset() {
      DefaultPieDataset var0 = new DefaultPieDataset();
      var0.setValue("Java", new Double(43.2D));
      var0.setValue("Visual Basic", new Double(10.0D));
      var0.setValue("C/C++", new Double(17.5D));
      var0.setValue("PHP", new Double(32.5D));
      var0.setValue("Perl", (Number)null);
      return var0;
   }

   private static JFreeChart createChart(PieDataset var0) {
      JFreeChart var1 = ChartFactory.createPieChart3D("Pie Chart 3D Demo 1", var0, true, true, false);
      PiePlot3D var2 = (PiePlot3D)var1.getPlot();
      var2.setDarkerSides(true);
      var2.setStartAngle(290.0D);
      var2.setDirection(Rotation.CLOCKWISE);
      var2.setForegroundAlpha(0.5F);
      var2.setNoDataMessage("No data to display");
      return var1;
   }

   public static ChartPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      PieChart3DDemo1 var1 = new PieChart3DDemo1("JFreeChart: PieChart3DDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
