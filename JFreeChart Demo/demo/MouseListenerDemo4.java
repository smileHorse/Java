package demo;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class MouseListenerDemo4 extends ApplicationFrame implements ChartMouseListener {

   private JFreeChart chart;
   private ChartPanel chartPanel;


   public MouseListenerDemo4(String var1) {
      super(var1);
      String var2 = "Mouse Listener Demo 4";
      XYDataset var3 = this.createDataset();
      this.chart = ChartFactory.createXYLineChart(var2, "X", "Y", var3, PlotOrientation.VERTICAL, true, true, false);
      XYPlot var4 = (XYPlot)this.chart.getPlot();
      var4.setDomainPannable(true);
      var4.setRangePannable(true);
      this.chartPanel = new ChartPanel(this.chart);
      this.chartPanel.setMouseWheelEnabled(true);
      this.chartPanel.setPreferredSize(new Dimension(500, 270));
      this.chartPanel.setMouseZoomable(true);
      this.chartPanel.addChartMouseListener(this);
      this.setContentPane(this.chartPanel);
   }

   public XYDataset createDataset() {
      XYSeries var1 = new XYSeries("Series 1");
      var1.add(12.5D, 11.0D);
      var1.add(15.0D, 9.3D);
      var1.add(20.0D, 21.0D);
      XYSeriesCollection var2 = new XYSeriesCollection();
      var2.addSeries(var1);
      return var2;
   }

   public void chartMouseClicked(ChartMouseEvent var1) {
      int var2 = var1.getTrigger().getX();
      int var3 = var1.getTrigger().getY();
      System.out.println("x = " + var2 + ", y = " + var3);
      Point2D var4 = this.chartPanel.translateScreenToJava2D(new Point(var2, var3));
      XYPlot var5 = (XYPlot)this.chart.getPlot();
      ChartRenderingInfo var6 = this.chartPanel.getChartRenderingInfo();
      Rectangle2D var7 = var6.getPlotInfo().getDataArea();
      ValueAxis var8 = var5.getDomainAxis();
      RectangleEdge var9 = var5.getDomainAxisEdge();
      ValueAxis var10 = var5.getRangeAxis();
      RectangleEdge var11 = var5.getRangeAxisEdge();
      double var12 = var8.java2DToValue(var4.getX(), var7, var9);
      double var14 = var10.java2DToValue(var4.getY(), var7, var11);
      System.out.println("Chart: x = " + var12 + ", y = " + var14);
   }

   public void chartMouseMoved(ChartMouseEvent var1) {}

   public static void main(String[] var0) {
      MouseListenerDemo4 var1 = new MouseListenerDemo4("JFreeChart: MouseListenerDemo4.java");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
