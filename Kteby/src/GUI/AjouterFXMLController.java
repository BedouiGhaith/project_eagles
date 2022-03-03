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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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

    @FXML
    private void gotoReclamation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("RecFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                RecFXMLController ctc=loader.getController();
    }

   
}
