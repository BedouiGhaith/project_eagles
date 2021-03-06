/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Icategorie;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.categorie;
import services.serviceCategorie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class AffiCatgFXMLController implements Initializable {

   Icategorie sc =new serviceCategorie();  
    
    @FXML
    private Label lab_list;
    @FXML
    private Label searchlab;
    @FXML
    private TextField nomcatTF;
    @FXML
    private ListView<?> listv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   
      
    
    
   @FXML
    private void afficherAction(ActionEvent event) {
        lab_list.setText(sc.consulterCategorie().toString());
    }

    @FXML
    private void gotocatg(ActionEvent event) throws IOException {
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
    private void searchAction(ActionEvent event) {
        if(sc.RechercheParNom(nomcatTF.getText()).isEmpty()){
          JOptionPane.showMessageDialog(null, "OUUPS ! La cat??gorie " +nomcatTF.getText()+ " n'existe pas dans la base des donn??es");
        }
        else{
         searchlab.setText(sc.RechercheParNom(nomcatTF.getText()).toString());
         JOptionPane.showMessageDialog(null, "La cat??gorie " +nomcatTF.getText()+ " Trouv??e ");
        }
    }

    
    
}
