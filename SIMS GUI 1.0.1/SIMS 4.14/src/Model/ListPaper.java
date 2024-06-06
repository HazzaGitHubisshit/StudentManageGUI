/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ListPaper {
    private JDBCSetup database;
    //class for listing students based on arraylist, and select statement, the list will be displayed in gui
    public ListPaper() {
        database = new JDBCSetup();
    }
    
    
    
    public List<String> listnames() {
        List<String> names = new ArrayList<>();
        String sql = "SELECT PAPERCODE, PAPERTITLE FROM PAPER"; // Assuming APP schema is the default schema

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = database.getConnection(); // Ensure this returns a valid connection
            if (connection != null) {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    String paperCode = resultSet.getString("PAPERCODE");
                    String paperTitle = resultSet.getString("PAPERTITLE");
                    names.add(paperCode + ": " + paperTitle);
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

}



//    public List<String> listnames() {
//        List<String> names = new ArrayList<>();
//        String sql = "SELECT PAPERCODE, PAPERTITLE FROM PAPER";
//
//        try {
//            ResultSet resultSet = database.queryDB(sql);
//            while (resultSet.next()) {
//                String PaperCode = resultSet.getString("PAPERCODE");
//                String PaperTitle = resultSet.getString("PAPERTITLE");
//                names.add(PaperCode + ": " + PaperTitle);
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
