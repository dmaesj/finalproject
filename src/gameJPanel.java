import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameJPanel extends JPanel
{
    private boolean gameStatePaused = false;
    private boolean soundMuted = false, gameKill = false; // will need to be changed after options panel is added
    JButton bTemp1, bTemp2, bTemp3;
    int speed = 2, flavors = 3, mode = 1;
    public gameJPanel ()
    {   
        super();
        bTemp1 = new JButton("Speed: " + speed);
        bTemp2 = new JButton("Flavors: " + flavors);
        bTemp3 = new JButton("Mode: " + mode);
        add(bTemp1);
        add(bTemp2);
        add(bTemp3);
        System.out.println("game constructed");
    }
    // Pauses or resumes game loop
    public void setGamePaused(boolean ispaused) {
        gameStatePaused = ispaused;
    }
    // Return whether or not game loop is paused
    public boolean getGameState() {
        return gameStatePaused;
    }
    // Mutes and unmutes sound effects
    public void setMuted(boolean muted) {
        soundMuted = muted;
    }
    // Returns whether or not game is muted
    public boolean isMuted() {
        return soundMuted;
    }
    // Set game options
    public void setOptions(int inSpeed, int inFlavors, int inMode) {
        speed = inSpeed;
        flavors = inFlavors;
        mode = inMode;
        bTemp1.setText("Speed: " + speed);
        bTemp2.setText("Flavors: " + flavors);
        bTemp3.setText("Mode: " + mode);
    }
    // Quit current game
    public void gQuit() {
        gameKill = true;
    }
}
