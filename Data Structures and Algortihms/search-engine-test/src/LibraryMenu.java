import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();  // Added serializer

    public LibraryMenu(Library library) {
        this.library = library;

        // Load the library data when the program starts
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks("src/resources/data/books.txt");
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // TODO 14: Display menu options
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. View All Books");
            System.out.println("2. Sort Books by Title");
            System.out.println("3. Sort Books by Author");
            System.out.println("4. Sort Books by Year");
            System.out.println("5. Search for a Book by keyword");
            System.out.println("6. Exit");

            // TODO 15: Read the user's choice
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // To consume the newline character

            // Handle the user's choice using a switch statement
            switch (choice) {
                case 1:
                    // View all books
                    library.viewAllBooks();
                    break;

                case 2:
                    // Sort books by title
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
                    System.out.println("\nBooks sorted by title:");
                    library.viewAllBooks();
                    break;

                case 3:
                    // Sort books by author
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                    System.out.println("\nBooks sorted by author:");
                    library.viewAllBooks();
                    break;

                case 4:
                    // Sort books by publication year
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparingInt(Book::getPublicationYear));
                    System.out.println("\nBooks sorted by year:");
                    library.viewAllBooks();
                    break;

                case 5:
                    // Search for a book by keyword
                    System.out.print("Enter a keyword to search (title, author, or year): ");
                    String keyword = scanner.nextLine();
                    Book foundBook = library.searchBookByKeyword(keyword);
                    if (foundBook != null) {
                        System.out.println("\nBook found: " + foundBook);
                    } else {
                        System.out.println("\nBook not found.");
                    }
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting the program.");
                    return;  // Exits the method and terminates the program

                default:
                    // Invalid input
                    System.out.println("\nInvalid choice. Please try again.");
                    break;
            }
        }
    }
}
