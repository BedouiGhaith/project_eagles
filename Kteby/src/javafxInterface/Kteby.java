/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxInterface;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.UserSession;

/**
 *
 * @author asus
 */
public class Kteby extends Application {
    /**
     * @param stage
     * @throws java.lang.Exception
     */

    @Override
    public void start(Stage stage) throws Exception {
        
        

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root,700,500);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        //users
        /* utilisateur u = new utilisateur("user", "00000000", "g@gmail.com", "ghaith", 25, "admin");
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
        System.out.println(matched);*/
    }

    
    

}
