/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bikram
 */
public class Copy {
     static DBService service = new DBService();
    public static Copy find(String copyId){
        String query = "Select * from copies where id='" + copyId + "'";
        try {
            ResultSet resultSet = service.doQuery(query);
            if(resultSet.next()){
                Member member = new Member(resultSet.getString("id"),resultSet.getString("fullName"),
                        resultSet.getString("email"));
                return member;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
