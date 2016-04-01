
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class gameJPanel extends JPanel implements MouseMotionListener, ActionListener {

    private boolean gameStatePaused = false;
    private boolean gameKill = false;
    
    options gameOpt;
    
    coneSprite cone;
    
    flavorSprite flavors;
    int flavorCount = 0, flavorDelay = 0, lives, score = 0, time = 0, 
            misses = 0, addSpeed = 0;
    double scoreMult = 1d;
    
    Timer gameCycle;
    
    JTextArea stats;
    
    int i;
    
    public gameJPanel(options inOpt) {
        super();
        gameOpt = inOpt;
        setLayout(null);
        addMouseMotionListener(this);
    }
    
        
    // starts game loops
    public void gameStart() {
        
        gameKill = false;
        stats = new JTextArea();
        stats.setBackground(Color.WHITE);
        stats.setBounds(0, 0, 300, 20);
        scoreMult = (gameOpt.speed * 1.5 + gameOpt.flavors * 1.5);
        cone = new coneSprite(180, 477);
        cone.setPosition(180, this.getHeight() - cone.getBounds().height);
        
                flavors = new flavorSprite(1,10, 10, false);
                flavors.setPosition(180, 100);
 

        add(flavors);
        flavors.startMoving(5);
        add(cone);
        add(stats);

        

        
        switch (gameOpt.mode) {
            case 1: {
                gameNormal();
                break;
            }
            case 2: {
                gameMarathon();
                time = 300;
                break;
            }
            case 3: {
                gameSurvival();
                break;
            }
        }
        gameCycle = new Timer(1000, this);
        gameCycle.start();
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

    // Quit current game
    public void gQuit() {
        this.removeAll();
        gameKill = true;
    }

    //Normal Game Loop
    public void gameNormal() { 
    // timer count up until level complete, match random order of scoops to finish level, base speed increases each level
    }

    //Marathon Game Loop
    public void gameMarathon() {
        // Timer countdown, unlimited lives, score based on scoops caught
    }

    //Survival Game Loop
    public void gameSurvival() {
        // No visible timer, score based on time alive, scoops caught, if a scoop is missed you lose
        // once scoops hit top, clear cones and continue, gets progressively faster
    }
    
    public String getTime() {
        String curTime;
        if (time >= 60) {
           curTime = Integer.toString(time / 60);
        }
        else {
            curTime = "00";
        }
        if (time % 60 < 10) {
            curTime += (":0" + time % 60);
        }
        else if (time % 60 >= 10) {
            curTime += (":" + time % 60);
        }
       return curTime;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (!gameKill && !gameStatePaused){

            if (obj == gameCycle) {
                System.out.println(i++);

                        
                    this.validate();
                    this.repaint();
                
                
                switch (gameOpt.mode) {
                    case 1: // Normal mode
                        time++;
                        stats.setText("Score: " + score + "     Elapsed Time: " + getTime());
                        break;
                    case 2: // Marathon mode
                        time--;
                        stats.setText("Score: " + score + "     Remaining Time: " + getTime());
                        break;
                    case 3: // Survival mode
                        time++;
                        stats.setText("Score: " + score + "     Elapsed Time: --:--");
                        //Increases speed every 5 seconds for marathon mode
                        if (time % 5 == 0) {
                            addSpeed++;
                        }   
                        break;
                }
            }
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent evt)
    {
    	Point pt = evt.getPoint();
        cone.move((int)pt.getX());
    }
    @Override
    public void mouseDragged(MouseEvent evt)
    {
    	Point pt = evt.getPoint();
        cone.move((int)pt.getX());
    }
}
