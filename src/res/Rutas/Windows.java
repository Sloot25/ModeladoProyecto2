package res.Rutas;
// Clase que contiene las rutas para un dispositivo tipo Windows
public class Windows implements Rutas { 
  // Metodo que regresa la imagen de la carpeta res de acuerdo a la cadena recibida 
  public String getImagen(String imagen){
    return "src\\res\\" + imagen;
  }
}
