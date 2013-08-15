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
     private String copyId;

    public String getCopyId() {
        return copyId;
    }
     private Publication publication;

    public Publication getPublication() {
        return publication;
    }

    public Copy(String copyId) {
        this.copyId = copyId;
    }
    
    public static boolean isExist(String copyId){
        String query = "Select * from copies where is_lost=0 and id='" + copyId + "'";
        try {
            ResultSet resultSet = service.doQuery(query);
            return resultSet.next();
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static Copy find(String copyId){
        String query = "Select * from copies where is_lost=0 and id='" + copyId + "'";
        try {
            ResultSet resultSet = service.doQuery(query);
            
            if(resultSet.next()){
                Copy copy= new Copy(resultSet.getString("id"));
                copy.publication = Publication.find(resultSet.getString("publication_id"));
                return copy;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
