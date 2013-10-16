package projekt;
import java.net.MalformedURLException;

public class SoundTest {
      public static void main(String []args) throws InterruptedException, MalformedURLException {
          String file = "World";

          SoundID ids = new SoundID();
          ids.printSoundIDMap();
          SoundModule sound = new SoundModule();
          String sound1 = sound.addSoundToMap("Boss", "Boss_5.wav", ids.getMusicID(0));
          String sound2 = sound.addSoundToMap("World", "World.wav", ids.getMusicID(0));
          sound.printSoundMap();
          


      }
}

