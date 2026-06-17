// Component Interface
interface Notifier {

    void send(String message);
}

// --------------------------------------------------
// Concrete Component
// --------------------------------------------------
class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {

        System.out.println(
                "Email Notification Sent: "
                        + message);
    }
}

// --------------------------------------------------
// Abstract Decorator
// --------------------------------------------------
abstract class NotifierDecorator
        implements Notifier {

    protected Notifier notifier;

    public NotifierDecorator(
            Notifier notifier) {

        this.notifier = notifier;
    }

    @Override
    public void send(String message) {

        notifier.send(message);
    }
}

// --------------------------------------------------
// SMS Decorator
// --------------------------------------------------
class SMSNotifierDecorator
        extends NotifierDecorator {

    public SMSNotifierDecorator(
            Notifier notifier) {

        super(notifier);
    }

    @Override
    public void send(String message) {

        super.send(message);

        sendSMS(message);
    }

    private void sendSMS(String message) {

        System.out.println(
                "SMS Notification Sent: "
                        + message);
    }
}

// --------------------------------------------------
// Slack Decorator
// --------------------------------------------------
class SlackNotifierDecorator
        extends NotifierDecorator {

    public SlackNotifierDecorator(
            Notifier notifier) {

        super(notifier);
    }

    @Override
    public void send(String message) {

        super.send(message);

        sendSlack(message);
    }

    private void sendSlack(String message) {

        System.out.println(
                "Slack Notification Sent: "
                        + message);
    }
}

// --------------------------------------------------
// Main Test Class
// --------------------------------------------------
public class DecoratorPatternExample {

    public static void main(String[] args) {

        System.out.println(
                "===== Decorator Pattern Demo =====\n");

        // Email Only
        System.out.println(
                "1. Email Notification:\n");

        Notifier emailNotifier =
                new EmailNotifier();

        emailNotifier.send(
                "System Update Available");

        System.out.println(
                "\n---------------------------------\n");

        // Email + SMS
        System.out.println(
                "2. Email + SMS Notification:\n");

        Notifier emailAndSMS =
                new SMSNotifierDecorator(
                        new EmailNotifier());

        emailAndSMS.send(
                "Server Maintenance Scheduled");

        System.out.println(
                "\n---------------------------------\n");

        // Email + SMS + Slack
        System.out.println(
                "3. Email + SMS + Slack Notification:\n");

        Notifier multiChannelNotifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        multiChannelNotifier.send(
                "Critical Security Alert");
    }
}