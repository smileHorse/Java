package MarketTable;

import javax.swing.table.AbstractTableModel;

public class MarketDataModel extends AbstractTableModel implements Runnable {

    Thread runner;
    MYOSM market;
    int delay;

    public MarketDataModel(int initialDelay) {
        market = new MYOSM();
        delay = initialDelay * 1000;
        Thread runner = new Thread(this);
        runner.start();
    }

    Stock[] stocks = new Stock[0];
    int[] stockIndices = new int[0];
    String[] headers = {"Symbol", "Price", "Change", "Last updated"};

    @Override
    public int getRowCount() {
        return stocks.length;
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return stocks[rowIndex].symbol;
            case 1:
                return new Double(stocks[rowIndex].price);
            case 2:
                return new Double(stocks[rowIndex].delta);
            case 3:
                return stocks[rowIndex].lastUpdate;
        }
        throw new IllegalArgumentException("Bad Cell (" + rowIndex + ", " + columnIndex + ")");
    }

    public void setDelay(int seconds) { delay = seconds * 1000; }

    public void setStocks(int[] indices) {
        stockIndices = indices;
        updateStocks();
        fireTableDataChanged();
    }

    public void updateStocks() {
        stocks = new Stock[stockIndices.length];
        for (int i = 0; i < stocks.length; i++) {
            stocks[i] = market.getQuote(stockIndices[i]);
        }
    }

    @Override
    public void run() {
        while (true) {
            // Blind update . . . we could check for real deltas if necessary
            updateStocks();

            // We know there are no new columns, so don't fire a data change; fire only a
            // row update. This keeps the table from flashing
            fireTableRowsUpdated(0, stocks.length - 1);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {}
        }
    }
}
