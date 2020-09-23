package demo;

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CompassFormat;
import org.jfree.chart.axis.ModuloAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CompassFormatDemo2 extends ApplicationFrame {

   public CompassFormatDemo2(String var1) {
      super(var1);
      this.setContentPane(new CompassFormatDemo2.MyDemoPanel());
   }

   public static JPanel createDemoPanel() {
      return new CompassFormatDemo2.MyDemoPanel();
   }

   public static void main(String[] var0) {
      CompassFormatDemo2 var1 = new CompassFormatDemo2("JFreeChart: CompassFormatDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }

   private static class MyDemoPanel extends DemoPanel implements ChangeListener {

      private JSlider directionSlider;
      private JSlider fieldSlider;
      private ModuloAxis rangeAxis;
      private double direction = 0.0D;
      private double degrees = 45.0D;


      public MyDemoPanel() {
         super(new BorderLayout());
         JPanel var1 = new JPanel(new GridLayout(1, 2));
         this.fieldSlider = new JSlider(1, 10, 180, 45);
         this.fieldSlider.setPaintLabels(true);
         this.fieldSlider.setPaintTicks(true);
         this.fieldSlider.setMajorTickSpacing(10);
         this.fieldSlider.setMinorTickSpacing(5);
         this.fieldSlider.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
         this.fieldSlider.addChangeListener(this);
         this.directionSlider = new JSlider(1, 0, 360, 0);
         this.directionSlider.setMajorTickSpacing(30);
         this.directionSlider.setMinorTickSpacing(5);
         this.directionSlider.setPaintLabels(true);
         this.directionSlider.setPaintTicks(true);
         this.directionSlider.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
         this.directionSlider.setPaintTrack(true);
         this.directionSlider.addChangeListener(this);
         var1.add(this.fieldSlider);
         var1.add(this.directionSlider);
         JFreeChart var2 = this.createChart();
         this.addChart(var2);
         ChartPanel var3 = new ChartPanel(var2);
         var3.setPreferredSize(new Dimension(500, 270));
         this.add(var1, "West");
         this.add(var3);
      }

      private XYDataset createDirectionDataset(int var1) {
         TimeSeriesCollection var2 = new TimeSeriesCollection();
         TimeSeries var3 = new TimeSeries("Wind Direction");
         Object var4 = new Minute();
         double var5 = 0.0D;

         for(int var7 = 0; var7 < var1; ++var7) {
            var3.add((RegularTimePeriod)var4, var5);
            var4 = ((RegularTimePeriod)var4).next();
            var5 += (Math.random() - 0.5D) * 15.0D;
            if(var5 < 0.0D) {
               var5 += 360.0D;
            } else if(var5 > 360.0D) {
               var5 -= 360.0D;
            }
         }

         var2.addSeries(var3);
         return var2;
      }

      private XYDataset createForceDataset(int var1) {
         TimeSeriesCollection var2 = new TimeSeriesCollection();
         TimeSeries var3 = new TimeSeries("Wind Force");
         Object var4 = new Minute();
         double var5 = 3.0D;

         for(int var7 = 0; var7 < var1; ++var7) {
            var3.add((RegularTimePeriod)var4, var5);
            var4 = ((RegularTimePeriod)var4).next();
            var5 = Math.max(0.5D, var5 + (Math.random() - 0.5D) * 0.5D);
         }

         var2.addSeries(var3);
         return var2;
      }

      private JFreeChart createChart() {
         XYDataset var1 = this.createDirectionDataset(100);
         JFreeChart var2 = ChartFactory.createTimeSeriesChart("Time", "Date", "Direction", var1, true, true, false);
         XYPlot var3 = (XYPlot)var2.getPlot();
         var3.getDomainAxis().setLowerMargin(0.0D);
         var3.getDomainAxis().setUpperMargin(0.0D);
         this.rangeAxis = new ModuloAxis("Direction", new Range(0.0D, 360.0D));
         TickUnits var4 = new TickUnits();
         var4.add(new NumberTickUnit(180.0D, new CompassFormat()));
         var4.add(new NumberTickUnit(90.0D, new CompassFormat()));
         var4.add(new NumberTickUnit(45.0D, new CompassFormat()));
         var4.add(new NumberTickUnit(22.5D, new CompassFormat()));
         this.rangeAxis.setStandardTickUnits(var4);
         XYLineAndShapeRenderer var5 = new XYLineAndShapeRenderer();
         var5.setBaseLinesVisible(false);
         var5.setBaseShapesVisible(true);
         var3.setRenderer(var5);
         var3.setRangeAxis(this.rangeAxis);
         this.rangeAxis.setDisplayRange(-45.0D, 45.0D);
         XYAreaRenderer var6 = new XYAreaRenderer();
         NumberAxis var7 = new NumberAxis("Force");
         var7.setRange(0.0D, 12.0D);
         var6.setSeriesPaint(0, new Color(0, 0, 255, 128));
         var3.setDataset(1, this.createForceDataset(100));
         var3.setRenderer(1, var6);
         var3.setRangeAxis(1, var7);
         var3.mapDatasetToRangeAxis(1, 1);
         ChartUtilities.applyCurrentTheme(var2);
         return var2;
      }

      public void stateChanged(ChangeEvent var1) {
         if(var1.getSource() == this.directionSlider) {
            this.direction = (double)this.directionSlider.getValue();
            this.rangeAxis.setDisplayRange(this.direction - this.degrees, this.direction + this.degrees);
         } else if(var1.getSource() == this.fieldSlider) {
            this.degrees = (double)this.fieldSlider.getValue();
            this.rangeAxis.setDisplayRange(this.direction - this.degrees, this.direction + this.degrees);
         }

      }
   }
}
