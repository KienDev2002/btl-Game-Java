/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.connectDB;

/**
 *
 * @author Dell Inspiron 5515
 */
public class getMarks {
    public static String getDB(String username){
        Connection conn = null;
        Statement stmt  = null;
        String data = null;
        try {
            conn = connectDB.connect();
            stmt = conn.createStatement();
            
            String sql = "select marks from account where username = '"+username+"'"; // id tăng tự động nên ko thêm
           
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                data = rs.getString("marks");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
     
        return data;
    }
    
    public static void main(String[] args) {
        getMarks get = new getMarks();
        System.out.println(get.getDB("ngo kien cntt2"));
    }
}
