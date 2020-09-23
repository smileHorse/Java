package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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

public class MeterChartDemo3 extends ApplicationFrame {

   public MeterChartDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(String var0, ValueDataset var1, DialShape var2) {
      MeterPlot var3 = new MeterPlot(var1);
      var3.setDialShape(var2);
      var3.setRange(new Range(0.0D, 60.0D));
      var3.addInterval(new MeterInterval("Normal", new Range(0.0D, 35.0D), Color.lightGray, new BasicStroke(2.0F), new Color(0, 255, 0, 64)));
      var3.addInterval(new MeterInterval("Warning", new Range(35.0D, 50.0D), Color.lightGray, new BasicStroke(2.0F), new Color(255, 255, 0, 64)));
      var3.addInterval(new MeterInterval("Critical", new Range(50.0D, 60.0D), Color.lightGray, new BasicStroke(2.0F), new Color(255, 0, 0, 128)));
      var3.setNeedlePaint(Color.darkGray);
      var3.setDialBackgroundPaint(Color.white);
      var3.setDialOutlinePaint(Color.gray);
      var3.setMeterAngle(260);
      var3.setTickLabelsVisible(true);
      var3.setTickLabelFont(new Font("Dialog", 1, 10));
      var3.setTickLabelPaint(Color.darkGray);
      var3.setTickSize(5.0D);
      var3.setTickPaint(Color.lightGray);
      var3.setValuePaint(Color.black);
      var3.setValueFont(new Font("Dialog", 1, 14));
      JFreeChart var4 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var3, true);
      ChartUtilities.applyCurrentTheme(var4);
      return var4;
   }

   public static JPanel createDemoPanel() {
      JPanel var0 = new JPanel(new GridLayout(1, 3));
      DefaultValueDataset var1 = new DefaultValueDataset(23.0D);
      ChartPanel var2 = new ChartPanel(createChart("DialShape.PIE", var1, DialShape.PIE));
      ChartPanel var3 = new ChartPanel(createChart("DialShape.CHORD", var1, DialShape.CHORD));
      ChartPanel var4 = new ChartPanel(createChart("DialShape.CIRCLE", var1, DialShape.CIRCLE));
      var0.add(var2);
      var0.add(var3);
      var0.add(var4);
      return var0;
   }

   public static void main(String[] var0) {
      MeterChartDemo3 var1 = new MeterChartDemo3("JFreeChart: MeterChartDemo3.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
