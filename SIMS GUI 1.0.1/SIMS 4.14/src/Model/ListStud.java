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
    
    public ListStud() {
        database = new JDBCSetup();
    }
    
    public List<String> listnames() {
        List<String> names = new ArrayList<>();
        String sql = "SELECT first_name, last_name FROM Students";

        try {
            ResultSet resultSet = database.queryDB(sql);
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                names.add(firstName + " " + lastName);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            database.closeConnections();
        }

        return names;

    }
}
