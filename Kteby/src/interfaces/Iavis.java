/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import model.Avis;

/**
 *
 * @author asus
 */
public interface Iavis {
   public void ajouterAvis(Avis a);
   public void deleteAvis(Avis a);
   public void updateAvis(Avis a);
   public List<Avis> consulterAvis();

    public int getTotalCom(String titre,String auteur)throws SQLException;
    
 
}
