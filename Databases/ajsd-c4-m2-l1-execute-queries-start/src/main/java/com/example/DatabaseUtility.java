package com.example;
import java.sql.*;

/*
 * TODO 1: import the Connection, from java.sql package.
 */
public class DatabaseUtility{
    /*TODO 2: Define a public static method, getDbConnection, which return Connection and accepts three parameters String url, String userName, and String password. */
    public static Connection getDbConnection(String url, String userName, String password) throws ClassNotFoundException, SQLException{
    /*TODO 3: Load the MySQL driver class by using the Class.forName method and pass the driver class name as String. */
    Class.forName("com.mysql.cj.jdbc.Driver");
    /* TODO 4: Declare a variable of type Connection, name it clickNBuyConnection. */
    Connection connection = null;
    /*
            * TODO 5: Initialize clickNBuyConnection, by using DriverManager.getConnection method to establish the connection to the database (import java.sql.DriverManager)
               a. Pass url, userName, and password parameters to the getConnection method
               b. Return the clickNBuyConnection, by using the return keyword, with the clickNBuyConnection.
            */
    connection = DriverManager.getConnection(url, userName, password);
    /* TODO 6:  Add ‘throws ClassNotFoundException and SQLException’ to the method signature to forward the exception to the calling method (import java.sql.SQLException). */
    return connection;
    }
}


    