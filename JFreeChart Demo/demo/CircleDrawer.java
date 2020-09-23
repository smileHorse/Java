package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;
import org.jfree.ui.Drawable;

public class CircleDrawer implements Drawable {

   private Paint outlinePaint;
   private Stroke outlineStroke;
   private Paint fillPaint;


   public CircleDrawer(Paint var1, Stroke var2, Paint var3) {
      this.outlinePaint = var1;
      this.outlineStroke = var2;
      this.fillPaint = var3;
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      Double var3 = new Double(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight());
      if(this.fillPaint != null) {
         var1.setPaint(this.fillPaint);
         var1.fill(var3);
      }

      if(this.outlinePaint != null && this.outlineStroke != null) {
         var1.setPaint(this.outlinePaint);
         var1.setStroke(this.outlineStroke);
         var1.draw(var3);
      }

      var1.setPaint(Color.black);
      var1.setStroke(new BasicStroke(1.0F));
      java.awt.geom.Line2D.Double var4 = new java.awt.geom.Line2D.Double(var2.getCenterX(), var2.getMinY(), var2.getCenterX(), var2.getMaxY());
      java.awt.geom.Line2D.Double var5 = new java.awt.geom.Line2D.Double(var2.getMinX(), var2.getCenterY(), var2.getMaxX(), var2.getCenterY());
      var1.draw(var4);
      var1.draw(var5);
   }
}
