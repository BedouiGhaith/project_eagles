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
        
  
        
        //avis
        Avis a = new Avis("aaaaa",5 , 25);
        Avis updated_avis = new Avis  ("na",5 , 25);
        
        serviceAvis  sa = new serviceAvis();
        
        sa.ajouterAvis(a);
        sa.updateAvis(updated_avis, "2");
        System.out.println(sa.consulterAvis());
        sa.deleteAvis("10");
        
  
        
    }

}
