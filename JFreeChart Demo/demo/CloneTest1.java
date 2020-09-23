package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CloneTest1 extends ApplicationFrame implements ActionListener {

   private TimeSeries series = new TimeSeries("Random Data");
   private double lastValue = 100.0D;


   public CloneTest1(String var1) {
      super(var1);
      TimeSeriesCollection var2 = new TimeSeriesCollection(this.series);
      JFreeChart var3 = this.createChart(var2);
      JFreeChart var4 = null;

      try {
         var4 = (JFreeChart)var3.clone();
      } catch (Exception var10) {
         var10.printStackTrace();
      }

      XYPlot var5 = (XYPlot)var4.getPlot();
      TimeSeriesCollection var6 = (TimeSeriesCollection)var5.getDataset();
      this.series = var6.getSeries(0);
      ChartPanel var7 = new ChartPanel(var4);
      JButton var8 = new JButton("Add New Data Item");
      var8.setActionCommand("ADD_DATA");
      var8.addActionListener(this);
      JPanel var9 = new JPanel(new BorderLayout());
      var9.add(var7);
      var9.add(var8, "South");
      var7.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var9);
   }

   private JFreeChart createChart(XYDataset var1) {
      JFreeChart var2 = ChartFactory.createTimeSeriesChart("Clone Test 1", "Time", "Value", var1, true, true, false);
      XYPlot var3 = (XYPlot)var2.getPlot();
      ValueAxis var4 = var3.getDomainAxis();
      var4.setAutoRange(true);
      var4.setFixedAutoRange(60000.0D);
      return var2;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getActionCommand().equals("ADD_DATA")) {
         double var2 = 0.9D + 0.2D * Math.random();
         this.lastValue *= var2;
         Millisecond var4 = new Millisecond();
         System.out.println("Now = " + var4.toString());
         this.series.add(new Millisecond(), this.lastValue);
      }

   }

   public static void main(String[] var0) {
      CloneTest1 var1 = new CloneTest1("JFreeChart : Clone Test 1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
