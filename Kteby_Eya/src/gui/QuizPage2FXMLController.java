/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import util.maConnexion;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class QuizPage2FXMLController implements Initializable {

    @FXML
    private Label textQuestion;
    @FXML
    private RadioButton a1;
    @FXML
    private RadioButton b1;
    @FXML
    private RadioButton c1;
    @FXML
    private Button bNext;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
Connection cnx = maConnexion.getInstance().getCnx();
    PreparedStatement pst=null;
    ResultSet rs =null;
    String value;
    
    
    @FXML
    private void rbClicked(MouseEvent event) {
    }

    @FXML
    private void gochoice1(ActionEvent event) {
         value ="De prose";
    }

    @FXML
    private void gochoice2(ActionEvent event) {
        value="D'allumettes";
    }

    @FXML
    private void gochoice3(ActionEvent event) {
        value="De vermicelles";
    } 

    @FXML
    private void submitAction2(ActionEvent event) {
        Connection cnx = maConnexion.getInstance().getCnx();
    
        try{
        String showquery="select value from compare order by id desc limit 1"; 
        pst=cnx.prepareStatement(showquery);
        rs=pst.executeQuery();
        if(rs.next()){
            String show = rs.getString("value");
            JOptionPane.showMessageDialog(null,"Your submitted answer is "+show,"Information",JOptionPane.PLAIN_MESSAGE);
        }
        
      } catch (Exception ex){
          ex.printStackTrace();
      }
    }

    @FXML
    private void submitAction(ActionEvent event) {
        
        try {
        String submitquery ="INSERT INTO submittedanswer(sa) VALUES (?)";
       pst=cnx.prepareStatement(submitquery);
       pst.setString(1, value);
       pst.executeUpdate();
       JOptionPane.showMessageDialog(null, "Your answer is submitted successful");
      String extractquery="select submittedanswer.sa,answer.ans from answer inner join (select sa from submittedanswer order by id desc limit 1) as submittedanswer on submittedanswer.sa = answer.ans";
        pst=cnx.prepareStatement(extractquery);
        rs=pst.executeQuery();
        if(rs.next()){
        String valueQuery ="INSERT INTO compare(value) values (?)";
        pst=cnx.prepareStatement(valueQuery);
        pst.setString(1, "Correct");
        pst.executeUpdate();
        }else{
        String valueQuery="INSERT INTO compare(value) VALUES (?)";
        pst=cnx.prepareStatement(valueQuery);
        pst.setString(1, "Incorrect");
        pst.executeUpdate();
        }
        
        
        
        }catch(Exception ex) {
            ex.printStackTrace();
    
    }
    
    }

    @FXML
    private void gotoQ3(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("QuizPage3FXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                QuizPage2FXMLController ctc=loader.getController();
    }

    @FXML
    private void gotoQ1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("QuizPageFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                QuizPage2FXMLController ctc=loader.getController();
    }
    
}
