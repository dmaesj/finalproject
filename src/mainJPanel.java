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
        mBarP = new menuBarJPanel();
        instP = new instJPanel();
        scoresP = new scoresJPanel();
        creditsP = new creditsJPanel();
        optionsP = new optionsJPanel();
        gameP = new gameJPanel();
        menuP = new menuJPanel();
        
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
        if (obj == menuP.bGame){
           menuP.setVisible(false);
           mBarP.setVisible(true);
           add(gameP, "Center");
           updateUI();
        }
        if (obj == mBarP.bReturn) {
            mBarP.setVisible(false);
            menuP.setVisible(true);
        }
    }
}
