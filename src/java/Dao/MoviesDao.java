/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.DBConnection;
import Model.NowShowingEntity;
import Model.TicketPricesEntity;
import Model.UpcomingMoviesEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class MoviesDao {

    public void AddNowShowingMovies(String name, String photo) {

        Connection con = DBConnection.makeConnection();

        String query = "INSERT INTO now_showing_movies(name,photo) VALUES ('" + name + "','" + photo + "')";
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(MoviesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AddUpcomingMovies(String name, String photo) {

        Connection con = DBConnection.makeConnection();

        String query = "INSERT INTO upcoming_movies(name,photo) VALUES ('" + name + "','" + photo + "')";
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(MoviesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<NowShowingEntity> getNowShowingMovies() {
        Connection con = DBConnection.makeConnection();
        String sql = "SELECT * FROM now_showing_movies";
        ArrayList<NowShowingEntity> list = new ArrayList<NowShowingEntity>();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                NowShowingEntity nse = new NowShowingEntity();
                nse.setNsmid(rs.getInt(1));
                nse.setMovie_name((String) rs.getString("name"));
                nse.setPhoto((String) rs.getString("photo"));
                list.add(nse);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MoviesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public ArrayList<UpcomingMoviesEntity> getUpcomingMovies() {
        Connection con = DBConnection.makeConnection();
        String sql = "SELECT * FROM upcoming_movies";
        ArrayList<UpcomingMoviesEntity> list = new ArrayList<UpcomingMoviesEntity>();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                UpcomingMoviesEntity upe = new UpcomingMoviesEntity();
                upe.setUmid(rs.getInt(1));
                upe.setMovie_name((String) rs.getString("name"));
                upe.setPhoto((String) rs.getString("photo"));
                list.add(upe);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MoviesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public ArrayList<NowShowingEntity> getMovies(String mid) {
        Connection con = DBConnection.makeConnection();
        String sql = "SELECT * FROM now_showing_movies WHERE nsmid=" + mid;
        System.out.println(sql);
        ArrayList<NowShowingEntity> list = new ArrayList<NowShowingEntity>();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                NowShowingEntity nse = new NowShowingEntity();
                nse.setNsmid(rs.getInt(1));
                nse.setMovie_name((String) rs.getString("name"));
                nse.setPhoto((String) rs.getString("photo"));
                list.add(nse);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MoviesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public void delete_movie(int mid) {

        Connection con = DBConnection.makeConnection();

        //String query = "INSERT INTO now_showing_movies(name,photo) VALUES ('"+name+"','"+photo+"')";
        String query = "DELETE FROM now_showing_movies where nsmid=" + mid;
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {

        }

    }
    
     public void delete_upcoming_movie(int mid) {

        Connection con = DBConnection.makeConnection();

        //String query = "INSERT INTO now_showing_movies(name,photo) VALUES ('"+name+"','"+photo+"')";
        String query = "DELETE FROM upcoming_movies where umid=" + mid;
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {

        }

    }

    public NowShowingEntity edit_movie(int mid) {
        NowShowingEntity m = new NowShowingEntity();
        String sql="SELECT * FROM now_showing_movies where nsmid=" + mid;
        Connection con = DBConnection.makeConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            m.setNsmid(rs.getInt(1));
            m.setMovie_name(rs.getString(2));
            m.setPhoto(rs.getString(3));
        } catch (SQLException ex) {
            
        }
        return m;
    }
    public void EditNowShowingMovies(String movie_name,String photo, int nsmid)
    {
        String query = "UPDATE now_showing_movies SET name='"+movie_name+"',photo='"+photo+"' WHERE nsmid="+nsmid;
        System.out.println(query);
        Connection con = DBConnection.makeConnection();
        try{
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception ex){
            System.out.println("Error executiong query");
            
        }
    }
    
    public UpcomingMoviesEntity edit_upcoming_movie(int mid) {
        UpcomingMoviesEntity m = new UpcomingMoviesEntity();
        String sql="SELECT * FROM upcoming_movies where umid=" + mid;
        Connection con = DBConnection.makeConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            m.setUmid(rs.getInt(1));
            m.setMovie_name(rs.getString(2));
            m.setPhoto(rs.getString(3));
        } catch (SQLException ex) {
            
        }
        return m;
    }
    
     public void EditUpcomingMovies(String movie_name,String photo, int umid)
    {
        String query = "UPDATE upcoming_movies SET name='"+movie_name+"',photo='"+photo+"' WHERE umid="+umid;
        System.out.println(query);
        Connection con = DBConnection.makeConnection();
        try{
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception ex){
            System.out.println("Error executiong query");
            
        }
    }
    

}
