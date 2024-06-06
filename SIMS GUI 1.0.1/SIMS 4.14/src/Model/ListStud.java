/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class ListStud {

    private JDBCSetup database;
    //class for listing students based on arraylist, and select statement, the list will be displayed in gui
    public ListStud() {
        database = new JDBCSetup();
    }

    public List<String> listnames() {
        List<String> names = new ArrayList<>();
        String sql = "SELECT FIRSTNAME, LASTNAME FROM STUDENT"; 

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = database.getConnection(); // Ensure this returns a valid connection
            if (connection != null) {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    String firstName = resultSet.getString("FIRSTNAME");
                    String lastName = resultSet.getString("LASTNAME");
                    names.add(firstName + " " + lastName);
                }
            } else {
                System.out.println("Failed to make connection to database.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return names;

    }
//    
}

//public List<String> listnames() {
//        List<String> names = new ArrayList<>();
//        String sql = "SELECT FIRSTNAME, LASTNAME FROM STUDENT";
//
//        try {
//            ResultSet resultSet = database.queryDB(sql);
//            while (resultSet.next()) {
//                String firstName = resultSet.getString("FIRSTNAME");
//                String lastName = resultSet.getString("LASTNAME");
//                names.add(firstName + " " + lastName);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        } finally {
//            database.closeConnections();
//        }
//
//        return names;
//
//    }
