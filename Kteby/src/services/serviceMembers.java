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
         String Req = "INSERT INTO `nbr_members`() VALUES (?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            
            ps.execute();
            System.out.println(" Livre ajoutée avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void deleteMember(String s) {
         try {
            String sql = "DELETE FROM nbrmembers WHERE titre=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setString(1, s);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A member was deleted successfully!");
            }
        } catch (SQLException ex) {
        }
    }

   /* @Override
    public void updateMember(members m,String s) {
        try {
            String sql = "UPDATE nbr_members";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(6, s);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing book was updated successfully!");
            }
        } catch (SQLException ex) {
        }
    }*/

   /* @Override
    public List<nbrmember> consulterNbrMember() {
         List<livre> livre = new ArrayList<>();

        String query = "SELECT * FROM nbr_members";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                livre.add(new livre(rs.getInt("id_livre"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt("categorie")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return members;
    }*/

    @Override
    public void deleteMember(members m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMember(members m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<members> consulterNbrMember() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


