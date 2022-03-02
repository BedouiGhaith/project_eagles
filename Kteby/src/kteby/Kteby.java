/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kteby;


import interfaces.Iclub;
import interfaces.Ilivre;
import model.club;

import model.livre;
import model.members;


import services.serviceClub;
import services.serviceLivre;
import services.serviceMembers;

/**
 *
 * @author asus
 */
public class Kteby {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        
      /*  //books
        livre li = new livre("harrypoter","pablo","heloothere","image",5);
        livre updated_livre = new livre("willsmith","pawlo","dracula","image",5);
        
        Ilivre sli = new serviceLivre();
         
        System.out.println(sli.calculelivre());
        sli.ajouterLivre(li);
       
        System.out.println(sli.consulterLivre());
        sli.deleteLivre(li);
        System.out.println(sli.getLivreById(sli.consulterLivre().get(0)));
        
        */
        //club
        Iclub scl = new serviceClub();
        
        club c = new club("club","10/10/1111","me",scl.calculemembre());
        club updated_cl = new club("club1","11/11/1111","he",scl.calculemembre());
        //club cl = new club();
        
        System.out.println(scl.calculemembre()); 
      
        scl.ajouterClub(c);
       
        
        scl.deleteClub(c);
        //System.out.println(scl.consulterClub());
      //  scl.updateClub(updated_cl,c);
        System.out.println(scl.getClubById(scl.consulterClub().get(0)));
        
       //members
        
       /* serviceMembers me = new serviceMembers() ;
        members m1 = new members(4,3);
      //  members m2 = new members(5,5);
        me.ajouterMember(m1);
        me.ajouterMember(m2);
        System.out.println(scl.calculemembre());*/
        
      
        
        
    }

}
