
import javax.swing.*;

public class gameJPanel extends JPanel {

    private boolean gameStatePaused = false;
    private boolean gameKill = false;
    JButton bSpeed, bMode, bFlavor;
    options gameOpt;
    gameSprite flavor1, flavor2, flavor3, flavor4, flavor5, cone;
    public gameJPanel(options inOpt) {
        super();
        gameOpt = inOpt;
        bSpeed = new JButton();
        bFlavor = new JButton();
        bMode = new JButton();
        add(bSpeed);
        add(bFlavor);
        add(bMode);
        //updateButtonText();
        System.out.println("game constructed");
        setLayout(null);
        
        // starts game loops
        switch (gameOpt.mode) {
            case 1: { gameNormal(); break;}
            case 2: { gameMarathon(); break; }
            case 3: { gameSurvival(); break; }
        }
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
    
    //Normal Game Loop
    public void gameNormal() {
        int x = 500, y = 500;
        flavor2 = new gameSprite("images/gameP/flavor2.png");
        flavor1 = new gameSprite("images/gameP/flavor1.png");
        cone = new gameSprite("images/gameP/coneCut.png");
        add(flavor2);
        add(flavor1);
        add(cone);
        cone.setBounds(x, y, cone.getWidth(), cone.getHeight());
        flavor1.setBounds((x + cone.getHCenter() - flavor1.getHCenter()), y - flavor1.getHeight() + 30, flavor1.getWidth(), flavor1.getHeight());
        flavor2.setBounds((x + cone.getHCenter() - flavor2.getHCenter()), y - flavor1.getHeight() - flavor2.getHeight() + 150, flavor2.getWidth(), flavor2.getHeight());
    }
    
    //Marathon Game Loop
    public void gameMarathon() {
        
    }
    
    //Survival Game Loop
    public void gameSurvival() {
        
    }
}

