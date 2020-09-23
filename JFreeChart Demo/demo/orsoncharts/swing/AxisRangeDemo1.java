package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.label.StandardCategoryItemLabelGenerator;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.renderer.category.AreaRenderer3D;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AxisRangeDemo1 extends JFrame {

   public AxisRangeDemo1(String var1) {
      super(var1);
      this.addWindowListener(new ExitOnClose());
      this.getContentPane().add(createDemoPanel());
   }

   public static JPanel createDemoPanel() {
      AxisRangeDemo1.CustomDemoPanel var0 = new AxisRangeDemo1.CustomDemoPanel(new BorderLayout());
      var0.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      CategoryDataset3D var1 = createDataset();
      Chart3D var2 = Chart3DFactory.createAreaChart("AxisRangeDemo1", "A test for rendering with a restricted value range", var1, "Row", "Category", "Value");
      var2.setChartBoxColor(new Color(255, 255, 255, 128));
      var2.setViewPoint(ViewPoint3D.createAboveLeftViewPoint(40.0D));
      CategoryPlot3D var3 = (CategoryPlot3D)var2.getPlot();
      var3.getValueAxis().setRange(-500.0D, 500.0D);
      var3.getRowAxis().setVisible(false);
      AreaRenderer3D var4 = (AreaRenderer3D)var3.getRenderer();
      var4.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("%4$.2f"));
      Chart3DPanel var5 = new Chart3DPanel(var2);
      var0.setChartPanel(var5);
      var0.add(new DisplayPanel3D(var5));
      var5.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      return var0;
   }

   private static CategoryDataset3D createDataset() {
      StandardCategoryDataset3D var0 = new StandardCategoryDataset3D();
      DefaultKeyedValues var1 = new DefaultKeyedValues();
      var1.put("A", Integer.valueOf(-500));
      var1.put("B", Integer.valueOf(-200));
      var1.put("C", Integer.valueOf(-400));
      var1.put("D", Integer.valueOf(-150));
      var0.addSeriesAsRow("All Negative", var1);
      DefaultKeyedValues var2 = new DefaultKeyedValues();
      var2.put("A", Integer.valueOf(-500));
      var2.put("B", Integer.valueOf(500));
      var2.put("C", Integer.valueOf(0));
      var2.put("D", Integer.valueOf(-150));
      var0.addSeriesAsRow("Alternating 1", var2);
      DefaultKeyedValues var3 = new DefaultKeyedValues();
      var3.put("A", Integer.valueOf(500));
      var3.put("B", Integer.valueOf(-500));
      var3.put("C", Integer.valueOf(0));
      var3.put("D", Integer.valueOf(150));
      var0.addSeriesAsRow("Alternating 2", var3);
      DefaultKeyedValues var4 = new DefaultKeyedValues();
      var4.put("A", Integer.valueOf(500));
      var4.put("B", Integer.valueOf(200));
      var4.put("C", Integer.valueOf(400));
      var4.put("D", Integer.valueOf(150));
      var0.addSeriesAsRow("All Positive", var4);
      return var0;
   }

   public static void main(String[] var0) {
      AxisRangeDemo1 var1 = new AxisRangeDemo1("OrsonCharts: AreaChart3DDemo3.java");
      var1.pack();
      var1.setVisible(true);
   }

   static class CustomDemoPanel extends DemoPanel implements ChangeListener {

      private JSlider slider1 = new JSlider(-1000, 0);
      private JSlider slider2;


      public CustomDemoPanel(LayoutManager var1) {
         super(var1);
         this.slider1.setValue(-500);
         this.slider2 = new JSlider(0, 1000);
         this.slider2.setValue(500);
         this.slider1.addChangeListener(this);
         this.slider2.addChangeListener(this);
         JPanel var2 = new JPanel(new FlowLayout());
         var2.add(new JLabel("Value axis lower bound: "));
         var2.add(this.slider1);
         var2.add(new JLabel("Upper bound: "));
         var2.add(this.slider2);
         this.add(var2, "South");
      }

      public void stateChanged(ChangeEvent var1) {
         Chart3D var2 = (Chart3D)this.getChartPanel().getDrawable();
         CategoryPlot3D var3 = (CategoryPlot3D)var2.getPlot();
         ValueAxis3D var4 = var3.getValueAxis();
         int var5 = this.slider1.getValue();
         int var6 = this.slider2.getValue();
         if(var5 != var6) {
            var4.setRange((double)var5, (double)var6);
         }

      }
   }
}
