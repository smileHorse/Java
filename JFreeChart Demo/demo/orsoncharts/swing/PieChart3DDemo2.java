package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.PieDataset3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.plot.PiePlot3D;
import demo.orsoncharts.PieChart3D2;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PieChart3DDemo2 extends JFrame {

   public static JPanel createDemoPanel() {
      DemoPanel var0 = new DemoPanel(new BorderLayout());
      var0.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      PieDataset3D var1 = PieChart3D2.createDataset();
      final Chart3D var2 = PieChart3D2.createChart(var1);
      Chart3DPanel var3 = new Chart3DPanel(var2);
      var3.setMargin(0.15D);
      var0.setChartPanel(var3);
      var3.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      var0.add(new DisplayPanel3D(var3));
      JButton var4 = new JButton("Change the Data");
      var4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent var1) {
            PieDataset3D var2x = PieChart3D2.createDataset();
            PiePlot3D var3 = (PiePlot3D)var2.getPlot();
            var3.setDataset(var2x);
         }
      });
      var0.add(var4, "South");
      return var0;
   }

   public PieChart3DDemo2(String var1) {
      super(var1);
      this.addWindowListener(new ExitOnClose());
      this.getContentPane().add(createDemoPanel());
   }

   public static void main(String[] var0) {
      PieChart3DDemo2 var1 = new PieChart3DDemo2("OrsonCharts: PieChart3DDemo2.java");
      var1.pack();
      var1.setVisible(true);
   }
}
