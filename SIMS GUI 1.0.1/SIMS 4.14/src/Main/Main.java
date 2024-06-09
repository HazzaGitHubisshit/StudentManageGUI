/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author user
 */

import Model.JDBCSetup;
import infosys.StudentManagementGUI;
import Model.SQLFoundation;

public class Main {
    public static void main(String[] args) {
        JDBCSetup jdbcSetup = new JDBCSetup();
        jdbcSetup.establishConnection();

//        Initialize the database and create tables
        SQLFoundation dbInitializer = new SQLFoundation(jdbcSetup);
        dbInitializer.createTables();

        // Launch the GUI
        StudentManagementGUI studentManagementGUI = new StudentManagementGUI();
        studentManagementGUI.setVisible(true);
    }
    
    
}
