package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo2 extends ApplicationFrame {

   public PieChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static PieDataset createDataset() {
      DefaultPieDataset var0 = new DefaultPieDataset();
      var0.setValue("One", 43.2D);
      var0.setValue("Two", 10.0D);
      var0.setValue("Three", 27.5D);
      var0.setValue("Four", 17.5D);
      var0.setValue("Five", 11.0D);
      var0.setValue("Six", 19.4D);
      return var0;
   }

   private static JFreeChart createChart(PieDataset var0) {
      JFreeChart var1 = ChartFactory.createPieChart("Pie Chart Demo 2", var0, true, true, false);
      PiePlot var2 = (PiePlot)var1.getPlot();
      var2.setSectionPaint("One", new Color(160, 160, 255));
      var2.setSectionPaint("Two", new Color(128, 128, 223));
      var2.setSectionPaint("Three", new Color(96, 96, 191));
      var2.setSectionPaint("Four", new Color(64, 64, 159));
      var2.setSectionPaint("Five", new Color(32, 32, 127));
      var2.setSectionPaint("Six", new Color(0, 0, 111));
      var2.setNoDataMessage("No data available");
      var2.setExplodePercent("Two", 0.2D);
      var2.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2} percent)"));
      var2.setLabelBackgroundPaint(new Color(220, 220, 220));
      var2.setLegendLabelToolTipGenerator(new StandardPieSectionLabelGenerator("Tooltip for legend item {0}"));
      var2.setSimpleLabels(true);
      var2.setInteriorGap(0.0D);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      PieChartDemo2 var1 = new PieChartDemo2("JFreeChart: PieChartDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
