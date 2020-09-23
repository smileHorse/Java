package demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class First {

   public static void main(String[] var0) {
      DefaultPieDataset var1 = new DefaultPieDataset();
      var1.setValue("Category 1", 43.2D);
      var1.setValue("Category 2", 27.9D);
      var1.setValue("Category 3", 79.5D);
      JFreeChart var2 = ChartFactory.createPieChart("Sample Pie Chart", var1, true, true, false);
      ChartFrame var3 = new ChartFrame("JFreeChart: First.java", var2);
      var3.pack();
      var3.setVisible(true);
   }
}
