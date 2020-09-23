package demo.orsoncharts;

import com.orsoncharts.Colors;
import com.orsoncharts.renderer.category.StandardCategoryColorSource;
import com.orsoncharts.util.ArgChecks;
import java.awt.Color;

public class HighlightCategoryColorSource extends StandardCategoryColorSource {

   private int highlightRowIndex;
   private int highlightColumnIndex;
   private Color highlightColor;


   public HighlightCategoryColorSource() {
      this(-1, -1, Color.RED, Colors.getDefaultColors());
   }

   public HighlightCategoryColorSource(int var1, int var2, Color var3, Color ... var4) {
      super(var4);
      this.highlightRowIndex = var1;
      this.highlightColumnIndex = var2;
      this.highlightColor = var3;
   }

   public int getHighlightRowIndex() {
      return this.highlightRowIndex;
   }

   public void setHighlightRowIndex(int var1) {
      this.highlightRowIndex = var1;
   }

   public int getHighlightColumnIndex() {
      return this.highlightColumnIndex;
   }

   public void setHighlightColumnIndex(int var1) {
      this.highlightColumnIndex = var1;
   }

   public Color getHighlightColor() {
      return this.highlightColor;
   }

   public void setHighlightColor(Color var1) {
      ArgChecks.nullNotPermitted(var1, "color");
      this.highlightColor = var1;
   }

   public Color getColor(int var1, int var2, int var3) {
      Color var4 = super.getColor(var1, var2, var3);
      if(var2 == this.highlightRowIndex && var3 == this.highlightColumnIndex) {
         var4 = this.highlightColor;
      }

      return var4;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof HighlightCategoryColorSource)) {
         return false;
      } else {
         HighlightCategoryColorSource var2 = (HighlightCategoryColorSource)var1;
         return this.highlightColumnIndex != var2.highlightColumnIndex?false:(this.highlightRowIndex != var2.highlightRowIndex?false:(!this.highlightColor.equals(var2.highlightColor)?false:super.equals(var1)));
      }
   }
}
