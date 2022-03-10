/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxInterface;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import interfaces.Iutilisateur;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.utilisateur;
import services.ServiceMail;
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
    @FXML
    private FontAwesomeIcon undo;
    @FXML
    private FontAwesomeIcon exit;
    @FXML
    private Button confirm1;
    private TextField code;
    @FXML
    private AnchorPane linker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        datepicker.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0);
            }
        });
    }

    @FXML
    private void confirmerAction(ActionEvent event) throws IOException {

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
            UserHolder.getInstance().setUser(u);
            linker.toFront();
            Node node;
            try {
                node = (Node) FXMLLoader.load(getClass().getResource("CodeVerif.fxml"));
                linker.getChildren().setAll(node);

            } catch (IOException ex) {

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
