/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ilivre;
import interfaces.Inbrmembers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.livre;
import model.members;
import util.maConnexion;

/**
 *
 * @author asus
 */
public class serviceMembers implements Inbrmembers{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    Connection cnx = maConnexion.getInstance().getCnx();

   

    @Override
    public void ajouterMember(members m) {
         String Req = "INSERT INTO `members`(`id_user`,`id_club`) VALUES (?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setInt(1, m.getId_user());
            ps.setInt(2, m.getId_club());
            ps.execute();
            System.out.println(" member ajoutée avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void deleteMember(members m) {
         try {
            String sql = "DELETE FROM members WHERE id_user=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setInt(1, m.getId_user());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A member was deleted successfully!");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public void updateMember(members m,members me) {
        try {
            String sql = "UPDATE nbr_members SET id_user=?, id_club=?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, m.getId_user());
            ps.setInt(2, m.getId_club());
            ps.setInt(3, me.getId_user());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing member was updated successfully!");
            }
        } catch (SQLException ex) {
        }
    }

/*    @Override
    public List<members> consulterNbrMember() {
         List<livre> livre = new ArrayList<>();

        String query = "SELECT * FROM nbr_members";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                livre.add(new livre(rs.getInt("id_user"), rs.getInt("id_club")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return members;
    }*/

    @Override
    public List<members> consulterNbrMember() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

}


