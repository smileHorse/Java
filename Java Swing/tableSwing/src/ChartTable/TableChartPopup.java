package ChartTable;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class TableChartPopup extends JFrame {

    public TableChartPopup(TableModel tm) {
        super("Table Chart");
        setSize(300,200);
        TableChart tc = new TableChart(tm);
        getContentPane( ).add(tc, BorderLayout.CENTER);
        // Use the following line to turn on tooltips:
        ToolTipManager.sharedInstance( ).registerComponent(tc);
    }

}
