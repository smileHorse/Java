package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.labels.StandardXYSeriesLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo3 extends ApplicationFrame {

   public TimeSeriesDemo3(String var1) {
      super(var1);
      XYDataset var2 = createDataset();
      JFreeChart var3 = createChart(var2);
      ChartPanel var4 = new ChartPanel(var3);
      var4.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var4);
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Series 1");
      var0.add(new Month(1, 2002), 500.2D);
      var0.add(new Month(2, 2002), 694.1D);
      var0.add(new Month(3, 2002), 734.4D);
      var0.add(new Month(4, 2002), 453.2D);
      var0.add(new Month(5, 2002), 500.2D);
      var0.add(new Month(6, 2002), 345.6D);
      var0.add(new Month(7, 2002), 500.2D);
      var0.add(new Month(8, 2002), 694.1D);
      var0.add(new Month(9, 2002), 734.4D);
      var0.add(new Month(10, 2002), 453.2D);
      var0.add(new Month(11, 2002), 500.2D);
      var0.add(new Month(12, 2002), 345.6D);
      TimeSeries var1 = new TimeSeries("Series 2");
      var1.add(new Month(1, 2002), 234.1D);
      var1.add(new Month(2, 2002), 623.7D);
      var1.add(new Month(3, 2002), 642.5D);
      var1.add(new Month(4, 2002), 651.4D);
      var1.add(new Month(5, 2002), 643.5D);
      var1.add(new Month(6, 2002), 785.6D);
      var1.add(new Month(7, 2002), 234.1D);
      var1.add(new Month(8, 2002), 623.7D);
      var1.add(new Month(9, 2002), 642.5D);
      var1.add(new Month(10, 2002), 651.4D);
      var1.add(new Month(11, 2002), 643.5D);
      var1.add(new Month(12, 2002), 785.6D);
      TimeSeriesCollection var2 = new TimeSeriesCollection();
      var2.addSeries(var0);
      var2.addSeries(var1);
      return var2;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Time Series Demo 3", "Time", "Value", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      DateAxis var3 = (DateAxis)var2.getDomainAxis();
      var3.setTickUnit(new DateTickUnit(DateTickUnitType.MONTH, 1, new SimpleDateFormat("MMM-yyyy")));
      var3.setVerticalTickLabels(true);
      XYLineAndShapeRenderer var4 = (XYLineAndShapeRenderer)var2.getRenderer();
      var4.setBaseShapesVisible(true);
      var4.setSeriesFillPaint(0, Color.red);
      var4.setSeriesFillPaint(1, Color.white);
      var4.setUseFillPaint(true);
      var4.setLegendItemToolTipGenerator(new StandardXYSeriesLabelGenerator("Tooltip {0}"));
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      TimeSeriesDemo3 var1 = new TimeSeriesDemo3("Time Series Demo 3");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
