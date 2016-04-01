import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class sprite extends JButton {

    ImageIcon icon;

    public sprite() {
        super();
    }
    
    public void setIcon(String imagePath) {
        icon = new ImageIcon(imagePath);
        setIcon(icon);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }
    
    public void setPosition(int x, int y) {
        setBounds(x, y, getBounds().width, getBounds().height);
    }
}
