package demo.orsoncharts.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExitOnClose extends WindowAdapter {

   public void windowClosing(WindowEvent var1) {
      System.exit(0);
   }
}
