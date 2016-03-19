import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainJPanel extends JPanel implements ActionListener
{
    instJPanel instP;
    scoresJPanel scoresP;
    creditsJPanel creditsP;
    optionsJPanel optionsP;
    gameJPanel gameP;
    menuJPanel menuP;
    menuBarJPanel mBarP;
    public mainJPanel ()
    {
        super();
        setLayout(new BorderLayout());
        
        //Initialize Panels
        
        instP = new instJPanel();
        scoresP = new scoresJPanel();
        creditsP = new creditsJPanel();
        optionsP = new optionsJPanel();
        gameP = new gameJPanel();
        menuP = new menuJPanel();
        mBarP = new menuBarJPanel(gameP);
        
        //Add Listeners
        menuP.bGame.addActionListener(this);
        menuP.bOptions.addActionListener(this);
        menuP.bInst.addActionListener(this);
        menuP.bScores.addActionListener(this);
        menuP.bCredits.addActionListener(this);
        
        mBarP.bReturn.addActionListener(this);
        
        //Add Top Bar
        add(menuP, "Center");
        add(mBarP, "North");
        mBarP.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj == mBarP.bReturn) {
            mBarP.setVisible(false);
            menuP.setVisible(true);
            gameP.setVisible(false);
            instP.setVisible(false);
            scoresP.setVisible(false);
            creditsP.setVisible(false);
            optionsP.setVisible(false);
        }
          if (obj == menuP.bGame){
           menuP.setVisible(false);
           mBarP.setVisible(true);
           mBarP.setGameStatus(1);
           add(gameP, "Center");
           gameP.setVisible(true);
        }
        if (obj == menuP.bInst){
           menuP.setVisible(false);
           mBarP.setVisible(true);
           mBarP.setGameStatus(0);
           add(instP, "Center");
           instP.setVisible(true);
        }
        if (obj == menuP.bCredits){
           menuP.setVisible(false);
           mBarP.setVisible(true);
           mBarP.setGameStatus(0);
           add(creditsP, "Center");
           creditsP.setVisible(true);
        }
         if (obj == menuP.bOptions){
           menuP.setVisible(false);
           mBarP.setVisible(true);
           mBarP.setGameStatus(0);
           add(optionsP, "Center");
           optionsP.setVisible(true);
        }
         if (obj == menuP.bScores){
           menuP.setVisible(false);
           mBarP.setVisible(true);
           mBarP.setGameStatus(0);
           add(scoresP, "Center");
           scoresP.setVisible(true);
        }
    }
}
