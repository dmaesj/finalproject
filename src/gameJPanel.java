import javax.swing.*;

public class gameJPanel extends JPanel 
{
    private boolean gameStatePaused = false;
    private boolean sound, gameKill = false; // will need to be changed after options panel is added
    JButton bSpeed, bMode, bFlavor;
    int speed, flavors, mode;
    options gameOpt;
    gameSprite flavor1, flavor2, flavor3, flavor4, flavor5, cone;
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
        //updateButtonText();
        System.out.println("game constructed");
        setLayout(null);
        
        // starts game loops
        switch (mode) {
            case 1: { gameNormal(); break;}
            case 2: { gameMarathon(); break; }
            case 3: { gameSurvival(); break; }
        }
    }
    
    public void setGamePaused(boolean bool) {
        gameStatePaused = bool;
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

