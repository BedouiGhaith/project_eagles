/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;


import interfaces.Iutilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.utilisateur;
import services.serviceUtilisateur;

/**
 * FXML Controller class
 *
 * @author bedou
 */
public class ListeViewController extends ListCell<utilisateur>
 {
    Iutilisateur su = new serviceUtilisateur();
    
    

    @FXML
    private Label NameLabel;
    @FXML
    private Label ContactLabel;
    @FXML
    private Button btnUpd;
    @FXML
    private Button btnBan;
    @FXML
    private Label UsernameLabel;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Label bday;
    @FXML
    private Label state;
    @FXML
    private ImageView btnModify;
    @FXML
    private ImageView btnBanhammer;
    
    


    public Button getBtnUpd() {
        return btnUpd;
    }

    public void setBtnUpd(Button btnUpd) {
        this.btnUpd = btnUpd;
    }

    public AnchorPane getAnchorpane() {
        return anchorpane;
    }

    public void setAnchorpane(AnchorPane anchorpane) {
        this.anchorpane = anchorpane;
    }

    public Label getBday() {
        return bday;
    }

    public void setBday(Label bday) {
        this.bday = bday;
    }

    public Label getState() {
        return state;
    }

    public void setState(Label state) {
        this.state = state;
    }

    public Button getBtnBan() {
        return btnBan;
    }

    public void setBtnBan(Button btnBan) {
        this.btnBan = btnBan;
    }
    
    
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
