/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxInterface;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import interfaces.Iutilisateur;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.utilisateur;
import services.serviceUtilisateur;

/**
 * FXML Controller class
 *
 * @author bedou
 */
public class UpdateAccountController implements Initializable {

    Iutilisateur su = new serviceUtilisateur();

    @FXML
    private TextField user;
    @FXML
    private PasswordField mdp;
    @FXML
    private PasswordField cmdp;
    @FXML
    private TextField email;
    @FXML
    private TextField nom;
    @FXML
    private DatePicker datepicker;
    @FXML
    private FontAwesomeIcon undo;
    @FXML
    private FontAwesomeIcon exit;
    @FXML
    private AnchorPane anchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        undo.setVisible(false);
        user.setText(UserHolder.getInstance().getUser().getNom_user());
        user.setEditable(false);
        email.setText(UserHolder.getInstance().getUser().getEmail());
        nom.setText(UserHolder.getInstance().getUser().getPrenom());
        datepicker.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0);
            }
        });
        datepicker.setPromptText(UserHolder.getInstance().getUser().getAge().toString());

        // TODO
    }

    @FXML
    private void confirmerAction(ActionEvent event) {

        if (email.getText().equals("") || nom.getText().equals("") || user.getText().equals("")
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
            try {
                utilisateur newUser = new utilisateur(user.getText(), mdp.getText(), email.getText(), nom.getText(), java.sql.Date.valueOf(datepicker.getValue().toString()), "lecteur");
                su.updateUtilisateur(newUser, newUser);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succés");
                alert.setHeaderText("Succés");
                alert.setContentText("Utilisateur modifié");
                alert.show();
                Stage stage = (Stage) anchor.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur!");
                alert.setContentText("Erreur");
                alert.show();

            }
        }
    }

    @FXML
    private void undo(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    private void exit(MouseEvent event) {
        Stage stage = (Stage) anchor.getScene().getWindow();
        stage.close();
    }

}
