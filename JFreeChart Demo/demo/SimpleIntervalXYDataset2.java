package demo;

import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;

public class SimpleIntervalXYDataset2 extends AbstractIntervalXYDataset implements IntervalXYDataset {

   private Double[] yStart;
   private Double[] yEnd = new Double[3];
   private Double[] xValues = new Double[3];


   public SimpleIntervalXYDataset2(int var1) {
      this.xValues = new Double[var1];
      this.yStart = new Double[var1];
      this.yEnd = new Double[var1];
      double var2 = 100.0D;

      for(int var4 = 1; var4 <= var1; ++var4) {
         this.xValues[var4 - 1] = new Double((double)var4);
         var2 *= 1.0D + (Math.random() / 10.0D - 0.05D);
         this.yStart[var4 - 1] = new Double(var2);
         this.yEnd[var4 - 1] = new Double(this.yStart[var4 - 1].doubleValue() + Math.random() * 30.0D);
      }

   }

   public int getSeriesCount() {
      return 1;
   }

   public Comparable getSeriesKey(int var1) {
      return "Series 1";
   }

   public int getItemCount(int var1) {
      return this.xValues.length;
   }

   public Number getX(int var1, int var2) {
      return this.xValues[var2];
   }

   public Number getY(int var1, int var2) {
      return this.yEnd[var2];
   }

   public Number getStartX(int var1, int var2) {
      return this.xValues[var2];
   }

   public Number getEndX(int var1, int var2) {
      return this.xValues[var2];
   }

   public Number getStartY(int var1, int var2) {
      return this.yStart[var2];
   }

   public Number getEndY(int var1, int var2) {
      return this.yEnd[var2];
   }

   public void addChangeListener(DatasetChangeListener var1) {}

   public void removeChangeListener(DatasetChangeListener var1) {}
}
