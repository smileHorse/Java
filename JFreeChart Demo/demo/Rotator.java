package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jfree.chart.plot.PiePlot3D;

class Rotator extends Timer implements ActionListener {

   private PiePlot3D plot;
   private int angle = 270;


   Rotator(PiePlot3D var1) {
      super(100, (ActionListener)null);
      this.plot = var1;
      this.addActionListener(this);
   }

   public void actionPerformed(ActionEvent var1) {
      this.plot.setStartAngle((double)this.angle);
      ++this.angle;
      if(this.angle == 360) {
         this.angle = 0;
      }

   }
}
