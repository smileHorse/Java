package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class XYAreaChartDemo1 extends ApplicationFrame {

   public XYAreaChartDemo1(String var1) {
      super(var1);
      XYDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var4);
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
      JFreeChart var1 = ChartFactory.createXYAreaChart("XY Area Chart Demo", "Domain (X)", "Range (Y)", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setForegroundAlpha(0.65F);
      ValueAxis var3 = var2.getDomainAxis();
      var3.setTickMarkPaint(Color.black);
      var3.setLowerMargin(0.0D);
      var3.setUpperMargin(0.0D);
      ValueAxis var4 = var2.getRangeAxis();
      var4.setTickMarkPaint(Color.black);
      XYPointerAnnotation var5 = new XYPointerAnnotation("Test", 5.0D, -500.0D, 2.356194490192345D);
      var5.setTipRadius(0.0D);
      var5.setBaseRadius(35.0D);
      var5.setFont(new Font("SansSerif", 0, 9));
      var5.setPaint(Color.blue);
      var5.setTextAnchor(TextAnchor.HALF_ASCENT_RIGHT);
      var2.addAnnotation(var5);
      return var1;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      XYAreaChartDemo1 var1 = new XYAreaChartDemo1("XY Area Chart Demo");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
