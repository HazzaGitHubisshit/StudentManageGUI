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

/**
 *
 * @author user
 */
public class SQLFoundation {

    //this will be for tables
    private JDBCSetup setup;
    private Connection conn;

    public SQLFoundation() {
        setup = new JDBCSetup();
        conn = setup.getConnection();
    }

    public void runDatabaseSetup(Connection connection) throws SQLException {
        SQLFoundation sql = new SQLFoundation();
        try ( Statement statement = connection.createStatement()) {

            if (sql.tableExists("PAPER")) {
                statement.executeUpdate("DROP TABLE PAPER");

            }
            String PaperTable = "CREATE TABLE PAPER (PAPERCODE VARCHAR(7) PRIMARY KEY, PAPERTITLE VARCHAR(255), PAPERLEVEL INT, PAPERPOINTS INT, DESCRIPTION VARCHAR(255))";
            statement.executeUpdate(PaperTable);

            if (sql.tableExists("STUDENT")) {
                statement.executeUpdate("DROP TABLE STUDENT");

            }
            String StudentTable = "CREATE TABLE STUDENT (STUDENT CHAR(8) PRIMARY KEY, FIRSTNAME VARCHAR(50) NOT NULL, LASTNAME VARCHAR(50) NOT NULL, DOB DATE NOT NULL, PAPERCODE VARCHAR(10), FOREIGN KEY (PAPERCODE) REFERENCES PAPER(PAPERCODE));";
            statement.executeUpdate(StudentTable);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private boolean tableExists(String tableName) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        try ( ResultSet resultSet = metaData.getTables(null, null, tableName, null)) {
            return resultSet.next();
        }
    }
}

//        try (Statement statement = connection.createStatement()) {
//            // Create a table
//            String createTableSQL = "CREATE TABLE IF NOT EXISTS USERS " +
//                                    "(ID INT PRIMARY KEY, NAME VARCHAR(255), EMAIL VARCHAR(255))";
//            statement.execute(createTableSQL);
//
//            // Insert some data
//            String insertDataSQL = "INSERT INTO USERS (ID, NAME, EMAIL) VALUES (1, 'John Doe', 'john@example.com')";
//            statement.execute(insertDataSQL);
//
//            System.out.println("Database setup completed.");
