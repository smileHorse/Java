package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import demo.orsoncharts.DemoDescription;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.OrsonChartsDemo;
import demo.orsoncharts.swing.OrsonChartsDemoComponent;
import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DemoDisplayer implements Runnable {

   private OrsonChartsDemoComponent demoComp;
   private DemoDescription demoDescription;


   public DemoDisplayer(OrsonChartsDemoComponent var1, DemoDescription var2) {
      this.demoComp = var1;
      this.demoDescription = var2;
   }

   public void run() {
      try {
         Class var1 = Class.forName(this.demoDescription.getClassName());
         Method var2 = var1.getDeclaredMethod("createDemoPanel", (Class[])null);
         JPanel var3 = (JPanel)var2.invoke((Object)null, (Object[])null);
         var3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.BLACK)));
         this.demoComp.getChartContainer().removeAll();
         this.demoComp.getChartContainer().add(var3);
         this.demoComp.getChartContainer().validate();
         if(var3 instanceof DemoPanel) {
            DemoPanel var4 = (DemoPanel)var3;

            Chart3DPanel var6;
            for(Iterator var5 = var4.getChartPanels().iterator(); var5.hasNext(); var6.zoomToFit()) {
               var6 = (Chart3DPanel)var5.next();
               if(this.demoComp.getChartStyle() != null) {
                  Chart3D var7 = (Chart3D)var6.getDrawable();
                  var7.setStyle(this.demoComp.getChartStyle());
               }
            }
         }

         String var13 = this.demoDescription.getDescriptionFileName();
         URL var14 = OrsonChartsDemo.class.getResource(var13);
         if(var14 != null) {
            try {
               this.demoComp.getChartDescriptionPane().setPage(var14);
            } catch (IOException var8) {
               System.err.println("Attempted to read a bad URL: " + var14);
            }
         }
      } catch (ClassNotFoundException var9) {
         var9.printStackTrace();
      } catch (NoSuchMethodException var10) {
         var10.printStackTrace();
      } catch (InvocationTargetException var11) {
         var11.printStackTrace();
      } catch (IllegalAccessException var12) {
         var12.printStackTrace();
      }

   }
}
