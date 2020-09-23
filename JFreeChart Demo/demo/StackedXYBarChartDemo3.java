package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
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
import org.jfree.chart.renderer.xy.StackedXYBarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.time.Year;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class StackedXYBarChartDemo3 extends ApplicationFrame {

   public StackedXYBarChartDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static TableXYDataset createDataset() {
      TimeTableXYDataset var0 = new TimeTableXYDataset();
      var0.add(new Year(2002), 41287.0D, "Landfilled");
      var0.add(new Year(2003), 41096.0D, "Landfilled");
      var0.add(new Year(2004), 39603.0D, "Landfilled");
      var0.add(new Year(2005), 39693.0D, "Landfilled");
      var0.add(new Year(2006), 37227.0D, "Landfilled");
      var0.add(new Year(2002), 7717.0D, "Recycled");
      var0.add(new Year(2003), 8317.0D, "Recycled");
      var0.add(new Year(2004), 9493.0D, "Recycled");
      var0.add(new Year(2005), 11228.0D, "Recycled");
      var0.add(new Year(2006), 14941.0D, "Recycled");
      return var0;
   }

   private static JFreeChart createChart(TableXYDataset var0) {
      DateAxis var1 = new DateAxis("Year");
      var1.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
      var1.setLowerMargin(0.01D);
      var1.setUpperMargin(0.01D);
      NumberAxis var2 = new NumberAxis("Tonnes");
      var2.setNumberFormatOverride(new DecimalFormat("0.0%"));
      StackedXYBarRenderer var3 = new StackedXYBarRenderer(0.3D);
      var3.setRenderAsPercentages(true);
      var3.setDrawBarOutline(false);
      var3.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0} : {1} = {2} tonnes", new SimpleDateFormat("yyyy"), new DecimalFormat("#,##0")));
      XYPlot var4 = new XYPlot(var0, var1, var2, var3);
      var4.setBackgroundPaint(Color.lightGray);
      var4.setDomainGridlinePaint(Color.white);
      var4.setRangeGridlinePaint(Color.white);
      JFreeChart var5 = new JFreeChart("Waste Management", var4);
      var5.setBackgroundPaint(Color.white);
      var5.addSubtitle(new TextTitle("St Albans City and District Council"));
      ChartUtilities.applyCurrentTheme(var5);
      GradientPaint var6 = new GradientPaint(0.0F, 0.0F, new Color(64, 0, 0), 0.0F, 0.0F, Color.red);
      GradientPaint var7 = new GradientPaint(0.0F, 0.0F, new Color(0, 64, 0), 0.0F, 0.0F, Color.green);
      var3.setSeriesPaint(0, var6);
      var3.setSeriesPaint(1, var7);
      var3.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
      return var5;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedXYBarChartDemo3 var1 = new StackedXYBarChartDemo3("JFreeChart: StackedXYBarChartDemo3");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
