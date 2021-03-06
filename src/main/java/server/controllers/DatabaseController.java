package server.controllers;

import server.utils.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseController {

    private static Connection connection;

    public DatabaseController() {
        connection = getConnection();
    }

    public static Connection getConnection() {
        try {
            // Set the dataabase connect with the data from the config
            String url =
                    "jdbc:mysql://"
                            + Config.getDatabaseHost()
                            + ":"
                            + Config.getDatabasePort()
                            + "/"
                            + Config.getDatabaseName()
                            + "?serverTimezone=CET";

            String user = Config.getDatabaseUsername();
            String password = Config.getDatabasePassword();

            // Register the driver in order to use it
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // create a connection to the database
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public ResultSet query(String sql) {
        if (connection == null)
            connection = getConnection();
        ResultSet rs = null;
        try {
            // Build the statement as a prepared statement
            PreparedStatement ps = connection.prepareStatement(sql);

            // Actually fire the query to the DB
            boolean retrievedSucessfully = ps.execute();
            //check if successfull
            if(retrievedSucessfully)
                rs = ps.getResultSet();
            else System.out.println("Something went wrong");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // Return the resultset which at this point will be null if somethis went wrong
        return rs;
    }
}
