package editedTable;

import javax.swing.*;
import java.awt.*;

public class MixerTest extends JFrame {

    public MixerTest() {
        super("Customer Editor Test");
        setSize(600, 160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MixerModel test = new MixerModel();
        test.dump();
        JTable jt = new JTable(test);
        jt.setDefaultRenderer(Volume.class, new VolumeRenderer());
        jt.setDefaultEditor(Volume.class, new VolumeEditor());
        JScrollPane scrollPane = new JScrollPane(jt);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MixerTest mt = new MixerTest();
        mt.setVisible(true);
    }
}
