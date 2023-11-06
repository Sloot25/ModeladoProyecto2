package res.Rutas;

// Clase que contiene las rutas para un dispositivo tipo Linux
public class Linux implements Rutas{
  // Metodo que regresa la imagen de la carpeta res de acuerdo al sistema Linux
  public String getImagen(String imagen){
    return "res/" + imagen;
  }
}
