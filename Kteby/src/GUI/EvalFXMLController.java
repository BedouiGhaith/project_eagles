/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Ievaluation;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.evaluation;
import services.serviceEvaluation;
import util.JavaMailUtil;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class EvalFXMLController implements Initializable {
    
    //VAR
 
    
    
    //WIDGETS
    @FXML
    private TextField nomlivTF;
    @FXML
    private TextField nbstarsTF;
    @FXML
    private TextField idevalTF;
    @FXML
    private Label lab_title_eval;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitAction(ActionEvent event) throws Exception {
        serviceEvaluation sev = new serviceEvaluation();
        sev.ajouterEvaluation(new evaluation((nomlivTF.getText()),Integer.valueOf(nbstarsTF.getText())));
        JOptionPane.showMessageDialog(null, "Evaluation ajoutée avec succés !");
        JavaMailUtil.sendMail("eyabouazyzy420@gmail.com");
    }

    @FXML
    private void updateAction(ActionEvent event) {
        serviceEvaluation sev = new serviceEvaluation();
        sev.updateEvaluation(new evaluation((nomlivTF.getText()),Integer.valueOf(nbstarsTF.getText())));
        JOptionPane.showMessageDialog(null, "Evaluation modifiée avec succés !");
    
    }

    @FXML
    private void deleteAction(ActionEvent event) {
           Ievaluation sev=new serviceEvaluation();
        /*sev.deleteEvaluation(new evaluation(Integer.valueOf(idevalTF.getText()),Integer.valueOf(idlivTF.getText()),Integer.valueOf(iduserTF.getText()),Integer.valueOf(nbstarsTF.getText())));
        JOptionPane.showMessageDialog(null, "Evaluation supprimée avec succés !");*/
        sev.deleteEvaluation(new evaluation(Integer.valueOf(idevalTF.getText())));
        JOptionPane.showMessageDialog(null, "Evaluation supprimée avec succés !");
    }

   

    @FXML
    private void returnAction(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("CategFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                CategFXMLController ctc=loader.getController();
}

    
    @FXML
    private void goAffAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AffiEvalFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                EvalFXMLController ctc=loader.getController();
    }

    @FXML
    private void startQuiz(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("QuizPageFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                EvalFXMLController ctc=loader.getController();
    }
     
}

    

