package Game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {
    ArrayList<Clip> clips = new ArrayList<Clip>();
    ArrayList<Integer> lastTime = new ArrayList<Integer>();
    public SoundPlayer(){

    }
    /*
     * Agrega un audio a la coleccion de audios que se pueden reproducir
     * @param String path
     */
    public void agregarAudio(String path){
        try {
            Clip clip;
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src\\res"+path));
            clip = AudioSystem.getClip();
            clip.open(ais);
            clips.add(clip);
            lastTime.add(0);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public void eliminarAudio(int i){

    }
    /*
     * Reproduce un audio
     * @param int i Audio a reproducir
     */
    public void play(int i){
        if (clips.get(i) == null || clips.get(i).isRunning()){
            return;
        }
        stop(i);
        clips.get(i).setFramePosition(lastTime.get(i));
        clips.get(i).start();
    }
    /*
     * Detiene un audio
     * @param int i Audio por detener
     */
    private void stop(int i) {
        if (clips.get(i).isRunning()){
            lastTime.set(i, clips.get(i).getFramePosition());
            clips.get(i).stop();
        }
    }
    /*
     * Cierra un clip de audio
     */
    public void close(int i){
        stop(i);
        clips.get(i).close();
    }
}
