/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import interfaces.Iavis;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import services.serviceAvis;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class AfficherFXMLController implements Initializable {
Iavis sa = new serviceAvis () ;
    @FXML
    private Label lab_list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficher(ActionEvent event) {
        lab_list.setText(sa.consulterAvis().toString());
    }
    
}