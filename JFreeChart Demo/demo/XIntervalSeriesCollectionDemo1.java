package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XIntervalSeries;
import org.jfree.data.xy.XIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XIntervalSeriesCollectionDemo1 extends ApplicationFrame {

   public XIntervalSeriesCollectionDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static IntervalXYDataset createDataset() {
      XIntervalSeriesCollection var0 = new XIntervalSeriesCollection();
      XIntervalSeries var1 = new XIntervalSeries("S1");
      var1.add(5.0D, 2.0D, 7.5D, 12.3D);
      var1.add(10.0D, 8.0D, 11.0D, 20.0D);
      var0.addSeries(var1);
      return var0;
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      DateAxis var1 = new DateAxis("Date");
      NumberAxis var2 = new NumberAxis("Y");
      XYBarRenderer var3 = new XYBarRenderer();
      var3.setUseYInterval(false);
      XYPlot var4 = new XYPlot(var0, var1, var2, var3);
      JFreeChart var5 = new JFreeChart(var4);
      var4.setBackgroundPaint(Color.lightGray);
      var4.setDomainGridlinePaint(Color.white);
      var4.setDomainGridlinesVisible(true);
      var4.setRangeGridlinePaint(Color.white);
      ChartUtilities.applyCurrentTheme(var5);
      return var5;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      XIntervalSeriesCollectionDemo1 var1 = new XIntervalSeriesCollectionDemo1("Demo 1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
