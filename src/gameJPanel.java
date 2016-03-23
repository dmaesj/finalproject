import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameJPanel extends JPanel
{
    private boolean gameStatePaused = false;
    private boolean sound, gameKill = false; // will need to be changed after options panel is added
    JButton bSpeed, bMode, bFlavor;
    int speed, flavors, mode;
    options gameOpt;
    
    public gameJPanel (options inOpt)
    {   
        super();
        gameOpt = inOpt;
        setGameOptions();
        bSpeed = new JButton();
        bFlavor = new JButton();
        bMode = new JButton();
        add(bSpeed);
        add(bFlavor);
        add(bMode);
        updateButtonText();
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
    // Returns whether or not game is muted
    public boolean isMuted() {
        return !sound;
    }
    // Set game options
    public void setGameOptions() {
        gameOpt.getOptions();
        speed = gameOpt.getSpeed();
        flavors = gameOpt.getFlavor();
        mode = gameOpt.getMode();
        sound = gameOpt.getSound();
    }
    public void updateButtonText() {
        bSpeed.setText("Speed: " + speed);
        bFlavor.setText("Flavors: " + flavors);
        bMode.setText("Mode: " + mode);
    }
    // Quit current game
    public void gQuit() {
        gameKill = true;
    }
}
