package Entity;

import Game.GamePanel;

public class Canek extends NPC{
  public Canek(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, width, height);
  }
  public void getEntityImage(){
    // Ingresar la ruta del personaje de canek
    imagen = gp.getRutas().getImagen("");
  }
  public void interact(){
    // TODO Se debe implementar la interaccion con el jugador
    // Importante poner en el mensaje: 
    // "Eres una decepcion"
  }

}
