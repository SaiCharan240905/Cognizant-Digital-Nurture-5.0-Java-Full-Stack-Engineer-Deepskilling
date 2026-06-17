// Target Interface
interface PaymentProcessor {

    void processPayment(double amount);
}

// ------------------------------
// Adaptee Class 1 - Razorpay
// ------------------------------
class RazorpayGateway {

    public void pay(double amount) {

        System.out.println(
                "Payment of ₹" + amount +
                " processed through Razorpay.");
    }
}

// ------------------------------
// Adaptee Class 2 - PayPal
// ------------------------------
class PaypalGateway {

    public void makePayment(double amount) {

        System.out.println(
                "Payment of ₹" + amount +
                " processed through PayPal.");
    }
}

// ------------------------------
// Adaptee Class 3 - Stripe
// ------------------------------
class StripeGateway {

    public void sendPayment(double amount) {

        System.out.println(
                "Payment of ₹" + amount +
                " processed through Stripe.");
    }
}

// ------------------------------
// Adapter for Razorpay
// ------------------------------
class RazorpayAdapter
        implements PaymentProcessor {

    private RazorpayGateway gateway;

    public RazorpayAdapter() {
        gateway = new RazorpayGateway();
    }

    @Override
    public void processPayment(double amount) {

        gateway.pay(amount);
    }
}

// ------------------------------
// Adapter for PayPal
// ------------------------------
class PaypalAdapter
        implements PaymentProcessor {

    private PaypalGateway gateway;

    public PaypalAdapter() {
        gateway = new PaypalGateway();
    }

    @Override
    public void processPayment(double amount) {

        gateway.makePayment(amount);
    }
}

// ------------------------------
// Adapter for Stripe
// ------------------------------
class StripeAdapter
        implements PaymentProcessor {

    private StripeGateway gateway;

    public StripeAdapter() {
        gateway = new StripeGateway();
    }

    @Override
    public void processPayment(double amount) {

        gateway.sendPayment(amount);
    }
}

// ------------------------------
// Main Test Class
// ------------------------------
public class AdapterPatternExample {

    public static void main(String[] args) {

        System.out.println(
                "===== Adapter Pattern Demo =====\n");

        // Razorpay
        PaymentProcessor razorpay =
                new RazorpayAdapter();

        razorpay.processPayment(5000);

        // PayPal
        PaymentProcessor paypal =
                new PaypalAdapter();

        paypal.processPayment(7500);

        // Stripe
        PaymentProcessor stripe =
                new StripeAdapter();

        stripe.processPayment(10000);
    }
}