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
public class reclamation {
    int id_reclamation ;
    int id_user ;
    String titre ;
    String description ;
    int status;
    String response;

    public reclamation(int id_reclamation, int id_user, String titre, String description, int status, String response) {
        this.id_reclamation = id_reclamation;
        this.id_user = id_user;
        this.titre = titre;
        this.description = description;
        this.status = status;
        this.response = response;
    }

    public reclamation( String titre, String description) {
        this.titre = titre;
        this.description = description;
    
    }

   public reclamation(int id_reclamation, String titre, String description) {
        this.id_reclamation = id_reclamation;
        this.titre = titre;
        this.description = description;
    }

    public reclamation(int id_user, String titre, String description, int status) {
        this.id_user = id_user;
        this.titre = titre;
        this.description = description;
        this.status = status;
    }
   
  
    public reclamation() {
    }

    public reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public reclamation(int id_reclamation, String response) {
        this.id_reclamation = id_reclamation;
        this.response = response;
    }

    

   

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "reclamation{" + "id_reclamation=" + id_reclamation + ", id_user=" + id_user + ", titre=" + titre + ", description=" + description + ", status=" + status + ", response=" + response + '}';
    }

}