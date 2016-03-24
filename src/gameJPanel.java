
import javax.swing.*;

public class gameJPanel extends JPanel {

    private boolean gameStatePaused = false;
    private boolean gameKill = false;
    JButton bSpeed, bMode, bFlavor;
    options gameOpt;

    public gameJPanel(options inOpt) {
        super();
        gameOpt = inOpt;
        bSpeed = new JButton();
        bFlavor = new JButton();
        bMode = new JButton();
        add(bSpeed);
        add(bFlavor);
        add(bMode);
        updateButtonText();
        System.out.println("game constructed");
    }

    public void setGamePaused() {
        gameStatePaused = !gameStatePaused;
    }

    public void setGamePaused(boolean bool) {
        gameStatePaused = bool;
    }

    // Return whether or not game loop is paused
    public boolean getGameState() {
        return gameStatePaused;
    }

    public void updateButtonText() {
        bSpeed.setText("Speed: " + gameOpt.speed);
        bFlavor.setText("Flavors: " + gameOpt.flavors);
        bMode.setText("Mode: " + gameOpt.mode);
    }

    // Quit current game
    public void gQuit() {
        gameKill = true;
    }
}
