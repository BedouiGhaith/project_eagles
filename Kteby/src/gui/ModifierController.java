/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Ireclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.reclamation;
import services.serviceReclamation;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ModifierController implements Initializable {
        Ireclamation rec = new serviceReclamation();


    @FXML
    private TextField titre;
    @FXML
    private TextField description;
    @FXML
    private TextField idrec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    @FXML
    private void validerAction(ActionEvent event) {
          rec.updateReclamation(new reclamation(Integer.valueOf(idrec.getText()),titre.getText(),description.getText()));
    }
    
}
