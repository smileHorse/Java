package demo;

import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo5 extends ApplicationFrame {

   public BarChartDemo5(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      String var1 = "Prison Population Rates";
      var0.addValue(59.0D, var1, "Norway");
      var0.addValue(69.0D, var1, "Switzerland");
      var0.addValue(85.0D, var1, "France");
      var0.addValue(93.0D, var1, "Syria");
      var0.addValue(96.0D, var1, "Germany");
      var0.addValue(111.0D, var1, "China");
      var0.addValue(116.0D, var1, "Australia");
      var0.addValue(121.0D, var1, "Egypt");
      var0.addValue(129.0D, var1, "England & Wales");
      var0.addValue(157.0D, var1, "New Zealand");
      var0.addValue(205.0D, var1, "Chile");
      var0.addValue(229.0D, var1, "Iran");
      var0.addValue(359.0D, var1, "Singapore");
      var0.addValue(404.0D, var1, "South Africa");
      var0.addValue(406.0D, var1, "Ukraine");
      var0.addValue(686.0D, var1, "USA");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart("Prison Population Rates - Selected Countries", "Country", "Prisoners Per 100,000 National Population", var0, PlotOrientation.HORIZONTAL, false, true, false);
      var1.addSubtitle(new TextTitle("Source: http://www.homeoffice.gov.uk/rds/pdfs2/r188.pdf", new Font("Dialog", 2, 10)));
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
      var2.setRangePannable(true);
      BarRenderer var3 = (BarRenderer)var2.getRenderer();
      var3.setItemLabelAnchorOffset(9.0D);
      var3.setBaseItemLabelsVisible(true);
      var3.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
      var3.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{0}, {1}) = {2} per 100,000", new DecimalFormat("0")));
      CategoryAxis var4 = var2.getDomainAxis();
      var4.setCategoryMargin(0.25D);
      var4.setUpperMargin(0.02D);
      var4.setLowerMargin(0.02D);
      NumberAxis var5 = (NumberAxis)var2.getRangeAxis();
      var5.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var5.setUpperMargin(0.1D);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      BarChartDemo5 var1 = new BarChartDemo5("JFreeChart: BarChartDemo5.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
