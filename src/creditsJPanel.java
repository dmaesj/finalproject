
import javax.swing.*;
import java.awt.*;

public class creditsJPanel extends JPanel {

    JButton bTemp;

    public creditsJPanel() {
        super();
        bTemp = new JButton();
        bTemp.setText("CREDITS \n Adam Fedor \n Daniel Maes \n Eric Ruppert \n Jessica Spiegelblatt");
        add(bTemp);
    }
}
