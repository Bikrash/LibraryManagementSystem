/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.Copy.service;

/**
 *
 * @author Bikram
 */
public abstract class Publication {

    static DBService service = new DBService();

    public int getMaxBorrowDays() {
        return maxBorrowDays;
    }

    public String getType() {
        return type;
    }
    protected int id, maxBorrowDays;
    protected String type;

    public static Publication find(String publicationId) {
        String query = "Select * from publications where id=" + publicationId;
        try {
            ResultSet resultSet = service.doQuery(query);
            if (resultSet.next()) {
                Publication publication;
                String publicationType = resultSet.getString("type");
                if (publicationType.equals("BK")) {
                    publication = new Book(resultSet.getString("title"));
                    publication.id = resultSet.getInt("id");
                    publication.type = publicationType;
                    publication.maxBorrowDays = resultSet.getInt("max_borrow_days");

                    Book book = (Book) publication;
                    book.load();
                } else {
                    publication = new Magazine(resultSet.getString("title"));
                    publication.id = resultSet.getInt("id");
                    publication.type = publicationType;
                    publication.maxBorrowDays = resultSet.getInt("max_borrow_days");
                    Magazine magazine = (Magazine) publication;
                    magazine.load();
                }
                return publication;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    String title;
    List<Copy> copies;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publication(String title) {
        this.title = title;
    }

    public static void myStatic() {
    }

    public abstract void add();

    public abstract int getNumberOfCopy();
}
