package res.Rutas;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Game.GamePanel;
// Clase que contiene las rutas para un dispositivo tipo Windows
public class Windows implements Rutas { 
  public Windows(){
    
  }
  // Metodo que regresa la imagen de la carpeta res de acuerdo a la cadena recibida 
  public BufferedImage getImagen(String imagen){
    try{
      return ImageIO.read(new File("src\\res\\" + imagen));
    }catch(IOException e){
      e.printStackTrace();
      return null;
    }
  }
}
