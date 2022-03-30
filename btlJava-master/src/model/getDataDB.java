/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dell Inspiron 5515
 */
public class getDataDB {
    public static ArrayList getData(){
        Connection conn = null;
        Statement stmt  = null;
        
        try {
            conn = connectDB.connect();
            stmt = conn.createStatement();
            
            String sql = "select username from account"; // id tăng tự động nên ko thêm
     
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<String> data = new ArrayList<String>();
            while (rs.next()) {
                data.add(rs.getString("username"));
            }
            return data;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
   
}
