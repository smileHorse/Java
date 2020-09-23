package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.data.DataUtils;
import com.orsoncharts.data.JSONUtils;
import com.orsoncharts.data.KeyedValues3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.legend.LegendAnchor;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import com.orsoncharts.style.StandardChartStyle;
import com.orsoncharts.table.TextElement;
import com.orsoncharts.util.Orientation;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScatterPlot3D3 {

   public static XYZDataset[] createDatasets() {
      XYZDataset[] var0 = new XYZDataset[]{createDataset("sepal length", "sepal width", "petal length"), createDataset("sepal length", "sepal width", "petal width"), createDataset("sepal length", "petal width", "petal length"), createDataset("sepal width", "petal width", "petal length")};
      return var0;
   }

   public static Chart3D createChart(String var0, XYZDataset var1, String var2, String var3, String var4) {
      Chart3D var5 = Chart3DFactory.createScatterChart((String)null, (String)null, var1, var2, var3, var4);
      TextElement var6 = new TextElement(var0);
      var6.setFont(StandardChartStyle.createDefaultFont(0, 16));
      var5.setTitle(var6);
      var5.setLegendAnchor(LegendAnchor.BOTTOM_LEFT);
      var5.setLegendOrientation(Orientation.VERTICAL);
      XYZPlot var7 = (XYZPlot)var5.getPlot();
      ScatterXYZRenderer var8 = (ScatterXYZRenderer)var7.getRenderer();
      var8.setSize(0.15D);
      var8.setColors(Colors.createIntenseColors());
      var5.setViewPoint(ViewPoint3D.createAboveLeftViewPoint(40.0D));
      return var5;
   }

   private static XYZDataset createDataset(Comparable<?> var0, Comparable<?> var1, Comparable<?> var2) {
      InputStreamReader var3 = new InputStreamReader(ScatterPlot3D3.class.getResourceAsStream("iris.txt"));

      KeyedValues3D var4;
      try {
         var4 = JSONUtils.readKeyedValues3D(var3);
      } catch (IOException var6) {
         throw new RuntimeException(var6);
      }

      return DataUtils.extractXYZDatasetFromColumns(var4, var0, var1, var2);
   }
}
