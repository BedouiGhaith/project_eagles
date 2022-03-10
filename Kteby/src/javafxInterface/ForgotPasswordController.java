/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxInterface;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import interfaces.Iutilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeMath.random;
import model.utilisateur;
import services.ServiceMail;
import services.serviceUtilisateur;

/**
 * FXML Controller class
 *
 * @author bedou
 */
public class ForgotPasswordController implements Initializable {

    private Random codev = new Random();
    int c;
    utilisateur u;

    Iutilisateur su = new serviceUtilisateur();

    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private Button confirm1;
    @FXML
    private TextField code;
    @FXML
    private Button confirm2;
    @FXML
    private TextField pwd;
    @FXML
    private TextField cpwd;
    @FXML
    private Button confirm3;
    @FXML
    private FontAwesomeIcon undo;
    @FXML
    private FontAwesomeIcon exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        code.setEditable(false);
        confirm2.setDisable(true);
        pwd.setEditable(false);
        cpwd.setEditable(false);
        confirm3.setDisable(true);

    }

    @FXML
    private void confirm1(ActionEvent event) {
        if (email.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vérifier votre Email!");
            alert.show();
        } else if (username.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vérifier votre Nom Utilisateur!");
            alert.show();
        } else {
            u = new utilisateur(username.getText(), email.getText());
            try {
                utilisateur user = su.getUserByUsername(u);
                if (!user.getEmail().equals(email.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur de saisie!");
                    alert.setContentText("Données Erronées!");
                    alert.show();

                } else {
                    c = codev.nextInt(999999999);
                    code.setEditable(true);
                    confirm2.setDisable(false);
                    ServiceMail sm = new ServiceMail("bedoui.ghaith@gmail.com", "eagles.esprit@gmail.com", "/projet123", "localhost", "PROJECT EAGLES", "Veuillez entrer ce code pour changer votre mot de passe: " + c);

                }
            } catch (Exception e) {

            }
        }
    }

    @FXML
    private void confirm2(ActionEvent event) {
        System.out.println(c);
        if (code.getText().equals(c + "")) {
            pwd.setEditable(true);
            cpwd.setEditable(true);
            confirm3.setDisable(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie!");
            alert.setContentText("Vérifier le code envoyé!");
            alert.show();
        }
    }

    @FXML
    private void confirm3(ActionEvent event) {
        if (pwd.getText().equals(cpwd.getText())&&(pwd.getText().length()>8)) {
            try {
                su.updatePassword(u);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Echec d'envoi!");
                alert.setContentText("Vérifier votre connexion!");
                alert.show();
            }
        }

    }

    @FXML
    private void undo(MouseEvent event) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void exit(ContextMenuEvent event) {
        Platform.exit();
    }

}
