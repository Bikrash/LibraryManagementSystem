/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Bikram
 */
public abstract class Publication {
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
    public static void myStatic(){
        
    }
    public abstract void add();
    public abstract int getNumberOfCopy();
}
