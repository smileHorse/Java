package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class SurveyResultsDemo1 extends ApplicationFrame {

   public SurveyResultsDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(700, 600));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(2.01D, "Results", "Category 1");
      var0.addValue(2.02D, "Results", "Category 2");
      var0.addValue(2.0D, "Results", "Category 3");
      var0.addValue(1.97D, "Results", "Category 4");
      var0.addValue(1.44D, "Results", "Category 5");
      var0.addValue(1.49D, "Results", "Category 6");
      var0.addValue(1.49D, "Results", "Category 7");
      var0.addValue(1.48D, "Results", "Category 8");
      var0.addValue(4.26D, "Results", "Category 9");
      var0.addValue(4.08D, "Results", "Category 10");
      var0.addValue(4.03D, "Results", "Category 11");
      var0.addValue(3.92D, "Results", "Category 12");
      var0.addValue(3.99D, "Results", "Category 13");
      var0.addValue(2.23D, "Results", "Category 14");
      var0.addValue(2.6D, "Results", "Overall");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart((String)null, (String)null, (String)null, var0, PlotOrientation.HORIZONTAL, false, true, false);
      var1.setBackgroundPaint(Color.white);
      TextTitle var2 = new TextTitle("Figure 7 | I. Resources - The site offers users relevant, informative and educational resources");
      var2.setHorizontalAlignment(HorizontalAlignment.LEFT);
      var2.setBackgroundPaint(Color.red);
      var2.setPaint(Color.white);
      var1.setTitle(var2);
      CategoryPlot var3 = (CategoryPlot)var1.getPlot();
      var3.setOutlinePaint((Paint)null);
      var3.setDomainGridlinesVisible(true);
      var3.setDomainGridlinePosition(CategoryAnchor.END);
      var3.setDomainGridlineStroke(new BasicStroke(0.5F));
      var3.setDomainGridlinePaint(Color.black);
      var3.setRangeGridlinesVisible(false);
      var3.clearRangeMarkers();
      CategoryAxis var4 = var3.getDomainAxis();
      var4.setVisible(false);
      var4.setCategoryMargin(0.5D);
      var3.getRangeAxis().setVisible(false);
      BarRenderer var5 = (BarRenderer)var3.getRenderer();
      var5.setSeriesPaint(0, new Color(156, 164, 74));
      var5.setDrawBarOutline(false);
      var5.setBaseItemLabelsVisible(true);
      var5.setBaseItemLabelFont(new Font("SansSerif", 1, 10));
      ItemLabelPosition var6 = new ItemLabelPosition(ItemLabelAnchor.INSIDE3, TextAnchor.CENTER_RIGHT);
      var5.setBasePositiveItemLabelPosition(var6);
      CategoryTextAnnotation var7 = new CategoryTextAnnotation("1. White papers are available.", "Category 1", 0.0D);
      var7.setFont(new Font("SansSerif", 1, 12));
      var7.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var7.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var7);
      CategoryTextAnnotation var8 = new CategoryTextAnnotation("2. White papers enhance users understanding of the firm and its expertise.", "Category 2", 0.0D);
      var8.setFont(new Font("SansSerif", 0, 12));
      var8.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var8.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var8);
      CategoryTextAnnotation var9 = new CategoryTextAnnotation("3. White papers are relevant to the firm\'s prospects and clients.", "Category 3", 0.0D);
      var9.setFont(new Font("SansSerif", 0, 12));
      var9.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var9.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var9);
      CategoryTextAnnotation var10 = new CategoryTextAnnotation("4. White papers are relevant to the firm\'s positioning.", "Category 4", 0.0D);
      var10.setFont(new Font("SansSerif", 0, 12));
      var10.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var10.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var10);
      CategoryTextAnnotation var11 = new CategoryTextAnnotation("5. Case studies are available.", "Category 5", 0.0D);
      var11.setFont(new Font("SansSerif", 1, 12));
      var11.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var11.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var11);
      CategoryTextAnnotation var12 = new CategoryTextAnnotation("6. Case studies enhance users understanding of the firm and its expertise.", "Category 6", 0.0D);
      var12.setFont(new Font("SansSerif", 0, 12));
      var12.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var12.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var12);
      CategoryTextAnnotation var13 = new CategoryTextAnnotation("7. Case studies are relevant to the firm\'s prospects and clients.", "Category 7", 0.0D);
      var13.setFont(new Font("SansSerif", 0, 12));
      var13.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var13.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var13);
      CategoryTextAnnotation var14 = new CategoryTextAnnotation("8. White papers are relevant to the firm\'s positioning.", "Category 8", 0.0D);
      var14.setFont(new Font("SansSerif", 0, 12));
      var14.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var14.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var14);
      CategoryTextAnnotation var15 = new CategoryTextAnnotation("9. Case studies are available.", "Category 9", 0.0D);
      var15.setFont(new Font("SansSerif", 1, 12));
      var15.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var15.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var15);
      CategoryTextAnnotation var16 = new CategoryTextAnnotation("10. Case studies enhance users understanding of the firm and its expertise.", "Category 10", 0.0D);
      var16.setFont(new Font("SansSerif", 0, 12));
      var16.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var16.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var16);
      CategoryTextAnnotation var17 = new CategoryTextAnnotation("11. Case studies are relevant to the firm\'s prospects and clients.", "Category 11", 0.0D);
      var17.setFont(new Font("SansSerif", 0, 12));
      var17.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var17.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var17);
      CategoryTextAnnotation var18 = new CategoryTextAnnotation("12. White papers are relevant to the firm\'s positioning.", "Category 12", 0.0D);
      var18.setFont(new Font("SansSerif", 0, 12));
      var18.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var18.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var18);
      CategoryTextAnnotation var19 = new CategoryTextAnnotation("13. Users can easily access resources based on viewer interest.", "Category 13", 0.0D);
      var19.setFont(new Font("SansSerif", 1, 12));
      var19.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var19.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var19);
      CategoryTextAnnotation var20 = new CategoryTextAnnotation("14. Access to additional hyperlinks enhances users\'s ability to find relevant information.", "Category 14", 0.0D);
      var20.setFont(new Font("SansSerif", 1, 12));
      var20.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var20.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var20);
      CategoryTextAnnotation var21 = new CategoryTextAnnotation("15. OVERALL EFFECTIVENESS.", "Overall", 0.0D);
      var21.setFont(new Font("SansSerif", 1, 12));
      var21.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var21.setCategoryAnchor(CategoryAnchor.START);
      var3.addAnnotation(var21);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      SurveyResultsDemo1 var1 = new SurveyResultsDemo1("Survey Results Demo 1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
