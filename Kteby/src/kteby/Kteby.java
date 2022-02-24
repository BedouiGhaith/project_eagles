/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kteby;

import interfaces.Iutilisateur;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import model.utilisateur;
import services.serviceUtilisateur;

/**
 *
 * @author asus
 */
public class Kteby {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {

        //users
        utilisateur u = new utilisateur("user", "00000000", "g@gmail.com", "ghaith", 25, "admin");
        utilisateur updated_user = new utilisateur(48, "user", "11111111", "g@gmail.com", "bedoui", 25, "admin");

        Iutilisateur su = new serviceUtilisateur();

        su.deleteUtilisateur(updated_user);
        su.ajouterUtilisateur(u);
        System.out.println(su.consulterUtilisateur());
        su.updateUtilisateur(updated_user, u);
        System.out.println(su.getUserById(su.consulterUtilisateur().get(0)));
        su.deleteUtilisateur(updated_user);
        
        
        String originalPassword = "password";

        String generatedSecuredPasswordHash;
        generatedSecuredPasswordHash = serviceUtilisateur.generateStorngPasswordHash(originalPassword);
        System.out.println(generatedSecuredPasswordHash);

        boolean matched = serviceUtilisateur.validatePassword("password", generatedSecuredPasswordHash);
        System.out.println(matched);

        matched = serviceUtilisateur.validatePassword("password1", generatedSecuredPasswordHash);
        System.out.println(matched);

    }

}
