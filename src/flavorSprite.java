
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class flavorSprite extends sprite implements ActionListener {

    int xPos;
    boolean xSet = false;
    boolean moving = true;
    int speed = 25;
    soundPlayer flavorDrop, flavorMiss;
    boolean muted;
    int flavor;
    Timer t;
    
    public flavorSprite(int inFlavor, int x, int y, boolean inMuted) {
        super();
        this.setIcon(getFlavor(inFlavor));
        muted = inMuted;
        flavorDrop = new soundPlayer();
        flavorMiss = new soundPlayer();
        setBounds(x, y,
                icon.getIconWidth(), icon.getIconHeight());
        try {
            flavorDrop.setIStream("sounds/drop.wav");
            flavorMiss.setIStream("sounds/miss.wav");
        } catch (IOException ex) {
            Logger.getLogger(flavorSprite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getFlavor(int i) {
                return "images/gameP/flavor" + (i+1) + ".png";
    }
    
    public void startMoving(int inSpeed) {
        
        t = new Timer(60, this);
        t.start();

    }
    
    public void stopMoving() {
        speed = 0;
    }
    
    public void update() {
        if (!xSet) {
            xPos = (int) (Math.round(Math.random() * (getParent().getSize().width - icon.getIconWidth() / 2)));
            setBounds(xPos, 0, icon.getIconWidth(), icon.getIconHeight());
            xSet = true;
        }
        setPosition(xPos, getBounds().y + speed);
        if (!muted) {
            flavorDrop.play();
            if (getBounds().y >= getParent().getBounds().height) {
                flavorMiss.play();
            }
        }
    }
    
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();

            if (obj == t) {
               this.setPosition(this.getBounds(). x,this.getBounds().y + this.speed );
            }
        }
}
