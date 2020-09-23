package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jfree.data.category.DefaultCategoryDataset;

class Animator extends Timer implements ActionListener {

   private DefaultCategoryDataset dataset;


   Animator(DefaultCategoryDataset var1) {
      super(20, (ActionListener)null);
      this.dataset = var1;
      this.addActionListener(this);
   }

   public void actionPerformed(ActionEvent var1) {
      int var2 = (int)(Math.random() * (double)this.dataset.getRowCount());
      Comparable var3 = this.dataset.getRowKey(var2);
      int var4 = (int)(Math.random() * (double)this.dataset.getColumnCount());
      Comparable var5 = this.dataset.getColumnKey(var4);
      int var6 = Math.random() - 0.5D < 0.0D?-5:5;
      this.dataset.setValue(Math.max(0.0D, this.dataset.getValue(var2, var4).doubleValue() + (double)var6), var3, var5);
   }
}
