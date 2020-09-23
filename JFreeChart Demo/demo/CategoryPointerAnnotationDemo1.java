package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryPointerAnnotation;
import org.jfree.chart.axis.NumberAxis;
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
import org.jfree.ui.TextAnchor;

public class CategoryPointerAnnotationDemo1 extends ApplicationFrame {

   public CategoryPointerAnnotationDemo1(String var1) {
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
      CategoryPlot var3 = (CategoryPlot)var1.getPlot();
      NumberAxis var4 = (NumberAxis)var3.getRangeAxis();
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      LineAndShapeRenderer var5 = (LineAndShapeRenderer)var3.getRenderer();
      var5.setBaseShapesVisible(true);
      var5.setDrawOutlines(true);
      var5.setUseFillPaint(true);
      var5.setBaseFillPaint(Color.white);
      CategoryPointerAnnotation var6 = new CategoryPointerAnnotation("Released 4-Dec-1998", "JDK 1.2", 1530.0D, -2.356194490192345D);
      var6.setTextAnchor(TextAnchor.BOTTOM_RIGHT);
      var3.addAnnotation(var6);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      CategoryPointerAnnotationDemo1 var1 = new CategoryPointerAnnotationDemo1("JFreeChart: CategoryPointerAnnotationDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
