package demo;

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
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo1 extends ApplicationFrame {

   public XYBarChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(IntervalXYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYBarChart("State Executions - USA", "Year", true, "Number of People", var0, PlotOrientation.VERTICAL, true, false, false);
      var1.addSubtitle(new TextTitle("Source: http://www.amnestyusa.org/abolish/listbyyear.do", new Font("Dialog", 2, 10)));
      XYPlot var2 = (XYPlot)var1.getPlot();
      XYBarRenderer var3 = (XYBarRenderer)var2.getRenderer();
      StandardXYToolTipGenerator var4 = new StandardXYToolTipGenerator("{1} = {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0"));
      var3.setBaseToolTipGenerator(var4);
      var3.setMargin(0.1D);
      DateAxis var5 = (DateAxis)var2.getDomainAxis();
      var5.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
      var5.setLowerMargin(0.01D);
      var5.setUpperMargin(0.01D);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static IntervalXYDataset createDataset() {
      TimeSeries var0 = new TimeSeries("Executions", "Year", "Count");

      try {
         var0.add(new Year(1976), new Integer(0));
         var0.add(new Year(1977), new Integer(1));
         var0.add(new Year(1978), new Integer(0));
         var0.add(new Year(1979), new Integer(2));
         var0.add(new Year(1980), new Integer(0));
         var0.add(new Year(1981), new Integer(1));
         var0.add(new Year(1982), new Integer(2));
         var0.add(new Year(1983), new Integer(5));
         var0.add(new Year(1984), new Integer(21));
         var0.add(new Year(1985), new Integer(18));
         var0.add(new Year(1986), new Integer(18));
         var0.add(new Year(1987), new Integer(25));
         var0.add(new Year(1988), new Integer(11));
         var0.add(new Year(1989), new Integer(16));
         var0.add(new Year(1990), new Integer(23));
         var0.add(new Year(1991), new Integer(14));
         var0.add(new Year(1992), new Integer(31));
         var0.add(new Year(1993), new Integer(38));
         var0.add(new Year(1994), new Integer(31));
         var0.add(new Year(1995), new Integer(56));
         var0.add(new Year(1996), new Integer(45));
         var0.add(new Year(1997), new Integer(74));
         var0.add(new Year(1998), new Integer(68));
         var0.add(new Year(1999), new Integer(98));
         var0.add(new Year(2000), new Integer(85));
         var0.add(new Year(2001), new Integer(66));
         var0.add(new Year(2002), new Integer(71));
         var0.add(new Year(2003), new Integer(65));
         var0.add(new Year(2004), new Integer(59));
         var0.add(new Year(2005), new Integer(60));
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
      XYBarChartDemo1 var1 = new XYBarChartDemo1("State Executions - USA");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
