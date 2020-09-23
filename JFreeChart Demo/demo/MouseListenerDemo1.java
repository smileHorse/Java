package demo;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MouseListenerDemo1 extends ApplicationFrame implements ChartMouseListener {

   public MouseListenerDemo1(String var1) {
      super(var1);
      DefaultPieDataset var2 = new DefaultPieDataset();
      var2.setValue("Java", new Double(43.2D));
      var2.setValue("Visual Basic", new Double(0.0D));
      var2.setValue("C/C++", new Double(17.5D));
      JFreeChart var3 = ChartFactory.createPieChart("MouseListenerDemo1", var2, true, true, false);
      ChartPanel var4 = new ChartPanel(var3, false, false, false, false, false);
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
      MouseListenerDemo1 var1 = new MouseListenerDemo1("JFreeChart: MouseListenerDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
