/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.DBConnection;
import Model.FinalBookingEntity;
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
public class FinalBookingDao {
     public void booknow(FinalBookingEntity booking,String seatArray[])
    {
      Connection con = DBConnection.makeConnection();
        
        
        String query = "INSERT INTO final_booking(user_name,movie_choosen,showtime_choosen,day_choosen,payment,gender,address,email) VALUES('"+booking.getUser_name()+"','"+booking.getMovie_choosen()+"','"+booking.getShowtime_choosen()+"','"+booking.getDay_choosen()+"','"+booking.getPayment()+"','"+booking.getGender()+"','"+booking.getAddress()+"','"+booking.getEmail()+"')";
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            
        }   
        
        for(int i=0;i<seatArray.length;i++)
        {
        String query2 = "INSERT INTO seat_booking(movie,showtime,day,user,seat)values('"+booking.getMovie_choosen()+"','"+booking.getShowtime_choosen()+"','"+booking.getDay_choosen()+"','"+booking.getUser_name()+"',"+seatArray[i]+")";
            
        try {
            st = con.createStatement();
            st.executeUpdate(query2);
        } catch (SQLException ex) {
            System.out.println("Error has been occured");
        }   
        }
        
        
    }
     public ArrayList<FinalBookingEntity> getFinalBooking() {
        Connection con = DBConnection.makeConnection();
        String sql = "SELECT * FROM final_booking";
        ArrayList<FinalBookingEntity> list = new ArrayList<FinalBookingEntity>();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                FinalBookingEntity fbe = new FinalBookingEntity();
                
                fbe.setUser_name((String) rs.getString("user_name"));
                fbe.setMovie_choosen((String) rs.getString("movie_choosen"));
                fbe.setPayment((String) rs.getString("payment"));
                fbe.setAddress((String) rs.getString("address"));
                fbe.setEmail((String) rs.getString("email"));
                
                list.add(fbe);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MoviesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    
}


