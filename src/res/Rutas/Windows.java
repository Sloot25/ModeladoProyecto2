package res.Rutas;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
// Clase que contiene las rutas para un dispositivo tipo Windows
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Windows implements Rutas { 
  public Windows(){
    
  }
  // Metodo que regresa la imagen de la carpeta res de acuerdo a la cadena recibida 
  public BufferedImage getImagen(String imagen){
    try{
      return ImageIO.read(new File("res/" + imagen));
      //return ImageIO.read(new File("\\res\\" + imagen));
    }catch(IOException e){
      e.printStackTrace();
      return null;
    }
  }
  public AudioInputStream getAudio(String audio){
    try {
      return AudioSystem.getAudioInputStream(new File("res/KUWAGO/" + audio));
      //return AudioSystem.getAudioInputStream(new File("\\res\\KUWAGO\\"+audio));
    } catch (UnsupportedAudioFileException | IOException e) {
      e.printStackTrace();
      return null;
    }
} 
public BufferedImage getSprite(String imagen){
  try{
    return ImageIO.read(new File("res/Jugador/" + imagen));
    //return ImageIO.read(new File("\\res\\Jugador\\" + imagen));
  }catch(IOException e){
    e.printStackTrace();
    return null;
  }
  }
}
