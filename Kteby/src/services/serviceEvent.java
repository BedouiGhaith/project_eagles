/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ievenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.evenement;
import util.maConnexion;

/**
 *
 * @author asus
 */
public class serviceEvent implements Ievenement {

    Connection cnx = maConnexion.getInstance().getCnx();

    @Override
    public void ajouterEvenement(evenement e) {
        String Req = "INSERT INTO `evenement`(`evnt_name`, `description`, `evnt_date`, `id_club`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, e.getEvnt_name());
            ps.setString(2, e.getDescription());
            ps.setString(3, e.getEvnt_date());
            ps.setInt(4, e.getId_club());
            ps.execute();
            System.out.println(" evenement ajoutée avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEvenement(evenement e) {
            try {
        String sql = "DELETE FROM evenement WHERE id_event=?";
        
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.setInt(1, e.getId_event());
        
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("An event was deleted successfully!");
        }   } catch (SQLException ex) {
    }
    }

    @Override
    public void updateEvenement(evenement e) {
        try {
            String sql = "UPDATE evenement SET evnt_name=?, description=?, evnt_date=?, id_club=? WHERE id_event=?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, e.getEvnt_name());
            ps.setString(2, e.getDescription());
            ps.setString(3, e.getEvnt_date());
            ps.setInt(4, e.getId_club());
            ps.setInt(5, e.getId_event());
            ps.execute();

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing event was updated successfully!");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public List<evenement> consulterEvenement() {
        List<evenement> evnt = new ArrayList<>();

        String query = "SELECT * FROM evenement e inner join club c where e.id_club=c.id_club";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                evnt.add(new evenement(rs.getInt("id_event"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt("id_club")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return evnt;
    }
    
    public evenement getById(int id_event ) throws SQLException {
        Statement ste=cnx.createStatement();
        String query="SELECT * FROM `evenement`where id_event="+id_event;
        ResultSet rs=ste.executeQuery(query);
        while(rs.next())
        {
            evenement rec;
            rec = new evenement (rs.getInt("id_event"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt("id_club"));
            return rec;
        }
        return null;
    }   
    
    
    
    public Boolean exist(int id_event) throws SQLException {
        return getById(id_event)!=null;
    }
    
    
    public boolean delay ( String newdt,int id_event)  throws SQLException  {
       if(exist(id_event))
        {
        Statement ste=cnx.createStatement();
        String sql= "UPDATE evenement SET  evnt_date='"+newdt+"' where id_event="+id_event;
         ste.execute(sql);
    System.out.println("An existing event was updated successfully!");
            return true; 
        }
        System.out.println("l'evenement n'existe pas");
        return false;
 
}

    
}



