
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
    String[] nameList = new String[10];
    double[] scoreList = new double[10];
    String blank = "Name: ------- Date: ------ Score: ---";
    double blankScore = 0d;
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
        for (int x = 0; x < MAX_SCORES_SAVED; x++) {
            xr.writeObject(blank);
        }
         for (int x = 0; x < MAX_SCORES_SAVED; x++) {
            xr.writeObject(blankScore);
            System.out.println("writing: " + blankScore);
        }
        xr.closeWriterXML();
    }
    
    public void checkScore() {
      
    }
    
    public void getHighScores() {
        XML_240 xr = new XML_240();
        xr.openReaderXML(saveFile);
        for (int x = 0; x < MAX_SCORES_SAVED; x++) {
            nameList[x] = new String();
            nameList[x] = (String) xr.ReadObject();
            System.out.println(x + ": " + nameList[x]);
        }
        /*for (int x = 0; x < MAX_SCORES_SAVED; x++) {
            scoreList[x] = (double) xr.ReadObject();
            System.out.println("" + scoreList[x]);
        }*/
        xr.closeReaderXML();
    }
        
    
    public void setNewScore() {
        XML_240 xr = new XML_240();
        getHighScores();
        String tempSave;
        xr.openWriterXML(saveFile);
        for (int x = 0; x < MAX_SCORES_SAVED; x++) {
            tempSave = nameList[x];
            
            xr.writeObject(nameList[x]);
        }
        xr.closeWriterXML();
    }
    
}
