package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZItemKeys;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.interaction.StandardXYZDataItemSelection;
import com.orsoncharts.label.StandardXYZItemLabelGenerator;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
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

public class AxisRangeDemo5 extends JFrame {

   public AxisRangeDemo5(String var1) {
      super(var1);
      this.addWindowListener(new ExitOnClose());
      this.getContentPane().add(createDemoPanel());
   }

   public static JPanel createDemoPanel() {
      AxisRangeDemo5.CustomDemoPanel var0 = new AxisRangeDemo5.CustomDemoPanel(new BorderLayout());
      var0.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      XYZDataset var1 = createDataset();
      Chart3D var2 = Chart3DFactory.createScatterChart("AxisRangeDemo5", "Chart created with Orson Charts", var1, "X", "Y", "Z");
      XYZPlot var3 = (XYZPlot)var2.getPlot();
      var3.setDimensions(new Dimension3D(10.0D, 4.0D, 10.0D));
      ScatterXYZRenderer var4 = (ScatterXYZRenderer)var3.getRenderer();
      var4.setSize(0.1D);
      StandardXYZItemLabelGenerator var5 = new StandardXYZItemLabelGenerator();
      StandardXYZDataItemSelection var6 = new StandardXYZDataItemSelection();
      var5.setItemSelection(var6);
      var6.addAll(XYZItemKeys.itemKeysForSeries(var1, "S1"));
      var4.setItemLabelGenerator(var5);
      var2.setViewPoint(ViewPoint3D.createAboveLeftViewPoint(40.0D));
      Chart3DPanel var7 = new Chart3DPanel(var2);
      var0.setChartPanel(var7);
      var7.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      var0.add(new DisplayPanel3D(var7));
      return var0;
   }

   private static XYZDataset createDataset() {
      XYZSeries var0 = createRandomSeries("S1", 10);
      XYZSeries var1 = createRandomSeries("S2", 50);
      XYZSeries var2 = createRandomSeries("S3", 150);
      XYZSeriesCollection var3 = new XYZSeriesCollection();
      var3.add(var0);
      var3.add(var1);
      var3.add(var2);
      return var3;
   }

   private static XYZSeries createRandomSeries(String var0, int var1) {
      XYZSeries var2 = new XYZSeries(var0);

      for(int var3 = 0; var3 < var1; ++var3) {
         var2.add(Math.random() * 100.0D, Math.random() * 10.0D, Math.random() * 100.0D);
      }

      return var2;
   }

   public static void main(String[] var0) {
      AxisRangeDemo5 var1 = new AxisRangeDemo5("OrsonCharts : AxisRangeDemo5.java");
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
         double var5 = (double)this.xslider1.getValue();
         double var7 = (double)this.xslider2.getValue();
         if(var5 != var7) {
            var4.setRange(var5, var7);
         }

         ValueAxis3D var9 = var3.getYAxis();
         double var10 = (double)this.yslider1.getValue() / 10.0D;
         double var12 = (double)this.yslider2.getValue() / 10.0D;
         if(var10 != var12) {
            var9.setRange(var10, var12);
         }

         ValueAxis3D var14 = var3.getZAxis();
         double var15 = (double)this.zslider1.getValue();
         double var17 = (double)this.zslider2.getValue();
         if(var15 != var17) {
            var14.setRange(var15, var17);
         }

      }
   }
}
