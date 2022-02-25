/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Ievaluation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.evaluation;
import services.serviceEvaluation;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class StartFXMLController implements Initializable {
    
    //VAR
    Ievaluation sev = new serviceEvaluation();

    //WIDGETS
    @FXML
    private Label list_lab;
    @FXML
    private TextField idLivTF;
    @FXML
    private TextField iduserTF;
    @FXML
    private TextField nbrstarsTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitAction(ActionEvent event) {
        sev.ajouterEvaluation(new evaluation(Integer.parseInt(idLivTF.getText()),Integer.parseInt(iduserTF.getText()),Integer.parseInt(nbrstarsTF.getText())));
    }

    @FXML
    private void afficher_action(ActionEvent event) {
        list_lab.setText(sev.consulterEvaluation().toString());
    }
    
}
