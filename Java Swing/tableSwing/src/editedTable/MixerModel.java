package editedTable;

import javax.swing.table.AbstractTableModel;

public class MixerModel extends AbstractTableModel {

    String headers[] = {"Track", "Start", "Stop", "Left Volume", "Right Volume"};
    Class columnClass[] = {String.class, String.class, String.class, Volume.class, Volume.class};
    Object data[][] = {
        {"Bass", "0:00:000", "1:00:000", new Volume(56), new Volume(56)},
        {"Strings", "0:00:000", "0:52:000", new Volume(72), new Volume(52)},
        {"Brass", "0:08:000", "1:34:056", new Volume(99), new Volume(0)},
        {"Wind", "0:08:000", "1:00:000", new Volume(0), new Volume(99)}
    };

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    // Do something extra here so that if we get a string object back from a text editor,
    // We can still store that as a valid Volume object. If it's just a string,
    // then stick it directly into our data array
    public void setValueAt(Object value, int r, int c) {
        if (c >= 3) {
            ((Volume)data[r][c]).setVolume(value);
        } else {
            data[r][c] = value;
        }
    }

    // A quick debugging utility to dump the contents of our data structure
    public void dump() {
        for (int i = 0; i < data.length; i++) {
            System.out.println("|");
            for (int j = 0; j < data[0].length; j++) {
                System.out.println(data[i][i] + "|");
            }
            System.out.println();
        }
    }
}
