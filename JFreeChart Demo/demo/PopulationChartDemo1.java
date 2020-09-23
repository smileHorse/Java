package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultKeyedValues2DDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PopulationChartDemo1 extends ApplicationFrame {

   public PopulationChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   public static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createStackedBarChart("Population Chart Demo 1", "Age Group", "Population (millions)", var0, PlotOrientation.HORIZONTAL, true, true, false);
      return var1;
   }

   public static CategoryDataset createDataset() {
      DefaultKeyedValues2DDataset var0 = new DefaultKeyedValues2DDataset();
      var0.addValue(-6.0D, "Male", "70+");
      var0.addValue(-8.0D, "Male", "60-69");
      var0.addValue(-11.0D, "Male", "50-59");
      var0.addValue(-13.0D, "Male", "40-49");
      var0.addValue(-14.0D, "Male", "30-39");
      var0.addValue(-15.0D, "Male", "20-29");
      var0.addValue(-19.0D, "Male", "10-19");
      var0.addValue(-21.0D, "Male", "0-9");
      var0.addValue(10.0D, "Female", "70+");
      var0.addValue(12.0D, "Female", "60-69");
      var0.addValue(13.0D, "Female", "50-59");
      var0.addValue(14.0D, "Female", "40-49");
      var0.addValue(15.0D, "Female", "30-39");
      var0.addValue(17.0D, "Female", "20-29");
      var0.addValue(19.0D, "Female", "10-19");
      var0.addValue(20.0D, "Female", "0-9");
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      return var1;
   }

   public static void main(String[] var0) {
      PopulationChartDemo1 var1 = new PopulationChartDemo1("JFreeChart: PopulationChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
