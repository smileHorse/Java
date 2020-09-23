package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.function.Function3D;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.plot.XYZPlot;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AxisRangeDemo6 extends JFrame {

   public AxisRangeDemo6(String var1) {
      super(var1);
      this.addWindowListener(new ExitOnClose());
      this.getContentPane().add(createDemoPanel());
   }

   public static JPanel createDemoPanel() {
      AxisRangeDemo6.CustomDemoPanel var0 = new AxisRangeDemo6.CustomDemoPanel(new BorderLayout());
      var0.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      Function3D var1 = new Function3D() {
         public double getValue(double var1, double var3) {
            return Math.cos(var1) * Math.sin(var3);
         }
      };
      Chart3D var2 = Chart3DFactory.createSurfaceChart("AxisRangeDemo6", "Chart created with Orson Charts", var1, "X", "Y", "Z");
      XYZPlot var3 = (XYZPlot)var2.getPlot();
      var3.setDimensions(new Dimension3D(10.0D, 4.0D, 10.0D));
      var3.getXAxis().setRange(-5.0D, 5.0D);
      var3.getZAxis().setRange(-5.0D, 5.0D);
      var2.setViewPoint(ViewPoint3D.createAboveLeftViewPoint(40.0D));
      Chart3DPanel var4 = new Chart3DPanel(var2);
      var0.setChartPanel(var4);
      var4.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      var0.add(new DisplayPanel3D(var4));
      return var0;
   }

   public static void main(String[] var0) {
      AxisRangeDemo6 var1 = new AxisRangeDemo6("OrsonCharts : AxisRangeDemo6.java");
      var1.pack();
      var1.setVisible(true);
   }

   static class CustomDemoPanel extends DemoPanel implements ChangeListener {

      private JSlider xslider1 = new JSlider(0, 50);
      private JSlider xslider2;
      private JSlider yslider1;
      private JSlider yslider2;
      private JSlider zslider1;
      private JSlider zslider2;


      public CustomDemoPanel(LayoutManager var1) {
         super(var1);
         this.xslider1.setValue(0);
         this.xslider2 = new JSlider(50, 100);
         this.xslider2.setValue(100);
         this.xslider1.addChangeListener(this);
         this.xslider2.addChangeListener(this);
         this.yslider1 = new JSlider(0, 50);
         this.yslider1.setValue(0);
         this.yslider2 = new JSlider(50, 100);
         this.yslider2.setValue(100);
         this.yslider1.addChangeListener(this);
         this.yslider2.addChangeListener(this);
         this.zslider1 = new JSlider(0, 50);
         this.zslider1.setValue(0);
         this.zslider2 = new JSlider(50, 100);
         this.zslider2.setValue(100);
         this.zslider1.addChangeListener(this);
         this.zslider2.addChangeListener(this);
         JPanel var2 = new JPanel(new GridLayout(3, 1));
         JPanel var3 = new JPanel(new FlowLayout());
         var3.add(new JLabel("X axis: "));
         var3.add(new JLabel("Lower bound: "));
         var3.add(this.xslider1);
         var3.add(new JLabel("Upper bound: "));
         var3.add(this.xslider2);
         var2.add(var3);
         JPanel var4 = new JPanel(new FlowLayout());
         var4.add(new JLabel("Y axis: "));
         var4.add(new JLabel("Lower bound: "));
         var4.add(this.yslider1);
         var4.add(new JLabel("Upper bound: "));
         var4.add(this.yslider2);
         var2.add(var4);
         JPanel var5 = new JPanel(new FlowLayout());
         var5.add(new JLabel("Z axis: "));
         var5.add(new JLabel("Lower bound: "));
         var5.add(this.zslider1);
         var5.add(new JLabel("Upper bound: "));
         var5.add(this.zslider2);
         var2.add(var5);
         this.add(var2, "South");
      }

      public void stateChanged(ChangeEvent var1) {
         Chart3D var2 = (Chart3D)this.getChartPanel().getDrawable();
         XYZPlot var3 = (XYZPlot)var2.getPlot();
         ValueAxis3D var4 = var3.getXAxis();
         double var5 = (double)this.xslider1.getValue() / 10.0D - 5.0D;
         double var7 = (double)this.xslider2.getValue() / 10.0D - 5.0D;
         if(var5 != var7) {
            var4.setRange(var5, var7);
         }

         ValueAxis3D var9 = var3.getYAxis();
         double var10 = (double)this.yslider1.getValue() / 40.0D - 1.0D;
         double var12 = (double)this.yslider2.getValue() / 40.0D - 1.0D;
         if(var10 != var12) {
            var9.setRange(var10, var12);
         }

         ValueAxis3D var14 = var3.getZAxis();
         double var15 = (double)this.zslider1.getValue() / 10.0D - 5.0D;
         double var17 = (double)this.zslider2.getValue() / 10.0D - 5.0D;
         if(var15 != var17) {
            var14.setRange(var15, var17);
         }

      }
   }
}
