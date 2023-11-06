package res.Rutas;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Game.GamePanel;

// Clase que contiene las rutas para un dispositivo tipo Linux
public class Linux implements Rutas{
  // Metodo que regresa la imagen de la carpeta res de acuerdo al sistema Linux
  public BufferedImage getImagen(String imagen){
    try{
      return ImageIO.read(new File("res/" + imagen));
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
