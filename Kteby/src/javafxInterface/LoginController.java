/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxInterface;

import interfaces.Iutilisateur;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.utilisateur;
import services.serviceUtilisateur;

/**
 * FXML Controller class
 *
 * @author bedou
 */
public class LoginController implements Initializable {
    
    Iutilisateur su = new serviceUtilisateur();

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        if (username.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous n'avez pas saisie votre nom d'utilisateur!");
            alert.show();

        } else if (password.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous n'avez pas saisie votre mot de passe!");
            alert.show();
        } else {
            List<utilisateur> login = new ArrayList<>();
            login = su.login(username.getText(), password.getText());
            if (login.isEmpty()) {
                System.out.println("Données Erronées!");
            } else {
                
                System.out.println("Connecté!");
            }
    }
    }
    @FXML
    private void signin(ActionEvent event) {
    }
    
}
