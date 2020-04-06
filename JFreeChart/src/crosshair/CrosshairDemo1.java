package crosshair;

import demo.DemoPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.ChartProgressEvent;
import org.jfree.chart.event.ChartProgressListener;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.Range;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.DateCellRenderer;
import org.jfree.ui.NumberCellRenderer;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrosshairDemo1 extends ApplicationFrame {

    static class DemoTableModel extends AbstractTableModel {
        private Object data[][];

        @Override
        public int getColumnCount() {
            return 7;
        }

        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            data[rowIndex][columnIndex] = aValue;
            fireTableDataChanged();
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Series Name:";
                case 1:
                    return "X:";
                case 2:
                    return "Y:";
                case 3:
                    return "X(prev):";
                case 4:
                    return "Y(prev):";
                case 5:
                    return "X(next):";
                case 6:
                    return "Y(next):";
            }
            return null;
        }

        public DemoTableModel(int i) {
            data = new Object[i][7];
        }
    }

    private static class MyDemoPanel extends DemoPanel implements ChangeListener, ChartProgressListener {
        private TimeSeries timeSeries;
        private ChartPanel chartPanel;
        private DemoTableModel model;
        private JFreeChart jFreeChart;
        private JSlider slider;

        private JFreeChart createChart() {
            XYDataset xyDataset = createDataset("Random 1", 100D, new Minute(), 200);
            JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart("Crosshair Demo 1", "Time of Day",
                    "Value", xyDataset);
            XYPlot xyPlot = (XYPlot)jFreeChart.getPlot();
            xyPlot.setOrientation(PlotOrientation.VERTICAL);
            xyPlot.setDomainCrosshairVisible(true);
            xyPlot.setDomainCrosshairLockedOnData(false);
            xyPlot.setRangeCrosshairVisible(false);
            return jFreeChart;
        }

        private XYDataset createDataset(String s, double d, RegularTimePeriod regularTimePeriod, int i) {
            timeSeries = new TimeSeries(s);
            RegularTimePeriod regularTimePeriod1 = regularTimePeriod;
            double d1 = d;
            for (int j = 0; j < i; j++) {
                timeSeries.add(regularTimePeriod1, d1);
                regularTimePeriod1 = regularTimePeriod1.next();
                d1 *= 1.0D + (Math.random() - 0.495D) / 10D;
            }

            TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
            timeSeriesCollection.addSeries(timeSeries);
            return timeSeriesCollection;
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            int i = slider.getValue();
            XYPlot xyPlot = (XYPlot)jFreeChart.getPlot();
            ValueAxis valueAxis = xyPlot.getDomainAxis();
            Range range = valueAxis.getRange();
            double d = valueAxis.getLowerBound() + ((double)i / 100D) * range.getLength();
            xyPlot.setDomainCrosshairValue(d);
        }

        @Override
        public void chartProgress(ChartProgressEvent chartProgressEvent) {
            if (chartProgressEvent.getType() != 2) {
                return;
            }
            if (chartPanel != null) {
                JFreeChart jFreeChart = chartPanel.getChart();
                if (jFreeChart != null) {
                    XYPlot xyPlot = (XYPlot)jFreeChart.getPlot();
                    XYDataset xyDataset = xyPlot.getDataset();
                    Comparable comparable = xyDataset.getSeriesKey(0);
                    double d = xyPlot.getDomainCrosshairValue();
                    model.setValueAt(comparable, 0, 0);
                    long l = (long)d;
                    model.setValueAt(new Long(l), 0, 1);
                    int i = timeSeries.getIndex(new Minute(new Date(l)));
                    if (i >= 0) {
                        TimeSeriesDataItem timeSeriesDataItem = timeSeries.getDataItem(Math.min(99, Math.max(0, i)));
                        TimeSeriesDataItem timeSeriesDataItem1 = timeSeries.getDataItem(Math.max(0, i - 1));
                        TimeSeriesDataItem timeSeriesDataItem2 = timeSeries.getDataItem(Math.min(199, i + 1));
                        long l1 = timeSeriesDataItem.getPeriod().getMiddleMillisecond();
                        double d1 = timeSeriesDataItem.getValue().doubleValue();
                        long l2 = timeSeriesDataItem1.getPeriod().getMiddleMillisecond();
                        double d2 = timeSeriesDataItem1.getValue().doubleValue();
                        long l3 = timeSeriesDataItem2.getPeriod().getMiddleMillisecond();
                        double d3 = timeSeriesDataItem2.getValue().doubleValue();
                        model.setValueAt(new Long(l1), 0, 1);
                        model.setValueAt(new Double(d1), 0, 2);
                        model.setValueAt(new Long(l2), 0, 3);
                        model.setValueAt(new Double(d2), 0, 4);
                        model.setValueAt(new Long(l3), 0, 5);
                        model.setValueAt(new Double(d3), 0, 6);
                    }
                }
            }
        }

        public MyDemoPanel() {
            super(new BorderLayout());
            jFreeChart = createChart();
            addChart(jFreeChart);
            jFreeChart.addProgressListener(this);

            chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setPreferredSize(new Dimension(600, 250));
            chartPanel.setDomainZoomable(true);
            chartPanel.setRangeZoomable(true);
            CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(4, 4, 4, 4),
                    BorderFactory.createEtchedBorder());
            chartPanel.setBorder(compoundBorder);
            add(chartPanel);

            JPanel jPanel = new JPanel(new BorderLayout());
            jPanel.setPreferredSize(new Dimension(400, 80));
            jPanel.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
            model = new DemoTableModel(3);

            XYPlot xyPlot = (XYPlot)jFreeChart.getPlot();
            model.setValueAt(xyPlot.getDataset().getSeriesKey(0), 0, 0);
            model.setValueAt(new Double("0.00"), 0, 1);
            model.setValueAt(new Double("0.00"), 0, 2);
            model.setValueAt(new Double("0.00"), 0, 3);
            model.setValueAt(new Double("0.00"), 0, 4);
            model.setValueAt(new Double("0.00"), 0, 5);
            model.setValueAt(new Double("0.00"), 0, 6);
            JTable jTable = new JTable(model);
            DateCellRenderer dateCellRenderer = new DateCellRenderer(new SimpleDateFormat("HH:mm"));
            NumberCellRenderer numberCellRenderer = new NumberCellRenderer();
            jTable.getColumnModel().getColumn(1).setCellRenderer(dateCellRenderer);
            jTable.getColumnModel().getColumn(2).setCellRenderer(numberCellRenderer);
            jTable.getColumnModel().getColumn(3).setCellRenderer(dateCellRenderer);
            jTable.getColumnModel().getColumn(4).setCellRenderer(numberCellRenderer);
            jTable.getColumnModel().getColumn(5).setCellRenderer(dateCellRenderer);
            jTable.getColumnModel().getColumn(6).setCellRenderer(numberCellRenderer);

            JScrollPane jScrollPane = new JScrollPane(jTable);
            jPanel.add(jScrollPane);
            slider = new JSlider(0, 100, 50);
            slider.addChangeListener(this);
            jPanel.add(slider, BorderLayout.SOUTH);
            add(jPanel, BorderLayout.SOUTH);
        }
    }

    public CrosshairDemo1(String s) {
        super(s);
        setContentPane(new MyDemoPanel());
    }

    public static void main(String[] args) {
        CrosshairDemo1 demo = new CrosshairDemo1("JFreeChart: CrosshairDemo1.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
