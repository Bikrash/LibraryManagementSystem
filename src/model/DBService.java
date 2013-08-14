/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bikram
 */
public class DBService {

    private Connection connection = null;

    public DBService() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "");

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void execute(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(query);
    }
    public ResultSet doQuery(String query) throws SQLException{
        return connection.createStatement().executeQuery(query);
    }
}
