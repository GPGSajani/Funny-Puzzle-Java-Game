/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GamePackage;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author ASUS
 */
public class ClassSound {
    Clip clip;
    float previousVolume = 0;
    float currentVolume = 0;
    FloatControl fc;
    boolean mute = false;
    
    public void setFile(URL url){
        try{
            AudioInputStream sound = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(sound);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);           
        }catch(Exception e){
            
        }
    }
    
    public void play(URL url){
        clip.setFramePosition(0);
        clip.start();
    }
    
    public void loop(URL url){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop(URL url){
        clip.stop();
    }
    
    public void volumeUp(){
        currentVolume += 1.0f;
        if(currentVolume > 6.0f){
            currentVolume = 6.0f;
        }
        fc.setValue(currentVolume);
    }
    
    public void volumeDown(){
        currentVolume -= 1.0f;
        if(currentVolume < -80.0f){
            currentVolume = -80.0f;
        }
        fc.setValue(currentVolume);
    }
    
    public void volumeMute(){
        if(!mute){
        previousVolume = currentVolume;
        currentVolume = -80.0f;
        fc.setValue(currentVolume);
        mute = true;
    } else {
        currentVolume = previousVolume;
        fc.setValue(currentVolume);
        mute = false;
    }
    }
}
