package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYAreaChartDemo2 extends ApplicationFrame {

   public XYAreaChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Random 1");
      double var1 = 0.0D;
      Day var3 = new Day();

      for(int var4 = 0; var4 < 200; ++var4) {
         var1 = var1 + Math.random() - 0.5D;
         var0.add(var3, var1);
         var3 = (Day)var3.next();
      }

      TimeSeriesCollection var5 = new TimeSeriesCollection(var0);
      return var5;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYAreaChart("XY Area Chart Demo 2", "Time", "Value", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      DateAxis var3 = new DateAxis("Time");
      var3.setLowerMargin(0.0D);
      var3.setUpperMargin(0.0D);
      var2.setDomainAxis(var3);
      var2.setForegroundAlpha(0.5F);
      XYItemRenderer var4 = var2.getRenderer();
      var4.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("#,##0.00")));
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      XYAreaChartDemo2 var1 = new XYAreaChartDemo2("XY Area Chart Demo 2");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
