//File connect database
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
     // khai báo các tham số kết nối
    static  final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/quanlyusername";
    static final String USER = "root";
    static final String PASS = "";
    
    
    public static Connection connect() throws SQLException, ClassNotFoundException{
        Connection conn = null; // khai báo đối tượng kết nối
        try{
            // lớp driver là lớp trình điều khieern csdl
            Class.forName(DRIVER_CLASS); // nạp driver của mysql vào để sử dụng
       
            //thực hiện kết nối đến db
            conn =DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connect ok");
        } catch (ClassNotFoundException ex) {
            System.out.println("Not found driver.Detail: " + ex.getMessage());
        } catch(SQLException ex){
            System.out.println("Not Connection to mySQL. Detail" + ex.getMessage());
        }
        
        // trả về kết nối
        return conn;
    }
    

}
