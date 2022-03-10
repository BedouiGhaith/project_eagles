
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
import javafx.stage.StageStyle;
import services.ServiceMail;
import services.serviceUtilisateur;

/**
 * FXML Controller class
 *
 * @author bedou
 */
public class CodeVerifController implements Initializable {

    Iutilisateur su = new serviceUtilisateur();

    @FXML
    private Button confirm;
    @FXML
    private TextField code;

    Random codev = new Random();
    int c = codev.nextInt(999999999);
    ServiceMail sm = new ServiceMail(UserHolder.getInstance().getUser().getEmail(), "eagles.esprit@gmail.com", "/projet123", "localhost", "PROJECT EAGLES", "Veuillez entrer ce code pour changer votre mot de passe: " + c);
    @FXML
    private FontAwesomeIcon undo;
    @FXML
    private FontAwesomeIcon exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void checkCode(ActionEvent event) {
        try {
            if (code.getText().equals(c + "")) {

                su.ajouterUtilisateur(UserHolder.getInstance().getUser());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succés");
                alert.setHeaderText("Compte ajouté");
                alert.setContentText("Bienvenue sur notre plateforme!");
                alert.showAndWait();
                Parent blah = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Scene scene = new Scene(blah);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur de saisie !");
                alert.setContentText("Code erroné!");
                alert.show();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur!");
            alert.setContentText("Erreur inconnue!");
            alert.show();
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
