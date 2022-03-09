/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Icategorie;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import model.categorie;
import services.serviceCategorie;
import util.maConnexion;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class AdminCatgFXMLController implements Initializable {
Connection cnx = maConnexion.getInstance().getCnx();
    Icategorie sc = new serviceCategorie();
    @FXML
    private ListView<String> catgListView;
    @FXML
    private TextField inputTF;
    
   
    @FXML
    private TextField nomcatTF;
@FXML
    private ComboBox<String> comboCatg;
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnclear;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    try {
        fillcomboCatg() ;
    } catch (SQLException ex) {
        Logger.getLogger(AdminCatgFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
        // TODO
         //ObservableList<String> catglist = FXCollections.observableArrayList();
        String sql= "SELECT nom_categorie FROM categorie";
        try{
           
        Statement statement= cnx.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql);
        
            while (queryOutput.next()){
                    //int idCateg = queryOutput.getInt("id_categorie");
                    String nomCateg = queryOutput.getString("nom_categorie");
                    //String listOut = idCateg + " \"" +  nomCateg + "\"";
                    //String listOut =idCateg +"   " + nomCateg ;
                    String listOut =nomCateg ;
                    
                    catgListView.getItems().add(listOut);
                    //catgListView.setItems(catglist);
            }
        
        
        } catch(Exception e){
            e.printStackTrace();
        
        }
        
    }    

    @FXML
    private void listviewcatg(MouseEvent event) {
       
        ListView catgListView = new ListView();
        
      
        String selectedItem = catgListView.getSelectionModel().getSelectedItem().toString();
        int selectedIndex = catgListView.getSelectionModel().getSelectedIndex();
        inputTF.setText(selectedItem);
        System.out.println(selectedItem);
        
          
    }

    @FXML
    private void addAction(ActionEvent event) {
      sc.ajouterCategorie(new categorie (inputTF.getText()));
     inputTF.clear();
    catgListView.getItems().add(inputTF.getText());
    Alert alert=new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText(null);
    alert.setContentText("Categorie ajoutée avec succés");
    alert.showAndWait();
        refreshTable(event);
    }

    @FXML
    private void updateAction(ActionEvent event) throws SQLException{
         int selectedIndex=-1;
        String selectedItem = catgListView.getSelectionModel().getSelectedItem();
        System.out.println(selectedItem);
         selectedIndex = catgListView.getSelectionModel().getSelectedIndex();
        
        sc.updateCategorie(catgListView.getSelectionModel().getSelectedItem(),inputTF.getText());
        Dialog d=new Alert(Alert.AlertType.INFORMATION,String.valueOf(selectedIndex));
        d.show();
        
        catgListView.getItems().remove(selectedItem);
        catgListView.getItems().add(inputTF.getText());
        refreshTable(event);
        
                }
    

    @FXML
    private void deleteAction(ActionEvent event) {
        
        //get selected item
        String selectedItem = catgListView.getSelectionModel().getSelectedItem();
        System.out.println(selectedItem);
        //alert confirmation
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Supprimer !!");
        alert.setContentText("Vous êtes sur de supprimer cette catégorie?");
        alert.showAndWait();
        sc.deleteCategorie((new categorie(selectedItem)));
        refreshTable(event);
        //catgListView.getItems();
        //catgListView.refresh();
        //update listview
        //catgListView.getItems().clear();
        //ObservableList<String> catglist = FXCollections.observableArrayList();
        //catgListView.setItems(se);

    }
            
    

    @FXML
    private void clearAction(ActionEvent event) {
        catgListView.getItems().clear();
    }
        
    
    
    
 

    @FXML
    private void refreshTable(ActionEvent event) {
        String sql= "SELECT id_categorie,nom_categorie FROM categorie";
        try{
           catgListView.getItems().clear();
    
        Statement statement= cnx.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql);
        
            while (queryOutput.next()){
                    //int idCateg = queryOutput.getInt("id_categorie");
                    String nomCateg = queryOutput.getString("nom_categorie");
                    //String listOut = idCateg + " \"" +  nomCateg + "\"";
                    String listOut =  nomCateg ;
                    
                    catgListView.getItems().add(listOut);
                    //catgListView.setItems(catglist);
            }
        
        
        } catch(Exception e){
            e.printStackTrace();
        
        }
        
    }

    @FXML
    private void searchAction(ActionEvent event) {
        if(sc.RechercheParNom(nomcatTF.getText()).isEmpty()){
          JOptionPane.showMessageDialog(null, "OUUPS ! La catégorie " +nomcatTF.getText()+ " n'existe pas dans la base des données");
        }
        else{
         catgListView.getItems().clear();
         //catgListView.getItems().add(sc.RechercheParNom(nomcatTF.getText()).toString());
         catgListView.getItems().add(nomcatTF.getText());
         
         JOptionPane.showMessageDialog(null, "La catégorie " +nomcatTF.getText()+ " Trouvée ");
        }
    }

@FXML
    private void fillcomboCatg() throws SQLException  {
        ObservableList<String> list= FXCollections.observableArrayList();
        
        try{
        ResultSet rs=cnx.createStatement().executeQuery("select nom_categorie from categorie ORDER BY nom_categorie");
        while(rs.next()){
        list.add(rs.getString("nom_categorie"));
      
      }  
        } catch (SQLException ex) {
            System.out.println("erreur lors d'ajout une categorie");
            ex.printStackTrace();
        }
        comboCatg.setItems(null);
        comboCatg.setItems(list);
        
        
       
        /*String s=comboCatg.getSelectionModel().getSelectedItem();
        String sql="select * from livre where nom_categorie="+s;
        try{
         PreparedStatement statement=cnx.prepareStatement(sql);
         ResultSet rs=statement.executeQuery(sql);
         /*while(rs.next()){
         //listliv.setText(sql);
         rs.getString("titre");
         rs.getString("auteur");
         rs.getString("description");
         
         }
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }*/
}
}
        
 

    
    
   

    


    
    

