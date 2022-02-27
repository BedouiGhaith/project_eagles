/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Icategorie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.categorie;
import services.serviceCategorie;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class CategFXMLController implements Initializable {
    
    Icategorie sc= new serviceCategorie();

    @FXML
    private TextField idCatg;
    @FXML
    private TextField nomCatg;
    @FXML
    private Label lab_list;

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
    }

    @FXML
    private void updateAction(ActionEvent event) {
        sc.updateCategorie(new categorie(Integer.valueOf(idCatg.getText()),nomCatg.getText()));
        JOptionPane.showMessageDialog(null, "Catégorie modifiée avec succés !");
    }

    @FXML
    private void deleteAction(ActionEvent event) {
        sc.deleteCategorie(new categorie(Integer.valueOf(idCatg.getText()),nomCatg.getText()));
        JOptionPane.showMessageDialog(null, "Catégorie supprimée avec succés !");
    }

    @FXML
    private void afficherAction(ActionEvent event) {
        lab_list.setText(sc.consulterCategorie().toString());
    }
    
}
