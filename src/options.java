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
    
    int     mode;
    int     speed;
    int     flavor;
    boolean sound;
    
    public options ()
        {

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
    public int getFlavor() {
        return this.flavor;
    }

    public void setFlavor(int flavor) {
        this.flavor = flavor;
    }
    //==========================================================================
    public boolean getSound() {
        return this.sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    //==========================================================================

    public void restoreDefaults() {
        this.mode   = 1;
        this.speed  = 2;
        this.flavor = 3;
        this.sound  = true;
        this.storeOptions();
    }
        
    public void storeOptions() {
        xmlRW xr = new xmlRW();
        
        xr.openWriterXML("Options.xml");
                xr.writeObject(this.mode);
                xr.writeObject(this.speed);
                xr.writeObject(this.flavor);
                xr.writeObject(this.sound);
        xr.closeWriterXML();
    }    

    public void getOptions() {
        xmlRW xr = new xmlRW();
        
        xr.openReaderXML("Options.xml");
                this.mode   = (int)xr.ReadObject();
                this.speed  = (int)xr.ReadObject();
                this.flavor = (int)xr.ReadObject();
                this.sound  = (boolean)xr.ReadObject();
        xr.closeReaderXML();  
                
    }  
    
}
