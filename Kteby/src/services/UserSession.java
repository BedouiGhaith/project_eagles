/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.HashSet;
import java.util.Set;
import java.util.prefs.Preferences;
import model.utilisateur;

/**
 *
 * @author bedou
 */
public final class UserSession {

    private static UserSession instance;

    private int id;
    private String userName;
    private String privileges;

    private UserSession(int id, String userName, String privileges) {
        this.id = id;
        this.userName = userName;
        this.privileges = privileges;
    }

    public static UserSession getInstace(int id, String userName, String privileges) {
        if (instance == null) {
            instance = new UserSession(id, userName, privileges);
        }
        return instance;
    }
    
    public static UserSession getInstace() {
       
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public String getPrivileges() {
        return privileges;
    }

    public int getId() {
        return id;
    }

    public void cleanUserSession() {
        id = 0;
        userName = null;
        privileges = null;
    }

    @Override
    public String toString() {
        return "UserSession{" + "id=" + id + ", userName=" + userName + ", privileges=" + privileges + '}';
    }

}
