import java.awt.*;
import javax.swing.*;

public class imageButton extends JButton {
    private ImageIcon image1, image2;
    imageButton(String imagePath1) {
        super();
        image1 = new ImageIcon(imagePath1);
        setIcon(image1);
        setBorderPainted(false);
        setContentAreaFilled(false);
    }
    imageButton(String imagePath1, String imagePath2) {
        super();
        image1 = new ImageIcon(imagePath1);
        image2 = new ImageIcon(imagePath2);
        setIcon(image1);
        setBorderPainted(false);
        setContentAreaFilled(false);
    }
    // Sets alternate images for buttons
    public void setAltImage(boolean alt) {
        if (alt) {
            setIcon(image2);
        }
        else {
            setIcon(image1);
        }
    }
    // Changes primary or alternate images manually
    public void addImageIcon(boolean priImage, String inPath) {
        if (priImage) {
            image1 = new ImageIcon(inPath);
        }
        else {
            image2 = new ImageIcon(inPath);
        }
    }
}