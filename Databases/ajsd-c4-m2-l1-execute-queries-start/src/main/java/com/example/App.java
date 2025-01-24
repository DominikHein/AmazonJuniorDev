package com.example;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // TODO 18: Declare a variable newUser of type User and initialize it by calling the constructor and passing the values as arguments betty.george, betty.george@email.com, Betty, George, +11536549870, 15000.
        User newUser = new User("betty.george", "betty.george@email.com", "Betty", "George", "+11536549870", 15000);
        
        // TODO 19: Declare a variable userDAO of type UserDAO, and initialize it by calling the constructor.
        UserDAO userDAO = new UserDAO();

        try {
            // TODO 20: Call the addUser method using the userDAO and passing the newUser as argument. Store the result in rowsUpdated variable of int type.
            int rowsUpdated = userDAO.addUser(newUser);
            
            // TODO 22: Inside the try block, use the if-else statement to check the rowsUpdated variable for a value equal to 1.
            if (rowsUpdated == 1) {
                // TODO 23: Inside the if block, display the message New user added successfully.
                System.out.println("New user added successfully.");
            } else {
                // TODO 24: Inside the else block, display the message Cannot add user.
                System.out.println("Cannot add user.");
            }
        } catch (ClassNotFoundException classNotFoundException) {
            // TODO 21: Surround the addUser method call with a try-catch block and handle the ClassNotFoundException and SQLException.
            classNotFoundException.printStackTrace();
        } catch (SQLException sqlException) {
            // Handle SQL exceptions
            sqlException.printStackTrace();
        }   
    }
}
