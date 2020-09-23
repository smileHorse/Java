package demo;

import java.awt.Dimension;
import java.text.DateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class EventFrequencyDemo1 extends ApplicationFrame {

   public EventFrequencyDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart("Event Frequency Demo", "Category", "Value", var0, PlotOrientation.HORIZONTAL, true, true, false);
      CategoryPlot var2 = (CategoryPlot)var1.getPlot();
      var2.setRangePannable(true);
      var2.getDomainAxis().setMaximumCategoryLabelWidthRatio(10.0F);
      var2.setRangeAxis(new DateAxis("Date"));
      StandardCategoryToolTipGenerator var3 = new StandardCategoryToolTipGenerator("{0}, {1} : {2}", DateFormat.getDateInstance());
      LineAndShapeRenderer var4 = new LineAndShapeRenderer(false, true);
      var4.setBaseToolTipGenerator(var3);
      var2.setRenderer(var4);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      Day var1 = new Day(12, 6, 2002);
      Day var2 = new Day(14, 6, 2002);
      Day var3 = new Day(15, 6, 2002);
      Day var4 = new Day(10, 7, 2002);
      Day var5 = new Day(20, 7, 2002);
      Day var6 = new Day(22, 8, 2002);
      var0.setValue(new Long(var1.getMiddleMillisecond()), "Series 1", "Requirement 1");
      var0.setValue(new Long(var1.getMiddleMillisecond()), "Series 1", "Requirement 2");
      var0.setValue(new Long(var2.getMiddleMillisecond()), "Series 1", "Requirement 3");
      var0.setValue(new Long(var3.getMiddleMillisecond()), "Series 2", "Requirement 1");
      var0.setValue(new Long(var4.getMiddleMillisecond()), "Series 2", "Requirement 3");
      var0.setValue(new Long(var5.getMiddleMillisecond()), "Series 3", "Requirement 2");
      var0.setValue(new Long(var6.getMiddleMillisecond()), "Series 1", "Requirement 4");
      return var0;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      EventFrequencyDemo1 var1 = new EventFrequencyDemo1("JFreeChart: EventFrequencyDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
