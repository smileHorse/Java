package demo;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class JDBCCategoryChartDemo extends ApplicationFrame {

   public JDBCCategoryChartDemo(String var1) {
      super(var1);
      CategoryDataset var2 = this.readData();
      JFreeChart var3 = ChartFactory.createBarChart3D("JDBC Category Chart Demo", "Category", "Value", var2, PlotOrientation.VERTICAL, true, true, false);
      var3.setBackgroundPaint(Color.yellow);
      ChartPanel var4 = new ChartPanel(var3);
      this.setContentPane(var4);
   }

   private CategoryDataset readData() {
      JDBCCategoryDataset var1 = null;
      String var2 = "jdbc:postgresql://localhost/jfreechartdb";

      try {
         Class.forName("org.postgresql.Driver");
      } catch (ClassNotFoundException var7) {
         System.err.print("ClassNotFoundException: ");
         System.err.println(var7.getMessage());
      }

      try {
         Connection var3 = DriverManager.getConnection(var2, "jfreechart", "password");
         var1 = new JDBCCategoryDataset(var3);
         String var4 = "SELECT * FROM CATEGORYDATA1;";
         System.out.println("Once...");
         var1.executeQuery(var4);
         System.out.println("Again...");
         var1.executeQuery(var4);
         System.out.println("Done.");
         var3.close();
      } catch (SQLException var5) {
         System.err.print("SQLException: ");
         System.err.println(var5.getMessage());
      } catch (Exception var6) {
         System.err.print("Exception: ");
         System.err.println(var6.getMessage());
      }

      return var1;
   }

   public static void main(String[] var0) {
      JDBCCategoryChartDemo var1 = new JDBCCategoryChartDemo("JDBC Category Chart Demo");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
