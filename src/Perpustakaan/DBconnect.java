package Perpustakaan;

import java.sql.*;

public class DBconnect {

    public static Connection getConnection(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_perpustakaan", "root","");
            
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    
}
