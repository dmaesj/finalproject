
import javax.swing.*;

public class gameJPanel extends JPanel {

    private boolean gameKill = false; // will need to be changed after options panel is added
    JButton bSpeed, bMode, bFlavor;

    public gameJPanel() {
        super();
        bSpeed = new JButton("Speed: " + app.speed);
        bFlavor = new JButton("Flavors: " + app.flavors);
        bMode = new JButton("Mode: " + app.mode);
        add(bSpeed);
        add(bFlavor);
        add(bMode);
        System.out.println("game constructed");
    }

    public void update() {
        bSpeed.setText("Speed: " + app.speed);
        bFlavor.setText("Flavors: " + app.flavors);
        bMode.setText("Mode: " + app.mode);
    }

    // Quit current game, currently does nothing
    public void gQuit() {
        gameKill = true;
    }
}
