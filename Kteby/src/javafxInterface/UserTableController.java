/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxInterface;

import interfaces.Iutilisateur;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
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
    private ListView<utilisateur> usertable;
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
        final ObservableList<utilisateur> data = FXCollections.observableArrayList(su.consulterUtilisateur());
        usertable.setItems(data);

        usertable.setCellFactory(lv -> new ListCell<utilisateur>() {
            private Node graphic;
            private CustomCellController controller;

            {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomCell.fxml"));
                    graphic = loader.load();
                    controller = loader.getController();
                } catch (IOException exc) {
                    throw new RuntimeException(exc);
                }
            }

            @Override
            protected void updateItem(utilisateur item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    controller.getUsernameLabel().setText(item.getNom_user());
                    controller.getNameLabel().setText(item.getPrenom());
                    controller.getContactLabel().setText(item.getEmail());
                    setText(null);
                    setGraphic(graphic);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                }
            }
        });

    }

    // TODO
    @FXML
    private void addAction(ActionEvent event) {
    }

    @FXML
    private void modifyAction(ActionEvent event) {
    }

    @FXML
    private void banAction(ActionEvent event) {
        if (usertable.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Sélectionner un utilisateur tout d'abord!");
            alert.show();

        } else {

            usertable.refresh();
        }
    }

    @FXML
    private void returnAction(ActionEvent event) {
    }

}
