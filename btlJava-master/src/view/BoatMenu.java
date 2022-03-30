//File tạo giao diện bắt đầu và kết thúc game
package view;

import controller.BoatComponent;
import view.WallComponent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.Constants;
import model.Constants;
import model.ImageUtils;
import model.UrlConstants;
import model.UrlConstants;
import model.updateMarks;

public class BoatMenu extends Component implements ActionListener {
    private static final long serialVersionUID = 1L;
    private static final int PROGRESS = 5;
    private Image readyImage;
    private Image gameOverImage;
    private Timer timer;
    private int progress;
    private boolean ready;

    public BoatMenu() {
        super();
        this.readyImage = ImageUtils.generateImageFromUrl(UrlConstants.READY_IMAGE_URL);
        timer = new Timer(Constants.READY_TIME_DELAY, this);
        ready = false;
        progress = PROGRESS;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean isReady) {
        this.ready = isReady;
    }

    public void active() {
        timer.start();
    }

    public void gameOver(Graphics g, int score, WallComponent wallComponent, String urlImage) {
        this.gameOverImage = ImageUtils.generateImageFromUrl(urlImage);
        String playAgain = Constants.PLAY_AGAIN_MESSAGE;
        Font font = new Font("Helvetica", Font.BOLD, 120);
        Font font2 = new Font("Helvetica", Font.CENTER_BASELINE, 18);
        FontMetrics metr = getFontMetrics(font);
        FontMetrics metr2 = getFontMetrics(font2);
        g.setColor(Color.yellow);
        g.setFont(font);
        g.drawImage(this.gameOverImage, (Constants.BOARD_WITH - Constants.READY_LENGTH)/2, Constants.BOARD_HEIGHT / 2 -30, this.getParent());
        g.drawString(String.valueOf(score), (Constants.BOARD_WITH - metr.stringWidth(String.valueOf(score))) / 2,
                Constants.BOARD_HEIGHT / 2 - 110);
        g.setColor(Color.white);
        g.setFont(font2);
        g.drawString(playAgain, (Constants.BOARD_WITH - metr2.stringWidth(playAgain)) / 2,
                Constants.BOARD_HEIGHT - 60);
        wallComponent.draw(g);
        //Sound
        try {
            File f = new File("res/sounds/gameOver.wav");
            AudioInputStream audio = AudioSystem.getAudioInputStream(f);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Sound is not exsist!");
        }
        
        updateMarks update = new updateMarks();
        login log= new login();

        
        update.update(log.user, score);
    }

    public void drawStartGame(Graphics g, WallComponent wallComponent, BoatComponent boatComponent) {
        if(this.progress > 0) {
            g.drawImage(this.readyImage, (Constants.BOARD_WITH - Constants.READY_LENGTH)/2, Constants.BOARD_HEIGHT / 2 -30, this.getParent());
            wallComponent.draw(g);
            boatComponent.draw(g);
            progress --;
        } else {
            this.setReady(true);
            timer.stop();
            this.getParent().repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.getParent().repaint();
    }
}
