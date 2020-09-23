package demo;

import demo.SampleXYZDataset2;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.BubbleXYItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class BubbleChartDemo2 extends ApplicationFrame {

   public BubbleChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYZDataset var0) {
      JFreeChart var1 = ChartFactory.createBubbleChart("Bubble Chart Demo 2", "X", "Y", var0, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setRenderer(new XYBubbleRenderer(0));
      var2.setForegroundAlpha(0.65F);
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      XYItemRenderer var3 = var2.getRenderer();
      var3.setSeriesPaint(0, Color.blue);
      var3.setBaseItemLabelGenerator(new BubbleXYItemLabelGenerator());
      var3.setBaseToolTipGenerator(new StandardXYZToolTipGenerator());
      var3.setBaseItemLabelsVisible(true);
      var3.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
      NumberAxis var4 = (NumberAxis)var2.getDomainAxis();
      var4.setRange(0.0D, 10.0D);
      NumberAxis var5 = (NumberAxis)var2.getRangeAxis();
      var5.setRange(0.0D, 10.0D);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(new SampleXYZDataset2());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      BubbleChartDemo2 var1 = new BubbleChartDemo2("JFreeChart: BubbleChartDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
