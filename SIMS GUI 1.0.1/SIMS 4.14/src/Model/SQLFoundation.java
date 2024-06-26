/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLFoundation {

    //this will be for tables
    private JDBCSetup dbSetup;

    public SQLFoundation(JDBCSetup dbSetup) {
        this.dbSetup = dbSetup;
    }

    public void createTables() {
        Connection conn = dbSetup.getConnection();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            DatabaseMetaData dbMetaData = conn.getMetaData();
            ResultSet rs = dbMetaData.getSchemas(null, "SIMS");
            if (!rs.next()) {
                // Schema does not exist, create it
                stmt.executeUpdate("CREATE SCHEMA SIMS");
                System.out.println("Schema SIMS created successfully.");
            }

            // Set the schema to SIMS
            stmt.executeUpdate("SET SCHEMA SIMS");

            // Check if the Papers table exists
            rs = dbMetaData.getTables(null, "SIMS", "PAPER", null);
            if (!rs.next()) {
                // Courses table does not exist, create it
                String createPapersTable = "CREATE TABLE PAPER (PAPERCODE VARCHAR(7) PRIMARY KEY, PAPERTITLE VARCHAR(255), PAPERLEVEL INT, PAPERPOINTS INT, DESCRIPTION VARCHAR(255))";
                stmt.executeUpdate(createPapersTable);
                System.out.println("Paper table created successfully.");
            }

            // Check if the Students table exists
            rs = dbMetaData.getTables(null, "SIMS", "STUDENT", null);
            if (!rs.next()) {
                // Students table does not exist, create it
                String createStudentsTable = "CREATE TABLE STUDENT (STUDENT CHAR(8) PRIMARY KEY, FIRSTNAME VARCHAR(50) NOT NULL, LASTNAME VARCHAR(50) NOT NULL, DOB DATE NOT NULL, PAPERCODE VARCHAR(7), FOREIGN KEY (PAPERCODE) REFERENCES PAPER(PAPERCODE))";
                stmt.executeUpdate(createStudentsTable);
                System.out.println("Student table created successfully.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}


