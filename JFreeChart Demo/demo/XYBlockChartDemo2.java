package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class XYBlockChartDemo2 extends ApplicationFrame {

   public XYBlockChartDemo2(String var1) {
      super(var1);
      JPanel var2 = createDemoPanel();
      var2.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var2);
   }

   private static JFreeChart createChart(XYZDataset var0) {
      DateAxis var1 = new DateAxis("Date");
      var1.setLowerMargin(0.0D);
      var1.setUpperMargin(0.0D);
      var1.setInverted(true);
      NumberAxis var2 = new NumberAxis("Hour");
      var2.setUpperMargin(0.0D);
      var2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      XYBlockRenderer var3 = new XYBlockRenderer();
      var3.setBlockWidth(8.64E7D);
      var3.setBlockAnchor(RectangleAnchor.BOTTOM_LEFT);
      LookupPaintScale var4 = new LookupPaintScale(0.5D, 4.5D, Color.white);
      var4.add(0.5D, Color.red);
      var4.add(1.5D, Color.green);
      var4.add(2.5D, Color.blue);
      var4.add(3.5D, Color.yellow);
      var3.setPaintScale(var4);
      XYPlot var5 = new XYPlot(var0, var1, var2, var3);
      var5.setOrientation(PlotOrientation.HORIZONTAL);
      var5.setBackgroundPaint(Color.lightGray);
      var5.setRangeGridlinePaint(Color.white);
      var5.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
      JFreeChart var6 = new JFreeChart("XYBlockChartDemo2", var5);
      var6.removeLegend();
      var6.setBackgroundPaint(Color.white);
      SymbolAxis var7 = new SymbolAxis((String)null, new String[]{"", "Unavailable", "Free", "Group 1", "Group 2"});
      var7.setRange(0.5D, 4.5D);
      var7.setPlot(new PiePlot());
      var7.setGridBandsVisible(false);
      PaintScaleLegend var8 = new PaintScaleLegend(var4, var7);
      var8.setMargin(new RectangleInsets(3.0D, 10.0D, 3.0D, 10.0D));
      var8.setPosition(RectangleEdge.BOTTOM);
      var8.setAxisOffset(5.0D);
      var6.addSubtitle(var8);
      ChartUtilities.applyCurrentTheme(var6);
      return var6;
   }

   private static XYZDataset createDataset() {
      double[] var0 = new double[2400];
      double[] var1 = new double[2400];
      double[] var2 = new double[2400];
      Object var3 = new Day();

      for(int var4 = 0; var4 < 100; ++var4) {
         double var5 = 1.0D;

         for(int var7 = 0; var7 < 24; ++var7) {
            if(Math.random() < 0.1D) {
               var5 = Math.random() * 4.0D;
            }

            var0[var4 * 24 + var7] = (double)((RegularTimePeriod)var3).getFirstMillisecond();
            var1[var4 * 24 + var7] = (double)var7;
            var2[var4 * 24 + var7] = var5;
         }

         var3 = ((RegularTimePeriod)var3).next();
      }

      DefaultXYZDataset var8 = new DefaultXYZDataset();
      var8.addSeries("Series 1", new double[][]{var0, var1, var2});
      return var8;
   }

   public static JPanel createDemoPanel() {
      return new ChartPanel(createChart(createDataset()));
   }

   public static void main(String[] var0) {
      XYBlockChartDemo2 var1 = new XYBlockChartDemo2("Block Chart Demo 2");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
