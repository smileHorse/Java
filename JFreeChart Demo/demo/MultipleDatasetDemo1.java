package demo;

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MultipleDatasetDemo1 extends ApplicationFrame {

   public MultipleDatasetDemo1(String var1) {
      super(var1);
      this.setContentPane(createDemoPanel());
   }

   public static JPanel createDemoPanel() {
      return new MultipleDatasetDemo1.MyDemoPanel();
   }

   public static void main(String[] var0) {
      MultipleDatasetDemo1 var1 = new MultipleDatasetDemo1("JFreeChart: MultipleDatasetDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }

   static class MyDemoPanel extends DemoPanel implements ActionListener {

      private XYPlot plot;
      private int datasetIndex = 0;


      public MyDemoPanel() {
         super(new BorderLayout());
         TimeSeriesCollection var1 = this.createRandomDataset("Series 1");
         JFreeChart var2 = ChartFactory.createTimeSeriesChart("Multiple Dataset Demo 1", "Time", "Value", var1, true, true, false);
         var2.setBackgroundPaint((Paint)null);
         this.addChart(var2);
         this.plot = (XYPlot)var2.getPlot();
         ValueAxis var3 = this.plot.getDomainAxis();
         var3.setAutoRange(true);
         NumberAxis var4 = new NumberAxis("Range Axis 2");
         var4.setAutoRangeIncludesZero(false);
         ChartUtilities.applyCurrentTheme(var2);
         JPanel var5 = new JPanel(new BorderLayout());
         ChartPanel var6 = new ChartPanel(var2);
         var5.add(var6);
         JButton var7 = new JButton("Add Dataset");
         var7.setActionCommand("ADD_DATASET");
         var7.addActionListener(this);
         JButton var8 = new JButton("Remove Dataset");
         var8.setActionCommand("REMOVE_DATASET");
         var8.addActionListener(this);
         JPanel var9 = new JPanel(new FlowLayout());
         var9.add(var7);
         var9.add(var8);
         var5.add(var9, "South");
         var6.setPreferredSize(new Dimension(500, 270));
         this.add(var5);
      }

      private TimeSeriesCollection createRandomDataset(String var1) {
         TimeSeries var2 = new TimeSeries(var1);
         double var3 = 100.0D;
         Object var5 = new Day();

         for(int var6 = 0; var6 < 50; ++var6) {
            var2.add((RegularTimePeriod)var5, var3);
            var5 = ((RegularTimePeriod)var5).next();
            var3 *= 1.0D + Math.random() / 100.0D;
         }

         return new TimeSeriesCollection(var2);
      }

      public void actionPerformed(ActionEvent var1) {
         if(var1.getActionCommand().equals("ADD_DATASET")) {
            if(this.datasetIndex < 20) {
               ++this.datasetIndex;
               this.plot.setDataset(this.datasetIndex, this.createRandomDataset("S" + this.datasetIndex));
               this.plot.setRenderer(this.datasetIndex, new StandardXYItemRenderer());
            }
         } else if(var1.getActionCommand().equals("REMOVE_DATASET") && this.datasetIndex >= 1) {
            this.plot.setDataset(this.datasetIndex, (XYDataset)null);
            this.plot.setRenderer(this.datasetIndex, (XYItemRenderer)null);
            --this.datasetIndex;
         }

      }
   }
}
