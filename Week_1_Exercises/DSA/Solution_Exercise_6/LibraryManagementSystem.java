class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Getters and setters (omitted for brevity)
}

public class LibraryManagementSystem {
    private Book[] books;

    public LibraryManagementSystem(Book[] books) {
        this.books = books;
    }

    public int linearSearchByTitle(String targetTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(targetTitle)) {
                return i; // Found
            }
        }
        return -1; // Not found
    }

    public int binarySearchByTitle(String targetTitle) {
        int low = 0;
        int high = books.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(targetTitle);
            if (comparison == 0) {
                return mid; // Found
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        Book[] sampleBooks = {
                new Book(101, "The Catcher in the Rye", "J.D. Salinger"),
                new Book(102, "To Kill a Mockingbird", "Harper Lee"),
                // Add more books as needed
        };

        LibraryManagementSystem lms = new LibraryManagementSystem(sampleBooks);

        String targetTitle = "To Kill a Mockingbird";
        int linearResult = lms.linearSearchByTitle(targetTitle);
        int binaryResult = lms.binarySearchByTitle(targetTitle);

        if (linearResult != -1) {
            System.out.println("Found using linear search at index " + linearResult);
        } else {
            System.out.println("Book not found using linear search.");
        }

        if (binaryResult != -1) {
            System.out.println("Found using binary search at index " + binaryResult);
        } else {
            System.out.println("Book not found using binary search.");
        }
    }
}
