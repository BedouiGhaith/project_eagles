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
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Avis;
import services.serviceAvis;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class ModifierFXMLController implements Initializable {
 Iavis sa = new serviceAvis () ;
    @FXML
    private TextField idComment;
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
    private void modifier(ActionEvent event) {
       // sa.updateAvis(new Avis(is));
     sa.updateAvis(new Avis(idComment.getText(),Integer.valueOf(idAvis.getText())));
     if (controleDeSaisi()) {
         JOptionPane.showMessageDialog(null, "Avis Modifié");
          
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succées");
        alert.setHeaderText(null);
        alert.setContentText("la modification a été effectué avec succées");
        alert.showAndWait();
     }
    }
    
     private boolean controleDeSaisi() {  

        if (idComment.getText().isEmpty() ) {
            showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Veuillez bien remplir tous les champs !");
            return false;
        } else {
      if (!Pattern.matches("[A-z]*", idComment.getText())) {
                showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Vérifiez le idComment ! ");
                idComment.requestFocus();
                idComment.selectEnd();
                return false;
            } 
           
        }
        return true;
    }
     
      public static void showAlert(Alert.AlertType type, String title, String header, String text) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();

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
       AvisFXMLController ctc = loader.getController();
        
    
    }
    
}
