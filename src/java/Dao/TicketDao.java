/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.DBConnection;
import Model.TicketPricesEntity;
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
public class TicketDao {
     public void AddTicketPrice(TicketPricesEntity ticketprice)
    {
        Connection con = DBConnection.makeConnection();
        
        String query = "INSERT INTO ticket_price(day,price) VALUES ('"+ticketprice.getDay()+"','"+ticketprice.getPrice()+"')";
        System.out.println(query);
                
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            
        }
        
        
        
    }
      public ArrayList<TicketPricesEntity> getTicketPrice()
    {
       Connection con = DBConnection.makeConnection();
       String sql = "SELECT * FROM ticket_price";
       ArrayList<TicketPricesEntity> list = new ArrayList<>();
       
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
            while(rs.next())
            {
                TicketPricesEntity tpe = new TicketPricesEntity();
                
                tpe.setTpid(rs.getInt(1));
                tpe.setDay((String)rs.getString("day"));
                tpe.setPrice((String)rs.getString("price"));
                
                list.add(tpe);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MoviesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
       
       
    }
      
      
     
        public TicketPricesEntity edit_ticket_price(int tpid) {
        TicketPricesEntity m = new TicketPricesEntity();
        String sql="SELECT * FROM ticket_price where tpid=" + tpid;
        Connection con = DBConnection.makeConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            m.setTpid(rs.getInt(1));
            m.setDay(rs.getString(2));
            m.setPrice(rs.getString(3));
        } catch (SQLException ex) {
            
        }
        return m;
    }
        
          public void EditTicketPrice(String day,String price, int tpid)
    {
        String query = "UPDATE ticket_price SET day='"+day+"',price='"+price+"' WHERE tpid="+tpid;
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
          
          public void delete_ticket_prices(int tpid) {

        Connection con = DBConnection.makeConnection();

        
        String query = "DELETE FROM ticket_price where tpid=" + tpid;
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {

        }

    }
    
    
}
