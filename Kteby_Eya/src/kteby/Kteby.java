/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kteby;

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
        /*categorie c = new categorie("enfant");
        categorie updated_c = new categorie("adulte");
        
        serviceCategorie sc = new serviceCategorie();
        System.out.println(sc.consulterCategorie());
        sc.rechercheParId(5); 
        sc.RechercheParNom("horreur").forEach(System.out::println);
        
        /*sc.ajouterCategorie(c);
        System.out.println(sc.consulterCategorie());
        sc.updateCategorie(updated_c, "enfant");
        sc.deleteCategorie("adulte");*/
        
        
        //evaluation
        evaluation ev= new evaluation(1,2,13,3);
        evaluation updated_ev = new evaluation(1,2,4);
        
        serviceEvaluation sev = new serviceEvaluation();
        
        /*sev.ajouterEvaluation(ev);*/
        /*System.out.println(sev.CalculAvgRating());*/
        
        /*sev.updateEvaluation(updated_ev, "1");*/
        /*System.out.println(sev.consulterEvaluation());
        /*sev.deleteEvaluation("1");*/
        System.out.println(sev.moyenneStars());
       /* System.out.println(sev.getAverageRating());*/
        
        
        
    }

}
