/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.dateTime;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import interfaces.Iavis;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Avis;
import model.livre;
import model.utilisateur;
import services.serviceAvis;
import util.JavaMailUtil;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class AjouterFXMLController implements Initializable {
Iavis sa = new serviceAvis () ;
    private TextField idUser;
    private TextField idLivre;
    @FXML
    private TextField idComment;
    private DatePicker txtdateact;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        // TODO
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

    @FXML
     private void Ajouter(ActionEvent event) throws Exception {
        /* if (controleDeSaisi()) {
        //sa.ajouterAvis(new Avis(idComment.getText(),Integer.valueOf(idUser.getText()),Integer.valueOf(idLivre.getText())));
       
        String msg ="Salut, Mr "+idUser.getText()+" ajouté un avis : "+idComment.getText()+" sur le livre :"+idLivre.getText();
       // JavaMailUtil.sendMail("eya.bouazizi@esprit.tn"); 
       Twilio.init("AC5554931284cc28e6252ce2c6b1cd4c7a","f590cba01f1acfc76b7f86d40b337954");
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21693603902"),
                new com.twilio.type.PhoneNumber("+18567334578"),
                msg ).create();
             System.out.println("");
             System.out.println("aa");
         }else{
     // JOptionPane.showMessageDialog(null, "Avis Ajouté");
      JOptionPane.showMessageDialog(null, "idComment est vide!", "Input error!", JOptionPane.ERROR_MESSAGE);
        //System.out.println("bb");*/
      serviceAvis sa = new serviceAvis();
       Avis a = new Avis(idComment.getText());
        utilisateur u =new utilisateur();
        u.setId_user(6);
                livre v = new livre();
        v.setId_livre(3);
        sa.ajouterAvis(a, u, v);    } 
     
    
     
      public static void showAlert(Alert.AlertType type, String title, String header, String text) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();

    }


    @FXML
    private void goToAvis(ActionEvent event)  throws SQLException, 
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
