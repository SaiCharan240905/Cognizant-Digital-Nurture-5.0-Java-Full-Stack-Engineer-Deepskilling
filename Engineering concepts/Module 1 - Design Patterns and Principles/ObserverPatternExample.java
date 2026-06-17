import java.util.ArrayList;
import java.util.List;

// --------------------------------------------------
// Observer Interface
// --------------------------------------------------
interface Observer {

    void update(String stockName, double stockPrice);
}

// --------------------------------------------------
// Subject Interface
// --------------------------------------------------
interface Stock {

    void registerObserver(Observer observer);

    void deregisterObserver(Observer observer);

    void notifyObservers();
}

// --------------------------------------------------
// Concrete Subject
// --------------------------------------------------
class StockMarket implements Stock {

    private List<Observer> observers;

    private String stockName;
    private double stockPrice;

    public StockMarket() {

        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(
            Observer observer) {

        observers.add(observer);

        System.out.println(
                observer.getClass().getSimpleName()
                        + " registered successfully.");
    }

    @Override
    public void deregisterObserver(
            Observer observer) {

        observers.remove(observer);

        System.out.println(
                observer.getClass().getSimpleName()
                        + " removed successfully.");
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {

            observer.update(
                    stockName,
                    stockPrice);
        }
    }

    // Update Stock Price
    public void setStockPrice(
            String stockName,
            double stockPrice) {

        this.stockName = stockName;
        this.stockPrice = stockPrice;

        System.out.println(
                "\nStock Updated: "
                        + stockName
                        + " = ₹"
                        + stockPrice);

        notifyObservers();
    }
}

// --------------------------------------------------
// Concrete Observer - Mobile App
// --------------------------------------------------
class MobileApp implements Observer {

    private String userName;

    public MobileApp(String userName) {

        this.userName = userName;
    }

    @Override
    public void update(
            String stockName,
            double stockPrice) {

        System.out.println(
                "Mobile App Notification for "
                        + userName
                        + " -> "
                        + stockName
                        + " Price Updated to ₹"
                        + stockPrice);
    }
}

// --------------------------------------------------
// Concrete Observer - Web App
// --------------------------------------------------
class WebApp implements Observer {

    private String userName;

    public WebApp(String userName) {

        this.userName = userName;
    }

    @Override
    public void update(
            String stockName,
            double stockPrice) {

        System.out.println(
                "Web App Notification for "
                        + userName
                        + " -> "
                        + stockName
                        + " Price Updated to ₹"
                        + stockPrice);
    }
}

// --------------------------------------------------
// Main Test Class
// --------------------------------------------------
public class ObserverPatternExample {

    public static void main(String[] args) {

        System.out.println(
                "===== Observer Pattern Demo =====\n");

        // Create Stock Market
        StockMarket stockMarket =
                new StockMarket();

        // Create Observers
        Observer mobileUser1 =
                new MobileApp("Sai");

        Observer mobileUser2 =
                new MobileApp("Rahul");

        Observer webUser1 =
                new WebApp("Priya");

        // Register Observers
        stockMarket.registerObserver(
                mobileUser1);

        stockMarket.registerObserver(
                mobileUser2);

        stockMarket.registerObserver(
                webUser1);

        // Stock Updates
        stockMarket.setStockPrice(
                "TCS",
                3500);

        stockMarket.setStockPrice(
                "INFOSYS",
                1650);

        // Remove Observer
        System.out.println(
                "\nRemoving Rahul from notifications...\n");

        stockMarket.deregisterObserver(
                mobileUser2);

        // Another Stock Update
        stockMarket.setStockPrice(
                "WIPRO",
                450);
    }
}