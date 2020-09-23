package demo;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.jdbc.JDBCXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class JDBCXYChartDemo extends ApplicationFrame {

   public JDBCXYChartDemo(String var1) {
      super(var1);
      XYDataset var2 = this.readData();
      JFreeChart var3 = ChartFactory.createTimeSeriesChart("JDBC XY Chart Demo", "Date", "Value", var2, true, true, false);
      var3.setBackgroundPaint(Color.yellow);
      ChartPanel var4 = new ChartPanel(var3);
      this.setContentPane(var4);
   }

   private XYDataset readData() {
      JDBCXYDataset var1 = null;
      String var2 = "jdbc:postgresql://nomad/jfreechartdb";

      try {
         Class.forName("org.postgresql.Driver");
      } catch (ClassNotFoundException var7) {
         System.err.print("ClassNotFoundException: ");
         System.err.println(var7.getMessage());
      }

      try {
         Connection var3 = DriverManager.getConnection(var2, "jfreechart", "password");
         var1 = new JDBCXYDataset(var3);
         String var4 = "SELECT * FROM XYDATA1;";
         var1.executeQuery(var4);
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
      JDBCXYChartDemo var1 = new JDBCXYChartDemo("JDBC XY Chart Demo");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
