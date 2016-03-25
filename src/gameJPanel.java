import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gameJPanel extends JPanel implements MouseMotionListener , ActionListener {
    Point mouseLoc;
    private boolean gameStatePaused = false;
    private boolean gameKill = false;
    JButton bSpeed, bMode, bFlavor;
    options gameOpt;
    gameSprite flavor1, flavor2, flavor3, flavor4, flavor5, cone;
    int panelHeight = 0, panelWidth = 0;
    int coneX = 500, coneY = 500;
    Timer mouseCycle;                                                                                                                                                                                                                                                                                 
    public gameJPanel(options inOpt) {
        super();
        mouseLoc = new Point(250,500);
        gameOpt = inOpt;
        setLayout(null); 
    }
    
    // starts game loops
    public void gameStart() {
        switch (gameOpt.mode) {
            case 1: { gameNormal(); break;}
            case 2: { gameMarathon(); break; }
            case 3: { gameSurvival(); break; }
        }
        mouseCycle = new Timer(10, this);
        mouseCycle.start();
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
        addMouseMotionListener(this);
        flavor2 = new gameSprite("images/gameP/flavor2.png");
        flavor1 = new gameSprite("images/gameP/flavor1.png");
        cone = new gameSprite("images/gameP/coneCut.png");
        //coneX = (int)(panelWidth / 2) - cone.getXCenter();
        //coneY = panelHeight - cone.getHeight();
        add(flavor2);
        add(flavor1);
        add(cone);
        cone.setBounds(coneX, coneY, cone.getWidth(), cone.getHeight());
        flavor1.setBounds((coneX + cone.getYCenter() - flavor1.getXCenter()), coneY - flavor1.getHeight() + 30, flavor1.getWidth(), flavor1.getHeight());
        flavor2.setBounds((coneX + cone.getYCenter() - flavor2.getXCenter()), coneY - flavor1.getHeight() - flavor2.getHeight() + 150, flavor2.getWidth(), flavor2.getHeight());
        if (cone.getX() != mouseLoc.getX()) {
            moveCone();
        }
    }
    
    public void moveCone() {
        //Fine tuned adjustments
        if (cone.getXCenterLoc() <= (int)mouseLoc.getX() + 10 && (int)mouseLoc.getX() - 10 <= cone.getXCenterLoc()) {
            if (cone.getXCenterLoc() + 10 > (int)mouseLoc.getX()) {
                cone.setBounds(coneX-=(10 - (int)(mouseLoc.getX() - cone.getXCenterLoc())), coneY, cone.getWidth(), cone.getHeight());
            }
            else if ((int)mouseLoc.getX() - 10 > cone.getXCenterLoc()) {
                    cone.setBounds(coneX+=(10 - (int)(mouseLoc.getX() - cone.getXCenterLoc())), coneY, cone.getWidth(), cone.getHeight());
            }
        }
        //Gross adjustments
        else if (cone.getXCenterLoc() > mouseLoc.getX()) {
            cone.setBounds((coneX-=10), coneY, cone.getWidth(), cone.getHeight());
        }
        else if (cone.getXCenterLoc() < mouseLoc.getX()) {
            cone.setBounds((coneX+=10), coneY, cone.getWidth(), cone.getHeight()); 
        } 
    }
    
    //Marathon Game Loop
    public void gameMarathon() {
        
    }
    
    //Survival Game Loop
    public void gameSurvival() {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        mouseLoc = event.getPoint();
        moveCone();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj == mouseCycle) {
            moveCone();     
        }
    }
}

