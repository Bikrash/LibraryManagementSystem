/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static model.Member.service;

/**
 *
 * @author Bikram
 */
public class Loan {

    private Member member;
    private Copy copy;
    private Date startDate, endDate;
    static DBService service = new DBService();

    static Loan find(Member aThis, Copy copy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Loan(Member member, Copy copy,Date startDate,Date endDate) {
        this.member = member;
        this.copy = copy;
        this.startDate=startDate;
        this.endDate=endDate;
    }

    public void add() throws SQLException {
        DateFormat sqlDateParser      = new SimpleDateFormat("yyyy-MM-dd");
        String query = "Insert into loans(copy_id,member_id,start_date,end_date) "
                       + " values('" + copy.getCopyId() + "' , '" + this.member.getMemberId() + "' , '"+ sqlDateParser.format(startDate) +"' , '"+ sqlDateParser.format(endDate) +"')";
        service.execute(query);
    }

    double calculateFine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void returnCopy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
