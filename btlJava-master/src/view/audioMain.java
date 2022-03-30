/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

/**
 *
 * @author Dell Inspiron 5515
 */
public class audioMain {
        public static Scanner scanner = new Scanner(System.in);
        public static File file  = new File("src\\view\\img\\audioMain.wav");
        public static AudioInputStream audioStream;
        public static Clip clip ;

    public  audioMain() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.audioStream = AudioSystem.getAudioInputStream(file);
        this.clip =  AudioSystem.getClip();
    }


        public void start() throws LineUnavailableException, IOException {
                clip.open(audioStream);
                this.clip.start();
                String response = scanner.next();
        }
    public void stop() throws LineUnavailableException, UnsupportedAudioFileException, IOException{
            clip.open(audioStream);
            clip.stop();
            String response = scanner.next();
    }
    
    
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioMain audi = new audioMain();
        audi.start();
    }
 }

