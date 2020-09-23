package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import demo.orsoncharts.SurfaceRenderer2;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SurfaceRendererDemo2 extends JFrame {

   public SurfaceRendererDemo2(String var1) {
      super(var1);
      this.addWindowListener(new ExitOnClose());
      this.getContentPane().add(createDemoPanel());
   }

   public static JPanel createDemoPanel() {
      DemoPanel var0 = new DemoPanel(new BorderLayout());
      var0.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      Chart3D var1 = SurfaceRenderer2.createChart();
      Chart3DPanel var2 = new Chart3DPanel(var1);
      var2.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      var0.setChartPanel(var2);
      var0.add(new DisplayPanel3D(var2));
      return var0;
   }

   public static void main(String[] var0) {
      SurfaceRendererDemo2 var1 = new SurfaceRendererDemo2("OrsonCharts: SurfaceRendererDemo2.java");
      var1.pack();
      var1.setVisible(true);
   }
}
