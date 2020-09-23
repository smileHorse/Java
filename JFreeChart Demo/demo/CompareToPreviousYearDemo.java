package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CompareToPreviousYearDemo extends ApplicationFrame {

   public CompareToPreviousYearDemo(String var1) {
      super(var1);
      ChartPanel var2 = (ChartPanel)createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      var2.setMouseZoomable(true, true);
      this.setContentPane(var2);
   }

   private static JFreeChart createChart() {
      XYDataset var0 = createDataset2006();
      XYDataset var1 = createDataset2007();
      DateAxis var2 = new DateAxis("Date");
      Month var3 = new Month(1, 2007);
      Month var4 = new Month(12, 2007);
      var2.setRange((double)var3.getFirstMillisecond(), (double)var4.getLastMillisecond());
      var2.setDateFormatOverride(new SimpleDateFormat("MMM"));
      var2.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
      XYLineAndShapeRenderer var5 = new XYLineAndShapeRenderer();
      var5.setUseFillPaint(true);
      var5.setBaseFillPaint(Color.white);
      var5.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{1}: {2}", new SimpleDateFormat("MMM-yyyy"), new DecimalFormat("0.00")));
      XYPlot var6 = new XYPlot(var1, var2, new NumberAxis("Sales"), var5);
      var6.setDomainPannable(true);
      var6.setRangePannable(true);
      DateAxis var7 = new DateAxis();
      var7.setVisible(false);
      var6.setDomainAxis(1, var7);
      var6.setDataset(1, var0);
      var6.mapDatasetToDomainAxis(1, 1);
      XYLineAndShapeRenderer var8 = new XYLineAndShapeRenderer();
      var8.setSeriesPaint(0, Color.blue);
      var8.setUseFillPaint(true);
      var8.setBaseFillPaint(Color.white);
      var8.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{1}: {2}", new SimpleDateFormat("MMM-yyyy"), new DecimalFormat("0.00")));
      var6.setRenderer(1, var8);
      JFreeChart var9 = new JFreeChart("Sales Comparison Chart", var6);
      var6.setDomainCrosshairVisible(true);
      var6.setRangeCrosshairVisible(true);
      DateAxis var10 = (DateAxis)var6.getDomainAxis();
      var10.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
      ChartUtilities.applyCurrentTheme(var9);
      return var9;
   }

   private static XYDataset createDataset2006() {
      TimeSeries var0 = new TimeSeries("Sales 2006");
      var0.add(new Month(1, 2006), 100.0D);
      var0.add(new Month(2, 2006), 102.3D);
      var0.add(new Month(3, 2006), 105.7D);
      var0.add(new Month(4, 2006), 104.2D);
      var0.add(new Month(5, 2006), 114.7D);
      var0.add(new Month(6, 2006), 121.7D);
      var0.add(new Month(7, 2006), 155.6D);
      var0.add(new Month(8, 2006), 143.2D);
      var0.add(new Month(9, 2006), 131.9D);
      var0.add(new Month(10, 2006), 120.0D);
      var0.add(new Month(11, 2006), 109.9D);
      var0.add(new Month(12, 2006), 99.6D);
      TimeSeriesCollection var1 = new TimeSeriesCollection();
      var1.addSeries(var0);
      var1.setXPosition(TimePeriodAnchor.MIDDLE);
      return var1;
   }

   private static XYDataset createDataset2007() {
      TimeSeries var0 = new TimeSeries("Sales 2007");
      var0.add(new Month(1, 2007), 163.9D);
      var0.add(new Month(2, 2007), 163.8D);
      var0.add(new Month(3, 2007), 162.0D);
      var0.add(new Month(4, 2007), 167.1D);
      var0.add(new Month(5, 2007), 170.0D);
      var0.add(new Month(6, 2007), 175.7D);
      var0.add(new Month(7, 2007), 171.9D);
      TimeSeriesCollection var1 = new TimeSeriesCollection();
      var1.addSeries(var0);
      var1.setXPosition(TimePeriodAnchor.MIDDLE);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      CompareToPreviousYearDemo var1 = new CompareToPreviousYearDemo("JFreeChart: CompareToPreviousYearDemo.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
