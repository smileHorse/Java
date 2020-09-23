package demo;

import org.jfree.data.xy.AbstractXYZDataset;
import org.jfree.data.xy.XYZDataset;

public class SampleXYZDataset extends AbstractXYZDataset implements XYZDataset {

   private double[] xVal = new double[]{2.1D, 2.375625D, 2.375625D, 2.232928726D, 2.232928726D, 1.860415253D, 1.840842668D, 1.905415253D, 2.336029412D, 3.8D};
   private double[] yVal = new double[]{14.168D, 11.156D, 10.089D, 8.884D, 8.719D, 8.466D, 5.489D, 4.107D, 4.101D, 25.0D};
   private double[] zVal = new double[]{2.45D, 2.791285714D, 2.791285714D, 2.2125D, 2.2125D, 2.22D, 2.1D, 2.22D, 1.64875D, 4.0D};


   public int getSeriesCount() {
      return 1;
   }

   public Comparable getSeriesKey(int var1) {
      return "Series 1";
   }

   public int getItemCount(int var1) {
      return this.xVal.length;
   }

   public Number getX(int var1, int var2) {
      return new Double(this.xVal[var2]);
   }

   public Number getY(int var1, int var2) {
      return new Double(this.yVal[var2]);
   }

   public Number getZ(int var1, int var2) {
      return new Double(this.zVal[var2]);
   }
}
