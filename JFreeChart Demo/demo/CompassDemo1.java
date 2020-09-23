package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CompassPlot;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CompassDemo1 extends ApplicationFrame {

   public CompassDemo1(String var1) {
      super(var1);
      ChartPanel var2 = (ChartPanel)createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      var2.setEnforceFileExtensions(false);
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(ValueDataset var0) {
      CompassPlot var1 = new CompassPlot(var0);
      var1.setSeriesNeedle(7);
      var1.setSeriesPaint(0, Color.black);
      var1.setSeriesOutlinePaint(0, Color.black);
      var1.setRosePaint(Color.red);
      var1.setRoseHighlightPaint(Color.gray);
      var1.setRoseCenterPaint(Color.white);
      var1.setDrawBorder(false);
      JFreeChart var2 = new JFreeChart(var1);
      ChartUtilities.applyCurrentTheme(var2);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(new DefaultValueDataset(new Double(45.0D)));
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      CompassDemo1 var1 = new CompassDemo1("JFreeChart: CompassDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
