package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import demo.orsoncharts.BarChart3D2;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BarChart3DDemo2 extends JFrame {

   public BarChart3DDemo2(String var1) {
      super(var1);
      this.addWindowListener(new ExitOnClose());
      this.getContentPane().add(createDemoPanel());
   }

   public static JPanel createDemoPanel() {
      DemoPanel var0 = new DemoPanel(new BorderLayout());
      var0.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      CategoryDataset3D var1 = BarChart3D2.createDataset();
      Chart3D var2 = BarChart3D2.createChart(var1);
      Chart3DPanel var3 = new Chart3DPanel(var2);
      var0.setChartPanel(var3);
      var0.add(new DisplayPanel3D(var3));
      var3.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      return var0;
   }

   public static void main(String[] var0) {
      BarChart3DDemo2 var1 = new BarChart3DDemo2("OrsonCharts: BarChart3DDemo2.java");
      var1.pack();
      var1.setVisible(true);
   }
}
