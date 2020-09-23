package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JPanel;
import org.jfree.text.TextUtilities;
import org.jfree.ui.TextAnchor;

public class DrawStringPanel extends JPanel {

   private static final Dimension PREFERRED_SIZE = new Dimension(500, 300);
   private boolean rotate;
   private String text = "Hello World";
   private TextAnchor anchor;
   private TextAnchor rotationAnchor;
   private Font font;
   private double angle;


   public DrawStringPanel(String var1, boolean var2) {
      this.anchor = TextAnchor.TOP_LEFT;
      this.rotationAnchor = TextAnchor.TOP_LEFT;
      this.font = new Font("Serif", 0, 12);
      this.text = var1;
      this.rotate = var2;
   }

   public Dimension getPreferredSize() {
      return PREFERRED_SIZE;
   }

   public void setAnchor(TextAnchor var1) {
      this.anchor = var1;
   }

   public void setRotationAnchor(TextAnchor var1) {
      this.rotationAnchor = var1;
   }

   public void setAngle(double var1) {
      this.angle = var1;
   }

   public Font getFont() {
      return this.font;
   }

   public void setFont(Font var1) {
      this.font = var1;
   }

   public void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      Graphics2D var2 = (Graphics2D)var1;
      Dimension var3 = this.getSize();
      Insets var4 = this.getInsets();
      Double var5 = new Double((double)var4.left, (double)var4.top, var3.getWidth() - (double)var4.left - (double)var4.right, var3.getHeight() - (double)var4.top - (double)var4.bottom);
      double var6 = var5.getCenterX();
      double var8 = var5.getCenterY();
      java.awt.geom.Line2D.Double var10 = new java.awt.geom.Line2D.Double(var6 - 2.0D, var8 + 2.0D, var6 + 2.0D, var8 - 2.0D);
      java.awt.geom.Line2D.Double var11 = new java.awt.geom.Line2D.Double(var6 - 2.0D, var8 - 2.0D, var6 + 2.0D, var8 + 2.0D);
      var2.setPaint(Color.red);
      var2.draw(var10);
      var2.draw(var11);
      var2.setFont(this.font);
      var2.setPaint(Color.black);
      if(this.rotate) {
         TextUtilities.drawRotatedString(this.text, var2, (float)var6, (float)var8, this.anchor, this.angle, this.rotationAnchor);
      } else {
         TextUtilities.drawAlignedString(this.text, var2, (float)var6, (float)var8, this.anchor);
      }

   }

}
