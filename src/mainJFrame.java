import java.awt.*;
import javax.swing.*;

public class mainJFrame extends JFrame
{
	public mainJFrame ()
	{
		super ("Berkey Creamery");
		

  	 	mainJPanel mPanel = new mainJPanel();
    
    	
    	
		getContentPane().add(mPanel,"Center");
		

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (640, 480);
		setVisible(true);
	}

}
