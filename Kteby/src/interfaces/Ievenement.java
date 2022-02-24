/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import model.evenement;

/**
 *
 * @author asus
 */
public interface Ievenement {

    public void ajouterEvenement(evenement e);

    public void deleteEvenement(evenement s);

    public void updateEvenement(evenement e, evenement s);

    public List<evenement> consulterEvenement();
    public evenement getById(int id_event ) throws SQLException;
    public boolean delay ( String newdt,int id_event)  throws SQLException ;
    
}
