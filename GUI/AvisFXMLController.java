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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Avis;
import services.serviceAvis;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class AvisFXMLController implements Initializable {

    Iavis sa = new serviceAvis () ;
    
    @FXML
    private TextField idAvis;
    @FXML
    private TextField idUser;
    @FXML
    private TextField idLivre;
    @FXML
    private TextField idComment;
    @FXML
    private Label lab_list;
    @FXML
    private Label nbrcom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
     
   

   

    @FXML
    private void calculAction(ActionEvent event) throws SQLException {
        int somcom=0;
        somcom=sa.getTotalCom(Integer.valueOf(idLivre.getText())); 
        //nbrcom.setText(Integer.valueOf(somcom.getText()));
        
            nbrcom.setText(Integer.valueOf(somcom).toString());
        
    }

    @FXML
    private void goToDelete(ActionEvent event) throws SQLException, IOException  {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("deleteFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                DeleteFXMLController ctc=loader.getController();


    }

    private void goToModifier(ActionEvent event) throws SQLException, IOException  {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("modifierFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                ModifierFXMLController ctc=loader.getController();
        
    }

    @FXML
    private void goToAjouter(ActionEvent event) throws SQLException, IOException  {
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
    private void goToafficher(ActionEvent event) throws SQLException, IOException  {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("afficherFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                AfficherFXMLController ctc=loader.getController();
        
    }
}

   