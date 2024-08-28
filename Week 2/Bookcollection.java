
import java.util.LinkedHashSet;

public class BookCollection {
    private LinkedHashSet<String> books;

    public BookCollection() {
        books = new LinkedHashSet<>();
    }

    public void addBook(String bookTitle) {
        if (books.add(bookTitle)) {
            System.out.println(bookTitle + " added to the collection.");
        } else {
            System.out.println(bookTitle + " is already in the collection.");
        }
    }

    public void removeBook(String bookTitle) {
        if (books.remove(bookTitle)) {
            System.out.println(bookTitle + " removed from the collection.");
        } else {
            System.out.println(bookTitle + " not found in the collection.");
        }
    }

    public void displayBooks() {
        System.out.println("Book Collection: " + books);
    }
}


public class BookCollectionTest {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();

        collection.addBook("The Great Gatsby");
        collection.addBook("1984");
        collection.addBook("To Kill a Mockingbird");

        collection.displayBooks();

        collection.removeBook("1984");

        collection.displayBooks();
    }
}
