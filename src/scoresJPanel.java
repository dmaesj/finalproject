
import javax.swing.*;
import java.awt.*;

public class scoresJPanel extends JPanel {

    JButton bTemp;
    scoreKeeper score;

    public scoresJPanel() {
        super();
        bTemp = new JButton();
        score = new scoreKeeper();
        score.getHighScores();
        score.setNewScore("ADAM", 100);
        bTemp.setText("stuff");
        add(bTemp);
    }
}
