/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.members;

/**
 *
 * @author asus
 */
public interface Inbrmembers {
    public void ajouterMember(members m);
   public void deleteMember(members m);
   public void updateMember(members m);
   public List<members> consulterNbrMember();
}
