package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ExtendedCategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class SurveyResultsDemo3 extends ApplicationFrame {

   public SurveyResultsDemo3(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(300, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(2.61D, "Results", "Sm.");
      var0.addValue(2.7D, "Results", "Med.");
      var0.addValue(2.9D, "Results", "Lg.");
      var0.addValue(2.74D, "Results", "All");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart((String)null, (String)null, (String)null, var0, PlotOrientation.HORIZONTAL, false, true, false);
      var1.setBackgroundPaint(Color.white);
      var1.getPlot().setOutlinePaint((Paint)null);
      TextTitle var2 = new TextTitle("Figure 6 | Overall SEO Rating");
      var2.setHorizontalAlignment(HorizontalAlignment.LEFT);
      var2.setBackgroundPaint(Color.red);
      var2.setPaint(Color.white);
      var1.setTitle(var2);
      CategoryPlot var3 = (CategoryPlot)var1.getPlot();
      ValueAxis var4 = var3.getRangeAxis();
      var4.setRange(0.0D, 4.0D);
      var4.setVisible(false);
      ExtendedCategoryAxis var5 = new ExtendedCategoryAxis((String)null);
      var5.setTickLabelFont(new Font("SansSerif", 1, 12));
      var5.setCategoryMargin(0.3D);
      var5.addSubLabel("Sm.", "(10)");
      var5.addSubLabel("Med.", "(10)");
      var5.addSubLabel("Lg.", "(10)");
      var5.addSubLabel("All", "(10)");
      CategoryLabelPositions var6 = var5.getCategoryLabelPositions();
      CategoryLabelPosition var7 = new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT);
      var5.setCategoryLabelPositions(CategoryLabelPositions.replaceLeftPosition(var6, var7));
      var3.setDomainAxis(var5);
      BarRenderer var8 = (BarRenderer)var3.getRenderer();
      var8.setSeriesPaint(0, new Color(156, 164, 74));
      var8.setDrawBarOutline(false);
      StandardCategoryItemLabelGenerator var9 = new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.00"));
      var8.setBaseItemLabelGenerator(var9);
      var8.setBaseItemLabelsVisible(true);
      var8.setBaseItemLabelFont(new Font("SansSerif", 0, 18));
      ItemLabelPosition var10 = new ItemLabelPosition(ItemLabelAnchor.INSIDE3, TextAnchor.CENTER_RIGHT);
      var8.setBasePositiveItemLabelPosition(var10);
      var8.setPositiveItemLabelPositionFallback(new ItemLabelPosition());
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      SurveyResultsDemo3 var1 = new SurveyResultsDemo3("Survey Results Demo 3");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
