/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxInterface;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import interfaces.Iutilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.utilisateur;
import services.UserSession;
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
    @FXML
    private Hyperlink resetPwd;
    @FXML
    private Hyperlink Create;
    @FXML
    private AnchorPane linker;
    @FXML
    private FontAwesomeIcon end;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
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
            if (!login.isEmpty()) {
                System.out.println("Connecté!");
                utilisateur u = login.get(0);
                UserSession.getInstace(u.getId_user(), u.getNom_user(), u.getType());
                System.out.print(u.getType());
                
                if (UserSession.getInstace().getPrivileges().equals("admin")) {
                    Parent blah = FXMLLoader.load(getClass().getResource("UserTable.fxml"));
                    Scene scene = new Scene(blah);
                    Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    appStage.setScene(scene);
                    appStage.show();
                }
                if (UserSession.getInstace().getPrivileges().equals("bannis")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur de saisie !");
                    alert.setContentText("Compte Bannis!");
                    alert.show();
                }
            } else {
                System.out.println("Données Erronées!");

            }
        }
    }

    @FXML
    private void ResetPassword(ActionEvent event) {
        linker.toFront();
        Node node;
        try {

            node = (Node) FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));
            linker.getChildren().setAll(node);

        } catch (IOException ex) {

        }
    }

    @FXML
    private void CreateAccount(ActionEvent event) {
        linker.toFront();
        Node node;
        try {
            node = (Node) FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
            linker.getChildren().setAll(node);

        } catch (IOException ex) {

        }
    }

    @FXML
    private void close(MouseEvent event) {
        Platform.exit();
    }

}
