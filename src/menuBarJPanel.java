import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBarJPanel extends JPanel implements ActionListener
{   
    JButton bReturn, bPause, bGiveUp, bSound;
    ImageIcon iMenu, iPause, iResume, iGiveUp, iSoundOn, iSoundOff;
    gameJPanel gameP;
    public menuBarJPanel (gameJPanel inGame)
    { 
        super();
        setBackground(Color.LIGHT_GRAY);
        // Pass gameP by reference for pause functionality;
        gameP = inGame;
        
        //Initialize buttons
        bReturn = new JButton();
        bPause = new JButton();
        bGiveUp = new JButton();
        bSound = new JButton();
        
        //Add listeners
        bPause.addActionListener(this);
        
        
        // Initialize and set Images
        iMenu = new ImageIcon("images/mBarP/iMenu.png");
        iPause = new ImageIcon("images/mBarP/iPause.png");
        iResume = new ImageIcon("images/mBarP/iResume.png");
        iSoundOn = new ImageIcon("images/mBarP/iSoundOn.png");
        iSoundOff = new ImageIcon("images/mBarP/iSoundOff.png");
        iGiveUp = new ImageIcon("images/mBarP/iGiveUp.png");
       
        bReturn.setIcon(iMenu);
        bReturn.setBorderPainted(false);
        bReturn.setContentAreaFilled(false);
        add(bReturn);
        
        //Add if to check if sound was turned off in options *** also need to add soundOn variable in gameP
        bSound.setIcon(iSoundOn);
        bSound.setBorderPainted(false);
        bSound.setContentAreaFilled(false);
        add(bSound);
        
        bGiveUp.setIcon(iGiveUp);
        bGiveUp.setBorderPainted(false);
        bGiveUp.setContentAreaFilled(false);
        add(bGiveUp);
    }
    
    public void setGameStatus(int gStatus) {
        if (gStatus == 1) {
            bPause.setIcon(iPause);
            bPause.setBorderPainted(false);
            bPause.setContentAreaFilled(false);
            add(bPause);
        }
        else if (gStatus != 1) {
            bPause.setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj == bPause) {
            if (!gameP.getGameState()){
                //add code to pause game
                bPause.setIcon(iResume);
                gameP.setGamePaused(true);
            }
            else {
                //add code to resume game
                bPause.setIcon(iPause);
                gameP.setGamePaused(false);
            }
        }
    }
}
