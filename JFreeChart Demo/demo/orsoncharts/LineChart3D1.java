package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.axis.NumberAxis3D;
import com.orsoncharts.axis.NumberTickSelector;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.KeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.plot.CategoryPlot3D;

public class LineChart3D1 {

   public static Chart3D createChart(CategoryDataset3D var0) {
      Chart3D var1 = Chart3DFactory.createLineChart("Web Browser Market Share", "Source: http://gs.statcounter.com", var0, (String)null, (String)null, "Market Share (%)");
      CategoryPlot3D var2 = (CategoryPlot3D)var1.getPlot();
      var2.setDimensions(new Dimension3D(18.0D, 8.0D, 4.0D));
      var2.getRowAxis().setVisible(false);
      NumberAxis3D var3 = (NumberAxis3D)var2.getValueAxis();
      var3.setTickSelector(new NumberTickSelector(true));
      var2.getRenderer().setColors(Colors.createFancyDarkColors());
      var1.setViewPoint(ViewPoint3D.createAboveViewPoint(30.0D));
      return var1;
   }

   public static CategoryDataset3D createDataset() {
      StandardCategoryDataset3D var0 = new StandardCategoryDataset3D();
      var0.addSeriesAsRow("Safari", createSafariData());
      var0.addSeriesAsRow("Firefox", createFirefoxData());
      var0.addSeriesAsRow("Internet Explorer", createInternetExplorerData());
      var0.addSeriesAsRow("Chrome", createChromeData());
      return var0;
   }

   private static KeyedValues<Double> createChromeData() {
      DefaultKeyedValues var0 = new DefaultKeyedValues();
      var0.put("Jan-12", Double.valueOf(0.284D));
      var0.put("Feb-12", Double.valueOf(0.2984D));
      var0.put("Mar-12", Double.valueOf(0.3087D));
      var0.put("Apr-12", Double.valueOf(0.3123D));
      var0.put("May-12", Double.valueOf(0.3243D));
      var0.put("Jun-12", Double.valueOf(0.3276D));
      var0.put("Jul-12", Double.valueOf(0.3381D));
      var0.put("Aug-12", Double.valueOf(0.3359D));
      var0.put("Sep-12", Double.valueOf(0.3421D));
      var0.put("Oct-12", Double.valueOf(0.3477D));
      var0.put("Nov-12", Double.valueOf(0.3572D));
      var0.put("Dec-12", Double.valueOf(0.3642D));
      var0.put("Jan-13", Double.valueOf(0.3652D));
      var0.put("Feb-13", Double.valueOf(0.3709D));
      var0.put("Mar-13", Double.valueOf(0.3807D));
      var0.put("Apr-13", Double.valueOf(0.3915D));
      var0.put("May-13", Double.valueOf(0.4138D));
      var0.put("Jun-13", Double.valueOf(0.4268D));
      return var0;
   }

   private static KeyedValues<Double> createFirefoxData() {
      DefaultKeyedValues var0 = new DefaultKeyedValues();
      var0.put("Jan-12", Double.valueOf(0.2478D));
      var0.put("Feb-12", Double.valueOf(0.2488D));
      var0.put("Mar-12", Double.valueOf(0.2498D));
      var0.put("Apr-12", Double.valueOf(0.2487D));
      var0.put("May-12", Double.valueOf(0.2555D));
      var0.put("Jun-12", Double.valueOf(0.2456D));
      var0.put("Jul-12", Double.valueOf(0.2373D));
      var0.put("Aug-12", Double.valueOf(0.2285D));
      var0.put("Sep-12", Double.valueOf(0.224D));
      var0.put("Oct-12", Double.valueOf(0.2232D));
      var0.put("Nov-12", Double.valueOf(0.2237D));
      var0.put("Dec-12", Double.valueOf(0.2189D));
      var0.put("Jan-13", Double.valueOf(0.2142D));
      var0.put("Feb-13", Double.valueOf(0.2134D));
      var0.put("Mar-13", Double.valueOf(0.2087D));
      var0.put("Apr-13", Double.valueOf(0.2006D));
      var0.put("May-13", Double.valueOf(0.1976D));
      var0.put("Jun-13", Double.valueOf(0.2001D));
      return var0;
   }

   private static KeyedValues<Double> createInternetExplorerData() {
      DefaultKeyedValues var0 = new DefaultKeyedValues();
      var0.put("Jan-12", Double.valueOf(0.3745D));
      var0.put("Feb-12", Double.valueOf(0.3575D));
      var0.put("Mar-12", Double.valueOf(0.3481D));
      var0.put("Apr-12", Double.valueOf(0.3407D));
      var0.put("May-12", Double.valueOf(0.3212D));
      var0.put("Jun-12", Double.valueOf(0.3231D));
      var0.put("Jul-12", Double.valueOf(0.3204D));
      var0.put("Aug-12", Double.valueOf(0.3285D));
      var0.put("Sep-12", Double.valueOf(0.327D));
      var0.put("Oct-12", Double.valueOf(0.3208D));
      var0.put("Nov-12", Double.valueOf(0.3123D));
      var0.put("Dec-12", Double.valueOf(0.3078D));
      var0.put("Jan-13", Double.valueOf(0.3069D));
      var0.put("Feb-13", Double.valueOf(0.2982D));
      var0.put("Mar-13", Double.valueOf(0.293D));
      var0.put("Jun-13", Double.valueOf(0.2544D));
      var0.put("May-13", Double.valueOf(0.2772D));
      var0.put("Apr-13", Double.valueOf(0.2971D));
      return var0;
   }

   private static KeyedValues<Double> createSafariData() {
      DefaultKeyedValues var0 = new DefaultKeyedValues();
      var0.put("Jan-12", Double.valueOf(0.0662D));
      var0.put("Feb-12", Double.valueOf(0.0677D));
      var0.put("Mar-12", Double.valueOf(0.0672D));
      var0.put("Apr-12", Double.valueOf(0.0713D));
      var0.put("May-12", Double.valueOf(0.0709D));
      var0.put("Jun-12", Double.valueOf(0.07D));
      var0.put("Jul-12", Double.valueOf(0.0712D));
      var0.put("Aug-12", Double.valueOf(0.0739D));
      var0.put("Sep-12", Double.valueOf(0.077D));
      var0.put("Oct-12", Double.valueOf(0.0781D));
      var0.put("Nov-12", Double.valueOf(0.0783D));
      var0.put("Dec-12", Double.valueOf(0.0792D));
      var0.put("Jan-13", Double.valueOf(0.083D));
      var0.put("Feb-13", Double.valueOf(0.086D));
      var0.put("Mar-13", Double.valueOf(0.085D));
      var0.put("Apr-13", Double.valueOf(0.08D));
      var0.put("May-13", Double.valueOf(0.0796D));
      var0.put("Jun-13", Double.valueOf(0.0839D));
      return var0;
   }
}
