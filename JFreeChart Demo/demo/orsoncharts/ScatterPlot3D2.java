package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.axis.LabelOrientation;
import com.orsoncharts.axis.LogAxis3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import com.orsoncharts.style.ChartStyler;
import java.awt.Color;

public class ScatterPlot3D2 {

   public static Chart3D createChart(XYZDataset var0) {
      Chart3D var1 = Chart3DFactory.createScatterChart("ScatterPlot3DDemo2", (String)null, var0, "X", "Y", "Z");
      XYZPlot var2 = (XYZPlot)var1.getPlot();
      ScatterXYZRenderer var3 = (ScatterXYZRenderer)var2.getRenderer();
      var2.setDimensions(new Dimension3D(10.0D, 6.0D, 10.0D));
      var3.setSize(0.1D);
      var3.setColors(new Color[]{new Color(255, 128, 128), new Color(128, 255, 128)});
      LogAxis3D var4 = new LogAxis3D("Y (log scale)");
      var4.setTickLabelOrientation(LabelOrientation.PERPENDICULAR);
      var4.receive(new ChartStyler(var1.getStyle()));
      var2.setYAxis(var4);
      var1.setViewPoint(ViewPoint3D.createAboveLeftViewPoint(40.0D));
      return var1;
   }

   public static XYZDataset createDataset() {
      XYZSeries var0 = new XYZSeries("S1");

      for(int var1 = 0; var1 < 1000; ++var1) {
         var0.add(Math.random() * 100.0D, Math.pow(10.0D, Math.random() * 5.0D), Math.random() * 100.0D);
      }

      XYZSeries var3 = new XYZSeries("S2");

      for(int var2 = 0; var2 < 1000; ++var2) {
         var3.add(Math.random() * 100.0D, Math.random() * 100000.0D, Math.random() * 100.0D);
      }

      XYZSeriesCollection var4 = new XYZSeriesCollection();
      var4.add(var0);
      var4.add(var3);
      return var4;
   }
}
