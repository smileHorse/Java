package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BoxAndWhiskerChartDemo2 extends ApplicationFrame {

   public BoxAndWhiskerChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static BoxAndWhiskerXYDataset createDataset() {
      DefaultBoxAndWhiskerXYDataset var1 = new DefaultBoxAndWhiskerXYDataset("Series Name");
      Object var2 = new Day();

      for(int var3 = 0; var3 < 10; ++var3) {
         List var4 = createValueList(0.0D, 20.0D, 20);
         var1.add(((RegularTimePeriod)var2).getStart(), BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(var4));
         var2 = ((RegularTimePeriod)var2).next();
      }

      return var1;
   }

   private static List createValueList(double var0, double var2, int var4) {
      ArrayList var5 = new ArrayList();

      for(int var6 = 0; var6 < var4; ++var6) {
         double var7 = var0 + Math.random() * (var2 - var0);
         var5.add(new Double(var7));
      }

      return var5;
   }

   private static JFreeChart createChart(BoxAndWhiskerXYDataset var0) {
      DateAxis var1 = new DateAxis("Day");
      NumberAxis var2 = new NumberAxis("Value");
      XYBoxAndWhiskerRenderer var3 = new XYBoxAndWhiskerRenderer();
      XYPlot var4 = new XYPlot(var0, var1, var2, var3);
      JFreeChart var5 = new JFreeChart("Box-and-Whisker Chart Demo 2", var4);
      var5.setBackgroundPaint(Color.white);
      var4.setBackgroundPaint(Color.lightGray);
      var4.setDomainGridlinePaint(Color.white);
      var4.setDomainGridlinesVisible(true);
      var4.setRangeGridlinePaint(Color.white);
      var4.setDomainPannable(true);
      var4.setRangePannable(true);
      var2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      ChartUtilities.applyCurrentTheme(var5);
      return var5;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      BoxAndWhiskerChartDemo2 var1 = new BoxAndWhiskerChartDemo2("JFreeChart: BoxAndWhiskerChartDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
