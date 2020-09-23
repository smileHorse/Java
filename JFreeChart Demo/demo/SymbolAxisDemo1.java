package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class SymbolAxisDemo1 extends ApplicationFrame {

   public SymbolAxisDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      SymbolAxis var1 = new SymbolAxis("Domain", new String[]{"A", "B", "C", "DDDDDDDDDDDDDDDDDDD"});
      SymbolAxis var2 = new SymbolAxis("Range", new String[]{"V", "X", "Y", "Z"});
      var2.setUpperMargin(0.0D);
      XYLineAndShapeRenderer var3 = new XYLineAndShapeRenderer(false, true);
      XYPlot var4 = new XYPlot(var0, var1, var2, var3);
      JFreeChart var5 = new JFreeChart("SymbolAxis Demo 1", var4);
      ChartUtilities.applyCurrentTheme(var5);
      return var5;
   }

   private static XYDataset createDataset() {
      XYSeries var0 = new XYSeries("Series 1");
      var0.add(0.0D, 3.0D);
      var0.add(1.0D, 3.0D);
      var0.add(2.0D, 0.0D);
      var0.add(3.0D, 1.0D);
      XYSeries var1 = new XYSeries("Series 2");
      var1.add(0.0D, 1.0D);
      var1.add(1.0D, 2.0D);
      var1.add(2.0D, 1.0D);
      var1.add(3.0D, 3.0D);
      XYSeriesCollection var2 = new XYSeriesCollection();
      var2.addSeries(var0);
      var2.addSeries(var1);
      return var2;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      SymbolAxisDemo1 var1 = new SymbolAxisDemo1("JFreeChart: SymbolAxisDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
