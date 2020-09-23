package demo.orsoncharts.swing;

import com.orsoncharts.style.ChartStyle;
import demo.orsoncharts.DemoDescription;
import demo.orsoncharts.swing.AreaChart3DDemo1;
import demo.orsoncharts.swing.DemoDisplayer;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class OrsonChartsDemoComponent extends JPanel implements TreeSelectionListener {

   private static final String PREFIX = "demo.orsoncharts.swing.";
   private static final String ABOUT_PREFIX = "/demo/orsoncharts/";
   private TreePath defaultChartPath;
   private JPanel chartContainer;
   private JTextPane chartDescriptionPane;
   private ChartStyle style = null;


   public OrsonChartsDemoComponent() {
      super(new BorderLayout());
      this.add(this.createContent());
   }

   public ChartStyle getChartStyle() {
      return this.style == null?null:this.style.clone();
   }

   public void setChartStyle(ChartStyle var1) {
      this.style = var1;
   }

   public JPanel getChartContainer() {
      return this.chartContainer;
   }

   public JTextPane getChartDescriptionPane() {
      return this.chartDescriptionPane;
   }

   private JComponent createContent() {
      JSplitPane var1 = new JSplitPane(1);
      var1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      JTree var2 = new JTree(this.createTreeModel());
      var2.addTreeSelectionListener(this);
      var2.setSelectionPath(this.defaultChartPath);
      JScrollPane var3 = new JScrollPane(var2);
      var3.setPreferredSize(new Dimension(300, 580));
      var1.add(var3);
      var1.add(this.createChartComponent());
      return var1;
   }

   private TreeModel createTreeModel() {
      DefaultMutableTreeNode var1 = new DefaultMutableTreeNode("Orson Charts");
      var1.add(this.createCategoryChartsNode(var1));
      var1.add(this.createPieChartsNode());
      var1.add(this.createXYZChartsNode());
      var1.add(this.createAxisRangeTestNode());
      return new DefaultTreeModel(var1);
   }

   private MutableTreeNode createNode(String var1, String var2, String var3) {
      return new DefaultMutableTreeNode(new DemoDescription(var1, var2, var3));
   }

   private MutableTreeNode createCategoryChartsNode(DefaultMutableTreeNode var1) {
      DefaultMutableTreeNode var2 = new DefaultMutableTreeNode("Category Charts");
      MutableTreeNode var3 = this.createNode("demo.orsoncharts.swing.AreaChart3DDemo1", "AreaChart3DDemo1.java", "/demo/orsoncharts/AreaChart3D1.html");
      this.defaultChartPath = new TreePath(new Object[]{var1, var2, var3});
      var2.add(var3);
      var2.add(this.createNode("demo.orsoncharts.swing.AreaChart3DDemo2", "AreaChart3DDemo2.java", "/demo/orsoncharts/AreaChart3D2.html"));
      var2.add(this.createNode("demo.orsoncharts.swing.BarChart3DDemo1", "BarChart3DDemo1.java", "/demo/orsoncharts/BarChart3D1.html"));
      var2.add(this.createNode("demo.orsoncharts.swing.BarChart3DDemo2", "BarChart3DDemo2.java", "/demo/orsoncharts/BarChart3D2.html"));
      var2.add(this.createNode("demo.orsoncharts.swing.CategoryMarkerDemo1", "CategoryMarkerDemo1.java", "/demo/orsoncharts/CategoryMarkerDemo1.html"));
      var2.add(this.createNode("demo.orsoncharts.swing.LineChart3DDemo1", "LineChart3DDemo1.java", "/demo/orsoncharts/LineChart3D1.html"));
      var2.add(this.createNode("demo.orsoncharts.swing.LineChart3DDemo2", "LineChart3DDemo2.java", "/demo/orsoncharts/LineChart3D2.html"));
      var2.add(this.createNode("demo.orsoncharts.swing.StackedBarChart3DDemo1", "StackedBarChart3DDemo1.java", "/demo/orsoncharts/StackedBarChart3D1.html"));
      var2.add(this.createNode("demo.orsoncharts.swing.StackedBarChart3DDemo2", "StackedBarChart3DDemo2.java", "/demo/orsoncharts/StackedBarChart3D2.html"));
      var2.add(this.createNode("demo.orsoncharts.swing.StackedBarChart3DDemo3", "StackedBarChart3DDemo3.java", "/demo/orsoncharts/StackedBarChart3D3.html"));
      return var2;
   }

   private MutableTreeNode createPieChartsNode() {
      DefaultMutableTreeNode var1 = new DefaultMutableTreeNode("Pie Charts");
      var1.add(this.createNode("demo.orsoncharts.swing.PieChart3DDemo1", "PieChart3DDemo1.java", "/demo/orsoncharts/PieChart3D1.html"));
      var1.add(this.createNode("demo.orsoncharts.swing.PieChart3DDemo2", "PieChart3DDemo2.java", "/demo/orsoncharts/PieChart3D2.html"));
      return var1;
   }

   private MutableTreeNode createXYZChartsNode() {
      DefaultMutableTreeNode var1 = new DefaultMutableTreeNode("XYZ Charts");
      var1.add(this.createNode("demo.orsoncharts.swing.RangeMarkerDemo1", "RangeMarkerDemo1.java", "/demo/orsoncharts/RangeMarker1.html"));
      var1.add(this.createNode("demo.orsoncharts.swing.ScatterPlot3DDemo1", "ScatterPlot3DDemo1.java", "/demo/orsoncharts/ScatterPlot3D1.html"));
      var1.add(this.createNode("demo.orsoncharts.swing.ScatterPlot3DDemo2", "ScatterPlot3DDemo2.java", "/demo/orsoncharts/ScatterPlot3D2.html"));
      var1.add(this.createNode("demo.orsoncharts.swing.ScatterPlot3DDemo3", "ScatterPlot3DDemo3.java", "/demo/orsoncharts/ScatterPlot3D3.html"));
      var1.add(this.createNode("demo.orsoncharts.swing.SurfaceRendererDemo1", "SurfaceRendererDemo1.java", "/demo/orsoncharts/SurfaceRenderer1.html"));
      var1.add(this.createNode("demo.orsoncharts.swing.SurfaceRendererDemo2", "SurfaceRendererDemo2.java", "/demo/orsoncharts/SurfaceRenderer2.html"));
      var1.add(this.createNode("demo.orsoncharts.swing.XYZBarChart3DDemo1", "XYZBarChart3DDemo1.java", "/demo/orsoncharts/XYZBarChart3D1.html"));
      return var1;
   }

   private MutableTreeNode createAxisRangeTestNode() {
      DefaultMutableTreeNode var1 = new DefaultMutableTreeNode("Axis Range Tests");
      var1.add(this.createNode("demo.orsoncharts.swing.AxisRangeDemo1", "AxisRangeDemo1.java", "/demo/orsoncharts/AxisRangeDemo1.html"));
      var1.add(this.createNode("demo.orsoncharts.swing.AxisRangeDemo2", "AxisRangeDemo2.java", "/demo/orsoncharts/AxisRangeDemo2.html"));
      var1.add(this.createNode("demo.orsoncharts.swing.AxisRangeDemo3", "AxisRangeDemo3.java", "/demo/orsoncharts/AxisRangeDemo3.html"));
      var1.add(this.createNode("demo.orsoncharts.swing.AxisRangeDemo4", "AxisRangeDemo4.java", "/demo/orsoncharts/AxisRangeDemo4.html"));
      var1.add(this.createNode("demo.orsoncharts.swing.AxisRangeDemo5", "AxisRangeDemo5.java", "/demo/orsoncharts/AxisRangeDemo5.html"));
      var1.add(this.createNode("demo.orsoncharts.swing.AxisRangeDemo6", "AxisRangeDemo6.java", "/demo/orsoncharts/AxisRangeDemo6.html"));
      return var1;
   }

   private JComponent createChartComponent() {
      JSplitPane var1 = new JSplitPane(0);
      CompoundBorder var2 = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.DARK_GRAY));
      this.chartContainer = new JPanel(new BorderLayout());
      this.chartContainer.setPreferredSize(new Dimension(400, 400));
      DemoPanel var3 = AreaChart3DDemo1.createDemoPanel();
      var3.setBorder(var2);
      this.chartContainer.add(var3);
      var1.add(this.chartContainer);
      JPanel var4 = new JPanel(new BorderLayout());
      var4.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.BLACK)));
      this.chartDescriptionPane = new JTextPane();
      this.chartDescriptionPane.setPreferredSize(new Dimension(400, 180));
      this.chartDescriptionPane.setEditable(false);
      this.chartDescriptionPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
      this.chartDescriptionPane.setText("No chart description available.");
      var4.add(this.chartDescriptionPane);
      var1.add(var4);
      return var1;
   }

   public void valueChanged(TreeSelectionEvent var1) {
      TreePath var2 = var1.getPath();
      Object var3 = var2.getLastPathComponent();
      if(var3 != null) {
         DefaultMutableTreeNode var4 = (DefaultMutableTreeNode)var3;
         Object var5 = var4.getUserObject();
         if(var5 instanceof DemoDescription) {
            DemoDescription var6 = (DemoDescription)var5;
            SwingUtilities.invokeLater(new DemoDisplayer(this, var6));
         } else {
            this.chartContainer.removeAll();
            this.chartContainer.add(this.createNoDemoSelectedPanel());
            this.chartContainer.validate();
            URL var9 = OrsonChartsDemo.class.getResource("select.html");
            if(var9 != null) {
               try {
                  this.chartDescriptionPane.setPage(var9);
               } catch (IOException var8) {
                  System.err.println("Attempted to read a bad URL: " + var9);
               }
            }
         }
      }

   }

   private JComponent createNoDemoSelectedPanel() {
      return new JButton("No demo selected.");
   }
}
