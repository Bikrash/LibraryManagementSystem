/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.Copy.service;

/**
 *
 * @author Bikram
 */
public class Book  extends Publication {

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    private String isbn;
    private String author;
    private int edition;

    public void setEdition(int edition) {
        this.edition = edition;
    }
    static DBService service = new DBService();
    public Book(String title){
        super(title);
    }
    
    public static Book[] findAll(String title) {
        return new Book[1];
        //.throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Book{"+ "title=" + title + "isbn=" + isbn + ", author=" + author + ", edition=" + edition + '}';
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfCopy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void load() {
         String query = "Select * from books where publication_id='" + this.id + "'";
        try {
            ResultSet resultSet = service.doQuery(query);
            if(resultSet.next()){
                this.isbn= resultSet.getString("isbn");
                this.author= resultSet.getString("author");
                this.edition= resultSet.getInt("edition");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
