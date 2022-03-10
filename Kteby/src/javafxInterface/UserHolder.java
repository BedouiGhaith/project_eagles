/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxInterface;

import model.utilisateur;

/**
 *
 * @author bedou
 */
public class UserHolder {

    private utilisateur user;
    private final static UserHolder INSTANCE = new UserHolder();

    private UserHolder() {
    }

    public static UserHolder getInstance() {
        return INSTANCE;
    }

    public void setUser(utilisateur u) {
        this.user = u;
    }

    public utilisateur getUser() {
        return this.user;
    }
}
