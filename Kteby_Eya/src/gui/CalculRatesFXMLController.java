/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Ievaluation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.evaluation;
import services.serviceEvaluation;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class CalculRatesFXMLController implements Initializable {
    Ievaluation sev=new serviceEvaluation();

    @FXML
    private TextField idLivTF;
    @FXML
    private Label resmoy;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void calculAction(ActionEvent event) throws SQLException {
        int moy=0;
         moy=sev.getAvgRates(Integer.valueOf(idLivTF.getText()));
         
          if(moy >=0 && moy < 1)
            {
                JOptionPane.showMessageDialog(null, "Ce livre n'a pas une évaluation!");
                resmoy.setText("Ce livre n'a pas une évaluation");
            }
            if(moy >=1 && moy < 2)
            {
                resmoy.setText("★");
            }
            if(moy >=2 && moy < 3)
            {
                resmoy.setText("★★");
            }
            if(moy >=3 && moy < 4)
            {
                resmoy.setText("★★★");
            }
            if(moy >=4 && moy< 5)
            {
                resmoy.setText("★★★★");
            }
            if(moy==5 )
            {
                resmoy.setText("★★★★★");
            }
        } 

    @FXML
    private void returnAction(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("EvalFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                EvalFXMLController ctc=loader.getController();
    }
    
       
    }
    

