
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
        bReturn = new imageButton("images/mBarP/iMenu.png",
                "images/mBarP/iMenuP.png");
        bPause = new imageButton("images/mBarP/iPause.png",
                "images/mBarP/iPauseP.png",
                "images/mBarP/iResume.png",
                "images/mBarP/iResumeP.png");
        bGiveUp = new imageButton("images/mBarP/iGiveUp.png",
                "images/mBarP/iGiveUpP.png");
        bSound = new imageButton("images/mBarP/iSoundOn.png",
                "images/mBarP/iSoundOnP.png",
                "images/mBarP/iSoundOff.png",
                "images/mBarP/iSoundOffP.png");
        bPlay = new imageButton("images/mBarP/iPlay.png",
                "images/mBarP/iPlayP.png");
        bDiscard = new imageButton("images/mBarP/iDiscard.png");
        bSave = new imageButton("images/mBarP/iSave.png");
        


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
        bPlay.setVisible(false);
        bReturn.setVisible(false);
        bSave.setVisible(false);
        bDiscard.setVisible(false);

        switch (inStatus) {
        case 1: {
                bSound.setAltImage(!gameOpt.getSound());
                bSound.setVisible(true);

                bPause.setVisible(true);
                bGiveUp.setVisible(true);
                break;
            }
                
            case 2: { // Status 2: Active options panel
                bReturn.setVisible(true);
                bDiscard.setVisible(true);
                bSave.setVisible(true);
                bPlay.setVisible(true);
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
    }

    public void setPaused() {
        bPause.doClick();
    }

    public void setPaused(boolean isPaused) {
        bPause.setAltImage(isPaused);
    }

    //public boolean getPaused() {
    //    return paused;
    //}

    public void setMuted() {
        bSound.doClick();
    }

    public void setMuted(boolean muted) {
        bSound.setAltImage(!bSound.getAltState());
    }
}
