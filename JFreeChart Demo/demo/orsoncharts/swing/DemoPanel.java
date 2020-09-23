package demo.orsoncharts.swing;

import com.orsoncharts.Chart3DPanel;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class DemoPanel extends JPanel {

   private List<Chart3DPanel> chartPanels = new ArrayList();


   public DemoPanel(LayoutManager var1) {
      super(var1);
   }

   public Chart3DPanel getChartPanel() {
      return this.chartPanels.isEmpty()?null:(Chart3DPanel)this.chartPanels.get(0);
   }

   public List<Chart3DPanel> getChartPanels() {
      return this.chartPanels;
   }

   public void setChartPanel(Chart3DPanel var1) {
      this.chartPanels.clear();
      this.chartPanels.add(var1);
   }

   public void addChartPanel(Chart3DPanel var1) {
      this.chartPanels.add(var1);
   }
}
