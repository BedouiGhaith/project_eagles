/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxInterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import model.utilisateur;

/**
 * FXML Controller class
 *
 * @author bedou
 */
public class CustomCellController extends ListCell<utilisateur>
 {

    @FXML
    private Label NameLabel;
    @FXML
    private Label ContactLabel;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpd;
    @FXML
    private Button btnBan;
    @FXML
    private Label UsernameLabel;
    @FXML
    private AnchorPane anchorpane;

    public Label getNameLabel() {
        return NameLabel;
    }

    public void setNameLabel(Label NameLabel) {
        this.NameLabel = NameLabel;
    }

    public Label getContactLabel() {
        return ContactLabel;
    }

    public void setContactLabel(Label ContactLabel) {
        this.ContactLabel = ContactLabel;
    }

    public Label getUsernameLabel() {
        return UsernameLabel;
    }

    public void setUsernameLabel(Label UsernameLabel) {
        this.UsernameLabel = UsernameLabel;
    }

    /**
     * Initializes the controller class.
     */
   
     
}
