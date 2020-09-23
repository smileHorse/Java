package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo5 extends ApplicationFrame {

   public XYBarChartDemo5(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 300));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYBarChart("US Budget Deficit", "Year", true, "$ Billion", var0, PlotOrientation.VERTICAL, false, false, false);
      TextTitle var2 = new TextTitle("Source: http://www.cbo.gov/showdoc.cfm?index=1821&sequence=0#table12");
      var2.setFont(new Font("Dialog", 0, 8));
      var2.setPosition(RectangleEdge.BOTTOM);
      var2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
      var1.addSubtitle(var2);
      XYPlot var3 = (XYPlot)var1.getPlot();
      XYBarRenderer var4 = (XYBarRenderer)var3.getRenderer();
      var4.setDrawBarOutline(true);
      var4.setSeriesOutlinePaint(0, Color.red);
      StandardXYToolTipGenerator var5 = new StandardXYToolTipGenerator("{1} = {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0"));
      var4.setBaseToolTipGenerator(var5);
      DateAxis var6 = (DateAxis)var3.getDomainAxis();
      var6.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
      var6.setLowerMargin(0.01D);
      var6.setUpperMargin(0.01D);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static IntervalXYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Budget", "Year", "$ Million");

      try {
         var0.add(new Year(1980), -74.0D);
         var0.add(new Year(1981), -79.0D);
         var0.add(new Year(1982), -128.0D);
         var0.add(new Year(1983), -208.0D);
         var0.add(new Year(1984), -185.0D);
         var0.add(new Year(1985), -212.0D);
         var0.add(new Year(1986), -221.0D);
         var0.add(new Year(1987), -150.0D);
         var0.add(new Year(1988), -155.0D);
         var0.add(new Year(1989), -153.0D);
         var0.add(new Year(1990), -221.0D);
         var0.add(new Year(1991), -269.0D);
         var0.add(new Year(1992), -290.0D);
         var0.add(new Year(1993), -255.0D);
         var0.add(new Year(1994), -203.0D);
         var0.add(new Year(1995), -164.0D);
         var0.add(new Year(1996), -107.0D);
         var0.add(new Year(1997), -22.0D);
         var0.add(new Year(1998), 69.0D);
         var0.add(new Year(1999), 126.0D);
         var0.add(new Year(2000), 236.0D);
         var0.add(new Year(2001), 128.0D);
         var0.add(new Year(2002), -158.0D);
         var0.add(new Year(2003), -378.0D);
         var0.add(new Year(2004), -412.0D);
      } catch (Exception var2) {
         System.err.println(var2.getMessage());
      }

      TimeSeriesCollection var1 = new TimeSeriesCollection(var0);
      return var1;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      XYBarChartDemo5 var1 = new XYBarChartDemo5("US Budget Deficit");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
