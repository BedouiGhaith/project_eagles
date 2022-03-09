/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Iavis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Avis;
import model.livre;
import model.utilisateur;
import util.maConnexion;

/**
 *
 * @author asus
 */
public class serviceAvis implements Iavis {

    Connection cnx = maConnexion.getInstance().getCnx();

    public void ajouterAvis(Avis a, utilisateur u, livre v) {
        String Req = "INSERT INTO `avis`(`commentaire`,`id_user`, `id_livre`) VALUES (?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, a.getCommentaire());
            ps.setInt(2, u.getId_user());
            ps.setInt(3, v.getId_livre());

            ps.execute();
            System.out.println(" Avis ajoutée avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteAvis(Avis a) {
        try {
            String sql = "DELETE FROM avis WHERE id_Avis=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setInt(1, a.getId_avis());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Avis supprimé");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public void updateAvis(Avis a) {
        try {
            String sql = "UPDATE avis SET commentaire=? WHERE id_Avis=?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, a.getCommentaire());
            ps.setInt(2, a.getId_avis());
            /*ps.setInt(2, a.getId_Avis());
            ps.setInt(2, a.getId_user());
            ps.setInt(3, a.getId_livre());
            ps.setString(4, s);*/
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing opinion was updated successfully!");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public List<Avis> consulterAvis() {
        List<Avis> avis = new ArrayList<>();

        String query = "SELECT * FROM avis";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                avis.add(new Avis(rs.getString(2), rs.getInt(1)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return avis;
    }

    public int getTotalCom(livre v) throws SQLException {
        PreparedStatement reqSelectParam = cnx.prepareStatement("SELECT count(id_avis) FROM Avis WHERE id_livre=? ");
        reqSelectParam.setInt(1, v.getId_livre());

        ResultSet res = reqSelectParam.executeQuery();
        //  int sumCom = 0;
        // while (res.next()) {
        int sumCom = res.getInt(1);
        // }
        res.close();
        return sumCom;
    }

    /*
    public Avis getById(int id_avis) throws SQLException {
        Statement st = cnx.createStatement();
        String query = "select * from avis where id_avis='" + id_avis + "'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Avis av;
            av = new Avis(rs.getInt("id_Avis"), rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            return av;
        }
        return null;
    }

    public Avis getAvisByComment(Avis a) {
        Avis av = new Avis();
        String query = "SELECT * FROM avis where commentaire= '" + a.getCommentaire() + "'";
        /* String query = "SELECT * FROM avis where commentaire= " + a.getCommentaire();*/
 /*
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                av.setId_Avis(rs.getInt("id_Avis"));
                av.setCommentaire(rs.getString(1));
                 av.setPrenom(rs.getString(2));
            av.setNom_user(rs.getString(3));
            av.setTitre(rs.getString(4));
            av.setAuteur(rs.getString(5));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return av;
    }
     */
 /*
    public static String reactComment() {

        Scanner sc = new Scanner(System.in);
        System.out.println("react:like or dislike");
        String react = sc.nextLine();

        while (!react.equals("Like") || !react.equals("Dislike")) {
            System.out.println("react:like or dislike");
            react = sc.nextLine();
        }
        return react;
    }
     */

    public void like(Avis a, utilisateur u) {
        try {
            Statement st = cnx.createStatement();
            // System.out.println(id_user+ " | " + id_livre);
             String query = "SELECT * FROM review WHERE id_Avis = " + a.getId_avis() + " AND id_user = "+u.getId_user();
            ResultSet rs = st.executeQuery(query);
            if (rs.next() == false) {
            String query2 = "INSERT INTO review (id_Avis,id_user,opinion) VALUES(?,?,1)";
            PreparedStatement ps = cnx.prepareStatement(query2);
            ps.setInt(1, a.getId_avis());
            ps.setInt(2, u.getId_user());
            ps.execute();
             } else {
                String query2 ="UPDATE review  Set opinion = 1 where  id_Avis = ? AND id_user = ?" ;
                PreparedStatement ps = cnx.prepareStatement(query2);
               ps.setInt(1, a.getId_avis());
               ps.setInt(2, u.getId_user());
               ps.execute();

          }
        } catch (SQLException ex) {
            Logger.getLogger(serviceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

       public void dislike(Avis a, utilisateur u) {
        try {
            Statement st = cnx.createStatement();
            // System.out.println(id_user+ " | " + id_livre);
             String query = "SELECT * FROM review WHERE id_Avis = " + a.getId_avis() + " AND id_user = "+u.getId_user();
            ResultSet rs = st.executeQuery(query);
            if (rs.next() == false) {
            String query2 = "INSERT INTO review (id_Avis,id_user,opinion) VALUES(?,?,0)";
            PreparedStatement ps = cnx.prepareStatement(query2);
            ps.setInt(1, a.getId_avis());
            ps.setInt(2, u.getId_user());
            ps.execute();
             } else {
                
                String query2 ="UPDATE review  Set opinion = 0 where  id_Avis = ? AND id_user = ?" ;
                PreparedStatement ps = cnx.prepareStatement(query2);
               ps.setInt(1, a.getId_avis());
               ps.setInt(2, u.getId_user());
               ps.execute();
          }
        } catch (SQLException ex) {
            Logger.getLogger(serviceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
        public void dislike(Avis a) {
        try {
            Statement st = cnx.createStatement();
            // System.out.println(id_user+ " | " + id_livre);
            String query = "SELECT * FROM avis WHERE commentaire = " + a.getCommentaire()+"AND prenom ="+a.getPrenom()+"AND num_user ="+a.getNom_user();
            ResultSet rs = st.executeQuery(query);
            if (rs.next() == false) {
                String query2 = "INSERT INTO avis (commentaire,prenom,nom_user,titre,auteur,opinion) VALUES(?,?,?,?,?,-1)";
                PreparedStatement ps = cnx.prepareStatement(query2);
                
            ps.setString(1, a.getCommentaire());
            ps.setString(2, a.getPrenom());
            ps.setString(3, a.getNom_user());
            ps.setString(4, a.getTitre());
            ps.setString(5, a.getAuteur());
                ps.execute();
            } else {
                String query2 = "UPDATE avis  Set opinion = -1 where  commentaire = " + a.getCommentaire()+"AND prenom ="+a.getPrenom()+"AND num_user ="+a.getNom_user();
                PreparedStatement ps = cnx.prepareStatement(query2);
                 ps.setString(1, a.getCommentaire());
            ps.setString(2, a.getPrenom());
            ps.setString(3, a.getNom_user());
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
    public ArrayList<Avis> getbooksComments(Avis a) {
        ArrayList<Avis> commentsList = new ArrayList();
        try {
            Statement st = cnx.createStatement();

            String query = "SELECT * FROM avis where commentaire= '" + a.getCommentaire() + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Avis av = new Avis();
                av.setId_Avis(rs.getInt("id_Avis"));
                av.setCommentaire(rs.getString(1));
                   av.setPrenom(rs.getString(2));
            av.setNom_user(rs.getString(3));
            av.setTitre(rs.getString(4));
            av.setAuteur(rs.getString(5));
                commentsList.add(av);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return commentsList;
    }*/

    @Override
    public void ajouterAvis(Avis a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTotalCom(String titre, String auteur) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
