package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.legend.LegendAnchor;
import com.orsoncharts.plot.CategoryPlot3D;
import java.awt.Color;

public class BarChart3D1 {

   public static Chart3D createChart(CategoryDataset3D var0) {
      Chart3D var1 = Chart3DFactory.createBarChart("Quarterly Revenues", "For some large IT companies", var0, (String)null, "Quarter", "$billion Revenues");
      var1.setChartBoxColor(new Color(255, 255, 255, 127));
      var1.setLegendAnchor(LegendAnchor.BOTTOM_RIGHT);
      CategoryPlot3D var2 = (CategoryPlot3D)var1.getPlot();
      var2.setGridlinePaintForValues(Color.BLACK);
      return var1;
   }

   public static CategoryDataset3D createDataset() {
      StandardCategoryDataset3D var0 = new StandardCategoryDataset3D();
      DefaultKeyedValues var1 = new DefaultKeyedValues();
      var1.put("Q2/11", Double.valueOf(8.181D));
      var1.put("Q3/11", Double.valueOf(8.792D));
      var1.put("Q4/11", Double.valueOf(9.039D));
      var1.put("Q1/12", Double.valueOf(10.916D));
      var1.put("Q2/12", Double.valueOf(8.181D));
      var1.put("Q3/12", Double.valueOf(9.094D));
      var1.put("Q4/12", Double.valueOf(8.958D));
      var1.put("Q1/13", Double.valueOf(10.947D));
      var1.put("Q2/13", Double.valueOf(8.372D));
      var1.put("Q3/13", Double.valueOf(9.275D));
      var0.addSeriesAsRow("Oracle", var1);
      DefaultKeyedValues var2 = new DefaultKeyedValues();
      var2.put("Q2/11", Double.valueOf(9.03D));
      var2.put("Q3/11", Double.valueOf(9.72D));
      var2.put("Q4/11", Double.valueOf(10.58D));
      var2.put("Q1/12", Double.valueOf(10.65D));
      var2.put("Q2/12", Double.valueOf(12.214D));
      var2.put("Q3/12", Double.valueOf(14.101D));
      var2.put("Q4/12", Double.valueOf(14.419D));
      var2.put("Q1/13", Double.valueOf(13.969D));
      var2.put("Q2/13", Double.valueOf(14.105D));
      var2.put("Q3/13", Double.valueOf(14.893D));
      var2.put("Q4/13", Double.valueOf(16.858D));
      var0.addSeriesAsRow("Google", var2);
      DefaultKeyedValues var3 = new DefaultKeyedValues();
      var3.put("Q2/11", Double.valueOf(17.37D));
      var3.put("Q3/11", Double.valueOf(17.37D));
      var3.put("Q4/11", Double.valueOf(20.89D));
      var3.put("Q1/12", Double.valueOf(17.41D));
      var3.put("Q2/12", Double.valueOf(18.06D));
      var3.put("Q3/12", Double.valueOf(16.008D));
      var3.put("Q4/12", Double.valueOf(21.456D));
      var3.put("Q1/13", Double.valueOf(20.489D));
      var3.put("Q2/13", Double.valueOf(19.896D));
      var3.put("Q3/13", Double.valueOf(18.529D));
      var3.put("Q4/13", Double.valueOf(24.519D));
      var0.addSeriesAsRow("Microsoft", var3);
      DefaultKeyedValues var4 = new DefaultKeyedValues();
      var4.put("Q2/11", Double.valueOf(28.57D));
      var4.put("Q3/11", Double.valueOf(28.27D));
      var4.put("Q4/11", Double.valueOf(46.33D));
      var4.put("Q1/12", Double.valueOf(39.2D));
      var4.put("Q2/12", Double.valueOf(35.0D));
      var4.put("Q3/12", Double.valueOf(36.0D));
      var4.put("Q4/12", Double.valueOf(54.5D));
      var4.put("Q1/13", Double.valueOf(43.6D));
      var4.put("Q2/13", Double.valueOf(35.323D));
      var4.put("Q3/13", Double.valueOf(37.5D));
      var4.put("Q4/13", Double.valueOf(57.594D));
      var0.addSeriesAsRow("Apple", var4);
      return var0;
   }
}
