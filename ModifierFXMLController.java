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
import javafx.scene.control.TextField;
import model.Avis;
import services.serviceAvis;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class ModifierFXMLController implements Initializable {
 Iavis sa = new serviceAvis () ;
    @FXML
    private TextField idComment;
    @FXML
    private TextField idAvis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
     sa.updateAvis(new Avis(Integer.valueOf(idAvis.getText()),idComment.getText()));
    }
    
}
