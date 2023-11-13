package Entity;

import Game.GamePanel;

public class Odin extends NPC {
  public Odin(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, width, height);
  }
  public void getEntityImage(){
    imagen = gp.getRutas().getImagen("odin.png");
  }
  public void interact(){
    // TODO Ingresa la interaccion de los personajes
  }
}
