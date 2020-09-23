package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.axis.LabelOrientation;
import com.orsoncharts.axis.StandardCategoryAxis3D;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.label.StandardCategoryItemLabelGenerator;
import com.orsoncharts.label.StandardCategoryLabelGenerator;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.renderer.category.StackedBarRenderer3D;
import com.orsoncharts.table.StandardRectanglePainter;
import com.orsoncharts.util.Fit2D;
import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;

public class StackedBarChart3D3 {

   public static Chart3D createChart(CategoryDataset3D var0) {
      Chart3D var1 = Chart3DFactory.createStackedBarChart("The Sinking of the Titanic", "Survival data for 2,201 passengers", var0, (String)null, "Class", "Passengers");
      URL var2 = StackedBarChart3D3.class.getResource("iStock_000003105870Small.jpg");
      ImageIcon var3 = new ImageIcon(var2);
      StandardRectanglePainter var4 = new StandardRectanglePainter(Color.WHITE, var3.getImage(), Fit2D.SCALE_TO_FIT_TARGET);
      var1.setBackground(var4);
      var1.setChartBoxColor(new Color(255, 255, 255, 155));
      CategoryPlot3D var5 = (CategoryPlot3D)var1.getPlot();
      var5.setLegendLabelGenerator(new StandardCategoryLabelGenerator("%s (%3$,.0f)"));
      var5.setToolTipGenerator(new StandardCategoryItemLabelGenerator("%s, %s, %s = %4$.0f"));
      StandardCategoryAxis3D var6 = (StandardCategoryAxis3D)var5.getRowAxis();
      var6.setTickLabelGenerator(new StandardCategoryLabelGenerator("%s (%3$,.0f)"));
      StandardCategoryAxis3D var7 = (StandardCategoryAxis3D)var5.getColumnAxis();
      var7.setTickLabelGenerator(new StandardCategoryLabelGenerator("%s (%3$,.0f)"));
      var7.setTickLabelOrientation(LabelOrientation.PARALLEL);
      var7.setMaxTickLabelLevels(2);
      StackedBarRenderer3D var8 = (StackedBarRenderer3D)var5.getRenderer();
      var8.setColors(Colors.createIceCubeColors());
      return var1;
   }

   public static CategoryDataset3D createDataset() {
      StandardCategoryDataset3D var0 = new StandardCategoryDataset3D();
      var0.addValue(Integer.valueOf(146), "Survivors", "Women/Children", "1st");
      var0.addValue(Integer.valueOf(104), "Survivors", "Women/Children", "2nd");
      var0.addValue(Integer.valueOf(103), "Survivors", "Women/Children", "3rd");
      var0.addValue(Integer.valueOf(20), "Survivors", "Women/Children", "Crew");
      var0.addValue(Integer.valueOf(57), "Survivors", "Men", "1st");
      var0.addValue(Integer.valueOf(14), "Survivors", "Men", "2nd");
      var0.addValue(Integer.valueOf(75), "Survivors", "Men", "3rd");
      var0.addValue(Integer.valueOf(192), "Survivors", "Men", "Crew");
      var0.addValue(Integer.valueOf(4), "Victims", "Women/Children", "1st");
      var0.addValue(Integer.valueOf(13), "Victims", "Women/Children", "2nd");
      var0.addValue(Integer.valueOf(141), "Victims", "Women/Children", "3rd");
      var0.addValue(Integer.valueOf(3), "Victims", "Women/Children", "Crew");
      var0.addValue(Integer.valueOf(118), "Victims", "Men", "1st");
      var0.addValue(Integer.valueOf(154), "Victims", "Men", "2nd");
      var0.addValue(Integer.valueOf(387), "Victims", "Men", "3rd");
      var0.addValue(Integer.valueOf(670), "Victims", "Men", "Crew");
      return var0;
   }
}
