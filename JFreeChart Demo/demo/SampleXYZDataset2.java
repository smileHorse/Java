package demo;

import org.jfree.data.xy.AbstractXYZDataset;
import org.jfree.data.xy.XYZDataset;

public class SampleXYZDataset2 extends AbstractXYZDataset implements XYZDataset {

   private double[][] xVal = new double[][]{{1.0D, 2.0D, 3.0D}, {4.0D, 5.0D, 6.0D}};
   private double[][] yVal = new double[][]{{1.0D, 2.0D, 3.0D}, {4.0D, 5.0D, 6.0D}};
   private double[][] zVal = new double[][]{{1.1D, 2.2D, 3.3D}, {4.4D, 5.5D, 6.6D}};


   public int getSeriesCount() {
      return this.xVal.length;
   }

   public Comparable getSeriesKey(int var1) {
      return "Series " + var1;
   }

   public int getItemCount(int var1) {
      return this.xVal[0].length;
   }

   public Number getX(int var1, int var2) {
      return new Double(this.xVal[var1][var2]);
   }

   public Number getY(int var1, int var2) {
      return new Double(this.yVal[var1][var2]);
   }

   public Number getZ(int var1, int var2) {
      return new Double(this.zVal[var1][var2]);
   }
}
