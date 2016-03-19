import javax.swing.*;
import java.awt.*;

public class menuJPanel extends JPanel 
{
    JButton bLabel, bGame, bInst, bScores, bCredits, bOptions, bLion;
    ImageIcon iLabel, iGame, iInst, iScores, iCredits, iOptions, iLion;
    public menuJPanel ()
    {
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 10;
        
        //Initialize Buttons and Icons
        bLabel = new JButton();
        bGame = new JButton();
        bOptions = new JButton();
        bInst = new JButton();
        bScores = new JButton();
        bCredits = new JButton();
        bLion = new JButton ();
        
        iLabel = new ImageIcon("images/menuP/iLabel.png");
        iGame = new ImageIcon("images/menuP/iGame.png");
        iInst = new ImageIcon("images/menuP/iInst.png");
        iScores = new ImageIcon("images/menuP/iScores.png");
        iCredits = new ImageIcon("images/menuP/iCredits.png");
        iOptions = new ImageIcon("images/menuP/iOptions.png");
        iLion = new ImageIcon("images/menuP/iLionSmall.png");
        
        // Add ImageIcons to buttons and set border and button fill as invisible
        bLabel.setIcon(iLabel);
        bLabel.setBorderPainted(false);
        bLabel.setContentAreaFilled(false);
        
        bGame.setIcon(iGame);
        bGame.setBorderPainted(false);
        bGame.setContentAreaFilled(false);
        
        bInst.setIcon(iInst);
        bInst.setBorderPainted(false);
        bInst.setContentAreaFilled(false);
        
        bScores.setIcon(iScores);
        bScores.setBorderPainted(false);
        bScores.setContentAreaFilled(false);
        
        bCredits.setIcon(iCredits);
        bCredits.setBorderPainted(false);
        bCredits.setContentAreaFilled(false);
        
        bOptions.setIcon(iOptions);
        bOptions.setBorderPainted(false);
        bOptions.setContentAreaFilled(false);
        
        bLion.setIcon(iLion);
        bLion.setBorderPainted(false);
        bLion.setContentAreaFilled(false);
        
        //Add Buttons, setting gridbaglayout constraints
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 10;
        c.insets = new Insets(10,0,0,0);
        add(bLabel, c);
        c.gridy=2;
        add(bGame, c);
        c.gridy=3;
        add(bOptions, c);
        c.gridy=4;
        add(bInst, c);
        c.gridy=5;
        add(bScores, c);
        c.gridy=6;
        add(bCredits, c);
        c.gridy=7;
        c.gridx=10;
        c.anchor= GridBagConstraints.SOUTHEAST;
        add(bLion, c);
    }
}
