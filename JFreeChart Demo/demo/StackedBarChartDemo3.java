package demo;

import demo.ExtendedStackedBarRenderer;
import java.awt.Dimension;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChartDemo3 extends ApplicationFrame {

   public StackedBarChartDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(10.0D, "Series 1", "Jan");
      var0.addValue(12.0D, "Series 1", "Feb");
      var0.addValue(13.0D, "Series 1", "Mar");
      var0.addValue(4.0D, "Series 2", "Jan");
      var0.addValue(3.0D, "Series 2", "Feb");
      var0.addValue(2.0D, "Series 2", "Mar");
      var0.addValue(2.0D, "Series 3", "Jan");
      var0.addValue(3.0D, "Series 3", "Feb");
      var0.addValue(2.0D, "Series 3", "Mar");
      var0.addValue(2.0D, "Series 4", "Jan");
      var0.addValue(3.0D, "Series 4", "Feb");
      var0.addValue(4.0D, "Series 4", "Mar");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedBarChart("Stacked Bar Chart Demo 3", "Category", "Value", var0, PlotOrientation.VERTICAL, true, false, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      ExtendedStackedBarRenderer var3 = new ExtendedStackedBarRenderer();
      var3.setBaseItemLabelsVisible(true);
      var3.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
      var3.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
      var2.setRenderer(var3);
      NumberAxis var4 = (NumberAxis)var2.getRangeAxis();
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var4.setLowerMargin(0.15D);
      var4.setUpperMargin(0.15D);
      var4.setNumberFormatOverride(NumberFormat.getPercentInstance());
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      StackedBarChartDemo3 var1 = new StackedBarChartDemo3("Stacked Bar Chart Demo 3");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
