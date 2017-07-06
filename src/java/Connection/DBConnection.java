/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author dell
 */
public class DBConnection {
     public static Connection makeConnection(){
       try{
            Class.forName("com.mysql.jdbc.Driver");
            //above code loads the jdbc driver
            
        }catch(Exception e){
            System.out.println("driver not loaded");
            
        }
        Connection con =null;
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_ticket","root","");
            //making connection with database named institute_management
            
        }catch(Exception f){
            System.out.println("connection object not created");
            
        }
       
  return con;  
  
      }                 
    
}
