/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kteby;

import interfaces.Ievaluation;
import java.sql.SQLException;
import model.Avis;
import model.categorie;
import model.club;
import model.evaluation;
import model.evenement;
import model.livre;
import model.reclamation;
import model.utilisateur;
import model.evenement;
import services.serviceAvis;
import services.serviceCategorie;
import services.serviceClub;
import services.serviceEvaluation;
import services.serviceLivre;
import services.serviceReclamation;
import services.serviceUtilisateur;
import services.serviceEvent;

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
        
        //books
        /*livre li = new livre("na","na","na","na",5);
        livre updated_livre = new livre("a","a","a","a",5);
        
        serviceLivre sli = new serviceLivre();
        
         sli.ajouterLivre(li);
        System.out.println(sli.consulterLivre());
       /*sli.updateLivre(updated_livre,"na");
        /*sli.deleteLivre("na");*/
        
        //avis
        /*Avis a = new Avis("aaaaa",5 , 25);
        Avis updated_avis = new Avis  ("na",5 , 25);*/
        
        serviceAvis  sa = new serviceAvis();
        System.out.println(sa.getById(3));
        System.out.println("La totale des commentaires est :"+sa.getTotalCom(25));
        /*sa.ajouterAvis(a);
        System.out.println(sa.consulterAvis());
        sa.updateAvis(updated_avis, "5");*/
        /*sa.deleteAvis("5");*/
        
        //categorie
        /*categorie c = new categorie("enfant");
        categorie updated_c = new categorie("adulte");
        
        serviceCategorie sc = new serviceCategorie();
        
        sc.ajouterCategorie(c);
        System.out.println(sc.consulterCategorie());
        sc.updateCategorie(updated_c, "enfant");
        sc.deleteCategorie("adulte");*/
        
        //club
        /*club cl = new club("club","22/22/2222","me",20);
        club updated_cl = new club("club123","11/11/1111","he",30);
        
        serviceClub scl = new serviceClub();
        
        /*scl.ajouterClub(cl);
        System.out.println(scl.consulterClub());
        scl.updateClub(updated_cl, "club");
        /*scl.deleteClub("club123");*/
        
        //reclamation
        /*reclamation re = new reclamation(1,"problem","aaaaaaaaaaaaaaaaaa");
        reclamation updated_re = new reclamation(1,"ppppp","a");
        
        serviceReclamation sre = new serviceReclamation();
        
        /*sre.ajouterReclamation(re);
        System.out.println(sre.consulterReclamation());
        sre.updateReclamation(updated_re, "1");
        /*sre.deleteReclamation("2");*/
        
        //evaluation
        evaluation ev= new evaluation(1,2,3);
        evaluation updated_ev = new evaluation(1,2,4);
        
        Ievaluation sev = new serviceEvaluation();
        
        /*sev.ajouterEvaluation(ev);*/
        /*System.out.println(sev.CalculAvgRating());*/
        
        /*sev.updateEvaluation(updated_ev, "1");
        System.out.println(sev.consulterEvaluation());
        sev.deleteEvaluation("1");*/
        
        //Events
        /*evenement evn= new evenement("event1","aaaaaa","15/12/2021",1);
        evenement updated_evn = new evenement("EVENT1","aabbba","15/12/2021",1);
        
        serviceEvent sev = new serviceEvent();
        
        sev.ajouterEvenement(evn);
        System.out.println(sev.consulterEvenement());
        /*sev.updateEvenement(updated_ev, "1");
        sev.deleteEvenement("1");*/
        
    }

}
