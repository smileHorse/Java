package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DialShape;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MeterChartDemo1 extends ApplicationFrame {

   private static DefaultValueDataset dataset;


   public MeterChartDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(ValueDataset var0) {
      MeterPlot var1 = new MeterPlot(var0);
      var1.setRange(new Range(0.0D, 60.0D));
      var1.addInterval(new MeterInterval("Normal", new Range(0.0D, 35.0D), Color.lightGray, new BasicStroke(2.0F), new Color(0, 255, 0, 64)));
      var1.addInterval(new MeterInterval("Warning", new Range(35.0D, 50.0D), Color.lightGray, new BasicStroke(2.0F), new Color(255, 255, 0, 64)));
      var1.addInterval(new MeterInterval("Critical", new Range(50.0D, 60.0D), Color.lightGray, new BasicStroke(2.0F), new Color(255, 0, 0, 128)));
      var1.setNeedlePaint(Color.darkGray);
      var1.setDialBackgroundPaint(Color.white);
      var1.setDialOutlinePaint(Color.gray);
      var1.setDialShape(DialShape.CHORD);
      var1.setMeterAngle(260);
      var1.setTickLabelsVisible(true);
      var1.setTickLabelFont(new Font("Dialog", 1, 10));
      var1.setTickLabelPaint(Color.darkGray);
      var1.setTickSize(5.0D);
      var1.setTickPaint(Color.lightGray);
      var1.setValuePaint(Color.black);
      var1.setValueFont(new Font("Dialog", 1, 14));
      JFreeChart var2 = new JFreeChart("Meter Chart 1", JFreeChart.DEFAULT_TITLE_FONT, var1, true);
      ChartUtilities.applyCurrentTheme(var2);
      return var2;
   }

   public static JPanel createDemoPanel() {
      dataset = new DefaultValueDataset(23.0D);
      JFreeChart var0 = createChart(dataset);
      ChartPanel var1 = new ChartPanel(var0);
      return var1;
   }

   public static void main(String[] var0) {
      MeterChartDemo1 var1 = new MeterChartDemo1("JFreeChart: MeterChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
