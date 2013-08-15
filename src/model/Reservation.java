/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Bikram
 */
public class Reservation {

    public static void setMember(Member member) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Reservation(Publication publication, Member member) {
        this.publication = publication;
        this.member = member;
        this.reservationDate=new Date();
    }
    public void add(){
        //Insert into Reservation values(member.id,publication.id,publication.getClass().getSimpleName,reservationDate);
    }
    private Publication publication;
    private Member member;
    private Date reservationDate;
}
