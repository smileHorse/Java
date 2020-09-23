package demo;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.time.TimePeriodValuesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimePeriodValuesDemo1 extends ApplicationFrame {

   public TimePeriodValuesDemo1(String var1) {
      super(var1);
      XYDataset var2 = this.createDataset1();
      XYBarRenderer var3 = new XYBarRenderer();
      DateAxis var4 = new DateAxis("Date");
      var4.setVerticalTickLabels(true);
      var4.setTickUnit(new DateTickUnit(DateTickUnitType.HOUR, 1));
      var4.setDateFormatOverride(new SimpleDateFormat("hh:mm"));
      var4.setLowerMargin(0.01D);
      var4.setUpperMargin(0.01D);
      NumberAxis var5 = new NumberAxis("Value");
      XYPlot var6 = new XYPlot(var2, var4, var5, var3);
      XYDataset var7 = this.createDataset2();
      StandardXYItemRenderer var8 = new StandardXYItemRenderer(3);
      var8.setBaseShapesFilled(true);
      var6.setDataset(1, var7);
      var6.setRenderer(1, var8);
      JFreeChart var9 = new JFreeChart("Supply and Demand", var6);
      ChartUtilities.applyCurrentTheme(var9);
      ChartPanel var10 = new ChartPanel(var9);
      var10.setPreferredSize(new Dimension(500, 270));
      var10.setMouseZoomable(true);
      this.setContentPane(var10);
   }

   public XYDataset createDataset1() {
      TimePeriodValues var1 = new TimePeriodValues("Supply");
      TimePeriodValues var2 = new TimePeriodValues("Demand");
      Day var3 = new Day();

      for(int var4 = 0; var4 < 24; ++var4) {
         Minute var5 = new Minute(0, new Hour(var4, var3));
         Minute var6 = new Minute(15, new Hour(var4, var3));
         Minute var7 = new Minute(30, new Hour(var4, var3));
         Minute var8 = new Minute(45, new Hour(var4, var3));
         Minute var9 = new Minute(0, new Hour(var4 + 1, var3));
         var1.add(new SimpleTimePeriod(var5.getStart(), var6.getStart()), Math.random());
         var2.add(new SimpleTimePeriod(var6.getStart(), var7.getStart()), Math.random());
         var1.add(new SimpleTimePeriod(var7.getStart(), var8.getStart()), Math.random());
         var2.add(new SimpleTimePeriod(var8.getStart(), var9.getStart()), Math.random());
      }

      TimePeriodValuesCollection var10 = new TimePeriodValuesCollection();
      var10.addSeries(var1);
      var10.addSeries(var2);
      return var10;
   }

   public XYDataset createDataset2() {
      TimePeriodValues var1 = new TimePeriodValues("WebCOINS");
      Day var2 = new Day();

      for(int var3 = 0; var3 < 24; ++var3) {
         Minute var4 = new Minute(0, new Hour(var3, var2));
         Minute var5 = new Minute(30, new Hour(var3, var2));
         Minute var6 = new Minute(0, new Hour(var3 + 1, var2));
         var1.add(new SimpleTimePeriod(var4.getStart(), var5.getStart()), Math.random() * 2.0D);
         var1.add(new SimpleTimePeriod(var5.getStart(), var6.getStart()), Math.random() * 2.0D);
      }

      TimePeriodValuesCollection var7 = new TimePeriodValuesCollection();
      var7.addSeries(var1);
      return var7;
   }

   public static void main(String[] var0) {
      TimePeriodValuesDemo1 var1 = new TimePeriodValuesDemo1("Time Period Values Demo 1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
