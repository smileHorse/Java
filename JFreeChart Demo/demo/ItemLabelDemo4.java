package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class ItemLabelDemo4 extends ApplicationFrame {

   public ItemLabelDemo4(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(212.0D, "Classes", "JDK 1.0");
      var0.addValue(504.0D, "Classes", "JDK 1.1");
      var0.addValue(1520.0D, "Classes", "JDK 1.2");
      var0.addValue(1842.0D, "Classes", "JDK 1.3");
      var0.addValue(2991.0D, "Classes", "JDK 1.4");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createLineChart("Java Standard Class Library", "Release", "Class Count", var0, PlotOrientation.VERTICAL, false, true, false);
      var1.addSubtitle(new TextTitle("Number of Classes By Release"));
      TextTitle var2 = new TextTitle("Source: Java In A Nutshell (4th Edition) by David Flanagan (O\'Reilly)");
      var2.setFont(new Font("SansSerif", 0, 10));
      var2.setPosition(RectangleEdge.BOTTOM);
      var2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
      var1.addSubtitle(var2);
      ChartUtilities.applyCurrentTheme(var1);
      CategoryPlot var3 = (CategoryPlot)var1.getPlot();
      NumberAxis var4 = (NumberAxis)var3.getRangeAxis();
      var4.setUpperMargin(0.15D);
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      LineAndShapeRenderer var5 = (LineAndShapeRenderer)var3.getRenderer();
      var5.setBaseShapesVisible(true);
      var5.setDrawOutlines(true);
      var5.setUseFillPaint(true);
      var5.setBaseFillPaint(Color.white);
      var5.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
      var5.setBaseItemLabelsVisible(true);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      ItemLabelDemo4 var1 = new ItemLabelDemo4("JFreeChart: ItemLabelDemo4.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
