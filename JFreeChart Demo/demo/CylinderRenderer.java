package demo;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleEdge;

public class CylinderRenderer extends BarRenderer3D {

   public CylinderRenderer() {}

   public CylinderRenderer(double var1, double var3) {
      super(var1, var3);
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      Number var11 = var7.getValue(var8, var9);
      if(var11 != null) {
         double var12 = var11.doubleValue();
         Double var14 = new Double(var3.getX(), var3.getY() + this.getYOffset(), var3.getWidth() - this.getXOffset(), var3.getHeight() - this.getYOffset());
         PlotOrientation var15 = var4.getOrientation();
         double var16 = this.calculateBarW0(var4, var15, var14, var5, var2, var8, var9);
         double[] var18 = this.calculateBarL0L1(var12);
         if(var18 != null) {
            RectangleEdge var19 = var4.getRangeAxisEdge();
            float var20 = (float)var6.valueToJava2D(var18[0], var14, var19);
            float var21 = (float)var6.valueToJava2D(var18[1], var14, var19);
            float var22 = Math.min(var20, var21);
            float var23 = Math.abs(var21 - var20);
            GeneralPath var24 = new GeneralPath();
            java.awt.geom.Ellipse2D.Double var25 = null;
            java.awt.geom.Arc2D.Double var26;
            if(var15 == PlotOrientation.HORIZONTAL) {
               var24.moveTo((float)((double)var22 + this.getXOffset() / 2.0D), (float)var16);
               var24.lineTo((float)((double)(var22 + var23) + this.getXOffset() / 2.0D), (float)var16);
               var26 = new java.awt.geom.Arc2D.Double((double)(var22 + var23), var16, this.getXOffset(), var2.getBarWidth(), 90.0D, 180.0D, 0);
               var24.append(var26, true);
               var24.lineTo((float)((double)var22 + this.getXOffset() / 2.0D), (float)(var16 + var2.getBarWidth()));
               var26 = new java.awt.geom.Arc2D.Double((double)var22, var16, this.getXOffset(), var2.getBarWidth(), 270.0D, -180.0D, 0);
               var24.append(var26, true);
               var24.closePath();
               var25 = new java.awt.geom.Ellipse2D.Double((double)(var22 + var23), var16, this.getXOffset(), var2.getBarWidth());
            } else {
               var24.moveTo((float)var16, (float)((double)var22 - this.getYOffset() / 2.0D));
               var24.lineTo((float)var16, (float)((double)(var22 + var23) - this.getYOffset() / 2.0D));
               var26 = new java.awt.geom.Arc2D.Double(var16, (double)(var22 + var23) - this.getYOffset(), var2.getBarWidth(), this.getYOffset(), 180.0D, 180.0D, 0);
               var24.append(var26, true);
               var24.lineTo((float)(var16 + var2.getBarWidth()), (float)((double)var22 - this.getYOffset() / 2.0D));
               var26 = new java.awt.geom.Arc2D.Double(var16, (double)var22 - this.getYOffset(), var2.getBarWidth(), this.getYOffset(), 0.0D, -180.0D, 0);
               var24.append(var26, true);
               var24.closePath();
               var25 = new java.awt.geom.Ellipse2D.Double(var16, (double)var22 - this.getYOffset(), var2.getBarWidth(), this.getYOffset());
            }

            Object var33 = this.getItemPaint(var8, var9);
            if(this.getGradientPaintTransformer() != null && var33 instanceof GradientPaint) {
               GradientPaint var27 = (GradientPaint)var33;
               var33 = this.getGradientPaintTransformer().transform(var27, var24);
            }

            var1.setPaint((Paint)var33);
            var1.fill(var24);
            if(var33 instanceof GradientPaint) {
               var1.setPaint(((GradientPaint)var33).getColor2());
            }

            if(var25 != null) {
               var1.fill(var25);
            }

            if(this.isDrawBarOutline() && var2.getBarWidth() > 3.0D) {
               var1.setStroke(this.getItemOutlineStroke(var8, var9));
               var1.setPaint(this.getItemOutlinePaint(var8, var9));
               var1.draw(var24);
               if(var25 != null) {
                  var1.draw(var25);
               }
            }

            CategoryItemLabelGenerator var34 = this.getItemLabelGenerator(var8, var9);
            if(var34 != null && this.isItemLabelVisible(var8, var9)) {
               this.drawItemLabel(var1, var7, var8, var9, var4, var34, var24.getBounds2D(), var12 < 0.0D);
            }

            if(var2.getInfo() != null) {
               EntityCollection var28 = var2.getEntityCollection();
               if(var28 != null) {
                  String var29 = null;
                  CategoryToolTipGenerator var30 = this.getToolTipGenerator(var8, var9);
                  if(var30 != null) {
                     var29 = var30.generateToolTip(var7, var8, var9);
                  }

                  String var31 = null;
                  if(this.getItemURLGenerator(var8, var9) != null) {
                     var31 = this.getItemURLGenerator(var8, var9).generateURL(var7, var8, var9);
                  }

                  CategoryItemEntity var32 = new CategoryItemEntity(var24.getBounds2D(), var29, var31, var7, var7.getRowKey(var8), var7.getColumnKey(var9));
                  var28.add(var32);
               }
            }

         }
      }
   }
}
