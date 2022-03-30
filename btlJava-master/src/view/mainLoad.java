/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.JFrame;

/**
 *
 * @author Dell Inspiron 5515
 */
public class mainLoad extends JFrame{
    public void run() throws InterruptedException{
        loadingDisplay load = new loadingDisplay();
        load.setVisible(true);
//        view.Main_Interface_1 main = new Main_Interface_1();
//        main.setVisible(false);
        BoatApplication boat = new BoatApplication();
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(50);
                load.loadingValue.setText(i+"%");
                
                if(i==30){
                    load.loadingLabel.setText("Connecting to Database");
                }
                
                if(i==60){
                    load.loadingLabel.setText("Connection success !");
                }
                        
                if(i==90){
                    load.loadingLabel.setText("Loading...");
                }
                load.loadingBar.setValue(i);
//                if(i==99){
//                    load.setVisible(false);
//                    boat.main();
//                    
//                }
            }
            
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        mainLoad main = new mainLoad();
        main.run();
    }
}
