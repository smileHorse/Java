package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class WaterfallChartDemo1 extends ApplicationFrame {

   public WaterfallChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(15.76D, "Product 1", "Labour");
      var0.addValue(8.66D, "Product 1", "Administration");
      var0.addValue(4.71D, "Product 1", "Marketing");
      var0.addValue(3.51D, "Product 1", "Distribution");
      var0.addValue(32.64D, "Product 1", "Total Expense");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createWaterfallChart("Product Cost Breakdown", "Expense Category", "Cost Per Unit", var0, PlotOrientation.VERTICAL, false, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      ValueAxis var3 = var2.getRangeAxis();
      DecimalFormat var4 = new DecimalFormat("##,###");
      var4.setNegativePrefix("(");
      var4.setNegativeSuffix(")");
      TickUnits var5 = new TickUnits();
      var5.add(new NumberTickUnit(5.0D, var4));
      var5.add(new NumberTickUnit(10.0D, var4));
      var5.add(new NumberTickUnit(20.0D, var4));
      var5.add(new NumberTickUnit(50.0D, var4));
      var5.add(new NumberTickUnit(100.0D, var4));
      var5.add(new NumberTickUnit(200.0D, var4));
      var5.add(new NumberTickUnit(500.0D, var4));
      var5.add(new NumberTickUnit(1000.0D, var4));
      var5.add(new NumberTickUnit(2000.0D, var4));
      var5.add(new NumberTickUnit(5000.0D, var4));
      var3.setStandardTickUnits(var5);
      BarRenderer var6 = (BarRenderer)var2.getRenderer();
      var6.setDrawBarOutline(false);
      var6.setBase(5.0D);
      DecimalFormat var7 = new DecimalFormat("$##,###.00");
      var7.setNegativePrefix("(");
      var7.setNegativeSuffix(")");
      var6.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", var7));
      var6.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{0}, {1}) = {2}", new DecimalFormat("$##,###.00")));
      var6.setBaseItemLabelsVisible(true);
      return var1;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      WaterfallChartDemo1 var1 = new WaterfallChartDemo1("JFreeChart: WaterfallChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
