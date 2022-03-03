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

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class DeleteFXMLController implements Initializable {
Iavis sa = new serviceAvis () ;
    @FXML
    private TextField idAvis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void delete(ActionEvent event) {
         sa.deleteAvis(new Avis(Integer.valueOf(idAvis.getText())));
    }

    @FXML
    private void goToAvis(ActionEvent event) throws SQLException, 
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
