/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class Avis {

    private String commentaire;
    

    private int id_avis;

    public Avis() {
    }

    public Avis(int id_avis) {
        this.id_avis = id_avis;
    }

    
    public Avis(String commentaire, int id_avis) {
        this.commentaire = commentaire;
        this.id_avis = id_avis;
    }

    public Avis(String commentaire) {
        this.commentaire = commentaire;
    }
    
    

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getId_avis() {
        return id_avis;
    }

    public void setId_avis(int id_avis) {
        this.id_avis = id_avis;
    }

    @Override
    public String toString() {
        return "Avis{" + "commentaire=" + commentaire + ", id_avis=" + id_avis + '}';
    }


}
