package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.renderer.category.StackedBarRenderer3D;

public class StackedBarChart3D2 {

   public static Chart3D createChart(CategoryDataset3D var0) {
      Chart3D var1 = Chart3DFactory.createStackedBarChart("Water Usage Chart", "Source: http://en.wikipedia.org/wiki/Peak_water#Water_supply", var0, (String)null, (String)null, "Cubic meters / person / year");
      CategoryPlot3D var2 = (CategoryPlot3D)var1.getPlot();
      var2.setDimensions(new Dimension3D(14.0D, 6.5D, 2.0D));
      var2.getRowAxis().setVisible(false);
      StackedBarRenderer3D var3 = (StackedBarRenderer3D)var2.getRenderer();
      var3.setBarZWidth(0.3D);
      var3.setColors(Colors.createBlueOceanColors());
      var1.getViewPoint().moveUpDown(0.10471975511965977D);
      return var1;
   }

   public static CategoryDataset3D createDataset() {
      StandardCategoryDataset3D var0 = new StandardCategoryDataset3D();
      var0.addValue(Integer.valueOf(197), "Agricultural", "R1", "Brazil");
      var0.addValue(Integer.valueOf(64), "Domestic", "R1", "Brazil");
      var0.addValue(Integer.valueOf(57), "Industrial", "R1", "Brazil");
      var0.addValue(Integer.valueOf(339), "Agricultural", "R1", "Indonesia");
      var0.addValue(Integer.valueOf(30), "Domestic", "R1", "Indonesia");
      var0.addValue(Integer.valueOf(4), "Industrial", "R1", "Indonesia");
      var0.addValue(Integer.valueOf(279), "Agricultural", "R1", "China");
      var0.addValue(Integer.valueOf(27), "Domestic", "R1", "China");
      var0.addValue(Integer.valueOf(107), "Industrial", "R1", "China");
      var0.addValue(Integer.valueOf(92), "Agricultural", "R1", "Germany");
      var0.addValue(Integer.valueOf(55), "Domestic", "R1", "Germany");
      var0.addValue(Integer.valueOf(313), "Industrial", "R1", "Germany");
      var0.addValue(Integer.valueOf(96), "Agricultural", "R1", "Russia");
      var0.addValue(Integer.valueOf(102), "Domestic", "R1", "Russia");
      var0.addValue(Integer.valueOf(337), "Industrial", "R1", "Russia");
      var0.addValue(Integer.valueOf(403), "Agricultural", "R1", "Turkey");
      var0.addValue(Integer.valueOf(82), "Domestic", "R1", "Turkey");
      var0.addValue(Integer.valueOf(60), "Industrial", "R1", "Turkey");
      var0.addValue(Integer.valueOf(536), "Agricultural", "R1", "Bangladesh");
      var0.addValue(Integer.valueOf(17), "Domestic", "R1", "Bangladesh");
      var0.addValue(Integer.valueOf(6), "Industrial", "R1", "Bangladesh");
      var0.addValue(Integer.valueOf(508), "Agricultural", "R1", "India");
      var0.addValue(Integer.valueOf(47), "Domestic", "R1", "India");
      var0.addValue(Integer.valueOf(30), "Industrial", "R1", "India");
      var0.addValue(Integer.valueOf(428), "Agricultural", "R1", "Japan");
      var0.addValue(Integer.valueOf(138), "Domestic", "R1", "Japan");
      var0.addValue(Integer.valueOf(124), "Industrial", "R1", "Japan");
      var0.addValue(Integer.valueOf(325), "Agricultural", "R1", "Italy");
      var0.addValue(Integer.valueOf(130), "Domestic", "R1", "Italy");
      var0.addValue(Integer.valueOf(268), "Industrial", "R1", "Italy");
      var0.addValue(Integer.valueOf(569), "Agricultural", "R1", "Mexico");
      var0.addValue(Integer.valueOf(126), "Domestic", "R1", "Mexico");
      var0.addValue(Integer.valueOf(37), "Industrial", "R1", "Mexico");
      var0.addValue(Integer.valueOf(576), "Agricultural", "R1", "Vietnam");
      var0.addValue(Integer.valueOf(68), "Domestic", "R1", "Vietnam");
      var0.addValue(Integer.valueOf(203), "Industrial", "R1", "Vietnam");
      var0.addValue(Integer.valueOf(794), "Agricultural", "R1", "Egypt");
      var0.addValue(Integer.valueOf(74), "Domestic", "R1", "Egypt");
      var0.addValue(Integer.valueOf(55), "Industrial", "R1", "Egypt");
      var0.addValue(Integer.valueOf(954), "Agricultural", "R1", "Iran");
      var0.addValue(Integer.valueOf(21), "Domestic", "R1", "Iran");
      var0.addValue(Integer.valueOf(73), "Industrial", "R1", "Iran");
      var0.addValue(Integer.valueOf(1029), "Agricultural", "R1", "Pakistan");
      var0.addValue(Integer.valueOf(21), "Domestic", "R1", "Pakistan");
      var0.addValue(Integer.valueOf(21), "Industrial", "R1", "Pakistan");
      var0.addValue(Integer.valueOf(1236), "Agricultural", "R1", "Thailand");
      var0.addValue(Integer.valueOf(26), "Domestic", "R1", "Thailand");
      var0.addValue(Integer.valueOf(26), "Industrial", "R1", "Thailand");
      var0.addValue(Integer.valueOf(165), "Agricultural", "R1", "Canada");
      var0.addValue(Integer.valueOf(274), "Domestic", "R1", "Canada");
      var0.addValue(Integer.valueOf(947), "Industrial", "R1", "Canada");
      var0.addValue(Integer.valueOf(1363), "Agricultural", "R1", "Iraq");
      var0.addValue(Integer.valueOf(44), "Domestic", "R1", "Iraq");
      var0.addValue(Integer.valueOf(74), "Industrial", "R1", "Iraq");
      var0.addValue(Integer.valueOf(656), "Agricultural", "R1", "US");
      var0.addValue(Integer.valueOf(208), "Domestic", "R1", "US");
      var0.addValue(Integer.valueOf(736), "Industrial", "R1", "US");
      var0.addValue(Integer.valueOf(2040), "Agricultural", "R1", "Uzbekistan");
      var0.addValue(Integer.valueOf(110), "Domestic", "R1", "Uzbekistan");
      var0.addValue(Integer.valueOf(44), "Industrial", "R1", "Uzbekistan");
      return var0;
   }
}
