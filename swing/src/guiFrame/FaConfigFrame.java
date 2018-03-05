package guiFrame;

import javax.swing.*;

public class FaConfigFrame {
    private JPanel panel;
    private JSplitPane mainSplitPane;
    private JList areaList;
    private JPanel configPanel;
    private JPanel usePanel;
    private JPanel paramPanel;
    private JPanel mainButtonPanel;
    private JCheckBox useCheckBox;
    private JTabbedPane tabbedPane;
    private JPanel lineParamPanel;
    private JPanel faultParamPanel;
    private JPanel lineSubParamPanel;
    private JPanel nodeParamPanel;
    private JTextField nameTextField;
    private JTextField graphNameTextField;
    private JTextField permFaultVoltTextField;
    private JLabel nameLabel;
    private JLabel graphNameLabel;
    private JLabel permFaultVoltLabel;
    private JLabel voltUnitLabel;
    private JTable nodeTable;
    private JPanel nodeButtonPanel;
    private JButton addButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton closeButton;
    private JPanel basicParamPanel;
    private JPanel overCurrentParamPanel;
    private JPanel groundParamPanel;
    private JTextField faultMaxDurationTimeTextField;
    private JTextField eventMaxWaitTimeTextField;
    private JTextField sameGroupMaxDurationTimeTextField;
    private JTextField eventValidProcTimeTextField;
    private JTextField soeTimeTextField;
    private JTextField faultValidProcTimeTextField;
    private JLabel faultMaxDurationTimeLabel;
    private JLabel faultMaxDurationTimeUnitLabel;
    private JLabel eventMaxWaitTimeLabel;
    private JLabel eventMaxWaitTimeUnitLabel;
    private JLabel sameGroupMaxDurationTimeLabel;
    private JLabel sameGroupMaxDurationTimeUnitLabel;
    private JLabel eventValidProcTimeLabel;
    private JLabel eventValidProcTimeUnitLabel;
    private JLabel soeTimeLabel;
    private JLabel soeTimeUnitLabel;
    private JLabel faultValidProcTimeLabel;
    private JLabel faultValidProcTimeUnitLabel;
    private JComboBox algorithmForOverCurrentComboBox;
    private JLabel algorithmForOverCurrentLabel;
    private JCheckBox overCurrentCheckBox;
    private JComboBox isolateFaultModeComboBox;
    private JComboBox resumeModeComboBox;
    private JTextField lossVoltValueTextField;
    private JCheckBox supplyModeUseFlagCheckBox;
    private JCheckBox supplyDirUseFlagCheckBox;
    private JLabel isolateFaultModeLabel;
    private JLabel resumeModeLabel;
    private JLabel lossVoltValueLabel;
    private JComboBox algorithmForGroundComboBox;
    private JCheckBox groundCheckBox;
    private JLabel algorithmForGroundLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("FaConfigFrame");
        frame.setContentPane(new FaConfigFrame().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
