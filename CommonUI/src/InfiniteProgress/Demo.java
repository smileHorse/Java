package InfiniteProgress;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class Demo extends JFrame {
    protected InfiniteProgressPanel glassPane;
    protected CardLayout carder;
    protected JPanel cardPane;

    public Demo() {
        super("Infinite Progress Demo");

        build();

        pack();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    protected void build() {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(BorderLayout.CENTER, buildTabbedPane());
    }

    protected Container buildTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Infinite", buildInfinitePanel());
        return tabbedPane;
    }

    protected Container buildInfinitePanel() {
        JPanel pane = new JPanel(new BorderLayout());

        glassPane = new InfiniteProgressPanel();
        setGlassPane(glassPane);

        JTable table = new JTable(new CountTableModel());
        JScrollPane scrollPane = new JScrollPane(table);
        pane.add(BorderLayout.CENTER, scrollPane);

        JPanel buttons = new JPanel();
        JButton button = new JButton("Start");
        buttons.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                glassPane.start();
	            Thread performer = new Thread(new Runnable() {
	                public void run() {
	                    try {
	                       Thread.sleep(5000);
	                    } catch (InterruptedException ie) { }
	                    glassPane.stop();
	                }
	            }, "Performer");
	            performer.start();
            }
        });
        pane.add(BorderLayout.SOUTH, buttons);

        return pane;
    }

    private class CountTableModel extends AbstractTableModel {
        public int getColumnCount() { return 10; }
        public int getRowCount() { return 10; }
        public Object getValueAt(int row, int col) { return new Integer((row + 1) * (col + 1)); }
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        d.setVisible(true);
    }
}