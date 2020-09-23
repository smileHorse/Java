package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.PieDataset3D;
import com.orsoncharts.graphics3d.RenderedElement;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.interaction.Chart3DMouseEvent;
import com.orsoncharts.interaction.Chart3DMouseListener;
import demo.orsoncharts.PieChart3D1;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PieChart3DDemo1 extends JFrame {

   public PieChart3DDemo1(String var1) {
      super(var1);
      this.addWindowListener(new ExitOnClose());
      this.getContentPane().add(createDemoPanel());
   }

   public static JPanel createDemoPanel() {
      final DemoPanel var0 = new DemoPanel(new BorderLayout());
      var0.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      PieDataset3D var1 = PieChart3D1.createDataset();
      Chart3D var2 = PieChart3D1.createChart(var1);
      Chart3DPanel var3 = new Chart3DPanel(var2);
      var3.setMargin(0.05D);
      var3.addChartMouseListener(new Chart3DMouseListener() {
         public void chartMouseClicked(Chart3DMouseEvent var1) {
            RenderedElement var2 = var1.getElement();
            if(var2 != null) {
               JOptionPane.showMessageDialog(var0, Chart3D.renderedElementToString(var1.getElement()));
            }

         }
         public void chartMouseMoved(Chart3DMouseEvent var1) {}
      });
      var0.setChartPanel(var3);
      var0.add(new DisplayPanel3D(var3));
      var3.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      return var0;
   }

   public static void main(String[] var0) {
      PieChart3DDemo1 var1 = new PieChart3DDemo1("OrsonCharts: PieChart3DDemo1.java");
      var1.pack();
      var1.setVisible(true);
   }
}
