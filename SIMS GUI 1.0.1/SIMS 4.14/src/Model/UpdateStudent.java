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
    
    private JDBCSetup setup = new JDBCSetup();
    private Connection conn;
    private Statement statement;
    
    public void AddStudent(String ID, String FirstName, String LastName, Date DOB) {
        
        String SQLAddToStudentStatement = "INSERT INTO STUDENT (STUDENTID, FIRSTNAME, LASTNAME, DOB, PAPERCODE) VALUES ('"+ID+"', '"+FirstName+"', '"+LastName+"', '"+DOB+"');";
        //Uses sql statement with JDBCSetup class
        setup.updateDB(SQLAddToStudentStatement);
    }
    
    public void DeleteStudent(String ID) {
        String sql = "DELETE FROM STUDENT WHERE STUDENTID ='"+ID+"';";
        setup.updateDB(sql);
        //Uses sql statement with JDBCSetup class
    }
}
