/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.getDataDB;
import view.mainLoad;

/**
 *
 * @author Dell Inspiron 5515
 */
public class checkLogin {
    public static int check(String user){
            getDataDB get = new getDataDB();
            ArrayList<String> data = new ArrayList<String>();
            data = get.getData();
            int check = 0;
            for (String string : data) {
                if(user.equals(string)){
                    return 1;
                }
            }
            return 0;
    }
}
