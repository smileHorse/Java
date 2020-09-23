package demo;

import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;

public class SampleXYDataset extends AbstractXYDataset implements XYDataset {

   private double translate = 0.0D;


   public double getTranslate() {
      return this.translate;
   }

   public void setTranslate(double var1) {
      this.translate = var1;
      this.notifyListeners(new DatasetChangeEvent(this, this));
   }

   public Number getX(int var1, int var2) {
      return new Double(-10.0D + this.translate + (double)var2 / 10.0D);
   }

   public Number getY(int var1, int var2) {
      return var1 == 0?new Double(Math.cos(-10.0D + this.translate + (double)var2 / 10.0D)):new Double(2.0D * Math.sin(-10.0D + this.translate + (double)var2 / 10.0D));
   }

   public int getSeriesCount() {
      return 2;
   }

   public Comparable getSeriesKey(int var1) {
      return var1 == 0?"y = cosine(x)":(var1 == 1?"y = 2*sine(x)":"Error");
   }

   public int getItemCount(int var1) {
      return 200;
   }
}
