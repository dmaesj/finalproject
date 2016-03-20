import javax.swing.*;
import java.awt.*;

public class optionsSlider extends JSlider {
    optionsSlider(int orientation, int min, int max, int start, int majSpacing) {
        super(orientation, min, max, start);
            setMajorTickSpacing(majSpacing);
            setPaintLabels(true);
            //setPaintTicks(true);
    }
}