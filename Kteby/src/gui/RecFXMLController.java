/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Ireclamation;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.reclamation;
import services.serviceReclamation;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RecFXMLController implements Initializable {

    
    Ireclamation rec = new serviceReclamation();
    
    
  
    @FXML
    private TextField titreRec;
    @FXML
    private TextField descRec;
    @FXML
    private TextField statutRec;
    @FXML
    private TextField reponseRes;
    @FXML
    private TextField iduserRec;
    @FXML
    private Label listRec;
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
    private void afficheraction(ActionEvent event) {
        listRec.setText(rec.consulterReclamation().toString());
    }

    
    @FXML
    private void deleteaction(ActionEvent event) {
        rec.deleteReclamation(new reclamation(Integer.valueOf(idrec.getText())));
    }

    @FXML
    private void gotoadd(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ajouterFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                AjouterFXMLController ctc=loader.getController();
    }

    @FXML
    private void gotoupdate(ActionEvent event) throws IOException  {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("modifierFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                ModifierController ctc=loader.getController();
        
        
    }

  
    
}
