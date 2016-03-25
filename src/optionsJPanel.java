
import javax.swing.*;
import java.awt.*;

public class optionsJPanel extends JPanel {

    imageButton bMode, bSpeed, bFlavors, bSound;
    JRadioButton jrbNormal, jrbSurvival, jrbMarathon;
    ButtonGroup bgMode;
    optionsSlider jsSpeed, jsFlavors;
    options gameOpt;

    JTextArea saved;

    public optionsJPanel(options inOpt) {
        super();
        gameOpt = inOpt;

        //Initialize imageButtons
        bMode = new imageButton("images/optionsP/iMode.png");
        bSpeed = new imageButton("images/optionsP/iSpeed.png");
        bFlavors = new imageButton("images/optionsP/iFlavor.png");
        bSound = new imageButton("images/optionsP/iSoundEn.png",
                "images/optionsP/iSoundEnP.png",
                "images/optionsP/iSoundDis.png",
                "images/optionsP/iSoundDisP.png");

        System.out.println("Initializing optionsP");

        //Initialize and group RadioButtons
        jrbNormal = new JRadioButton("Normal");
        jrbSurvival = new JRadioButton("Survival");
        jrbMarathon = new JRadioButton("Marathon");
        bgMode = new ButtonGroup();
        bgMode.add(jrbNormal);
        bgMode.add(jrbSurvival);
        bgMode.add(jrbMarathon);

        //Initialize Sliders
        jsSpeed = new optionsSlider(JSlider.HORIZONTAL, 1, 5, gameOpt.getSpeed(), 1);
        jsFlavors = new optionsSlider(JSlider.HORIZONTAL, 1, 5, gameOpt.getFlavors(), 1);

        saved = new JTextArea("Options Saved...");
        saved.setVisible(false);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.ipady = 10;
        c.insets = new Insets(10, 0, 0, 0);
        add(bMode, c);
        c.gridy = 1;
        c.gridx = 0;
        add(jrbNormal, c);
        c.gridx = 1;
        add(jrbSurvival, c);
        c.gridx = 2;
        add(jrbMarathon, c);
        c.gridy = 2;
        c.gridx = 1;
        add(bSpeed, c);
        c.gridy = 3;
        add(jsSpeed, c);
        c.gridy = 4;
        add(bFlavors, c);
        c.gridy = 5;
        add(jsFlavors, c);
        c.gridy = 6;
        add(bSound, c);

        setOptionScreen();

    }

    // Set values to values from xml
    public void setOptionScreen() {
        jsSpeed.setValue(gameOpt.getSpeed());
        jsFlavors.setValue(gameOpt.getFlavors());

        switch (gameOpt.getMode()) {
            case 1: {
                jrbNormal.setSelected(true);
                break;
            }
            case 2: {
                jrbSurvival.setSelected(true);
                break;
            }
            case 3: {
                jrbMarathon.setSelected(true);
                break;
            }
        }

        bSound.setAltImage(gameOpt.getMuted());

    }

}
