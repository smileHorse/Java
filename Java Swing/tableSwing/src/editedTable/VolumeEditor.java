package editedTable;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.Vector;

public class VolumeEditor extends JSlider implements TableCellEditor {

    public OkCancel helper = new OkCancel();
    protected transient Vector listeners;
    protected transient int originalValue;
    protected transient boolean editing;

    public VolumeEditor() {
        super(SwingConstants.HORIZONTAL);
        listeners = new Vector();
    }

    // Inner class for the Ok/Cancel pop-up window that displays below the active
    // scrollbar, Its position will have to be determined by the editor when
    // getTableCellEditorComponent is called
    public class OkCancel extends JWindow {
        private JButton okB = new JButton(new ImageIcon("accept.gif"));
        private JButton cancelB = new JButton(new ImageIcon("decline.gif"));
        private int w = 50;
        private int h = 24;

        public OkCancel() {
            setSize(w, h);
            setBackground(Color.yellow);
            JPanel p = new JPanel(new GridLayout(0, 2));
            p.setBorder(BorderFactory.createLineBorder(Color.gray));
            okB.setBorder(null);
            cancelB.setBorder(null);
            p.add(okB);
            p.add(cancelB);
            setContentPane(p);

            okB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stopCellEditing();
                }
            });

            cancelB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelCellEditing();
                }
            });
        }
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
                                                 int row, int column) {
        if (value == null) {
            return this;
        }
        if (value instanceof Volume) {
            setValue(((Volume)value).getVolume());
        } else {
            setValue(0);
        }
        table.setRowSelectionInterval(row, row);
        table.setColumnSelectionInterval(column, column);
        originalValue = getValue();
        editing = true;
        Point p = table.getLocationOnScreen();
        Rectangle r = table.getCellRect(row, column, true);
        helper.setLocation(r.x + p.x + getWidth() - 50, r.y + p.y + getHeight());
        helper.setVisible(true);
        return this;
    }

    @Override
    public void cancelCellEditing() {
        fireEditingCanceled();
        editing = false;
        helper.setVisible(false);
    }

    @Override
    public Object getCellEditorValue() {
        return new Integer(getValue());
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        fireEditingStopped();
        editing = false;
        helper.setVisible(false);
        return true;
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
        listeners.addElement(l);
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
        listeners.removeElement(l);
    }

    public void fireEditingCanceled() {
        setValue(originalValue);
        ChangeEvent ce = new ChangeEvent(this);
        for (int i = 0; i < listeners.size(); i++) {
            ((CellEditorListener)listeners.get(i)).editingCanceled(ce);
        }
    }

    public void fireEditingStopped() {
        ChangeEvent ce = new ChangeEvent(this);
        for (int i = 0; i < listeners.size(); i++) {
            ((CellEditorListener)listeners.get(i)).editingStopped(ce);
        }
    }
}
