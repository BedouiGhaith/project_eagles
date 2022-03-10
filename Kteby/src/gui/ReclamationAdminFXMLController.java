/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Ireclamation;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import services.serviceReclamation;
import util.maConnexion;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ReclamationAdminFXMLController implements Initializable {
            Connection cnx = maConnexion.getInstance().getCnx();
            Ireclamation rec = new serviceReclamation();


    @FXML
    private ListView<String> recListView;
    @FXML
    private Button btnTraiter;
    private TextField inputTraiter;
    private int selectedIndex=-1;
    @FXML
    private TextField inputReponse;
    @FXML
    private TextField inputIdRec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String sql= "SELECT id_reclamation,titre,description,status,response FROM reclamation ";
        try{
           
        Statement statement= cnx.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql);
             while (queryOutput.next()){
             int id_reclamation = queryOutput.getInt("id_reclamation");    
             String titre = queryOutput.getString("titre");
             String description = queryOutput.getString("description");
             int status = queryOutput.getInt("status");
             String response = queryOutput.getString("response");
             String listOut = id_reclamation + " \"" +titre + " \"" +  description + "\"" + status + "\"" + response;
             
            recListView.getItems().add(listOut);
             
             
             
             }
    }           catch (SQLException ex) {    
                  ex.printStackTrace();             
    }
    }
        
    @FXML
    private void listreclama(MouseEvent event) {
        ListView recListView = new ListView();
        String selectedItem = recListView.getSelectionModel().getSelectedItem().toString();
        int selectedIndex = recListView.getSelectionModel().getSelectedIndex();
        inputTraiter.setText(selectedItem);
    }


    @FXML
    private void TraiterAction(ActionEvent event) throws SQLException {
        
       if (rec.Reponse(inputReponse.getText(),Integer.valueOf(inputIdRec.getText()))==false){
        JOptionPane.showMessageDialog( null,"La réclamation n'existe pas"); 
       } else{
        rec.Reponse(inputReponse.getText(),Integer.valueOf(inputIdRec.getText()));
        JOptionPane.showMessageDialog( null,"La réclamation est traitée avec succés");
           refreshAction(event);
        
    }
    }

    @FXML
    private void refreshAction(ActionEvent event) {
   String sql= "SELECT id_reclamation,titre,description,status,response FROM reclamation ";
        try{
           
        Statement statement= cnx.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql);
             while (queryOutput.next()){
             int id_reclamation = queryOutput.getInt("id_reclamation");    
             String titre = queryOutput.getString("titre");
             String description = queryOutput.getString("description");
             int status = queryOutput.getInt("status");
             String response = queryOutput.getString("response");
             String listOut = id_reclamation + " \"" +titre + " \"" +  description + "\"" + status + "\"" + response;
             
            recListView.getItems().add(listOut);
             
             
             
             }
    }           catch (SQLException ex) {    
                  ex.printStackTrace();             
    }
    
}
}
