import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBarJPanel extends JPanel implements ActionListener
{   
    imageButton bReturn, bPause, bGiveUp, bSound, bPlay, bSave, bDiscard;
    gameJPanel gameP;
    optionsJPanel optionsP;
    public menuBarJPanel (gameJPanel inGame, optionsJPanel inOptions)
    { 
        super();
        setBackground(Color.LIGHT_GRAY);
        // Pass gameP by reference for pause functionality;
        gameP = inGame;
        optionsP = inOptions;
        
        //Initialize buttons
        bReturn = new imageButton("images/mBarP/iMenu.png");
        bPause = new imageButton("images/mBarP/iPause.png", "images/mBarP/iResume.png");
        bGiveUp = new imageButton("images/mBarP/iGiveUp.png");
        bSound = new imageButton("images/mBarP/iSoundOn.png", "images/mBarP/iSoundOff.png");
        bSave = new imageButton("images/mBarP/iSave.png");
        bPlay = new imageButton("images/mBarP/iPlay.png");
        bDiscard = new imageButton("images/mBarP/iDiscard.png");
        
        //Add listeners
        bPause.addActionListener(this);
        bSound.addActionListener(this);
        
        //Add standard buttons
        add(bReturn);
        add(bPause);
        add(bSound);
        add(bGiveUp);
        add(bDiscard);
        add(bPlay);
        add(bSave);
        
        
    }
    
    // Display panel specific buttons
    public void setVisButtons(int inStatus) {
        switch (inStatus) {
            case 0: { // Status 0: plain menu bar or reset
                bPause.setVisible(false);
                bSound.setVisible(false);
                bGiveUp.setVisible(false);
                bSave.setVisible(false);
                bPlay.setVisible(false);
                bReturn.setVisible(true);
                bDiscard.setVisible(false);
                break;
            }
            case 1: { // Status 1: Active game panel
                bSave.setVisible(false);
                bPlay.setVisible(false);
                bReturn.setVisible(false);
                bDiscard.setVisible(false);
                if (gameP.isMuted()) {
                    bSound.setAltImage(true);
                }
                else {
                    bSound.setAltImage(false);
                }
                bSound.setVisible(true);
                bPause.setVisible(true);
                bGiveUp.setVisible(true);
                break;
            }
            case 2: { // Active options panel
                bPlay.setVisible(false);
                bReturn.setVisible(false);
                bSound.setVisible(false);
                bPause.setVisible(false);
                bGiveUp.setVisible(false);
                
                bDiscard.setVisible(true);
                bPlay.setVisible(true);
                bSave.setVisible(true);
                break;
            }
            default: {
                System.out.println("no supported default");
                break;
            }
        }
        
        
        if (inStatus == 1) {
            
        }
        else if (inStatus != 1) {
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
                optionsP.setMuted(false);
                bSound.setAltImage(false);
                gameP.setMuted(false);
            }
            else {
                bSound.setAltImage(true);
                optionsP.setMuted(true);
                gameP.setMuted(true);
            }
        }
    }
}
