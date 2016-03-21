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
        bSave.addActionListener(this);
        bDiscard.addActionListener(this);
        
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
                 // reset visible
                bPause.setVisible(false);
                bSound.setVisible(false);
                bGiveUp.setVisible(false);
                bSave.setVisible(false);
                bPlay.setVisible(false);
                bReturn.setVisible(false);
                bDiscard.setVisible(false);
                
        switch (inStatus) {
            case 1: { // Status 1: Active game panel

                bSound.setAltImage(gameP.isMuted());
                bSound.setVisible(true);
                
                bPause.setVisible(true);
                bGiveUp.setVisible(true);
                break;
            }
            case 2: { // Status 2: Active options panel
                bReturn.setVisible(true);
                bDiscard.setVisible(true);
                bPlay.setVisible(true);
                bSave.setVisible(true);
                break;
            }
            case 3: { // Status 3: Placehoder for other panels
                bReturn.setVisible(true);
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
        boolean bool;
        // Toggles pause status
        if (obj == bPause) {
            
            bool = (!(gameP.getGameState()));

                bPause.setAltImage(bool);
                gameP.setGamePaused(bool);
        }
        // Toggles mute
        if (obj == bSound) {
            bool = (!(gameP.isMuted()));
            
            optionsP.setMuted(bool);
            bSound.setAltImage(bool);
            gameP.setMuted(bool);

        }
        // Save optionsP options to gameP
        if (obj == bSave) {
            optionsP.setAll();
            gameP.setOptions(optionsP.speed, optionsP.flavors, optionsP.mode);
            optionsP.saved.setVisible(true);
            
        }
    }
}
