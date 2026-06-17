// Document Interface
interface Document {
    void open();
}

// Word Document
class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Word Document...");
    }
}

// PDF Document
class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening PDF Document...");
    }
}

// Excel Document
class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Excel Document...");
    }
}

// Abstract Factory
abstract class DocumentFactory {

    public abstract Document createDocument();

    // Common method
    public void displayDocument() {
        Document document = createDocument();
        document.open();
    }
}

// Word Factory
class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

// PDF Factory
class PdfDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

// Excel Factory
class ExcelDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// Main Test Class
public class FactoryMethodPatternExample {

    public static void main(String[] args) {

        System.out.println("===== Factory Method Pattern Demo =====\n");

        // Create Word Document
        DocumentFactory wordFactory =
                new WordDocumentFactory();

        Document wordDoc =
                wordFactory.createDocument();

        wordDoc.open();

        // Create PDF Document
        DocumentFactory pdfFactory =
                new PdfDocumentFactory();

        Document pdfDoc =
                pdfFactory.createDocument();

        pdfDoc.open();

        // Create Excel Document
        DocumentFactory excelFactory =
                new ExcelDocumentFactory();

        Document excelDoc =
                excelFactory.createDocument();

        excelDoc.open();
    }
}