package res.Rutas;
import java.awt.image.BufferedImage;
/*Interface que nos permite el cambio para el tipo de ruta entre sistemas operativos*/

import javax.sound.sampled.AudioInputStream;
public interface Rutas {
  public BufferedImage getImagen(String imagen);
  public AudioInputStream getAudio(String audio);
}
