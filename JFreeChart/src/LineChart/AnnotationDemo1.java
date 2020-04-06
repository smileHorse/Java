package LineChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnnotationDemo1 extends ApplicationFrame {

    public AnnotationDemo1(String s) {
        super(s);
        JPanel panel = createDemoPanel();
        panel.setPreferredSize(new Dimension(360, 500));
        setContentPane(panel);
    }

    private static XYSeriesCollection createDataset() {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    XYSeriesCollection.class.getClassLoader().getResourceAsStream("wtageinf.txt")
            ));
            String s = bufferedReader.readLine();
            s = bufferedReader.readLine();
            s = bufferedReader.readLine();
            s = bufferedReader.readLine();
            XYSeries xySeries = new XYSeries("P3", true, false);
            XYSeries xySeries1 = new XYSeries("P5", true, false);
            XYSeries xySeries2 = new XYSeries("P10", true, false);
            XYSeries xySeries3 = new XYSeries("P25", true, false);
            XYSeries xySeries4 = new XYSeries("P50", true, false);
            XYSeries xySeries5 = new XYSeries("P75", true, false);
            XYSeries xySeries6 = new XYSeries("P90", true, false);
            XYSeries xySeries7 = new XYSeries("P95", true, false);
            XYSeries xySeries8 = new XYSeries("P97", true, false);
            for (String s1 = bufferedReader.readLine(); s1 != null; s1 = bufferedReader.readLine()) {
                int i = Integer.parseInt(s1.substring(1, 8).trim());
                float f = Float.parseFloat(s1.substring(9, 17).trim());
                float f1 = Float.parseFloat(s1.substring(69, 86).trim());
                float f2 = Float.parseFloat(s1.substring(87, 103).trim());
                float f3 = Float.parseFloat(s1.substring(104, 122).trim());
                float f4 = Float.parseFloat(s1.substring(123, 140).trim());
                float f5 = Float.parseFloat(s1.substring(141, 158).trim());
                float f6 = Float.parseFloat(s1.substring(159, 176).trim());
                float f7 = Float.parseFloat(s1.substring(177, 193).trim());
                float f8 = Float.parseFloat(s1.substring(194, 212).trim());
                float f9 = Float.parseFloat(s1.substring(212, s1.length()).trim());
                if (i == 1) {
                    xySeries.add(f, f1);
                    xySeries1.add(f, f2);
                    xySeries2.add(f, f3);
                    xySeries3.add(f, f4);
                    xySeries4.add(f, f5);
                    xySeries5.add(f, f6);
                    xySeries6.add(f, f7);
                    xySeries7.add(f, f8);
                    xySeries8.add(f, f9);
                }
            }

            xySeriesCollection.addSeries(xySeries);
            xySeriesCollection.addSeries(xySeries1);
            xySeriesCollection.addSeries(xySeries2);
            xySeriesCollection.addSeries(xySeries3);
            xySeriesCollection.addSeries(xySeries4);
            xySeriesCollection.addSeries(xySeries5);
            xySeriesCollection.addSeries(xySeries6);
            xySeriesCollection.addSeries(xySeries7);
            xySeriesCollection.addSeries(xySeries8);
        } catch (FileNotFoundException fileNotFoundExcetpion) {
            System.err.println(fileNotFoundExcetpion);
        } catch (IOException ioException) {
            System.err.println(ioException);
        }
        return xySeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xyDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart(null, "Age in Months",
                "Weight(kg)", xyDataset);

        TextTitle textTitle = new TextTitle("Growth Charts: United States", new Font("SansSerif", 1, 14));
        TextTitle textTitle1 = new TextTitle("Weigth-for-age percentiles: boys, birth to 36 months",
                new Font("SansSerif", 0, 11));
        jFreeChart.addSubtitle(textTitle);
        jFreeChart.addSubtitle(textTitle1);

        XYPlot xyPlot = (XYPlot) jFreeChart.getPlot();
        xyPlot.setDomainPannable(true);
        xyPlot.setRangePannable(true);

        NumberAxis numberAxis = (NumberAxis)xyPlot.getDomainAxis();
        numberAxis.setUpperMargin(0.12D);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        NumberAxis numberAxis1 = (NumberAxis)xyPlot.getRangeAxis();
        numberAxis1.setAutoRangeIncludesZero(false);

        Font font = new Font("SansSerif", 0 ,9);
        XYTextAnnotation xyTextAnnotation = new XYTextAnnotation("3rd", 36.5D, 11.76D);
        xyTextAnnotation.setFont(font);
        xyTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyPlot.addAnnotation(xyTextAnnotation);

        xyTextAnnotation = new XYTextAnnotation("5th", 36.5D, 12.039999999999999D);
        xyTextAnnotation.setFont(font);
        xyTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyPlot.addAnnotation(xyTextAnnotation);

        xyTextAnnotation = new XYTextAnnotation("10th", 36.5D, 12.493D);
        xyTextAnnotation.setFont(font);
        xyTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyPlot.addAnnotation(xyTextAnnotation);

        xyTextAnnotation = new XYTextAnnotation("25th", 36.5D, 13.313000000000001D);
        xyTextAnnotation.setFont(font);
        xyTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyPlot.addAnnotation(xyTextAnnotation);

        xyTextAnnotation = new XYTextAnnotation("50th", 36.5D, 14.33D);
        xyTextAnnotation.setFont(font);
        xyTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyPlot.addAnnotation(xyTextAnnotation);

        xyTextAnnotation = new XYTextAnnotation("75th", 36.5D, 15.478D);
        xyTextAnnotation.setFont(font);
        xyTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyPlot.addAnnotation(xyTextAnnotation);

        xyTextAnnotation = new XYTextAnnotation("90th", 36.5D, 16.641999999999999D);
        xyTextAnnotation.setFont(font);
        xyTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyPlot.addAnnotation(xyTextAnnotation);

        xyTextAnnotation = new XYTextAnnotation("95th", 36.5D, 17.408000000000001D);
        xyTextAnnotation.setFont(font);
        xyTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyPlot.addAnnotation(xyTextAnnotation);

        xyTextAnnotation = new XYTextAnnotation("97th", 36.5D, 17.936D);
        xyTextAnnotation.setFont(font);
        xyTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyPlot.addAnnotation(xyTextAnnotation);

        ChartUtilities.applyCurrentTheme(jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] args) {
        AnnotationDemo1 annotationDemo1 = new AnnotationDemo1("JFreeChart: AnnotationDemo1.java");
        annotationDemo1.pack();
        RefineryUtilities.centerFrameOnScreen(annotationDemo1);
        annotationDemo1.setVisible(true);
    }
}
