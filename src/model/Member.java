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
public class Member {

    public String getFullName() {
        return fullName;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getEmail() {
        return email;
    }

    public Member(String memberId, String fullName, String email) {
        this(memberId,fullName);
        this.email = email;
    }

    public Member(String memberId, String fullName) {
        this.fullName = fullName;
        this.memberId = memberId;
        
    }

    public static Member find(String memberId) {
        String query = "Select * from members where id='" + memberId + "'";
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

    public boolean exist() {
        try {
            String query = "Select * from members where id='" + memberId + "'";
            ResultSet resultSet = service.doQuery(query);
            return resultSet.next();
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void add() throws SQLException {

        String str = String.format("insert into members values('%s','%s','%s')", memberId,
                fullName, email);

        service.execute(str);

    }

    public static Member[] findAll() {
        return new Member[5];
    }

    public void borrow(Copy copy) {
        Loan loan = new Loan(this, copy);
        loan.add();

    }

    public void reserve(Publication publication) {
        // implement reserve publication
        Reservation reservation = new Reservation(publication, this);
        reservation.add();

    }

    public void returnBook(Copy copy) {
        Loan loan = Loan.find(this, copy);
        if (loan != null) {
            double fine = loan.calculateFine();
            if (fine > 0) {
                payFine(fine);
            }
            loan.returnCopy();
        }
    }
    private String fullName;
    private String memberId;
    private String email;
    static DBService service = new DBService();

    private void payFine(double fine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
