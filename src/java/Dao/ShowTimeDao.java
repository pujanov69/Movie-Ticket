/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.DBConnection;
import Model.ShowTimesEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class ShowTimeDao {
    public void AddShowTime(ShowTimesEntity showtime)
    {
        Connection con = DBConnection.makeConnection();
        
        String query = "INSERT INTO show_time(morning_show_time,afternoon1_show_time,afternoon2_show_time,night1_show_time,night2_show_time) VALUES ('"+showtime.getMorning_show_time()+"','"+showtime.getAfternoon1_show_time()+"','"+showtime.getAfternoon2_show_time()+"','"+showtime.getNight1_show_time()+"','"+showtime.getNight2_show_time()+"')";
        
        //INSERT INTO show_time (morning_show_time,afternoon1_show_time,afternoon2_show_time,night1_show_time,night2_show_time) VALUES ('helow1','helow2','helow3','helow4','helow5');
        
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            
        }
        
        
        
    }
    public String getSeatData(String movie,String showtime,String day)
    {
        Connection con = DBConnection.makeConnection();
    
        String sql = "SELECT seat from seat_booking where movie='"+movie+"'and showtime='"+showtime+"' and day='"+day+"'";
         String seatData="";
        try {
             Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next())
            {
                if(seatData=="")
                   seatData= rs.getInt("seat")+"";
                else
                seatData=seatData+","+rs.getInt("seat");
            }
        } catch (SQLException ex) {
        }
        
            
        
        return seatData;
        
    }
    
    
     public ArrayList<ShowTimesEntity> getShowTimes()
    {
       Connection con = DBConnection.makeConnection();
       String sql = "SELECT * FROM show_time";
       ArrayList<ShowTimesEntity> list = new ArrayList<>();
       
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
            while(rs.next())
            {
                ShowTimesEntity ste = new ShowTimesEntity();
                
                ste.setStid(rs.getInt(1));
                
                ste.setMorning_show_time((String)rs.getString("morning_show_time"));
                ste.setAfternoon1_show_time((String)rs.getString("afternoon1_show_time"));
                ste.setAfternoon2_show_time((String)rs.getString("afternoon2_show_time"));
                ste.setNight1_show_time((String)rs.getString("night1_show_time"));
                ste.setNight2_show_time((String)rs.getString("night2_show_time"));
                list.add(ste);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MoviesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
       
       
    }
     
        public ShowTimesEntity edit_show_time(int stid) {
        ShowTimesEntity ste = new ShowTimesEntity();
        String sql="SELECT * FROM show_time where stid=" + stid;
        Connection con = DBConnection.makeConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            ste.setStid(rs.getInt(1));
            ste.setMorning_show_time(rs.getString(2));
            ste.setAfternoon1_show_time(rs.getString(3));
            ste.setAfternoon2_show_time(rs.getString(4));
            ste.setNight1_show_time(rs.getString(5));
            ste.setNight2_show_time(rs.getString(6));
        } catch (SQLException ex) {
            
        }
        return ste;
    }
        
              public void EditShowTime(String mshow,String afshow1,String afshow2,String nshow1,String nshow2, int stid)
    {
        String query = "UPDATE show_time SET morning_show_time='"+mshow+"',afternoon1_show_time='"+afshow1+"',afternoon2_show_time='"+afshow2+"',night1_show_time='"+nshow1+"',night2_show_time='"+nshow2+"' WHERE stid="+stid;
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
        public void delete_show_time(int stid) {

        Connection con = DBConnection.makeConnection();

        
        String query = "DELETE FROM show_time where stid=" + stid;
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {

        }

    }
    
    
        
    
}
