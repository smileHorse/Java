package demo;

import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.LabelBlock;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class LegendWrapperDemo1 extends ApplicationFrame {

   public LegendWrapperDemo1(String var1) {
      super(var1);
      this.setContentPane(createDemoPanel());
   }

   private static PieDataset createDataset() {
      DefaultPieDataset var0 = new DefaultPieDataset();
      var0.setValue("One", new Double(43.2D));
      var0.setValue("Two", new Double(10.0D));
      var0.setValue("Three", new Double(27.5D));
      var0.setValue("Four", new Double(17.5D));
      var0.setValue("Five", new Double(11.0D));
      var0.setValue("Six", new Double(19.4D));
      return var0;
   }

   private static JFreeChart createChart(PieDataset var0) {
      JFreeChart var1 = ChartFactory.createPieChart("Legend Wrapper Demo 1", var0, false, true, false);
      PiePlot var2 = (PiePlot)var1.getPlot();
      var2.setLabelFont(new Font("SansSerif", 0, 12));
      var2.setNoDataMessage("No data available");
      var2.setCircular(true);
      var2.setLabelGap(0.02D);
      LegendTitle var3 = new LegendTitle(var1.getPlot());
      BlockContainer var4 = new BlockContainer(new BorderArrangement());
      var4.setFrame(new BlockBorder(1.0D, 1.0D, 1.0D, 1.0D));
      LabelBlock var5 = new LabelBlock("Legend Items:", new Font("SansSerif", 1, 12));
      var5.setPadding(5.0D, 5.0D, 5.0D, 5.0D);
      var4.add(var5, RectangleEdge.TOP);
      LabelBlock var6 = new LabelBlock("Source: http://www.jfree.org");
      var6.setPadding(8.0D, 20.0D, 2.0D, 5.0D);
      var4.add(var6, RectangleEdge.BOTTOM);
      BlockContainer var7 = var3.getItemContainer();
      var7.setPadding(2.0D, 10.0D, 5.0D, 2.0D);
      var4.add(var7);
      var3.setWrapper(var4);
      var3.setPosition(RectangleEdge.RIGHT);
      var3.setHorizontalAlignment(HorizontalAlignment.LEFT);
      var1.addSubtitle(var3);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      LegendWrapperDemo1 var1 = new LegendWrapperDemo1("JFreeChart: LegendWrapperDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
