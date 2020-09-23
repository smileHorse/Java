package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedXYAreaChartDemo3 extends ApplicationFrame {

   public StackedXYAreaChartDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static TableXYDataset createDataset() {
      TimeTableXYDataset var0 = new TimeTableXYDataset();
      var0.add(new Day(14, 2, 2007), 87.0D, "Series 1");
      var0.add(new Day(15, 2, 2007), 67.0D, "Series 1");
      var0.add(new Day(16, 2, 2007), 78.0D, "Series 1");
      var0.add(new Day(17, 2, 2007), 55.0D, "Series 1");
      var0.add(new Day(18, 2, 2007), 58.0D, "Series 1");
      var0.add(new Day(19, 2, 2007), 60.0D, "Series 1");
      var0.add(new Day(14, 2, 2007), 45.0D, "Series 2");
      var0.add(new Day(15, 2, 2007), 67.0D, "Series 2");
      var0.add(new Day(16, 2, 2007), 61.0D, "Series 2");
      var0.add(new Day(17, 2, 2007), 58.0D, "Series 2");
      var0.add(new Day(18, 2, 2007), 73.0D, "Series 2");
      var0.add(new Day(19, 2, 2007), 64.0D, "Series 2");
      var0.add(new Day(14, 2, 2007), 32.0D, "Series 3");
      var0.add(new Day(15, 2, 2007), 38.0D, "Series 3");
      var0.add(new Day(16, 2, 2007), 43.0D, "Series 3");
      var0.add(new Day(17, 2, 2007), 12.0D, "Series 3");
      var0.add(new Day(18, 2, 2007), 19.0D, "Series 3");
      var0.add(new Day(19, 2, 2007), 26.0D, "Series 3");
      return var0;
   }

   private static JFreeChart createChart(TableXYDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedXYAreaChart("Stacked XY Area Chart Demo 3", "X Value", "Y Value", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      DateAxis var3 = new DateAxis("Date");
      var2.setDomainAxis(var3);
      var3.setLowerMargin(0.0D);
      var3.setUpperMargin(0.0D);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedXYAreaChartDemo3 var1 = new StackedXYAreaChartDemo3("Stacked XY Area Chart Demo 3");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
