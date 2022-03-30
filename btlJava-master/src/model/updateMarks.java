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
public class updateMarks {
        public void update(String username , int marks){
            Connection conn = null;
            Statement stmt  = null;

            try {
                conn = connectDB.connect();
                stmt = conn.createStatement();



                String sqlUpdate = "update account set marks = '"+marks+"' where username = '"+username+"'";
                stmt.executeUpdate(sqlUpdate);

                System.out.println("Update success!");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        public static void main(String[] args) {
            updateMarks up = new updateMarks();
            String s = "ngo kien cntt2";
            int x = 220;
            up.update(s, x);
        }
    }

