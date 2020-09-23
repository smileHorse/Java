package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.geom.Ellipse2D.Double;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
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

public class LineChartDemo1 extends ApplicationFrame {

   public LineChartDemo1(String var1) {
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
      var0.addValue(3500.0D, "Classes", "JDK 1.5");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createLineChart("Java Standard Class Library", (String)null, "Class Count", var0, PlotOrientation.VERTICAL, false, true, false);
      var1.addSubtitle(new TextTitle("Number of Classes By Release"));
      TextTitle var2 = new TextTitle("Source: Java In A Nutshell (5th Edition) by David Flanagan (O\'Reilly)");
      var2.setFont(new Font("SansSerif", 0, 10));
      var2.setPosition(RectangleEdge.BOTTOM);
      var2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
      var1.addSubtitle(var2);
      CategoryPlot var3 = (CategoryPlot)var1.getPlot();
      var3.setRangePannable(true);
      var3.setRangeGridlinesVisible(false);
      URL var4 = LineChartDemo1.class.getClassLoader().getResource("OnBridge11small.png");
      if(var4 != null) {
         ImageIcon var5 = new ImageIcon(var4);
         var1.setBackgroundImage(var5.getImage());
         var3.setBackgroundPaint((Paint)null);
      }

      NumberAxis var7 = (NumberAxis)var3.getRangeAxis();
      var7.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      ChartUtilities.applyCurrentTheme(var1);
      LineAndShapeRenderer var6 = (LineAndShapeRenderer)var3.getRenderer();
      var6.setBaseShapesVisible(true);
      var6.setDrawOutlines(true);
      var6.setUseFillPaint(true);
      var6.setBaseFillPaint(Color.white);
      var6.setSeriesStroke(0, new BasicStroke(3.0F));
      var6.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
      var6.setSeriesShape(0, new Double(-5.0D, -5.0D, 10.0D, 10.0D));
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      LineChartDemo1 var1 = new LineChartDemo1("JFreeChart: LineChartDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
