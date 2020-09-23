package demo;

import demo.DemoPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo6 extends ApplicationFrame {

   public PieChartDemo6(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(800, 600));
      this.setContentPane(var2);
   }

   private static PieDataset createDataset() {
      DefaultPieDataset var0 = new DefaultPieDataset();
      var0.setValue("S1", 7.0D);
      var0.setValue("S2", (Number)null);
      var0.setValue("S3", 0.0D);
      var0.setValue("S4", 3.0D);
      var0.setValue("S5", -1.0D);
      return var0;
   }

   private static JFreeChart createChart(String var0, PieDataset var1) {
      JFreeChart var2 = ChartFactory.createPieChart(var0, var1, true, true, false);
      PiePlot var3 = (PiePlot)var2.getPlot();
      var3.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {1}"));
      return var2;
   }

   public static JPanel createDemoPanel() {
      DemoPanel var0 = new DemoPanel(new GridLayout(2, 2));
      JFreeChart var1 = createChart("Pie Chart 1", createDataset());
      Font var2 = new Font("Dialog", 0, 12);
      var1.addSubtitle(new TextTitle("Ignore nulls: false; Ignore zeros: false;", var2));
      JFreeChart var3 = createChart("Pie Chart 2", createDataset());
      var3.addSubtitle(new TextTitle("Ignore nulls: true; Ignore zeros: false;", var2));
      PiePlot var4 = (PiePlot)var3.getPlot();
      var4.setIgnoreNullValues(true);
      var4.setIgnoreZeroValues(false);
      JFreeChart var5 = createChart("Pie Chart 3", createDataset());
      var5.addSubtitle(new TextTitle("Ignore nulls: false; Ignore zeros: true;", var2));
      PiePlot var6 = (PiePlot)var5.getPlot();
      var6.setIgnoreNullValues(false);
      var6.setIgnoreZeroValues(true);
      JFreeChart var7 = createChart("Pie Chart 4", createDataset());
      var7.addSubtitle(new TextTitle("Ignore nulls: true; Ignore zeros: true;", var2));
      PiePlot var8 = (PiePlot)var7.getPlot();
      var8.setIgnoreNullValues(true);
      var8.setIgnoreZeroValues(true);
      var0.add(new ChartPanel(var1));
      var0.add(new ChartPanel(var3));
      var0.add(new ChartPanel(var5));
      var0.add(new ChartPanel(var7));
      var0.addChart(var1);
      var0.addChart(var3);
      var0.addChart(var5);
      var0.addChart(var7);
      return var0;
   }

   public static void main(String[] var0) {
      PieChartDemo6 var1 = new PieChartDemo6("JFreeChart: PieChartDemo6.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
