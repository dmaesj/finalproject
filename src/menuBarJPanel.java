import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBarJPanel extends JPanel implements ActionListener
{   
    imageButton bReturn, bPause, bGiveUp, bSound;
    JButton bPlay, bSave;
    gameJPanel gameP;
    public menuBarJPanel (gameJPanel inGame)
    { 
        super();
        setBackground(Color.LIGHT_GRAY);
        // Pass gameP by reference for pause functionality;
        gameP = inGame;
        
        //Initialize buttons
        bReturn = new imageButton("images/mBarP/iMenu.png");
        bPause = new imageButton("images/mBarP/iPause.png", "images/mBarP/iResume.png");
        bGiveUp = new imageButton("images/mBarP/iGiveUp.png");
        bSound = new imageButton("images/mBarP/iSoundOn.png", "images/mBarP/iSoundOff.png");
        bSave = new JButton();
        bPlay = new JButton();
        
        //Add listeners
        bPause.addActionListener(this);
        bSound.addActionListener(this);
        
        //Add standard buttons
        add(bReturn);
        
        
    }
    
    // Display panel specific buttons
    public void setGameStatus(int gStatus) {
        if (gStatus == 1) {
            add(bPause);
            if (gameP.isMuted()) {
                bSound.setAltImage(true);
            }
            add(bSound);
            add(bGiveUp);
        }
        else if (gStatus != 1) {
            bPause.setVisible(false);
            bSound.setVisible(false);
            bGiveUp.setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        // Toggles pause status
        if (obj == bPause) {
            if (!gameP.getGameState()){
                //add code to pause game
                bPause.setAltImage(true);
                gameP.setGamePaused(true);
            }
            else {
                //add code to resume game
                bPause.setAltImage(false);
                gameP.setGamePaused(false);
            }
        }
        // Toggles mute
        if (obj == bSound) {
             if (gameP.isMuted()){
                bSound.setAltImage(false);
                gameP.setMuted(false);
            }
            else {
                bSound.setAltImage(true);
                gameP.setMuted(true);
            }
        }
    }
}
