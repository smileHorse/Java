package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.TitleAnchor;
import com.orsoncharts.data.PieDataset3D;
import com.orsoncharts.data.StandardPieDataset3D;
import com.orsoncharts.legend.LegendAnchor;
import com.orsoncharts.util.Orientation;

public class PieChart3D1 {

   public static Chart3D createChart(PieDataset3D var0) {
      Chart3D var1 = Chart3DFactory.createPieChart("New Zealand Exports 2012", "http://www.stats.govt.nz/browse_for_stats/snapshots-of-nz/nz-in-profile-2013.aspx", createDataset());
      var1.setTitleAnchor(TitleAnchor.TOP_LEFT);
      var1.setLegendPosition(LegendAnchor.BOTTOM_CENTER, Orientation.HORIZONTAL);
      return var1;
   }

   public static PieDataset3D createDataset() {
      StandardPieDataset3D var0 = new StandardPieDataset3D();
      var0.add("Milk Products", 11625.0D);
      var0.add("Meat", 5114.0D);
      var0.add("Wood/Logs", 3060.0D);
      var0.add("Crude Oil", 2023.0D);
      var0.add("Machinery", 1865.0D);
      var0.add("Fruit", 1587.0D);
      var0.add("Fish", 1367.0D);
      var0.add("Wine", 1177.0D);
      var0.add("Other", 18870.0D);
      return var0;
   }
}
