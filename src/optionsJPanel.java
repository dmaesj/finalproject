import javax.swing.*;
import java.awt.*;

public class optionsJPanel extends JPanel 
{   
    JButton bTemp;
    public optionsJPanel ()
    {
        super();
        bTemp = new JButton();
        bTemp.setText("Options Panel");
        add(bTemp);
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 10;
        
        
    }
}
