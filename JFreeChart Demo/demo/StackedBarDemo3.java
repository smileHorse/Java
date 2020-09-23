package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarDemo3 extends ApplicationFrame {

   public StackedBarDemo3(String var1) {
      super(var1);
      DefaultCategoryDataset var2 = new DefaultCategoryDataset();
      var2.addValue(1.0D, "Row 1", "Column 1");
      var2.addValue(5.0D, "Row 1", "Column 2");
      var2.addValue(3.0D, "Row 1", "Column 3");
      var2.addValue(2.0D, "Row 2", "Column 1");
      var2.addValue(3.0D, "Row 2", "Column 2");
      var2.addValue(2.0D, "Row 2", "Column 3");
      JFreeChart var3 = ChartFactory.createStackedBarChart("StackedBarDemo3", "Category", "Value", var2, PlotOrientation.VERTICAL, true, true, false);
      CategoryPlot var4 = (CategoryPlot)var3.getPlot();
      StackedBarRenderer var5 = (StackedBarRenderer)var4.getRenderer();
      var5.setRenderAsPercentages(true);
      NumberAxis var6 = (NumberAxis)var4.getRangeAxis();
      var6.setLabel("Percentage");
      var6.setNumberFormatOverride(new DecimalFormat("0.0%"));
      ChartPanel var7 = new ChartPanel(var3);
      var7.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var7);
   }

   public static void main(String[] var0) {
      StackedBarDemo3 var1 = new StackedBarDemo3("StackedBarDemo3");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
