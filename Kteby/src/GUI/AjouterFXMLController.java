/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import interfaces.Iavis;
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
import model.Avis;
import services.serviceAvis;
import util.JavaMailUtil;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class AjouterFXMLController implements Initializable {
Iavis sa = new serviceAvis () ;
    @FXML
    private TextField idUser;
    @FXML
    private TextField idLivre;
    @FXML
    private TextField idComment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
     private void Ajouter(ActionEvent event) throws Exception {
        sa.ajouterAvis(new Avis(idComment.getText(), Integer.valueOf(idUser.getText()),Integer.valueOf(idLivre.getText())));
JavaMailUtil.sendMail("eya.bouazizi@esprit.tn");   
     }

    @FXML
    private void goToAvis(ActionEvent event)  throws SQLException, 
            IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("AvisFXML.fxml"));
        Stage primaryStage = new Stage();
        Parent root = loader.load();
        Scene homescene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homescene);
        window.show();
        AjouterFXMLController ctc = loader.getController();
        
    }
}
