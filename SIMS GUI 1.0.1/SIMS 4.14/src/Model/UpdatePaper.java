/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UpdatePaper {
    
    //add/delete papers
    private JDBCSetup setup = new JDBCSetup();;
    private Connection conn;
    private Statement statement;
    
    
    public void AddPaper(String Code, String title, int level, int points, String description) {
        
        String SQLAddToPaperStatement = "INSERT INTO PAPER (PAPERCODE, PAPERTITLE, PAPERLEVEL, PAPERPOINTS, DESCRIPTION) VALUES ('"+Code+"', '"+title+"', "+level+", "+points+", '"+description+"')";
       //Uses sql statement with JDBCSetup class
        
//       


            
        setup.updateDB(SQLAddToPaperStatement);
    }
    
    
    public void DeletePaper(String Code) {
        
        String sql = "DELETE FROM PAPER WHERE PAPERCODE ='"+Code+"'";
        setup.updateDB(sql);
        //Uses sql statement with JDBCSetup class
    }
    
    
    


}
