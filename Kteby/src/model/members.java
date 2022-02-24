/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author asus
 */
public class members {
    int id_user;
    int id_club ;

    public members(int id_club) {
        this.id_club = id_club;
    }

    public members() {
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_club() {
        return id_club;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    public members(int id_user, int id_club) {
        this.id_user = id_user;
        this.id_club = id_club;
    }
    
}
