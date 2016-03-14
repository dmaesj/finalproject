import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameJPanel extends JPanel implements ActionListener
{
    JButton temp, bReturn;
    public gameJPanel ()
    {   
        super();
        //Initialize buttons
        bReturn = new JButton();
        temp = new JButton();
        
        //Set text and add buttons and listeners
        temp.setText("More to come");
        bReturn.setText("Main Menu");
        bReturn.addActionListener(this);
        add(bReturn);
        add(temp);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj == bReturn) {
            setVisible(false);
        }
    }
}
