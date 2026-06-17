import java.util.Arrays;
import java.util.Comparator;

// Book Class
class Book {

    private int bookId;
    private String title;
    private String author;

    public Book(int bookId,
                String title,
                String author) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {

        return "Book ID: " + bookId +
               ", Title: " + title +
               ", Author: " + author;
    }
}

public class LibraryManagementSystem {

    // Linear Search
    public static Book linearSearch(
            Book[] books,
            String title) {

        for (Book book : books) {

            if (book.getTitle()
                    .equalsIgnoreCase(title)) {

                return book;
            }
        }

        return null;
    }

    // Binary Search
    public static Book binarySearch(
            Book[] books,
            String title) {

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int comparison =
                    books[mid]
                    .getTitle()
                    .compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            }

            if (comparison < 0) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return null;
    }

    // Display Books
    public static void displayBooks(Book[] books) {

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {

        Book[] books = {

                new Book(
                        101,
                        "Java",
                        "James Gosling"),

                new Book(
                        102,
                        "Python",
                        "Guido van Rossum"),

                new Book(
                        103,
                        "DBMS",
                        "Korth"),

                new Book(
                        104,
                        "C++",
                        "Bjarne Stroustrup"),

                new Book(
                        105,
                        "React",
                        "Jordan Walke")
        };

        System.out.println(
                "========== AVAILABLE BOOKS ==========\n");

        displayBooks(books);

        // Linear Search
        System.out.println(
                "\n========== LINEAR SEARCH ==========");

        Book linearResult =
                linearSearch(books, "DBMS");

        if (linearResult != null) {

            System.out.println(
                    "\nBook Found:");

            System.out.println(linearResult);
        }
        else {

            System.out.println(
                    "\nBook Not Found");
        }

        // Sort Books for Binary Search
        Book[] sortedBooks = books.clone();

        Arrays.sort(
                sortedBooks,
                Comparator.comparing(
                        Book::getTitle));

        System.out.println(
                "\n========== SORTED BOOKS ==========\n");

        displayBooks(sortedBooks);

        // Binary Search
        System.out.println(
                "\n========== BINARY SEARCH ==========");

        Book binaryResult =
                binarySearch(
                        sortedBooks,
                        "DBMS");

        if (binaryResult != null) {

            System.out.println(
                    "\nBook Found:");

            System.out.println(binaryResult);
        }
        else {

            System.out.println(
                    "\nBook Not Found");
        }
    }
}