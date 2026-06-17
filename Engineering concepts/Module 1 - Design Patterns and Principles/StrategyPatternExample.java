// --------------------------------------------------
// Strategy Interface
// --------------------------------------------------
interface PaymentStrategy {

    void pay(double amount);
}

// --------------------------------------------------
// Concrete Strategy - Credit Card Payment
// --------------------------------------------------
class CreditCardPayment
        implements PaymentStrategy {

    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(
            String cardNumber,
            String cardHolderName) {

        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {

        System.out.println(
                "Payment of ₹" + amount +
                " made using Credit Card.");

        System.out.println(
                "Card Holder: "
                        + cardHolderName);

        System.out.println(
                "Card Number: "
                        + cardNumber);
    }
}

// --------------------------------------------------
// Concrete Strategy - PayPal Payment
// --------------------------------------------------
class PayPalPayment
        implements PaymentStrategy {

    private String email;

    public PayPalPayment(String email) {

        this.email = email;
    }

    @Override
    public void pay(double amount) {

        System.out.println(
                "Payment of ₹" + amount +
                " made using PayPal.");

        System.out.println(
                "PayPal Account: "
                        + email);
    }
}

// --------------------------------------------------
// Context Class
// --------------------------------------------------
class PaymentContext {

    private PaymentStrategy strategy;

    public void setPaymentStrategy(
            PaymentStrategy strategy) {

        this.strategy = strategy;
    }

    public void executePayment(
            double amount) {

        if (strategy == null) {

            System.out.println(
                    "No Payment Strategy Selected.");

            return;
        }

        strategy.pay(amount);
    }
}

// --------------------------------------------------
// Main Test Class
// --------------------------------------------------
public class StrategyPatternExample {

    public static void main(String[] args) {

        System.out.println(
                "===== Strategy Pattern Demo =====\n");

        PaymentContext context =
                new PaymentContext();

        // -----------------------------
        // Credit Card Payment
        // -----------------------------
        System.out.println(
                "1. Credit Card Payment\n");

        context.setPaymentStrategy(
                new CreditCardPayment(
                        "1234-5678-9012",
                        "Sai Charan"));

        context.executePayment(5000);

        // -----------------------------
        // PayPal Payment
        // -----------------------------
        System.out.println(
                "\n-----------------------------\n");

        System.out.println(
                "2. PayPal Payment\n");

        context.setPaymentStrategy(
                new PayPalPayment(
                        "saicharan@gmail.com"));

        context.executePayment(7500);
    }
}