package demo;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MouseListenerDemo2 extends ApplicationFrame implements ChartMouseListener {

   public MouseListenerDemo2(String var1) {
      super(var1);
      DefaultCategoryDataset var2 = new DefaultCategoryDataset();
      var2.addValue(1.0D, "S1", "C1");
      var2.addValue(4.0D, "S1", "C2");
      var2.addValue(3.0D, "S1", "C3");
      var2.addValue(5.0D, "S1", "C4");
      var2.addValue(5.0D, "S1", "C5");
      var2.addValue(6.0D, "S1", "C6");
      var2.addValue(7.0D, "S1", "C7");
      var2.addValue(8.0D, "S1", "C8");
      var2.addValue(5.0D, "S2", "C1");
      var2.addValue(7.0D, "S2", "C2");
      var2.addValue(6.0D, "S2", "C3");
      var2.addValue(8.0D, "S2", "C4");
      var2.addValue(4.0D, "S2", "C5");
      var2.addValue(4.0D, "S2", "C6");
      var2.addValue(3.0D, "S2", "C7");
      var2.addValue(1.0D, "S2", "C8");
      var2.addValue(4.0D, "S3", "C1");
      var2.addValue(3.0D, "S3", "C2");
      var2.addValue(2.0D, "S3", "C3");
      var2.addValue(3.0D, "S3", "C4");
      var2.addValue(6.0D, "S3", "C5");
      var2.addValue(3.0D, "S3", "C6");
      var2.addValue(4.0D, "S3", "C7");
      var2.addValue(3.0D, "S3", "C8");
      JFreeChart var3 = ChartFactory.createBarChart("MouseListenerDemo2", "Category", "Value", var2, PlotOrientation.VERTICAL, true, true, false);
      ChartPanel var4 = new ChartPanel(var3);
      var4.addChartMouseListener(this);
      var4.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var4);
   }

   public void chartMouseClicked(ChartMouseEvent var1) {
      ChartEntity var2 = var1.getEntity();
      if(var2 != null) {
         System.out.println("Mouse clicked: " + var2.toString());
      } else {
         System.out.println("Mouse clicked: null entity.");
      }

   }

   public void chartMouseMoved(ChartMouseEvent var1) {
      int var2 = var1.getTrigger().getX();
      int var3 = var1.getTrigger().getY();
      ChartEntity var4 = var1.getEntity();
      if(var4 != null) {
         System.out.println("Mouse moved: " + var2 + ", " + var3 + ": " + var4.toString());
      } else {
         System.out.println("Mouse moved: " + var2 + ", " + var3 + ": null entity.");
      }

   }

   public static void main(String[] var0) {
      MouseListenerDemo2 var1 = new MouseListenerDemo2("JFreeChart: MouseListenerDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
