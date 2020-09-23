package demo;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo7 extends ApplicationFrame {

   public PieChartDemo7(String var1) {
      super(var1);
      this.setContentPane(createDemoPanel());
   }

   private static PieDataset createDataset(int var0) {
      DefaultPieDataset var1 = new DefaultPieDataset();

      for(int var2 = 0; var2 < var0; ++var2) {
         double var3 = 100.0D * Math.random();
         var1.setValue("Section " + var2, var3);
      }

      return var1;
   }

   public static JPanel createDemoPanel() {
      PieDataset var0 = createDataset(14);
      JFreeChart var1 = ChartFactory.createPieChart("Pie Chart Demo 7", var0, false, true, false);
      PiePlot var2 = (PiePlot)var1.getPlot();
      var2.setCircular(true);
      var2.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
      var2.setNoDataMessage("No data available");
      ChartPanel var3 = new ChartPanel(var1);
      var3.setPreferredSize(new Dimension(500, 270));
      PieChartDemo7.Rotator var4 = new PieChartDemo7.Rotator(var2);
      var4.start();
      return var3;
   }

   public static void main(String[] var0) {
      PieChartDemo7 var1 = new PieChartDemo7("JFreeChart: PieChartDemo7.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }

   static class Rotator extends Timer implements ActionListener {

      private PiePlot plot;
      private int angle = 270;


      Rotator(PiePlot var1) {
         super(50, (ActionListener)null);
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
}
