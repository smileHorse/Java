package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYBarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.time.Year;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class StackedXYBarChartDemo2 extends ApplicationFrame {

   public StackedXYBarChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static TableXYDataset createDataset() {
      TimeTableXYDataset var0 = new TimeTableXYDataset();
      var0.add(new Year(1983), 0.0D, "Albatrosses");
      var0.add(new Year(1984), 2.0D, "Albatrosses");
      var0.add(new Year(1985), 1.0D, "Albatrosses");
      var0.add(new Year(1986), 1.0D, "Albatrosses");
      var0.add(new Year(1987), 2.0D, "Albatrosses");
      var0.add(new Year(1988), 2.0D, "Albatrosses");
      var0.add(new Year(1989), 1.0D, "Albatrosses");
      var0.add(new Year(1990), 5.0D, "Albatrosses");
      var0.add(new Year(1991), 5.0D, "Albatrosses");
      var0.add(new Year(1992), 2.0D, "Albatrosses");
      var0.add(new Year(1993), 4.0D, "Albatrosses");
      var0.add(new Year(1994), 3.0D, "Albatrosses");
      var0.add(new Year(1995), 2.0D, "Albatrosses");
      var0.add(new Year(1996), 1.0D, "Albatrosses");
      var0.add(new Year(1997), 2.0D, "Albatrosses");
      var0.add(new Year(1998), 1.0D, "Albatrosses");
      var0.add(new Year(1999), 4.0D, "Albatrosses");
      var0.add(new Year(2000), 6.0D, "Albatrosses");
      var0.add(new Year(2001), 5.0D, "Albatrosses");
      var0.add(new Year(2002), 4.0D, "Albatrosses");
      var0.add(new Year(2003), 2.0D, "Albatrosses");
      var0.add(new Year(1983), 21.0D, "Aces");
      var0.add(new Year(1984), 24.0D, "Aces");
      var0.add(new Year(1985), 32.0D, "Aces");
      var0.add(new Year(1986), 20.0D, "Aces");
      var0.add(new Year(1987), 28.0D, "Aces");
      var0.add(new Year(1988), 17.0D, "Aces");
      var0.add(new Year(1989), 31.0D, "Aces");
      var0.add(new Year(1990), 32.0D, "Aces");
      var0.add(new Year(1991), 29.0D, "Aces");
      var0.add(new Year(1992), 31.0D, "Aces");
      var0.add(new Year(1993), 25.0D, "Aces");
      var0.add(new Year(1994), 44.0D, "Aces");
      var0.add(new Year(1995), 35.0D, "Aces");
      var0.add(new Year(1996), 40.0D, "Aces");
      var0.add(new Year(1997), 32.0D, "Aces");
      var0.add(new Year(1998), 32.0D, "Aces");
      var0.add(new Year(1999), 30.0D, "Aces");
      var0.add(new Year(2000), 29.0D, "Aces");
      var0.add(new Year(2001), 28.0D, "Aces");
      var0.add(new Year(2002), 39.0D, "Aces");
      var0.add(new Year(2003), 32.0D, "Aces");
      return var0;
   }

   private static JFreeChart createChart(TableXYDataset var0) {
      DateAxis var1 = new DateAxis("Date");
      var1.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
      var1.setLowerMargin(0.01D);
      var1.setUpperMargin(0.01D);
      NumberAxis var2 = new NumberAxis("Count");
      var2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var2.setUpperMargin(0.1D);
      StackedXYBarRenderer var3 = new StackedXYBarRenderer(0.15D);
      var3.setDrawBarOutline(false);
      var3.setBaseItemLabelsVisible(true);
      var3.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
      var3.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
      var3.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0} : {1} = {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0")));
      XYPlot var4 = new XYPlot(var0, var1, var2, var3);
      JFreeChart var5 = new JFreeChart("Holes-In-One / Double Eagles", var4);
      var5.removeLegend();
      var5.addSubtitle(new TextTitle("PGA Tour, 1983 to 2003"));
      TextTitle var6 = new TextTitle("http://www.golfdigest.com/majors/masters/index.ssf?/majors/masters/gw20040402albatross.html", new Font("Dialog", 0, 8));
      var5.addSubtitle(var6);
      var5.setTextAntiAlias(RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
      LegendTitle var7 = new LegendTitle(var4);
      var7.setBackgroundPaint(Color.white);
      var7.setFrame(new BlockBorder());
      var7.setPosition(RectangleEdge.BOTTOM);
      var5.addSubtitle(var7);
      ChartUtilities.applyCurrentTheme(var5);
      return var5;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedXYBarChartDemo2 var1 = new StackedXYBarChartDemo2("JFreeChart: Stacked XY Bar Chart Demo 2");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
