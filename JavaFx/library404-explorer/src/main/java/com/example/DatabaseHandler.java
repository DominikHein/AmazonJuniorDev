package com.example;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseHandler {

// TODO1: define the database URL in a private static final String variable
        private static final String url = "jdbc:mysql://localhost:3306/404booksnotfoundlibrary"; // Change this to your database URL
 // TODO2: define the database username in a private static final String variable
        private static final String username = "root"; // Change this to your MySQL username
 // TODO3: define the database password in a private static final String variable
         private static final String password = "password"; // Change this to your MySQL password

         static public Connection getDataBaseConnection() throws SQLException{
            // TODO5: use the DriverManager.getConnection method to establish a connection to the database
            // a. pass the url, username, and password variables as arguments to the getConnection method
            // b. add the return keyword to return the Connection object
            return DriverManager.getConnection(url, username, password);

         }

         // TODO7: define a public static method named fetchBooks that returns an ObservableList of Book objects
        public static ObservableList<Book> fetchBooks() throws SQLException{
            // TODO8: define an ObservableList of Book objects named books and initialize it with FXCollections.observableArrayList()
            ObservableList<Book> books = FXCollections.observableArrayList();
            // TODO9: define a String variable named query and assign the SQL query to select all columns from the book table
            String query = "SELECT * FROM book;";
            // TODO10: call the getDatabaseConnection method and assign the returned object to a Connection variable named libraryConnection
            Connection libraryConnection = getDataBaseConnection();
            // TODO11: add throws SQLException to the method signature
            // TODO12: call the createStatement method on the libraryConnection and assign the returned object to a Statement variable named queryStatement
            Statement queryStatement = libraryConnection.createStatement();
            // TODO13: call the executeQuery method on the queryStatement object with the query variable as an argument and assign the returned object to a ResultSet variable named booksResultSet
           ResultSet booksResultSet = queryStatement.executeQuery(query);
            // TODO14: use a while loop to iterate through the resultSet
            while(booksResultSet.next()) {
            // TODO15: store the value of the id column in the resultSet in an int variable named id
            int id = booksResultSet.getInt("id");
            // TODO16: store the value of the title column in the resultSet in a String variable named title
            String title = booksResultSet.getString("title");
            // TODO17: store the value of the author column in the resultSet in a String variable named author
            String author = booksResultSet.getString("author");
            // TODO18: store the value of the publication year column in the resultSet in an int variable named publicationYear
            int publicationYear = booksResultSet.getInt("publication_year");
            // TODO19: store the value of the genre column in the resultSet in a String variable named genre
            String genre = booksResultSet.getString("genre");


            // TODO20: create a new Book object with the id, title, author, publicationYear, and genre variables as arguments
            Book book = new Book(id, title, author, publicationYear, genre);
            // TODO21: add the book object to the books observable list
            books.add(book);
            }
            // TODO22: return the books observable list
            return books;
        }

}
