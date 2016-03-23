
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class myJPanel extends JPanel implements ActionListener {

    instJPanel instP;
    scoresJPanel scoresP;
    creditsJPanel creditsP;
    optionsJPanel optionsP;
    gameJPanel gameP;
    menuJPanel menuP;
    menuBarJPanel mBarP;
    options gameOptions;
    JLabel sizeLabel;

    public myJPanel() {
        super();
        setLayout(new BorderLayout());
        //Initialize Options
        gameOptions = new options();
        gameOptions.getOptions();
        
    //Initialize Panels        
        instP = new instJPanel();
        scoresP = new scoresJPanel();
        creditsP = new creditsJPanel();
        optionsP = new optionsJPanel(gameOptions);
        gameP = new gameJPanel(gameOptions);
        menuP = new menuJPanel();
        mBarP = new menuBarJPanel(gameOptions);
        

        
        //Add Listeners
        menuP.bGame.addActionListener(this);
        menuP.bOptions.addActionListener(this);
        menuP.bInst.addActionListener(this);
        menuP.bScores.addActionListener(this);
        menuP.bCredits.addActionListener(this);

        mBarP.bGiveUp.addActionListener(this);
        mBarP.bReturn.addActionListener(this);
        mBarP.bPlay.addActionListener(this);
        mBarP.bPause.addActionListener(this);
        mBarP.bSound.addActionListener(this);
        mBarP.bSave.addActionListener(this);
        mBarP.bDiscard.addActionListener(this);
 
        optionsP.bSound.addActionListener(this);
        
        //Add panels
        switchPanel("menu");
    }

    public void switchPanel(String state) {

        if (state.equals("menu")) {
            add(menuP, "Center");
        } else {
            remove(menuP);
        }
        if (!state.equals("menu")) {
            add(mBarP, "North");
        } else {
            remove(mBarP);
        }
        if (state.equals("game")) {
            add(gameP, "Center");
        } else {
            remove(gameP);
        }
        if (state.equals("instructions")) {
            add(instP, "Center");
        } else {
            remove(instP);
        }
        if (state.equals("scores")) {
            add(scoresP, "Center");
        } else {
            remove(scoresP);
        }
        if (state.equals("credits")) {
            add(creditsP, "Center");
        } else {
            remove(creditsP);
        }
        if (state.equals("options")) {
            add(optionsP, "Center");
        } else {
            remove(optionsP);
        }

        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();

        if (obj == mBarP.bReturn) {
            switchPanel("menu");
        }

        if (obj == menuP.bInst) {
            switchPanel("instructions");
            mBarP.setVisButtons(3);
        }

        if (obj == menuP.bCredits) {
            switchPanel("credits");
            mBarP.setVisButtons(3);
        }

        if (obj == menuP.bScores) {
            switchPanel("scores");
            mBarP.setVisButtons(3);

        }

        if (obj == mBarP.bGiveUp) {
            gameP.gQuit();
            switchPanel("menu");
        }
        
        if (obj == menuP.bOptions){
           
           mBarP.setVisButtons(2);
           optionsP.saved.setVisible(false);
           switchPanel("options");
        }
        
        if (obj == mBarP.bDiscard) {
            switchPanel("menu");
            gameOptions.restoreDefaults();
            gameOptions.getOptions();
            optionsP.setOptionScreen();
        }
        
        if (obj == mBarP.bPlay || obj == menuP.bGame){
           switchPanel("game");
           mBarP.setVisButtons(1);
           gameP.setGameOptions();
           gameP.updateButtonText();

        }
        
        boolean bool;
        // Toggles pause status
        if (obj == mBarP.bPause) {
            
            bool = (!(gameP.getGameState()));

            mBarP.bPause.setAltImage(bool);
            gameP.setGamePaused(bool);
        }
        // Toggles mute
        if (obj == mBarP.bSound) {
            bool = (!(gameP.isMuted()));
            
            optionsP.setMuted();
            mBarP.bSound.setAltImage(bool);

        }
        // Save optionsP options to gameP
        if (obj == mBarP.bSave) {
            optionsP.setAll();
            gameOptions.storeOptions();
            optionsP.saved.setVisible(true);
        }
        
        if (obj == optionsP.bSound) {
            optionsP.bSound.setAltImage(!optionsP.bSound.getAltState());
        }
        
    }
}
