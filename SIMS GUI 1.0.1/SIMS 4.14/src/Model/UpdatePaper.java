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
public class UpdatePaper {
    
    //add/delete papers
    private JDBCSetup setup;
    private Connection conn;
    private Statement statement;
    
    
    public void AddPaper(String Code, String title, int level, int points, String description) {
        
        
        setup = new JDBCSetup();
        
        String SQLAddToPaperStatement = "INSERT INTO PAPER ("+Code+", "+title+", "+level+", "+points+", "+description+")";
        
        setup.updateDB(SQLAddToPaperStatement);
    }
    
    
    public void DeletePaper(String Code) {
        
    }
    
    
    


}
