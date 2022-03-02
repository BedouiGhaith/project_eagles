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
public class AjouterFXMLController implements Initializable {
    Ireclamation rec = new serviceReclamation();

    @FXML
    private TextField titreRec;
    @FXML
    private TextField descRec;
    @FXML
    private TextField statutRec;
    @FXML
    private TextField iduserRec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submit(ActionEvent event) {
                rec.ajouterReclamation(new reclamation(Integer.valueOf(iduserRec.getText()),titreRec.getText(),descRec.getText(),Integer.valueOf(statutRec.getText())));

    }
    
}
