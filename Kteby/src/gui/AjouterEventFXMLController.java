/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Ievenement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.evenement;
import services.serviceEvent;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AjouterEventFXMLController implements Initializable {
    Ievenement evn = new serviceEvent();

    @FXML
    private TextField id_club;
    @FXML
    private TextField event_date;
    @FXML
    private TextField event_description;
    @FXML
    private TextField event_name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterevent(ActionEvent event) {
                evn.ajouterEvenement(new evenement(event_name.getText(),event_description.getText(),event_date.getText(),Integer.valueOf(id_club.getText())));

    }

    @FXML
    private void backtoEvent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("EventFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                EventFXMLController ctc=loader.getController();
    }
    
}
