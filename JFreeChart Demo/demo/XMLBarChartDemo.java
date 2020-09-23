package demo;

import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xml.DatasetReader;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XMLBarChartDemo extends ApplicationFrame {

   public XMLBarChartDemo(String var1) {
      super(var1);
      CategoryDataset var2 = null;
      URL var3 = this.getClass().getResource("/demo/categorydata.xml");

      try {
         InputStream var4 = var3.openStream();
         var2 = DatasetReader.readCategoryDatasetFromXML(var4);
      } catch (IOException var6) {
         var6.printStackTrace();
      }

      JFreeChart var7 = ChartFactory.createBarChart("Bar Chart", "Domain", "Range", var2, PlotOrientation.VERTICAL, true, true, false);
      ChartPanel var5 = new ChartPanel(var7);
      var5.setPreferredSize(new Dimension(500, 270));
      this.setContentPane(var5);
   }

   public static void main(String[] var0) {
      XMLBarChartDemo var1 = new XMLBarChartDemo("XML Bar Chart Demo");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
