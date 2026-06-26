import java.util.List;

public class LibrarySearch {
    public static Book linearSearch(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(List<Book> sortedBooks, String title) {
        int low = 0;
        int high = sortedBooks.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = title.compareToIgnoreCase(sortedBooks.get(mid).getTitle());

            if (res == 0) return sortedBooks.get(mid);
            if (res > 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
}