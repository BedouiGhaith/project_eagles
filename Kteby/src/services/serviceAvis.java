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
import util.maConnexion;

/**
 *
 * @author asus
 */
public class serviceAvis implements Iavis {

    Connection cnx = maConnexion.getInstance().getCnx();

    @Override
    public void ajouterAvis(Avis a) {
        String Req = "INSERT INTO `avis`(`commentaire`, `id_user`,`id_livre`) VALUES (?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, a.getCommentaire());
            ps.setInt(2, a.getId_user());
            ps.setInt(3, a.getId_livre());
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
            statement.setInt(1, a.getId_Avis());

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
            ps.setInt(2, a.getId_Avis());
            /*ps.setInt(2, a.getId_user());
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
                avis.add(new Avis(rs.getInt("id_Avis"), rs.getString(2), rs.getInt("id_user"), rs.getInt("id_livre")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return avis;
    }

    @Override
    public int getTotalCom(int id_livre) throws SQLException {
        PreparedStatement reqSelectParam = cnx.prepareStatement("SELECT count(id_avis) FROM Avis WHERE id_livre = ?");
        reqSelectParam.setInt(1, id_livre);
        ResultSet res = reqSelectParam.executeQuery();
        int sumCom = 0;
        while (res.next()) {
            sumCom = res.getInt(1);
        }
        res.close();
        return sumCom;
    }

    public Avis getById(int id_avis) throws SQLException {
        Statement st = cnx.createStatement();
        String query = "select * from avis where id_avis='" + id_avis + "'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Avis av;
            av = new Avis(rs.getInt("id_Avis"), rs.getString(2), rs.getInt("id_user"), rs.getInt("id_livre"));
            return av;
        }
        return null;
    }

    public Avis getAvisByComment(Avis a) {
        Avis av = new Avis();
        String query = "SELECT * FROM avis where commentaire= '" + a.getCommentaire() + "'";
        /* String query = "SELECT * FROM avis where commentaire= " + a.getCommentaire();*/

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                av.setId_Avis(rs.getInt("id_Avis"));
                av.setCommentaire(rs.getString(2));
                av.setId_livre(rs.getInt("id_livre"));
                av.setId_user(rs.getInt("id_user"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return av;
    }

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

    public void like(int id_user, int id_livre) {
        try {
            Statement st = cnx.createStatement();
            // System.out.println(id_user+ " | " + id_livre);
            String query = "SELECT * FROM react WHERE id_user = " + id_user + "AND id_livre = " + id_livre;
            ResultSet rs = st.executeQuery(query);
            if (rs.next() == false) {
                String query2 = "INSERTE INTO react (id_user,id_livre,opinion) VALUES(?,?,1)";
                PreparedStatement ps = cnx.prepareStatement(query2);
                ps.setInt(1, id_user);
                ps.setInt(2, id_livre);

                ps.execute();
            } else {
                String query2 = "UPDATE react  Set opinion = 1 where id_user = ? and id_livre = ?";
                PreparedStatement ps = cnx.prepareStatement(query2);
                ps.setInt(1, id_user);
                ps.setInt(2, id_livre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void dislike(int id_user, int id_livre) {
        try {
            Statement st = cnx.createStatement();
            // System.out.println(id_user+ " | " + id_livre);
            String query = "SELECT * FROM react WHERE id_user = " + id_user + "AND id_livre = " + id_livre;
            ResultSet rs = st.executeQuery(query);
            if (rs.next() == false) {
                String query2 = "INSERTE INTO react (id_user,id_livre,opinion) VALUES(?,?,-1)";
                PreparedStatement ps = cnx.prepareStatement(query2);
                ps.setInt(1, id_user);
                ps.setInt(2, id_livre);

                ps.execute();
            } else {
                String query2 = "UPDATE react  Set opinion = -1 where id_user = ? and id_livre = ?";
                PreparedStatement ps = cnx.prepareStatement(query2);
                ps.setInt(1, id_user);
                ps.setInt(2, id_livre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Avis> getbooksComments(Avis a) {
        ArrayList<Avis> commentsList = new ArrayList();
        try {
            Statement st = cnx.createStatement();

            String query = "SELECT * FROM avis where commentaire= '" + a.getCommentaire() + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Avis av = new Avis();
                av.setId_Avis(rs.getInt("id_Avis"));
                av.setCommentaire(rs.getString(2));
                av.setId_livre(rs.getInt("id_livre"));
                av.setId_user(rs.getInt("id_user"));
                commentsList.add(av);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return commentsList;
    }
}
