/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Icategorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.categorie;

import util.maConnexion;

/**
 *
 * @author asus
 */
public class serviceCategorie implements Icategorie{
Connection cnx = maConnexion.getInstance().getCnx();
    @Override
    public void ajouterCategorie(categorie c) {
        String Req = "INSERT INTO `categorie`(`nom_categorie`) VALUES (?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, c.getNom_categorie()
            );
            ps.execute();
            System.out.println(" Categorie ajoutée avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteCategorie(categorie c) {
        try {
            String sql = "DELETE FROM categorie WHERE id_categorie=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setInt(1, c.getId_categorie());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A category was deleted successfully!");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public void updateCategorie(categorie c) {
        try {
             String sql = "UPDATE categorie SET nom_categorie =? WHERE id_categorie=?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, c.getNom_categorie());
            ps.setInt(2, c.getId_categorie());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing category was updated successfully!");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public List<categorie> consulterCategorie() {
        List<categorie> categorie = new ArrayList<>();

        String query = "SELECT * FROM categorie c inner join livre l where l.id_categorie=c.id_categorie";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                categorie.add(new categorie(rs.getInt("id_categorie"), rs.getString(2)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categorie;
    }
    
    
    
    public categorie getCategorieById(categorie c) throws SQLException {
        Statement st=cnx.createStatement();
        String query="select * from categorie where id_categorie = "+c.getId_categorie();
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            categorie cg;
            cg = new categorie(rs.getInt("id_categorie"), rs.getString("nom_categorie"));
            return cg;
        }
        return null;
    }
    
@Override
    public categorie rechercheParId(int id_categorie) {
        categorie d = new categorie();
        try {
            String req = "SELECT * FROM categorie where id_categorie = '"+id_categorie+"'";
            PreparedStatement pre = cnx.prepareStatement(req);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                d.setId_categorie(rs.getInt(1));
                d.setNom_categorie(rs.getString(2));
            }
        
        if(d.getNom_categorie() == null){
            System.out.println("Categorie n'existe pas!");
        } else {
            System.out.println("Categorie de nom "+d.getNom_categorie()+" Trouvé!");
        }
        
        } catch(SQLException ex) {
           System.out.println("erreur de requette "+ex);
       }
       return d;
    }
    
    public List<categorie> RechercheParNom(String search) {
        String req = "SELECT * FROM categorie WHERE nom_categorie="+(char)34+search+(char)34;
        List<categorie> list = new ArrayList<>();
        try {
            PreparedStatement pre = cnx.prepareStatement(req);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new categorie(rs.getInt("id_categorie"), rs.getString("nom_categorie")));
            }
            
            if(list.isEmpty()){
                System.out.println("N'existe pas dans la base de donnée");
            }else{
                System.out.println("Categorie Trouvé!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(serviceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    
    public List<categorie> getTrierParNomCat() throws SQLException {
        List<categorie> array = new ArrayList<>();
        String sql ="select * from categorie ORDER BY nom_categorie ASC";
        PreparedStatement pre = cnx.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
         while (rs.next()) {                
                   int id_categorie = rs.getInt(1);
                   String nom_categorie = rs.getString(2);
                   categorie c = new categorie(id_categorie,nom_categorie);
            array.add(c);
        }
         
        System.out.println("trié avec succés ");
        return array;
    }
    
    
     public int getTotalCategorie() throws SQLException{
        PreparedStatement reqSelectParam = cnx.prepareStatement("SELECT COUNT(id_categorie) FROM categorie ");
        ResultSet res = reqSelectParam.executeQuery();
        int sumLiv = 0;
        while(res.next()){
            sumLiv = res.getInt(1);
        }
        res.close();
        return sumLiv;
    }
    
    
    }
