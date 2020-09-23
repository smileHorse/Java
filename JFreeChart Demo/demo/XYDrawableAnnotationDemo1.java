package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.geom.Ellipse2D.Double;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYDrawableAnnotation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class XYDrawableAnnotationDemo1 extends ApplicationFrame {

   public XYDrawableAnnotationDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("XYDrawableAnnotationDemo1", (String)null, "$ million", var0, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      DateAxis var3 = (DateAxis)var2.getDomainAxis();
      var3.setLowerMargin(0.2D);
      var3.setUpperMargin(0.2D);
      var3.setStandardTickUnits(createStandardDateTickUnits());
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setLowerMargin(0.2D);
      var4.setUpperMargin(0.2D);
      XYLineAndShapeRenderer var5 = new XYLineAndShapeRenderer();
      var5.setBaseShapesVisible(true);
      var5.setBaseLinesVisible(true);
      var5.setSeriesShape(0, new Double(-5.0D, -5.0D, 10.0D, 10.0D));
      var5.setSeriesShape(1, new Double(-5.0D, -5.0D, 10.0D, 10.0D));
      var5.setSeriesStroke(0, new BasicStroke(3.0F));
      var5.setSeriesStroke(1, new BasicStroke(3.0F, 1, 1, 5.0F, new float[]{10.0F, 5.0F}, 0.0F));
      var5.setSeriesFillPaint(0, Color.white);
      var5.setSeriesFillPaint(1, Color.white);
      var5.setUseFillPaint(true);
      var5.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
      var5.setDefaultEntityRadius(6);
      var5.addAnnotation(new XYDrawableAnnotation((double)(new Month(4, 2005)).getFirstMillisecond(), 600.0D, 180.0D, 100.0D, 3.0D, createPieChart()));
      var5.addAnnotation(new XYDrawableAnnotation((double)(new Month(9, 2007)).getFirstMillisecond(), 1250.0D, 120.0D, 100.0D, 2.0D, createBarChart()));
      var2.setRenderer(var5);
      return var1;
   }

   private static XYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Division A");
      var0.add(new Year(2005), 1520.0D);
      var0.add(new Year(2006), 1132.0D);
      var0.add(new Year(2007), 450.0D);
      var0.add(new Year(2008), 620.0D);
      TimeSeries var1 = new TimeSeries("Division B");
      var1.add(new Year(2005), 1200.0D);
      var1.add(new Year(2006), 1300.0D);
      var1.add(new Year(2007), 640.0D);
      var1.add(new Year(2008), 520.0D);
      TimeSeriesCollection var2 = new TimeSeriesCollection();
      var2.addSeries(var0);
      var2.addSeries(var1);
      return var2;
   }

   private static JFreeChart createPieChart() {
      DefaultPieDataset var0 = new DefaultPieDataset();
      var0.setValue("Engineering", 43.2D);
      var0.setValue("Research", 13.2D);
      var0.setValue("Advertising", 20.9D);
      PiePlot var1 = new PiePlot(var0);
      var1.setBackgroundPaint((Paint)null);
      var1.setOutlinePaint((Paint)null);
      var1.setBaseSectionOutlinePaint(Color.white);
      var1.setBaseSectionOutlineStroke(new BasicStroke(2.0F));
      var1.setLabelFont(new Font("Dialog", 0, 18));
      var1.setMaximumLabelWidth(0.25D);
      JFreeChart var2 = new JFreeChart(var1);
      var2.setBackgroundPaint((Paint)null);
      var2.removeLegend();
      var2.setPadding(RectangleInsets.ZERO_INSETS);
      return var2;
   }

   private static JFreeChart createBarChart() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(10.0D, "R1", "Q1");
      var0.addValue(7.0D, "R1", "Q2");
      var0.addValue(8.0D, "R1", "Q3");
      var0.addValue(4.0D, "R1", "Q4");
      var0.addValue(10.6D, "R2", "Q1");
      var0.addValue(6.1D, "R2", "Q2");
      var0.addValue(8.5D, "R2", "Q3");
      var0.addValue(4.3D, "R2", "Q4");
      JFreeChart var1 = ChartFactory.createBarChart("Sales 2008", (String)null, (String)null, var0, PlotOrientation.VERTICAL, false, false, false);
      var1.setBackgroundPaint((Paint)null);
      var1.getPlot().setBackgroundPaint(new Color(200, 200, 255, 60));
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   private static TickUnitSource createStandardDateTickUnits() {
      TickUnits var0 = new TickUnits();
      SimpleDateFormat var1 = new SimpleDateFormat("yyyy");
      var0.add(new DateTickUnit(DateTickUnitType.YEAR, 1, DateTickUnitType.YEAR, 1, var1));
      var0.add(new DateTickUnit(DateTickUnitType.YEAR, 2, DateTickUnitType.YEAR, 1, var1));
      var0.add(new DateTickUnit(DateTickUnitType.YEAR, 5, DateTickUnitType.YEAR, 5, var1));
      return var0;
   }

   public static void main(String[] var0) {
      XYDrawableAnnotationDemo1 var1 = new XYDrawableAnnotationDemo1("JFreeChart: XYDrawableAnnotationDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
