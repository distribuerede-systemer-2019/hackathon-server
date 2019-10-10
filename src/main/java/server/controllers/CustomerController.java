package server.controllers;

import server.models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerController {
    private static DatabaseController dbCon;

    public static Customer getCustomer(int accountNo) {
        //TODO implement this
        return null;
    }

    public static ArrayList<Customer> getCustomers() {

        // Check for DB connection
        if (dbCon == null) {
            dbCon = new DatabaseController();
        }

        // Build SQL
        String sql = "SELECT * FROM customers";

        // Do the query and initialyze an empty list for use if we don't get results
        ResultSet rs = dbCon.query(sql);
        ArrayList<Customer> customers = new ArrayList<Customer>();

        try {
            // Loop through DB Data
            while (rs.next()) {
                Customer customer =
                        new Customer(
                                rs.getString("name"),
                                rs.getInt("balance"),
                                rs.getInt("account_no"));
                // Add element to list
                customers.add(customer);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // Return the list of users
        return customers;
    }

    public static Customer createCustomer(Customer customer) {
        //TODO implement this
        return null;
    }

    public static Customer updateCustomer(Customer customer) {
        //TODO implement this
        // The idea with this method is that you update an entire customer,
        // and thus doesn't need methods to change every field individually
        return null;
    }

}
