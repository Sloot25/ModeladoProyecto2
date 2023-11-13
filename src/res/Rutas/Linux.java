package res.Rutas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

// Clase que contiene las rutas para un dispositivo tipo Linux
public class Linux implements Rutas{
  public Linux(){
    
  }
  // Metodo que regresa la imagen de la carpeta res de acuerdo al sistema Linux
  public BufferedImage getImagen(String imagen){
    try{
      return ImageIO.read(new File("res/" + imagen));
    }catch(IOException e){
      e.printStackTrace();
      return null;
    }
  }
  public AudioInputStream getAudio(String audio){
    try {
      return AudioSystem.getAudioInputStream(new File("res/KUWAGO/"+audio));
    } catch (UnsupportedAudioFileException | IOException e) {
      e.printStackTrace();
      return null;
    }
  } 
}
