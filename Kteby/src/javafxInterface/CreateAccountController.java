/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxInterface;

import interfaces.Iutilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.utilisateur;
import services.serviceUtilisateur;

/**
 * FXML Controller class
 *
 * @author bedou
 */
public class CreateAccountController implements Initializable {

    Iutilisateur su = new serviceUtilisateur();

    @FXML
    private TextField email;
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
    @FXML
    private TextField user;
    @FXML
    private DatePicker datepicker;
    @FXML
    private PasswordField cmdp;
    @FXML
    private PasswordField mdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void anuulerAction(ActionEvent event) {

    }

    @FXML
    private void confirmerAction(ActionEvent event) {
        
        System.out.println(datepicker.getValue().toString());
        System.out.println(java.sql.Date.valueOf(datepicker.getValue().toString()));

        if (email.getText().equals("") || prenom.getText().equals("") || nom.getText().equals("") || user.getText().equals("")
                || mdp.getText().equals("") || datepicker.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Veillez remplir tous les champs!");
            alert.show();
        } else if (!cmdp.getText().equals(mdp.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vérifier mot de passe!");
            alert.show();
        } else {
            utilisateur u = new utilisateur(user.getText(), mdp.getText(), email.getText(), nom.getText() + " " + prenom.getText(),
                    java.sql.Date.valueOf(datepicker.getValue().toString()), "lecteur");
            try {
                su.ajouterUtilisateur(u);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur de saisie!");
                alert.setContentText("Vérifier les données!");
                alert.show();

            }

        }
    }

}
