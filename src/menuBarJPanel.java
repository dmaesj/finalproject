
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBarJPanel extends JPanel implements ActionListener {

    imageButton bReturn, bPause, bGiveUp, bSound, bPlay;
    myJPanel mainPanel;

    public menuBarJPanel() {
        super();
        setBackground(Color.LIGHT_GRAY);
        mainPanel = (myJPanel) SwingUtilities.getRoot(this);
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

        //Add listeners
        bPause.addActionListener(this);
        bSound.addActionListener(this);

        //Add standard buttons
        add(bReturn);
        add(bPause);
        add(bSound);
        add(bGiveUp);
        add(bPlay);

    }

    // Display panel specific buttons
    public void setVisButtons(int inStatus) {
        // reset visible
        bPause.setVisible(false);
        bSound.setVisible(false);
        bGiveUp.setVisible(false);
        bPlay.setVisible(false);
        bReturn.setVisible(false);

        switch (inStatus) {
            case app.GAMEPANEL: { // Status 1: Active game panel
                setPaused(app.paused);
                setMuted(app.muted);
                bSound.setVisible(true);

                bPause.setVisible(true);
                bGiveUp.setVisible(true);
                break;
            }
            case app.OPTIONSPANEL: { // Status 2: Active options panel
                bReturn.setVisible(true);
                bPlay.setVisible(true);
                break;
            }
            case app.OTHERPANEL: { // Status 3: Placehoder for other panels
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
        app.paused = isPaused;
        bPause.setAltImage(isPaused);
    }

    public boolean getPaused() {
        return app.paused;
    }

    public void setMuted() {
        bSound.doClick();
    }

    public void setMuted(boolean muted) {
        app.muted = muted;
        bSound.setAltImage(app.muted);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        // Toggles pause status
        if (obj == bPause) {
            app.paused = !app.paused;
            bPause.setAltImage();
        }
        // Toggles mute
        if (obj == bSound) {
            app.muted = !app.muted;
            bSound.setAltImage();
        }
    }
}
