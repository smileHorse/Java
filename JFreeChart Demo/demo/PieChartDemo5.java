package demo;

import demo.DemoPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo5 extends ApplicationFrame {

   public PieChartDemo5(String var1) {
      super(var1);
      this.setContentPane(createDemoPanel());
   }

   public static JPanel createDemoPanel() {
      DemoPanel var0 = new DemoPanel(new GridLayout(2, 2));
      DefaultPieDataset var1 = new DefaultPieDataset();
      var1.setValue("Section 1", 23.3D);
      var1.setValue("Section 2", 56.5D);
      var1.setValue("Section 3", 43.3D);
      var1.setValue("Section 4", 11.1D);
      JFreeChart var2 = ChartFactory.createPieChart("Chart 1", var1, false, false, false);
      var2.addSubtitle(new TextTitle("setCircular(true);", new Font("Dialog", 0, 12)));
      PiePlot var3 = (PiePlot)var2.getPlot();
      var3.setCircular(true);
      var3.setInteriorGap(0.04D);
      var3.setMaximumLabelWidth(0.2D);
      JFreeChart var4 = ChartFactory.createPieChart("Chart 2", var1, false, false, false);
      var4.addSubtitle(new TextTitle("setCircular(false);", new Font("Dialog", 0, 12)));
      PiePlot var5 = (PiePlot)var4.getPlot();
      var5.setCircular(false);
      var5.setInteriorGap(0.04D);
      var5.setMaximumLabelWidth(0.2D);
      JFreeChart var6 = ChartFactory.createPieChart3D("Chart 3", var1, false, false, false);
      var6.addSubtitle(new TextTitle("setCircular(true);", new Font("Dialog", 0, 12)));
      PiePlot3D var7 = (PiePlot3D)var6.getPlot();
      var7.setForegroundAlpha(0.6F);
      var7.setCircular(true);
      var7.setInteriorGap(0.04D);
      var7.setMaximumLabelWidth(0.2D);
      JFreeChart var8 = ChartFactory.createPieChart3D("Chart 4", var1, false, false, false);
      var8.addSubtitle(new TextTitle("setCircular(false);", new Font("Dialog", 0, 12)));
      PiePlot3D var9 = (PiePlot3D)var8.getPlot();
      var9.setForegroundAlpha(0.6F);
      var9.setCircular(false);
      var9.setInteriorGap(0.04D);
      var9.setMaximumLabelWidth(0.2D);
      var0.add(new ChartPanel(var2));
      var0.add(new ChartPanel(var4));
      var0.add(new ChartPanel(var6));
      var0.add(new ChartPanel(var8));
      var0.addChart(var2);
      var0.addChart(var4);
      var0.addChart(var6);
      var0.addChart(var8);
      var0.setPreferredSize(new Dimension(800, 600));
      return var0;
   }

   public static void main(String[] var0) {
      PieChartDemo5 var1 = new PieChartDemo5("JFreeChart: PieChartDemo5.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
