package demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.text.NumberFormat;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

public class ExtendedStackedBarRenderer extends StackedBarRenderer {

   private boolean showPositiveTotal = true;
   private boolean showNegativeTotal = true;
   private Font totalLabelFont = new Font("SansSerif", 1, 12);
   private NumberFormat totalFormatter = NumberFormat.getInstance();


   public NumberFormat getTotalFormatter() {
      return this.totalFormatter;
   }

   public void setTotalFormatter(NumberFormat var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null format not permitted.");
      } else {
         this.totalFormatter = var1;
      }
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      Number var11 = var7.getValue(var8, var9);
      if(var11 != null) {
         double var12 = var11.doubleValue();
         PlotOrientation var14 = var4.getOrientation();
         double var15 = var5.getCategoryMiddle(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge()) - var2.getBarWidth() / 2.0D;
         double var17 = 0.0D;
         double var19 = 0.0D;

         double var23;
         for(int var21 = 0; var21 < var8; ++var21) {
            Number var22 = var7.getValue(var21, var9);
            if(var22 != null) {
               var23 = var22.doubleValue();
               if(var23 > 0.0D) {
                  var17 += var23;
               } else {
                  var19 += var23;
               }
            }
         }

         RectangleEdge var25 = var4.getRangeAxisEdge();
         double var38;
         if(var12 > 0.0D) {
            var38 = var6.valueToJava2D(var17, var3, var25);
            var23 = var6.valueToJava2D(var17 + var12, var3, var25);
         } else {
            var38 = var6.valueToJava2D(var19, var3, var25);
            var23 = var6.valueToJava2D(var19 + var12, var3, var25);
         }

         double var26 = Math.min(var38, var23);
         double var28 = Math.max(Math.abs(var23 - var38), this.getMinimumBarLength());
         Double var30 = null;
         if(var14 == PlotOrientation.HORIZONTAL) {
            var30 = new Double(var26, var15, var28, var2.getBarWidth());
         } else {
            var30 = new Double(var15, var26, var2.getBarWidth(), var28);
         }

         Paint var31 = this.getItemPaint(var8, var9);
         var1.setPaint(var31);
         var1.fill(var30);
         if(this.isDrawBarOutline() && var2.getBarWidth() > 3.0D) {
            var1.setStroke(this.getItemStroke(var8, var9));
            var1.setPaint(this.getItemOutlinePaint(var8, var9));
            var1.draw(var30);
         }

         CategoryItemLabelGenerator var32 = this.getItemLabelGenerator(var8, var9);
         if(var32 != null && this.isItemLabelVisible(var8, var9)) {
            this.drawItemLabel(var1, var7, var8, var9, var4, var32, var30, var12 < 0.0D);
         }

         double var33;
         float var35;
         float var36;
         TextAnchor var37;
         if(var12 > 0.0D) {
            if(this.showPositiveTotal && this.isLastPositiveItem(var7, var8, var9)) {
               var1.setPaint(Color.black);
               var1.setFont(this.totalLabelFont);
               var33 = this.calculateSumOfPositiveValuesForCategory(var7, var9);
               var35 = (float)var30.getCenterX();
               var36 = (float)var30.getMinY() - 4.0F;
               var37 = TextAnchor.BOTTOM_CENTER;
               if(var14 == PlotOrientation.HORIZONTAL) {
                  var35 = (float)var30.getMaxX() + 4.0F;
                  var36 = (float)var30.getCenterY();
                  var37 = TextAnchor.CENTER_LEFT;
               }

               TextUtilities.drawRotatedString(this.totalFormatter.format(var33), var1, var35, var36, var37, 0.0D, TextAnchor.CENTER);
            }
         } else if(this.showNegativeTotal && this.isLastNegativeItem(var7, var8, var9)) {
            var1.setPaint(Color.black);
            var1.setFont(this.totalLabelFont);
            var33 = this.calculateSumOfNegativeValuesForCategory(var7, var9);
            var35 = (float)var30.getCenterX();
            var36 = (float)var30.getMaxY() + 4.0F;
            var37 = TextAnchor.TOP_CENTER;
            if(var14 == PlotOrientation.HORIZONTAL) {
               var35 = (float)var30.getMinX() - 4.0F;
               var36 = (float)var30.getCenterY();
               var37 = TextAnchor.CENTER_RIGHT;
            }

            TextUtilities.drawRotatedString(this.totalFormatter.format(var33), var1, var35, var36, var37, 0.0D, TextAnchor.CENTER);
         }

         if(var2.getInfo() != null) {
            EntityCollection var39 = var2.getEntityCollection();
            if(var39 != null) {
               String var34 = null;
               CategoryToolTipGenerator var40 = this.getToolTipGenerator(var8, var9);
               if(var40 != null) {
                  var34 = var40.generateToolTip(var7, var8, var9);
               }

               String var41 = null;
               if(this.getItemURLGenerator(var8, var9) != null) {
                  var41 = this.getItemURLGenerator(var8, var9).generateURL(var7, var8, var9);
               }

               CategoryItemEntity var42 = new CategoryItemEntity(var30, var34, var41, var7, var7.getRowKey(var8), var7.getColumnKey(var9));
               var39.add(var42);
            }
         }

      }
   }

   private boolean isLastPositiveItem(CategoryDataset var1, int var2, int var3) {
      boolean var4 = true;
      Number var5 = var1.getValue(var2, var3);
      if(var5 == null) {
         return false;
      } else {
         for(int var6 = var2 + 1; var6 < var1.getRowCount(); ++var6) {
            var5 = var1.getValue(var6, var3);
            if(var5 != null) {
               var4 = var4 && var5.doubleValue() <= 0.0D;
            }
         }

         return var4;
      }
   }

   private boolean isLastNegativeItem(CategoryDataset var1, int var2, int var3) {
      boolean var4 = true;
      Number var5 = var1.getValue(var2, var3);
      if(var5 == null) {
         return false;
      } else {
         for(int var6 = var2 + 1; var6 < var1.getRowCount(); ++var6) {
            var5 = var1.getValue(var6, var3);
            if(var5 != null) {
               var4 = var4 && var5.doubleValue() >= 0.0D;
            }
         }

         return var4;
      }
   }

   private double calculateSumOfPositiveValuesForCategory(CategoryDataset var1, int var2) {
      double var3 = 0.0D;

      for(int var5 = 0; var5 < var1.getRowCount(); ++var5) {
         Number var6 = var1.getValue(var5, var2);
         if(var6 != null) {
            double var7 = var6.doubleValue();
            if(var7 > 0.0D) {
               var3 += var7;
            }
         }
      }

      return var3;
   }

   private double calculateSumOfNegativeValuesForCategory(CategoryDataset var1, int var2) {
      double var3 = 0.0D;

      for(int var5 = 0; var5 < var1.getRowCount(); ++var5) {
         Number var6 = var1.getValue(var5, var2);
         if(var6 != null) {
            double var7 = var6.doubleValue();
            if(var7 < 0.0D) {
               var3 += var7;
            }
         }
      }

      return var3;
   }
}
