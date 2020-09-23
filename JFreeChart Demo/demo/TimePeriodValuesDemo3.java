package demo;

import java.awt.Dimension;
import java.text.DateFormat;
import java.util.Date;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.time.TimePeriodValuesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimePeriodValuesDemo3 extends ApplicationFrame {

   public TimePeriodValuesDemo3(String var1) {
      super(var1);
      XYDataset var2 = this.createDataset();
      XYBarRenderer var3 = new XYBarRenderer();
      var3.setDrawBarOutline(false);
      DateAxis var4 = new DateAxis("Date");
      NumberAxis var5 = new NumberAxis("Value");
      XYPlot var6 = new XYPlot(var2, var4, var5, var3);
      JFreeChart var7 = new JFreeChart("Time Period Values Demo 3", var6);
      ChartUtilities.applyCurrentTheme(var7);
      ChartPanel var8 = new ChartPanel(var7);
      var8.setPreferredSize(new Dimension(500, 270));
      var8.setMouseZoomable(true);
      this.setContentPane(var8);
   }

   public XYDataset createDataset() {
      TimePeriodValues var1 = new TimePeriodValues("Series 1");
      DateFormat var2 = DateFormat.getInstance();

      try {
         Date var3 = var2.parse("11/5/2003 0:00:00.000");
         Date var4 = var2.parse("11/5/2003 0:15:00.000");
         Date var5 = var2.parse("11/5/2003 0:30:00.000");
         Date var6 = var2.parse("11/5/2003 0:45:00.000");
         Date var7 = var2.parse("11/5/2003 1:00:00.001");
         Date var8 = var2.parse("11/5/2003 1:14:59.999");
         Date var9 = var2.parse("11/5/2003 1:30:00.000");
         Date var10 = var2.parse("11/5/2003 1:45:00.000");
         Date var11 = var2.parse("11/5/2003 2:00:00.000");
         Date var12 = var2.parse("11/5/2003 2:15:00.000");
         var1.add(new SimpleTimePeriod(var3, var4), 0.39D);
         var1.add(new SimpleTimePeriod(var5, var6), 0.225D);
         var1.add(new SimpleTimePeriod(var6, var7), 0.235D);
         var1.add(new SimpleTimePeriod(var7, var8), 0.238D);
         var1.add(new SimpleTimePeriod(var8, var9), 0.236D);
         var1.add(new SimpleTimePeriod(var9, var10), 0.25D);
         var1.add(new SimpleTimePeriod(var10, var11), 0.238D);
         var1.add(new SimpleTimePeriod(var11, var12), 0.215D);
      } catch (Exception var13) {
         var13.printStackTrace();
      }

      TimePeriodValuesCollection var14 = new TimePeriodValuesCollection();
      var14.addSeries(var1);
      return var14;
   }

   public static void main(String[] var0) {
      TimePeriodValuesDemo3 var1 = new TimePeriodValuesDemo3("JFreeChart: TimePeriodValuesDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
