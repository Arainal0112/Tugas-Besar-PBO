/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.*;

/**
 *
 * @author user
 */
public class DBHelper {
    private static Connection koneksi;
    public static void bukaKoneksi(){
        if(koneksi == null){
            try{
                String url = "jdbc:mysql://localhost:3306/dbrentalmobil"; //disesuaikan nama database
                String user = "root"; //untuk akses
                String password = ""; //untuk askes
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); //pengelola driver
                
//                Driver driver = new com.mysql.cj.jdbc.Driver(); // membuat objek
//                DriverManager.registerDriver(driver); 
                koneksi = DriverManager.getConnection(url,user,password);
            }
            catch(SQLException t){
                System.out.println("Error Koneksi!!");
            }
        }
    }
    public static int insertQueryGetId(String query){
        bukaKoneksi();
        int result = -1;
        try
        { 
            Statement stmt = koneksi.createStatement(); 
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);  
            ResultSet rs = stmt.getGeneratedKeys();  //

            if (rs.next()) 
            { 
                result = rs.getInt(1); //mengembalikan id 
            }
            rs.close();             
            stmt.close(); 
        }  
        catch (Exception e)  
        { 
            e.printStackTrace();
            result = -1; 
        }          
        return result; 
    }

    public static boolean executeQuery(String query){ 
        bukaKoneksi(); 
        boolean result = false; 
        try 
        { 
            Statement stmt = koneksi.createStatement();
            stmt.executeUpdate(query);

            result = true; 
             
            stmt.close(); 
        } 
        catch (Exception e) 
        { 
            e.printStackTrace(); 
        }          
        return result; 
    }      
    public static ResultSet selectQuery(String query){ 
        bukaKoneksi();         
        ResultSet rs = null; 
                 try 
        { 
            Statement stmt = koneksi.createStatement();
            rs = stmt.executeQuery(query); 
        } 
        catch (Exception e) 
        { 
            e.printStackTrace(); 
        }          
        return rs; 
    } 
    
}
