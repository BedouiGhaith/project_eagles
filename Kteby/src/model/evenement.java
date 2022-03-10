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
public class evenement {
    int id_event ; 
    String evnt_name ;
    String description ;
    Date evnt_date ;
    String nom_club ;
    String image;

    public evenement(int id_event, String evnt_name, String description, Date evnt_date, String nom_club, String image) {
        this.id_event = id_event;
        this.evnt_name = evnt_name;
        this.description = description;
        this.evnt_date = evnt_date;
        this.nom_club = nom_club;
        this.image = image;
    }

    

    public evenement(int id_event, String evnt_name, String description, Date evnt_date, String nom_club) {
        this.id_event = id_event;
        this.evnt_name = evnt_name;
        this.description = description;
        this.evnt_date = evnt_date;
        this.nom_club = nom_club;
    }

    public evenement(int id_event, Date evnt_date) {
        this.id_event = id_event;
        this.evnt_date = evnt_date;
    }

    

    /*public evenement(String evnt_ame) {
        this.evnt_name = evnt_name;
    }
    */
    public evenement(int id_event) {
        this.id_event = id_event;
    }

    public evenement(String evnt_name, String description, Date evnt_date, String nom_club) {
        this.evnt_name = evnt_name;
        this.description = description;
        this.evnt_date = evnt_date;
        this.nom_club = nom_club;
        
    }

    public evenement(String evnt_name, String description, Date evnt_date, String nom_club, String image) {
        this.evnt_name = evnt_name;
        this.description = description;
        this.evnt_date = evnt_date;
        this.nom_club = nom_club;
        this.image = image;
    }

   
    @Override
    public String toString() {
        return "evenement{" + "id_event=" + id_event + ", evnt_name=" + evnt_name + ", description=" + description +", image="+ image +", evnt_date=" + evnt_date + ", nom_club=" + nom_club + '}';
    }

    public evenement() {
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setEvnt_name(String evnt_name) {
        this.evnt_name = evnt_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    

    public void setEvnt_date(Date evnt_date) {
        this.evnt_date = evnt_date;
    }

    public void setNom_club(String nom_club) {
        this.nom_club = nom_club;
    }

    

   

    public int getId_event() {
        return id_event;
    }

    public String getEvnt_name() {
        return evnt_name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    
    
    public Date getEvnt_date() {
        return evnt_date;
    }

    public String getNom_club() {
        return nom_club;
    }

    

    
    
}
