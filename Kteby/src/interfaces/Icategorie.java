/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import model.categorie;

/**
 *
 * @author asus
 */
public interface Icategorie {
   public void ajouterCategorie(categorie c);
   public void deleteCategorie(categorie s);
   public void updateCategorie(categorie c,categorie s);
    public List<categorie> consulterCategorie();
   public List<categorie> getTrierParNomCat() throws SQLException;
    public categorie getCategorieById(categorie c) throws SQLException;

   public List<categorie> RechercheParNom(String search);
public categorie rechercheParId(int id_categorie);

  public int getTotalCategorie() throws SQLException;
   
 





    

  

   

    
}
