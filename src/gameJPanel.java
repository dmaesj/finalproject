import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameJPanel extends JPanel
{
    private boolean gameStatePaused = false;
    JButton bTemp;
    public gameJPanel ()
    {   
        super();
        bTemp = new JButton();
        bTemp.setText("Game Panel");
        add(bTemp);
    }
    public void setGamePaused(boolean paused) {
        gameStatePaused = paused;
    }
    public boolean getGameState() {
        return gameStatePaused;
    }
}
