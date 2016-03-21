import javax.swing.*;
import java.awt.*;

public class menuJPanel extends JPanel 
{
    imageButton bLabel, bGame, bInst, bScores, bCredits, bOptions, bLion;
    public menuJPanel ()
    {
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 10;
        
        //Initialize Buttons and Icons
        bLabel = new imageButton("images/menuP/iLabel.png");
        bGame = new imageButton("images/menuP/iGame.png");
        bOptions = new imageButton("images/menuP/iOptions.png");
        bInst = new imageButton("images/menuP/iInst.png");
        bScores = new imageButton("images/menuP/iScores.png");
        bCredits = new imageButton("images/menuP/iCredits.png");
        bLion = new imageButton("images/menuP/iLionSmall.png");
         
        //Add Buttons, setting gridbaglayout constraints
        c.gridx = 10;
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
        c.gridx=12;
        c.anchor= GridBagConstraints.SOUTHEAST;
        add(bLion, c);
    }
}
