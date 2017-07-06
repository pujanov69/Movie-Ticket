/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.DBConnection;
import Model.UserInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class UserDao {
    
    public void signup(UserInfo user)
    {
        Connection con = DBConnection.makeConnection();
        
        String query = "INSERT INTO user_info(username,password,name,gender,address,mobile,email,type) VALUES ('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getName()+"','"+user.getGender()+"','"+user.getAddress()+"','"+user.getMobile()+"','"+user.getEmail()+"',"+2+")";
        
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public UserInfo SignIn(String username,String password)
    {
        Connection con = DBConnection.makeConnection();
        
        String query = "SELECT * FROM User_Info WHERE username='"+username+"' AND password='"+password+"'";
        UserInfo userInfo = new UserInfo();
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                userInfo.setUsername((String)rs.getString("username"));
                userInfo.setPassword((String)rs.getString("password"));
                userInfo.setName((String)rs.getString("name"));
                userInfo.setGender((String)rs.getString("gender"));
                userInfo.setMobile((String)rs.getString("mobile"));
                userInfo.setEmail((String)rs.getString("email"));
                userInfo.setType((Integer)rs.getInt("type"));
            }
            else
                userInfo=null;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userInfo;
    }
}
