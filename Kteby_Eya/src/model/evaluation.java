/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author asus
 */
public class evaluation {

    int id_evaluation;
    String nom_livre;
    int id_user;
    int nb_stars;

    public evaluation(int id_evaluation, String nom_livre, int id_user, int nb_stars) {
        this.id_evaluation = id_evaluation;
        this.nom_livre = nom_livre;
        this.id_user = id_user;
        this.nb_stars = nb_stars;
    }

    public evaluation(String nom_livre, int nb_stars) {
        this.nom_livre = nom_livre;
        this.nb_stars = nb_stars;
    }

      public evaluation(int id_evaluation, int nb_stars) {
        this.id_evaluation = id_evaluation;
        this.nb_stars = nb_stars;
    }
      public evaluation(int id_evaluation,String nom_livre, int nb_stars) {
        this.id_evaluation = id_evaluation;
        this.nom_livre = nom_livre;
        this.nb_stars = nb_stars;
    }

    public evaluation(int id_evaluation) {
        this.id_evaluation = id_evaluation;
    }
      


    public evaluation() {
    }



    public int getId_evaluation() {
        return id_evaluation;
    }

    

    public int getNb_stars() {
        return nb_stars;
    }

    public void setNb_stars(int nb_stars) {
        this.nb_stars = nb_stars;
    }

    
    

    public void setId_evaluation(int id_evaluation) {
        this.id_evaluation = id_evaluation;
    }

    public String getNom_livre() {
        return nom_livre;
    }

    public void setNom_livre(String nom_livre) {
        this.nom_livre = nom_livre;
    }

   

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_user() {
        return id_user;
    }

    @Override
    public String toString() {
        return "evaluation{" + "id_evaluation=" + id_evaluation + ", nom_livre=" + nom_livre + ", id_user=" + id_user + ", star=" + nb_stars + '}';
    }

}
