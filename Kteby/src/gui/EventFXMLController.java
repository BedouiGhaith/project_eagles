/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Ievenement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.evenement;
import services.serviceEvent;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EventFXMLController implements Initializable {

    Ievenement evn = new serviceEvent();
    @FXML
    private TextField idevent;
    @FXML
    private TextField idclub;
    @FXML
    private TextField ideventdate;
    @FXML
    private TextField idDescription;
    @FXML
    private TextField ideventname;
    @FXML
    private Label listEvent;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
    private void submitaction(ActionEvent event) {
        evn.ajouterEvenement(new evenement(ideventname.getText(),idDescription.getText(),ideventdate.getText(),Integer.valueOf(idclub.getText())));
   
    }

    @FXML
    private void afficheraction(ActionEvent event) {
        listEvent.setText(evn.consulterEvenement().toString());
    }

    @FXML
    private void deleteaction(ActionEvent event) {
        evn.deleteEvenement(new evenement(Integer.valueOf(idevent.getText())));
    }

    @FXML
    private void updateaction(ActionEvent event) {
        evn.updateEvenement(new evenement(Integer.valueOf(idevent.getText()),ideventname.getText(),idDescription.getText(),ideventdate.getText(),Integer.valueOf(idclub.getText())));   
    }
    
    
    
}
