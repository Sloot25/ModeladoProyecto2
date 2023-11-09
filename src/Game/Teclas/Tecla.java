package Game.Teclas;

public class Tecla  {
  private boolean pulsada = false; 
  private long ultimaPulsacion = System.nanoTime();

  // cambia el boolean a true si la tecla es pulsada 
  // asigna la el tiempo exacto en ultimaPulsacion
  public void teclaPulsada(){
    pulsada = true; 
    ultimaPulsacion = System.nanoTime();
  }

  // Cmabia el boolean a false 
  public void teclaLiberada(){
    pulsada = false;
  }
  // Regresa el valor de pulsada;
  public boolean estaPulsada(){
    return pulsada;
  }

  //Regresa el tiempo ecacto de la ultimaPulsacion
  public long obtenerUltimaPulsacion(){
    return ultimaPulsacion;
  }

}
