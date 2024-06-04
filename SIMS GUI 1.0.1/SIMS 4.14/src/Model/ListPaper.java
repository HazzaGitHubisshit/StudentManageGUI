/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ListPaper {
    private JDBCSetup database;
    
    public ListPaper() {
        database = new JDBCSetup();
    }
    
    public List<String> listnames() {
        List<String> names = new ArrayList<>();
        String sql = "SELECT PaperCode, PaperTitle FROM Papers";

        try {
            ResultSet resultSet = database.queryDB(sql);
            while (resultSet.next()) {
                String PaperCode = resultSet.getString("PaperCode");
                String PaperTitle = resultSet.getString("PaperTitle");
                names.add(PaperCode + ": " + PaperTitle);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            database.closeConnections();
        }

        return names;

    }
}
