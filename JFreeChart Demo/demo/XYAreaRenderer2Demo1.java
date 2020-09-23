package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer2;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYAreaRenderer2Demo1 extends ApplicationFrame {

   public XYAreaRenderer2Demo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static XYDataset createDataset() {
      XYSeries var0 = new XYSeries("Random 1");
      var0.add(new Integer(1), new Double(500.2D));
      var0.add(new Integer(2), new Double(694.1D));
      var0.add(new Integer(3), new Double(-734.4D));
      var0.add(new Integer(4), new Double(453.2D));
      var0.add(new Integer(5), new Double(500.2D));
      var0.add(new Integer(6), new Double(300.7D));
      var0.add(new Integer(7), new Double(734.4D));
      var0.add(new Integer(8), new Double(453.2D));
      XYSeries var1 = new XYSeries("Random 2");
      var1.add(new Integer(1), new Double(700.2D));
      var1.add(new Integer(2), new Double(534.1D));
      var1.add(new Integer(3), new Double(323.4D));
      var1.add(new Integer(4), new Double(125.2D));
      var1.add(new Integer(5), new Double(653.2D));
      var1.add(new Integer(6), new Double(432.7D));
      var1.add(new Integer(7), new Double(564.4D));
      var1.add(new Integer(8), new Double(322.2D));
      XYSeriesCollection var2 = new XYSeriesCollection();
      var2.addSeries(var0);
      var2.addSeries(var1);
      var2.setIntervalWidth(0.0D);
      return var2;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYAreaChart("XYAreaRenderer2Demo1", "Domain (X)", "Range (Y)", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setRenderer(new XYAreaRenderer2());
      var2.setForegroundAlpha(0.65F);
      ValueAxis var3 = var2.getDomainAxis();
      var3.setTickMarkPaint(Color.black);
      var3.setLowerMargin(0.0D);
      var3.setUpperMargin(0.0D);
      ValueAxis var4 = var2.getRangeAxis();
      var4.setTickMarkPaint(Color.black);
      return var1;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      XYAreaRenderer2Demo1 var1 = new XYAreaRenderer2Demo1("XYAreaRenderer2Demo1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
