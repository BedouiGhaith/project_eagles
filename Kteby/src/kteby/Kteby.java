/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kteby;

import model.Avis;
import model.categorie;
import model.club;
import model.evaluation;
import model.livre;
import model.reclamation;
import model.utilisateur;
import services.serviceAvis;
import services.serviceCategorie;
import services.serviceClub;
import services.serviceEvaluation;
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
    public static void main(String[] args) {
        
        
        
        //books
        livre li = new livre("na","na","na","na",5);
        livre updated_livre = new livre("a","a","a","a",5);
        
        serviceLivre sli = new serviceLivre();
        
        sli.ajouterLivre(li);
        sli.updateLivre(updated_livre,"na");
        System.out.println(sli.consulterLivre());
        sli.deleteLivre("na");
        
        
       
        
        //club
        club cl = new club("club","22/22/2222","me",20);
        club cl = new club("club","10/10/1111","me",scl.calculemembre());
        
        serviceClub scl = new serviceClub();
        
        scl.ajouterClub(cl);
        scl.updateClub(updated_cl, "club");
        System.out.println(scl.consulterClub());
        scl.deleteClub("club123");
        
      
        
    }

}
