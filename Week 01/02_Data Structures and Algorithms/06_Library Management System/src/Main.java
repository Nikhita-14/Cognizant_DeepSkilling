import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> library = new ArrayList<>();
        library.add(new Book("B001", "Design Patterns", "Gang of Four"));
        library.add(new Book("B002", "Clean Code", "Robert C. Martin"));
        library.add(new Book("B003", "Effective Java", "Joshua Bloch"));
        library.add(new Book("B004", "Introduction to Algorithms", "CLRS"));

        System.out.println("--- Testing Linear Search (Unsorted Data) ---");
        Book foundLinear = LibrarySearch.linearSearch(library, "Clean Code");
        if (foundLinear != null) {
            System.out.println("Found: " + foundLinear.getTitle() + " by " + foundLinear.getAuthor());
        } else {
            System.out.println("Book not found.");
        }

        Collections.sort(library, Comparator.comparing(Book::getTitle));

        System.out.println("\n--- Testing Binary Search (Sorted Data) ---");
        Book foundBinary = LibrarySearch.binarySearch(library, "Effective Java");
        if (foundBinary != null) {
            System.out.println("Found: " + foundBinary.getTitle() + " by " + foundBinary.getAuthor());
        } else {
            System.out.println("Book not found.");
        }
    }
}