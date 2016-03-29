
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric
 */
public class flavorSprite extends sprite {

    int xPos;
    boolean xSet = false;
    int speed = 5;
    soundPlayer flavorDrop, flavorMiss;
    boolean muted;
    public flavorSprite(String imagePath, boolean inMuted) {
        super(imagePath);
        muted = inMuted;
        flavorDrop = new soundPlayer();
        flavorMiss = new soundPlayer();
        try {
            flavorDrop.setIStream("sounds/drop.wav");
            flavorMiss.setIStream("sounds/miss.wav");
        } catch (IOException ex) {
            Logger.getLogger(flavorSprite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update() {
        if (!xSet) {
            xPos = (int) (Math.round(Math.random() * (getParent().getSize().width - icon.getIconWidth() / 2)));
            setBounds(xPos, 0, icon.getIconWidth(), icon.getIconHeight());
            xSet = true;
        }
        setPosition(xPos, getBounds().y + speed);
        if (!muted) {
            flavorDrop.play();
            if (getBounds().y >= getParent().getBounds().height) {
                flavorMiss.play();
            }
        }
    }
}
