package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import demo.orsoncharts.ScatterPlot3D3;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScatterPlot3DDemo3 extends JFrame {

   public ScatterPlot3DDemo3(String var1) {
      super(var1);
      this.addWindowListener(new ExitOnClose());
      this.getContentPane().add(createDemoPanel());
   }

   public static JPanel createDemoPanel() {
      DemoPanel var0 = new DemoPanel(new GridLayout(2, 2));
      XYZDataset[] var1 = ScatterPlot3D3.createDatasets();
      Chart3D var2 = ScatterPlot3D3.createChart("Iris Dataset : Combination 1", var1[0], "Sepal Length", "Sepal Width", "Petal Length");
      Chart3DPanel var3 = new Chart3DPanel(var2);
      var3.setPreferredSize(new Dimension(10, 10));
      var3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 0)), BorderFactory.createLineBorder(Color.DARK_GRAY)));
      var3.setMargin(0.35D);
      Chart3D var4 = ScatterPlot3D3.createChart("Iris Dataset : Combination 2", var1[1], "Sepal Length", "Sepal Width", "Petal Width");
      Chart3DPanel var5 = new Chart3DPanel(var4);
      var5.setPreferredSize(new Dimension(10, 10));
      var5.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 0)), BorderFactory.createLineBorder(Color.DARK_GRAY)));
      var5.setMargin(0.35D);
      Chart3D var6 = ScatterPlot3D3.createChart("Iris Dataset : Combination 3", var1[2], "Sepal Length", "Petal Width", "Petal Length");
      Chart3DPanel var7 = new Chart3DPanel(var6);
      var7.setPreferredSize(new Dimension(10, 10));
      var7.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 0)), BorderFactory.createLineBorder(Color.DARK_GRAY)));
      var7.setMargin(0.35D);
      Chart3D var8 = ScatterPlot3D3.createChart("Iris Dataset : Combination 4", var1[3], "Sepal Width", "Petal Width", "Petal Length");
      Chart3DPanel var9 = new Chart3DPanel(var8);
      var9.setPreferredSize(new Dimension(10, 10));
      var9.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 0)), BorderFactory.createLineBorder(Color.DARK_GRAY)));
      var9.setMargin(0.35D);
      var0.add(new DisplayPanel3D(var3, false, true));
      var0.addChartPanel(var3);
      var0.add(new DisplayPanel3D(var5, false, true));
      var0.addChartPanel(var5);
      var0.add(new DisplayPanel3D(var7, false, true));
      var0.addChartPanel(var7);
      var0.add(new DisplayPanel3D(var9, false, true));
      var0.addChartPanel(var9);
      var0.setPreferredSize(new Dimension(400, 400));
      return var0;
   }

   public static void main(String[] var0) {
      ScatterPlot3DDemo3 var1 = new ScatterPlot3DDemo3("OrsonCharts : ScatterPlot3DDemo3.java");
      var1.pack();
      var1.setVisible(true);
   }
}
