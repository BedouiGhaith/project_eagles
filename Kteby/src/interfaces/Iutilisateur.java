/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.utilisateur;

/**
 *
 * @author asus
 */
public interface Iutilisateur {
     public void ajouterUtilisateur(utilisateur u);
   public void deleteUtilisateur(utilisateur s);
   public void updateUtilisateur(utilisateur u,utilisateur s);
   public List<utilisateur> consulterUtilisateur();
   public utilisateur getUserById(utilisateur u);
   public utilisateur getUserByEmail(utilisateur u);
   public List<utilisateur> getUserByName(utilisateur u);
   public utilisateur getUserByUsername(utilisateur u);
   public List<utilisateur> getUserByAge(utilisateur u);
   public int countUsers();
   
}
