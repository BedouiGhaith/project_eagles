/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Ievaluation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.evaluation;
import services.serviceEvaluation;
import util.JavaMailUtil;
import util.ShowNotification;
import util.maConnexion;


/**
 * FXML Controller class
 *
 * @author eya
 */
public class RatingFXMLController implements Initializable {
    ShowNotification sn = new ShowNotification();
    Ievaluation sev=new serviceEvaluation();
    int a  ; 
    @FXML
    ImageView star1;

    @FXML
    ImageView star2;

    @FXML
    ImageView star3;

    @FXML
    ImageView star4;

    @FXML
    ImageView star5;
    @FXML
    private TextField tf_nom_livre;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
     void showRating(int id_livre) throws ClassNotFoundException, SQLException {
Connection cnx = maConnexion.getInstance().getCnx();
        String query= "SELECT nb_stars from evaluation  WHERE id_livre='" + id_livre +"'";
        PreparedStatement pre = cnx.prepareStatement(query);
        ResultSet result = pre.executeQuery();
         Image ratedImage=new Image("\\images\\icons8-star-64.png");
        while (result.next()) {
            int rating = result.getInt("nb_stars");
            switch (rating){
                case 5:
                    star5.setImage(ratedImage);
                case 4:
                    star4.setImage(ratedImage);
                case 3:
                    star3.setImage(ratedImage);
                case 2:
                    star2.setImage(ratedImage);
                case 1:
                    star1.setImage(ratedImage);
            }

        }


    }

    @FXML
    public void setRating(MouseEvent event) throws FileNotFoundException, ClassNotFoundException, SQLException {
       Connection cnx = maConnexion.getInstance().getCnx();
        Image unratedImage=new Image("\\images\\icons8-add-to-favorites-64.png");
        star1.setImage(unratedImage);
        star2.setImage(unratedImage);
        star3.setImage(unratedImage);
        star4.setImage(unratedImage);
        star5.setImage(unratedImage);
        ImageView star = (ImageView) event.getSource();
        String starID= star.getId();
        Image ratedImage=new Image("/images/icons8-star-64.png");

        switch (starID){
            case "star5":
                star5.setImage(ratedImage);
                a = 5;
            case "star4":
                star4.setImage(ratedImage);
                a=4;
            case "star3":
                star3.setImage(ratedImage);
                a=3;
            case "star2":
                star2.setImage(ratedImage);
                a=2;
            case "star1":
                star1.setImage(ratedImage);
                a=1;
        }
        
        int starRating=starID.charAt(starID.length()-1)-'0';
        System.out.println(starRating);
         sn.showConfirm("Confirmation d'évaluation ! ", " Merci pour évaluer ce livre");
        
       
        
        String query = "UPDATE evaluation set nb_stars  ='"+a +"' WHERE id_livre=?";
         PreparedStatement pre = cnx.prepareStatement(query);
        ResultSet result = pre.executeQuery();
        while (result.next()) {
            int rating = result.getInt("nb_stars");
        Statement statement=cnx.createStatement();
        statement.executeUpdate(query);
        }
    
}

    @FXML
    private void gotoeval(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("EvalFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                EvalFXMLController ctc=loader.getController();
    }
      @FXML
    void give1(MouseEvent event) throws Exception {
        serviceEvaluation sev = new serviceEvaluation();
        sev.updateEvaluation(new evaluation((tf_nom_livre.getText()),1));
        JOptionPane.showMessageDialog(null, "Evaluation modifiée avec succés !");
        JavaMailUtil.sendMail("eyabouazyzy420@gmail.com");
    
    }

    @FXML
    void give2(MouseEvent event) throws Exception {
        serviceEvaluation sev = new serviceEvaluation();
        sev.updateEvaluation(new evaluation((tf_nom_livre.getText()),2 ));
        JOptionPane.showMessageDialog(null, "Evaluation modifiée avec succés !");
        JavaMailUtil.sendMail("eyabouazyzy420@gmail.com");

    }

    @FXML
    void give3(MouseEvent event) throws Exception {
serviceEvaluation sev = new serviceEvaluation();
        sev.updateEvaluation(new evaluation((tf_nom_livre.getText()),3));
        JOptionPane.showMessageDialog(null, "Evaluation modifiée avec succés !");
        JavaMailUtil.sendMail("eyabouazyzy420@gmail.com");
    }

    @FXML
    void give4(MouseEvent event) throws Exception {
        serviceEvaluation sev = new serviceEvaluation();
        sev.updateEvaluation(new evaluation((tf_nom_livre.getText()),4));
        JOptionPane.showMessageDialog(null, "Evaluation modifiée avec succés !");
        JavaMailUtil.sendMail("eyabouazyzy420@gmail.com");
    }

    @FXML
    void give5(MouseEvent event) throws Exception {
        serviceEvaluation sev = new serviceEvaluation();
        sev.updateEvaluation(new evaluation((tf_nom_livre.getText()),5));
        JOptionPane.showMessageDialog(null, "Evaluation modifiée avec succés !");
        JavaMailUtil.sendMail("eyabouazyzy420@gmail.com");
    }
}
