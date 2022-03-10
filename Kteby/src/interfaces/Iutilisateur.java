/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Date;
import java.util.List;
import model.utilisateur;

/**
 *
 * @author asus
 */
public interface Iutilisateur {

    public void ajouterUtilisateur(utilisateur u);

    public void deleteUtilisateur(utilisateur s);

    public void updateUtilisateur(utilisateur u, utilisateur s);

    public List<utilisateur> consulterUtilisateur();

    public utilisateur getUserById(utilisateur u);

    public utilisateur getUserByEmail(utilisateur u);

    public List<utilisateur> getUserByName(utilisateur u);

    public utilisateur getUserByUsername(utilisateur u);

    public List<utilisateur> getUserByAge(utilisateur u);

    public List<utilisateur> login(String u, String p);

    public java.sql.Date tosqldate(java.util.Date date);

    public java.util.Date StringToDate(String s);

    public void updatePassword(utilisateur u);
    
    public void banUser(utilisateur u);
    
    public void unbanUser(utilisateur u);
}
