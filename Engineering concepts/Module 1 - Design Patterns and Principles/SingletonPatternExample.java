// --------------------------------------------------
// Singleton Class
// --------------------------------------------------
class Logger {

    // Private static instance
    private static Logger instance;

    // Private constructor
    private Logger() {

        System.out.println(
                "Logger Instance Created");
    }

    // Public method to get instance
    public static Logger getInstance() {

        if (instance == null) {

            instance = new Logger();
        }

        return instance;
    }

    // Logging method
    public void log(String message) {

        System.out.println(
                "[LOG] " + message);
    }
}

// --------------------------------------------------
// Main Test Class
// --------------------------------------------------
public class SingletonPatternExample {

    public static void main(String[] args) {

        System.out.println(
                "===== Singleton Pattern Demo =====\n");

        // First Instance
        Logger logger1 =
                Logger.getInstance();

        logger1.log(
                "Application Started");

        // Second Instance Request
        Logger logger2 =
                Logger.getInstance();

        logger2.log(
                "User Logged In");

        // Third Instance Request
        Logger logger3 =
                Logger.getInstance();

        logger3.log(
                "Data Saved Successfully");

        System.out.println(
                "\nChecking Singleton Property...\n");

        System.out.println(
                "Logger1 HashCode : "
                        + logger1.hashCode());

        System.out.println(
                "Logger2 HashCode : "
                        + logger2.hashCode());

        System.out.println(
                "Logger3 HashCode : "
                        + logger3.hashCode());

        if (logger1 == logger2 &&
                logger2 == logger3) {

            System.out.println(
                    "\nSUCCESS: Only one Logger instance exists.");
        }
        else {

            System.out.println(
                    "\nERROR: Multiple Logger instances created.");
        }
    }
}