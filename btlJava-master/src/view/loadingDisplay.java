/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.getMarks;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import static view.audioMain.audioStream;
import static view.audioMain.clip;

/**
 *
 * @author Dell Inspiron 5515
 */
public class loadingDisplay extends JFrame implements ActionListener  {
    
    public JButton btnstart = new JButton();
    public JButton btnBack = new JButton();
    private JLabel mainImg = new JLabel();
    private JLabel jLabel3 = new JLabel();
    public JProgressBar loadingBar = new JProgressBar();
    public  JLabel loadingLabel = new JLabel();
    public  JLabel loadingValue = new JLabel();
    public JLabel yourMarks = new JLabel();
    public JLabel labelMark = new JLabel();
    public JTextField txtMark = new JTextField();
           
    public loadingDisplay() throws InterruptedException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new AbsoluteLayout());


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        yourMarks.setFont(new java.awt.Font("Harrington", 1, 36)); // NOI18N
        yourMarks.setForeground(new java.awt.Color(255, 51, 51));
        
        yourMarks.setText("000");
        getContentPane().add(yourMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 280, 98, 56));

        labelMark.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        labelMark.setForeground(new java.awt.Color(255, 255, 255));
        labelMark.setText("YOUR MARKS");
        getContentPane().add(labelMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 238, 168, -1));

        txtMark.setBackground(new java.awt.Color(102, 255, 102));
        txtMark.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        txtMark.setForeground(new java.awt.Color(255, 255, 255));
        txtMark.addActionListener(this);
        getContentPane().add(txtMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 280, 126, 56));

        btnBack.setBackground(new java.awt.Color(102, 255, 102));
        btnBack.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(this);
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 28, -1, -1));

        btnstart.setBackground(new java.awt.Color(102, 255, 102));
        btnstart.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        btnstart.setForeground(new java.awt.Color(255, 255, 255));
        btnstart.setText("START");
        btnstart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnstart.addActionListener(this);
        getContentPane().add(btnstart, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 532, 112, 42));

        loadingLabel.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        loadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        loadingLabel.setText("Loading...");
        getContentPane().add(loadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 546, -1, -1));

        jLabel3.setFont(new java.awt.Font("Harrington", 3, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SPACE SHIP");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 28, 336, 70));

        loadingBar.setForeground(new java.awt.Color(255, 153, 153));
        getContentPane().add(loadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-14, 588, 812, 14));

   
        
        mainImg.setIcon(new ImageIcon(getClass().getResource("/view/img/loading_c.gif"))); 
        getContentPane().add(mainImg, new AbsoluteConstraints(0, 0, 798, 600));
        pack();
        setLocationRelativeTo(null);
        
        
    }
    public void actionPerformed(ActionEvent evt) {
        
        if (evt.getSource() == btnstart) {
            clip.stop();
            BoatApplication boat = new BoatApplication();
            boat.main();
            
           
            this.setVisible(false);
        }else if(evt.getSource()==btnBack){
            login log = new login();
            log.setVisible(true);
            this.setVisible(false);
        }
    }
 
      
    public JLabel getMainImg() {
        return mainImg;
    }

    public void setMainImg(JLabel mainImg) {
        this.mainImg = mainImg;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JProgressBar getLoadingBar() {
        return loadingBar;
    }

    public void setLoadingBar(JProgressBar loadingBar) {
        this.loadingBar = loadingBar;
    }

    public JLabel getLoadingLabel() {
        return loadingLabel;
    }

    public void setLoadingLabel(JLabel loadingLabel) {
        this.loadingLabel = loadingLabel;
    }

    public JLabel getLoadingValue() {
        return loadingValue;
    }

    public void setLoadingValue(JLabel loadingValue) {
        this.loadingValue = loadingValue;
    }
  
    public static void main(String args[]) throws InterruptedException {
        loadingDisplay load = new loadingDisplay();
        load.setVisible(true);
        
    } 
   
}
