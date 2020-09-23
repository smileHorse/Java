package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.ViewPoint3D;

public class XYZBarChart3D1 {

   public static Chart3D createChart(XYZDataset var0) {
      Chart3D var1 = Chart3DFactory.createXYZBarChart("XYZBarChart3DDemo1", "Chart created with Orson Charts", var0, "X", "Value", "Z");
      var1.setViewPoint(ViewPoint3D.createAboveRightViewPoint(40.0D));
      return var1;
   }

   public static XYZDataset createDataset() {
      XYZSeries var0 = new XYZSeries("Series 1");
      var0.add(1.0D, 5.0D, 1.0D);
      XYZSeries var1 = new XYZSeries("Series 2");
      var1.add(2.0D, 8.0D, 2.0D);
      XYZSeries var2 = new XYZSeries("Series 3");
      var2.add(1.0D, 10.0D, 2.0D);
      XYZSeriesCollection var3 = new XYZSeriesCollection();
      var3.add(var0);
      var3.add(var1);
      var3.add(var2);
      return var3;
   }
}
