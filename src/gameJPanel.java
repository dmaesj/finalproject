import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameJPanel extends JPanel
{
   
    public gameJPanel ()
    {   
        super();
        JButton bTemp;
        bTemp = new JButton();
        bTemp.setText("Game Panel");
        add(bTemp);
    }
}
