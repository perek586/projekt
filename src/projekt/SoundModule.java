package projekt;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.util.HashMap;

/** This module will handle ALL the sounds we need for our game */

public class SoundModule{
    /** soundMap contains keys and AudioClips which are always related to each other,
     *  for example: soundMap.get("attack") will return an AudioClip which contains the
     *  sound for an attack */
    private HashMap<String, AudioClip> soundMap = new HashMap<String, AudioClip>();
    private SoundChannel channel;


    /** Don't know what the constructor will do yet */
    public SoundModule(){}

    /** This method plays a sound from the given key */
    public void playSound(String key){
        getAudioClip(key).play();
    }

    /** stops playing a sound */
    public void stopSound(String key){
        getAudioClip(key).stop();
    }

    public void printSoundMap(){
        System.out.println(soundMap.toString());
    }
    
    public void loopSound(String key){
    	getAudioClip(key).loop();
    }

    /** addSoundToMap adds a key with a related path to our soundMap */
    public String addSoundToMap(String key, String path, int id) throws MalformedURLException {
        channel = new SoundChannel(key,id, Applet.newAudioClip(new URL("file:"+path)));
        soundMap.put(channel.getName(), channel.getClip());
        System.out.println("Successfully added the sound " + path + " to the soundMap.\nName: "+channel.getName());
        return (key+id);
    }
    /** getAudioClip returns the AudioClip which is related to the key */
    public AudioClip getAudioClip(String key){
        return soundMap.get(key);
    }



}

