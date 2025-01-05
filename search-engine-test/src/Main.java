import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        LibrarySerializer serializer = new LibrarySerializer();

        // Load the library data when the program starts
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully from src/resources/data/library.ser");
        } else {
            // If no serialized data is found, load the books from the default source (e.g., books.txt)
            System.out.println("Loading data from books.txt...");
            library.loadBooks("src/resources/data/books.txt");
        }

        // Create the library menu and start the interaction
        LibraryMenu menu = new LibraryMenu(library);
        menu.displayMenu();

        // Save the library data when the program exits
        serializer.saveLibrary(library.getBooks(), "src/resources/data/library.ser");
        System.out.println("Library saved to src/resources/data/library.ser");
    }
}
