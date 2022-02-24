/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kteby;

import interfaces.Icategorie;
import interfaces.Ievaluation;
import java.sql.SQLException;

import model.categorie;

import model.evaluation;

import services.serviceCategorie;

import services.serviceEvaluation;


/**
 *
 * @author asus
 */
public class Kteby {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
       
        
        //categorie
        categorie c = new categorie("romantique");
        categorie updated_c = new categorie("test");
        
        Icategorie sc = new serviceCategorie();
        System.out.println(sc.getTotalCategorie());
        /*System.out.println(sc.consulterCategorie());*/
        /*sc.rechercheParId(5); */
        /*System.out.println(sc.RechercheParNom("horreur"));*/
        
        /*sc.ajouterCategorie(c);*/
        /*System.out.println(sc.consulterCategorie());*/
          /*sc.updateCategorie(updated_c,c);*/
       /* sc.deleteCategorie(updated_c); */
         /*System.out.println(sc.getTrierParNomCat());*/
         /*System.out.println(sc.getCategorieById(sc.consulterCategorie().get(0)));*/
        
        
        //evaluation
        evaluation ev= new evaluation(11,2,13,5);
        evaluation updated_ev = new evaluation(11,2,13,4);
        
        Ievaluation sev = new serviceEvaluation();
        
        /*sev.ajouterEvaluation(ev);  */    
         /*sev.updateEvaluation(updated_ev,ev);*/
        /*System.out.println(sev.consulterEvaluation());*/
        /*sev.deleteEvaluation(ev);*/
        /*System.out.println(sev.getById(sev.consulterEvaluation().get(3)));*/
        /*System.out.println("Le moyenne des Rates est :"+sev.getAvgRates(3));*/
        
        
    }

}
