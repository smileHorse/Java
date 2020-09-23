package demo;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;

public class DemoPanel extends JPanel {

   List charts = new ArrayList();


   public DemoPanel(LayoutManager var1) {
      super(var1);
   }

   public void addChart(JFreeChart var1) {
      this.charts.add(var1);
   }

   public JFreeChart[] getCharts() {
      int var1 = this.charts.size();
      JFreeChart[] var2 = new JFreeChart[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = (JFreeChart)this.charts.get(var3);
      }

      return var2;
   }
}
