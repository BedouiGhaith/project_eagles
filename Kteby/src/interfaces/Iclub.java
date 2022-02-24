/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

import model.club;
import model.livre;

/**
 *
 * @author asus
 */
public interface Iclub {
     public void ajouterClub(club b);
   public void deleteClub(club c);
   public void updateClub(club b , club s);
   public List<club> consulterClub();
   public club getClubById(club c);
   public int calculemembre() ;
}
