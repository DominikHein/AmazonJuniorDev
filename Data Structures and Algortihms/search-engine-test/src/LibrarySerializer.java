import java.io.*;
import java.util.List;

public class LibrarySerializer {

    // Save the list of books to a file
    public void saveLibrary(List<Book> books, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // Serialize the books list and write it to the file
            oos.writeObject(books);
            System.out.println("Library saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load the list of books from a file
    public List<Book> loadLibrary(String fileName) {
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {
            return null; // Return null if the file doesn't exist or is empty
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            // Deserialize the books list from the file
            return (List<Book>) ois.readObject();
        } catch (EOFException e) {
            System.err.println("The file is empty or corrupted: " + fileName);
            return null; // Handle empty or corrupted file
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
