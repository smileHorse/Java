package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class DualAxisDemo1 extends ApplicationFrame {

   public DualAxisDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset1() {
      String var0 = "S1";
      String var1 = "S2";
      String var2 = "S3";
      String var3 = "Category 1";
      String var4 = "Category 2";
      String var5 = "Category 3";
      String var6 = "Category 4";
      String var7 = "Category 5";
      String var8 = "Category 6";
      String var9 = "Category 7";
      String var10 = "Category 8";
      DefaultCategoryDataset var11 = new DefaultCategoryDataset();
      var11.addValue(1.0D, var0, var3);
      var11.addValue(4.0D, var0, var4);
      var11.addValue(3.0D, var0, var5);
      var11.addValue(5.0D, var0, var6);
      var11.addValue(5.0D, var0, var7);
      var11.addValue(7.0D, var0, var8);
      var11.addValue(7.0D, var0, var9);
      var11.addValue(8.0D, var0, var10);
      var11.addValue(5.0D, var1, var3);
      var11.addValue(7.0D, var1, var4);
      var11.addValue(6.0D, var1, var5);
      var11.addValue(8.0D, var1, var6);
      var11.addValue(4.0D, var1, var7);
      var11.addValue(4.0D, var1, var8);
      var11.addValue(2.0D, var1, var9);
      var11.addValue(1.0D, var1, var10);
      var11.addValue(4.0D, var2, var3);
      var11.addValue(3.0D, var2, var4);
      var11.addValue(2.0D, var2, var5);
      var11.addValue(3.0D, var2, var6);
      var11.addValue(6.0D, var2, var7);
      var11.addValue(3.0D, var2, var8);
      var11.addValue(4.0D, var2, var9);
      var11.addValue(3.0D, var2, var10);
      return var11;
   }

   private static CategoryDataset createDataset2() {
      String var0 = "S4";
      String var1 = "Category 1";
      String var2 = "Category 2";
      String var3 = "Category 3";
      String var4 = "Category 4";
      String var5 = "Category 5";
      String var6 = "Category 6";
      String var7 = "Category 7";
      String var8 = "Category 8";
      DefaultCategoryDataset var9 = new DefaultCategoryDataset();
      var9.addValue(15.0D, var0, var1);
      var9.addValue(24.0D, var0, var2);
      var9.addValue(31.0D, var0, var3);
      var9.addValue(25.0D, var0, var4);
      var9.addValue(56.0D, var0, var5);
      var9.addValue(37.0D, var0, var6);
      var9.addValue(77.0D, var0, var7);
      var9.addValue(18.0D, var0, var8);
      return var9;
   }

   private static JFreeChart createChart() {
      JFreeChart var0 = ChartFactory.createBarChart("DualAxisDemo1", "Category", "Value", createDataset1(), PlotOrientation.VERTICAL, false, true, false);
      CategoryPlot var1 = (CategoryPlot)var0.getPlot();
      CategoryDataset var2 = createDataset2();
      var1.setDataset(1, var2);
      var1.mapDatasetToRangeAxis(1, 1);
      CategoryAxis var3 = var1.getDomainAxis();
      var3.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
      NumberAxis var4 = new NumberAxis("Secondary");
      var1.setRangeAxis(1, var4);
      LineAndShapeRenderer var5 = new LineAndShapeRenderer();
      var5.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
      var1.setRenderer(1, var5);
      var1.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
      LegendTitle var6 = new LegendTitle(var1.getRenderer(0));
      var6.setMargin(new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D));
      var6.setFrame(new BlockBorder());
      LegendTitle var7 = new LegendTitle(var1.getRenderer(1));
      var7.setMargin(new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D));
      var7.setFrame(new BlockBorder());
      BlockContainer var8 = new BlockContainer(new BorderArrangement());
      var8.add(var6, RectangleEdge.LEFT);
      var8.add(var7, RectangleEdge.RIGHT);
      var8.add(new EmptyBlock(2000.0D, 0.0D));
      CompositeTitle var9 = new CompositeTitle(var8);
      var9.setPosition(RectangleEdge.BOTTOM);
      var0.addSubtitle(var9);
      ChartUtilities.applyCurrentTheme(var0);
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      DualAxisDemo1 var1 = new DualAxisDemo1("JFreeChart: DualAxisDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
