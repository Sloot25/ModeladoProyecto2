package res.Rutas;
import java.awt.image.BufferedImage;
/*Interface que nos permite el cambio para el tipo de ruta entre sistemas operativos*/
public interface Rutas {
  public BufferedImage getImagen(String imagen);
}
