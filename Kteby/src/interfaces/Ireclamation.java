/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import model.reclamation;

/**
 *
 * @author asus
 */
public interface Ireclamation {
    public void ajouterReclamation(reclamation e);

    public void deleteReclamation(reclamation e);

    public void updateReclamation(reclamation e);

    public List<reclamation> consulterReclamation();
    public reclamation getById(int id_reclamation ) throws SQLException;

    public boolean Reponse(String rep, int id_reclamation)throws SQLException;
}

