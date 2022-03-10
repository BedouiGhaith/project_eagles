/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Ievenement;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.evenement;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import services.ServiceMail;
import services.serviceEvent;
import util.maConnexion;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EventAdminFXMLController implements Initializable {
            Connection cnx = maConnexion.getInstance().getCnx();
                Ievenement evn = new serviceEvent();
                private static String projectPath = System.getProperty("user.dir").replace("/", "\\");

    @FXML
    private ListView<String> EventListView;
    @FXML
    private Button btnAjout;
    @FXML
    private TextField titre;
    @FXML
    private TextField club;
    @FXML
    private TextField description;
    @FXML
    private DatePicker dateEv;
    @FXML
    private ImageView imageId;
    @FXML
    private Label lab_url;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    String sql= "SELECT evnt_name,description,image,nom_club,evnt_date FROM evenement ";
        try{
           
        Statement statement= cnx.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql);
             while (queryOutput.next()){
             String evnt_name = queryOutput.getString("evnt_name");
             String description = queryOutput.getString("description");
             String nom_club = queryOutput.getString("nom_club");
             Date evnt_date = queryOutput.getDate("evnt_date");
             String image = queryOutput.getString("image");
             String listOut = "Evenement: "+evnt_name + " \n" +  "Description: "+description + "\n" +"Image: "+image+"\n"  +"Nom Club: "+nom_club + "\n" + "Date: "+evnt_date;
             
            EventListView.getItems().add(listOut);
             
             
             
             }
    }           catch (SQLException ex) {    
                  ex.printStackTrace();             
    }
    } 

    @FXML
    private void listeEvent(MouseEvent event) {
        ListView recListView = new ListView();
        String selectedItem = recListView.getSelectionModel().getSelectedItem().toString();
        int selectedIndex = recListView.getSelectionModel().getSelectedIndex();
        titre.setText(selectedItem);
        description.setText(selectedItem);
        //date.setText(selectedItem);
        club.setText(selectedItem);


        
    }
    
    private void QRcode() throws FileNotFoundException, IOException {
        
        String contenue = "desc: " + description.getText() + "\n" + "name: " + titre.getText();
        ByteArrayOutputStream out = QRCode.from(contenue).to(ImageType.JPG).stream();
        File f = new File(projectPath + "\\src\\images\\" + titre.getText() + ".jpg");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(out.toByteArray());
        fos.flush();

    }

    @FXML
    private void addAction(ActionEvent event) throws ParseException, IOException {
       SimpleDateFormat simpleFormat = new SimpleDateFormat ("YYYY-MM-DD");
        java.util.Date date;
        date = simpleFormat.parse(dateEv.getValue().toString());
        java.sql.Date sqldate = new Date(date.getTime());
       
            evn.ajouterEvenement(new evenement(titre.getText(),description.getText(),sqldate,club.getText(),lab_url.getText()));
             JOptionPane.showMessageDialog(null, "Evenement ajoutée");
          QRcode();  
          ServiceMail SM = new ServiceMail();

       String Msg = "Bonjour Mr/Mme , Il y'a un nouvel évènement bientôt , Veuillez consulter l'application pour plus de details  ";

       SM.sendmailfunc("eya.bouazizi@esprit.tn", Msg);
    }

    @FXML
    private void goToRapporter(ActionEvent event) throws IOException  {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("RapporterEventFXML.fxml"));
                                         Stage primaryStage=new Stage();
                Parent root = loader.load();
                Scene homescene=new Scene(root);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(homescene);
                    window.show();
                RapporterEventFXMLController ctc=loader.getController();
        
    }

    @FXML
    private void Refreshaction(ActionEvent event) {
        String sql= "SELECT evnt_name,description,nom_club,evnt_date FROM evenement ";
        try{
           
        Statement statement= cnx.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql);
             while (queryOutput.next()){
             String evnt_name = queryOutput.getString("evnt_name");
             String description = queryOutput.getString("description");
             String nom_club = queryOutput.getString("nom_club");
             Date evnt_date = queryOutput.getDate("evnt_date");
             String listOut = evnt_name + " \"" +  description + "\"" + nom_club + "\"" + evnt_date;
             
            EventListView.getItems().add(listOut);
             
             
             
             }
    }           catch (SQLException ex) {    
                  ex.printStackTrace();             
    }
        
    }

    @FXML
    private void Image(ActionEvent event) {

        byte byteImg[];
        Blob blob;
        FileChooser fc = new FileChooser();
        //fc.getExtensionFilters().add(new ExtensionFilter(".png", ".jpg"));
        File f = fc.showOpenDialog(null);
        if (f != null) {
            lab_url.setText(f.getAbsolutePath());
            Image imag = new Image(f.toURI().toString(), imageId.getFitWidth(), imageId.getFitHeight(), true, true);

            imageId.setImage(imag);

        }
    }
    }

   
     

       

