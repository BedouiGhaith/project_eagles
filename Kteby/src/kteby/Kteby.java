/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kteby;

import interfaces.Icategorie;
import interfaces.Iclub;
import interfaces.Ievaluation;
import interfaces.Ilivre;
import interfaces.Ireclamation;
import interfaces.Iutilisateur;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import model.Avis;
import model.categorie;
import model.club;
import model.evaluation;
import model.evenement;

import model.livre;
import model.members;
import model.reclamation;
import model.utilisateur;
import services.serviceAvis;
import services.serviceCategorie;

import services.serviceClub;
import services.serviceEvaluation;
import services.serviceEvent;
import services.serviceLivre;
import services.serviceMembers;
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
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {

        /*  //books
        livre li = new livre("harrypoter","pablo","heloothere","image",5);
        livre updated_livre = new livre("willsmith","pawlo","dracula","image",5);
        
        Ilivre sli = new serviceLivre();
         
        System.out.println(sli.calculelivre());
        sli.ajouterLivre(li);
       
        System.out.println(sli.consulterLivre());
        sli.deleteLivre(li);
        System.out.println(sli.getLivreById(sli.consulterLivre().get(0)));
        
         */
        //club
        Iclub scl = new serviceClub();

        club c = new club("club", "10/10/1111", "me", scl.calculemembre());
        club updated_cl = new club("club1", "11/11/1111", "he", scl.calculemembre());
        //club cl = new club();

        System.out.println(scl.calculemembre());

        scl.ajouterClub(c);

        scl.deleteClub(c);
        //System.out.println(scl.consulterClub());
        //  scl.updateClub(updated_cl,c);
        System.out.println(scl.getClubById(scl.consulterClub().get(0)));

        //members
        /* serviceMembers me = new serviceMembers() ;
        members m1 = new members(4,3);
        members m2 = new members(5,5);
        me.ajouterMember(m1);
        me.ajouterMember(m2);
        System.out.println(scl.calculemembre());*/
        utilisateur u = new utilisateur("user", "00000000", "g@gmail.com", "ghaith", 25, "admin");
        utilisateur updated_user = new utilisateur(48, "user", "11111111", "g@gmail.com", "bedoui", 25, "admin");

        Iutilisateur su = new serviceUtilisateur();

        su.deleteUtilisateur(updated_user);
        su.ajouterUtilisateur(u);
        System.out.println(su.consulterUtilisateur());
        su.updateUtilisateur(updated_user, u);
        System.out.println(su.getUserById(su.consulterUtilisateur().get(0)));
        su.deleteUtilisateur(updated_user);

        String originalPassword = "password";

        String generatedSecuredPasswordHash;
        generatedSecuredPasswordHash = serviceUtilisateur.generateStorngPasswordHash(originalPassword);
        System.out.println(generatedSecuredPasswordHash);

        boolean matched = serviceUtilisateur.validatePassword("password", generatedSecuredPasswordHash);
        System.out.println(matched);

        matched = serviceUtilisateur.validatePassword("password1", generatedSecuredPasswordHash);
        System.out.println(matched);

        //reclamation
        //reclamation re = new reclamation(1,"problem","livre qui manque",0,"");
        reclamation re1 = new reclamation(1, "test", "livre c'est pour les enfants", 0, "");
        reclamation updated_re = new reclamation(1, "warning", "pas claire", 0, "");

        Ireclamation sre = new serviceReclamation();
        //System.out.println(sre.Reponse("refusé",5));
        //System.out.println(sre.getById(4));
        //sre.ajouterReclamation(re1);
        sre.updateReclamation(updated_re, re1);
        //System.out.println(sre.consulterReclamation());
        //sre.deleteReclamation(re);

        //Events
        evenement evn = new evenement("eventHarry", "fans meeting", "15/12/2021", 1);
        evenement evn2 = new evenement("EventIntelligence", "intelligence people", "01/12/2022", 2);
        evenement evn3 = new evenement("eventday", "webinaire", "24/02/2021", 1);
        evenement delay_ev = new evenement("eventHarry", "fans meeting", "20/12/2021", 1);
        evenement updated_evn = new evenement("EVENT1", "aabbba", "15/12/2021", 1);

        serviceEvent sev = new serviceEvent();
        /*System.out.println(sev.delay("20/12/2021",8));
        /*sev.ajouterEvenement(evn2);*/
        //sev.ajouterEvenement(evn2);
        //System.out.println(sev.consulterEvenement());

        //sev.updateEvenement(updated_evn,evn);
        // sev.deleteEvenement("1");*/

        //categorie
        categorie cat = new categorie("romantique");
        categorie updated_c = new categorie("test");

        Icategorie sc = new serviceCategorie();
        System.out.println(sc.getTotalCategorie());
        /*System.out.println(sc.consulterCategorie());*/
 /*sc.rechercheParId(5); */
 /*System.out.println(sc.RechercheParNom("horreur"));*/

 /*sc.ajouterCategorie(cat);*/
 /*System.out.println(sc.consulterCategorie());*/
 /*sc.updateCategorie(updated_c,cat);*/
 /* sc.deleteCategorie(updated_c); */
 /*System.out.println(sc.getTrierParNomCat());*/
 /*System.out.println(sc.getCategorieById(sc.consulterCategorie().get(0)));*/
        //evaluation
        evaluation ev = new evaluation(11, 2, 13, 5);
        evaluation updated_ev = new evaluation(11, 2, 13, 4);

        Ievaluation seval = new serviceEvaluation();

        /*sev.ajouterEvaluation(ev);  */
 /*sev.updateEvaluation(updated_ev,ev);*/
 /*System.out.println(sev.consulterEvaluation());*/
 /*sev.deleteEvaluation(ev);*/
 /*System.out.println(sev.getById(sev.consulterEvaluation().get(3)));*/
 /*System.out.println("Le moyenne des Rates est :"+sev.getAvgRates(3));*/
 
    Avis a = new Avis("interessant",5 , 25);
       /* Avis updated_avis = new Avis  ("ce n'est pas interessant ",5 , 25); */
        
        serviceAvis  sa = new serviceAvis();
          sa.ajouterAvis(a);
        System.out.println(sa.consulterAvis());
      /*  sa.updateAvis(updated_avis, "5");
        /*sa.deleteAvis("5");*/
        System.out.println(sa.getById(3));
        System.out.println("La totale des commentaires est :"+sa.getTotalCom(25));
       
         
      
        System.out.println(serviceAvis.reactComment());
    }

}
