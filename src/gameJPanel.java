
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class gameJPanel extends JPanel implements ActionListener {

    Point mouseLoc;
    private boolean gameStatePaused = false;
    private boolean gameKill = false;
    String[] flavorIcons = {"images/gameP/flavor1.png",
        "images/gameP/flavor2.png",
        "images/gameP/flavor3.png",
        "images/gameP/flavor4.png",
        "images/gameP/flavor5.png"};
    JButton bSpeed, bMode, bFlavor;
    options gameOpt;
    coneSprite cone;
    flavorSprite[] flavors;
    int flavorCount = 0, flavorDelay = 200, lives, score = 0, time = 0, 
            misses = 0, addSpeed = 0;
    double scoreMult = 1d;
    Timer mouseCycle, gameCycle;
    JTextArea stats;
    public gameJPanel(options inOpt) {
        super();
        gameOpt = inOpt;
        setLayout(null);
        mouseLoc = MouseInfo.getPointerInfo().getLocation();
        flavors = new flavorSprite[15];
        stats = new JTextArea();
        stats.setBackground(Color.WHITE);
    }

    // starts game loops
    public void gameStart() {
        scoreMult = (gameOpt.speed * 1.5 + gameOpt.flavors * 1.5);
        mouseLoc = MouseInfo.getPointerInfo().getLocation();
        cone = new coneSprite("images/gameP/coneCut.png");
        add(cone);
        stats.setBounds(0, 0, 300, 20);
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
        mouseCycle = new Timer(10, this);
        mouseCycle.start();
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
    
    public void update() {
        cone.update();
        for (int i = 0; i < flavorCount; i++) {
            flavors[i].update();
        }
        flavorDelay--;
        if (flavorDelay == 0 && flavorCount < 14) {
            int flavor = (int) Math.round(Math.random() * (gameOpt.flavors - 1));
            flavors[flavorCount] = new flavorSprite(flavorIcons[flavor], gameOpt.muted);
            flavors[flavorCount].speed += (gameOpt.speed * 2) + addSpeed;
            System.out.println(flavors[flavorCount].speed + "");
            add(flavors[flavorCount]);
            flavorCount++;
            flavorDelay = 200;
        }
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
            if (obj == mouseCycle) {
                    update();
            }
            if (obj == gameCycle) {
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
}
