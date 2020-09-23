package demo;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class AnnotationDemo2 extends ApplicationFrame {

   public AnnotationDemo2(String var1) {
      super(var1);
      this.setContentPane(createDemoPanel());
   }

   private static XYDataset createDataset1() {
      XYSeries var0 = new XYSeries("Random Data 1");
      var0.add(1.0D, 181.8D);
      var0.add(2.0D, 167.3D);
      var0.add(3.0D, 153.8D);
      var0.add(4.0D, 167.6D);
      var0.add(5.0D, 158.8D);
      var0.add(6.0D, 148.3D);
      var0.add(7.0D, 153.9D);
      var0.add(8.0D, 142.7D);
      var0.add(9.0D, 123.2D);
      var0.add(10.0D, 131.8D);
      var0.add(11.0D, 139.6D);
      var0.add(12.0D, 142.9D);
      var0.add(13.0D, 138.7D);
      var0.add(14.0D, 137.3D);
      var0.add(15.0D, 143.9D);
      var0.add(16.0D, 139.8D);
      var0.add(17.0D, 137.0D);
      var0.add(18.0D, 132.8D);
      XYSeriesCollection var1 = new XYSeriesCollection();
      var1.addSeries(var0);
      return var1;
   }

   private static XYDataset createDataset2() {
      XYSeries var0 = new XYSeries("Random Data 2");
      var0.add(1.0D, 429.6D);
      var0.add(2.0D, 323.2D);
      var0.add(3.0D, 417.2D);
      var0.add(4.0D, 624.1D);
      var0.add(5.0D, 422.6D);
      var0.add(6.0D, 619.2D);
      var0.add(7.0D, 416.5D);
      var0.add(8.0D, 512.7D);
      var0.add(9.0D, 501.5D);
      var0.add(10.0D, 306.1D);
      var0.add(11.0D, 410.3D);
      var0.add(12.0D, 511.7D);
      var0.add(13.0D, 611.0D);
      var0.add(14.0D, 709.6D);
      var0.add(15.0D, 613.2D);
      var0.add(16.0D, 711.6D);
      var0.add(17.0D, 708.8D);
      var0.add(18.0D, 501.6D);
      XYSeriesCollection var1 = new XYSeriesCollection();
      var1.addSeries(var0);
      return var1;
   }

   private static JFreeChart createChart() {
      XYDataset var0 = createDataset1();
      JFreeChart var1 = ChartFactory.createXYLineChart("Annotation Demo 2", "Date", "Price Per Unit", var0);
      var1.removeLegend();
      XYPlot var2 = (XYPlot)var1.getPlot();
      var2.setDomainPannable(true);
      var2.setRangePannable(true);
      NumberAxis var3 = (NumberAxis)var2.getRangeAxis();
      var3.setAutoRangeIncludesZero(false);
      NumberAxis var4 = new NumberAxis("Secondary");
      var4.setAutoRangeIncludesZero(false);
      var2.setRangeAxis(1, var4);
      var2.setDataset(1, createDataset2());
      var2.mapDatasetToRangeAxis(1, 1);
      XYLineAndShapeRenderer var5 = (XYLineAndShapeRenderer)var2.getRenderer();
      var5.setBaseToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
      var5.setBaseShapesVisible(true);
      var5.setBaseShapesFilled(true);
      XYPointerAnnotation var6 = new XYPointerAnnotation("Annotation 1 (2.0, 167.3)", 2.0D, 167.3D, -0.7853981633974483D);
      var6.setTextAnchor(TextAnchor.BOTTOM_LEFT);
      var6.setPaint(Color.red);
      var6.setArrowPaint(Color.red);
      var5.addAnnotation(var6);
      XYLineAndShapeRenderer var7 = new XYLineAndShapeRenderer(true, true);
      var7.setSeriesPaint(0, Color.black);
      var5.setBaseToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
      XYPointerAnnotation var8 = new XYPointerAnnotation("Annotation 2 (15.0, 613.2)", 15.0D, 613.2D, 1.5707963267948966D);
      var8.setTextAnchor(TextAnchor.TOP_CENTER);
      var7.addAnnotation(var8);
      var2.setRenderer(1, var7);
      LegendTitle var9 = new LegendTitle(var5);
      LegendTitle var10 = new LegendTitle(var7);
      BlockContainer var11 = new BlockContainer(new BorderArrangement());
      var11.add(var9, RectangleEdge.LEFT);
      var11.add(var10, RectangleEdge.RIGHT);
      var11.add(new EmptyBlock(2000.0D, 0.0D));
      CompositeTitle var12 = new CompositeTitle(var11);
      var12.setFrame(new BlockBorder(Color.red));
      var12.setBackgroundPaint(Color.LIGHT_GRAY);
      var12.setPosition(RectangleEdge.BOTTOM);
      var1.addSubtitle(var12);
      ChartUtilities.applyCurrentTheme(var1);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart();
      ChartPanel var1 = new ChartPanel(var0);
      var1.setMouseWheelEnabled(true);
      return var1;
   }

   public static void main(String[] var0) {
      AnnotationDemo2 var1 = new AnnotationDemo2("JFreeChart: AnnotationDemo2.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
