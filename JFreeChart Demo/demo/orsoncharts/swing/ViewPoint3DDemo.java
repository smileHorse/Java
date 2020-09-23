package demo.orsoncharts.swing;

import com.orsoncharts.graphics3d.DefaultDrawable3D;
import com.orsoncharts.graphics3d.Object3D;
import com.orsoncharts.graphics3d.Point3D;
import com.orsoncharts.graphics3d.Rotate3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.World;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewPoint3DDemo extends JFrame {

   List<Point3D> xlist;
   List<Point3D> ylist;
   List<Point3D> zlist;
   Panel3D panel3D;


   public ViewPoint3DDemo(String var1) {
      super(var1);
      this.addWindowListener(new ExitOnClose());
      this.getContentPane().add(this.createDemoPanel());
   }

   public final JPanel createDemoPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
      World var2 = new World();
      var2.add(Object3D.createCube(1.0D, 0.0D, 0.0D, 0.0D, Color.BLUE));
      ViewPoint3D var3 = new ViewPoint3D(new Point3D(10.0D, 10.0D, 10.0D), 0.0D);
      this.xlist = this.addRing(true, var2, new Point3D(0.0D, 5.0D, 0.0D), Point3D.UNIT_X, Color.GREEN);
      this.ylist = this.addRing(true, var2, new Point3D(0.0D, 0.0D, 5.0D), Point3D.UNIT_Y, Color.ORANGE);
      this.zlist = this.addRing(true, var2, new Point3D(0.0D, 5.0D, 0.0D), Point3D.UNIT_Z, Color.RED);
      DefaultDrawable3D var4 = new DefaultDrawable3D(var2);
      this.panel3D = new Panel3D(var4);
      this.panel3D.setViewPoint(var3);
      var1.add(new DisplayPanel3D(this.panel3D));
      return var1;
   }

   private List<Point3D> addRing(boolean var1, World var2, Point3D var3, Point3D var4, Color var5) {
      boolean var6 = true;
      ArrayList var7 = new ArrayList();
      Rotate3D var8 = new Rotate3D(Point3D.ORIGIN, var4, 0.0D);

      for(int var9 = 0; var9 < 60; ++var9) {
         var8.setAngle(0.10471975511965977D * (double)var9);
         Point3D var10 = var8.applyRotation(var3);
         var7.add(var10);
         if(var1) {
            if(var6) {
               var2.add(Object3D.createCube(0.2D, var10.x, var10.y, var10.z, Color.RED));
               var6 = false;
            } else {
               var2.add(Object3D.createCube(0.2D, var10.x, var10.y, var10.z, var5));
            }
         }
      }

      return var7;
   }

   public static void main(String[] var0) {
      ViewPoint3DDemo var1 = new ViewPoint3DDemo("OrsonCharts: ViewPointDemo.java");
      var1.pack();
      var1.setVisible(true);
   }
}
