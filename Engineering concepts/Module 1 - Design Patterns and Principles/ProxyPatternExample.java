// Subject Interface
interface Image {

    void display();
}

// ---------------------------------------------------
// Real Subject
// ---------------------------------------------------
class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {

        this.fileName = fileName;

        loadFromServer();
    }

    // Simulate expensive operation
    private void loadFromServer() {

        System.out.println(
                "Loading image from remote server: "
                        + fileName);
    }

    @Override
    public void display() {

        System.out.println(
                "Displaying image: "
                        + fileName);
    }
}

// ---------------------------------------------------
// Proxy Class
// ---------------------------------------------------
class ProxyImage implements Image {

    private String fileName;

    // Cache the RealImage object
    private RealImage realImage;

    public ProxyImage(String fileName) {

        this.fileName = fileName;
    }

    @Override
    public void display() {

        // Lazy Initialization
        if (realImage == null) {

            System.out.println(
                    "\n[Proxy] Image not loaded yet.");

            realImage =
                    new RealImage(fileName);
        }
        else {

            System.out.println(
                    "\n[Proxy] Using cached image.");
        }

        realImage.display();
    }
}

// ---------------------------------------------------
// Main Test Class
// ---------------------------------------------------
public class ProxyPatternExample {

    public static void main(String[] args) {

        System.out.println(
                "===== Proxy Pattern Demo =====\n");

        Image image =
                new ProxyImage(
                        "Nature.jpg");

        System.out.println(
                "Image object created.");

        System.out.println(
                "\nFirst Display Call:");

        image.display();

        System.out.println(
                "\nSecond Display Call:");

        image.display();

        System.out.println(
                "\nThird Display Call:");

        image.display();
    }
}