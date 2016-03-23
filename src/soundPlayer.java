
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class soundPlayer {

    private FileInputStream inStream = null;
    private AudioStream aStream = null;

    soundPlayer() {
    }

    public void play() {
        AudioPlayer.player.start(aStream);
    }

    public void stop() {
        AudioPlayer.player.stop(aStream);
    }

    public void setIStream(String inPath) throws FileNotFoundException, IOException {
        inStream = new FileInputStream(inPath);
        aStream = new AudioStream(inStream);
    }

}
