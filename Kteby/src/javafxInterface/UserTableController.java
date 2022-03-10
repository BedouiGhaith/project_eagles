/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxInterface;

import interfaces.Iutilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.utilisateur;
import services.UserSession;
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
    private Label user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        user.setText("Bienvenue " + UserSession.getInstace().getUserName());

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
                    controller.getBday().setText(item.getAge().toString());
                    controller.getState().setText(item.getType());
                    controller.getBtnBan().setOnAction(evt -> {
                        utilisateur cell = getItem();
                        int index = getIndex();
                        System.out.print(cell.getNom_user());
                        if (cell.getType().equals("admin")) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Erreur");
                            alert.setHeaderText("Echec d'action!");
                            alert.setContentText("Impossible de bannir un utilisateur admin!");
                            alert.show();
                        } else if (controller.getState().getText().equals("bannis")) {
                            su.unbanUser(cell);
                            controller.getState().setText("lecteur");

                        } else if (controller.getState().getText().equals("lecteur")){
                            su.banUser(cell);
                            controller.getState().setText("bannis");

                        }

                    });
                    controller.getBtnUpd().setOnAction(evt -> {

                        try {
                            utilisateur u = getItem();
                            int index = getIndex();
                            UserHolder.getInstance().setUser(u);
                            Parent root;

                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("UpdateAccount.fxml"));
                            Scene scene = new Scene(fxmlLoader.load(), 400, 500);

                            Stage stage = new Stage();

                            stage.initStyle(StageStyle.UNDECORATED);
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(UserTableController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    });
                    setText(null);
                    setGraphic(graphic);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                }
            }
        }
        );

    }

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

}
