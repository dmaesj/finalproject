import javax.swing.*;
import java.awt.*;

public class scoresJPanel extends JPanel {
    
    JButton bTemp;
    public scoresJPanel ()
    {
        super();
        bTemp = new JButton();
        bTemp.setText("Scores Panel");
        add(bTemp);
    }
}
