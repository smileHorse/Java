package demo;

import demo.DrawStringPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.FontChooserPanel;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class DrawStringDemo extends ApplicationFrame implements ActionListener, ChangeListener {

   private JComboBox combo1;
   private JComboBox combo2;
   private JComboBox combo3;
   private JSlider rotation;
   private DrawStringPanel drawStringPanel1;
   private DrawStringPanel drawStringPanel2;


   public DrawStringDemo(String var1) {
      super(var1);
      this.setContentPane(this.createContentPane());
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getActionCommand().equals("fontButton.clicked")) {
         this.displayFontDialog();
      }

      if(var1.getActionCommand().equals("combo1.changed")) {
         this.handleCombo1Change();
      }

      if(var1.getActionCommand().equals("combo2.changed")) {
         this.handleCombo2Change();
      }

      if(var1.getActionCommand().equals("combo3.changed")) {
         this.handleCombo3Change();
      }

   }

   public void stateChanged(ChangeEvent var1) {
      int var2 = this.rotation.getValue();
      double var3 = 6.283185307179586D * ((double)var2 / 360.0D);
      this.drawStringPanel2.setAngle(var3);
      this.drawStringPanel2.invalidate();
      this.drawStringPanel2.repaint();
   }

   private void handleCombo1Change() {
      String var1 = this.combo1.getSelectedItem().toString();
      this.drawStringPanel1.setAnchor(this.convertStringToAnchor(var1));
      this.drawStringPanel1.invalidate();
      this.drawStringPanel1.repaint();
   }

   private void handleCombo2Change() {
      String var1 = this.combo2.getSelectedItem().toString();
      this.drawStringPanel2.setAnchor(this.convertStringToAnchor(var1));
      this.drawStringPanel2.invalidate();
      this.drawStringPanel2.repaint();
   }

   private void handleCombo3Change() {
      String var1 = this.combo3.getSelectedItem().toString();
      this.drawStringPanel2.setRotationAnchor(this.convertStringToAnchor(var1));
      this.drawStringPanel2.invalidate();
      this.drawStringPanel2.repaint();
   }

   private JPanel createContentPane() {
      JPanel var1 = new JPanel(new BorderLayout());
      JTabbedPane var2 = new JTabbedPane();
      var2.add("Alignment", this.createTab1Content());
      var2.add("Rotation", this.createTab2Content());
      var1.add(var2);
      return var1;
   }

   private JPanel createTab1Content() {
      JPanel var1 = new JPanel(new BorderLayout());
      this.combo1 = new JComboBox();
      this.combo1.setActionCommand("combo1.changed");
      this.populateTextAnchorCombo(this.combo1);
      this.combo1.addActionListener(this);
      JPanel var2 = new JPanel();
      var2.add(this.combo1);
      JButton var3 = new JButton("Select Font...");
      var3.setActionCommand("fontButton.clicked");
      var3.addActionListener(this);
      var2.add(var3);
      var1.add(var2, "North");
      this.drawStringPanel1 = new DrawStringPanel("0123456789", false);
      var1.add(this.drawStringPanel1);
      return var1;
   }

   private JPanel createTab2Content() {
      JPanel var1 = new JPanel(new BorderLayout());
      JPanel var2 = new JPanel();
      var2.add(new JLabel("Text anchor: "));
      this.combo2 = new JComboBox();
      this.populateTextAnchorCombo(this.combo2);
      this.combo2.setActionCommand("combo2.changed");
      this.combo2.addActionListener(this);
      var2.add(this.combo2);
      var2.add(new JLabel("Rotation anchor: "));
      this.combo3 = new JComboBox();
      this.populateTextAnchorCombo(this.combo3);
      this.combo3.setActionCommand("combo3.changed");
      this.combo3.addActionListener(this);
      var2.add(this.combo3);
      this.rotation = new JSlider(-360, 360, 0);
      this.rotation.setMajorTickSpacing(60);
      this.rotation.setMinorTickSpacing(10);
      this.rotation.setPaintLabels(true);
      this.rotation.setPaintTicks(true);
      this.rotation.addChangeListener(this);
      var1.add(this.rotation, "South");
      var1.add(var2, "North");
      this.drawStringPanel2 = new DrawStringPanel("Rotated Text", true);
      var1.add(this.drawStringPanel2);
      return var1;
   }

   private void displayFontDialog() {
      FontChooserPanel var1 = new FontChooserPanel(this.drawStringPanel1.getFont());
      int var2 = JOptionPane.showConfirmDialog(this, var1, "Font Selection", 2, -1);
      if(var2 == 0) {
         this.drawStringPanel1.setFont(var1.getSelectedFont());
         this.drawStringPanel2.setFont(var1.getSelectedFont());
      }

   }

   private void populateTextAnchorCombo(JComboBox var1) {
      var1.addItem("TextAnchor.TOP_LEFT");
      var1.addItem("TextAnchor.TOP_CENTER");
      var1.addItem("TextAnchor.TOP_RIGHT");
      var1.addItem("TextAnchor.HALF_ASCENT_LEFT");
      var1.addItem("TextAnchor.HALF_ASCENT_CENTER");
      var1.addItem("TextAnchor.HALF_ASCENT_RIGHT");
      var1.addItem("TextAnchor.CENTER_LEFT");
      var1.addItem("TextAnchor.CENTER");
      var1.addItem("TextAnchor.CENTER_RIGHT");
      var1.addItem("TextAnchor.BASELINE_LEFT");
      var1.addItem("TextAnchor.BASELINE_CENTER");
      var1.addItem("TextAnchor.BASELINE_RIGHT");
      var1.addItem("TextAnchor.BOTTOM_LEFT");
      var1.addItem("TextAnchor.BOTTOM_CENTER");
      var1.addItem("TextAnchor.BOTTOM_RIGHT");
   }

   private TextAnchor convertStringToAnchor(String var1) {
      return var1.equals("TextAnchor.TOP_LEFT")?TextAnchor.TOP_LEFT:(var1.equals("TextAnchor.TOP_CENTER")?TextAnchor.TOP_CENTER:(var1.equals("TextAnchor.TOP_RIGHT")?TextAnchor.TOP_RIGHT:(var1.equals("TextAnchor.CENTER_LEFT")?TextAnchor.CENTER_LEFT:(var1.equals("TextAnchor.CENTER")?TextAnchor.CENTER:(var1.equals("TextAnchor.CENTER_RIGHT")?TextAnchor.CENTER_RIGHT:(var1.equals("TextAnchor.HALF_ASCENT_LEFT")?TextAnchor.HALF_ASCENT_LEFT:(var1.equals("TextAnchor.HALF_ASCENT_CENTER")?TextAnchor.HALF_ASCENT_CENTER:(var1.equals("TextAnchor.HALF_ASCENT_RIGHT")?TextAnchor.HALF_ASCENT_RIGHT:(var1.equals("TextAnchor.BASELINE_LEFT")?TextAnchor.BASELINE_LEFT:(var1.equals("TextAnchor.BASELINE_CENTER")?TextAnchor.BASELINE_CENTER:(var1.equals("TextAnchor.BASELINE_RIGHT")?TextAnchor.BASELINE_RIGHT:(var1.equals("TextAnchor.BOTTOM_LEFT")?TextAnchor.BOTTOM_LEFT:(var1.equals("TextAnchor.BOTTOM_CENTER")?TextAnchor.BOTTOM_CENTER:(var1.equals("TextAnchor.BOTTOM_RIGHT")?TextAnchor.BOTTOM_RIGHT:null))))))))))))));
   }

   public static void main(String[] var0) {
      DrawStringDemo var1 = new DrawStringDemo("DrawString Demo");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
