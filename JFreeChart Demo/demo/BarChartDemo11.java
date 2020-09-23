package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo11 extends ApplicationFrame {

   public BarChartDemo11(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static CategoryDataset createDataset() {
      DefaultCategoryDataset var0 = new DefaultCategoryDataset();
      var0.addValue(33.0D, "S1", "GNU General Public License (GPL) 2.0");
      var0.addValue(13.0D, "S1", "Apache License 2.0");
      var0.addValue(12.0D, "S1", "GNU General Public License (GPL) 3.0");
      var0.addValue(11.0D, "S1", "MIT License");
      var0.addValue(7.0D, "S1", "BSD License 2.0");
      var0.addValue(6.0D, "S1", "Artistic Licence (Perl)");
      var0.addValue(6.0D, "S1", "GNU Lesser General Public License (LGPL) 2.1");
      var0.addValue(3.0D, "S1", "GNU Lesser General Public License (LGPL) 3.0");
      var0.addValue(2.0D, "S1", "Eclipse Public License");
      var0.addValue(1.0D, "S1", "Code Project 1.02 License");
      return var0;
   }

   private static JFreeChart createChart(CategoryDataset var0) {
      JFreeChart var1 = ChartFactory.createBarChart("Open Source Projects By License", "License", "Percent", var0);
      var1.removeLegend();
      TextTitle var2 = new TextTitle("Source: http://www.blackducksoftware.com/resources/data/top-20-licenses (as at 30 Aug 2013)", new Font("Dialog", 0, 9));
      var2.setPosition(RectangleEdge.BOTTOM);
      var1.addSubtitle(var2);
      CategoryPlot var3 = (CategoryPlot)var1.getPlot();
      var3.setOrientation(PlotOrientation.HORIZONTAL);
      var3.setDomainGridlinesVisible(true);
      var3.getDomainAxis().setMaximumCategoryLabelWidthRatio(0.8F);
      NumberAxis var4 = (NumberAxis)var3.getRangeAxis();
      var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      BarRenderer var5 = (BarRenderer)var3.getRenderer();
      var5.setDrawBarOutline(false);
      StandardCategoryToolTipGenerator var6 = new StandardCategoryToolTipGenerator("{1}: {2} percent", new DecimalFormat("0"));
      var5.setBaseToolTipGenerator(var6);
      GradientPaint var7 = new GradientPaint(0.0F, 0.0F, Color.BLUE, 0.0F, 0.0F, new Color(0, 0, 64));
      var5.setSeriesPaint(0, var7);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      BarChartDemo11 var1 = new BarChartDemo11("JFreeChart: BarChartDemo11.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
