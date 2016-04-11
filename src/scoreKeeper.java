
import java.io.File;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */
public class scoreKeeper {
    String[] scoresList;
    String blank = "Name: ------- Date: ------ Score: ---";
    int MAX_SCORES_SAVED = 10;
    String saveFile = "HighScores.xml";
    
    
    scoreKeeper() {
         File f = new File(saveFile);
        if(!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setBlank();
        }
    }
    public void setBlank() {
        XML_240 xr = new XML_240();
        xr.openWriterXML(saveFile);
        for (int x = 0; x < 10; x++) {
            xr.writeObject(blank);
        }
        xr.closeWriterXML();
    }
    
    public void checkScore() {
      
    }
    
    public void getHighScores() {
        int x = 0;
        XML_240 xr = new XML_240();
        xr.openReaderXML(saveFile);
        /*while ((boolean) xr.ReadObject()); {
        scoresList[x] = (String) xr.ReadObject();
        System.out.println(scoresList[x]);
        x++;*/
    }
        
    
    public void setNewScore() {
        XML_240 xr = new XML_240();
        xr.openReaderXML(saveFile);
        for (int x = 0; x < MAX_SCORES_SAVED; x++) {
            scoresList[x] = (String) xr.ReadObject();
            System.out.println(scoresList[x]);
        }
        
    }
}
