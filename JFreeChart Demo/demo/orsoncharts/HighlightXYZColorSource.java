package demo.orsoncharts;

import com.orsoncharts.Range;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.renderer.xyz.StandardXYZColorSource;
import java.awt.Color;

public class HighlightXYZColorSource extends StandardXYZColorSource {

   private XYZDataset dataset;
   private Range xRange;
   private Range yRange;
   private Range zRange;
   private Color highlightColor;


   public HighlightXYZColorSource(XYZDataset var1, Color var2, Range var3, Range var4, Range var5, Color ... var6) {
      super(var6);
      this.dataset = var1;
      this.xRange = var3;
      this.yRange = var4;
      this.zRange = var5;
      this.highlightColor = var2;
   }

   public Color getColor(int var1, int var2) {
      double var3 = this.dataset.getX(var1, var2);
      double var5 = this.dataset.getY(var1, var2);
      double var7 = this.dataset.getZ(var1, var2);
      return this.xRange.contains(var3) && this.yRange.contains(var5) && this.zRange.contains(var7)?this.highlightColor:super.getColor(var1, var2);
   }
}
