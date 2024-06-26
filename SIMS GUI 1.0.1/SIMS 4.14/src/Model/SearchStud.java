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


public class SearchStud {

    private JDBCSetup database;

    //class for listing students based on arraylist, and select statement, the list will be displayed in gui
    public SearchStud() {
        database = new JDBCSetup();
    }

    //use list classes code to make combo box that you can select a name and it will display the full info
    public String getStudentDetails(String studentID) {
        String sql = "SELECT STUDENT, FIRSTNAME, LASTNAME FROM STUDENT WHERE STUDENT = '" + studentID + "'";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = database.getConnection();
            if (connection != null) {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);

                if (resultSet.next()) {
                    String id = resultSet.getString("STUDENT");
                    String firstName = resultSet.getString("FIRSTNAME");
                    String lastName = resultSet.getString("LASTNAME");
//                    Date dob = resultSet.getDate("DOB");
//                    String paperCode = resultSet.getString("PAPERCODE");
// I messed up with the date and decided against assigning and disassigning, so the app wont display their date or what paper theyre in anymore:)
                    return "Student's ID: " + id + "\nStudent's First Name: " + firstName + "\nStudent's Last Name: " + lastName + "\nThey are a cool student!";
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
