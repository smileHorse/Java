package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.legend.LegendAnchor;
import java.awt.Color;

public class LineChart3D2 {

   public static Chart3D createChart(CategoryDataset3D var0) {
      Chart3D var1 = Chart3DFactory.createLineChart("Quarterly Profits", "Large Banks in USA", var0, (String)null, "Quarter", "$ millions");
      var1.setChartBoxColor(new Color(255, 255, 255, 128));
      var1.setLegendAnchor(LegendAnchor.TOP_RIGHT);
      return var1;
   }

   public static CategoryDataset3D createDataset() {
      StandardCategoryDataset3D var0 = new StandardCategoryDataset3D();
      DefaultKeyedValues var1 = new DefaultKeyedValues();
      var1.put("Q3/11", Integer.valueOf(5889));
      var1.put("Q4/11", Integer.valueOf(1584));
      var1.put("Q1/12", Integer.valueOf(328));
      var1.put("Q2/12", Integer.valueOf(2098));
      var1.put("Q3/12", Integer.valueOf(-33));
      var1.put("Q4/12", Integer.valueOf(367));
      var1.put("Q1/13", Integer.valueOf(1110));
      var1.put("Q2/13", Integer.valueOf(3571));
      var1.put("Q3/13", Integer.valueOf(2218));
      var0.addSeriesAsRow("Bank of America", var1);
      DefaultKeyedValues var2 = new DefaultKeyedValues();
      var2.put("Q3/11", Integer.valueOf(3771));
      var2.put("Q4/11", Integer.valueOf(956));
      var2.put("Q1/12", Integer.valueOf(2931));
      var2.put("Q2/12", Integer.valueOf(2946));
      var2.put("Q3/12", Integer.valueOf(468));
      var2.put("Q4/12", Integer.valueOf(1196));
      var2.put("Q1/13", Integer.valueOf(3808));
      var2.put("Q2/13", Integer.valueOf(4182));
      var2.put("Q3/13", Integer.valueOf(3227));
      var0.addSeriesAsRow("Citigroup", var2);
      DefaultKeyedValues var3 = new DefaultKeyedValues();
      var3.put("Q3/11", Integer.valueOf(4055));
      var3.put("Q4/11", Integer.valueOf(4107));
      var3.put("Q1/12", Integer.valueOf(4248));
      var3.put("Q2/12", Integer.valueOf(4622));
      var3.put("Q3/12", Integer.valueOf(4937));
      var3.put("Q4/12", Integer.valueOf(4857));
      var3.put("Q1/13", Integer.valueOf(4931));
      var3.put("Q2/13", Integer.valueOf(5272));
      var3.put("Q3/13", Integer.valueOf(5317));
      var0.addSeriesAsRow("Wells Fargo", var3);
      DefaultKeyedValues var4 = new DefaultKeyedValues();
      var4.put("Q3/11", Integer.valueOf(4262));
      var4.put("Q4/11", Integer.valueOf(3728));
      var4.put("Q1/12", Integer.valueOf(4924));
      var4.put("Q2/12", Integer.valueOf(4960));
      var4.put("Q3/12", Integer.valueOf(5708));
      var4.put("Q4/12", Integer.valueOf(5692));
      var4.put("Q1/13", Integer.valueOf(6529));
      var4.put("Q2/13", Integer.valueOf(6496));
      var4.put("Q3/13", Integer.valueOf(-380));
      var0.addSeriesAsRow("J.P.Morgan", var4);
      return var0;
   }
}
