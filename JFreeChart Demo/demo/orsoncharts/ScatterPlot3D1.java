package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.label.StandardXYZLabelGenerator;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;

public class ScatterPlot3D1 {

   public static Chart3D createChart(XYZDataset var0) {
      Chart3D var1 = Chart3DFactory.createScatterChart("ScatterPlot3DDemo1", "Chart created with Orson Charts", var0, "X", "Y", "Z");
      XYZPlot var2 = (XYZPlot)var1.getPlot();
      var2.setDimensions(new Dimension3D(10.0D, 4.0D, 4.0D));
      var2.setLegendLabelGenerator(new StandardXYZLabelGenerator("%s (%2$,d)"));
      ScatterXYZRenderer var3 = (ScatterXYZRenderer)var2.getRenderer();
      var3.setSize(0.15D);
      var3.setColors(Colors.createIntenseColors());
      var1.setViewPoint(ViewPoint3D.createAboveLeftViewPoint(40.0D));
      return var1;
   }

   public static XYZDataset createDataset() {
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
         var2.add(Math.random() * 100.0D, Math.random() / 100.0D, Math.random() * 100.0D);
      }

      return var2;
   }
}
