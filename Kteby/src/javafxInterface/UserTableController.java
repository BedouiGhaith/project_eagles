/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxInterface;

import interfaces.Iutilisateur;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.utilisateur;
import services.serviceUtilisateur;

/**
 * FXML Controller class
 *
 * @author bedou
 */
public class UserTableController implements Initializable {

    Iutilisateur su = new serviceUtilisateur();

    @FXML
    private TableView<utilisateur> usertable;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnModify;
    @FXML
    private Button btnBan;
    @FXML
    private Button btnReturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       TableColumn id = new TableColumn("ID");
        TableColumn username = new TableColumn("Nom Utilisateur");
        TableColumn pwd = new TableColumn("Mot de Passe");
        TableColumn email = new TableColumn("Email"); 
        TableColumn fullname = new TableColumn("Nom et Prenom");
        TableColumn bday = new TableColumn("Date de Naissance");
        TableColumn state = new TableColumn("Etat");
        
   
       
        
       
        usertable.getColumns().addAll(id, username, pwd, email, fullname, bday, state);
        
        
        //Step : 1# Create a person class that will represtent data
        
        //Step : 2# Define data in an Observable list and add data as you want to show inside table    
         final ObservableList<utilisateur> data = FXCollections.observableArrayList(su.consulterUtilisateur())   ;

        
        //Step : 3#  Associate data with columns  
            id.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("id_user"));
        
            username.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("nom_user"));

            pwd.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("mot_de_passe"));

            email.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("email"));
            
            fullname.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("prenom"));
            
            bday.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("age"));
            
            state.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("type"));
            
               
                        
        //Step 4: add data inside table
           usertable.setItems(data);
           
      
        // TODO
    }

    @FXML
    private void addAction(ActionEvent event) {
    }

    @FXML
    private void modifyAction(ActionEvent event) {
    }

    @FXML
    private void banAction(ActionEvent event) {
        if(usertable.getSelectionModel().getSelectedItem()==null){
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Sélectionner un utilisateur tout d'abord!");
            alert.show();
            
        }else{
            utilisateur u = usertable.getSelectionModel().getSelectedItem();
            u.setType("bannis");
            su.updateUtilisateur(u, u);
            usertable.refresh();
        }
    }

    @FXML
    private void returnAction(ActionEvent event) {
    }

}
