/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bikram
 */
public class Main {
    public static void main(String[] args){
        Member m= new Member("faf", "asdf");
        try {
            System.out.println("adding");
            m.add();
            System.out.println("added");
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
}
