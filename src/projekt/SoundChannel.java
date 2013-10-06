package projekt;
import java.applet.AudioClip;

/** SoundChannel is used because we sometimes want to play one sound when the
 *  same sound is already playing (they overlap), because if we try to stop a sound that
 *  has the same key in the soundMap as another sound, soundMap.get(key).stop() will stop ALL sounds with that
 *  name, not the last or first only */

  public class SoundChannel {
    private String name;
    private int id;
    private AudioClip clip;

    /** The name and id are both initialized in SoundModule (addToSoundBoard(key,path,id))
     *  here, we change the name to name+id to make it unique*/
    public SoundChannel(String name, int id, AudioClip clip){
        this.clip   = clip;
        this.id     =   id;
        this.name   = name+(""+id);
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public AudioClip getClip(){
        return this.clip;
    }


}
