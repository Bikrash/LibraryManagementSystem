/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bikram
 */
public class Magazine extends Publication{
 static DBService service = new DBService();

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public static DBService getService() {
        return service;
    }

    public static void setService(DBService service) {
        Publication.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxBorrowDays() {
        return maxBorrowDays;
    }

    public void setMaxBorrowDays(int maxBorrowDays) {
        this.maxBorrowDays = maxBorrowDays;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }
     private String issueNumber;
     private Date publishDate;
     private int volume;
     public Magazine(String title){
        super(title);
    }
    public static Magazine[] findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfCopy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Magazine{"+ "title=" + title + "issueNumber=" + issueNumber + ", publishDate=" + publishDate + ", volume=" + volume + '}';
    }

    void load() {
         String query = "Select * from magazines where publication_id='" + this.id + "'";
        try {
            ResultSet resultSet = service.doQuery(query);
            if(resultSet.next()){
                this.issueNumber= resultSet.getString("issue_number");
                this.publishDate= resultSet.getDate("publish_date");
                this.volume= resultSet.getInt("volume");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
