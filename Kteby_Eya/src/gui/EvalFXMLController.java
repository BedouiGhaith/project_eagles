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
import javax.swing.JOptionPane;
import model.evaluation;
import services.serviceEvaluation;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class EvalFXMLController implements Initializable {
    
    //VAR
    Ievaluation sev=new serviceEvaluation();
    
    
    //WIDGETS
    @FXML
    private TextField idlivTF;
    @FXML
    private TextField iduserTF;
    @FXML
    private TextField nbstarsTF;
    @FXML
    private Label list_lab;
    @FXML
    private TextField idevalTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitAction(ActionEvent event) {
        sev.ajouterEvaluation(new evaluation(Integer.parseInt(idlivTF.getText()),Integer.parseInt(iduserTF.getText()),Integer.parseInt(nbstarsTF.getText())));
        JOptionPane.showMessageDialog(null, "Evaluation ajoutée avec succés !");
    }

    @FXML
    private void updateAction(ActionEvent event) {
        serviceEvaluation sev = new serviceEvaluation();
        sev.updateEvaluation(new evaluation(Integer.valueOf(idevalTF.getText()),Integer.valueOf(nbstarsTF.getText())));
        JOptionPane.showMessageDialog(null, "Evaluation modifiée avec succés !");
    
    }

    @FXML
    private void deleteAction(ActionEvent event) {
        /*sev.deleteEvaluation(new evaluation(Integer.valueOf(idevalTF.getText()),Integer.valueOf(idlivTF.getText()),Integer.valueOf(iduserTF.getText()),Integer.valueOf(nbstarsTF.getText())));
        JOptionPane.showMessageDialog(null, "Evaluation supprimée avec succés !");*/
        sev.deleteEvaluation(new evaluation(Integer.valueOf(idevalTF.getText())));
        JOptionPane.showMessageDialog(null, "Evaluation supprimée avec succés !");
    }

    @FXML
    private void afficherAction(ActionEvent event) {
        list_lab.setText(sev.consulterEvaluation().toString());
    }
    
}
