import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameJPanel extends JPanel
{
    JButton bTemp;
    public gameJPanel ()
    {   
        super();
        bTemp = new JButton();
        bTemp.setText("Game Panel");
        add(bTemp);
    }
}
