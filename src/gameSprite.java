
import java.awt.*;
import javax.swing.*;

public class gameSprite extends JButton {
    ImageIcon icon;

    gameSprite(String imagePath) {
        super();
        icon = new ImageIcon(imagePath);
        setIcon(icon);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }
    
    // Get horizonal center point
    public int getHCenter() {
        return (int)(icon.getIconWidth() / 2);
    }
    // Get vertical center point
    public int getVCenter() {
        return (int)(icon.getIconHeight() / 2);
    }
    // Get width
    public int getWidth() {
        return icon.getIconWidth();
    }
    // Get height
    public int getHeight() {
        return icon.getIconHeight();
    }
}
