package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.renderer.category.AreaRenderer3D;
import java.awt.Color;

public class AreaChart3D2 {

   public static Chart3D createChart(CategoryDataset3D var0) {
      Chart3D var1 = Chart3DFactory.createAreaChart("AreaChart3DDemo2", "Chart created with Orson Charts", var0, "Row", "Category", "Value");
      var1.setChartBoxColor(new Color(255, 255, 255, 128));
      var1.setViewPoint(ViewPoint3D.createAboveLeftViewPoint(40.0D));
      CategoryPlot3D var2 = (CategoryPlot3D)var1.getPlot();
      var2.getRowAxis().setVisible(false);
      AreaRenderer3D var3 = (AreaRenderer3D)var2.getRenderer();
      var3.setBaseColor(Color.GRAY);
      var3.setColors(Colors.getSAPMultiColor());
      return var1;
   }

   public static CategoryDataset3D createDataset() {
      StandardCategoryDataset3D var0 = new StandardCategoryDataset3D();
      DefaultKeyedValues var1 = new DefaultKeyedValues();
      var1.put("A", Integer.valueOf(-1));
      var1.put("B", Integer.valueOf(-4));
      var1.put("C", Integer.valueOf(-9));
      var1.put("D", Integer.valueOf(-5));
      var1.put("E", Integer.valueOf(-5));
      var1.put("F", Integer.valueOf(-2));
      var1.put("G", Integer.valueOf(-4));
      var1.put("H", Integer.valueOf(-7));
      var1.put("I", Integer.valueOf(-3));
      var1.put("J", Integer.valueOf(-1));
      var0.addSeriesAsRow("Series 1", var1);
      DefaultKeyedValues var2 = new DefaultKeyedValues();
      var2.put("A", Integer.valueOf(1));
      var2.put("B", Integer.valueOf(12));
      var2.put("C", Integer.valueOf(14));
      var2.put("D", Integer.valueOf(7));
      var2.put("E", Integer.valueOf(2));
      var2.put("F", Integer.valueOf(-9));
      var2.put("G", Integer.valueOf(-14));
      var2.put("H", Integer.valueOf(0));
      var2.put("I", Integer.valueOf(12));
      var2.put("J", Integer.valueOf(4));
      var0.addSeriesAsRow("Series 2", var2);
      DefaultKeyedValues var3 = new DefaultKeyedValues();
      var3.put("A", Integer.valueOf(5));
      var3.put("B", Integer.valueOf(13));
      var3.put("C", Integer.valueOf(19));
      var3.put("D", Integer.valueOf(11));
      var3.put("E", Integer.valueOf(10));
      var3.put("F", Integer.valueOf(5));
      var3.put("G", Integer.valueOf(-7));
      var3.put("H", Integer.valueOf(-3));
      var3.put("I", Integer.valueOf(-15));
      var3.put("J", Integer.valueOf(-20));
      var0.addSeriesAsRow("Series 3", var3);
      DefaultKeyedValues var4 = new DefaultKeyedValues();
      var4.put("A", Integer.valueOf(5));
      var4.put("B", Integer.valueOf(18));
      var4.put("C", Integer.valueOf(20));
      var4.put("D", Integer.valueOf(17));
      var4.put("E", Integer.valueOf(11));
      var4.put("F", Integer.valueOf(19));
      var4.put("G", Integer.valueOf(25));
      var4.put("H", Integer.valueOf(12));
      var4.put("I", Integer.valueOf(4));
      var4.put("J", Integer.valueOf(2));
      var0.addSeriesAsRow("Series 4", var4);
      return var0;
   }
}
