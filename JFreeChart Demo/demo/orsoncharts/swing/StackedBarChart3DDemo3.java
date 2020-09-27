package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import demo.orsoncharts.StackedBarChart3D3;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StackedBarChart3DDemo3 extends JFrame {

   public StackedBarChart3DDemo3(String var1) {
      super(var1);
      this.addWindowListener(new ExitOnClose());
      this.getContentPane().add(createDemoPanel());
   }

   public static JPanel createDemoPanel() {
      DemoPanel var0 = new DemoPanel(new BorderLayout());
      var0.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      CategoryDataset3D var1 = StackedBarChart3D3.createDataset();
      Chart3D var2 = StackedBarChart3D3.createChart(var1);
      Chart3DPanel var3 = new Chart3DPanel(var2);
      var3.setMargin(0.33D);
      var0.setChartPanel(var3);
      var3.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      var0.add(new DisplayPanel3D(var3));
      return var0;
   }

   public static void main(String[] var0) {
      StackedBarChart3DDemo3 var1 = new StackedBarChart3DDemo3("OrsonCharts: StackedBarChart3DDemo3.java");
      var1.pack();
      var1.setVisible(true);
   }
}