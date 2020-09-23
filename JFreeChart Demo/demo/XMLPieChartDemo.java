package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.NumberFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xml.DatasetReader;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XMLPieChartDemo extends ApplicationFrame {

   public XMLPieChartDemo(String var1) {
      super(var1);
      PieDataset var2 = null;
      URL var3 = this.getClass().getResource("/org/jfree/chart/demo/piedata.xml");

      try {
         InputStream var4 = var3.openStream();
         var2 = DatasetReader.readPieDatasetFromXML(var4);
      } catch (IOException var7) {
         System.out.println(var7.getMessage());
      }

      JFreeChart var8 = ChartFactory.createPieChart("Pie Chart Demo 1", var2, true, true, false);
      var8.setBackgroundPaint(Color.yellow);
      PiePlot var5 = (PiePlot)var8.getPlot();
      var5.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
      var5.setNoDataMessage("No data available");
      ChartPanel var6 = new ChartPanel(var8);
      var6.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var6);
   }

   public static void main(String[] var0) {
      XMLPieChartDemo var1 = new XMLPieChartDemo("XML Pie Chart Demo");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
