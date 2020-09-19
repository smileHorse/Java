package crosshair;

import demo.DemoPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.event.ChartProgressEvent;
import org.jfree.chart.event.ChartProgressListener;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
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

public class CrosshairDemo2 extends ApplicationFrame {

    static class DemoTableModel extends AbstractTableModel {
        private Object data[][];

        @Override
        public int getColumnCount() {
            return 7;
        }

        @Override
        public int getRowCount() {
            return data.length;
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

    private static class MyDemoPanel extends DemoPanel implements ChartChangeListener, ChartProgressListener {
        private static final int SERIES_COUNT = 4;
        private TimeSeriesCollection dataSets[];
        private TimeSeries timeSeries[];
        private ChartPanel chartPanel;
        private DemoTableModel model;

        private JFreeChart createChart() {
            JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart("Crosshair Demo 2", "Time of Day",
                    "Value", null, true, true, false);
            XYPlot xyPlot = (XYPlot)jFreeChart.getPlot();
            XYDataset axyDataset[] = new XYDataset[4];
            for (int i = 0; i < 4; i++) {
                axyDataset[i] = createDataset(i, (new StringBuilder()).append("Series ").append(i).toString(),
                        100D + (double)i * 200D, new Minute(), 200);
                if (i == 0) {
                    xyPlot.setDataset(axyDataset[i]);
                } else {
                    xyPlot.setDataset(i, axyDataset[i]);
                    xyPlot.setRangeAxis(i, new NumberAxis((new StringBuilder()).append("Axis ").append(i + 1).toString()));
                    xyPlot.mapDatasetToRangeAxis(i, i);
                    xyPlot.setRenderer(i, new XYLineAndShapeRenderer(true, false));
                }
             }

            jFreeChart.addChangeListener(this);
            jFreeChart.addProgressListener(this);
            xyPlot.setOrientation(PlotOrientation.VERTICAL);
            xyPlot.setDomainCrosshairVisible(true);
            xyPlot.setDomainCrosshairLockedOnData(false);
            xyPlot.setRangeCrosshairVisible(false);
            return jFreeChart;
        }

        private XYDataset createDataset(int i, String s, double d, RegularTimePeriod regularTimePeriod, int j) {
            timeSeries[i] = new TimeSeries(s);
            RegularTimePeriod regularTimePeriod1 = regularTimePeriod;
            double d1 = d;
            for (int k = 0; k < j; k++) {
                timeSeries[i].add(regularTimePeriod1, d1);
                regularTimePeriod1 = regularTimePeriod1.next();
                d1 *= 1.0D + (Math.random() - 0.495D) / 10D;
            }

            dataSets[i] = new TimeSeriesCollection();
            dataSets[i].addSeries(timeSeries[i]);
            return dataSets[i];
        }

        @Override
        public void chartChanged(ChartChangeEvent chartChangeEvent) {
            if (chartPanel == null) {
                return;
            }
            JFreeChart jFreeChart = chartPanel.getChart();
            if (jFreeChart != null) {
                XYPlot xyPlot = (XYPlot)jFreeChart.getPlot();
                XYDataset xyDataset = xyPlot.getDataset();
                Comparable comparable = xyDataset.getSeriesKey(0);
                double d = xyPlot.getDomainCrosshairValue();
                model.setValueAt(comparable, 0, 0);
                long l = (long)d;
                for (int i = 0; i < 4; i++) {
                    model.setValueAt(new Long(l), i, 1);
                    int ai[] = dataSets[i].getSurroundingItems(0, l);
                    long l1 = 0L;
                    long l2 = 0L;
                    double d1 = 0.0D;
                    double d2 = 0.0D;
                    if (ai[0] >= 0) {
                        TimeSeriesDataItem timeSeriesDataItem = timeSeries[i].getDataItem(ai[0]);
                        l1 = timeSeriesDataItem.getPeriod().getMiddleMillisecond();
                        Number number = timeSeriesDataItem.getValue();
                        if (number != null) {
                            d1 = number.doubleValue();
                            model.setValueAt(new Double(d1), i, 4);
                        } else {
                            model.setValueAt(null, i, 4);
                        }
                        model.setValueAt(new Long(l1), i, 3);
                    } else {
                        model.setValueAt(new Double(0.0D), i, 4);
                        model.setValueAt(new Double(xyPlot.getDomainAxis().getRange().getLowerBound()), i, 3);
                    }

                    if (ai[1] >= 0) {
                        TimeSeriesDataItem timeSeriesDataItem1 = timeSeries[i].getDataItem(ai[1]);
                        l2 = timeSeriesDataItem1.getPeriod().getMiddleMillisecond();
                        Number number1 = timeSeriesDataItem1.getValue();
                        if (number1 != null) {
                            d2 = number1.doubleValue();
                            model.setValueAt(new Double(d2), i, 6);
                        } else {
                            model.setValueAt(null, i, 6);
                        }
                        model.setValueAt(new Long(l2), i, 5);
                    } else {
                        model.setValueAt(new Double(0.0D), i, 6);
                        model.setValueAt(new Double(xyPlot.getDomainAxis().getRange().getLowerBound()), i, 5);
                    }

                    double d3;
                    if (l2 - l1 > 0L) {
                        d3 = d1 + (((double)l - (double)l1) / ((double)l2 - (double)l1)) * (d2 - d1);
                    } else {
                        d3 = d1;
                    }
                    model.setValueAt(new Double(d3), i, 2);
                }
            }
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
                    for (int i = 0; i < 4; i++) {
                        int j = timeSeries[i].getIndex(new Minute(new Date(l)));
                        if (j >= 0) {
                            TimeSeriesDataItem timeSeriesDataItem = timeSeries[i].getDataItem(Math.min(99, Math.max(0, j)));
                            TimeSeriesDataItem timeSeriesDataItem1 = timeSeries[i].getDataItem(Math.max(0, j - 1));
                            TimeSeriesDataItem timeSeriesDataItem2 = timeSeries[i].getDataItem(Math.min(199, j + 1));
                            long l1 = timeSeriesDataItem.getPeriod().getMiddleMillisecond();
                            double d1 = timeSeriesDataItem.getValue().doubleValue();
                            long l2 = timeSeriesDataItem1.getPeriod().getMiddleMillisecond();
                            double d2 = timeSeriesDataItem1.getValue().doubleValue();
                            long l3 = timeSeriesDataItem2.getPeriod().getMiddleMillisecond();
                            double d3 = timeSeriesDataItem2.getValue().doubleValue();
                            model.setValueAt(new Long(l1), i, 1);
                            model.setValueAt(new Double(d1), i, 2);
                            model.setValueAt(new Long(l2), i, 3);
                            model.setValueAt(new Double(d2), i, 4);
                            model.setValueAt(new Long(l3), i, 5);
                            model.setValueAt(new Double(d3), i, 6);
                        }
                    }

                }
            }
        }

        public MyDemoPanel() {
            super(new BorderLayout());
            dataSets = new TimeSeriesCollection[4];
            timeSeries = new TimeSeries[4];

            JPanel jPanel = new JPanel(new BorderLayout());
            JFreeChart jFreeChart = createChart();
            addChart(jFreeChart);
            jFreeChart.addProgressListener(this);

            chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setPreferredSize(new Dimension(600, 270));
            chartPanel.setDomainZoomable(true);
            chartPanel.setRangeZoomable(true);
            CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(4, 4, 4, 4),
                    BorderFactory.createEtchedBorder());
            chartPanel.setBorder(compoundBorder);
            add(chartPanel);

            JPanel jPanel1 = new JPanel(new BorderLayout());
            jPanel1.setPreferredSize(new Dimension(400, 120));
            jPanel1.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
            model = new DemoTableModel(4);

            for (int i = 0; i < 4; i++) {
                XYPlot xyPlot = (XYPlot)jFreeChart.getPlot();
                model.setValueAt(xyPlot.getDataset().getSeriesKey(0), i, 0);
                model.setValueAt(new Double("0.00"), i, 1);
                model.setValueAt(new Double("0.00"), i, 2);
                model.setValueAt(new Double("0.00"), i, 3);
                model.setValueAt(new Double("0.00"), i, 4);
                model.setValueAt(new Double("0.00"), i, 5);
                model.setValueAt(new Double("0.00"), i, 6);
            }
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
            jPanel1.add(jScrollPane);
            add(jPanel1, BorderLayout.SOUTH);
        }
    }

    public CrosshairDemo2(String s) {
        super(s);
        setContentPane(new MyDemoPanel());
    }

    public static void main(String[] args) {
        CrosshairDemo2 demo = new CrosshairDemo2("JFreeChart: CrosshairDemo1.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
