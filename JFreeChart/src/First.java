import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class First {
    public static void main(String[] args) {
        // create a dataset
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Category 1", 33.2);
        data.setValue("Category 2", 27.9);
        data.setValue("Category 3", 75.6);

        // create a chart
        JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart", data, true,
                true, false);

        // create and display a frame
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
