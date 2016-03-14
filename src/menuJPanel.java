import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuJPanel extends JPanel implements ActionListener
{
    instJPanel instP;
    scoresJPanel scoresP;
    creditsJPanel creditsP;
    optionsJPanel optionsP;
    gameJPanel gameP;
    JButton bLabel, bGame, bInst, bScores, bCredits, bOptions;
    public menuJPanel ()
    {
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 10;
        
        //Initialize Buttons
        bLabel = new JButton();
        bGame = new JButton();
        bOptions = new JButton();
        bInst = new JButton();
        bScores = new JButton();
        bCredits = new JButton();
        
        //Set Button Text
        bLabel.setText("Nittany Creamery");
        bGame.setText("Start");
        bOptions.setText("Options");
        bInst.setText("Instructions");
        bScores.setText("High Scores");
        bCredits.setText("Credits");
        
        //Add Listeners
        bGame.addActionListener(this);
        bOptions.addActionListener(this);
        bInst.addActionListener(this);
        bScores.addActionListener(this);
        bCredits.addActionListener(this);
        
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

        //Initialize Panels
        instP = new instJPanel();
        scoresP = new scoresJPanel();
        creditsP = new creditsJPanel();
        optionsP = new optionsJPanel();
        gameP = new gameJPanel();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj == bGame){
           removeAll();
           setLayout(new BorderLayout()); 
           add(gameP, "Center");
           updateUI();
        }
    }
}
