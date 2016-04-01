public class coneSprite extends sprite{
    int speed = 100;
    
    coneSprite(int x, int y) {
        super();
        this.setIcon("images/gameP/coneCut.png");
        setBounds(x, y,
                icon.getIconWidth(), icon.getIconHeight());
    }

    public void move(int inX) {

        int yPos = getParent().getSize().height - icon.getIconHeight();
        int delta = 0;
        delta = inX - (getBounds().x + (getBounds().width / 2));
        
        if (delta > speed) {
            delta = speed;
        }
        if (delta < -speed) {
            delta = -speed;
        }
        
        setPosition(getBounds().x + delta, yPos);

    }
    
}
