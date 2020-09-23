package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.axis.NumberAxis3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.interaction.StandardXYZDataItemSelection;
import com.orsoncharts.label.StandardXYZItemLabelGenerator;
import com.orsoncharts.marker.RangeMarker;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import com.orsoncharts.style.ChartStyler;
import com.orsoncharts.style.ChartStyles;
import com.orsoncharts.util.Anchor2D;
import demo.orsoncharts.HighlightXYZColorSource;
import java.awt.Color;

public class RangeMarker1 {

   public static Chart3D createChart(XYZDataset var0) {
      Chart3D var1 = Chart3DFactory.createScatterChart("RangeMarkerDemo1", (String)null, var0, "X", "Y", "Z");
      var1.setStyle(ChartStyles.createOrson1Style());
      XYZPlot var2 = (XYZPlot)var1.getPlot();
      var2.setDimensions(new Dimension3D(10.0D, 6.0D, 10.0D));
      ChartStyler var3 = new ChartStyler(var1.getStyle());
      NumberAxis3D var4 = (NumberAxis3D)var2.getXAxis();
      RangeMarker var5 = new RangeMarker(60.0D, 90.0D, "X: 60 to 90");
      var5.receive(var3);
      var5.setFillColor(new Color(128, 128, 255, 128));
      var5.setLabelAnchor(Anchor2D.BOTTOM_LEFT);
      var4.setMarker("X1", var5);
      NumberAxis3D var6 = (NumberAxis3D)var2.getYAxis();
      RangeMarker var7 = new RangeMarker(0.002D, 0.006D, "Y: 0.002 to 0.006");
      var7.receive(var3);
      var7.setFillColor(new Color(128, 255, 128, 128));
      var6.setMarker("Y1", var7);
      NumberAxis3D var8 = (NumberAxis3D)var2.getZAxis();
      RangeMarker var9 = new RangeMarker(20.0D, 60.0D, "Z: 20 to 60");
      var9.setLabelAnchor(Anchor2D.TOP_LEFT);
      var9.receive(var3);
      var9.setFillColor(new Color(255, 128, 128, 128));
      var8.setMarker("Z1", var9);
      ScatterXYZRenderer var10 = (ScatterXYZRenderer)var2.getRenderer();
      var10.setSize(0.15D);
      HighlightXYZColorSource var11 = new HighlightXYZColorSource(var2.getDataset(), Color.RED, var5.getRange(), var7.getRange(), var9.getRange(), var1.getStyle().getStandardColors());
      var10.setColorSource(var11);
      StandardXYZItemLabelGenerator var12 = new StandardXYZItemLabelGenerator();
      StandardXYZDataItemSelection var13 = new StandardXYZDataItemSelection();
      var12.setItemSelection(var13);
      var10.setItemLabelGenerator(var12);
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
