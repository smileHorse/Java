package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;

public class StackedBarChart3D1 {

   public static Chart3D createChart(CategoryDataset3D var0) {
      Chart3D var1 = Chart3DFactory.createStackedBarChart("Stacked Bar Chart", "Put the data source here", var0, (String)null, (String)null, "Value");
      return var1;
   }

   public static CategoryDataset3D createDataset() {
      StandardCategoryDataset3D var0 = new StandardCategoryDataset3D();
      DefaultKeyedValues var1 = new DefaultKeyedValues();
      var1.put("A", Double.valueOf(4.0D));
      var1.put("B", Double.valueOf(2.0D));
      var1.put("C", Double.valueOf(3.0D));
      var1.put("D", Double.valueOf(5.0D));
      var1.put("E", Double.valueOf(2.0D));
      var1.put("F", Double.valueOf(1.0D));
      DefaultKeyedValues var2 = new DefaultKeyedValues();
      var2.put("A", Double.valueOf(1.0D));
      var2.put("B", Double.valueOf(2.0D));
      var2.put("C", Double.valueOf(3.0D));
      var2.put("D", Double.valueOf(2.0D));
      var2.put("E", Double.valueOf(3.0D));
      var2.put("F", Double.valueOf(1.0D));
      DefaultKeyedValues var3 = new DefaultKeyedValues();
      var3.put("A", Double.valueOf(6.0D));
      var3.put("B", Double.valueOf(6.0D));
      var3.put("C", Double.valueOf(6.0D));
      var3.put("D", Double.valueOf(4.0D));
      var3.put("E", Double.valueOf(4.0D));
      var3.put("F", Double.valueOf(4.0D));
      DefaultKeyedValues var4 = new DefaultKeyedValues();
      var4.put("A", Double.valueOf(9.0D));
      var4.put("B", Double.valueOf(8.0D));
      var4.put("C", Double.valueOf(7.0D));
      var4.put("D", Double.valueOf(6.0D));
      var4.put("D", Double.valueOf(3.0D));
      var4.put("E", Double.valueOf(4.0D));
      var4.put("F", Double.valueOf(6.0D));
      DefaultKeyedValues var5 = new DefaultKeyedValues();
      var5.put("A", Double.valueOf(9.0D));
      var5.put("B", Double.valueOf(8.0D));
      var5.put("C", Double.valueOf(7.0D));
      var5.put("D", Double.valueOf(6.0D));
      var5.put("E", Double.valueOf(7.0D));
      var5.put("F", Double.valueOf(9.0D));
      var0.addSeriesAsRow("Series 1", "Row 1", var1);
      var0.addSeriesAsRow("Series 2", "Row 2", var2);
      var0.addSeriesAsRow("Series 3", "Row 2", var3);
      var0.addSeriesAsRow("Series 4", "Row 3", var4);
      var0.addSeriesAsRow("Series 5", "Row 3", var5);
      return var0;
   }
}
