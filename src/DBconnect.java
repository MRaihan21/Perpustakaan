package Perpustakaan;

import java.sql.*;

public class DBconnect {

    public static Connection getConnection(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dblogin", "root","");
            
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
}

//Connection con = null;
//
//    public DBconnect() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dblogin","root ", "");                        
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//
//    public Connection getConn(){
//        return con;
//    }