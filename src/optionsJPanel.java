
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class optionsJPanel extends JPanel implements ActionListener, ChangeListener {

    imageButton bMode, bSpeed, bFlavors, bSound;
    JRadioButton jrbNormal, jrbSurvival, jrbMarathon;
    ButtonGroup bgMode;
    optionsSlider jsSpeed, jsFlavors;

    public optionsJPanel() {
        super();
        //Initialize imageButtons
        bMode = new imageButton("images/optionsP/iMode.png");
        bSpeed = new imageButton("images/optionsP/iSpeed.png");
        bFlavors = new imageButton("images/optionsP/iFlavor.png");
        bSound = new imageButton("images/optionsP/iSoundEn.png",
                "images/optionsP/iSoundEnP.png",
                "images/optionsP/iSoundDis.png",
                "images/optionsP/iSoundDisP.png");
        bSound.addActionListener(this);

        System.out.println("Initializing optionsP");

        //Initialize and group RadioButtons
        jrbNormal = new JRadioButton("Normal");
        jrbSurvival = new JRadioButton("Survival");
        jrbMarathon = new JRadioButton("Marathon");
        bgMode = new ButtonGroup();
        bgMode.add(jrbNormal);
        bgMode.add(jrbSurvival);
        bgMode.add(jrbMarathon);

        jrbNormal.addActionListener(this);
        jrbSurvival.addActionListener(this);
        jrbMarathon.addActionListener(this);
        checkModeButton();
        //Initialize Sliders
        jsSpeed = new optionsSlider(JSlider.HORIZONTAL, 1, 5, app.speed, 1);
        jsFlavors = new optionsSlider(JSlider.HORIZONTAL, 1, 5, app.flavors, 1);
        jsSpeed.addChangeListener(this);
        jsFlavors.addChangeListener(this);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.ipady = 10;
        c.insets = new Insets(10, 0, 0, 0);
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

    }

    public void update() {
        setMuted(!app.muted);
        jsSpeed.setValue(app.speed);
        jsFlavors.setValue(app.flavors);
        checkModeButton();
    }

    public void setMuted(boolean isMuted) {
        bSound.setAltImage(isMuted);
        app.muted = isMuted;
    }

    public void checkModeButton() {
        switch (app.mode) {
            case app.MODE_NORMAL: {
                jrbNormal.setSelected(true);
                break;
            }
            case app.MODE_SURVIVAL: {
                jrbSurvival.setSelected(true);
                break;
            }
            case app.MODE_MARATHON: {
                jrbMarathon.setSelected(true);
                break;
            }
        }
    }

    //Reset Defaults
    public void setDefaults() {
        app.speed = app.DEFAULT_SPEED;
        app.flavors = app.DEFAULT_FLAVORS;
        app.mode = app.DEFAULT_MODE;
        app.muted = app.DEFAULT_MUTED;
        update();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == bSound) {
            //toggle mute
            setMuted(!app.muted);
        } //set app mode based on which button is pressed.
        else if (source == jrbNormal) {
            app.mode = app.MODE_NORMAL;
        } else if (source == jrbSurvival) {
            app.mode = app.MODE_SURVIVAL;
        } else if (source == jrbMarathon) {
            app.mode = app.MODE_MARATHON;
        }
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        Object source = ce.getSource();
        if (source == jsSpeed) {
            app.speed = jsSpeed.getValue();
        } else if (source == jsFlavors) {
            app.flavors = jsFlavors.getValue();
        }
    }
}
