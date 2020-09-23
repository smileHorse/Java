package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.TitleAnchor;
import com.orsoncharts.data.PieDataset3D;
import com.orsoncharts.data.StandardPieDataset3D;
import com.orsoncharts.label.StandardPieLabelGenerator;
import com.orsoncharts.plot.PiePlot3D;

public class PieChart3D2 {

   public static PieDataset3D createDataset() {
      StandardPieDataset3D var0 = new StandardPieDataset3D();
      var0.add("United States", Math.random() * 30.0D);
      var0.add("France", Math.random() * 20.0D);
      var0.add("New Zealand", Math.random() * 12.0D);
      var0.add("United Kingdom", Math.random() * 43.0D);
      var0.add("Australia", Math.random() * 43.0D);
      var0.add("Canada", Math.random() * 43.0D);
      return var0;
   }

   public static Chart3D createChart(PieDataset3D var0) {
      Chart3D var1 = Chart3DFactory.createPieChart("Orson Charts 3D", "For more info see: http://www.object-refinery.com/orsoncharts/", createDataset());
      var1.setTitleAnchor(TitleAnchor.TOP_LEFT);
      PiePlot3D var2 = (PiePlot3D)var1.getPlot();
      var2.setLegendLabelGenerator(new StandardPieLabelGenerator("%s (%3$,.0f%%)"));
      var2.setSectionLabelGenerator(new StandardPieLabelGenerator("%s (%3$,.0f%%)"));
      var2.setSectionColors(Colors.createFancyLightColors());
      return var1;
   }
}
