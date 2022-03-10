/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kteby;

import interfaces.Ievenement;
import interfaces.Ireclamation;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import model.Avis;
import model.categorie;
import model.club;
import model.evaluation;
import model.evenement;
import model.livre;
import model.reclamation;
import model.utilisateur;
import services.serviceAvis;
import services.serviceCategorie;
import services.serviceClub;
import services.serviceEvaluation;
import services.serviceEvent;
import services.serviceLivre;
import services.serviceReclamation;
import services.serviceUtilisateur;

/**
 *
 * @author asus
 */
public class Kteby {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        //users
        /*utilisateur u = new utilisateur("user", "00000000", "g@gmail.com", "ghaith", 25, "admin");
        utilisateur updated_user = new utilisateur("user", "11111111", "g@gmail.com", "bedoui", 25, "admin");

        serviceUtilisateur su = new serviceUtilisateur();

        su.ajouterUtilisateur(u);
        System.out.println(su.consulterUtilisateur());
        su.updateUtilisateur(updated_user, "user");
        su.deleteUtilisateur("user");*/
        
        
        
        
        //reclamation
       // reclamation re = new reclamation(1,"problem","livre qui manque",0,"");
        //reclamation re1 = new reclamation(1,"test","livre c'est pour les enfants",0,"");

        //reclamation updated_re = new reclamation(1,"warning","pas claire",0,"");
        
        Ireclamation sre = new serviceReclamation();
         //System.out.println(sre.Reponse("refusé",5));
         //System.out.println(sre.getById(4));
        //sre.ajouterReclamation(re1);
        //sre.updateReclamation(updated_re,re1);
        //System.out.println(sre.consulterReclamation());
        //sre.deleteReclamation(re);
        
       
        
        //Events
       // evenement evn= new evenement("eventHarry","fans meeting","15/12/2021",1);
       //evenement evn2= new evenement("EventIntelligence","intelligence people","01/12/2022",2);
       //evenement evn3= new evenement("eventday","webinaire","24/02/2021",1);

         //evenement delay_ev = new evenement ("eventHarry","fans meeting","20/12/2021",1);
        //evenement updated_evn = new evenement("EVENT1","aabbba","15/12/2021",1);
        //1
        Ievenement sev = new serviceEvent();
        //2
        java.util.Date mydate = new java.util.Date();
        java.sql.Date sqldate = new Date(mydate.getTime());
        //evenement evn= new evenement("eventHarry","fans meeting",sqldate,"eagles");
        //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        //java.util.Date myDate = new java.util.Date("2022/02/28");
       //evenement even = new evenement("enement", "Fans meet",myDate, 1);
        System.out.println(sre.getById(5));
        System.out.println(sev.delay(sqldate,19));
        //sev.ajouterEvenement(evn);
        //sev.ajouterEvenement(evn2);
        //System.out.println(sev.consulterEvenement());
       
        //sev.updateEvenement(updated_evn,evn);
       // sev.deleteEvenement("1");
        
    }

}
