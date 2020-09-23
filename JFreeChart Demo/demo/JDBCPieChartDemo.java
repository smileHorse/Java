package demo;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class JDBCPieChartDemo extends ApplicationFrame {

   public JDBCPieChartDemo(String var1) {
      super(var1);
      PieDataset var2 = this.readData();
      JFreeChart var3 = ChartFactory.createPieChart("JDBC Pie Chart Demo", var2, true, true, false);
      var3.setBackgroundPaint(Color.yellow);
      PiePlot var4 = (PiePlot)var3.getPlot();
      var4.setNoDataMessage("No data available");
      ChartPanel var5 = new ChartPanel(var3);
      this.setContentPane(var5);
   }

   private PieDataset readData() {
      JDBCPieDataset var1 = null;
      String var2 = "jdbc:postgresql://nomad/jfreechartdb";

      try {
         Class.forName("org.postgresql.Driver");
      } catch (ClassNotFoundException var7) {
         System.err.print("ClassNotFoundException: ");
         System.err.println(var7.getMessage());
      }

      try {
         Connection var3 = DriverManager.getConnection(var2, "jfreechart", "password");
         var1 = new JDBCPieDataset(var3);
         String var4 = "SELECT * FROM PIEDATA1;";
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
      JDBCPieChartDemo var1 = new JDBCPieChartDemo("JDBC Pie Chart Demo");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
