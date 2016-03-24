/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DJ
 */
public class options {

    int mode;
    int speed;
    int flavors;
    boolean muted;

    public options() {

    }

    //==========================================================================
    public int getMode() {
        return this.mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    //==========================================================================
    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //==========================================================================
    public int getFlavors() {
        return this.flavors;
    }

    public void setFlavors(int flavors) {
        this.flavors = flavors;
    }

    //==========================================================================
    public boolean getMuted() {
        return this.muted;
    }

    public void setMuted() {
        muted = !muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public void storeOptions() {
        XML_240 xr = new XML_240();

        xr.openWriterXML("Options.xml");
        xr.writeObject(mode);
        xr.writeObject(speed);
        xr.writeObject(flavors);
        xr.writeObject(muted);
        xr.closeWriterXML();
    }

    public void getOptions() {
        XML_240 xr = new XML_240();

        xr.openReaderXML("Options.xml");
        mode = (int) xr.ReadObject();
        speed = (int) xr.ReadObject();
        flavors = (int) xr.ReadObject();
        muted = (boolean) xr.ReadObject();
        xr.closeReaderXML();

    }

}
