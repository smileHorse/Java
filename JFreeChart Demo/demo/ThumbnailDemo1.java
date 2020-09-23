package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.DeviationRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Week;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

public class ThumbnailDemo1 extends ApplicationFrame {

   public ThumbnailDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset1() {
      String var0 = "First";
      String var1 = "Second";
      String var2 = "Third";
      String var3 = "Category 1";
      String var4 = "Category 2";
      String var5 = "Category 3";
      String var6 = "Category 4";
      String var7 = "Category 5";
      DefaultCategoryDataset var8 = new DefaultCategoryDataset();
      var8.addValue(1.0D, var0, var3);
      var8.addValue(4.0D, var0, var4);
      var8.addValue(3.0D, var0, var5);
      var8.addValue(5.0D, var0, var6);
      var8.addValue(5.0D, var0, var7);
      var8.addValue(5.0D, var1, var3);
      var8.addValue(7.0D, var1, var4);
      var8.addValue(6.0D, var1, var5);
      var8.addValue(8.0D, var1, var6);
      var8.addValue(4.0D, var1, var7);
      var8.addValue(4.0D, var2, var3);
      var8.addValue(3.0D, var2, var4);
      var8.addValue(2.0D, var2, var5);
      var8.addValue(3.0D, var2, var6);
      var8.addValue(6.0D, var2, var7);
      return var8;
   }

   private static JFreeChart createChart1(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart("Bar Chart Demo 1", "Category", "Value", var0, PlotOrientation.VERTICAL, true, true, false);
      var1.setBackgroundPaint(Color.white);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      BarRenderer var4 = (BarRenderer)var2.getRenderer();
      var4.setDrawBarOutline(false);
      GradientPaint var5 = new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, new Color(0, 0, 64));
      GradientPaint var6 = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
      GradientPaint var7 = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, new Color(64, 0, 0));
      var4.setSeriesPaint(0, var5);
      var4.setSeriesPaint(1, var6);
      var4.setSeriesPaint(2, var7);
      var4.setLegendItemToolTipGenerator(new StandardCategorySeriesLabelGenerator("Tooltip: {0}"));
      CategoryAxis var8 = var2.getDomainAxis();
      var8.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.5235987755982988D));
      return var1;
   }

   private static PieDataset createDataset2() {
      DefaultPieDataset var0 = new DefaultPieDataset();
      var0.setValue("Java", new Double(43.2D));
      var0.setValue("Visual Basic", new Double(10.0D));
      var0.setValue("C/C++", new Double(17.5D));
      var0.setValue("PHP", new Double(32.5D));
      var0.setValue("Perl", (Number)null);
      return var0;
   }

   private static JFreeChart createChart2(PieDataset var0) {
      JFreeChart var1 = ChartFactory.createPieChart3D("Pie Chart 3D Demo 1", var0, true, true, false);
      var1.setBackgroundPaint(Color.white);
      PiePlot3D var2 = (PiePlot3D)var1.getPlot();
      var2.setDarkerSides(true);
      var2.setStartAngle(290.0D);
      var2.setDirection(Rotation.CLOCKWISE);
      var2.setForegroundAlpha(0.5F);
      var2.setOutlinePaint((Paint)null);
      var2.setNoDataMessage("No data to display");
      return var1;
   }

   private static CategoryDataset createDataset3() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(81.0D, "Against all torture", "Italy");
      var0.addValue(72.0D, "Against all torture", "Great Britain");
      var0.addValue(58.0D, "Against all torture", "USA");
      var0.addValue(48.0D, "Against all torture", "Israel");
      var0.addValue(43.0D, "Against all torture", "Russia");
      var0.addValue(23.0D, "Against all torture", "India");
      var0.addValue(59.0D, "Against all torture", "Average (*)");
      var0.addValue(5.0D, "-", "Italy");
      var0.addValue(4.0D, "-", "Great Britain");
      var0.addValue(6.0D, "-", "USA");
      var0.addValue(9.0D, "-", "Israel");
      var0.addValue(20.0D, "-", "Russia");
      var0.addValue(45.0D, "-", "India");
      var0.addValue(12.0D, "-", "Average (*)");
      var0.addValue(14.0D, "Some degree permissible", "Italy");
      var0.addValue(24.0D, "Some degree permissible", "Great Britain");
      var0.addValue(36.0D, "Some degree permissible", "USA");
      var0.addValue(43.0D, "Some degree permissible", "Israel");
      var0.addValue(37.0D, "Some degree permissible", "Russia");
      var0.addValue(32.0D, "Some degree permissible", "India");
      var0.addValue(29.0D, "Some degree permissible", "Average (*)");
      return var0;
   }

   private static JFreeChart createChart3(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedBarChart("Public Opinion : Torture of Prisoners", "Country", "%", var0, PlotOrientation.HORIZONTAL, false, true, false);
      var1.getTitle().setMargin(2.0D, 0.0D, 0.0D, 0.0D);
      TextTitle var2 = new TextTitle("Source: http://news.bbc.co.uk/1/hi/world/6063386.stm", new Font("Dialog", 0, 11));
      var2.setPosition(RectangleEdge.BOTTOM);
      var2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
      var2.setMargin(0.0D, 0.0D, 4.0D, 4.0D);
      var1.addSubtitle(var2);
      TextTitle var3 = new TextTitle("(*) Across 27,000 respondents in 25 countries", new Font("Dialog", 0, 11));
      var3.setPosition(RectangleEdge.BOTTOM);
      var3.setHorizontalAlignment(HorizontalAlignment.RIGHT);
      var3.setMargin(4.0D, 0.0D, 2.0D, 4.0D);
      var1.addSubtitle(var3);
      CategoryPlot var4 = (CategoryPlot)var1.getPlot();
      LegendItemCollection var5 = new LegendItemCollection();
      var5.add(new LegendItem("Against all torture", (String)null, (String)null, (String)null, new java.awt.geom.Rectangle2D.Double(-6.0D, -3.0D, 12.0D, 6.0D), Color.green));
      var5.add(new LegendItem("Some degree permissible", (String)null, (String)null, (String)null, new java.awt.geom.Rectangle2D.Double(-6.0D, -3.0D, 12.0D, 6.0D), Color.red));
      var4.setFixedLegendItems(var5);
      var4.setInsets(new RectangleInsets(5.0D, 5.0D, 5.0D, 20.0D));
      LegendTitle var6 = new LegendTitle(var4);
      var6.setPosition(RectangleEdge.BOTTOM);
      var1.addSubtitle(var6);
      var4.setBackgroundPaint(Color.lightGray);
      var4.setDomainGridlinePaint(Color.white);
      var4.setDomainGridlinesVisible(true);
      var4.setRangeGridlinePaint(Color.white);
      NumberAxis var7 = (NumberAxis)var4.getRangeAxis();
      var7.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var7.setUpperMargin(0.0D);
      BarRenderer var8 = (BarRenderer)var4.getRenderer();
      var8.setDrawBarOutline(false);
      GradientPaint var9 = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
      Color var10 = new Color(0, 0, 0, 0);
      GradientPaint var11 = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, new Color(64, 0, 0));
      var8.setSeriesPaint(0, var9);
      var8.setSeriesPaint(1, var10);
      var8.setSeriesPaint(2, var11);
      return var1;
   }

   private static XYDataset createDataset4() {
      YIntervalSeries var0 = new YIntervalSeries("Series 1");
      YIntervalSeries var1 = new YIntervalSeries("Series 2");
      Object var2 = new Week();
      double var3 = 100.0D;
      double var5 = 100.0D;

      for(int var7 = 0; var7 <= 52; ++var7) {
         double var8 = 0.05D * (double)var7;
         var0.add((double)((RegularTimePeriod)var2).getFirstMillisecond(), var3, var3 - var8, var3 + var8);
         var3 = var3 + Math.random() - 0.45D;
         double var10 = 0.07D * (double)var7;
         var1.add((double)((RegularTimePeriod)var2).getFirstMillisecond(), var5, var5 - var10, var5 + var10);
         var5 = var5 + Math.random() - 0.55D;
         var2 = ((RegularTimePeriod)var2).next();
      }

      YIntervalSeriesCollection var12 = new YIntervalSeriesCollection();
      var12.addSeries(var0);
      var12.addSeries(var1);
      return var12;
   }

   private static JFreeChart createChart4(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createTimeSeriesChart("Projected Values - Test", "Date", "Index Projection", var0, true, true, false);
      var1.setBackgroundPaint(Color.white);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setInsets(new RectangleInsets(5.0D, 5.0D, 5.0D, 20.0D));
      var2.setBackgroundPaint(Color.lightGray);
      var2.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
      var2.setDomainGridlinePaint(Color.white);
      var2.setRangeGridlinePaint(Color.white);
      DeviationRenderer var3 = new DeviationRenderer(true, false);
      var3.setSeriesStroke(0, new BasicStroke(3.0F, 1, 1));
      var3.setSeriesStroke(0, new BasicStroke(3.0F, 1, 1));
      var3.setSeriesStroke(1, new BasicStroke(3.0F, 1, 1));
      var3.setSeriesFillPaint(0, new Color(255, 200, 200));
      var3.setSeriesFillPaint(1, new Color(200, 200, 255));
      var2.setRenderer(var3);
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setAutoRangeIncludesZero(false);
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      return var1;
   }

   private static IntervalXYDataset createDataset5() {
      HistogramDataset var0 = new HistogramDataset();
      double[] var1 = new double[1000];
      Random var2 = new Random(12345678L);

      int var3;
      for(var3 = 0; var3 < 1000; ++var3) {
         var1[var3] = var2.nextGaussian() + 5.0D;
      }

      var0.addSeries("H1", var1, 100, 2.0D, 8.0D);
      var1 = new double[1000];

      for(var3 = 0; var3 < 1000; ++var3) {
         var1[var3] = var2.nextGaussian() + 7.0D;
      }

      var0.addSeries("H2", var1, 100, 4.0D, 10.0D);
      return var0;
   }

   private static JFreeChart createChart5(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createHistogram("Histogram Demo 1", (String)null, (String)null, var0, PlotOrientation.VERTICAL, true, true, false);
      var1.setBackgroundPaint(Color.white);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setBackgroundPaint(Color.lightGray);
      var2.setDomainGridlinePaint(Color.white);
      var2.setRangeGridlinePaint(Color.white);
      var2.setForegroundAlpha(0.85F);
      XYBarRenderer var3 = (XYBarRenderer)var2.getRenderer();
      var3.setDrawBarOutline(false);
      return var1;
   }

   private static CategoryDataset createDataset6() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(212.0D, "Classes", "JDK 1.0");
      var0.addValue(504.0D, "Classes", "JDK 1.1");
      var0.addValue(1520.0D, "Classes", "SDK 1.2");
      var0.addValue(1842.0D, "Classes", "SDK 1.3");
      var0.addValue(2991.0D, "Classes", "SDK 1.4");
      return var0;
   }

   private static JFreeChart createChart6(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createLineChart("Java Standard Class Library", "Release", "Class Count", var0, PlotOrientation.VERTICAL, false, true, false);
      var1.addSubtitle(new TextTitle("Number of Classes By Release"));
      TextTitle var2 = new TextTitle("Source: Java In A Nutshell (4th Edition) by David Flanagan (O\'Reilly)");
      var2.setFont(new Font("SansSerif", 0, 10));
      var2.setPosition(RectangleEdge.BOTTOM);
      var2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
      var1.addSubtitle(var2);
      var1.setBackgroundPaint(Color.white);
      CategoryPlot var3 = (CategoryPlot)var1.getPlot();
      var3.setBackgroundPaint(Color.lightGray);
      var3.setRangeGridlinePaint(Color.white);
      NumberAxis var4 = (NumberAxis)var3.getRangeAxis();
      var4.setUpperMargin(0.15D);
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      LineAndShapeRenderer var5 = (LineAndShapeRenderer)var3.getRenderer();
      var5.setBaseShapesVisible(true);
      var5.setDrawOutlines(true);
      var5.setUseFillPaint(true);
      var5.setBaseFillPaint(Color.white);
      var5.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
      var5.setBaseItemLabelsVisible(true);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JPanel var0 = new JPanel(new GridLayout(2, 3));
      JFreeChart var1 = createChart1(createDataset1());
      ChartUtilities.applyCurrentTheme(var1);
      BufferedImage var2 = var1.createBufferedImage(120, 80, 360.0D, 240.0D, (ChartRenderingInfo)null);
      ImageIcon var3 = new ImageIcon(var2);
      var0.add(new JButton(var3));
      JFreeChart var4 = createChart2(createDataset2());
      ChartUtilities.applyCurrentTheme(var4);
      BufferedImage var5 = var4.createBufferedImage(120, 80, 360.0D, 240.0D, (ChartRenderingInfo)null);
      ImageIcon var6 = new ImageIcon(var5);
      var0.add(new JButton(var6));
      JFreeChart var7 = createChart3(createDataset3());
      ChartUtilities.applyCurrentTheme(var7);
      BufferedImage var8 = var7.createBufferedImage(120, 80, 360.0D, 240.0D, (ChartRenderingInfo)null);
      ImageIcon var9 = new ImageIcon(var8);
      var0.add(new JButton(var9));
      JFreeChart var10 = createChart4(createDataset4());
      ChartUtilities.applyCurrentTheme(var10);
      BufferedImage var11 = var10.createBufferedImage(120, 80, 360.0D, 240.0D, (ChartRenderingInfo)null);
      ImageIcon var12 = new ImageIcon(var11);
      var0.add(new JButton(var12));
      JFreeChart var13 = createChart5(createDataset5());
      ChartUtilities.applyCurrentTheme(var13);
      BufferedImage var14 = var13.createBufferedImage(120, 80, 360.0D, 240.0D, (ChartRenderingInfo)null);
      ImageIcon var15 = new ImageIcon(var14);
      var0.add(new JButton(var15));
      JFreeChart var16 = createChart6(createDataset6());
      ChartUtilities.applyCurrentTheme(var16);
      BufferedImage var17 = var16.createBufferedImage(120, 80, 360.0D, 240.0D, (ChartRenderingInfo)null);
      ImageIcon var18 = new ImageIcon(var17);
      var0.add(new JButton(var18));
      return var0;
   }

   public static void main(String[] var0) {
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      ThumbnailDemo1 var1 = new ThumbnailDemo1("JFreeChart: ThumbnailDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
