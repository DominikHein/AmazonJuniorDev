package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public static final String URL = "jdbc:mysql://localhost:3306/clicknbuy";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "password";

    /* TODO 10: Define the public addUser method, which returns an integer, and accepts one parameter User newUser */
    public int addUser(User newUser) throws ClassNotFoundException, SQLException {
        
        /* TODO 11: Declare a variable Connection clickNBuyConnection and initialize it by calling the getDbConnection method of the DatabaseUtility class and passing url, userName, and password (import java.sql.Connection) */
        Connection clickNBuyConnection = DatabaseUtility.getDbConnection(URL, USER_NAME, PASSWORD);

        /* TODO 13: Declare a variable sqlQuery of type String and initialize it, with the parameterized insert query. */
        String sqlQuery = "INSERT INTO clicknbuy.user (username, user_email, first_name, last_name, phone_number, reward_points) VALUES (?,?,?,?,?,?)";

        /* TODO 14: Declare a variable insertPreparedStatement of type PreparedStatement and initialize it by calling the method prepareStatement using the clickNBuyConnection reference and pass the sqlQuery (import java.sql.PreparedStatement) */
        PreparedStatement insertPreparedStatement = clickNBuyConnection.prepareStatement(sqlQuery);
        
        /* TODO 15: Use the insertPreparedStatement to set all the parameters of sqlQuery, by using the corresponding set methods of PreparedStatement and set the values using the newUser parameter. */
        insertPreparedStatement.setString(1, newUser.getUserName());
        insertPreparedStatement.setString(2, newUser.getUserEmail());
        insertPreparedStatement.setString(3, newUser.getFirstName());
        insertPreparedStatement.setString(4, newUser.getLastName());
        insertPreparedStatement.setString(5, newUser.getPhoneNumber());
        insertPreparedStatement.setInt(6, newUser.getRewardPoints());

        /* TODO 16: Declare a variable int rowsUpdated and initialize it by calling executeUpdate method using the insertPreparedStatement. */
        int rowsUpdated = insertPreparedStatement.executeUpdate();
        
        /* TODO 17: Return the rowsUpdated variable. */
        return rowsUpdated; 
    }
}
