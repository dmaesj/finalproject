
import java.awt.*;
import javax.swing.*;

public class imageButton extends JButton {

    private ImageIcon iReleased, iPressed, i2Released, i2Pressed;

    imageButton(String imagePath1) {
        super();
        iReleased = new ImageIcon(imagePath1);
        setIcon(iReleased);
        setPressedIcon(iReleased);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    imageButton(String imagePath1, String imagePath2) {
        this(imagePath1);
        iPressed = new ImageIcon(imagePath2);
        setPressedIcon(iPressed);
    }

    imageButton(String imagePath1, String imagePath2, String imagePath3, String imagePath4) {
        this(imagePath1, imagePath2);
        i2Released = new ImageIcon(imagePath3);
        i2Pressed = new ImageIcon(imagePath4);
    }

    // Sets alternate images for buttons
    public void setAltImage() {
        if (getIcon() == i2Released) {
            setIcon(iReleased);
            setPressedIcon(iPressed);
        } else {
            setIcon(i2Released);
            setPressedIcon(i2Pressed);
        }
    }

    public void setAltImage(boolean alt) {
        if (alt) {
            setIcon(i2Released);
            setPressedIcon(i2Pressed);
        } else {
            setIcon(iReleased);
            setPressedIcon(iPressed);
        }
    }

    // Changes primary or alternate images manually
    public void addImageIcon(boolean alt, String inPath) {
        if (alt) {
            i2Pressed = new ImageIcon(inPath);
            i2Released = new ImageIcon(inPath);
        } else {
            iReleased = new ImageIcon(inPath);
            iPressed = new ImageIcon(inPath);
        }

    }

    public void addImageIcon(boolean alt, String inPath, String inPath2) {
        if (alt) {
            i2Pressed = new ImageIcon(inPath);
            i2Released = new ImageIcon(inPath2);
        } else {
            iReleased = new ImageIcon(inPath);
            iPressed = new ImageIcon(inPath2);
        }

    }
}
