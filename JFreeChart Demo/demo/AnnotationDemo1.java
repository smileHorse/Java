package demo;

import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class AnnotationDemo1 extends ApplicationFrame {

   public AnnotationDemo1(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(360, 500));
      this.setContentPane(var2);
   }

   private static XYSeriesCollection createDataset() {
      XYSeriesCollection var0 = new XYSeriesCollection();

      try {
         BufferedReader var1 = new BufferedReader(new InputStreamReader(XYSeriesCollection.class.getClassLoader().getResourceAsStream("demo/wtageinf.txt")));
         String var2 = var1.readLine();
         var2 = var1.readLine();
         var2 = var1.readLine();
         var2 = var1.readLine();
         XYSeries var3 = new XYSeries("P3", true, false);
         XYSeries var4 = new XYSeries("P5", true, false);
         XYSeries var5 = new XYSeries("P10", true, false);
         XYSeries var6 = new XYSeries("P25", true, false);
         XYSeries var7 = new XYSeries("P50", true, false);
         XYSeries var8 = new XYSeries("P75", true, false);
         XYSeries var9 = new XYSeries("P90", true, false);
         XYSeries var10 = new XYSeries("P95", true, false);
         XYSeries var11 = new XYSeries("P97", true, false);

         for(var2 = var1.readLine(); var2 != null; var2 = var1.readLine()) {
            int var12 = Integer.parseInt(var2.substring(1, 8).trim());
            float var13 = Float.parseFloat(var2.substring(9, 17).trim());
            float var14 = Float.parseFloat(var2.substring(69, 86).trim());
            float var15 = Float.parseFloat(var2.substring(87, 103).trim());
            float var16 = Float.parseFloat(var2.substring(104, 122).trim());
            float var17 = Float.parseFloat(var2.substring(123, 140).trim());
            float var18 = Float.parseFloat(var2.substring(141, 158).trim());
            float var19 = Float.parseFloat(var2.substring(159, 176).trim());
            float var20 = Float.parseFloat(var2.substring(177, 193).trim());
            float var21 = Float.parseFloat(var2.substring(194, 212).trim());
            float var22 = Float.parseFloat(var2.substring(212, var2.length()).trim());
            if(var12 == 1) {
               var3.add((double)var13, (double)var14);
               var4.add((double)var13, (double)var15);
               var5.add((double)var13, (double)var16);
               var6.add((double)var13, (double)var17);
               var7.add((double)var13, (double)var18);
               var8.add((double)var13, (double)var19);
               var9.add((double)var13, (double)var20);
               var10.add((double)var13, (double)var21);
               var11.add((double)var13, (double)var22);
            }
         }

         var0.addSeries(var3);
         var0.addSeries(var4);
         var0.addSeries(var5);
         var0.addSeries(var6);
         var0.addSeries(var7);
         var0.addSeries(var8);
         var0.addSeries(var9);
         var0.addSeries(var10);
         var0.addSeries(var11);
      } catch (FileNotFoundException var23) {
         System.err.println(var23);
      } catch (IOException var24) {
         System.err.println(var24);
      }

      return var0;
   }

   private static JFreeChart createChart(XYDataset var0) {
      JFreeChart var1 = ChartFactory.createXYLineChart((String)null, "Age in Months", "Weight (kg)", var0);
      TextTitle var2 = new TextTitle("Growth Charts: United States", new Font("SansSerif", 1, 14));
      TextTitle var3 = new TextTitle("Weight-for-age percentiles: boys, birth to 36 months", new Font("SansSerif", 0, 11));
      var1.addSubtitle(var2);
      var1.addSubtitle(var3);
      XYPlot var4 = (XYPlot)var1.getPlot();
      var4.setDomainPannable(true);
      var4.setRangePannable(true);
      NumberAxis var5 = (NumberAxis)var4.getDomainAxis();
      var5.setUpperMargin(0.12D);
      var5.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      NumberAxis var6 = (NumberAxis)var4.getRangeAxis();
      var6.setAutoRangeIncludesZero(false);
      Font var8 = new Font("SansSerif", 0, 9);
      XYTextAnnotation var7 = new XYTextAnnotation("3rd", 36.5D, 11.76D);
      var7.setFont(var8);
      var7.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
      var4.addAnnotation(var7);
      var7 = new XYTextAnnotation("5th", 36.5D, 12.04D);
      var7.setFont(var8);
      var7.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
      var4.addAnnotation(var7);
      var7 = new XYTextAnnotation("10th", 36.5D, 12.493D);
      var7.setFont(var8);
      var7.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
      var4.addAnnotation(var7);
      var7 = new XYTextAnnotation("25th", 36.5D, 13.313D);
      var7.setFont(var8);
      var7.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
      var4.addAnnotation(var7);
      var7 = new XYTextAnnotation("50th", 36.5D, 14.33D);
      var7.setFont(var8);
      var7.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
      var4.addAnnotation(var7);
      var7 = new XYTextAnnotation("75th", 36.5D, 15.478D);
      var7.setFont(var8);
      var7.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
      var4.addAnnotation(var7);
      var7 = new XYTextAnnotation("90th", 36.5D, 16.642D);
      var7.setFont(var8);
      var7.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
      var4.addAnnotation(var7);
      var7 = new XYTextAnnotation("95th", 36.5D, 17.408D);
      var7.setFont(var8);
      var7.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
      var4.addAnnotation(var7);
      var7 = new XYTextAnnotation("97th", 36.5D, 17.936D);
      var7.setFont(var8);
      var7.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
      var4.addAnnotation(var7);
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
      AnnotationDemo1 var1 = new AnnotationDemo1("JFreeChart: AnnotationDemo1.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
