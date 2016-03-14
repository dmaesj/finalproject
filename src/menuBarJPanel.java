import javax.swing.*;
import java.awt.*;

public class menuBarJPanel extends JPanel 
{   
    JButton temp, bReturn;
    public menuBarJPanel ()
    { 
        super();
        //Initialize buttons
        bReturn = new JButton();
        temp = new JButton();
        
        //Set text and add buttons and listeners
        temp.setText("More to come");
        bReturn.setText("Main Menu");
        add(bReturn);
        add(temp);
    }
}
