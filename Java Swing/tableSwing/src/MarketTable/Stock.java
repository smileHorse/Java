package MarketTable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {
    protected String symbol;
    protected double price;
    protected double delta;
    protected String lastUpdate;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void update(double delta) {
        this.price += this.price * delta;
        this.delta = delta;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        this.lastUpdate = format.format(new Date());
    }

    public void print() {

    }
}
