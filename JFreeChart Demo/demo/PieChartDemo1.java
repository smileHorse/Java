package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Stroke;
import java.awt.geom.Point2D.Float;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo1 extends ApplicationFrame {

   private static final long serialVersionUID = 1L;


   public PieChartDemo1(String var1) {
      super(var1);
      ChartFactory.setChartTheme(new StandardChartTheme("JFree/Shadow", true));
      this.setContentPane(createDemoPanel());
   }

   private static PieDataset createDataset() {
      DefaultPieDataset var0 = new DefaultPieDataset();
      var0.setValue("Samsung", new Double(27.8D));
      var0.setValue("Others", new Double(55.3D));
      var0.setValue("Nokia", new Double(16.8D));
      var0.setValue("Apple", new Double(17.1D));
      return var0;
   }

   private static JFreeChart createChart(PieDataset var0) {
      JFreeChart var1 = ChartFactory.createPieChart("Smart Phones Manufactured / Q3 2011", var0, false, true, false);
      var1.setBackgroundPaint(new GradientPaint(new Point(0, 0), new Color(20, 20, 20), new Point(400, 200), Color.DARK_GRAY));
      TextTitle var2 = var1.getTitle();
      var2.setHorizontalAlignment(HorizontalAlignment.LEFT);
      var2.setPaint(new Color(240, 240, 240));
      var2.setFont(new Font("Arial", 1, 26));
      PiePlot var3 = (PiePlot)var1.getPlot();
      var3.setBackgroundPaint((Paint)null);
      var3.setInteriorGap(0.04D);
      var3.setOutlineVisible(false);
      var3.setSectionPaint("Others", createGradientPaint(new Color(200, 200, 255), Color.BLUE));
      var3.setSectionPaint("Samsung", createGradientPaint(new Color(255, 200, 200), Color.RED));
      var3.setSectionPaint("Apple", createGradientPaint(new Color(200, 255, 200), Color.GREEN));
      var3.setSectionPaint("Nokia", createGradientPaint(new Color(200, 255, 200), Color.YELLOW));
      var3.setBaseSectionOutlinePaint(Color.WHITE);
      var3.setSectionOutlinesVisible(true);
      var3.setBaseSectionOutlineStroke(new BasicStroke(2.0F));
      var3.setLabelFont(new Font("Courier New", 1, 20));
      var3.setLabelLinkPaint(Color.WHITE);
      var3.setLabelLinkStroke(new BasicStroke(2.0F));
      var3.setLabelOutlineStroke((Stroke)null);
      var3.setLabelPaint(Color.WHITE);
      var3.setLabelBackgroundPaint((Paint)null);
      TextTitle var4 = new TextTitle("Source: http://www.bbc.co.uk/news/business-15489523", new Font("Courier New", 0, 12));
      var4.setPaint(Color.WHITE);
      var4.setPosition(RectangleEdge.BOTTOM);
      var4.setHorizontalAlignment(HorizontalAlignment.RIGHT);
      var1.addSubtitle(var4);
      return var1;
   }

   private static RadialGradientPaint createGradientPaint(Color var0, Color var1) {
      Float var2 = new Float(0.0F, 0.0F);
      float var3 = 200.0F;
      float[] var4 = new float[]{0.0F, 1.0F};
      return new RadialGradientPaint(var2, var3, var4, new Color[]{var0, var1});
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      var0.setPadding(new RectangleInsets(4.0D, 8.0D, 2.0D, 2.0D));
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      var1.setPreferredSize(new Dimension(600, 300));
      return var1;
   }

   public static void main(String[] var0) {
      PieChartDemo1 var1 = new PieChartDemo1("JFreeChart: Pie Chart Demo 1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
