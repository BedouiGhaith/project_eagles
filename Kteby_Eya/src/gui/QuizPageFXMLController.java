/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class QuizPageFXMLController implements Initializable {

    @FXML
    private Label textQuestion;
    @FXML
    private RadioButton rba;
    @FXML
    private RadioButton rbb;
    @FXML
    private RadioButton rbc;
    @FXML
    private RadioButton rbd;
    @FXML
    private Button bNext;
    @FXML
    private HBox timerBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void rbClicked(MouseEvent event) {
    }

    @FXML
    private void goNext(ActionEvent event) {
    }
    
}
