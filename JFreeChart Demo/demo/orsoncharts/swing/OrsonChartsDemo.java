package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.style.ChartStyle;
import com.orsoncharts.style.ChartStyles;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemoComponent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;

public class OrsonChartsDemo extends JFrame implements ActionListener {

   public static final Dimension DEFAULT_CONTENT_SIZE = new Dimension(760, 480);
   private OrsonChartsDemoComponent demoComponent;


   public OrsonChartsDemo(String var1) {
      super(var1);
      this.addWindowListener(new ExitOnClose());
      this.setJMenuBar(this.createMenuBar());
      this.add(this.createContent());
   }

   private JMenuBar createMenuBar() {
      JMenuBar var1 = new JMenuBar();
      var1.add(this.createFileMenu("File"));
      var1.add(this.createStyleMenu("Style"));
      return var1;
   }

   private JMenu createFileMenu(String var1) {
      JMenu var2 = new JMenu(var1);
      JMenuItem var3 = new JMenuItem("Exit");
      var3.setActionCommand("EXIT");
      var3.addActionListener(this);
      var2.add(var3);
      return var2;
   }

   private JMenu createStyleMenu(String var1) {
      JMenu var2 = new JMenu(var1);
      JRadioButtonMenuItem var3 = new JRadioButtonMenuItem("No Style (style as coded)");
      var3.setActionCommand("NO_STYLE");
      var3.addActionListener(this);
      JRadioButtonMenuItem var4 = new JRadioButtonMenuItem("Orson 1 Style");
      var4.setActionCommand("ORSON1_STYLE");
      var4.addActionListener(this);
      JRadioButtonMenuItem var5 = new JRadioButtonMenuItem("Orson 2 Style");
      var5.setActionCommand("ORSON2_STYLE");
      var5.addActionListener(this);
      JRadioButtonMenuItem var6 = new JRadioButtonMenuItem("Ice Cube Style");
      var6.setActionCommand("ICE_CUBE_STYLE");
      var6.addActionListener(this);
      JRadioButtonMenuItem var7 = new JRadioButtonMenuItem("Pastel");
      var7.setActionCommand("PASTEL_STYLE");
      var7.addActionListener(this);
      JRadioButtonMenuItem var8 = new JRadioButtonMenuItem("Logical Font Style");
      var8.setActionCommand("LOGICAL_FONT_STYLE");
      var8.addActionListener(this);
      var2.add(var3);
      var2.add(var4);
      var2.add(var5);
      var2.add(var6);
      var2.add(var7);
      var2.add(var8);
      ButtonGroup var9 = new ButtonGroup();
      var9.add(var3);
      var9.add(var4);
      var9.add(var5);
      var9.add(var6);
      var9.add(var7);
      var9.add(var8);
      var3.setSelected(true);
      return var2;
   }

   private JComponent createContent() {
      JTabbedPane var1 = new JTabbedPane();
      this.demoComponent = new OrsonChartsDemoComponent();
      var1.add("Demos", this.demoComponent);
      var1.add("About", this.createAboutPanel());
      return var1;
   }

   private JPanel createAboutPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      JTextPane var2 = new JTextPane();
      var2.setEditable(false);
      var2.setPreferredSize(new Dimension(800, 400));
      URL var3 = OrsonChartsDemo.class.getResource("/demo/orsoncharts/about.html");

      try {
         var2.setPage(var3);
      } catch (IOException var5) {
         throw new RuntimeException(var5);
      }

      JScrollPane var4 = new JScrollPane(var2);
      var1.add(var4);
      return var1;
   }

   private void applyStyleToChartsInPanels(List<Chart3DPanel> var1, ChartStyle var2) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Chart3DPanel var4 = (Chart3DPanel)var3.next();
         Chart3D var5 = (Chart3D)var4.getDrawable();
         ChartStyle var6 = var2.clone();
         var5.setStyle(var6);
      }

   }

   public void actionPerformed(ActionEvent var1) {
      if("EXIT".equals(var1.getActionCommand())) {
         System.exit(0);
      }

      Component var2 = this.demoComponent.getChartContainer().getComponent(0);
      if(var2 instanceof DemoPanel) {
         DemoPanel var3 = (DemoPanel)var2;
         List var4 = var3.getChartPanels();
         if("NO_STYLE".equals(var1.getActionCommand())) {
            this.demoComponent.setChartStyle((ChartStyle)null);
            int var5 = this.demoComponent.getWidth();
            int var6 = this.demoComponent.getHeight();
            SVGGraphics2D var7 = new SVGGraphics2D(var5, var6);
            this.demoComponent.paint(var7);

            try {
               SVGUtils.writeToSVG(new File("test.svg"), var7.getSVGElement());
            } catch (IOException var9) {
               ;
            }
         }

         if("ORSON1_STYLE".equals(var1.getActionCommand())) {
            this.demoComponent.setChartStyle(ChartStyles.createOrson1Style());
            this.applyStyleToChartsInPanels(var4, ChartStyles.createOrson1Style());
         }

         if("ORSON2_STYLE".equals(var1.getActionCommand())) {
            this.demoComponent.setChartStyle(ChartStyles.createOrson2Style());
            this.applyStyleToChartsInPanels(var4, ChartStyles.createOrson2Style());
         }

         if("ICE_CUBE_STYLE".equals(var1.getActionCommand())) {
            this.demoComponent.setChartStyle(ChartStyles.createIceCubeStyle());
            this.applyStyleToChartsInPanels(var4, ChartStyles.createIceCubeStyle());
         }

         if("PASTEL_STYLE".equals(var1.getActionCommand())) {
            this.demoComponent.setChartStyle(ChartStyles.createPastelStyle());
            this.applyStyleToChartsInPanels(var4, ChartStyles.createPastelStyle());
         }

         if("LOGICAL_FONT_STYLE".equals(var1.getActionCommand())) {
            this.demoComponent.setChartStyle(ChartStyles.createLogicalFontStyle());
            this.applyStyleToChartsInPanels(var4, ChartStyles.createLogicalFontStyle());
         }
      }

   }

   public static void main(String[] var0) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
               LookAndFeelInfo var4 = var1[var3];
               if("Nimbus".equals(var4.getName())) {
                  try {
                     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                  } catch (Exception var8) {
                     try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                     } catch (Exception var7) {
                        ;
                     }
                  }
               }
            }

            OrsonChartsDemo var9 = new OrsonChartsDemo("Orson Charts Demo 1.4");
            var9.pack();
            var9.setVisible(true);
         }
      });
   }

}
