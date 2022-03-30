/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Dell Inspiron 5515
 */
public class insertDB {
     public static void insert(String username){
        Connection conn = null;
        Statement stmt  = null;
        
        try {
            conn = connectDB.connect();
            stmt = conn.createStatement();
            
            String sql = "insert into account (username) values('"+username+"')"; // id tăng tự động nên ko thêm
     
            stmt.executeUpdate(sql);
            System.out.println("Insert success!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
     

}
