package SelectionExample;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionExample extends JFrame {
    public SelectionExample( ) {
        super("Selection Model Test");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        TableModel tm = new AbstractTableModel( ) {
            // We'll create a simple multiplication table to serve as a noneditable
            // table with several rows and columns.
            public int getRowCount( ) { return 10; }
            public int getColumnCount( ) { return 10; }
            public Object getValueAt(int r, int c) { return "" + (r+1)*(c+1); }
        };

        final JTable jt = new JTable(tm);

        JScrollPane jsp = new JScrollPane(jt);
        getContentPane( ).add(jsp, BorderLayout.CENTER);

        // Now set up our selection controls.
        JPanel controlPanel, buttonPanel, columnPanel, rowPanel;

        buttonPanel = new JPanel( );
        final JCheckBox cellBox, columnBox, rowBox;
        cellBox = new JCheckBox("Cells", jt.getCellSelectionEnabled( ));
        columnBox = new JCheckBox("Columns", jt.getColumnSelectionAllowed( ));
        rowBox = new JCheckBox("Rows", jt.getRowSelectionAllowed( ));
        cellBox.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent ae) {
                jt.setCellSelectionEnabled(cellBox.isSelected( ));
                columnBox.setSelected(jt.getColumnSelectionAllowed( ));
                rowBox.setSelected(jt.getRowSelectionAllowed( ));
            }
        } );

        columnBox.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent ae) {
                jt.setColumnSelectionAllowed(columnBox.isSelected( ));
                cellBox.setSelected(jt.getCellSelectionEnabled( ));
            }
        } );

        rowBox.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent ae) {
                jt.setRowSelectionAllowed(rowBox.isSelected( ));
                cellBox.setSelected(jt.getCellSelectionEnabled( ));
            }
        } );

        buttonPanel.add(new JLabel("Selections allowed:"));
        buttonPanel.add(cellBox);
        buttonPanel.add(columnBox);
        buttonPanel.add(rowBox);

        columnPanel = new JPanel( );
        ListSelectionModel csm = jt.getColumnModel( ).getSelectionModel( );
        JLabel columnCounter = new JLabel("(Selected Column Indices Go Here)");
        csm.addListSelectionListener(new SelectionDebugger(columnCounter, csm));
        columnPanel.add(new JLabel("Selected columns:"));
        columnPanel.add(columnCounter);

        rowPanel = new JPanel( );
        ListSelectionModel rsm = jt.getSelectionModel( );
        JLabel rowCounter = new JLabel("(Selected Row Indices Go Here)");
        rsm.addListSelectionListener(new SelectionDebugger(rowCounter, rsm));
        rowPanel.add(new JLabel("Selected rows:"));
        rowPanel.add(rowCounter);

        controlPanel = new JPanel(new GridLayout(0, 1));
        controlPanel.add(buttonPanel);
        controlPanel.add(columnPanel);
        controlPanel.add(rowPanel);

        getContentPane( ).add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String args[]) {
        SelectionExample se = new SelectionExample( );
        se.setVisible(true);
    }

    public class SelectionDebugger implements ListSelectionListener {
        JLabel debugger;
        ListSelectionModel model;

        public SelectionDebugger(JLabel target, ListSelectionModel lsm) {
            this.debugger = target;
            this.model = lsm;
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                // Skip all the intermediate events.
                StringBuffer buffer = new StringBuffer();
                int[] selection = getSelectedIndices(model.getMinSelectionIndex(), model.getMaxSelectionIndex());
                if (selection.length == 0) {
                    buffer.append("none");
                } else {
                    for (int i = 0; i < selection.length - 1; i++) {
                        buffer.append(selection[i]);
                        buffer.append(", ");
                    }
                    buffer.append(selection[selection.length - 1]);
                }
                debugger.setText(buffer.toString());
            }
        }

        // This method returns an array of selected indices. It's guaranteed to
        // return a non-null value.
        protected int[] getSelectedIndices(int start, int stop) {
            if ((start == -1) || (stop == -1)) {
                // No selection, so return an empty array
                return new int[0];
            }

            int guesses[] = new int[stop - start + 1];
            int index = 0;
            // Manually walk through these.
            for (int i = start; i <= stop; i++) {
                if (model.isSelectedIndex(i)) {
                    guesses[index++] = i;
                }
            }

            // Pare down the guess array to the real thing.
            int realThing[] = new int[index];
            System.arraycopy(guesses, 0, realThing, 0, index);
            return realThing;
        }
    }
}
