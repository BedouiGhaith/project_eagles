/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.serviceAvis;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class ReactFXMLController implements Initializable {

    @FXML
    private TextField idUser;
    @FXML
    private TextField idLivre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void React(ActionEvent event) {
         int id_user;
        int id_livre;
        if (idUser.getText().equals("") || idLivre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "user_id ou livre_id est vide!", "Input error!", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                id_user = Integer.parseInt(idUser.getText());
                id_livre = Integer.parseInt(idLivre.getText());
                serviceAvis sa = new serviceAvis();

                try {
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("React");
                    ButtonType likeButton = new ButtonType("like ", ButtonBar.ButtonData.YES);
                    ButtonType dislikeButton = new ButtonType("dislike ", ButtonBar.ButtonData.NO);

                    alert.getButtonTypes().setAll(likeButton, dislikeButton);
                    alert.showAndWait().ifPresent(type -> {
                        if (type == likeButton) {
                            try {

                                //sa.like(id_user, id_livre);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "id_livre ou id_user n'existe pas!", "error!", JOptionPane.ERROR_MESSAGE);

                            }
                        } else {
                            try {

                               // sa.dislike(id_user, id_livre);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "id_livre ou id_user n'existe pas!", "error!", JOptionPane.ERROR_MESSAGE);

                            }
                        }
                    });

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erreur!", "error!", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "user_id et livre_id doivent etre des nombres!", "Input error!", JOptionPane.ERROR_MESSAGE);
            }
        }
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

    
    

