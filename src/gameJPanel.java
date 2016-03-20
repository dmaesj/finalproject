import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameJPanel extends JPanel
{
    private boolean gameStatePaused = false;
    private boolean soundMuted = false; // will need to be changed after options panel is added
    JButton bTemp;
    public gameJPanel ()
    {   
        super();
        bTemp = new JButton();
        bTemp.setText("Game Panel");
        add(bTemp);
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
}
