import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooks(String fileName) {
        // TODO Missing Code
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Parse each line from the file
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    int publicationYear = Integer.parseInt(parts[2].trim());

                    books.add(new Book(title, author, publicationYear));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to view all books in the library
    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Method to search for a book by a keyword
    public Book searchBookByKeyword(String keyword) {
        // TODO 9: Ensure the search is case-insensitive
        keyword = keyword.toLowerCase();

        // TODO 10: Use a for-each loop to iterate over the books
        for (Book book : books) {
            // TODO 11: Check each condition
            if (book.getTitle().toLowerCase().contains(keyword) ||
                    book.getAuthor().toLowerCase().contains(keyword) ||
                    String.valueOf(book.getPublicationYear()).equals(keyword)) {
                return book; // Return the first matching book
            }
        }

        // Return null if no match is found
        return null;
    }



    // Getters and setters
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
