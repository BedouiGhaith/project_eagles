/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import interfaces.Iavis;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Avis;
import services.serviceAvis;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class AvisFXMLController implements Initializable {

    Iavis sa = new serviceAvis();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void goToDelete(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("deleteFXML.fxml"));
        Stage primaryStage = new Stage();
        Parent root = loader.load();
        Scene homescene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homescene);
        window.show();
        DeleteFXMLController ctc = loader.getController();

    }

    @FXML
    private void goToModifier(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("modifierFXML.fxml"));
        Stage primaryStage = new Stage();
        Parent root = loader.load();
        Scene homescene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homescene);
        window.show();
        ModifierFXMLController ctc = loader.getController();

    }

    @FXML
    private void goToAjouter(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("ajouterFXML.fxml"));
        Stage primaryStage = new Stage();
        Parent root = loader.load();
        Scene homescene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homescene);
        window.show();
        AjouterFXMLController ctc = loader.getController();

    }

    @FXML
    private void goToafficher(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("afficherFXML.fxml"));
        Stage primaryStage = new Stage();
        Parent root = loader.load();
        Scene homescene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homescene);
        window.show();
        AfficherFXMLController ctc = loader.getController();

    }

    @FXML
    private void goTcalculer(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("calculerFXML.fxml"));
        Stage primaryStage = new Stage();
        Parent root = loader.load();
        Scene homescene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homescene);
        window.show();
        CalculerFXMLController ctc = loader.getController();

    }

   

    @FXML
    private void react(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("reactFXML.fxml"));
        Stage primaryStage = new Stage();
        Parent root = loader.load();
        Scene homescene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homescene);
        window.show();
        ReactFXMLController ctc = loader.getController();

    
    }
}