/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author user
 */
public class UpdateStudent {
    //add/delete students
    
    private JDBCSetup setup;
    private Connection conn;
    private Statement statement;
    
    public void AddStudent(String ID, String FirstName, String LastName, Date DOB) {
        
        
        setup = new JDBCSetup();
        
        String SQLAddToStudentStatement = "INSERT INTO STUDENT ("+ID+", "+FirstName+", "+LastName+", "+DOB+")";
        
        setup.updateDB(SQLAddToStudentStatement);
    }
    
    public void DeleteStudent(String ID) {
        
    }
}
