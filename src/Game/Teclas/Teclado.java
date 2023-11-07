package Game.Teclas;

import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener;


public class Teclado implements KeyListener{
  // Inicializamos como publicas las teclas 
  // Tenemos que revisar en el codigo si de verdad es necesario inicializar como 
  // publicas o podemos reducirlo a privadas o protegidas 
  public Tecla arriba = new Tecla();
  public Tecla abajo = new Tecla(); 
  public Tecla izquierda = new Tecla(); 
  public Tecla derecha = new Tecla(); 
  public Tecla space = new Tecla();

  public void keyPressed(KeyEvent e){
    switch (e.getKeyCode()) {
      case KeyEvent.VK_W:
        arriba.teclaPulsada();
        break;
      case KeyEvent.VK_S: 
        abajo.teclaPulsada();
        break;
      case KeyEvent.VK_D: 
        derecha.teclaPulsada();
        break;
      case KeyEvent.VK_A: 
        izquierda.teclaPulsada();
        break;
      case KeyEvent.VK_SPACE:
        space.teclaPulsada();
        break;
    }
  }

  public void keyReleased(KeyEvent e){
    switch (e.getKeyCode()) {
      case KeyEvent.VK_W:
        arriba.teclaLiberada();
        break;
      case KeyEvent.VK_S: 
        abajo.teclaLiberada();
        break;
      case KeyEvent.VK_A: 
        izquierda.teclaLiberada();
        break;
      case KeyEvent.VK_D:
        derecha.teclaLiberada();
        break;
      case KeyEvent.VK_SPACE:
        space.teclaLiberada();
        break;
    }
  }

}
