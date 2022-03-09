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
import model.categorie;
import services.serviceCategorie;
import util.ShowNotification;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class CategFXMLController implements Initializable {
    ShowNotification sn = new ShowNotification();
    Icategorie sc= new serviceCategorie();

    @FXML
    private TextField idCatg;
    @FXML
    private TextField nomCatg;
    @FXML
    private Label lab_title_catg;
    @FXML
    private Label lab_list;
    @FXML
    private Button ajoutB;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterAction(ActionEvent event) {
        sc.ajouterCategorie(new categorie(nomCatg.getText()));
        JOptionPane.showMessageDialog(null, "Catégorie ajoutée avec succés !");
        sn.showConfirm("Confirmation ! ", " Ajout de catégorie réussi");
    }

    @FXML
    private void updateAction(ActionEvent event) {
        //sc.updateCategorie(new categorie(,);
        JOptionPane.showMessageDialog(null, "Catégorie modifiée avec succés !");
        sn.showInformation("Mise à jour réussie", "Catégorie modifiée");
    }
    @FXML
    private void deleteAction(ActionEvent event) {
        sc.deleteCategorie(new categorie(Integer.valueOf(idCatg.getText()),nomCatg.getText()));
        JOptionPane.showMessageDialog(null, "Catégorie supprimée avec succés !");
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

    

    @FXML
    private void goAffAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AffiCatgFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                EvalFXMLController ctc=loader.getController();
    }

}