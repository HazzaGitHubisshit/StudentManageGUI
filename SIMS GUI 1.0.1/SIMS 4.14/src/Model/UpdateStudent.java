/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class UpdateStudent {
    //add/delete students

    private JDBCSetup setup = new JDBCSetup();
    private Connection conn;
    private Statement statement;

    public void AddStudent(String ID, String FirstName, String LastName) {

        String SQLAddToStudentStatement = "INSERT INTO STUDENT (STUDENT, FIRSTNAME, LASTNAME, DOB, PAPERCODE) VALUES ('" + ID + "', '" + FirstName + "', '" + LastName + "', '2004-01-01'," + " NULL)";
//        //Uses sql statement with JDBCSetup class
//        try (Connection conn = setup.getConnection();  
//            PreparedStatement pstmt = conn.prepareStatement(SQLAddToStudentStatement)) {
//
//            pstmt.setString(1, ID);
//            pstmt.setString(2, FirstName);
//            pstmt.setString(3, LastName);
//            pstmt.setDate(4, new java.sql.Date(DOB.getTime()));
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle or rethrow the exception as appropriate
//        }

        setup.updateDB(SQLAddToStudentStatement);
    }

    public void DeleteStudent(String ID) {
        String sql = "DELETE FROM STUDENT WHERE STUDENT ='" + ID + "'";
        setup.updateDB(sql);
        //Uses sql statement with JDBCSetup class
    }
}
