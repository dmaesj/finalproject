public class coneSprite extends sprite{
    int speed = 100;
    coneSprite(String imagePath) {
        super(imagePath);
        setBounds(icon.getIconWidth() / 2, 0,
                icon.getIconWidth(), icon.getIconHeight());
        
    }

    @Override
    public void update() {
        mouseLoc = getParent().getMousePosition();
        if (mouseLoc == null)
            return;
        int yPos = getParent().getSize().height - icon.getIconHeight();
        int delta = 0;
        delta = mouseLoc.x - (getBounds().x + (getBounds().width / 2));
        if (delta > speed) {
            delta = speed;
        }
        if (delta < -speed) {
            delta = -speed;
        }
        setPosition(getBounds().x + delta, yPos);
    }
}
