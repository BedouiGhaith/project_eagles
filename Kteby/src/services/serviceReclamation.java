/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ireclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.reclamation;
import util.maConnexion;

/**
 *
 * @author asus
 */
public class serviceReclamation implements Ireclamation {

        Connection cnx = maConnexion.getInstance().getCnx();
        
    @Override
    public void ajouterReclamation(reclamation e) {
        String Req = "INSERT INTO `reclamation`(`id_user`, `titre`, `description`, `status`, `response`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setInt(1, e.getId_user());
            ps.setString(2, e.getTitre());
            ps.setString(3, e.getDescription());
            ps.setInt(4, e.getStatus());
            ps.setString(5, e.getResponse());
            ps.execute();
            System.out.println(" Reclamation ajoutée avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteReclamation(reclamation s) {
        try {
            String sql = "DELETE FROM reclamation WHERE id_reclamation=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setInt(1, s.getId_reclamation());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A reclamation was deleted successfully!");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public void updateReclamation(reclamation e, reclamation s) {
       try {
            String sql = "UPDATE reclamation SET id_user=?, titre=?, description=? status=?, response=? WHERE id_reclamation=?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, e.getId_user());
            ps.setString(2, e.getTitre());
            ps.setString(3, e.getDescription());
            ps.setInt(4, e.getStatus());
            ps.setString(5, e.getResponse());
            ps.setInt(6, s.getId_reclamation());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("A reclamation user was updated successfully!");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public List<reclamation> consulterReclamation() {
        List<reclamation> reclamation = new ArrayList<>();

        String query = "SELECT * FROM reclamation";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                reclamation.add(new reclamation(rs.getInt("id_reclamation"), rs.getInt("id_user"), rs.getString(3), rs.getString(4), rs.getInt("status"),rs.getString(6)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reclamation;
    }
    
    public reclamation getById(int id_reclamation ) throws SQLException {
        Statement ste=cnx.createStatement();
        String query="SELECT * FROM `reclamation`where id_reclamation="+id_reclamation;
        ResultSet rs=ste.executeQuery(query);
        while(rs.next())
        {
            reclamation rec;
            rec = new reclamation (rs.getInt("id_reclamation"), rs.getInt("id_user"), rs.getString(3), rs.getString(4), rs.getInt("status"),rs.getString(6));
            return rec;
        }
        return null;
    }   
    
    public Boolean exist(int id_reclamation) throws SQLException {
        return getById(id_reclamation)!=null;
    }
    

     
     public boolean Reponse(String rep,int id_reclamation) throws SQLException {
         
        if(exist(id_reclamation))
        {
        Statement ste=cnx.createStatement();
         String query="UPDATE reclamation set status=1 , response='"+rep+"' where id_reclamation="+id_reclamation;
         ste.execute(query);
         System.out.println("la réclamation est traitée avec succés");
         return true;
         
        }
        System.out.println("la réclamation n'existe pas");
        return false;
    }
        
    }
    
   

