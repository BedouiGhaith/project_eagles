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
       String Req = "INSERT INTO `evaluation`(`id_livre`, `id_user`, `nb_stars`) VALUES (?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setInt(1, e.getId_livre());
            ps.setInt(2, e.getId_user());
            ps.setInt(3, e.getNb_stars());
            ps.execute();
            System.out.println(" Evaluation ajoutée avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEvaluation(String s) {
        try {
            String sql = "DELETE FROM evaluation WHERE id_evaluation=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setString(1, s);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A book was deleted successfully!");
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public void updateEvaluation(evaluation e, String s) {
        try {
            String sql = "UPDATE evaluation SET nb_stars=? WHERE id_evaluation=?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, e.getNb_stars());
            ps.setString(2, s);
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

        String query = "SELECT * FROM evaluation";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                evaluation.add(new evaluation(rs.getInt("id_evaluation"), rs.getInt("id_livre"), rs.getInt("id_user"), rs.getInt("nb_stars")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return evaluation;
    }
    
    
    public evaluation getById(int id_evaluation) throws SQLException {
        Statement st=cnx.createStatement();
        String query="select * from evaluation where id_evaluation='"+id_evaluation+"'";
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            evaluation ev;
            ev = new evaluation(rs.getInt("id_evaluation"), rs.getInt("id_livre"), rs.getInt("id_user"), rs.getInt("nb_stars"));
            return ev;
        }
        return null;
    }
    
    public Boolean exist(int id_evaluation) throws SQLException {
        if(getById(id_evaluation)!=null)
        {
            return true;
        }
        return false;
    }
    /**
     *
     * @return moyStars
     * @throws SQLException
     */
    
     /*public double moyenneStars() {
        
        List<evaluation> list=consulterEvaluation();
        double moyStars=0;
        int ratingCount=0;
        int nb_stars_sum=0;
        for(evaluation ev:list)
        {
            ratingCount=(ratingCount+ev.getNb_stars());
            nb_stars_sum=(nb_stars_sum+ev.getNb_stars())*ev.getNb_stars(); 
            moyStars=nb_stars_sum/ratingCount;
        }
       
        System.out.println(ratingCount);
        
        return moyStars;
    }*/
    
    /**
     * 
    @param id_livre 
  * @return averageRating
   */
/*public double getAverageRating(int id_livre){

   evaluation e = new evaluation();
   ResultSet rs = null;
    float ratingSum =0;
    int ratingCount =0;
    double averageRating=0.0;

    try{
        
        String sql="Select sum(nb_stars),count(nb_stars) from evaluation  where id_livre=='\"+p.getId_livre()+\"'\" group by nb_stars ";
        PreparedStatement ps = cnx.prepareStatement(sql);
        ps.setInt(1,e.getId_livre());
        rs=ps.executeQuery();

        while (rs.next()) {
            ratingSum=ratingSum+rs.getInt("sum(nb_stars)");
            ratingCount=ratingCount+rs.getInt("count(nb_stars)");

        }

        averageRating=ratingSum/ratingCount;

    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
    

    return averageRating;
}*/

   /*public double getAverageRating(int id_livre){

   evaluation e = new evaluation();
   ResultSet rs = null;
    float ratingSum =0;
    int ratingCount =0;
    double avgR=0;
    double averageRating=0.0;

    try{
        
        String sql="SELECT  AVG(nb_stars)FROM evaluation  where id_livre=? group by id_evaluation ";
        PreparedStatement ps = cnx.prepareStatement(sql);
        ps.setInt(1,e.getId_livre());
        rs=ps.executeQuery();
        avgR=
    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
    

    return avgR;
}*/
   
   
  public int getAvgRates(int id_livre) throws SQLException{
        PreparedStatement reqSelectParam = cnx.prepareStatement("SELECT AVG(nb_stars) FROM evaluation WHERE id_livre = ?");
        reqSelectParam.setInt(1, id_livre);
        ResultSet res = reqSelectParam.executeQuery();
        int avgR = 0;
        while(res.next()){
            avgR = res.getInt(1);
        }
        res.close();
        return avgR;
    }
    
          
    }
