package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.CenterTextMode;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class RingChartDemo2 extends ApplicationFrame {

   private static final long serialVersionUID = 1L;


   public RingChartDemo2(String var1) {
      super(var1);
      this.setContentPane(createDemoPanel());
   }

   private static PieDataset createDataset() {
      DefaultPieDataset var0 = new DefaultPieDataset();
      var0.setValue("A", new Double(0.653D));
      var0.setValue("B", new Double(0.347D));
      return var0;
   }

   private static JFreeChart createChart(PieDataset var0) {
      RingPlot var1 = new RingPlot(var0);
      var1.setCenterTextMode(CenterTextMode.VALUE);
      var1.setCenterTextFont(new Font("SansSerif", 1, 24));
      var1.setCenterTextColor(Color.LIGHT_GRAY);
      var1.setCenterTextFormatter(new DecimalFormat("0.0%"));
      JFreeChart var2 = new JFreeChart("Machine Capacity", JFreeChart.DEFAULT_TITLE_FONT, var1, false);
      var2.setBackgroundPaint(new GradientPaint(new Point(0, 0), new Color(20, 20, 20), new Point(400, 200), Color.DARK_GRAY));
      TextTitle var3 = var2.getTitle();
      var3.setHorizontalAlignment(HorizontalAlignment.LEFT);
      var3.setPaint(new Color(240, 240, 240));
      var3.setFont(new Font("Arial", 1, 26));
      var1.setBackgroundPaint((Paint)null);
      var1.setOutlineVisible(false);
      var1.setLabelGenerator((PieSectionLabelGenerator)null);
      var1.setSectionPaint("A", Color.ORANGE);
      var1.setSectionPaint("B", new Color(100, 100, 100));
      var1.setSectionDepth(0.05D);
      var1.setSectionOutlinesVisible(false);
      var1.setShadowPaint((Paint)null);
      return var2;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      var0.setPadding(new RectangleInsets(4.0D, 8.0D, 2.0D, 2.0D));
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      var1.setPreferredSize(new Dimension(600, 300));
      return var1;
   }

   public static void main(String[] var0) {
      RingChartDemo2 var1 = new RingChartDemo2("JFreeChart: Ring Chart Demo 2");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
