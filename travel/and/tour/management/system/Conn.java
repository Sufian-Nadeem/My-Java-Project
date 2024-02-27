package travel.and.tour.management.system;

import java.sql.*;


public class Conn {
    
    Connection c;
    Statement s;
    
    Conn(){
        try{
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///travelandtourmanagementsystem", "root", "Pakistan12345");
            s = c.createStatement();
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
    

    }
    
}
