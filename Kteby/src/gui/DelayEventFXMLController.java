/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Ievenement;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javax.swing.JOptionPane;
import services.serviceEvent;
import util.JavaMailUtil;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class DelayEventFXMLController implements Initializable {
    
    Ievenement evn = new serviceEvent();

    @FXML
    private TextField idEvent;
    @FXML
    private TextField idDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Delayaction(ActionEvent event) throws SQLException, Exception {
         if (evn.delay(idDate.getText(),Integer.valueOf(idEvent.getText()))==false){
             JOptionPane.showMessageDialog( null,"l'evenement n'existe pas"); 
       } else{
        evn.delay(idDate.getText(),Integer.valueOf(idEvent.getText()));
        JOptionPane.showMessageDialog( null,"la date de l'evenement a modifié");
        JavaMailUtil.sendMail("eya.bouazizi@esprit.tn");
        
    }
        
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
