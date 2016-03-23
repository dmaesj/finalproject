import javax.swing.*;
import java.awt.*;


public class menuBarJPanel extends JPanel
{   
    imageButton bReturn, bPause, bGiveUp, bSound, bPlay, bSave, bDiscard;
    options gameOpt;
    public menuBarJPanel (options inOpt)
    { 
        super();
        setBackground(Color.LIGHT_GRAY);
        gameOpt = inOpt;
        //Initialize buttons
        bReturn = new imageButton("images/mBarP/iMenu.png");
        bPause = new imageButton("images/mBarP/iPause.png", "images/mBarP/iResume.png");
        bGiveUp = new imageButton("images/mBarP/iGiveUp.png");
        bSound = new imageButton("images/mBarP/iSoundOn.png", "images/mBarP/iSoundOff.png");
        bSave = new imageButton("images/mBarP/iSave.png");
        bPlay = new imageButton("images/mBarP/iPlay.png");
        bDiscard = new imageButton("images/mBarP/iDiscard.png");
        

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

                bSound.setAltImage(!gameOpt.getSound());
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
}