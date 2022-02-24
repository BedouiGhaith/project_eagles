/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Iutilisateur;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import model.utilisateur;
import util.maConnexion;

/**
 *
 * @author asus
 */
public class serviceUtilisateur implements Iutilisateur {

    Connection cnx = maConnexion.getInstance().getCnx();

    @Override
    public void ajouterUtilisateur(utilisateur u) {
        String Req = "INSERT INTO `utilisateur`(`nom_utilisateur`, `mdp`,`email`,`prenom_utilisateur`,`age`,`type`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, u.getNom_user());
            ps.setString(2, u.getMot_de_passe());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPrenom());
            ps.setInt(5, u.getAge());
            ps.setString(6, u.getType());
            ps.execute();
            System.out.println(" Utilisateur ajoutée avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteUtilisateur(utilisateur s) {
        try {
            String sql = "DELETE FROM utilisateur WHERE nom_utilisateur=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setString(1, s.getNom_user());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public void updateUtilisateur(utilisateur u, utilisateur s) {
        try {
            String sql = "UPDATE utilisateur SET nom_utilisateur=?, mdp=?, email=?, prenom_utilisateur=?, age=?, type=? WHERE nom_utilisateur=?";

            PreparedStatement statement = cnx.prepareStatement(sql);

            statement.setString(1, u.getNom_user());
            statement.setString(2, u.getMot_de_passe());
            statement.setString(3, u.getEmail());
            statement.setString(4, u.getPrenom());
            statement.setInt(5, u.getAge());
            statement.setString(6, u.getType());
            statement.setString(7, s.getNom_user());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public List<utilisateur> consulterUtilisateur() {
        List<utilisateur> utilisateur = new ArrayList<>();

        String query = "SELECT * FROM utilisateur";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                utilisateur.add(new utilisateur(rs.getInt("id_user"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt("age"), rs.getString(7)));
            }

        } catch (SQLException ex) {
        }
        return utilisateur;
    }

    @Override
    public utilisateur getUserById(utilisateur u) {
        utilisateur user = new utilisateur();

        String query = "SELECT * FROM utilisateur where " + " id_user= " + u.getId_user();

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                user = new utilisateur(rs.getInt("id_user"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt("age"), rs.getString(7));
            }

        } catch (SQLException ex) {
        }
        return user;
    }

    @Override
    public utilisateur getUserByEmail(utilisateur u) {
        utilisateur user = new utilisateur();

        String query = "SELECT * FROM utilisateur where " + " email= " + u.getEmail();

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                user = new utilisateur(rs.getInt("id_user"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt("age"), rs.getString(7));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public List<utilisateur> getUserByName(utilisateur u) {
        List<utilisateur> user = new ArrayList<>();

        String query = "SELECT * FROM utilisateur where " + " prenom_utilisateur= " + u.getPrenom();

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                user.add(new utilisateur(rs.getInt("id_user"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt("age"), rs.getString(7)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public utilisateur getUserByUsername(utilisateur u) {
        utilisateur user = new utilisateur();

        String query = "SELECT * FROM utilisateur where " + " nom_utilisateur= " + u.getNom_user();

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                user = new utilisateur(rs.getInt("id_user"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt("age"), rs.getString(7));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public List<utilisateur> getUserByAge(utilisateur u) {
        List<utilisateur> user = new ArrayList<>();

        String query = "SELECT * FROM utilisateur where "
                + "age= " + u.getAge();

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                user.add(new utilisateur(rs.getInt("id_user"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt("age"), rs.getString(7)));
            }

        } catch (SQLException ex) {
        }
        return user;
    }

    
    @Override
    public String generateStorngPasswordHash(String password)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);

        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    public static boolean validatePassword(String originalPassword, String storedPassword)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);

        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(),
                salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for (int i = 0; i < hash.length && i < testHash.length; i++) {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }

    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
    @Override
    public int countUsers(){
        int c = 0;
        
        String query = "SELECT count(*) FROM utilisateur";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = rs.getInt(1);
            }

        } catch (SQLException ex) {
        }
        return c;
    }

}
