/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import model.evaluation;

/**
 *
 * @author asus
 */
public interface Ievaluation {
    public void ajouterEvaluation(evaluation e);
   public void deleteEvaluation(evaluation s);
   public void updateEvaluation(evaluation e);
   public List<evaluation> consulterEvaluation();
   public evaluation getById(evaluation e) throws SQLException;
   public int getAvgRates(String nom_livre) throws SQLException;
   /* public Boolean exist(evaluation e)throws SQLException;*/
/*
    /**
     *
     * @param e
     * @return moyStars
     
    public double moyenneStars(evaluation e);*/

  
   
}
