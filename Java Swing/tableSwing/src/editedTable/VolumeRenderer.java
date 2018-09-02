package editedTable;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class VolumeRenderer extends JSlider implements TableCellRenderer {

    public VolumeRenderer() {
        super(SwingConstants.HORIZONTAL);
        setSize(115, 15);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        if (value == null) {
            return this;
        }
        if (value instanceof Volume) {
            setValue(((Volume)value).getVolume());
        } else {
            setValue(0);
        }
        return this;
    }
}
