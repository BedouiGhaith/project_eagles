/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ievaluation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.evaluation;
import util.maConnexion;

/**
 *
 * @author asus
 */
public class serviceEvaluation implements Ievaluation{
Connection cnx = maConnexion.getInstance().getCnx();
    @Override
    public void ajouterEvaluation(evaluation e) {
        if(e.getNb_stars()<=5){
       String Req = "INSERT INTO `evaluation`(`nom_livre`, `nb_stars`) VALUES (?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, e.getNom_livre());
     
            ps.setInt(2, e.getNb_stars());
            ps.execute();
            System.out.println(" Evaluation ajoutée avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        else
    {
        System.out.println("le nombre d'étoiles est hors limites");
        System.out.println("Il faut choisir entre 1 et 5 étoiles !!! ");
        
                
    }
    } 
    

    @Override
    public void deleteEvaluation(evaluation e) {
        try {
            String sql = "DELETE FROM evaluation WHERE id_evaluation=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setInt(1, e.getId_evaluation());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An evaluation was deleted successfully!");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public void updateEvaluation(evaluation e) {
        try {
            String sql = "UPDATE evaluation SET nb_stars=?  WHERE nom_livre=?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, e.getNb_stars());
            ps.setString(2, e.getNom_livre());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing evaluation was updated successfully!");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public List<evaluation> consulterEvaluation() {
        List<evaluation> evaluation = new ArrayList<>();

        String query = "SELECT * FROM evaluation ";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                evaluation.add(new evaluation(rs.getInt("id_evaluation"), rs.getString("nom_livre"), rs.getInt("nb_stars")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return evaluation;
    }
    
    
    public evaluation getById(evaluation e) throws SQLException {
        Statement st=cnx.createStatement();
        String query="select * from evaluation where id_evaluation="+e.getId_evaluation();
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            evaluation ev;
            ev = new evaluation(rs.getInt("id_evaluation"), rs.getString("nom_livre"), rs.getInt("id_user"), rs.getInt("nb_stars"));
            return ev;
        }
        return null;
    }
    

@Override
  public int getAvgRates(String nom_livre) throws SQLException{
        PreparedStatement reqSelectParam = cnx.prepareStatement("SELECT AVG(nb_stars) FROM evaluation WHERE nom_livre = ?");
        reqSelectParam.setString(1, nom_livre);
        ResultSet res = reqSelectParam.executeQuery();
        int avgR = 0;
        while(res.next()){
            avgR = res.getInt(1);
        }
        res.close();
        return avgR;
    }
    
          
    }
