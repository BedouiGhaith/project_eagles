/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kteby;

import interfaces.Iutilisateur;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.utilisateur;
import services.serviceUtilisateur;

/**
 *
 * @author asus
 */
public class Kteby {
    /**
     * @param stage
     * @throws java.lang.Exception
     */

  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
         Iutilisateur su = new serviceUtilisateur();
        //users
       
        utilisateur u = new utilisateur("user", "00000000", "g@gmail.com", "ghaith", su.StringToDate("22-12-2000"), "admin");
        utilisateur updated_user = new utilisateur(48, "user", "11111111", "g@gmail.com", "bedoui", su.StringToDate("22-10-2000"), "admin");

       

        su.deleteUtilisateur(updated_user);
        su.ajouterUtilisateur(u);
        System.out.println(su.consulterUtilisateur());
        /*su.updateUtilisateur(updated_user, u);
        System.out.println(su.getUserById(su.consulterUtilisateur().get(0)));
        su.deleteUtilisateur(updated_user);
        
        
        String originalPassword = "password";

        String generatedSecuredPasswordHash;
        generatedSecuredPasswordHash = serviceUtilisateur.generateStorngPasswordHash(originalPassword);
        System.out.println(generatedSecuredPasswordHash);

        boolean matched = serviceUtilisateur.validatePassword("password", generatedSecuredPasswordHash);
        System.out.println(matched);

        matched = serviceUtilisateur.validatePassword("password1", generatedSecuredPasswordHash);
        System.out.println(matched);*/
    }

    
    

}
