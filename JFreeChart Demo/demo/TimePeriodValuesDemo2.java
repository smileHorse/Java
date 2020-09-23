package demo;

import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.time.TimePeriodValuesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimePeriodValuesDemo2 extends ApplicationFrame {

   public TimePeriodValuesDemo2(String var1) {
      super(var1);
      XYDataset var2 = this.createDataset();
      XYBarRenderer var3 = new XYBarRenderer();
      DateAxis var4 = new DateAxis("Date");
      NumberAxis var5 = new NumberAxis("Value");
      XYPlot var6 = new XYPlot(var2, var4, var5, var3);
      JFreeChart var7 = new JFreeChart("Time Period Values Demo", var6);
      ChartUtilities.applyCurrentTheme(var7);
      ChartPanel var8 = new ChartPanel(var7);
      var8.setPreferredSize(new Dimension(500, 270));
      var8.setMouseZoomable(true);
      this.setContentPane(var8);
   }

   public XYDataset createDataset() {
      TimePeriodValues var1 = new TimePeriodValues("Series 1");
      Day var2 = new Day();
      Day var3 = (Day)var2.next();
      Day var4 = (Day)var3.next();
      Day var5 = (Day)var4.next();
      Day var6 = (Day)var5.next();
      Day var7 = (Day)var6.next();
      Day var8 = (Day)var7.next();
      var1.add(new SimpleTimePeriod(var7.getStart(), var7.getEnd()), 74.95D);
      var1.add(new SimpleTimePeriod(var2.getStart(), var3.getEnd()), 55.75D);
      var1.add(new SimpleTimePeriod(var8.getStart(), var8.getEnd()), 90.45D);
      var1.add(new SimpleTimePeriod(var4.getStart(), var6.getEnd()), 105.75D);
      TimePeriodValuesCollection var9 = new TimePeriodValuesCollection();
      var9.addSeries(var1);
      return var9;
   }

   public static void main(String[] var0) {
      TimePeriodValuesDemo2 var1 = new TimePeriodValuesDemo2("Time Period Values Demo 2");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
