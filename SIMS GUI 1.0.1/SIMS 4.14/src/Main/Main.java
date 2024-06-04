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

public class Main {
    public static void main(String[] args) {
        JDBCSetup JBDCSetup = new JDBCSetup();
        JBDCSetup.establishConnection();

        
        StudentManagementGUI StudentManagementGUI = new StudentManagementGUI();
        StudentManagementGUI.setVisible(true);
    }
    
    
}
