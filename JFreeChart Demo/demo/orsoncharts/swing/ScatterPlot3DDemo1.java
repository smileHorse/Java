package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import demo.orsoncharts.ScatterPlot3D1;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScatterPlot3DDemo1 extends JFrame {

   public ScatterPlot3DDemo1(String var1) {
      super(var1);
      this.addWindowListener(new ExitOnClose());
      this.getContentPane().add(createDemoPanel());
   }

   public static JPanel createDemoPanel() {
      DemoPanel var0 = new DemoPanel(new BorderLayout());
      var0.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      XYZDataset var1 = ScatterPlot3D1.createDataset();
      Chart3D var2 = ScatterPlot3D1.createChart(var1);
      Chart3DPanel var3 = new Chart3DPanel(var2);
      var0.setChartPanel(var3);
      var3.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      var0.add(new DisplayPanel3D(var3));
      return var0;
   }

   public static void main(String[] var0) {
      ScatterPlot3DDemo1 var1 = new ScatterPlot3DDemo1("OrsonCharts : ScatterPlot3DDemo1.java");
      var1.pack();
      var1.setVisible(true);
   }
}
