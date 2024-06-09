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
import java.util.Date;

/**
 *
 * @author user
 */
public class SearchPaper {

    private JDBCSetup database;

    //class for listing students based on arraylist, and select statement, the list will be displayed in gui
    public SearchPaper() {
        database = new JDBCSetup();
    }

    //or use list classes code to make combo box that you can select a name and it will display the full info
    public String getPaperDetails(String code) {
        String sql = "SELECT * FROM PAPER WHERE PAPER = '" + code + "'";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = database.getConnection();
            if (connection != null) {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);

                if (resultSet.next()) {
                    String papercode = resultSet.getString("PAPERCODE");
                    String title = resultSet.getString("PAPERTITLE");
                    String levelStr = resultSet.getString("PAPERLEVEL");
                    String pointsStr = resultSet.getString("PAPERPOINTS");
                    String description = resultSet.getString("DESCRIPTION");
                    
                    int level = Integer.parseInt(levelStr);
                    int points = Integer.parseInt(pointsStr);
                    
                    return papercode + title + level + points + description;
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
        return null;

    }
}

//SELECT * FROM Customers
//WHERE CustomerName LIKE 'a%';
//or use list classes code to make combo box that you can select a name and it will display the full info

